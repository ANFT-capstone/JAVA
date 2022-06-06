package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataVo.FunctionInfoVo;
import DataVo.NftCategoryVo;
import DataVo.NftInfoVo;
import DataVo.UserInfoVo;

public class DatabaseManager {
	public UserInfoVo user;
	public NftInfoVo nft;
	public NftCategoryVo category;
	public FunctionInfoVo function;
	
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
	
	public List<NftInfoVo> getAllNft() {
		List<NftInfoVo> nftList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetAllNftSql();
		
	    try {
	            // SQL문을 실행할 수 있는 객체 생성 (예외처리 요구됨)
	            stmt = conn.createStatement();
	            // SQL문 실행하기 --> 결과 행 리턴된 (예외처리 요구됨)
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next()) {
	            	NftInfoVo nft = new NftInfoVo();
	            	nft.setNftNumber(rs.getString("NFT_NUMBER"));
	            	nft.setLabel(rs.getString("LABEL"));
	            	nft.setCategory(rs.getString("CATEGORY"));
	            	nft.setCreateDate(rs.getTimestamp("CREATE_DATE"));
	            	nft.setPrice(rs.getInt("PRICE"));
	            	nft.setUri(rs.getString("URI"));
	            	nft.setIs_sell((char) rs.getByte("IS_SELL"));
	            	nft.setCreateUser(rs.getString("CREATE_USER"));
	            	nft.setOwnerUser(rs.getString("OWNER_USER"));
	            	nftList.add(nft);
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
		
		return nftList;
	}
	
	public List<NftCategoryVo> getAllCategory() {
		List<NftCategoryVo> categoryList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetAllCategorySql();
		
	    try {
	            // SQL문을 실행할 수 있는 객체 생성 (예외처리 요구됨)
	            stmt = conn.createStatement();
	            // SQL문 실행하기 --> 결과 행 리턴된 (예외처리 요구됨)
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next()) {
	            	NftCategoryVo category = new NftCategoryVo();
	            	category.setCategory(rs.getString("NFT_NUMS"));
	            	category.setCreateDate(rs.getTimestamp("CREATE_DATE"));
	            	category.setCreateUser(rs.getString("CREATE_USER"));
	            	category.setNftNums(rs.getInt("NFT_NUMS"));
	            	category.setCategoryNumber(rs.getInt("CATEGORY_NUMBER"));
	            	categoryList.add(category);
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
		
		return categoryList;
	}
	
	public List<FunctionInfoVo> getAllFunction() {
		List<FunctionInfoVo> functionList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetAllFunctionSql();
		
	    try {
	            // SQL문을 실행할 수 있는 객체 생성 (예외처리 요구됨)
	            stmt = conn.createStatement();
	            // SQL문 실행하기 --> 결과 행 리턴된 (예외처리 요구됨)
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next()) {
	            	FunctionInfoVo function = new FunctionInfoVo();
	            	function.setFunctionLabel(rs.getString("FUNCTION_LABEL"));
	            	function.setFunctionID(rs.getInt("FUNCTION_ID"));
	            	function.setParameterList(rs.getString("PARAMETER_LIST"));
	            	function.setHttpUrl(rs.getString("HTTP_URL"));
	            	functionList.add(function);
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
		
		return functionList;
	}
}
