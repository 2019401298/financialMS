package cn.edu.jsu.lyl.frm;
/**
 * ����˾��������������
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
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Addbns extends JFrame {

	private JPanel contentPane;
	private JTextField XMJL;
	private JTextField ZCJF;
	private JTextField BSRJF;
	private JTextField BZJF;
	private JLabel XMJL1;
	private JLabel ZCJL1;
	private JLabel SRJL1;
	private JLabel BZJL1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbns frame = new Addbns();
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
	public Addbns() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 361, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9879\u76EE");
		lblNewLabel.setBounds(10, 24, 54, 15);
		contentPane.add(lblNewLabel);
		
		XMJL = new JTextField();
		XMJL.setBounds(74, 21, 135, 21);
		contentPane.add(XMJL);
		XMJL.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u652F\u51FA");
		lblNewLabel_1.setBounds(10, 66, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		ZCJF = new JTextField();
		ZCJF.setBounds(74, 63, 135, 21);
		contentPane.add(ZCJF);
		ZCJF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6536\u5165");
		lblNewLabel_2.setBounds(10, 111, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		BSRJF = new JTextField();
		BSRJF.setText("");
		BSRJF.setBounds(74, 108, 135, 21);
		contentPane.add(BSRJF);
		BSRJF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5907\u6CE8");
		lblNewLabel_3.setBounds(10, 160, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		BZJF = new JTextField();
		BZJF.setBounds(74, 157, 135, 21);
		contentPane.add(BZJF);
		BZJF.setColumns(10);
		
		XMJL1 = new JLabel("");
		XMJL1.setForeground(Color.RED);
		XMJL1.setBounds(221, 25, 82, 15);
		contentPane.add(XMJL1);
		
		ZCJL1 = new JLabel("");
		ZCJL1.setForeground(Color.RED);
		ZCJL1.setBounds(219, 66, 82, 15);
		contentPane.add(ZCJL1);
		
		SRJL1 = new JLabel("");
		SRJL1.setForeground(Color.RED);
		SRJL1.setBounds(221, 111, 82, 15);
		contentPane.add(SRJL1);
		
		BZJL1 = new JLabel("");
		BZJL1.setForeground(Color.RED);
		BZJL1.setBounds(219, 160, 82, 15);
		contentPane.add(BZJL1);
		
		JButton THJB1 = new JButton("\u63D0\u4EA4");
		THJB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cheakA()&&cheakB()&&cheakC()&&cheakD()) {
					Date now = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");// ���Է�����޸����ڸ�ʽ
					String hehe = dateFormat.format(now);
					DatabaseConnection dbconn = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
					String sql="INSERT INTO business(proname,putinto,income,time,note,prici) VALUES(?,?,?,?,?,?)";
					try (Connection conn = dbconn.getConnection(); // ��ȡ���ݿ��
							java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);){
						pstmt.setString(1, XMJL.getText());
						pstmt.setString(2, ZCJF.getText());
						pstmt.setString(3, BSRJF.getText());
						pstmt.setString(4, hehe);
						pstmt.setString(5, BZJF.getText());
						pstmt.setString(6, putName());
						pstmt.executeUpdate();// ����ִ�в������
						JOptionPane.showMessageDialog(null, "��ӳɹ�");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		THJB1.setBounds(74, 207, 93, 23);
		contentPane.add(THJB1);
	}
	public boolean cheakA() {
		if (XMJL.getText().length() == 0) {
			XMJL1.setText("����Ϊ��");
			XMJL.requestFocus();
			return false;
		}
		return true;
	}
	public boolean cheakB() {
		if (ZCJF.getText().length() == 0) {
			ZCJL1.setText("����Ϊ��");
			ZCJF.requestFocus();
			return false;
		}
		return true;
	}
	public boolean cheakC() {
		if (BSRJF.getText().length() == 0) {
			SRJL1.setText("����Ϊ��");
			BSRJF.requestFocus();
			return false;
		}
		return true;
	}
	public boolean cheakD() {
		if (BZJF.getText().length() == 0) {
			BZJL1.setText("����Ϊ��");
			BZJF.requestFocus();
			return false;
		}
		return true;
	}
	
	public String putName() {
		String str=MainFrm.getStr3();
		DatabaseConnection dbconn = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
		String sql="select * from Managedate";
		try (Connection conn1 = dbconn.getConnection(); // ��ȡ���ݿ��
				Statement stm1=conn1.createStatement();
				 ResultSet rs=stm1.executeQuery(sql)){
			while(rs.next()) {
				if(rs.getString("Mid").equals(str)) {
					return rs.getString("Mid")+","+rs.getString("Mname");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
