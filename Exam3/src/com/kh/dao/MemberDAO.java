package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";
		return DriverManager.getConnection(url, id, pw);
	}
	
	public boolean login(String id, String pwd) throws Exception {
		String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PWD = ?";
		
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, pwd);
		ResultSet rs = st.executeQuery();
		return rs.next();		
	}

}
