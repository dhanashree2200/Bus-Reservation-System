package admin;
import com.jfoenix.controls.JFXButton;

public class mb{
	int sr;
	String fr,t1;
	JFXButton update,delete;
	
	public mb(int sr, String fr, String t1, JFXButton update, JFXButton delete) {
		super();
		this.sr = sr;
		this.fr = fr;
		this.t1 = t1;
		this.update = update;
		this.delete = delete;
	}
	public int getSr() {
		return sr;
	}

	public void setSr(int sr) {
		this.sr = sr;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public JFXButton getUpdate() {
		return update;
	}

	public void setUpdate(JFXButton update) {
		this.update = update;
	}

	public JFXButton getDelete() {
		return delete;
	}

	public void setDelete(JFXButton delete) {
		this.delete = delete;
	}

	
}