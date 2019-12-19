package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.Book;
import com.example.dbtermprojectspringboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired //객체를 자동으로 만들어줌
    private JdbcTemplate jdbcTemplate;

    public int save(User user) {
        return this.jdbcTemplate.update(
                "insert user values(?,?,?,?,?,?)",
                new Object[]{user.getUserID(),
                        user.getUserPwd(),
                        user.getUserName(),
                        user.getUserEmail(),
                        user.getUserPhone(),
                        user.getUserType()
                }
        );
    }

    public int delete(String userID) {
        return this.jdbcTemplate.update(
                "delete from user where userID=?",
                userID
        );
    }

    public User getUserObjById(String userID){
        return this.jdbcTemplate.queryForObject(
                "select * from user where userID=?",
                (rs, rowNum)->
                    new User(rs.getString("userID"),
                            rs.getString("userPwd"),
                            rs.getString("userName"),
                            rs.getString("userEmail"),
                            rs.getString("userPhone"),
                            rs.getString("userType"))
                ,
                userID
        );
    }

    public String getTypeById(String customerId) throws Exception {
        return convertType(jdbcTemplate.queryForObject(
                "select type from customer c where c.id=?",
                new Object[]{customerId}, String.class));
    }


    public List<User> takeAllUsers() {
        return this.jdbcTemplate.query(
                "select * from user",
                (rs, rowNum) -> new User(
                        rs.getString("userID"),
                        rs.getString("userPwd"),
                        rs.getString("userName"),
                        rs.getString("userEmail"),
                        rs.getString("userPhone"),
                        rs.getString("userType"))
        );
    }

    public String convertType(String type) {
        if(type.equals("10"))
            return "std";
        if(type.equals("30"))
            return "grad";
        if(type.equals("60"))
            return "fac";
        return "admin";
    }
    public int insert(User user) throws Exception {
        return this.jdbcTemplate.update(
                "insert customer values(?, ?, ?, ?, ?, ?)",
                user.getUserID(),
                user.getUserPwd(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPhone(),
                user.getUserType()
        );
    }
    public int update(String userID, User newInfo) throws Exception {
        return this.jdbcTemplate.update(
                "update customer SET " +
                        "password=?, " +
                        "email=?, " +
                        "name=?, " +
                        "phone_number=?, " +
                        "type=? " +
                        "WHERE id=?",
                newInfo.getUserPwd(),
                newInfo.getUserName(),
                newInfo.getUserEmail(),
                newInfo.getUserPhone(),
                newInfo.getUserType(),
                userID
        );
    }
    public boolean isAdmin(String userID) throws Exception {
        String type = getTypeById(userID);
        return type.equals("admin");
    }

}
