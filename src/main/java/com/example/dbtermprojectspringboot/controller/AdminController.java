package com.example.dbtermprojectspringboot.controller;

import com.example.dbtermprojectspringboot.domain.Book;
import com.example.dbtermprojectspringboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication(scanBasePackages = {"com.example.dbtermprojectspringboot.repository.AdminRepository"})

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/main")
    public String main() {
        return "hello";
    }

    @GetMapping("/errorPage")
    public String error() {
        return "error/error-page";
    }

    @GetMapping("/adminPage")
    public String adminMainPage() {
        return "admin-main-page";
    }

    @GetMapping("/enrollPage")
    public String enrollPage() {
        return "admin-enroll-page";
    }

    @GetMapping("/enroll")
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
    public String modifyPage() {
        return "admin-modify-page";
    }

    @GetMapping("/modify")
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

    @GetMapping("/remove")
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
}

