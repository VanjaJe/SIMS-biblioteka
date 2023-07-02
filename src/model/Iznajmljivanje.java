package model;

import java.util.Date;

public class Iznajmljivanje {
	private Date datumIznjamljivanja;
	private Boolean produzeno;
	private Primerak primerak;
	private Clan clan;
	
	
	public Iznajmljivanje(Date datumIznjamljivanja, Boolean produzeno, Primerak primerak, Clan clan) {
		super();
		this.datumIznjamljivanja = datumIznjamljivanja;
		this.produzeno = produzeno;
		this.primerak = primerak;
		this.clan = clan;
	}
	
	
	public Date getDatumIznjamljivanja() {
		return datumIznjamljivanja;
	}
	public void setDatumIznjamljivanja(Date datumIznjamljivanja) {
		this.datumIznjamljivanja = datumIznjamljivanja;
	}
	public Boolean getProduzeno() {
		return produzeno;
	}
	public void setProduzeno(Boolean produzeno) {
		this.produzeno = produzeno;
	}
	public Primerak getPrimerak() {
		return primerak;
	}
	public void setPrimerak(Primerak primerak) {
		this.primerak = primerak;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
	
	
	
}
