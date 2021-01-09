package cn.edu.jsu.lyl.frm;
/**
 * 管理员管理员工工资界面
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
		
		// =====创建表格======
				String[] title = { "编号", "姓名", "基本工资", "社会保险", "交通补助", "通讯补助","绩效工资","个人税收","加班天数","加班工资","缺勤次数","扣除工资","总计" };
				modell = new DefaultTableModel(title, 0);// 定义表格数据模型的表格标题和行数(为0行)
				Stuoperate.initTable4(modell);// 调用方法装载数据
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
				
				lblNewLabel = new JLabel("输入关键字");
				lblNewLabel.setBounds(10, 401, 75, 15);
				contentPane.add(lblNewLabel);
				
				textField = new JTextField();
				textField.setBounds(97, 398, 130, 21);
				contentPane.add(textField);
				textField.setColumns(10);
				
				QCXJB = new JButton("查询");
				QCXJB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(modell);// 设置排序器
						table.setRowSorter(sorter);// 设置表格的排序器
						sorter.setRowFilter(null);
						sorter.setRowFilter(RowFilter.regexFilter(textField.getText()));
					}
				});
				QCXJB.setBounds(244, 397, 93, 23);
				contentPane.add(QCXJB);
				
				QXGJB = new JButton("修改");
				QXGJB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (table.getSelectedRow() != -1) {// 是否选择了要的行
						int count = table.getSelectedRow();// 获取你选中的行号（记录）
						String getname = table.getValueAt(count, 0).toString();// 读取你获取行号的某一列的值（也就是字段）
						//System.out.println(getname+" "+"qqq");
						fUpdataFrm.setStr(getname);
						fUpdataFrm fu=new fUpdataFrm();
						fu.setVisible(true);
						}else
						{
							JOptionPane.showMessageDialog(null, "请选择你要修改的行");
						}
					}
				});
				QXGJB.setBounds(375, 397, 93, 23);
				contentPane.add(QXGJB);
				
				QGXJB = new JButton("更新");
				QGXJB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modell.getDataVector().clear();
						JCheckBox box = new JCheckBox();
						DefaultTableModel dtm2=(DefaultTableModel)table.getModel();//获取表格模型
						Stuoperate.initTable4(modell);
						table.updateUI();//更新显示
					}
				});
				QGXJB.setBounds(515, 397, 93, 23);
				contentPane.add(QGXJB);
				
				btnNewButton = new JButton("\u7EDF\u8BA1\u5458\u5DE5\u5DE5\u8D44");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TotalMoney.charu();
						JOptionPane.showMessageDialog(null, "统计成功");
					}
				});
				btnNewButton.setBounds(646, 397, 146, 23);
				contentPane.add(btnNewButton);
	}

}
