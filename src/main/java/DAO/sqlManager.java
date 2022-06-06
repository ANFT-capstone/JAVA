package DAO;

public class sqlManager {
	private static String getAllUserSql = "SELECT USER_ID, NICKNAME, REGISTER_DATE FROM USER_INFO";
	private static String getAllNftSql = "SELECT * FROM NFT_INFO";
	private static String getAllCategorySql = "SELECT * FROM NFT_CATEGORY";
	private static String getAllFunctionSql = "SELECT * FROM FUNCTION_INFO";
	private static String getAllRequestHistorySql = "SELECT * FROM REQUEST_HISTORY";
	private static String getUserByUserIdSql = "SELECT * FROM USER_INFO WHERE USER_ID = ";
	private static String getNftListByUserIdSql = "select * from nft_info \r\n"
													+ "WHERE NFT_NUMBER IN\r\n"
													+ "(\r\n"
													+ "	SELECT NFT_ID \r\n"
													+ "	FROM NFT_OWNER_GROUP_INFO\r\n"
													+ "	WHERE USER_ID = ";
	
	public static String getGetUserByUserIdSql(String userID) {
		return getUserByUserIdSql+"\""+userID+"\"";
	}
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
	public static String getGetNftListByUserIdSql(String userID) {
		return getNftListByUserIdSql+"\""+userID+"\")";
	}
}
