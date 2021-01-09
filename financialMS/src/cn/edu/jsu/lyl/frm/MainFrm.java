package cn.edu.jsu.lyl.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lyl.Efrm.Domesticfrm;
import cn.edu.jsu.lyl.dao.VerifyCode;
import cn.edu.jsu.lyl.dbc.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
/**
 * �����棬������¼��ע��
 * @author ������
 *
 */
public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JTextField YHMtextField;
	private JTextField MMtextField;
	private JTextField YZMTF;
	private String s1 = null;
	private JLabel YZMLAB;
	private JLabel YHMJL1;
	private JLabel MMJL1;
	private JLabel YZMTS;
	private JRadioButton PTJR;
	private JRadioButton GLJR;
	private JLabel sexJL;
	private static String stra = null;
	private static String stra1=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setLocationRelativeTo(null);// �������
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
	public MainFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/cn/edu/jsu/lyl/frm/q1.png")));
		setTitle("����¼����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel TPJL = new JLabel("");
		TPJL.setIcon(new ImageIcon(MainFrm.class.getResource("/cn/edu/jsu/lyl/frm/zzpic.jpg")));
		TPJL.setBounds(0, 0, 582, 304);
		contentPane.add(TPJL);

		JLabel YHMJL = new JLabel("�û���");
		YHMJL.setBounds(10, 320, 51, 22);
		contentPane.add(YHMJL);

		YHMtextField = new JTextField();
		YHMtextField.setBounds(69, 321, 136, 21);
		contentPane.add(YHMtextField);
		YHMtextField.setColumns(10);

		JLabel MMJL = new JLabel("����");
		MMJL.setBounds(10, 367, 32, 15);
		contentPane.add(MMJL);

		MMtextField = new JTextField();
		MMtextField.setBounds(69, 364, 136, 21);
		contentPane.add(MMtextField);
		MMtextField.setColumns(10);

		PTJR = new JRadioButton("��ͨ�û�");
		PTJR.setBounds(326, 320, 88, 23);
		contentPane.add(PTJR);

		GLJR = new JRadioButton("����Ա");
		GLJR.setBounds(326, 363, 83, 23);
		contentPane.add(GLJR);
		ButtonGroup bg = new ButtonGroup();// ʵ�ֵ�ѡ����
		bg.add(PTJR);
		bg.add(GLJR);

		JButton DLBT = new JButton("��¼");
		DLBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cheakInputID() && cheakInputMM() && cheakInputsex()) {
					if (cheakInputYZM()) {
						if (((JRadioButton) PTJR).isSelected()) {
							if (cheakInputYZ()) {
								Domesticfrm dofrm = new Domesticfrm();
								dofrm.setVisible(true);
							} else {
								MMJL1.setText("�������");
							}
						} else if (((JRadioButton) GLJR).isSelected()) {
							if (cheakInputYZ2()) {
								Admistfrm adm = new Admistfrm();
								stra1=YHMtextField.getText();
								adm.setVisible(true);
							}
						}

					} else {
						YZMTS.setText("��֤�����");
						YZMTF.requestFocus();
					}

				}
			}
		});
		DLBT.setBackground(Color.CYAN);
		DLBT.setFont(new Font("����", Font.PLAIN, 17));
		DLBT.setForeground(Color.BLACK);
		DLBT.setBounds(69, 459, 136, 36);
		contentPane.add(DLBT);

		JButton btnNewButton = new JButton("ע���û�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registerfrm frm1 = new Registerfrm();
				frm1.setVisible(true);
			}
		});
		btnNewButton.setBounds(255, 467, 136, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("��֤��");
		lblNewLabel.setBounds(10, 415, 54, 15);
		contentPane.add(lblNewLabel);

		YZMTF = new JTextField();
		YZMTF.setBounds(69, 412, 73, 21);
		contentPane.add(YZMTF);
		YZMTF.setColumns(10);

		JButton YZMButton_1 = new JButton("����");
		YZMButton_1.setForeground(Color.BLACK);
		YZMButton_1.setBounds(240, 411, 68, 23);
		contentPane.add(YZMButton_1);
		YZMButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerifyCode vc = new VerifyCode();
				s1 = vc.runVerifyCode(4);
				YZMLAB.setText(s1);
			}
		});

		YZMLAB = new JLabel(s1);
		YZMLAB.setFont(new Font("����", Font.PLAIN, 25));
		YZMLAB.setForeground(Color.RED);
		YZMLAB.setBounds(152, 404, 73, 36);
		contentPane.add(YZMLAB);

		YHMJL1 = new JLabel("");
		YHMJL1.setForeground(Color.RED);
		YHMJL1.setBounds(215, 324, 83, 15);
		contentPane.add(YHMJL1);

		MMJL1 = new JLabel("");
		MMJL1.setForeground(Color.RED);
		MMJL1.setBounds(215, 367, 83, 15);
		contentPane.add(MMJL1);

		YZMTS = new JLabel("");
		YZMTS.setForeground(Color.RED);
		YZMTS.setBounds(326, 415, 83, 15);
		contentPane.add(YZMTS);

		sexJL = new JLabel("");
		sexJL.setForeground(Color.RED);
		sexJL.setBounds(427, 344, 88, 22);
		contentPane.add(sexJL);
	}

	/*
	 * ��֤�������ı�����Ϊ��
	 */
	// ��Ź淶��
	public boolean cheakInputID() {
		if (YHMtextField.getText().length() == 0) {
			YHMJL1.setText("����Ϊ��");
			YHMtextField.requestFocus();
			return false;
		}
		return true;
	}

	/*
	 * ��֤�������ı�����Ϊ��
	 */
	// ����淶��
	public boolean cheakInputMM() {
		if (MMtextField.getText().length() == 0) {
			MMJL1.setText("����Ϊ��");
			MMtextField.requestFocus();
			return false;
		}
		return true;
	}
