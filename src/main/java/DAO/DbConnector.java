package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static final String db_hostname 	= "210.99.239.58";
    private static final int db_portnumber 		= 3306;
    private static final String db_database 	= "testdb";
    private static final String db_charset 		= "utf8";
    private static final String db_username 	= "besuuser";
    private static final String db_password 	= "!Q2w3e4r";

    private Connection conn = null;

    // ----- �̱��� ��ü ������ ���� �غ� ���� -----
    // �̱��� ��ü
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

    /** �����ͺ��̽��� ���� ��, ���� ��ü ���� */
    public Connection open() {
        // �ߺ� ����� ��� �߻��� ������ �����ϱ� ����
        // Connection ��ü�� null�� ��츸 ó���ϵ��� if������ ����
        if (conn == null) {
            /** �����ͺ��̽� ���� ó�� */
            // ����Ϸ��� �����ͺ��̽����� ������ URL���
            String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=UTC";
            String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);

            // MySQL JDBC�� ����̹� Ŭ������ �ε��ؼ� DriverManagerŬ������ ����Ѵ�.
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // DriverManager ��ü�� ����Ͽ� DB�� �����Ѵ�.
                // -> ���� URL, ���̵�, ��й�ȣ�� ����
                // -> DriverManager�� ��ϵ� Driver ��ü�� ����Ͽ� DB�� ���� ��,
                // Connection ��ü�� ���Ϲ޴´�
                conn = DriverManager.getConnection(url, db_username, db_password);

                // ������ �޽��� ���
                System.out.println("=== DATABASE Connect Success ===");

            } catch (ClassNotFoundException e) {            
                // ���н� �޽����� ���� ���� ���
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());

            } catch (SQLException e) {
                // ���н� �޽����� ���� ���� ���
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }

    /** �����ͺ��̽��� ������ ���� */
    public void close() {
        if (conn != null) {
            /** �����ͺ��̽� ���� ���� ó��*/
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
