package model;

import enums.TipKorisnika;

public class KorisnickiNalog {
	
	private String korisnickoIme;
	private String lozinka;
	private TipKorisnika tipKorisnika;
	
	public KorisnickiNalog() {}

	public KorisnickiNalog(String korisnickoIme, String lozinka, TipKorisnika tipKorisnika) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = tipKorisnika;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}
	
	public boolean promenaLozinke(String novaLozinka) {
		return true; //TODO: Implementiraj metodu za promenu lozinke
	}
}
