package DAO;

public class sqlManager {
	private static String getAllUserSql = "SELECT USER_ID, NICKNAME, REGISTER_DATE FROM USER_INFO";
	private static String getAllNftSql = "SELECT * FROM NFT_INFO";
	private static String getAllCategorySql = "SELECT * FROM NFT_CATEGORY";
	private static String getAllFunctionSql = "SELECT * FROM FUNCTION_INFO";
	private static String getAllRequestHistorySql = "SELECT * FROM REQUEST_HISTORY";
	private static String getUserByUserIdSql = "SELECT * FROM USER_INFO WHERE USER_ID = \"{PARAM}\"";
	private static String getNftListByUserIdSql = "select * from nft_info\r\n"
													+ "WHERE NFT_NUMBER in\r\n"
													+ "(\r\n"
													+ "	SELECT NFT_ID\r\n"
													+ "	FROM NFT_OWNER_GROUP_INFO\r\n"
													+ "	WHERE USER_ID = \"{PARAM}\"\r\n"
													+ ")";
	private static String getOwnerListByNftUriSql = "SELECT * FROM USER_INFO\r\n"
													+ "WHERE USER_ID IN\r\n"
													+ "(\r\n"
													+ "    SELECT DISTINCT USER_ID FROM NFT_OWNER_GROUP_INFO\r\n"
													+ "    WHERE NFT_ID IN\r\n"
													+ "    (\r\n"
													+ "        SELECT NFT_ID FROM NFT_INFO WHERE URI = \"{PARAM}\"\r\n"
													+ "    )\r\n"
													+ ")";
	private static String getOwnerListByNftIdSql = "select * from user_info\r\n"
													+ "WHERE user_id in\r\n"
													+ "(\r\n"
													+ "	SELECT user_id\r\n"
													+ "	FROM NFT_OWNER_GROUP_INFO\r\n"
													+ "	WHERE nft_id = {PARAM}\r\n"
													+ ")";
	private static String getNftByNftIdSql = "SELECT * FROM NFT_INFO WHERE NFT_NUMBER = \"{PARAM}\"";
	private static String getNftByNftUriSql = "SELECT * FROM NFT_INFO WHERE URI = \"{PARAM}\"";
	
	public static String getGetNftByNftUriSql(String NftUri) {
		return getNftByNftUriSql.replace("{PARAM}", NftUri);
	}
	public static String getGetNftByNftIdSql(int nftId) {
		return getNftByNftIdSql.replace("{PARAM}", Integer.toString(nftId));
	}
	public static String getGetOwnerListByNftIdSql(int nftId) {
		return getOwnerListByNftIdSql.replace("{PARAM}", Integer.toString(nftId));
	}
	public static String getGetOwnerListByNftUriSql(String nftUri) {
		return getOwnerListByNftUriSql.replace("{PARAM}", nftUri);
	}
	public static String getGetUserByUserIdSql(String userID) {
		return getUserByUserIdSql.replace("{PARAM}", userID);
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
		return getNftListByUserIdSql.replace("{PARAM}", userID);
	}
}
