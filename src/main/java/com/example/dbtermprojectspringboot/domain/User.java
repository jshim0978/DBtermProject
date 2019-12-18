package com.example.dbtermprojectspringboot.domain;

public class User {
    private String userID;
    private String userPwd;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userType;

    public User() {
    }

    public User(String userID, String userPwd, String userName, String userEmail, String userPhone, String userType) {
        this.userID = userID;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
