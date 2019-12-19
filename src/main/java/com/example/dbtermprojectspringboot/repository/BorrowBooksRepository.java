package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.BorrowBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BorrowBooksRepository {

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
}
