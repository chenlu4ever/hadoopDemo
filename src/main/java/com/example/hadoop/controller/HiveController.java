package com.example.hadoop.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hive")
public class HiveController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/queryStudent")
    public String queryStudent(){
        List<Map<String, Object>> lists = jdbcTemplate.queryForList("select * from bustest.student_tbl");
        System.out.println("ID" + "\t" + "姓名" + "\t" + "性别" + "\t" + "年级" );
        System.out.println(JSONObject.toJSONString(lists));
        return JSONObject.toJSONString(lists);
    }

    @GetMapping("/insertBook")
    public String insertStudent(){
        Object args[] = new Object[]{"中小学生六年级白皮书"};
        int i = jdbcTemplate.update("insert into table bustest.book_tbl values (?)",args);
        return "success!";
    }
}
