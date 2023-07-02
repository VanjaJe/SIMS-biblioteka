package model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("naslov")
public class Naslov {
	private String naslovDela;
	private String opis;
	private String udk;
	private String isbn;
	private List<Autor> autori;
	public Naslov(String naslovDela,String opis, String udk, String isbn, List<Autor> autori) {
		super();
		this.naslovDela = naslovDela;
		this.opis=opis;
		this.udk = udk;
		this.isbn = isbn;
		this.autori = autori;
	}
	public String getNaslovDela() {
		return naslovDela;
	}
	public void setNaslovDela(String naslovDela) {
		this.naslovDela = naslovDela;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis=opis;
	}
	public String getUdk() {
		return udk;
	}
	public void setUdk(String udk) {
		this.udk = udk;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<Autor> getAutori() {
		return autori;
	}
	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}
	
	

}
