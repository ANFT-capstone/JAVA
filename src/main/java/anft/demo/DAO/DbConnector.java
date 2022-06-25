package anft.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static final String db_hostname 	= "";
    private static final int db_portnumber 		= 3306;
    private static final String db_database 	= "";
    private static final String db_charset 		= "";
    private static final String db_username 	= "";
    private static final String db_password 	= "";

    private Connection conn = null;

    // ----- 싱글톤 객체 생성을 위한 준비 시작 -----
    // 싱글톤 객체
    private static DbConnector current;

    public static DbConnector getInstance() {
        if (current == null) {
            current = new DbConnector();
        }
        return current;
    }

    public void freeInstance() {
        current = null;
    }

    private DbConnector() { }

    /** 데이터베이스에 접속 후, 접속 객체 리턴 */
    public Connection open() {
        // 중복 실행될 경우 발생될 문제를 방지하기 위해
        // Connection 객체가 null인 경우만 처리하도록 if문으로 구성
        if (conn == null) {
            /** 데이터베이스 접속 처리 */
            // 사용하려는 데이터베이스명을 포함한 URL기술
            String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=UTC";
            String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);

            // MySQL JDBC의 드라이버 클래스를 로딩해서 DriverManager클래스에 등록한다.
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // DriverManager 객체를 사용하여 DB에 접속한다.
                // -> 접속 URL, 아이디, 비밀번호를 전달
                // -> DriverManager에 등록된 Driver 객체를 사용하여 DB에 접속 후,
                // Connection 객체를 리턴받는다
                conn = DriverManager.getConnection(url, db_username, db_password);

                // 성공시 메시지 출력
                System.out.println("=== DATABASE Connect Success ===");

            } catch (ClassNotFoundException e) {
                // 실패시 메시지와 에러 내용 출력
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());

            } catch (SQLException e) {
                // 실패시 메시지와 에러 내용 출력
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }

    /** 데이터베이스의 접속을 해제 */
    public void close() {
        if (conn != null) {
            /** 데이터베이스 접속 해제 처리*/
            try {
                conn.close();
                System.out.println(" === DATABASE Disconnect Success ===");
            } catch (Exception e) {
                System.out.println(" === DATABASE Disconnect Fail ===");
                System.out.println(e.getMessage());
            }
            conn = null;
        }
    }
}