/*
 * ��֤�������ı�����Ϊ��
 */
	// ѡ���û��淶��
	public boolean cheakInputsex() {
		if (!((JRadioButton) PTJR).isSelected()) {
			if (!((JRadioButton) GLJR).isSelected()) {
				sexJL.setText("����Ϊ��");
				return false;
			}
		}
		return true;
	}
	/*
	 * ��֤�벻��Ϊ��
	 */
	public boolean cheakInputYZM() {// ��֤����֤��¼
		if (!YZMTF.getText().equalsIgnoreCase(s1)) {
			return false;
		}
		return true;
	}

	/*
	 * ְԱ��¼����
	 */
	public boolean cheakInputYZ() {// ְԱ��֤��¼��֤��¼
		DatabaseConnection dbconn = new DatabaseConnection();// ���ݿ�����
		String sql = "SELECT* from Employee";
		try (Connection conn = dbconn.getConnection();
				Statement stme = conn.createStatement();
				ResultSet rs = stme.executeQuery(sql);) {
			String ID = null;
			String password = null;
			while (rs.next()) {
				ID = rs.getString("eid");
				password = rs.getString("password");
				if ((YHMtextField.getText()).equals(ID) && (MMtextField.getText()).equals(password)) {
					stra = ID;
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*
	 *����Ա��֤��¼
	 */
	public boolean cheakInputYZ2() {// ����Ա��֤
		DatabaseConnection dbconn = new DatabaseConnection();// ���ݿ�����
		String sql = "SELECT* from Managedate";
		try (Connection conn = dbconn.getConnection();
				Statement stme = conn.createStatement();
				ResultSet rs = stme.executeQuery(sql);) {
			String ID = null;
			String password = null;
			while (rs.next()) {
				ID = rs.getString("Mid");
				password = rs.getString("Mpassword");
				if ((YHMtextField.getText()).equals(ID) && (MMtextField.getText()).equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static String getStr2() {
		return stra;
	}
	public static String getStr3() {
		return stra1;
	}
}
