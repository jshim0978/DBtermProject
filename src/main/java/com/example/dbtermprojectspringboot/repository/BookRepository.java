package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private BookRepository  bookRepository;


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

    public Book getBookObjById(int idBooks) {
        return this.jdbcTemplate.queryForObject(
                "select * from books c where c.idBooks = ? ",
                (rs, rowNum) ->
                        new Book(rs.getInt("idBooks"),
                                rs.getString("bookAuthor"),
                                rs.getString("bookName"),
                                rs.getString("bookPublisher")
                        )
        );
    }
    public int insertReservation(String customerId, String isbn) {
//        try {
////            return this.reservationDao.insert(customerId, isbn);
////        } catch (Exception e) {
////            return 0;
////        }
        return 0;
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

    public List<Book> takeUserBooks(String userID)
    {
        //todo
        return this.jdbcTemplate.query(
                "select * from books where books.idBooks = ?",
                (rs, rowNum) -> new Book(
                        rs.getInt("idBooks"),
                        rs.getString("bookAuthor"),
                        rs.getString("bookName"),
                        rs.getString("bookPublisher"))
        );
    }


    public Optional<Book> searchByIsbn(int idBooks) throws Exception{
        return this.jdbcTemplate.queryForObject(
                "select * from dbterm.books where idBooks=?",
                new Object[]{idBooks},
                (rs, rowNum) ->
                        Optional.of(Book.builder()
                                .idBooks(rs.getInt("idBooks"))
                                .bookAuthor(rs.getString("bookAuthor"))
                                .bookName(rs.getString("bookName"))
                                .bookPublisher(rs.getString("bookPublisher"))

                                .build())
        );
    }



    public List<Book> searchByTitle(String bookName) throws Exception{

        return this.jdbcTemplate.query(
                "select * from dbterm.books where bookName=" + "'" + bookName + "'",//sql문
                (rs, rowNum) ->
                        Book.builder()
                                .idBooks(rs.getInt("idBooks"))
                                .bookName(rs.getString("bookName"))
                                .bookAuthor(rs.getString("bookAuthor"))
                                .bookPublisher(rs.getString("bookPublisher"))

                                .build()
        );
    }

    public int setBookToBorrowed(String isbn) throws Exception{
        return this.jdbcTemplate.update(
                "update teamproject.book set is_borrow=1 where is_borrow=0 and book.isbn=?;",
                isbn
        );
    }
}
