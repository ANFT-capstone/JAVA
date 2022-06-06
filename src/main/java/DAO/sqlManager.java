package DAO;

public class sqlManager {
	private static String getAllUserSql = "SELECT USER_ID, NICKNAME, REGISTER_DATE FROM USER_INFO";
	private static String getAllNftSql = "SELECT * FROM NFT_INFO";

	public static String getGetAllUserSql() {
		return getAllUserSql;
	}
	public static String getGetAllNftSql() {
		return getAllNftSql;
	}
}
