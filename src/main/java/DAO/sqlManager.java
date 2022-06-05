package DAO;

public class sqlManager {
	private static String getAllUserSql = "SELECT USER_ID, NICKNAME, REGISTER_DATE FROM USER_INFO";

	public static String getGetAllUserSql() {
		return getAllUserSql;
	}
}
