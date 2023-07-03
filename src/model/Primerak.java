package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import enums.Stanje;
import enums.TipKoricenja;


@XStreamAlias("primerak")
public class Primerak {
	private Naslov naslov;
	private int inventarniBroj;
	private String jezik;
	private String format;
	private TipKoricenja tipKoricenja;
	private Stanje stanje;
	private Izdavac izdavac;
	private Inventar inventar;
	
	
	public Primerak(int inventarniBroj, String jezik, String format, TipKoricenja tipKoricenja, Stanje stanje, Izdavac izdavac, Inventar inventar, Naslov naslov) {
		super();
		this.inventarniBroj = inventarniBroj;
		this.jezik = jezik;
		this.format = format;
		this.tipKoricenja = tipKoricenja;
		this.stanje = stanje;
		this.izdavac = izdavac;
		this.inventar = inventar;
		this.naslov = naslov;
	}
	
	public Primerak(int inventarniBroj, String jezik, String format, TipKoricenja tipKoricenja, Stanje stanje, Inventar inventar, Naslov naslov) {
		super();
		this.inventarniBroj = inventarniBroj;
		this.jezik = jezik;
		this.format = format;
		this.tipKoricenja = tipKoricenja;
		this.stanje = stanje;
		this.inventar = inventar;
		this.naslov = naslov;
	}
	
	public Primerak() {}
	
	
	public int getInventarniBroj() {
		return inventarniBroj;
	}
	
	public void setInventarniBroj(int inventarniBroj) {
		this.inventarniBroj = inventarniBroj;
	}
	
	public String getJezik() {
		return jezik;
	}
	
	public void setJezik(String jezik) {
		this.jezik = jezik;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public TipKoricenja getTipKoricenja() {
		return tipKoricenja;
	}
	
	public void setTipKoricenja(TipKoricenja tipKoricenja) {
		this.tipKoricenja = tipKoricenja;
	}
	
	public Stanje getStanje() {
		return stanje;
	}
	
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	public Izdavac getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
	}

	public Inventar getInventar() {
		return inventar;
	}

	public void setInventar(Inventar inventar) {
		this.inventar = inventar;
	}

	public Naslov getNaslov() {
		return naslov;
	}

	public void setNaslov(Naslov naslov) {
		this.naslov = naslov;
	}

	@Override
	public String toString() {
		return "Primerak [naslov=" + naslov + ", inventarniBroj=" + inventarniBroj + ", jezik=" + jezik + ", format="
				+ format + ", tipKoricenja=" + tipKoricenja + ", stanje=" + stanje + ", izdavac=" + izdavac
				+ ", inventar=" + inventar + "]";
	}
	
}
