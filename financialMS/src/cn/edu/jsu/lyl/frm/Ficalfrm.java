package cn.edu.jsu.lyl.frm;
/**
 * ����Ա����ְԱ����ı�����¼
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
 * ����Ա����ְԱ����ı�����¼
 * @author ������
 *
 */
public class Ficalfrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel modell;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficalfrm frame = new Ficalfrm();
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
	public Ficalfrm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("����ؼ���");
		lblNewLabel.setBounds(10, 21, 73, 15);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(93, 18, 98, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton FCXJT = new JButton("��ѯ");
		FCXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(modell);// ����������
				table.setRowSorter(sorter);// ���ñ���������
				sorter.setRowFilter(null);
				sorter.setRowFilter(RowFilter.regexFilter(textField.getText()));
			}
		});
		FCXJT.setBounds(213, 17, 73, 23);
		contentPane.add(FCXJT);

		JButton FZJJT = new JButton("����");
		FZJJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFacialFrm adf=new AddFacialFrm();
				adf.setVisible(true);
			}
		});
		FZJJT.setBounds(341, 17, 73, 23);
		contentPane.add(FZJJT);

		JButton FSCJT = new JButton("ɾ��");
		FSCJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
					if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "", JOptionPane.YES_NO_OPTION) == 0) {// ȷ�϶Ի���
						int count = table.getSelectedRow();// ��ȡ��ѡ�е��кţ���¼��
						String getname = table.getValueAt(count, 0).toString();// ��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
						String gettime=	table.getValueAt(count, 6).toString();// ��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
//						System.out.println(getname + " ");
						modell.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						Stuoperate.deleteTable2(getname,gettime);
						JOptionPane.showMessageDialog(null, "����ɾ���ɹ�");
						// �ӱ��������ɾ����,modelΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
					}
				} else {
					JOptionPane.showMessageDialog(null,"��ѡ����Ҫɾ������!");
				}
			}
		});
		FSCJT.setBounds(473, 17, 73, 23);
		contentPane.add(FSCJT);

		JButton FGXJT = new JButton("����");
		FGXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modell.getDataVector().clear();
//				JCheckBox box = new JCheckBox();
//				DefaultTableModel dtm2=(DefaultTableModel)table.getModel();//��ȡ���ģ��
				Stuoperate.initTable2(modell);
//				table.updateUI();//������ʾ
//				modell.getDataVector().clear();
//				Stuoperate.initTable2(modell);// ���÷���װ������
			}
		});
		FGXJT.setBounds(603, 17, 73, 23);
		contentPane.add(FGXJT);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 680, 280);
		contentPane.add(scrollPane);

		// =====�������======
		String[] title = { "���", "������", "�Ա�","�绰����" ,"���","ԭ��","ʱ��"};
		modell = new DefaultTableModel(title, 0);// ����������ģ�͵ı����������(Ϊ0��)
		Stuoperate.initTable2(modell);// ���÷���װ������
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
