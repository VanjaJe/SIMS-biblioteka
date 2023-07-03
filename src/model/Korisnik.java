package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
//
//import observer.IzmenaKorisnikaEvent;
//import observer.Observer;
//import observer.Publisher;

@XStreamAlias("korisnik")
public class Korisnik{
	
	private long id;
	private String ime;
	private String prezime;
	private String telefon;
	private String jmbg;
	private String email;
	private LocalDate datumRodjenja;
	private KorisnickiNalog korisnickiNalog;
	
//	@XStreamOmitField
//	private List<Observer> observers;
	
	public Korisnik() {}
	
	public Korisnik(long id, String ime, String prezime, String telefon, String jmbg, String email, LocalDate datumRodjenja,
			KorisnickiNalog korisnickiNalog) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.jmbg = jmbg;
		this.email = email;
		this.datumRodjenja = datumRodjenja;
		this.korisnickiNalog = korisnickiNalog;
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public KorisnickiNalog getKorisnickiNalog() {
		return korisnickiNalog;
	}

	public void setKorisnickiNalog(KorisnickiNalog korisnickiNalog) {
		this.korisnickiNalog = korisnickiNalog;
	}
	
	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public void azurirajKorisnika(String ime, String prezime, String telefon, String jmbg, String email) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setTelefon(telefon);
		this.setJmbg(jmbg);
		this.setEmail(email);
//		this.notifyObservers();
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", telefon=" + telefon + ", jmbg="
				+ jmbg + ", email=" + email + ", datumRodjenja=" + datumRodjenja + ", korisnickiNalog="
				+ korisnickiNalog + "]";
	}

//	@Override
//	public void addObserver(Observer observer) {
//		if (observers == null)
//			observers = new ArrayList<Observer>();
//		observers.add(observer);
//	}
//
//	@Override
//	public void removeObserver(Observer observer) {
//		if (null == observers)
//			return;
//		observers.remove(observer);
//	}
//
//	@Override
//	public void notifyObservers() {
//		IzmenaKorisnikaEvent izmenaKorisnikaEvent = new IzmenaKorisnikaEvent(this);
//		for (Observer observer : observers) {
//			observer.updatePerformed(izmenaKorisnikaEvent);
//		}		
//	}
	
	
}

