package cn.edu.jsu.lyl.frm;
/**
 * 管理员修改员工工资界面
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fUpdataFrm extends JFrame {

	private JPanel contentPane;
	private JTextField JBGZTF;
	private JTextField SHBXJF;
	private JTextField JTBZJF;
	private JTextField TXBZJF;
	private JTextField JXGZJF;
	private JTextField GRSSJF;
	private JTextField textField;
	private JTextField JBGZJF;
	private JTextField QQCSJF;
	private JTextField KCGZJF;
	public static String Str3;
	String XM = null;
	String A = null;
	String B = null;
	String C = null;
	String D = null;
	String E = null;
	String F = null;
	String G = null;
	String H = null;
	String I = null;
	String J = null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					fUpdataFrm frame = new fUpdataFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public fUpdataFrm() {
		setTitle("\u5DE5\u8D44\u4FEE\u6539");
		chazhao();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel BHJL = new JLabel("");
		BHJL.setForeground(Color.BLUE);
		BHJL.setBounds(88, 35, 84, 15);
		BHJL.setText(Str3);
		contentPane.add(BHJL);

		JLabel lblNewLabel = new JLabel("编号：");
		lblNewLabel.setBounds(10, 35, 44, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(201, 35, 44, 15);
		contentPane.add(lblNewLabel_1);

		JLabel XMJL = new JLabel("");
		XMJL.setForeground(Color.BLUE);
		XMJL.setBounds(260, 35, 84, 15);
		XMJL.setText(XM);
		contentPane.add(XMJL);

		JLabel lblNewLabel_2 = new JLabel("基本工资");
		lblNewLabel_2.setBounds(10, 77, 62, 15);
		contentPane.add(lblNewLabel_2);

		JBGZTF = new JTextField();
		JBGZTF.setBounds(88, 74, 74, 21);
		contentPane.add(JBGZTF);
		JBGZTF.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("社会保险");
		lblNewLabel_3.setBounds(201, 77, 56, 15);
		contentPane.add(lblNewLabel_3);

		SHBXJF = new JTextField();
		SHBXJF.setColumns(10);
		SHBXJF.setBounds(270, 74, 74, 21);
		contentPane.add(SHBXJF);

		JLabel lblNewLabel_2_1 = new JLabel("交通补助");
		lblNewLabel_2_1.setBounds(10, 117, 62, 15);
		contentPane.add(lblNewLabel_2_1);

		JTBZJF = new JTextField();
		JTBZJF.setColumns(10);
		JTBZJF.setBounds(88, 114, 74, 21);
		contentPane.add(JTBZJF);

		JLabel lblNewLabel_3_1 = new JLabel("通讯补助");
		lblNewLabel_3_1.setBounds(201, 117, 56, 15);
		contentPane.add(lblNewLabel_3_1);

		TXBZJF = new JTextField();
		TXBZJF.setColumns(10);
		TXBZJF.setBounds(270, 114, 74, 21);
		contentPane.add(TXBZJF);

		JLabel lblNewLabel_2_1_1 = new JLabel("绩效工资");
		lblNewLabel_2_1_1.setBounds(10, 160, 62, 15);
		contentPane.add(lblNewLabel_2_1_1);

		JXGZJF = new JTextField();
		JXGZJF.setColumns(10);
		JXGZJF.setBounds(88, 157, 74, 21);
		contentPane.add(JXGZJF);

		JLabel lblNewLabel_3_1_1 = new JLabel("个人税收");
		lblNewLabel_3_1_1.setBounds(201, 160, 56, 15);
		contentPane.add(lblNewLabel_3_1_1);

		GRSSJF = new JTextField();
		GRSSJF.setColumns(10);
		GRSSJF.setBounds(270, 157, 74, 21);
		contentPane.add(GRSSJF);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("加班天数");
		lblNewLabel_2_1_1_1.setBounds(10, 202, 62, 15);
		contentPane.add(lblNewLabel_2_1_1_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(88, 199, 74, 21);
		contentPane.add(textField);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("加班工资");
		lblNewLabel_3_1_1_1.setBounds(201, 202, 56, 15);
		contentPane.add(lblNewLabel_3_1_1_1);

		JBGZJF = new JTextField();
		JBGZJF.setColumns(10);
		JBGZJF.setBounds(270, 199, 74, 21);
		contentPane.add(JBGZJF);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("缺勤次数");
		lblNewLabel_2_1_1_1_1.setBounds(10, 242, 62, 15);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		QQCSJF = new JTextField();
		QQCSJF.setColumns(10);
		QQCSJF.setBounds(88, 239, 74, 21);
		contentPane.add(QQCSJF);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("扣除工资");
		lblNewLabel_3_1_1_1_1.setBounds(201, 242, 56, 15);
		contentPane.add(lblNewLabel_3_1_1_1_1);

		KCGZJF = new JTextField();
		KCGZJF.setColumns(10);
		KCGZJF.setBounds(270, 239, 74, 21);
		contentPane.add(KCGZJF);

		JButton btnNewButton = new JButton("保存");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caozuo();
				JOptionPane.showMessageDialog(null, "保存成功");
			}
		});
		btnNewButton.setBounds(137, 292, 93, 23);
		contentPane.add(btnNewButton);
	}

	public boolean panDuan(String str) {
		if (str.length() == 0)
			return false;
		return true;
	}

	public void caozuo() {
		DatabaseConnection conn2 = new DatabaseConnection();
		String sql = "UPDATE Employee SET baseM=?,socialM=?,trafficA=?,communicationA=?,meritA=?,individualA=?,overday=?,overM=?,lostday=?,lostM=? WHERE eid=?";
		try (Connection conn = conn2.getConnection(); 
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);) {
			AA();
//			System.out.println( "更新 " + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " "
//					+ " " + H + " " + I + " " + J);
			pstmt.setString(1, A);
			pstmt.setString(2, B);
			pstmt.setString(3, C);
			pstmt.setString(4, D);
			pstmt.setString(5, E);
			pstmt.setString(6, F);
			pstmt.setString(7, G);
			pstmt.setString(8, H);
			pstmt.setString(9, I);
			pstmt.setString(10, J);
			pstmt.setString(11, Str3);
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void chazhao() {
		DatabaseConnection conn3 = new DatabaseConnection();
		String sql = "SELECT * FROM Employee";
		try (Connection conn = conn3.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				if (rs.getString("eid").equals(Str3)) {
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
					XM = rs.getString("name");
//					System.out.println(XM + " " + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " "
//							+ " " + H + " " + I + " " + J);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AA() {
		if (panDuan(JBGZTF.getText()))
			A = JBGZTF.getText();
		if (panDuan(SHBXJF.getText()))
			B = SHBXJF.getText();
		if (panDuan(JTBZJF.getText()))
			C = JTBZJF.getText();
		if (panDuan(TXBZJF.getText()))
			D = TXBZJF.getText();
		if (panDuan(JXGZJF.getText()))
			E = JXGZJF.getText();
		if (panDuan(GRSSJF.getText()))
			F = GRSSJF.getText();
		if (panDuan(textField.getText()))
			G = textField.getText();
		if (panDuan(JBGZJF.getText()))
			H = JBGZJF.getText();
		if (panDuan(QQCSJF.getText()))
			I = QQCSJF.getText();
		if (panDuan(KCGZJF.getText()))
			J = KCGZJF.getText();
	}

	public static void setStr(String a) {
		Str3 = a;
	}
}
