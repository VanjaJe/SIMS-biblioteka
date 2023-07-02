package model;

import java.util.Date;

import enums.TipNadoknade;

public class Placanje {
	private String razlog;
	private Date datum;
	private double iznos;
	private TipNadoknade tipNadoknade;
	
	
	public String getRazlog() {
		return razlog;
	}
	public void setRazlog(String razlog) {
		this.razlog = razlog;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public TipNadoknade getTipNadoknade() {
		return tipNadoknade;
	}
	public void setTipNadoknade(TipNadoknade tipNadoknade) {
		this.tipNadoknade = tipNadoknade;
	}
}
