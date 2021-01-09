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
	public Registerfrm() {
		setTitle("Ա��ע�����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel YGJLAB = new JLabel("Ա�����");
		YGJLAB.setBounds(10, 187, 54, 15);
		contentPane.add(YGJLAB);

		IDJF = new JTextField();
		IDJF.setBounds(74, 184, 132, 21);
		contentPane.add(IDJF);
		IDJF.setColumns(10);

		JLabel XMJL = new JLabel("����");
		XMJL.setBounds(10, 221, 54, 15);
		contentPane.add(XMJL);

		XMTF = new JTextField();
		XMTF.setBounds(74, 218, 132, 21);
		contentPane.add(XMTF);
		XMTF.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("�Ա�");
		lblNewLabel_1.setBounds(10, 261, 54, 15);
		contentPane.add(lblNewLabel_1);

		rdbtnNewRadioButton = new JRadioButton("��");
		rdbtnNewRadioButton.setBounds(70, 257, 37, 23);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Ů");
		rdbtnNewRadioButton_1.setBounds(152, 257, 54, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		ButtonGroup bg = new ButtonGroup();// ʵ�ֵ�ѡ����
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_2 = new JLabel("ѧ��");
		lblNewLabel_2.setBounds(10, 306, 54, 15);
		contentPane.add(lblNewLabel_2);

		XLJF = new JTextField();
		XLJF.setBounds(74, 303, 132, 21);
		contentPane.add(XLJF);
		XLJF.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("��¼����");
		lblNewLabel_3.setBounds(10, 343, 54, 15);
		contentPane.add(lblNewLabel_3);

		DLTF = new JTextField();
		DLTF.setBounds(74, 340, 132, 21);
		contentPane.add(DLTF);
		DLTF.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("�绰����");
		lblNewLabel_4.setBounds(10, 381, 54, 15);
		contentPane.add(lblNewLabel_4);

		phoneTF = new JTextField();
		phoneTF.setBounds(74, 378, 132, 21);
		contentPane.add(phoneTF);
		phoneTF.setColumns(10);

		JButton btnNewButton = new JButton("���");
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
					DatabaseConnection dbconn = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
					try (Connection conn = dbconn.getConnection(); // ��ȡ���ݿ��
							java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);) {
						pstmt.setString(1, ID);// �����1��ռλ��������
						pstmt.setString(2, XM);// �����2��ռλ��������
						pstmt.setString(3, XB);// �����3��ռλ��������
						pstmt.setString(4, XL);// �����4��ռλ��������
						pstmt.setString(5, DLMM);// �����5��ռλ��������
						pstmt.setString(6, ph);// �����6��ռλ��������
//						pstmt.addBatch();// ����������ȴ�ִ��
						pstmt.executeUpdate();// ����ִ�в������
						
						JOptionPane.showMessageDialog(null, "ע��ɹ�");
						flush();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
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

	//ˢ��
	public void flush() {
		IDJF.setText("");
		XMTF.setText("");
		rdbtnNewRadioButton.setText("");
		rdbtnNewRadioButton_1.setText("");
		XLJF.setText("");
		DLTF.setText("");
		phoneTF.setText("");
	}
	
	// ��Ź淶��
	public boolean cheakInputID() {
		if (IDJF.getText().length() == 0) {// ��ȡID����������
			IDJL.setText("����Ϊ��");
			IDJF.requestFocus();// ID������ȡ����
			return false;
		}
		return true;
	}

	// �����淶��
	public boolean cheakInputXM() {
		if (XMTF.getText().length() == 0) {
			XMJL1.setText("����Ϊ��");
			XMTF.requestFocus();
			return false;
		}
		return true;
	}

	// ��¼����淶��
	public boolean cheakInputDL() {
		if (DLTF.getText().length() == 0) {
			DLJL.setText("����Ϊ��");
			DLTF.requestFocus();
			return false;
		}
		return true;
	}

	// �绰����淶��
	public boolean cheakInputPhone() {
		if (phoneTF.getText().length() == 0) {
			TPJL.setText("����Ϊ��");
			phoneTF.requestFocus();
			return false;
		}
		return true;
	}
}
