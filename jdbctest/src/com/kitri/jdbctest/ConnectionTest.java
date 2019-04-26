package com.kitri.jdbctest;

import java.sql.*;

public class ConnectionTest { // [2] DB연결

	public ConnectionTest() {
		try { // Driver 읽기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void dbConnect() { // 나중가서는 login 정보를 properties 파일로 따로 빼는게 더 good
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orl", "kitri", "kitri"); //java는 무조건 thin씀
			System.out.println("DB Connction Success...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	 ConnectionTest ct = new ConnectionTest();
	 ct.dbConnect();
	}

}
