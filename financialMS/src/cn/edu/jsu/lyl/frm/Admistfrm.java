package cn.edu.jsu.lyl.frm;
/**
 * 管理员界面
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lyl.dao.TotalMoney;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 * 员工管理界面
 * @author 罗焰林
 *
 */
public class Admistfrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admistfrm frame = new Admistfrm();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);// 窗体居中
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admistfrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admistfrm.class.getResource("/cn/edu/jsu/lyl/frm/qian.jpg")));
		setTitle("企业财务管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 343);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("职员信息管理");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("打开操作页面");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staffm sta=new Staffm();
				sta.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("个人工资管理");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem DDCZ = new JMenuItem("\u6253\u5F00\u64CD\u4F5C\u9875\u9762");
		DDCZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicFrm bsm=new BasicFrm();
				bsm.setVisible(true);
			}
		});
		mnNewMenu_1.add(DDCZ);
		
		JMenu mnNewMenu_3 = new JMenu("公司经营管理");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6253\u5F00\u64CD\u4F5C\u9875\u9762");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Commanagefrm cmm=new Commanagefrm();
				cmm.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_4 = new JMenu("财务收支管理");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("打开操作页面");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ficalfrm fif=new Ficalfrm();
				fif.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admistfrm.class.getResource("/cn/edu/jsu/lyl/frm/\u7535\u81111.jpg")));
		lblNewLabel.setBounds(0, 0, 436, 289);
		contentPane.add(lblNewLabel);
	}
	
}
