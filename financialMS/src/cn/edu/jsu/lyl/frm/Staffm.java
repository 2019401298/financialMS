package cn.edu.jsu.lyl.frm;
/**
 * ����Ա����ְԱ��Ϣ����
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.lyl.Efrm.Updatepersonfrm;
import cn.edu.jsu.lyl.dao.Stuoperate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * ����Ա����ְԱ��Ϣ���棬
 * @author ������
 *
 */
public class Staffm extends JFrame {

	private JPanel contentPane;
	private JTextField CXTF;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staffm frame = new Staffm();
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
	public Staffm() {
		setTitle("ְԱ��Ϣ����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("��ѯ�ؼ���");
		lblNewLabel.setBounds(10, 28, 77, 15);
		contentPane.add(lblNewLabel);

		CXTF = new JTextField();
		CXTF.setBounds(97, 25, 134, 21);
		contentPane.add(CXTF);
		CXTF.setColumns(10);

		JButton CXJT = new JButton("��ѯ");
		CXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// ����������
				table.setRowSorter(sorter);// ���ñ���������
				sorter.setRowFilter(null);
				sorter.setRowFilter(RowFilter.regexFilter(CXTF.getText()));
			}
		});
		CXJT.setBounds(253, 24, 77, 23);
		contentPane.add(CXJT);

		JButton ZJJT = new JButton("����");
		ZJJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registerfrm re = new Registerfrm();
				re.setVisible(true);
			}
		});
		ZJJT.setBounds(340, 24, 77, 23);
		contentPane.add(ZJJT);

		JButton SCJT = new JButton("ɾ��");
		SCJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
					if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "", JOptionPane.YES_NO_OPTION) == 0) {// ȷ�϶Ի���
						int count = table.getSelectedRow();// ��ȡ��ѡ�е��кţ���¼��
						String getname = table.getValueAt(count, 0).toString();// ��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
//						System.out.println(getname + " ");
						model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						Stuoperate.deleteTable(getname);
						JOptionPane.showMessageDialog(null, "����ɾ���ɹ�");
						// �ӱ��������ɾ����,modelΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
					}
				} else {
					JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ������");
				}
			}
		});
		SCJT.setBounds(427, 24, 77, 23);
		contentPane.add(SCJT);

		JButton XGJT = new JButton("�޸�");
		XGJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
					if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�޸�������", "", JOptionPane.YES_NO_OPTION) == 0) {// ȷ�϶Ի���
						int count = table.getSelectedRow();// ��ȡ��ѡ�е��кţ���¼��
						String getname = table.getValueAt(count, 0).toString();// ��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
						Updatepersonfrm updp=new Updatepersonfrm();
						Updatepersonfrm.setID(getname);
						updp.setVisible(true);

					}
				} else {
					JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ���");
				}
			}
		});
		XGJT.setBounds(514, 24, 77, 23);
		contentPane.add(XGJT);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 669, 315);
		contentPane.add(scrollPane);

		// =====�������======
		String[] title = { "���", "����", "�Ա�", "ѧ��", "��¼����", "�绰����" };
		model = new DefaultTableModel(title, 0);// ����������ģ�͵ı����������(Ϊ0��)
		Stuoperate.initTable(model);// ���÷���װ������
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

		JButton SXJT = new JButton("����");
		SXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.getDataVector().clear();
				JCheckBox box = new JCheckBox();
				DefaultTableModel dtm2=(DefaultTableModel)table.getModel();//��ȡ���ģ��
				Stuoperate.initTable(model);
				table.updateUI();//������ʾ
//				model.getDataVector().clear();
//				Stuoperate.initTable(model);// ���÷���װ������
			}
		});
		SXJT.setBounds(602, 24, 77, 23);
		contentPane.add(SXJT);
	}

}
