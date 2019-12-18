package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired //객체를 자동으로 만들어줌
    private JdbcTemplate jdbcTemplate;

    public int save(User user) {
        return this.jdbcTemplate.update(
                "insert user values(?,?,?,?,?,?)",
                new Object[]{user.getUserId(),
                        user.getUserPwd(),
                        user.getUserName(),
                        user.getUserEmail(),
                        user.getUserPhone(),
                        user.getUserType()
                }
        );
    }
}
