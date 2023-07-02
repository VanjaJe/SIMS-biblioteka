package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("autor")
public class Autor {
	private String ime;
	private String prezime;
	private String datumRodjenja;
	public Autor(String ime, String prezime, String datumRodjenja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
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
}
