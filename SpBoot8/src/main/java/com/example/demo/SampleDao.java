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
		String sql = "insert into texttable(text) values('inserted data-spboot8')"; 
    	jdbcTemplate.update(sql);
    	System.out.println("更新中");
        return;
    }
    
    // ②検索処理
    public List select(){
    	String sql = "select text from texttable";
        List ret = jdbcTemplate.queryForList(sql, String.class);
        return ret;
    }
    //
    public List joinSelect(){
    	String sql = "select * from country natural join customer";
        List ret = jdbcTemplate.queryForList(sql, String.class);
        return ret;
    }
}
