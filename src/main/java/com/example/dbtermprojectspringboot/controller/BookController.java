package com.example.dbtermprojectspringboot.controller;

import com.example.dbtermprojectspringboot.domain.Book;
import com.example.dbtermprojectspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/allBookListPage")
    public String bookListPage(Model model) {
        try {
            List<Book> result = this.bookRepository.takeAllBooks();
            model.addAttribute("books", result);
        } catch (Exception e) {
            model.addAttribute("books", new ArrayList<>());
        }
        return "bookList-page";
    }
    @GetMapping("/adminBookListPage")
    public String adminBookListPage(Model model) {
        try {
            List<Book> result = this.bookRepository.takeAllBooks();
            model.addAttribute("books", result);
        } catch (Exception e) {
            model.addAttribute("books", new ArrayList<>());
        }
        return "admin-bookList-page";
    }
    @GetMapping("/bookSearchPage")
    public String bookSearchPage(Model model) {

        return "book-search-page";
    }


    @GetMapping("/bookSearchResult")
    public String bookSearchResult(@RequestParam("type") String type
            , @RequestParam("data") String data
            , Model model, HttpSession httpSession) {
        Object id = httpSession.getAttribute("id");

        if (id == null) {
            return "redirect:../user/error-page";
        }

        List<Book> books;
        if (type.equals("idBooks")) {
            int intData = Integer.parseInt(data);
            Book resultBook = this.bookRepository.searchBookByIsbn(intData);
            books = new ArrayList<>();
            if (resultBook != null) {
                books.add(resultBook);
            }
        } else {
            books = this.bookRepository.searchBookByTitle(data);
        }
        model.addAttribute("books", books);

        return "book-search-result-page";
    }

    @GetMapping("/addBooks") // db접근 전용 post/get
    public String addBooks(
            @RequestParam("idBooks") int idBooks,
            @RequestParam("bookAuthor") String bookAuthor,
            @RequestParam("bookName") String bookName,
            @RequestParam("bookPublisher") String bookPublisher) {
        try {
            if (this.bookRepository.save(new Books(idBooks, bookAuthor, bookName, bookPublisher)) != 0) {
                return "redirect:/user/bookList"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/user/errorPage"; //여기 페이지로 이동

        }
        return "redirect:/user/errorPage"; //여기 페이지로 이동
    }
}
