package com.example.dbtermprojectspringboot.controller;

import com.example.dbtermprojectspringboot.domain.Book;
import com.example.dbtermprojectspringboot.domain.BorrowBooks;
import com.example.dbtermprojectspringboot.repository.BookRepository;
import com.example.dbtermprojectspringboot.repository.BorrowBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BorrowBooksController {

    @Autowired
    private BorrowBooksRepository borrowBooksRepository;

    @GetMapping("/allReturnListPage")
    public String bookReturnPage(Model model) {
        try {
            List<BorrowBooks> result = this.borrowBooksRepository.takeAllReturnBooks();
            model.addAttribute("borrowbooks", result);
        } catch (Exception e) {
            model.addAttribute("borrowbooks", new ArrayList<>());
        }

        return "return-bookList-page";
    }

//    @GetMapping("/addBooks") // db접근 전용 post/get
//    public String addBooks(
//            @RequestParam("idBooks") int idBooks,
//            @RequestParam("bookAuthor") String bookAuthor,
//            @RequestParam("bookName") String bookName,
//            @RequestParam("bookPublisher") String bookPublisher) {
//        try {
////            if (this.save(new Books(idBooks, bookAuthor, bookName, bookPublisher)) != 0) {
////                return "redirect:/user/bookList"; // 여기 페이지로 이동
////            }
//        } catch (Exception e) {
//            return "redirect:/user/errorPage"; //여기 페이지로 이동
//
//        }
//        return "redirect:/user/errorPage"; //여기 페이지로 이동
//    }
}
