package model;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("iznajmljivanje")
public class Iznajmljivanje {
	private Date datumIznjamljivanja;
	private Boolean produzeno;
	private Primerak primerak;
	private Clan clan;
	private Boolean zavrseno;
	
	
	public Iznajmljivanje(Date datumIznjamljivanja, Boolean produzeno, Primerak primerak, Clan clan) {
		super();
		this.datumIznjamljivanja = datumIznjamljivanja;
		this.produzeno = produzeno;
		this.primerak = primerak;
		this.clan = clan;
		this.zavrseno=false;
	}
	
	
	public Boolean getZavrseno() {
		return zavrseno;
	}


	public void setZavrseno(Boolean zavrseno) {
		this.zavrseno = zavrseno;
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


	@Override
	public String toString() {
		return "Iznajmljivanje [datumIznjamljivanja=" + datumIznjamljivanja + ", produzeno=" + produzeno + ", primerak="
				+ primerak + ", clan=" + clan + "]";
	}
}