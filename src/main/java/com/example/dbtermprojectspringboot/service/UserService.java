package com.example.dbtermprojectspringboot.service;


import com.example.dbtermprojectspringboot.domain.User;
import com.example.dbtermprojectspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private UserRepository userRepository;

    // 회원 가입 : insert Customer

    public int insertService(User user) {
        try {
            return this.userRepository.insert(user);
        } catch (Exception e) {
            return 0;
        }
    }

    public int deleteService(String userID) {
        try {
            return this.userRepository.delete(userID);
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateService(String userID, User newInfo) {
        if (userID == null) {
            return 0;
        }
        try {
            return this.userRepository.update(userID, newInfo);
        } catch (Exception e) {
            return 0;
        }
    }


    public User getCustomerByIdService(String userID) {
        try {
            return this.userRepository.getUserObjById(userID);
        } catch (Exception e) {
            return null;
        }
    }


    public List<User> getAllCustomers() {
        try {
            return userRepository.takeAllUsers();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    public boolean isAdmin(String userID) {
        try {
            return userRepository.isAdmin(userID);
        } catch (Exception e) {
            return false;
        }
    }
}
