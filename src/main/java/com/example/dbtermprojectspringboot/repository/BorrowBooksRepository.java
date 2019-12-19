package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.BorrowBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
                        new BorrowBooks(rs.getString("idborrowBooks"),
                                rs.getString("idBooks"),
                                rs.getString("userID"),
                                rs.getString("borrowedDate"),
                                rs.getString("expectedReturn"),
                                rs.getString("isReturned"))
                ,
                idborrowBooks
        );
    }
}
