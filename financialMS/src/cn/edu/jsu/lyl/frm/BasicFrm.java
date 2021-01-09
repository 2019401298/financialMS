package cn.edu.jsu.lyl.frm;
/**
 * ����Ա����Ա�����ʽ���
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.lyl.dao.Stuoperate;
import cn.edu.jsu.lyl.dao.TotalMoney;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasicFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modell;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton QCXJB;
	private JButton QXGJB;
	private JButton QGXJB;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicFrm frame = new BasicFrm();
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
	public BasicFrm() {
		setTitle("\u5458\u5DE5\u5DE5\u8D44\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 966, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 932, 360);
		contentPane.add(scrollPane);
		
		// =====�������======
				String[] title = { "���", "����", "��������", "��ᱣ��", "��ͨ����", "ͨѶ����","��Ч����","����˰��","�Ӱ�����","�Ӱ๤��","ȱ�ڴ���","�۳�����","�ܼ�" };
				modell = new DefaultTableModel(title, 0);// ����������ģ�͵ı����������(Ϊ0��)
				Stuoperate.initTable4(modell);// ���÷���װ������
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
				
				lblNewLabel = new JLabel("����ؼ���");
				lblNewLabel.setBounds(10, 401, 75, 15);
				contentPane.add(lblNewLabel);
				
				textField = new JTextField();
				textField.setBounds(97, 398, 130, 21);
				contentPane.add(textField);
				textField.setColumns(10);
				
				QCXJB = new JButton("��ѯ");
				QCXJB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(modell);// ����������
						table.setRowSorter(sorter);// ���ñ���������
						sorter.setRowFilter(null);
						sorter.setRowFilter(RowFilter.regexFilter(textField.getText()));
					}
				});
				QCXJB.setBounds(244, 397, 93, 23);
				contentPane.add(QCXJB);
				
				QXGJB = new JButton("�޸�");
				QXGJB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫ����
						int count = table.getSelectedRow();// ��ȡ��ѡ�е��кţ���¼��
						String getname = table.getValueAt(count, 0).toString();// ��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
						//System.out.println(getname+" "+"qqq");
						fUpdataFrm.setStr(getname);
						fUpdataFrm fu=new fUpdataFrm();
						fu.setVisible(true);
						}else
						{
							JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ���");
						}
					}
				});
				QXGJB.setBounds(375, 397, 93, 23);
				contentPane.add(QXGJB);
				
				QGXJB = new JButton("����");
				QGXJB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modell.getDataVector().clear();
						JCheckBox box = new JCheckBox();
						DefaultTableModel dtm2=(DefaultTableModel)table.getModel();//��ȡ���ģ��
						Stuoperate.initTable4(modell);
						table.updateUI();//������ʾ
					}
				});
				QGXJB.setBounds(515, 397, 93, 23);
				contentPane.add(QGXJB);
				
				btnNewButton = new JButton("\u7EDF\u8BA1\u5458\u5DE5\u5DE5\u8D44");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TotalMoney.charu();
						JOptionPane.showMessageDialog(null, "ͳ�Ƴɹ�");
					}
				});
				btnNewButton.setBounds(646, 397, 146, 23);
				contentPane.add(btnNewButton);
	}

}
