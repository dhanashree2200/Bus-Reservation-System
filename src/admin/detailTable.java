package admin;

public class detailTable {
	String busno,from,to1,ariT,depT;
	int source;
	public detailTable( int source,String busno, String from, String to1, String ariT,String depT) {
		super();
		this.source = source;
		this.busno = busno;
		this.from = from;
		this.to1=to1;
		this.ariT=ariT;
		this.depT=depT;
	}



	public String getBusno() {
		return busno;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo1() {
		return to1;
	}
	public void setTo1(String to1) {
		this.to1 = to1;
	}
	public String getAriT() {
		return ariT;
	}
	public void setAriT(String ariT) {
		this.ariT = ariT;
	}
	public String getDepT() {
		return depT;
	}
	public void setDepT(String depT) {
		this.depT = depT;
	}

	
}

