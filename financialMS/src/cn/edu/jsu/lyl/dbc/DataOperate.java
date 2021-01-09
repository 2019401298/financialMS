package cn.edu.jsu.lyl.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DataOperate {
	// ��������
	private static String firstName = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	// ����Ů������
	private static String girl = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	// ������������
	private static String boy = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
	// ѧ��
	private static String edu = "���и��б���˶ʿ��ʿ";

	public static int getNum(int start, int end) {// ������ط���ָ����Χ�������
		// Math.random()�������0.0��1.0֮�����
		return (int) (Math.random() * (end - start + 1) + start);
	}

	// ������ر��
	public static StringBuilder getStuno() {// ��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
		StringBuilder xh = new StringBuilder("2019401");// ѧ��ǰ7λ��ͬ
		StringBuilder xh1 = new StringBuilder(String.valueOf(getNum(1, 100000)));// ���ȡ��3λ
		if(xh1.length()==1) {
			xh1 = xh1.insert(0, "00000");// �����1λ����ǰ������2��0
			xh = xh.append(xh1);// ǰ6λ���3λƴ�ӳ�ѧ��
		}else if (xh1.length() == 2) {
			xh1 = xh1.insert(0, "0000");// �����1λ����ǰ������2��0
			xh = xh.append(xh1);// ǰ6λ���3λƴ�ӳ�ѧ��
		} else if (xh1.length() == 3) {
			xh1 = xh1.insert(0, "000");// �����2λ����ǰ������1��0
			xh = xh.append(xh1);
		} else if (xh1.length() == 4) {
			xh1 = xh1.insert(0, "00");// �����2λ����ǰ������1��0
			xh = xh.append(xh1);
		} else if(xh1.length() == 5){
			xh1 = xh1.insert(0, "0");// �����2λ����ǰ������1��0
			xh = xh.append(xh1);
		}
		else{
			xh = xh.append(xh1);
		}
		return xh;
	}

	// ���������������
	public static String getChineseName() {
		int index = getNum(0, firstName.length() - 1);// ���ȡ�����ַ����е�����λ��
		String first = firstName.substring(index, index + 1);// ��ȡ��λ�õ�����
		int sex = getNum(0, 1);// ���ȡ�Ա�����1Ϊ������0ΪŮ��
		String str = boy;// ��������Ϊ�����ַ���
		int length = boy.length();// ��ȡ�����ַ����ĳ���
		if (sex == 0) {// ��������ȡΪ0�������ָ�ΪŮ��
			str = girl;
			length = girl.length();
		}
		index = getNum(0, length - 1);// �����ȡ���ֵ�λ��
		String second = str.substring(index, index + 1);// ��ȡ��λ���е�����
		int hasThird = getNum(0, 1);// �����ȡ�����Ƿ��е�������
		String third = "";// Ĭ��û�е�������
		if (hasThird == 1) {// ��������ȡΪ1�����е�������
			index = getNum(0, length - 1);
			third = str.substring(index, index + 1);
		}
		return first + second + third;// ��������
	}

	public static String getEducate() {
		int index = edu.length();
		int flag = 1;
		while (flag % 2 != 0) {
			flag = getNum(0, index - 2);
		}
		String ed = edu.substring(flag, flag + 2);
		return ed;
	}

	public static String getSex() {
		int sex = getNum(0, 1);
		String S = null;
		if (sex == 0) {
			S = "Ů";
		} else {
			S = "��";
		}
		return S;
	}

	public static void addData() {
		DatabaseConnection dbcs = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
		String sql = "insert into Employee (eid,name,sex,eduback,password,phone,baseM,socialM,trafficA,communicationA,meritA,individualA,overday,overM,lostday,lostM) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement
			ArrayList<String> alist = new ArrayList<String>();// ���弯��
			for (int i = 1; i <= 10;) {
				String eid = getStuno().toString();// �����ȡѧ��
				if (!alist.contains(eid)) {// �ж�ѧ���Ƿ�Ψһ
					alist.add(eid);// ��ѧ�ż��뼯��
					String xm = getChineseName();// �����ȡ����
					String xb = getSex();
					String XL=getEducate();
					String MM= String.valueOf(getNum(100000,999999));
					String DH="1"+getNum(3,9)+getNum(123456789,999999999);
					String JB= String.valueOf(getNum(4000,9000));
					int OD=getNum(0,30);
					int OC=getNum(0,10);
					pstmt.setString(1, eid);// �����1��ռλ��������
					pstmt.setString(2, xm);// �����2��ռλ��������
					pstmt.setString(3, xb);// �����3��ռλ��������
					pstmt.setString(4, XL);
					pstmt.setString(5,MM);
					pstmt.setString(6, DH);
					pstmt.setString(7, JB);
					pstmt.setString(8, "800");
					pstmt.setString(9, String.valueOf(getNum(300,900)));
					pstmt.setString(10, String.valueOf(getNum(50,300)));
					pstmt.setString(11, String.valueOf(getNum(200,500)));
					pstmt.setString(12, String.valueOf(getNum(300,500)));
					pstmt.setInt(13,OD);
					pstmt.setString(14,String.valueOf(OD*150));
					pstmt.setInt(15,OC);
					pstmt.setString(16,String.valueOf(OC*200));
					pstmt.addBatch();// ����������ȴ�ִ��
					i++;// ѧ��Ψһ��ѭ����������ִ��
				}
			}
			pstmt.executeBatch();// ����ִ�в������
			JOptionPane.showMessageDialog(null, "sucess");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		addData();
	}
}
