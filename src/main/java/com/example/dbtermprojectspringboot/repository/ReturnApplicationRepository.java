package com.example.dbtermprojectspringboot.repository;

import com.example.dbtermprojectspringboot.domain.ReturnApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReturnApplicationRepository {

    @Autowired //객체를 자동으로 만들어줌
    private JdbcTemplate jdbcTemplate;

    public int save(ReturnApplication returnApplication) {
        return this.jdbcTemplate.update(
                "insert returnApplication values(?,?,?,?,?,?)",
                new Object[]{returnApplication.getIdborrowBooks()
                }
        );
    }

    public int delete(String idborrowBooks) {
        return this.jdbcTemplate.update(
                "delete from returnApplication where returnApplicationID=?",
                idborrowBooks
        );
    }

    public ReturnApplication getReturnApplicationObjById(String idborrowBooks){
        return this.jdbcTemplate.queryForObject(
                "select * from returnApplication c where c.returnApplicationID=?",
                (rs, rowNum)->
                        new ReturnApplication(rs.getString("idborrowBooks"))
                ,
                idborrowBooks
        );
    }
}
