package cn.edu.jsu.lyl.frm;
/**
 * 管理员管理职员请求的报销记录
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
 * 管理员管理职员请求的报销记录
 * @author 罗焰林
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

		JLabel lblNewLabel = new JLabel("输入关键字");
		lblNewLabel.setBounds(10, 21, 73, 15);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(93, 18, 98, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton FCXJT = new JButton("查询");
		FCXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(modell);// 设置排序器
				table.setRowSorter(sorter);// 设置表格的排序器
				sorter.setRowFilter(null);
				sorter.setRowFilter(RowFilter.regexFilter(textField.getText()));
			}
		});
		FCXJT.setBounds(213, 17, 73, 23);
		contentPane.add(FCXJT);

		JButton FZJJT = new JButton("增加");
		FZJJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFacialFrm adf=new AddFacialFrm();
				adf.setVisible(true);
			}
		});
		FZJJT.setBounds(341, 17, 73, 23);
		contentPane.add(FZJJT);

		JButton FSCJT = new JButton("删除");
		FSCJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
					if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "", JOptionPane.YES_NO_OPTION) == 0) {// 确认对话框
						int count = table.getSelectedRow();// 获取你选中的行号（记录）
						String getname = table.getValueAt(count, 0).toString();// 读取你获取行号的某一列的值（也就是字段）
						String gettime=	table.getValueAt(count, 6).toString();// 读取你获取行号的某一列的值（也就是字段）
//						System.out.println(getname + " ");
						modell.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						Stuoperate.deleteTable2(getname,gettime);
						JOptionPane.showMessageDialog(null, "数据删除成功");
						// 从表格数据中删除行,model为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
					}
				} else {
					JOptionPane.showMessageDialog(null,"请选择你要删除的行!");
				}
			}
		});
		FSCJT.setBounds(473, 17, 73, 23);
		contentPane.add(FSCJT);

		JButton FGXJT = new JButton("更新");
		FGXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modell.getDataVector().clear();
//				JCheckBox box = new JCheckBox();
//				DefaultTableModel dtm2=(DefaultTableModel)table.getModel();//获取表格模型
				Stuoperate.initTable2(modell);
//				table.updateUI();//更新显示
//				modell.getDataVector().clear();
//				Stuoperate.initTable2(modell);// 调用方法装载数据
			}
		});
		FGXJT.setBounds(603, 17, 73, 23);
		contentPane.add(FGXJT);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 680, 280);
		contentPane.add(scrollPane);

		// =====创建表格======
		String[] title = { "编号", "报备人", "性别","电话号码" ,"金额","原因","时间"};
		modell = new DefaultTableModel(title, 0);// 定义表格数据模型的表格标题和行数(为0行)
		Stuoperate.initTable2(modell);// 调用方法装载数据
		table = new JTable(modell) {

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {// 设置第1列不可编辑
					return false;
				}
				return true;
			}
		};// 实例化表格装载表格模型实例
		scrollPane.setViewportView(table);
	}

}
