package model;

import java.util.Date;

public class Cenovnik {
	private Date datumOd;
	private Date datumDo;
	private double cenaClanstva;
	private VrstaClanstva vrstaClanstva;
	
	
	
	public Date getDatumOd() {
		return datumOd;
	}
	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}
	public Date getDatumDo() {
		return datumDo;
	}
	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}
	public double getCenaClanstva() {
		return cenaClanstva;
	}
	public void setCenaClanstva(double cenaClanstva) {
		this.cenaClanstva = cenaClanstva;
	}
	public VrstaClanstva getVrstaClanstva() {
		return vrstaClanstva;
	}
	public void setVrstaClanstva(VrstaClanstva vrstaClanstva) {
		this.vrstaClanstva = vrstaClanstva;
	}
}
