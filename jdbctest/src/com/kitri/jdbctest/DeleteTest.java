package com.kitri.jdbctest;

import java.sql.*;

public class DeleteTest { // mnmm97의 가입일을 현재시간으로 수정

	public DeleteTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection makeConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("DB Connection Success...");

		return conn;
	}

	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		String id = "조녕";
		int cnt = 0;

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = dt.makeConnection();


			String sql = "";

			sql += "Delete jdbctest \n";
			sql += "where name LIKE '%" + id  + "%'";
					
			stmt = conn.createStatement();

			cnt = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if(stmt != null) 
				stmt.close();
				if (conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (cnt != 0)
				System.out.println("data delete success...");
			else
				System.out.println("data delete fail...");
		}

	}
}
