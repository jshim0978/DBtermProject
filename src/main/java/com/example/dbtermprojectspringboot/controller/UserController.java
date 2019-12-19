package com.example.dbtermprojectspringboot.controller;

import com.example.dbtermprojectspringboot.domain.*;

import com.example.dbtermprojectspringboot.service.*;
import com.example.dbtermprojectspringboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/main")
    public String main(Model model, HttpServletRequest request) {
        try {
            String userID = (String)request.getAttribute("userID");
            List<Book> result = this.bookRepository.takeUserBooks(userID);
            model.addAttribute("books", result);
        } catch (Exception e) {
            model.addAttribute("books", new ArrayList<>());
        }

        return "user-main-page";
    }

    @GetMapping("/errorPage")
    public String error() {
        return "error/error-page";
    }

    @GetMapping("/register")
    public String userRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "user-register-page"; //jsp  이름으로만 하기
    } // web 띄우는 거 전용


    @GetMapping("/editProfile")
    public String userEditProfilePage() {
        return "editProfile"; //jsp  이름으로만 하기
    } // web 띄우는 거 전용


    @GetMapping("/loginPage")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login-page";
    }

    @GetMapping("/logoutPage")
    public String logoutPage() {
        return "logout-page";
    }


    //login page
    @GetMapping("/login")
    public String login(@RequestParam("userID") String userID,
                        @RequestParam("userPwd") String userPwd,
                        HttpSession httpSession, HttpServletRequest request) {
        httpSession.setAttribute("id", userID); //session 생성
        try {
            if (this.userRepository.getUserObjById(userID) != null) {
                request.setAttribute("userID", userID);
                return "redirect:/user/main"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/user/errorPage"; //여기 페이지로 이동
        }
        return "redirect:/user/errorPage"; //여기 페이지로 이동
    }
    @GetMapping("/loginCheck")
    public String loginCheck(@ModelAttribute("user") User user,
                             HttpSession httpSession) {
        User databaseCustomer = this.userService.getCustomerByIdService(user.getUserID());
        if (databaseCustomer == null) {
            return "redirect:/user/login";//입력된 ID가 존재하지 않을 경우
        }
        if (databaseCustomer.getUserID().equals(user.getUserID()) &&
                databaseCustomer.getUserPwd().equals(user.getUserPwd())) {
            httpSession.setAttribute("id", user.getUserID());
            if (user.getUserID().equals("admin")) {
                return "redirect:/admin/main"; //admin 계정
            }

            return "redirect:/user/main"; // 성공시
        }
        return "redirect:/user/loginPage"; // 실패
    }

    //
//    @RequestParam("userID") String userID,
//    @RequestParam("userPwd") String userPwd,
//    @RequestParam("userName") String userName,
//    @RequestParam("userEmail") String userEmail,
//    @RequestParam("userPhone") String userPhone,
//    @RequestParam("userType") String userType
    @GetMapping("/registerUser")
    public String registerUser(
            @RequestParam("userID") String userID,
            @RequestParam("userPwd") String userPwd,
            @RequestParam("userName") String userName,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userPhone") String userPhone,
            @RequestParam("userType") String userType) {
        try {
            if (this.userRepository.save(new User(userID, userPwd, userName, userEmail, userPhone, userType)) != 0) {
                return "redirect:/user/loginPage"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/user/errorPage"; //여기 페이지로 이동

        }
        return "user-register-page"; //여기 페이지로 이동
    }

    @GetMapping("/removeUser")
    public String removeUser(@RequestParam("userID") String userID) {
        try {
            if (this.adminRepository.removeUser(userID) != 0) {
                return "redirect:/user/register"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/admin/errorPage"; //여기 페이지로 이동
        }
        return "redirect:/admin/errorPage"; //여기 페이지로 이동
    }
    @GetMapping("/changeUserData")
    public String changeUserData(    @RequestParam("userID") String userID,
                                     @RequestParam("userPwd") String userPwd,
                                     @RequestParam("userName") String userName,
                                     @RequestParam("userEmail") String userEmail,
                                     @RequestParam("userPhone") String userPhone,
                                     @RequestParam("userType") String userType) {
        try {
            if (this.userRepository.save(new User(userID, userPwd, userName, userEmail, userPhone, userType)) != 0) {
                return "redirect:/user/main"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/user/erqrorPage"; //여기 페이지로 이동

        }
        return "editProfile"; //여기 페이지로 이동
    }

}
//@GetMapping("/register")
//public String register(Model model) {
//    model.addAttribute("user", new User());
//
//    return "user-register-page";
//}
//
//}

