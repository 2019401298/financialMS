package cn.edu.jsu.lyl.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;
import jxl.write.Label;
import jxl.write.WritableWorkbook;
/**
 * �����ݿ�����ݵ��뵽�ļ���
 * @author ������
 *
 */
public class Addfiledata {
	public static void addFile() {
		File file = new File("C:\\Users\\������\\Desktop\\java�γ����\\SJ.txt");
		DatabaseConnection dbcs = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
		String sql = "select * from Employee ";
		String qp = null;
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				FileWriter fw = new FileWriter(file, true);) {
			while (rs.next()) {
				qp = rs.getString("eid") + "\t" + rs.getString("name") + "\t" + rs.getString("sex") + "\t"
						+ rs.getString("eduback") + "\t" + rs.getString("phone") + "\r";
				fw.write(qp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		addFile();
		JOptionPane.showMessageDialog(null, "��ӳɹ�");
	}
}
