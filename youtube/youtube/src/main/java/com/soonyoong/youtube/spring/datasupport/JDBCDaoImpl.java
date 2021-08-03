package com.soonyoong.youtube.spring.datasupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDaoImpl {

	public Circle getCircle(int circleId) {
		Connection connection = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver).newInstance(); // create instance from driver class
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringDataSupport", "root", "123456");
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
}
