package com.kitri.jdbctest;

import java.sql.*;

public class UpdateTest { // mnmm97의 가입일을 현재시간으로 수정

	public UpdateTest() {
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
		InsertTest it = new InsertTest();
		String id = "mnmm97";
		int cnt = 0;

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = it.makeConnection();


			String sql = "";

			sql += "update jdbctest set joindate = sysdate \n";
			sql += "where id = '" + id  + "'";
					
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
				System.out.println(cnt + "개 data update success...");
			else
				System.out.println(cnt + "개 data update success...");
		}

	}
}
