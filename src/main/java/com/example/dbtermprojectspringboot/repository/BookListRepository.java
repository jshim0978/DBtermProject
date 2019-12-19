package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookListRepository {

    @Autowired //객체를 자동으로 만들어줌
    private JdbcTemplate jdbcTemplate;

    public int save(BookList bookList) {
        return this.jdbcTemplate.update(
                "insert bookList values(?,?)",
                new Object[]{bookList.getIdBooks(),
                        bookList.getNumberOfBooks()
                }
        );
    }

    public int delete(String idBooks) {
        return this.jdbcTemplate.update(
                "delete from bookList where idBooks=?",
                idBooks
        );
    }

    public BookList getBookListObjById(String idBooks){
        return this.jdbcTemplate.queryForObject(
                "select * from bookList c where c.idBooks=?",
                (rs, rowNum)->
                        new BookList(rs.getString("idBooks"),
                                rs.getString("numberOfBooks"))
                ,
                idBooks
        );
    }
}
