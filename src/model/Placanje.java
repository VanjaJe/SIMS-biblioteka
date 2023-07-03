package model;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import enums.TipNadoknade;

@XStreamAlias("placanje")
public class Placanje {
	private String razlog;
	private String datum;
	private double iznos;
	private TipNadoknade tipNadoknade;
	
	
	public Placanje(String razlog, String datum, double iznos, TipNadoknade tipNadoknade) {
		super();
		this.razlog = razlog;
		this.datum = datum;
		this.iznos = iznos;
		this.tipNadoknade = tipNadoknade;
	}
	public String getRazlog() {
		return razlog;
	}
	public void setRazlog(String razlog) {
		this.razlog = razlog;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
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
