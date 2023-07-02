package model;

import java.util.Date;

public class ClanskaKarta {
	private String datumUclanjivanja;
	private String brojClanskeKarte;
	private VrstaClanstva vrstaClanstva;
	
	
	
	public String getDatumUclanjivanja() {
		return datumUclanjivanja;
	}
	public void setDatumUclanjivanja(String datumUclanjivanja) {
		this.datumUclanjivanja = datumUclanjivanja;
	}
	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	public VrstaClanstva getVrstaClanstva() {
		return vrstaClanstva;
	}
	public void setVrstaClanstva(VrstaClanstva vrstaClanstva) {
		this.vrstaClanstva = vrstaClanstva;
	}
}
