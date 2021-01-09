package cn.edu.jsu.lyl.Efrm;
/**
 * ְԱ��¼����ʾ�Ľ���
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lyl.dbc.DatabaseConnection;
import cn.edu.jsu.lyl.frm.MainFrm;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Domesticfrm extends JFrame {

	private JPanel contentPane;
	private JTextField JETF;
	private static String XM = null;
	private static String ID = null;
	private static String XB = null;
	private static String DH = null;
	private JTextField reasonTF;
	private JLabel JEJL;
	private JLabel YYJL;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Domesticfrm frame = new Domesticfrm();
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
	public Domesticfrm() {
		cheakInputYZ();
		setTitle("������Ϣ");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Domesticfrm.class.getResource("/cn/edu/jsu/lyl/frm/yonghu.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ����HIDE_ON_CLOSE��
		setBounds(100, 100, 288, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel XMJL = new JLabel();
		XMJL.setForeground(Color.BLUE);
		XMJL.setBounds(80, 25, 99, 24);
		XMJL.setText(XM);
		contentPane.add(XMJL);

		JLabel lblNewLabel = new JLabel("��ã�");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 25, 60, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID��ţ�");
		lblNewLabel_1.setBounds(10, 70, 54, 15);

		contentPane.add(lblNewLabel_1);

		JLabel IDJL = new JLabel();
		IDJL.setForeground(Color.BLUE);
		IDJL.setBounds(80, 70, 99, 15);
		IDJL.setText(ID);
		contentPane.add(IDJL);

		JLabel lblNewLabel_2 = new JLabel("�Ա�");
		lblNewLabel_2.setBounds(10, 109, 54, 15);
		contentPane.add(lblNewLabel_2);

		JLabel XBJL = new JLabel(XB);
		XBJL.setForeground(Color.BLUE);
		XBJL.setBounds(80, 109, 99, 15);
		XBJL.setText(XB);
		contentPane.add(XBJL);

		JLabel lblNewLabel_3 = new JLabel("�绰");
		lblNewLabel_3.setBounds(10, 144, 54, 15);
		contentPane.add(lblNewLabel_3);

		JLabel PHJL = new JLabel(DH);
		PHJL.setForeground(Color.BLUE);
		PHJL.setBounds(80, 144, 99, 15);
		PHJL.setText(DH);
		contentPane.add(PHJL);

		JButton Updata = new JButton("�޸ĸ�����Ϣ");
		Updata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updatepersonfrm up = new Updatepersonfrm();
				Updatepersonfrm.setID(ID);
				up.setVisible(true);
			}
		});
		Updata.setBounds(10, 320, 110, 42);
		contentPane.add(Updata);

		JButton btnNewButton = new JButton("�鹤��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GongziFrm gm=new GongziFrm();
				gm.setVisible(true);
			}
		});
		btnNewButton.setBounds(144, 320, 120, 42);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_4 = new JLabel("����֧����¼");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(80, 170, 120, 24);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u91D1\u989D(\u5143)\uFF1A");
		lblNewLabel_5.setBounds(10, 200, 60, 15);
		contentPane.add(lblNewLabel_5);

		JETF = new JTextField();
		JETF.setBounds(80, 197, 120, 21);
		contentPane.add(JETF);
		JETF.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("ԭ��");
		lblNewLabel_6.setBounds(10, 243, 54, 15);
		contentPane.add(lblNewLabel_6);

		JButton TJBT = new JButton("�ύ");
		TJBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cheakInputJE() && cheakInputYY()) {
					String mo = JETF.getText();
					String reas = reasonTF.getText();

					Date now = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");// ���Է�����޸����ڸ�ʽ
					String hehe = dateFormat.format(now);

					String sql = "INSERT INTO record(eid,name,sex,phone,money,reason,time) VALUES(?,?,?,?,?,?,?)";
					DatabaseConnection dbconn1 = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
					try (Connection conn1 = dbconn1.getConnection(); // ��ȡ���ݿ�����
							java.sql.PreparedStatement pstmt1 = conn1.prepareStatement(sql);) {
						pstmt1.setString(1, ID);
						pstmt1.setString(2, XM);
						pstmt1.setString(3, XB);
						pstmt1.setString(4, DH);
						pstmt1.setString(5, mo);
						pstmt1.setString(6, reas);
						pstmt1.setString(7, hehe);
						pstmt1.executeUpdate();// ����ִ�в������

						JOptionPane.showMessageDialog(null, "��ӳɹ�");
						flush();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		TJBT.setBounds(86, 276, 93, 23);
		contentPane.add(TJBT);

		reasonTF = new JTextField();
		reasonTF.setBounds(80, 240, 120, 21);
		contentPane.add(reasonTF);
		reasonTF.setColumns(10);

		JEJL = new JLabel("");
		JEJL.setForeground(Color.RED);
		JEJL.setBounds(210, 200, 62, 15);
		contentPane.add(JEJL);

		YYJL = new JLabel("");
		YYJL.setForeground(Color.RED);
		YYJL.setBounds(210, 243, 60, 15);
		contentPane.add(YYJL);
	}

	public void flush() {
		JETF.setText("");
		reasonTF.setText("");
		JEJL.setText("");
		YYJL.setText("");
	}

	public static void cheakInputYZ() {
		DatabaseConnection dbconn = new DatabaseConnection();// ���ݿ�����
		String sql = "SELECT* from Employee";
		try (Connection conn = dbconn.getConnection();
				Statement stme = conn.createStatement();
				ResultSet rs = stme.executeQuery(sql);) {
			String AD = MainFrm.getStr2();
			while (rs.next()) {
				String SD = rs.getString("eid");
				if (AD.equals(SD)) {
					XM = rs.getString("name");
					ID = rs.getString("eid");
					XB = rs.getString("sex");
					DH = rs.getString("phone");
					return;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ����淶��
	public boolean cheakInputJE() {
		if (JETF.getText().length() == 0) {
			JEJL.setText("����Ϊ��");
			JETF.requestFocus();
			return false;
		}
		return true;
	}

	// ԭ���淶��
	public boolean cheakInputYY() {
		if (reasonTF.getText().length() == 0) {
			YYJL.setText("����Ϊ��");
			reasonTF.requestFocus();
			return false;
		}
		return true;
	}

}
