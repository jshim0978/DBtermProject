package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.Borrow;
import com.example.dbtermprojectspringboot.domain.Reservation;
import com.example.dbtermprojectspringboot.domain.ReservationAndBorrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 예약 추가
    public int insert(String customerId, String isbn) throws Exception {
        if (!this.isAreadyReserv(customerId, isbn).isPresent()) {
            return this.jdbcTemplate.update(
                    "insert into teamproject.reservation(customer_id,isbn,reserv_date) values(?,?,?)",
                    new Object[]{customerId, isbn, new Date(new java.util.Date().getTime())}
            );
        }
        return 0;
    }


    private Optional<Reservation> isAreadyReserv(String customerId, String isbn) {//이미 예약자가 있는지 확인
        try {
            return this.jdbcTemplate.queryForObject(
                    "SELECT * FROM teamproject.reservation " +
                            "WHERE isbn=? AND customer_id=?",
                    new Object[]{isbn, customerId},
                    (rs, rowNum) ->
                            Optional.of(Reservation.builder()
                                    .customerId(rs.getString("customer_id"))
                                    .isbn(rs.getString("isbn"))
                                    .reservDate(rs.getDate("reserv_date"))
                                    .build())
            );
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // 예약 삭제
    public int delete(Reservation reservation) throws Exception {
        return this.jdbcTemplate.update(
                "delete from teamproject.reservation where isbn=? and customer_id=?",
                reservation.getIsbn(), reservation.getCustomerId()
        );
    }

    //회원당 예약 목록 조회
    public List<ReservationAndBorrow> getReservationsByCustomerId(String customerId) throws Exception {
        return jdbcTemplate.query(
                "select * " +
                        "from (" +
                        "(" +
                        "select r.*, rank() over(partition by r.isbn order by r.reserv_date) ranking " +
                        "from teamproject.reservation as r" +
                        ")  as result" +
                        " JOIN teamproject.book as b " +
                        "on result.isbn = b.isbn ) " +
                        "where result.customer_id= ?",
                (rs, rowNum) ->
                        new ReservationAndBorrow(rs.getString("customer_id")
                                , rs.getString("isbn")
                                , rs.getDate("reserv_date")
                                , rs.getInt("is_borrow")
                                , rs.getString("title")
                                , rs.getInt("ranking"))
                , customerId
        );
    }

    public Optional<Date> getFastestDateFromBookReservation(String isbn) {
        return this.jdbcTemplate.queryForObject(
                "select min(reserv_date) " +
                        "from teamproject.reservation  " +
                        "where isbn = ?",
                new Object[]{isbn},
                (rs, rowNum) ->
                        Optional.of(rs.getDate("reserv_date"))
        );
    }


    // "isbn"을 예약한 목록 반환
    public List<Reservation> getAllReservByIsbn(Reservation reservation) throws Exception {
        return this.jdbcTemplate.query(
                "SELECT * FROM reservation WHERE isbn=?",
                (rs, rowNum) -> Reservation.builder()
                        .customerId(rs.getString("customer_id"))
                        .isbn(rs.getString("isbn"))
                        .reservDate(rs.getDate("reserv_date"))
                        .build(),
                reservation.getIsbn());
    }

    //위에서 작성한 함수를 호출해 isbn이 예약한 리스트 가져와 사이즈 리턴
    public int countReservationByIsbn(Reservation reservation) throws Exception {
        List<Reservation> listOfReservation = getAllReservByIsbn(reservation);
        return listOfReservation.size();
    }

    public Date availableDate(Reservation reservation) throws Exception {
        Optional<Borrow> temp = jdbcTemplate.queryForObject(
                "select * from teamproject.borrow where isbn=? AND is_return=0",//아직 반납되지 않은 해당 isbn이라면 return_date가져오기
                new Object[]{reservation.getIsbn()},
                (rs, rowNum) ->
                        Optional.of(Borrow.builder()
                                .borrowNumber(rs.getInt("borrow_number"))
                                .isbn(rs.getString("isbn"))
                                .title(rs.getString("title"))
                                .customerId(rs.getString("customer_id"))
                                .borrowDate(rs.getDate("borrow_date"))
                                .returnDate(rs.getDate("return_date"))
                                .isReturn(rs.getInt("is_return"))
                                .build())
        );
        Borrow resulBorrow = temp.orElse(null);
        Date reuturnDate = resulBorrow.getReturnDate();//해당 isbn의 return_date가져오기
        return calculateDate(reuturnDate, reservation);
    }

    private Date calculateDate(Date inputDate, Reservation reservation) throws Exception {
        String type;
        int plusDate = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDate);

        List<Map<String, Object>> countPerType =
                this.jdbcTemplate.queryForList(
                        "SELECT c.type,count(*) as count " +
                                "FROM teamproject.reservation r " +
                                "INNER JOIN teamproject.customer c " +
                                "ON r.customer_id=c.id and r.isbn=? " +
                                "GROUP BY c.type"
                        , reservation.getIsbn());//타입당 인원 수 반환

        for (int i = 0; i < countPerType.size(); i++) {//리스트 사이즈만큼 반복
            type = (String) countPerType.get(i).get("type");
            if (type.equals("30")) {//타입마다 다른 일수 합치기
                plusDate += 30 * (Long) countPerType.get(i).get("count");
            } else if (type.equals("60")) {
                plusDate += 60 * (Long) countPerType.get(i).get("count");
            } else {
                plusDate += 10 * (Long) countPerType.get(i).get("count");
            }
        }
        cal.add(cal.DATE, plusDate);
        return new Date(cal.getTimeInMillis());
    }

}
