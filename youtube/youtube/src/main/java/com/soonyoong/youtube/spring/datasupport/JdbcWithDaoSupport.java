package com.soonyoong.youtube.spring.datasupport;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

//our own class just need to extend from Spring's DAO support class
public class JdbcWithDaoSupport extends JdbcDaoSupport {
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) from CIRCLE";
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}
}
