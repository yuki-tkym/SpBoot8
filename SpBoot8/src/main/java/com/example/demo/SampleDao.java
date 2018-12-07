package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SampleDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
    
    // ①更新処理
	@Transactional(isolation=Isolation.READ_COMMITTED,
            propagation=Propagation.REQUIRED)
    public void update(){
    	jdbcTemplate.update("insert into texttable(text) values('inserted data-spboot8')");
    	System.out.println("更新中");
        return;
    }
    
    // ②検索処理
    public List select(){
        List ret = jdbcTemplate.queryForList("select text from texttable", String.class);
        return ret;
    }
}
