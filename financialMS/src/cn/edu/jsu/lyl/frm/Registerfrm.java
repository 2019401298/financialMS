package cn.edu.jsu.lyl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registerfrm extends JFrame {

	private JPanel contentPane;
	private JTextField IDJF;
	private JTextField XMTF;
	private JTextField XLJF;
	private JTextField DLTF;
	private JTextField phoneTF;
	private JLabel IDJL;
	private JLabel XMJL1;
	private JLabel DLJL;
	private JLabel TPJL;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registerfrm frame = new Registerfrm();
					frame.setLocationRelativeTo(null);// 窗体居中
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
	public Registerfrm() {
		setTitle("员工注册界面");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel YGJLAB = new JLabel("员工编号");
		YGJLAB.setBounds(10, 187, 54, 15);
		contentPane.add(YGJLAB);

		IDJF = new JTextField();
		IDJF.setBounds(74, 184, 132, 21);
		contentPane.add(IDJF);
		IDJF.setColumns(10);

		JLabel XMJL = new JLabel("姓名");
		XMJL.setBounds(10, 221, 54, 15);
		contentPane.add(XMJL);

		XMTF = new JTextField();
		XMTF.setBounds(74, 218, 132, 21);
		contentPane.add(XMTF);
		XMTF.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("性别");
		lblNewLabel_1.setBounds(10, 261, 54, 15);
		contentPane.add(lblNewLabel_1);

		rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(70, 257, 37, 23);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(152, 257, 54, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		ButtonGroup bg = new ButtonGroup();// 实现单选操作
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_2 = new JLabel("学历");
		lblNewLabel_2.setBounds(10, 306, 54, 15);
		contentPane.add(lblNewLabel_2);

		XLJF = new JTextField();
		XLJF.setBounds(74, 303, 132, 21);
		contentPane.add(XLJF);
		XLJF.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("登录密码");
		lblNewLabel_3.setBounds(10, 343, 54, 15);
		contentPane.add(lblNewLabel_3);

		DLTF = new JTextField();
		DLTF.setBounds(74, 340, 132, 21);
		contentPane.add(DLTF);
		DLTF.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("电话号码");
		lblNewLabel_4.setBounds(10, 381, 54, 15);
		contentPane.add(lblNewLabel_4);

		phoneTF = new JTextField();
		phoneTF.setBounds(74, 378, 132, 21);
		contentPane.add(phoneTF);
		phoneTF.setColumns(10);

		JButton btnNewButton = new JButton("完成");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cheakInputID() && cheakInputXM() && cheakInputPhone()) {
					String ID = IDJF.getText();
					String XM = XMTF.getText();
					String XB = null;
					if (((JRadioButton) rdbtnNewRadioButton).isSelected()) {
						XB = ((JRadioButton) rdbtnNewRadioButton).getText();
					} else if (((JRadioButton) rdbtnNewRadioButton_1).isSelected()) {
						XB = ((JRadioButton) rdbtnNewRadioButton_1).getText();
					}
					String XL = XLJF.getText();
					String DLMM = DLTF.getText();
					String ph = phoneTF.getText();
					String sql = "INSERT INTO Employee(eid,name,sex,eduback,password,phone) VALUES(?,?,?,?,?,?)";
					DatabaseConnection dbconn = new DatabaseConnection();// 使用1中定义的连接数据库的类
					try (Connection conn = dbconn.getConnection(); // 获取数据库接
							java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);) {
						pstmt.setString(1, ID);// 定义第1个占位符的内容
						pstmt.setString(2, XM);// 定义第2个占位符的内容
						pstmt.setString(3, XB);// 定义第3个占位符的内容
						pstmt.setString(4, XL);// 定义第4个占位符的内容
						pstmt.setString(5, DLMM);// 定义第5个占位符的内容
						pstmt.setString(6, ph);// 定义第6个占位符的内容
//						pstmt.addBatch();// 加入批处理等待执行
						pstmt.executeUpdate();// 批量执行插入操作
						
						JOptionPane.showMessageDialog(null, "注册成功");
						flush();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(94, 415, 112, 37);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Registerfrm.class.getResource("/cn/edu/jsu/lyl/frm/zhuce5.jpg")));
		lblNewLabel.setBounds(0, 0, 350, 177);
		contentPane.add(lblNewLabel);

		IDJL = new JLabel("");
		IDJL.setForeground(Color.RED);
		IDJL.setBounds(216, 187, 100, 15);
		contentPane.add(IDJL);

		XMJL1 = new JLabel("");
		XMJL1.setForeground(Color.RED);
		XMJL1.setBounds(216, 221, 100, 15);
		contentPane.add(XMJL1);

		DLJL = new JLabel("");
		DLJL.setForeground(Color.RED);
		DLJL.setBounds(216, 343, 100, 15);
		contentPane.add(DLJL);

		TPJL = new JLabel("");
		TPJL.setForeground(Color.RED);
		TPJL.setBounds(216, 381, 100, 15);
		contentPane.add(TPJL);
	}

	//刷新
	public void flush() {
		IDJF.setText("");
		XMTF.setText("");
		rdbtnNewRadioButton.setText("");
		rdbtnNewRadioButton_1.setText("");
		XLJF.setText("");
		DLTF.setText("");
		phoneTF.setText("");
	}
	
	// 编号规范化
	public boolean cheakInputID() {
		if (IDJF.getText().length() == 0) {// 获取ID输入框的内容
			IDJL.setText("不能为空");
			IDJF.requestFocus();// ID输入框获取焦点
			return false;
		}
		return true;
	}

	// 姓名规范性
	public boolean cheakInputXM() {
		if (XMTF.getText().length() == 0) {
			XMJL1.setText("不能为空");
			XMTF.requestFocus();
			return false;
		}
		return true;
	}

	// 登录密码规范性
	public boolean cheakInputDL() {
		if (DLTF.getText().length() == 0) {
			DLJL.setText("不能为空");
			DLTF.requestFocus();
			return false;
		}
		return true;
	}

	// 电话号码规范性
	public boolean cheakInputPhone() {
		if (phoneTF.getText().length() == 0) {
			TPJL.setText("不能为空");
			phoneTF.requestFocus();
			return false;
		}
		return true;
	}
}
