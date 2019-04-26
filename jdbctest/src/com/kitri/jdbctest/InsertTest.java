package com.kitri.jdbctest;

import java.sql.*;

public class InsertTest {

	public InsertTest() {
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
		DeleteTest it = new DeleteTest();
		String name = "고세라";
		String id = "인천내기니";
		int cnt = 0;

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = it.makeConnection();

//		insert into jdbctest (no, name, id, joindate)
//		values (jdbctest_no_seq.nextval, '안효인', 'java2', sysdate);

			// [3]
			String sql = ""; // SQL 실행준비

			sql += "insert into jdbctest (no, name, id, joindate) \n";
			sql += "values (jdbctest_no_seq.nextval, '" + name + "', '" + id + "', sysdate)"; // java에서는 세미콜론 찍으면 안됨
			stmt = conn.createStatement();

			// [4]
			cnt = stmt.executeUpdate(sql); // 갯수(insert 하나하니까 1)
			
			// 여기서 접속종료하면 X
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 에러가 나든 안나든 실행됨
			try { // 역순으로 닫아라
				if(stmt != null) // stmt가 null되면 nullPointerException 뜸
				stmt.close();
				if (conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (cnt != 0)
				System.out.println("data insert success...");
			else
				System.out.println("data insert fail...");
		}

	}
}
