package cn.edu.jsu.lyl.Efrm;
/**
 * 员工自己查询的工资信息界面
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;
import cn.edu.jsu.lyl.frm.MainFrm;

import javax.swing.JLabel;
import java.awt.Color;

public class GongziFrm extends JFrame {

	private JPanel contentPane;
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
	String XM=null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GongziFrm frame = new GongziFrm();
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
	public GongziFrm() {
		chazhao();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 317, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 44, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(10, 85, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u57FA\u672C\u5DE5\u8D44\uFF1A");
		lblNewLabel_1_1.setBounds(10, 121, 67, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u793E\u4F1A\u4FDD\u9669\uFF1A");
		lblNewLabel_1_1_1.setBounds(10, 155, 67, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("\u4EA4\u901A\u8865\u52A9\uFF1A");
		lblNewLabel_1_1_2.setBounds(10, 191, 67, 15);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("\u901A\u8BAF\u8865\u52A9\uFF1A");
		lblNewLabel_1_1_3.setBounds(10, 222, 67, 15);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("\u7EE9\u6548\u5DE5\u8D44");
		lblNewLabel_1_1_4.setBounds(10, 258, 67, 15);
		contentPane.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("\u4E2A\u4EBA\u7A0E\u6536\uFF1A");
		lblNewLabel_1_1_5.setBounds(10, 292, 67, 15);
		contentPane.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("\u52A0\u73ED\u5929\u6570\uFF1A");
		lblNewLabel_1_1_6.setBounds(10, 328, 67, 15);
		contentPane.add(lblNewLabel_1_1_6);
		
		JLabel lblNewLabel_1_1_7 = new JLabel("\u52A0\u73ED\u5DE5\u8D44\uFF1A");
		lblNewLabel_1_1_7.setBounds(10, 361, 67, 15);
		contentPane.add(lblNewLabel_1_1_7);
		
		JLabel lblNewLabel_1_1_8 = new JLabel("\u7F3A\u52E4\u5929\u6570\uFF1A");
		lblNewLabel_1_1_8.setBounds(10, 393, 67, 15);
		contentPane.add(lblNewLabel_1_1_8);
		
		JLabel lblNewLabel_1_1_9 = new JLabel("\u6263\u9664\u5DE5\u8D44\uFF1A");
		lblNewLabel_1_1_9.setBounds(10, 427, 67, 15);
		contentPane.add(lblNewLabel_1_1_9);
		
		JLabel lblNewLabel_2 = new JLabel("\u603B\u8BA1\u5E94\u5F97\u5DE5\u8D44\uFF1A");
		lblNewLabel_2.setBounds(8, 470, 106, 29);
		contentPane.add(lblNewLabel_2);
		
		String c= total()+" "+"元";
		JLabel ZGZ = new JLabel(c);
		ZGZ.setForeground(Color.BLUE);
		ZGZ.setBounds(136, 470, 156, 29);
		contentPane.add(ZGZ);
		
		JLabel BH = new JLabel("");
		BH.setForeground(Color.BLUE);
		BH.setBounds(117, 44, 106, 15);
		BH.setText(MainFrm.getStr2());
		contentPane.add(BH);
		
		JLabel XM1 = new JLabel(XM);
		XM1.setForeground(Color.BLUE);
		XM1.setBounds(117, 85, 106, 15);
		contentPane.add(XM1);
		
		JLabel A1 = new JLabel(A);
		A1.setForeground(Color.RED);
		A1.setBounds(117, 121, 106, 15);
		contentPane.add(A1);
		
		JLabel B1 = new JLabel(B);
		B1.setForeground(Color.RED);
		B1.setBounds(117, 155, 106, 15);
		contentPane.add(B1);
		
		JLabel C1 = new JLabel(C);
		C1.setForeground(Color.RED);
		C1.setBounds(117, 191, 106, 15);
		contentPane.add(C1);
		
		JLabel D1 = new JLabel(D);
		D1.setForeground(Color.RED);
		D1.setBounds(117, 222, 106, 15);
		contentPane.add(D1);
		
		JLabel E1 = new JLabel(E);
		E1.setForeground(Color.RED);
		E1.setBounds(117, 258, 106, 15);
		contentPane.add(E1);
		
		JLabel F1 = new JLabel(F);
		F1.setForeground(Color.RED);
		F1.setBounds(117, 292, 106, 15);
		contentPane.add(F1);
		
		JLabel G1 = new JLabel(G);
		G1.setForeground(Color.RED);
		G1.setBounds(117, 328, 106, 15);
		contentPane.add(G1);
		
		JLabel H1 = new JLabel(H);
		H1.setForeground(Color.RED);
		H1.setBounds(117, 361, 106, 15);
		contentPane.add(H1);
		
		JLabel I1 = new JLabel(I);
		I1.setForeground(Color.RED);
		I1.setBounds(117, 393, 106, 15);
		contentPane.add(I1);
		
		JLabel J1 = new JLabel(J);
		J1.setForeground(Color.RED);
		J1.setBounds(117, 427, 106, 15);
		contentPane.add(J1);
	}
	public void chazhao() {
		DatabaseConnection conn3 = new DatabaseConnection();
		String sql = "SELECT * FROM Employee";
		try (Connection conn = conn3.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				if (rs.getString("eid").equals(MainFrm.getStr2())) {
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
				//	System.out.println(XM + " " + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " "+ " " + H + " " + I + " " + J);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int parseInt(String intStr) {
//		//1.去除空格
//		 intStr = intStr.trim(); 
		return Double.valueOf(intStr.trim()).intValue();

	}

	public int total() {
//		System.out.println(XM + " " + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " "+ " " + H + " " + I + " " + J);
		return parseInt(A)-parseInt(B)+parseInt(C)+parseInt(D)+parseInt(E)-parseInt(F)+parseInt(H)-parseInt(J);
	}
}
