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
 * IO文件操作
 * @author 罗焰林
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
		
		// =======创建表格===========
		String[] title = { "编号", "姓名", "性别" ,"学历","电话"};// 定义数组表示表格标题
		DefaultTableModel model = new DefaultTableModel(title, 0);// 定义表格数据模型的表格标题和行数(为0行)
		Stuoperate.initTable8(model);
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
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// 设置排序器
				table.setRowSorter(sorter);// 设置表格的排序器
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
				if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
					if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "", JOptionPane.YES_NO_OPTION) == 0) {// 确认对话框
						model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						Stuoperate.deleteTable(model);
						JOptionPane.showMessageDialog(null, "数据更新成功");
						// 从表格数据中删除行,model为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
					} else {
						JOptionPane.showMessageDialog(null, "请选择你要删除的行");
					}
				}
			}
		});
		SCJT.setBounds(471, 421, 93, 23);
		contentPane.add(SCJT);
	}
}
