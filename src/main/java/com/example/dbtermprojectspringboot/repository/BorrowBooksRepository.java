package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.Book;
import com.example.dbtermprojectspringboot.domain.BorrowBooks;
import com.example.dbtermprojectspringboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class BorrowBooksRepository {
    static int bbid=0;

    @Autowired //객체를 자동으로 만들어줌
    private JdbcTemplate jdbcTemplate;

    public int save(BorrowBooks borrowBooks) {
        return this.jdbcTemplate.update(
                "insert borrowbooks values(?,?,?,?,?,?)",
                new Object[]{borrowBooks.getIdborrowBooks(),
                        borrowBooks.getIdBooks(),
                        borrowBooks.getUserID(),
                        borrowBooks.getBorrowedDate(),
                        borrowBooks.getExpectedReturn(),
                        borrowBooks.getIsReturned()
                }
        );
    }

    public int delete(String idborrowBooks) {
        return this.jdbcTemplate.update(
                "delete from borrowbooks where idborrowBooks=?",
                idborrowBooks
        );
    }

    public BorrowBooks getUserObjById(String idborrowBooks){
        return this.jdbcTemplate.queryForObject(
                "select * from borrowbooks c where c.idborrowBooks=?",
                (rs, rowNum)->
                        new BorrowBooks(rs.getInt("idborrowBooks"),
                                rs.getInt("idBooks"),
                                rs.getString("userID"),
                                rs.getString("borrowedDate"),
                                rs.getString("expectedReturn"),
                                rs.getString("isReturned"))
                ,
                idborrowBooks
        );
    }

    public List<BorrowBooks> takeAllReturnBooks() {
        return this.jdbcTemplate.query(
                //TODO: join
//                "select bb.idborrowBooks, bb.idBooks, bb.userID, bb.borrowedDate, bb.expectedReturn, bb.isReturned" +
//                        "from borrowbooks as bb" +
//                        "join returnapplication as ra" +
//                        "where bb.idborrowBooks = ra.idborrowBooks",
                "select * from borrowbooks",
                (rs, rowNum) -> new BorrowBooks(
                        rs.getInt("borrowbooks.idborrowBooks"),
                        rs.getInt("borrowbooks.idBooks"),
                        rs.getString("borrowbooks.userID"),
                        rs.getString("borrowbooks.borrowedDate"),
                        rs.getString("borrowbooks.expectedReturn"),
                        rs.getString("borrowbooks.isReturned"))
        );
    }

    public int borrowBook(Book book, String userID, String userType) {
        int num=0;
        LocalDate date = LocalDate.now();
        String borrowedDate = String.valueOf(date.getYear()) + String.valueOf(date.getMonthValue()) + String.valueOf(date.getDayOfMonth());
        String returnDate = date.plusDays(Integer.parseInt(userType)).toString();
        if((num=this.jdbcTemplate.update("select numberOfBooks from booklist where idBooks=?",
                book.getIdBooks())) == 0)
            return 0;

        return this.jdbcTemplate.update(
                "update booklist" +
                "set numberOfBooks=?" +
                "where idBooks=?",
                (num-1),
                book.getIdBooks()
                ) & this.jdbcTemplate.update(
                        "insert borrowbooks values(?,?,?,?,?,?)",
                new Object[]{++bbid,
                        book.getIdBooks(),
                        userID,
                        borrowedDate,
                        returnDate,
                        0
                }
        );
    }
}
