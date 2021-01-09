package cn.edu.jsu.lyl.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ���ݿ������
 * @author ������
 *
 */
//���ݿ������

public class DatabaseConnection {
	private static final String DBRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;; // ����sqlserver���ݿ���������
	private static final String DBURL ="jdbc:sqlserver://localhost:1433;DatabaseName=testMS" ; // ����sqlserver���ݿ����ӵ�ַ
	private static final String DBUSER = "sa"; // sqlserver���ݿ������û���
	private static final String PASSWORD = "12345678"; // sqlserver���ݿ���������
	private Connection conn = null; // �������Ӷ���

	public DatabaseConnection() {// ���췽���������ݿ�
		try {
			Class.forName(DBRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {// �������ݿ����Ӷ���
		return this.conn;
	}

	public void close() {// �ر���������
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
