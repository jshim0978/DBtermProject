package com.example.dbtermprojectspringboot.service;



import com.example.dbtermprojectspringboot.domain.Reservation;
import com.example.dbtermprojectspringboot.repository.ReservationRepository;
import com.example.dbtermprojectspringboot.domain.ReservationAndBorrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    //예약 추가

    /**
     * @param customerId : customer_id
     * @param isbn       : isbn
     * @return
     */
    public int insertReservation(String customerId, String isbn) {
        try {
            return this.reservationRepository.insert(customerId, isbn);
        } catch (Exception e) {
            return 0;
        }
    }

    //예약 취소

    /**
     * @param reservation : reservation.isbn
     * @return
     */
    public int cancleReservation(Reservation reservation) {
        try {
            return this.reservationRepository.delete(reservation);
        } catch (Exception e) {
            return 0;
        }
    }

    //각 회원당 예약목록 조회(book이랑 reservation join해서 가져온 결과)
    /**
     * @param customerId : user_id
     * @return: customer_id,isbn,reserv_date,is_borrow,title
     */
    public List<ReservationAndBorrow> getReservationsByCustomerId(String customerId) {
        try{
            return this.reservationRepository.getReservationsByCustomerId(customerId);
        } catch(Exception e) {
            return new ArrayList<>();
        }
    }

    //주어진 isbn을 예약한 인원 수

    /**
     * @param reservation : reservation.isbn
     * @return
     */
    public int countReservationByIsbn(Reservation reservation) {
        try {
            return this.reservationRepository.countReservationByIsbn(reservation);
        } catch (Exception e) {
            return 0;
        }
    }

    //주어진 isbn이 예약된 목록들 반환

    /**
     * @param reservation : reservation.isbn
     * @return
     */
    public List<Reservation> whoReservedPerIsbn(Reservation reservation) {
        try {
            return this.reservationRepository.getAllReservByIsbn(reservation);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * @param reservation : reservation.isbn
     * @return : 대출 가능한 날짜(YYYY-MM-DD)
     */
    public Date possibleBorrowDate(Reservation reservation) {
        try {
            return this.reservationRepository.availableDate(reservation);
        } catch (Exception e) {
            return null;
        }
    }

    //이미 예약되어 있는지 확인

//    /**
//     * @param reservation:reservation.isbn
//     * @return :예약자가 있으면 1,없으면 0 리턴
//     */
//    public int isAreadyReserv(Reservation reservation) {
//        try {
//            return this.reservationDao.isAreadyReserv(reservation);
//        } catch (Exception e) {
//            return 0;
//        }
//    }

}
