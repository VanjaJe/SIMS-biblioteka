package model;

import java.util.List;

public class Izdavac {
	private String naziv;
	private String datumOsnivanja;
	private List<Primerak> primerci;
	
	
	public Izdavac(String naziv, String datumOsnivanja, List<Primerak> primerci) {
		super();
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.primerci = primerci;
	}
	
	public Izdavac(String naziv, String datumOsnivanja) {
		super();
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
	}

	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getDatumOsnivanja() {
		return datumOsnivanja;
	}
	
	public void setDatumOsnivanja(String datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public List<Primerak> getPrimerci() {
		return primerci;
	}

	public void setPrimerci(List<Primerak> primerci) {
		this.primerci = primerci;
	}
}
