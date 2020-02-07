package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionHandler {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test";
		String uname = "root";
		String pass = "root";
		String query1 = "select id,ename,team from demo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, uname, pass);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query1);

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3));
			}
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}
}
