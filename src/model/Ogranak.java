package model;

import java.util.List;

public class Ogranak {
	private List<Primerak> primerci;
	private List<Inventar> inventari;
	private List<Bibliotekar> bibliotekari;
	private String kontaktBroj;
	private String id;
	private Adresa adresa;
	
	
	public Ogranak(List<Primerak> primerci, List<Inventar> inventari, List<Bibliotekar> bibliotekari,
			String kontaktBroj, String id, Adresa adresa) {
		super();
		this.primerci = primerci;
		this.inventari = inventari;
		this.bibliotekari = bibliotekari;
		this.kontaktBroj = kontaktBroj;
		this.id = id;
		this.adresa = adresa;
	}
	
	public Ogranak() {}


	public List<Primerak> getPrimerci() {
		return primerci;
	}
	
	public void setPrimerci(List<Primerak> primerci) {
		this.primerci = primerci;
	}
	
	public List<Inventar> getInventari() {
		return inventari;
	}
	
	public void setInventari(List<Inventar> inventari) {
		this.inventari = inventari;
	}

	public String getKontaktBroj() {
		return kontaktBroj;
	}

	public void setKontaktBroj(String kontaktBroj) {
		this.kontaktBroj = kontaktBroj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}

	public void setBibliotekari(List<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	@Override
	public String toString() {
		return "Ogranak [primerci=" + primerci + ", inventari=" + inventari + ", bibliotekari=" + bibliotekari
				+ ", kontaktBroj=" + kontaktBroj + ", id=" + id + ", adresa=" + adresa + "]";
	}
	
	
}
