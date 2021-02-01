package application;

import com.jfoenix.controls.JFXButton;

public class CA {
	int sn;
	String a1,d1,a2,n1;
	JFXButton bk=new JFXButton("BOOK TICKET");

	public CA(int sn,String n1, String a1, String d1, String a2, JFXButton bk) {
		super();
		this.sn = sn;
		this.n1 = n1;
		this.a1 = a1;
		this.d1 = d1;
		this.a2 = a2;
		this.bk = bk;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	
	public String getN1() {
		return n1;
	}
	public void setN1(String n1) {
		this.n1 = n1;
	}
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getD1() {
		return d1;
	}
	public void setD1(String d1) {
		this.d1 = d1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public JFXButton getBk() {
		return bk;
	}
	public void setBk(JFXButton bk) {
		this.bk = bk;
	}

}
