package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int enrollBook(Book book) {
        return this.jdbcTemplate.update(
                "insert books values(?,?,?,?)",
                new Object[]{book.getIdBooks(),
                        book.getBookAuthor(),
                        book.getBookName(),
                        book.getBookPublisher()
                }
        );
    }

    public int modifyBook(Book book) {
        return this.jdbcTemplate.update(
                "update books" +
                        "set bookAuthor=?, bookName=?, bookPublisher=?" +
                        "where idBooks=?",
                book.getBookAuthor(),
                book.getBookName(),
                book.getBookPublisher(),
                book.getIdBooks()
        );
    }

    public int removeBook(int idBooks) {
        return this.jdbcTemplate.update(
                "delete from books where idBooks=?",
                idBooks
        );
    }

    public int approveReturn(int idborrowBooks) {
        return this.jdbcTemplate.update(
                "delete from returnapplication where idborrowBooks=?",
                idborrowBooks
        ) & this.jdbcTemplate.update(
                "update borrowbooks set isReturned=1"
        );
    }
}
