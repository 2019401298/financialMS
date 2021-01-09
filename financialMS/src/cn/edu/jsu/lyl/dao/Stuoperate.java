package cn.edu.jsu.lyl.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;

public class Stuoperate {

	public static void initTable(DefaultTableModel model) {
		DatabaseConnection conn1 = new DatabaseConnection();
		Vector<Vector> rows = new Vector<Vector>();
		String sql = "SELECT* from Employee";
		try (Connection conn11 = conn1.getConnection();
				Statement stme = conn11.createStatement();
				ResultSet rs = stme.executeQuery(sql);) {
			while (rs.next()) {
				Vector row = new Vector();// 定义行数据
				row.add(rs.getString("eid"));
				row.add(rs.getString("name"));
				row.add(rs.getString("sex"));
				row.add(rs.getString("eduback"));
				row.add(rs.getString("password"));
				row.add(rs.getString("phone"));
				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteTable(String id) {// 删除行数据
		DatabaseConnection conn2 = new DatabaseConnection();
		String sql = "DELETE FROM Employee WHERE eid=" + id;
		try (Connection conn = conn2.getConnection(); 
				Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initTable2(DefaultTableModel model) {
		DatabaseConnection conn2 = new DatabaseConnection();
		Vector<Vector> rows = new Vector<Vector>();
		String sql = "SELECT* from record";
		try (Connection conn11 = conn2.getConnection();
				Statement stme = conn11.createStatement();
				ResultSet rs = stme.executeQuery(sql);) {
			while (rs.next()) {
				Vector row = new Vector();// 定义行数据
				row.add(rs.getString("eid"));
				row.add(rs.getString("name"));
				row.add(rs.getString("sex"));
				row.add(rs.getString("phone"));
				row.add(rs.getString("money"));
				row.add(rs.getString("reason"));
				row.add(rs.getString("time"));
				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initTable3(DefaultTableModel model) {
		DatabaseConnection conn2 = new DatabaseConnection();
		Vector<Vector> rows = new Vector<Vector>();
		String sql = "SELECT* from business";
		try (Connection conn11 = conn2.getConnection();
				Statement stme = conn11.createStatement();
				ResultSet rs = stme.executeQuery(sql);) {
			while (rs.next()) {
				Vector row = new Vector();// 定义行数据
				row.add(rs.getString("proname"));
				row.add(rs.getString("putinto"));
				row.add(rs.getString("income"));
				row.add(rs.getString("note"));
				row.add(rs.getString("time"));
				row.add(rs.getString("prici"));
				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initTable4(DefaultTableModel model) {
		DatabaseConnection conn2 = new DatabaseConnection();
		Vector<Vector> rows = new Vector<Vector>();
		String sql = "SELECT* from Employee";
		try (Connection conn11 = conn2.getConnection();
				Statement stme = conn11.createStatement();
				ResultSet rs = stme.executeQuery(sql);) {
			while (rs.next()) {
				Vector row = new Vector();// 定义行数据
				row.add(rs.getString("eid"));
				row.add(rs.getString("name"));
				row.add(rs.getString("baseM"));
				row.add(rs.getString("socialM"));
				row.add(rs.getString("trafficA"));
				row.add(rs.getString("communicationA"));
				row.add(rs.getString("meritA"));
				row.add(rs.getString("individualA"));
				row.add(rs.getInt("overday"));
				row.add(rs.getString("overM"));
				row.add(rs.getInt("lostday"));
				row.add(rs.getString("lostM"));
				row.add(rs.getInt("total"));
				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteTable2(String id,String Time) {// 删除行数据
		DatabaseConnection conn2 = new DatabaseConnection();
		String sql = "DELETE FROM record WHERE eid= '"+id+"' and time= '"+ Time+"'";
		try (Connection conn = conn2.getConnection(); 
				Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
