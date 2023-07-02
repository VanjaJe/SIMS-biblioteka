package model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("autor")
public class Autor {
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private List<Naslov> naslovi;
	
	
	public Autor(String ime, String prezime, String datumRodjenja, List<Naslov> naslovi) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.naslovi = naslovi;
	}
	
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public List<Naslov> getNaslovi() {
		return naslovi;
	}
	
	public void setNaslovi(List<Naslov> naslovi) {
		this.naslovi = naslovi;
	}
}
