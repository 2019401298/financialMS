package cn.edu.jsu.lyl.frm;
/**
 * 增加公司生意来往界面
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
		
		
		JButton CZJTB = new JButton("增加");
		CZJTB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addbns ab=new Addbns();
				ab.setVisible(true);
			}
		});
		CZJTB.setBounds(343, 372, 93, 23);
		contentPane.add(CZJTB);
		
		JButton CGXJT = new JButton("更新");
		CGXJT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modell.getDataVector().clear();
				JCheckBox box = new JCheckBox();
				DefaultTableModel dtm2=(DefaultTableModel)table.getModel();//获取表格模型
				Stuoperate.initTable3(modell);
				table.updateUI();//更新显示
			}
		});
		CGXJT.setBounds(485, 372, 93, 23);
		contentPane.add(CGXJT);
		
		// =====创建表格======
		String[] title = { "项目", "支出(元)", "收入(元)","备注" ,"时间","操作人"};
		modell = new DefaultTableModel(title, 0);// 定义表格数据模型的表格标题和行数(为0行)
		Stuoperate.initTable3(modell);// 调用方法装载数据
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
