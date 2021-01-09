package cn.edu.jsu.lyl.frm;
/**
 * 增加财务收支的界面
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddFacialFrm extends JFrame {

	private JPanel contentPane;
	private JTextField ABHJT;
	private JTextField AXMJF;
	private JTextField AXBJF;
	private JTextField ADHJF;
	private JTextField AJETF;
	private JTextField AYYTF;
	private JButton ATJJB;
	private JLabel ABHJL;
	private JLabel ADHJL;
	private JLabel AJEJL;
	private JLabel AYYJL;
	private JLabel AXMJL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFacialFrm frame = new AddFacialFrm();
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
	public AddFacialFrm() {
		setTitle("添加财务收支信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("编号：");
		lblNewLabel.setBounds(10, 33, 54, 15);
		contentPane.add(lblNewLabel);

		ABHJT = new JTextField();
		ABHJT.setBounds(65, 30, 146, 21);
		contentPane.add(ABHJT);
		ABHJT.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(10, 82, 54, 15);
		contentPane.add(lblNewLabel_1);

		AXMJF = new JTextField();
		AXMJF.setBounds(65, 82, 146, 21);
		contentPane.add(AXMJF);
		AXMJF.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("性别：");
		lblNewLabel_2.setBounds(10, 127, 54, 15);
		contentPane.add(lblNewLabel_2);

		AXBJF = new JTextField();
		AXBJF.setBounds(65, 124, 146, 21);
		contentPane.add(AXBJF);
		AXBJF.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("电话：");
		lblNewLabel_3.setBounds(10, 170, 54, 15);
		contentPane.add(lblNewLabel_3);

		ADHJF = new JTextField();
		ADHJF.setText("");
		ADHJF.setBounds(65, 167, 146, 21);
		contentPane.add(ADHJF);
		ADHJF.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("金额：");
		lblNewLabel_4.setBounds(10, 206, 44, 15);
		contentPane.add(lblNewLabel_4);

		AJETF = new JTextField();
		AJETF.setBounds(65, 203, 146, 21);
		contentPane.add(AJETF);
		AJETF.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("原因：");
		lblNewLabel_5.setBounds(10, 246, 54, 15);
		contentPane.add(lblNewLabel_5);

		AYYTF = new JTextField();
		AYYTF.setBounds(65, 243, 146, 21);
		contentPane.add(AYYTF);
		AYYTF.setColumns(10);

		ATJJB = new JButton("提交");
		ATJJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cheakA() && cheakB() && cheakC() && cheakD() && cheakE()) {
					Date now = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");// 可以方便地修改日期格式
					String hehe = dateFormat.format(now);
					String sql = "INSERT INTO record(eid,name,sex,phone,money,reason,time) VALUES(?,?,?,?,?,?,?)";
					DatabaseConnection dbconn = new DatabaseConnection();// 使用1中定义的连接数据库的类
					try (Connection conn = dbconn.getConnection(); // 获取数据库接
							java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);) {
						pstmt.setString(1, ABHJT.getText());
						pstmt.setString(2, AXMJF.getText());
						pstmt.setString(3, AXBJF.getText());
						pstmt.setString(4, ADHJF.getText());
						pstmt.setString(5, AJETF.getText());
						pstmt.setString(6, AYYTF.getText());
						pstmt.setString(7, hehe);
						pstmt.executeUpdate();// 批量执行插入操作
						JOptionPane.showMessageDialog(null, "添加成功");
						flush();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		ATJJB.setBounds(65, 288, 93, 23);
		contentPane.add(ATJJB);

		ABHJL = new JLabel("");
		ABHJL.setForeground(Color.RED);
		ABHJL.setBounds(221, 33, 74, 15);
		contentPane.add(ABHJL);

		AXMJL = new JLabel("");
		AXMJL.setForeground(Color.RED);
		AXMJL.setBounds(221, 82, 74, 15);
		contentPane.add(AXMJL);

		ADHJL = new JLabel("");
		ADHJL.setForeground(Color.RED);
		ADHJL.setBounds(221, 170, 74, 15);
		contentPane.add(ADHJL);

		AJEJL = new JLabel("");
		AJEJL.setForeground(Color.RED);
		AJEJL.setBounds(221, 206, 74, 15);
		contentPane.add(AJEJL);

		AYYJL = new JLabel("");
		AYYJL.setForeground(Color.RED);
		AYYJL.setBounds(221, 246, 74, 15);
		contentPane.add(AYYJL);

	}

	// 密码规范性
	public boolean cheakA() {
		if (ABHJT.getText().length() == 0) {
			ABHJL.setText("不能为空");
			ABHJT.requestFocus();
			return false;
		}
		return true;
	}

	public boolean cheakB() {
		if (AXMJF.getText().length() == 0) {
			AXMJL.setText("不能为空");
			AXMJF.requestFocus();
			return false;
		}
		return true;
	}

	public boolean cheakC() {
		if (ADHJF.getText().length() == 0) {
			ADHJL.setText("不能为空");
			ADHJF.requestFocus();
			return false;
		}
		return true;
	}

	public boolean cheakD() {
		if (AJETF.getText().length() == 0) {
			AJEJL.setText("不能为空");
			AJETF.requestFocus();
			return false;
		}
		return true;
	}

	public boolean cheakE() {
		if (AYYTF.getText().length() == 0) {
			AYYJL.setText("不能为空");
			AYYTF.requestFocus();
			return false;
		}
		return true;
	}

	// 刷新
	public void flush() {
		ABHJT.setText("");
		AXBJF.setText("");
		AXMJF.setText("");
		ADHJF.setText("");
		AJETF.setText("");
		AYYTF.setText("");
	}
}
