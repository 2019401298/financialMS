package cn.edu.jsu.lyl.frm;
/**
 * ���ӹ�˾������������
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.lyl.dao.Stuoperate;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Commanagefrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modell;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Commanagefrm frame = new Commanagefrm();
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
	public Commanagefrm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 621, 341);
		contentPane.add(scrollPane);
		
		
		JButton CZJTB = new JButton("����");
		CZJTB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addbns ab=new Addbns();
				ab.setVisible(true);
			}
		});
		CZJTB.setBounds(343, 372, 93, 23);
		contentPane.add(CZJTB);
		
		JButton CGXJT = new JButton("����");
		CGXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modell.getDataVector().clear();
				JCheckBox box = new JCheckBox();
				DefaultTableModel dtm2=(DefaultTableModel)table.getModel();//��ȡ���ģ��
				Stuoperate.initTable3(modell);
				table.updateUI();//������ʾ
			}
		});
		CGXJT.setBounds(485, 372, 93, 23);
		contentPane.add(CGXJT);
		
		// =====�������======
		String[] title = { "��Ŀ", "֧��(Ԫ)", "����(Ԫ)","��ע" ,"ʱ��","������"};
		modell = new DefaultTableModel(title, 0);// ����������ģ�͵ı����������(Ϊ0��)
		Stuoperate.initTable3(modell);// ���÷���װ������
		table = new JTable(modell) {

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {// ���õ�1�в��ɱ༭
					return false;
				}
				return true;
			}
		};// ʵ�������װ�ر��ģ��ʵ��
		scrollPane.setViewportView(table);
	}
}
