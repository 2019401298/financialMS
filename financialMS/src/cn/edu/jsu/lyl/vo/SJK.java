package cn.edu.jsu.lyl.vo;
/**
 * 打印数据库
 * @author 罗焰林
 *
 */
public class SJK {
	private String eid;
	private String name;
	private String sex;
	private String eduback;
	private String phone;
	private int total;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEduback() {
		return eduback;
	}
	public void setEduback(String eduback) {
		this.eduback = eduback;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "SJK [eid=" + eid + ", name=" + name + ", sex=" + sex + ", eduback=" + eduback + ", phone=" + phone
				+ ", total=" + total + ", getEid()=" + getEid() + ", getName()=" + getName() + ", getSex()=" + getSex()
				+ ", getEduback()=" + getEduback() + ", getPhone()=" + getPhone() + ", getTotal()=" + getTotal() + "]";
	}
	
}
