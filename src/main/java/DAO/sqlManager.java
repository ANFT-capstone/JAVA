package DAO;

public class sqlManager {
	private static String getAllUserSql = "SELECT USER_ID, NICKNAME, REGISTER_DATE FROM USER_INFO";
	private static String getAllNftSql = "SELECT * FROM NFT_INFO";
	private static String getAllCategorySql = "SELECT * FROM NFT_CATEGORY";
	private static String getAllFunctionSql = "SELECT * FROM FUNCTION_INFO";
	private static String getAllRequestHistorySql = "SELECT * FROM REQUEST_HISTORY";
	
	public static String getGetAllUserSql() {
		return getAllUserSql;
	}
	public static String getGetAllNftSql() {
		return getAllNftSql;
	}
	public static String getGetAllCategorySql() {
		return getAllCategorySql;
	}
	public static String getGetAllFunctionSql() {
		return getAllFunctionSql;
	}
	public static String getGetAllRequestHistorySql() {
		return getAllRequestHistorySql;
	}
}
