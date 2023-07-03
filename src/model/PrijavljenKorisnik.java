package model;

import enums.TipKorisnika;
import enums.TipKorisnika;

public class PrijavljenKorisnik {

	private static PrijavljenKorisnik instance = null;
	
	private String korisnickoIme;
	private TipKorisnika tipKorisnika;
	
	private PrijavljenKorisnik() {}
	
	public static PrijavljenKorisnik getInstance() {
		if (instance == null) {
			instance = new PrijavljenKorisnik();
		}
		return instance;
	}
	
	public static void setInstanceToNull() {
		instance = null;
	}
	
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}
	
	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}
	
	public TipKorisnika getTipKorisnika() {
		return this.tipKorisnika;
	}

	@Override
	public String toString() {
		return "PrijavljenKorisnik [korisnickoIme=" + korisnickoIme + ", tipKorisnika=" + tipKorisnika + "]";
	}
	
}
