package cn.edu.jsu.lyl.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;
import cn.edu.jsu.lyl.frm.MainFrm;
/**
 * ͳ��Ա������
 * @author ������
 *
 */
public class TotalMoney {
	static String A = null;
	static String B = null;
	static String C = null;
	static String D = null;
	static String E = null;
	static String F = null;
	static String G = null;
	static String H = null;
	static String I = null;
	static String J = null;
	static String XM = null;
	/*
	 * ������˹���
	 */
	public static int chazhao(String ID) {
		DatabaseConnection conn3 = new DatabaseConnection();
		String sql = "SELECT * FROM Employee";
		try (Connection conn = conn3.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				if (rs.getString("eid").equals(ID)) {
					A = rs.getString("baseM");// ��������
					B = rs.getString("socialM");// ��ᱣ��
					C = rs.getString("trafficA");// ��ͨ����
					D = rs.getString("communicationA");// ͨѶ����
					E = rs.getString("meritA");// ��Ч����
					F = rs.getString("individualA");// ����˰��
					G = rs.getString("overday");// �Ӱ�����
					H = rs.getString("overM");// �Ӱ๤��
					I = rs.getString("lostday");// ȱ�ڴ���
					J = rs.getString("lostM");// �۳�����
					// System.out.println(XM + " " + A + " " + B + " " + C + " " + D + " " + E + " "
					// + F + " " + G + " "+ " " + H + " " + I + " " + J);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parseInt(A) - parseInt(B) + parseInt(C) + parseInt(D) + parseInt(E) - parseInt(F) + parseInt(H)
				- parseInt(J);
	}

	/*
	 * �淶����ʱ���ַ���
	 */
	public static int parseInt(String intStr) {
//		//1.ȥ���ո�
//		 intStr = intStr.trim(); 
		if (intStr != null)
			return Double.valueOf(intStr.trim()).intValue();
		return 0;

	}

//	public int total() {
//		System.out.println(XM + " " + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " "+ " " + H + " " + I + " " + J);
//		return parseInt(A)-parseInt(B)+parseInt(C)+parseInt(D)+parseInt(E)-parseInt(F)+parseInt(H)-parseInt(J);
//	}

	/*
	 * ���������뵽���ݿ�
	 */
	public static void charu() {
		DatabaseConnection dbconn = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
		String sql = "UPDATE Employee SET total=? WHERE eid=?";
		String sql1 = "SELECT * FROM Employee";
		try (Connection conn = dbconn.getConnection(); // ��ȡ���ݿ�����
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql1)
					) {
			while (rs.next()) {
				int qp = chazhao(rs.getString("eid"));
//				System.out.println(qp+" ");
				pstmt.setInt(1, qp);
				pstmt.setString(2,rs.getString("eid"));
//				pstmt.addBatch();// ����������ȴ�ִ��
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		charu();
//	}
}
