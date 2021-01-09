package cn.edu.jsu.lyl.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;
/**
 * һЩ������ɾ��ĵķ���������IO������ɾ����
 * @author ������
 *
 */
public class Stuoperate {

	public static void initTable(DefaultTableModel model) {
		DatabaseConnection conn1 = new DatabaseConnection();
		Vector<Vector> rows = new Vector<Vector>();
		String sql = "SELECT* from Employee";
		try (Connection conn11 = conn1.getConnection();
				Statement stme = conn11.createStatement();
				ResultSet rs = stme.executeQuery(sql);) {
			while (rs.next()) {
				Vector row = new Vector();// ����������
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

	public static void deleteTable(String id) {// ɾ��������
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
				Vector row = new Vector();// ����������
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
				Vector row = new Vector();// ����������
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
				Vector row = new Vector();// ����������
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
	public static void deleteTable2(String id,String Time) {// ɾ��������
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
	
	
	//======================IO=============================
	static File file=new File("C:\\Users\\������\\Desktop\\java�γ����\\SJ.txt");
	public static boolean addStue2(String stu, String uid) {
		try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(file, true);) {
			char[] tmp = new char[1024];
			int len = 0;
			while ((len = fr.read(tmp)) != -1) {
				if (new String(tmp, 0, len).contains(uid))
					return false;
			}
			fw.write(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void initTable8(DefaultTableModel model) {
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
			String row = null;
			while ((row = br.readLine()) != null) {
				model.addRow(row.split("\t"));// ����ȡ���а��ָ�����ֳ��ַ��������������ģ�ͣ��ؼ�����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteTable(DefaultTableModel model) {
		String temp = null;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
			for (int i = 0; i < model.getRowCount(); i++) {// ����������ݣ����뼯����
				String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
				bw.write(row);// ���ı��ļ�����������
				bw.newLine();// д��س�����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void GXtable(DefaultTableModel model) {
		String temp=null;
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
			for(int i=0;i<model.getRowCount();i++) {
				String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
				bw.write(row);// ���ı��ļ�����������
				bw.newLine();// д��س�����
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
