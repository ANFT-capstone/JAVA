package anft.demo.DAO;

public class sqlManager {
	/*sql to get information from database*/
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
	/*sql to insert information to database*/
	private static String setNewUserSql = "insert into user_info(user_id,nickname,register_date)\r\n"
			+ "value(\"{param1}\",\"{param2}\",STR_TO_DATE('{param3}', '%Y%m%d'))";
	private static String setNewNftSql = "insert into nft_info(Label,Category,create_date,price,URI,is_sell,create_user)\r\n"
			+ "value(\"{param2}\",\"{param3}\",STR_TO_DATE('{param4}', '%Y%m%d'),{param5},\"{param6}\",'{param7}',\"{param8}\")";
	private static String setNewHistorySql = "insert into request_history(request_user,request_function,request_date,parameters,result)\r\n"
			+ "value(\"{param2}\",{param3},STR_TO_DATE('{param4}', '%Y%m%d'),\"{param5}\",'{param6}')";
	private static String setNewCategorySql = "insert into nft_category(category,create_date,create_user,nft_nums)\r\n"
			+"value(\"{param2}\",STR_TO_DATE('{param3}', '%Y%m%d'),\"{param4}\",{param5})";
	private static String setNewFunctionSql = "insert into function_info(function_label,parameter_list,http_url)\r\n"
			+"value(\"{param2}\",\"{param3}\",\"{param4}\")";
	private static String setNewOwnerGroupSql = "insert into nft_owner_group_info(nft_id, user_id)\r\n"
			+"value({param1},\"{param2}\")";

	/*set functions*/
	public static String setSetNewNftSql(String label, String category, String createDate, int price, String uri, char isSell, String createUser) {
		return setNewNftSql.replace("{param2}", label).replace("{param3}", category).replace("{param4}", createDate).replace("{param5}", Integer.toString(price)).replace("{param6}", uri).replace("{param7}", Character.toString(isSell)).replace("{param8}", createUser);
	}
	public static String setSetNewCategorySql(String category, String createDate, String createUser, int nftNums) {
		return setNewCategorySql.replace("{param2}", category).replace("{param3}", createDate).replace("{param4}", createUser).replace("{param5}", Integer.toString(nftNums));
	}
	public static String setSetNewUserSql(String userId, String nickName,String registerDate) {
		return setNewUserSql.replace("{param1}", userId).replace("{param2}", nickName).replace("{param3}", registerDate);
	}
	public static String setSetNewFunctionSql(String functionLabel, String parameterList, String httpUrl) {
		return setNewFunctionSql.replace("{param2}", functionLabel).replace("{param3}", parameterList).replace("{param4}", httpUrl);
	}
	public static String setSetNewHistorySql(String requestUser, int requestFunction, String requestDate, String parameters, char result) {
		return setNewHistorySql.replace("{param2}", requestUser).replace("{param3}", Integer.toString(requestFunction)).replace("{param4}", requestDate).replace("{param5}", parameters).replace("{param6}", Character.toString(result));
	}
	public static String setSetNewOwnerGroupSql(int nftId, String userId) {
		return setNewOwnerGroupSql.replace("{param1}", Integer.toString(nftId)).replace("{param2}", userId);
	}
	/*get functions*/
	public static String getGetNftByNftUriSql(String nftUri) {
		return getNftByNftUriSql.replace("{PARAM}", nftUri);
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
