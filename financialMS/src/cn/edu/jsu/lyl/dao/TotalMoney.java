package cn.edu.jsu.lyl.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;
import cn.edu.jsu.lyl.frm.MainFrm;
/**
 * 统计员工工资
 * @author 罗焰林
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
	 * 计算个人工资
	 */
	public static int chazhao(String ID) {
		DatabaseConnection conn3 = new DatabaseConnection();
		String sql = "SELECT * FROM Employee";
		try (Connection conn = conn3.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				if (rs.getString("eid").equals(ID)) {
					A = rs.getString("baseM");// 基本工资
					B = rs.getString("socialM");// 社会保险
					C = rs.getString("trafficA");// 交通补助
					D = rs.getString("communicationA");// 通讯补助
					E = rs.getString("meritA");// 绩效工资
					F = rs.getString("individualA");// 个人税收
					G = rs.getString("overday");// 加班天数
					H = rs.getString("overM");// 加班工资
					I = rs.getString("lostday");// 缺勤次数
					J = rs.getString("lostM");// 扣除工资
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
	 * 规范计算时的字符串
	 */
	public static int parseInt(String intStr) {
//		//1.去除空格
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
	 * 计算结果插入到数据库
	 */
	public static void charu() {
		DatabaseConnection dbconn = new DatabaseConnection();// 使用1中定义的连接数据库的类
		String sql = "UPDATE Employee SET total=? WHERE eid=?";
		String sql1 = "SELECT * FROM Employee";
		try (Connection conn = dbconn.getConnection(); // 获取数据库连接
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql1)
					) {
			while (rs.next()) {
				int qp = chazhao(rs.getString("eid"));
//				System.out.println(qp+" ");
				pstmt.setInt(1, qp);
				pstmt.setString(2,rs.getString("eid"));
//				pstmt.addBatch();// 加入批处理等待执行
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
