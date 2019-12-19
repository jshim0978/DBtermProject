package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private BookRepository bookRep;

    public int save(Book book) {
        return this.jdbcTemplate.update(
                "insert book values(?,?,?,?,?,?)",
                new Object[]{book.getIdBooks(),
                        book.getBookAuthor(),
                        book.getBookName(),
                        book.getBookPublisher()
                }
        );
    }

    public int delete(int idBooks) {
        return this.jdbcTemplate.update(
                "delete from books where idBooks = ?",
                idBooks
        );
    }

    public Book getBookObjById(String idBooks) {
        return this.jdbcTemplate.queryForObject(
                "select* from books c where c.idBooks = ? ",
                (rs, rowNum) ->
                        new Book(rs.getInt("idBooks"),
                                rs.getString("bookAuthor"),
                                rs.getString("bookName"),
                                rs.getString("bookPublisher")
                        )
        );
    }

    public List<Book> takeAllBooks() {
        return this.jdbcTemplate.query(
                "select * from books",
                (rs, rowNum) -> new Book(
                        rs.getInt("idBooks"),
                        rs.getString("bookAuthor"),
                        rs.getString("bookName"),
                        rs.getString("bookPublisher"))
        );
    }
    public Book searchBookByIsbn(int isbn) {
        Book book;
        try {
            book = this.bookRep.searchByIsbn(isbn);
        } catch (Exception e) {
            book = null;
        }

        return null;
    }
    public Book searchByIsbn(int idBooks) throws Exception{
        return this.jdbcTemplate.queryForObject(
                "select * from books where idBooks=?",
                (rs, rowNum) ->
                        new Book(
                                rs.getInt("idBooks"),
                                rs.getString("bookAuthor"),
                                rs.getString("bookName"),
                                rs.getString("bookPublisher"))
                        );

    }
    public List<Book> searchBookByTitle(String bookName) {
        try{
            return this.bookRep.searchByTitle(bookName);
        } catch(Exception e){
            return new ArrayList<Book>();
        }
    }
    public List<Book> searchByTitle(String bookName) throws Exception{
        return this.jdbcTemplate.query(
                "select * from books where bookName=" + "'" + bookName + "'",//sql문
                (rs, rowNum) ->
                        new Book(
                                rs.getInt("idBooks"),
                                rs.getString("bookAuthor"),
                                rs.getString("bookName"),
                                rs.getString("bookPublisher"))
        );
    }
}
