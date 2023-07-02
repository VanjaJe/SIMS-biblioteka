package model;

import java.util.List;

public class Biblioteka {
	private List<Naslov> naslov;
	private List<Ogranak> ogranci;
	private List<Korisnik> korisnici;
	private List<ClanskaKarta> clanskeKarte;
	private List<VrstaClanstva> vrsteClanstva;
	private List<Placanje> placanja;
	private List<DrzavniPraznik> drzavniPraznici;
	
	
	
	public List<Naslov> getNaslov() {
		return naslov;
	}
	
	public void setNaslov(List<Naslov> naslov) {
		this.naslov = naslov;
	}
	
	public List<Ogranak> getOgranci() {
		return ogranci;
	}
	
	public void setOgranci(List<Ogranak> ogranci) {
		this.ogranci = ogranci;
	}
	
	public List<Korisnik> getKorisnici() {
		return korisnici;
	}
	
	public void setKorisnici(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	public List<ClanskaKarta> getClanskeKarte() {
		return clanskeKarte;
	}
	
	public void setClanskeKarte(List<ClanskaKarta> clanskeKarte) {
		this.clanskeKarte = clanskeKarte;
	}
	
	public List<VrstaClanstva> getVrsteClanstva() {
		return vrsteClanstva;
	}
	
	public void setVrsteClanstva(List<VrstaClanstva> vrsteClanstva) {
		this.vrsteClanstva = vrsteClanstva;
	}
	
	public List<Placanje> getPlacanja() {
		return placanja;
	}
	
	public void setPlacanja(List<Placanje> placanja) {
		this.placanja = placanja;
	}
	
	public List<DrzavniPraznik> getDrzavniPraznici() {
		return drzavniPraznici;
	}
	
	public void setDrzavniPraznici(List<DrzavniPraznik> drzavniPraznici) {
		this.drzavniPraznici = drzavniPraznici;
	}
}
