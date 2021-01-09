package cn.edu.jsu.lyl.dao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * IO�ļ�����
 * @author ������
 *
 */
public class IOfIlefrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField CXJF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IOfIlefrm frame = new IOfIlefrm();
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
	public IOfIlefrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 618, 383);
		contentPane.add(scrollPane);
		
		// =======�������===========
		String[] title = { "���", "����", "�Ա�" ,"ѧ��","�绰"};// ���������ʾ������
		DefaultTableModel model = new DefaultTableModel(title, 0);// ����������ģ�͵ı����������(Ϊ0��)
		Stuoperate.initTable8(model);
		table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {// ���õ�1�в��ɱ༭
					return false;
				}
				return true;
			}
		};// ʵ�������װ�ر��ģ��ʵ��
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u5173\u952E\u5B57\uFF1A");
		lblNewLabel.setBounds(23, 425, 80, 15);
		contentPane.add(lblNewLabel);
		
		CXJF = new JTextField();
		CXJF.setBounds(114, 422, 120, 21);
		contentPane.add(CXJF);
		CXJF.setColumns(10);
		
		JButton CXJT = new JButton("\u67E5\u8BE2");
		CXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// ����������
				table.setRowSorter(sorter);// ���ñ���������
				sorter.setRowFilter(null);
				sorter.setRowFilter(RowFilter.regexFilter(CXJF.getText()));
			}
		});
		CXJT.setBounds(245, 421, 93, 23);
		contentPane.add(CXJT);
		
		JButton ZJJT = new JButton("\u589E\u52A0");
		ZJJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stuoperate.GXtable(model);
			}
		});
		ZJJT.setBounds(358, 421, 93, 23);
		contentPane.add(ZJJT);
		
		JButton SCJT = new JButton("\u5220\u9664");
		SCJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
					if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "", JOptionPane.YES_NO_OPTION) == 0) {// ȷ�϶Ի���
						model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						Stuoperate.deleteTable(model);
						JOptionPane.showMessageDialog(null, "���ݸ��³ɹ�");
						// �ӱ��������ɾ����,modelΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
					} else {
						JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ������");
					}
				}
			}
		});
		SCJT.setBounds(471, 421, 93, 23);
		contentPane.add(SCJT);
	}
}
