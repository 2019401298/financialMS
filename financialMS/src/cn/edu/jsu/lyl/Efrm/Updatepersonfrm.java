package cn.edu.jsu.lyl.Efrm;
/**
 * 职员修改个人信息界面
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;
import cn.edu.jsu.lyl.frm.MainFrm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Updatepersonfrm extends JFrame {

	private JPanel contentPane;
	private JTextField Xmtf;
	private JTextField Xbtf;
	private JTextField Dhtf;
	private JTextField Xltf;
	private JTextField textField;
	private static String ID=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatepersonfrm frame = new Updatepersonfrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Updatepersonfrm() {
		setTitle("个人信息修改");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setBounds(10, 52, 47, 25);
		contentPane.add(lblNewLabel);

		Xmtf = new JTextField();
		Xmtf.setBounds(95, 54, 126, 21);
		contentPane.add(Xmtf);
		Xmtf.setColumns(10);
		

		JLabel lblNewLabel_1 = new JLabel("性别：");
		lblNewLabel_1.setBounds(10, 109, 54, 15);
		contentPane.add(lblNewLabel_1);

		Xbtf = new JTextField();
		Xbtf.setBounds(95, 106, 126, 21);
		contentPane.add(Xbtf);
		Xbtf.setColumns(10);
		

		JLabel lblNewLabel_2 = new JLabel("电话：");
		lblNewLabel_2.setBounds(10, 160, 54, 15);
		contentPane.add(lblNewLabel_2);

		Dhtf = new JTextField();
		Dhtf.setText("");
		Dhtf.setBounds(95, 157, 126, 21);
		contentPane.add(Dhtf);
		Dhtf.setColumns(10);


		JLabel lblNewLabel_3 = new JLabel("学历：");
		lblNewLabel_3.setBounds(10, 207, 54, 15);
		contentPane.add(lblNewLabel_3);

		Xltf = new JTextField();
		Xltf.setBounds(95, 204, 126, 21);
		contentPane.add(Xltf);
		Xltf.setColumns(10);
		

		JLabel lblNewLabel_4 = new JLabel("登录密码：");
		lblNewLabel_4.setBounds(10, 246, 75, 15);
		contentPane.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(95, 243, 126, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JButton TjJB = new JButton("提交");
		TjJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE Employee SET name=?,sex=?,eduback=?,password=?,phone=? WHERE eid=?";
				DatabaseConnection dbconn = new DatabaseConnection();// 使用1中定义的连接数据库的类
				String XM=Xmtf.getText();
				String XB=Xbtf.getText();
				String XL=Xltf.getText();
				String DH=Dhtf.getText();
				String DLMM=textField.getText();
//				System.out.println(ID+" ");
//				System.out.println(XM+" ");
//				System.out.println(XB+" ");
//				System.out.println(XL+" ");
//				System.out.println(DH+" ");
//				System.out.println(DLMM+" ");
				try (Connection conn = dbconn.getConnection(); 
						java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);) {
						pstmt.setString(1, XM);
						pstmt.setString(2, XB);
						pstmt.setString(3, XL);
						pstmt.setString(4, DLMM);
						pstmt.setString(5, DH);
						pstmt.setString(6, ID);
						pstmt.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "修改成功");
						flush();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		TjJB.setBounds(88, 293, 93, 23);
		contentPane.add(TjJB);
		
		JLabel lblNewLabel_5 = new JLabel("用户：");
		lblNewLabel_5.setBounds(10, 10, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel YHJL = new JLabel("");
		YHJL.setForeground(Color.BLUE);
		YHJL.setBounds(74, 10, 126, 15);
		contentPane.add(YHJL);
		YHJL.setText(MainFrm.getStr2());
	}
	public void flush() {
		Xmtf.setText("");
		Xbtf.setText("");
		Xltf.setText("");
		Dhtf.setText("");
		textField.setText("");
	}
	public static void setID(String id) {
		ID=id;
	}
}