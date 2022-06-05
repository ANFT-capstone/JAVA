package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataVo.UserInfoVo;

public class DatabaseManager {
	public UserInfoVo user;
	
	public List<UserInfoVo> getAllUser() {
		List<UserInfoVo> userList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetAllUserSql();
		
	    try {
	            // SQL문을 실행할 수 있는 객체 생성 (예외처리 요구됨)
	            stmt = conn.createStatement();
	            // SQL문 실행하기 --> 결과 행 리턴된 (예외처리 요구됨)
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next()) {
	            	UserInfoVo user = new UserInfoVo();
	            	user.setUserId(rs.getString("USER_ID"));
	            	user.setNickname(rs.getString("NICKNAME"));
	            	user.setRegisterDate(rs.getTimestamp("REGISTER_DATE"));
	            	userList.add(user);
	            }
	    } catch (SQLException e) {
	        System.out.println("MySQL SQL Fail: " + e.getMessage());                
	    } finally {
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException e) { }
	        }
	    }        

		DB.close();
		
		return userList;
	}
}
