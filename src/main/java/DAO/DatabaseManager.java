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
import DataVo.RequestHistoryVo;
import DataVo.UserInfoVo;

public class DatabaseManager {
	// find NFT by nft uri
	public NftInfoVo getNftByNftId(String NftUri) {
		NftInfoVo nft = new NftInfoVo();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetNftByNftUriSql(NftUri);
		
	    try {
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            if(rs.next()) {
	            	nft.setNftNumber(rs.getString("NFT_NUMBER"));
	            	nft.setLabel(rs.getString("LABEL"));
	            	nft.setCategory(rs.getString("CATEGORY"));
	            	nft.setCreateDate(rs.getTimestamp("CREATE_DATE"));
	            	nft.setPrice(rs.getInt("PRICE"));
	            	nft.setUri(rs.getString("URI"));
	            	nft.setIs_sell((char) rs.getByte("IS_SELL"));
	            	nft.setCreateUser(rs.getString("CREATE_USER"));
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
		
		return nft;
	}
	
	// find NFT by nft id
	public NftInfoVo getNftByNftId(int NftId) {
		NftInfoVo nft = new NftInfoVo();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetNftByNftIdSql(NftId);
		
	    try {
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            if(rs.next()) {
	            	nft.setNftNumber(rs.getString("NFT_NUMBER"));
	            	nft.setLabel(rs.getString("LABEL"));
	            	nft.setCategory(rs.getString("CATEGORY"));
	            	nft.setCreateDate(rs.getTimestamp("CREATE_DATE"));
	            	nft.setPrice(rs.getInt("PRICE"));
	            	nft.setUri(rs.getString("URI"));
	            	nft.setIs_sell((char) rs.getByte("IS_SELL"));
	            	nft.setCreateUser(rs.getString("CREATE_USER"));
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
		
		return nft;
	}
	
	// find owner by nft id
	public List<UserInfoVo> getOwnerListByNftId(int nftId) {
		List<UserInfoVo> userList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetOwnerListByNftIdSql(nftId);
		
	    try {
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
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
	
	// find owner by nft uri
	public List<UserInfoVo> getOwnerListByNftUri(String nftUri) {
		List<UserInfoVo> userList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetOwnerListByNftUriSql(nftUri);
		
	    try {
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
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
	
	// find NFT by userID
	public List<NftInfoVo> getNftListByUserId(String userID) {
		List<NftInfoVo> nftList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetNftListByUserIdSql(userID);
		
	    try {
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
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
	
	// find user by userID
	public UserInfoVo getUserByUserID(String userID) {
		UserInfoVo user = new UserInfoVo();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetUserByUserIdSql(userID);
		
	    try {
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            if(rs.next()) {
	            	user.setUserId(rs.getString("USER_ID"));
	            	user.setNickname(rs.getString("NICKNAME"));
	            	user.setRegisterDate(rs.getTimestamp("REGISTER_DATE"));
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
		return user;
	}
	
	public List<UserInfoVo> getAllUser() {
		List<UserInfoVo> userList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetAllUserSql();
		
	    try {
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
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
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
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
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
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
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
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
	
	public List<RequestHistoryVo> getAllHistory() {
		List<RequestHistoryVo> historyList = new ArrayList<>();
		
		DbConnector DB = DbConnector.getInstance();
		
		Connection conn = DB.open();
		
		Statement stmt = null;
		
		String sql = sqlManager.getGetAllRequestHistorySql();
		
	    try {
	            // SQL���� ������ �� �ִ� ��ü ���� (����ó�� �䱸��)
	            stmt = conn.createStatement();
	            // SQL�� �����ϱ� --> ��� �� ���ϵ� (����ó�� �䱸��)
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next()) {
	            	RequestHistoryVo history = new RequestHistoryVo();
	            	history.setRequestId(rs.getInt("REQUEST_ID"));
	            	history.setRequestUser(rs.getString("REQUEST_USER"));
	            	history.setRequestFunction(rs.getInt("REQUEST_FUNCTION"));
	            	history.setRequestDate(rs.getTimestamp("REQUEST_DATE"));
	            	history.setParameters(rs.getString("PARAMETERS"));
	            	history.setResult((char)rs.getByte("RESULT"));
	            	historyList.add(history);
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
		
		return historyList;
	}
}
