package cn.edu.jsu.lyl.frm;
/**
 * 管理员管理职员信息界面
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
 * 管理员管理职员信息界面，
 * @author 罗焰林
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
					frame.setLocationRelativeTo(null);// 窗体居中
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
		setTitle("职员信息管理");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("查询关键字");
		lblNewLabel.setBounds(10, 28, 77, 15);
		contentPane.add(lblNewLabel);

		CXTF = new JTextField();
		CXTF.setBounds(97, 25, 134, 21);
		contentPane.add(CXTF);
		CXTF.setColumns(10);

		JButton CXJT = new JButton("查询");
		CXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// 设置排序器
				table.setRowSorter(sorter);// 设置表格的排序器
				sorter.setRowFilter(null);
				sorter.setRowFilter(RowFilter.regexFilter(CXTF.getText()));
			}
		});
		CXJT.setBounds(253, 24, 77, 23);
		contentPane.add(CXJT);

		JButton ZJJT = new JButton("增加");
		ZJJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registerfrm re = new Registerfrm();
				re.setVisible(true);
			}
		});
		ZJJT.setBounds(340, 24, 77, 23);
		contentPane.add(ZJJT);

		JButton SCJT = new JButton("删除");
		SCJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
					if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "", JOptionPane.YES_NO_OPTION) == 0) {// 确认对话框
						int count = table.getSelectedRow();// 获取你选中的行号（记录）
						String getname = table.getValueAt(count, 0).toString();// 读取你获取行号的某一列的值（也就是字段）
//						System.out.println(getname + " ");
						model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						Stuoperate.deleteTable(getname);
						JOptionPane.showMessageDialog(null, "数据删除成功");
						// 从表格数据中删除行,model为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
					}
				} else {
					JOptionPane.showMessageDialog(null, "请选择你要删除的行");
				}
			}
		});
		SCJT.setBounds(427, 24, 77, 23);
		contentPane.add(SCJT);

		JButton XGJT = new JButton("修改");
		XGJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
					if (JOptionPane.showConfirmDialog(null, "确定要修改数据吗？", "", JOptionPane.YES_NO_OPTION) == 0) {// 确认对话框
						int count = table.getSelectedRow();// 获取你选中的行号（记录）
						String getname = table.getValueAt(count, 0).toString();// 读取你获取行号的某一列的值（也就是字段）
						Updatepersonfrm updp=new Updatepersonfrm();
						Updatepersonfrm.setID(getname);
						updp.setVisible(true);

					}
				} else {
					JOptionPane.showMessageDialog(null, "请选择你要修改的行");
				}
			}
		});
		XGJT.setBounds(514, 24, 77, 23);
		contentPane.add(XGJT);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 669, 315);
		contentPane.add(scrollPane);

		// =====创建表格======
		String[] title = { "编号", "姓名", "性别", "学历", "登录密码", "电话号码" };
		model = new DefaultTableModel(title, 0);// 定义表格数据模型的表格标题和行数(为0行)
		Stuoperate.initTable(model);// 调用方法装载数据
		table = new JTable(model) {

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {// 设置第1列不可编辑
					return false;
				}
				return true;
			}
		};// 实例化表格装载表格模型实例
		scrollPane.setViewportView(table);

		JButton SXJT = new JButton("更新");
		SXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.getDataVector().clear();
				JCheckBox box = new JCheckBox();
				DefaultTableModel dtm2=(DefaultTableModel)table.getModel();//获取表格模型
				Stuoperate.initTable(model);
				table.updateUI();//更新显示
//				model.getDataVector().clear();
//				Stuoperate.initTable(model);// 调用方法装载数据
			}
		});
		SXJT.setBounds(602, 24, 77, 23);
		contentPane.add(SXJT);
	}

}
