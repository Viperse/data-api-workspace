package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public boolean isEmailExist(String email) throws Exception {
		String sql = "SELECT EMAIL FROM MEMBERS WHERE EMAIL = ?";
		Connection conn = getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, email);
		ResultSet rs = pstat.executeQuery();
		return rs.next();
	}

}
