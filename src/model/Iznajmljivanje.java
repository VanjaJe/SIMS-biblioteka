package model;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("iznajmljivanje")
public class Iznajmljivanje {
	private String datumIznjamljivanja;
	private Boolean produzeno;
	private Primerak primerak;
	private Clan clan;
	
	
	public Iznajmljivanje(String datumIznjamljivanja, Boolean produzeno, Primerak primerak, Clan clan) {
		super();
		this.datumIznjamljivanja = datumIznjamljivanja;
		this.produzeno = produzeno;
		this.primerak = primerak;
		this.clan = clan;
	}
	
	
	public String getDatumIznjamljivanja() {
		return datumIznjamljivanja;
	}
	public void setDatumIznjamljivanja(String datumIznjamljivanja) {
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
