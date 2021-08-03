package com.soonyoong.youtube.spring.datasupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
@Component
public class SpringJDBCDaoImpl {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private SimpleJdbcTemplate simpleJdbcTemplate;		deprecated
	
	public Circle getCircle(int circleId) {
		Connection connection = null;
		try {
			
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from circle where id = ?");
			preparedStatement.setInt(1, circleId);

			Circle circle = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				circle = new Circle(circleId, resultSet.getString("name"));
			}
			resultSet.close();
			preparedStatement.close();
			return circle;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				connection.close();		//close connection in finally block, because must close the connection even if error happen
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//to make use of JdbcTemplete, much simple compare to before, no need preparedStatement, loop through the resultSet
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) from CIRCLE";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public String getCircleName(int circleId) {
		String sql = "SELECT name from CIRCLE where ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}
	
	public Circle getCircleForId(int circleId) {
		String sql = "SELECT * from CIRCLE where ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles() {
		String sql = "SELECT * from CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO Circle(ID, NAME) values (?, ?)";
		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}
	
	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	//using namedParameterJdbcTemplate
	public void insertCircleByNamedParameter(Circle circle) {
		String sql = "INSERT INTO Circle(ID, NAME) values (:id, :name)";
		//to map the value to named parameter
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
	public DataSource getDatasource() {
		return dataSource;
	}
	@Autowired
	public void setDatasource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);	//the datasource actually is needed only by JDBC Template
		//normally just one of the jdbcTemplate enough, having two here is for testing and learning purpose
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);   
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static final class CircleMapper implements RowMapper<Circle> {
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
	}
}
