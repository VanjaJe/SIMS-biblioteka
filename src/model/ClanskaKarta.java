package model;

import java.util.Date;

public class ClanskaKarta {
	private String datumUclanjivanja;
	private int brojClanskeKarte;
	private VrstaClanstva vrstaClanstva;
	
	
	
	public ClanskaKarta(String datumUclanjivanja, int brojClanskeKarte, VrstaClanstva vrstaClanstva) {
		super();
		this.datumUclanjivanja = datumUclanjivanja;
		this.brojClanskeKarte = brojClanskeKarte;
		this.vrstaClanstva = vrstaClanstva;
	}
	public String getDatumUclanjivanja() {
		return datumUclanjivanja;
	}
	public void setDatumUclanjivanja(String datumUclanjivanja) {
		this.datumUclanjivanja = datumUclanjivanja;
	}
	public int getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
	public void setBrojClanskeKarte(int brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	public VrstaClanstva getVrstaClanstva() {
		return vrstaClanstva;
	}
	public void setVrstaClanstva(VrstaClanstva vrstaClanstva) {
		this.vrstaClanstva = vrstaClanstva;
	}
}
