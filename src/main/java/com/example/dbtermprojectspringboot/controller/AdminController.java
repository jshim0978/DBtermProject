package com.example.dbtermprojectspringboot.controller;

import com.example.dbtermprojectspringboot.domain.Book;
import com.example.dbtermprojectspringboot.repository.AdminRepository;
import com.example.dbtermprojectspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/errorPage")
    public String error() {
        return "error/error-page";
    }


    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/main")
    public String bookListPage(Model model) {
        try {
            List<Book> result = this.bookRepository.takeAllBooks();
            model.addAttribute("books", result);
        } catch (Exception e) {
            model.addAttribute("books", new ArrayList<>());
        }

        return "admin-main-page";
    }

//    @GetMapping("/main")
//    public String adminMainPage() {
//        return "admin-main-page";
//    }

    @GetMapping("/enrollPage")
    public String enrollPage() {
        return "admin-enroll-page";
    }

    @GetMapping("/enrollBook")
    public String enrollBook(@RequestParam("idBooks") int idBooks,
                             @RequestParam("bookAuthor") String bookAuthor,
                             @RequestParam("bookName") String bookName,
                             @RequestParam("bookPublisher") String bookPublisher) {
        try {
            Book book = new Book(idBooks, bookAuthor, bookName, bookPublisher);
            if (this.adminRepository.enrollBook(book) != 0) {
                return "redirect:/admin/main"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/admin/errorPage"; //여기 페이지로 이동
        }
        return "redirect:/admin/errorPage"; //여기 페이지로 이동
    }

    //modify book info
    @GetMapping("/modifyPage")
    public String modifyPage(@RequestParam("idBooks") int idBooks) {
        return "admin-modify-page";
    }

    @GetMapping("/modifyBook")
    public String modifyBook(@RequestParam("idBooks") int idBooks,
                             @RequestParam("bookAuthor") String bookAuthor,
                             @RequestParam("bookName") String bookName,
                             @RequestParam("bookPublisher") String bookPublisher) {
        try {
            Book book = new Book(idBooks, bookAuthor, bookName, bookPublisher);
            if (this.adminRepository.modifyBook(book) != 0) {
                return "redirect:/admin/main"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/admin/errorPage"; //여기 페이지로 이동
        }
        return "redirect:/admin/errorPage"; //여기 페이지로 이동
    }

    //remove book
    @GetMapping("/removePage")
    public String removePage() {
        return "admin-remove-page";
    }

    @GetMapping("/removeBook")
    public String removeBook(@RequestParam("idBooks") int idBooks) {
        try {
            if (this.adminRepository.removeBook(idBooks) != 0) {
                return "redirect:/admin/main"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/admin/errorPage"; //여기 페이지로 이동
        }
        return "redirect:/admin/errorPage"; //여기 페이지로 이동
    }

    //remove book
    @GetMapping("/returnPage")
    public String returnPage() {
        return "admin-return-page";
    }

    @GetMapping("/return")
    public String approveReturn(@RequestParam("idborrowBooks") int idborrowBooks) {
        try {
            if (this.adminRepository.approveReturn(idborrowBooks) != 0) {
                return "redirect:/admin/main"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/admin/errorPage"; //여기 페이지로 이동
        }
        return "redirect:/admin/errorPage"; //여기 페이지로 이동
    }
}

