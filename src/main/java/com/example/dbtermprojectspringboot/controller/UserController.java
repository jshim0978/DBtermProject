package com.example.dbtermprojectspringboot.controller;

import com.example.dbtermprojectspringboot.domain.User;
import com.example.dbtermprojectspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/main")
    public String main() {
        return "user-main-page";
    }

    @GetMapping("/errorPage")
    public String error() {
        return "error/error-page";
    }

    @GetMapping("/register")
    public String userRegisterPage() {
        return "user-register-page"; //jsp  이름으로만 하기
    } // web 띄우는 거 전용


    @GetMapping("/editProfile")
    public String userEditProfilePage() {
        return "editProfile"; //jsp  이름으로만 하기
    } // web 띄우는 거 전용


    @GetMapping("/loginPage")
    public String loginPage() {
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
                        HttpSession httpSession) {
        httpSession.setAttribute("id", userID); //session 생성
        try {
            if (this.userRepository.getUserObjById(userID) != null) {
                return "redirect:/user/main"; // 여기 페이지로 이동
            }
        } catch (Exception e) {
            return "redirect:/user/errorPage"; //여기 페이지로 이동
        }
        return "redirect:/user/errorPage"; //여기 페이지로 이동
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
}
//@GetMapping("/register")
//public String register(Model model) {
//    model.addAttribute("user", new User());
//
//    return "user-register-page";
//}
//
//}

