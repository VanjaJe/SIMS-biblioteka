package model.podaci;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Clan;
import model.Korisnik;

@XStreamAlias("sviKorisnici")
public class SviKorisnici {
	
	public static SviKorisnici instance = null;
	
	@XStreamAlias("korisnici")	
	private ArrayList<Korisnik> korisnici;
		
	private SviKorisnici() {
		this.korisnici = new ArrayList<Korisnik>();
	}
	
	public static SviKorisnici getInstance() {
		if (instance == null) {
			instance = new SviKorisnici();
		}
		
		return instance;
	}

	public long generisiId() {
		int brojKorisnika = korisnici.size();
		return ++brojKorisnika;
	}
	
	public static void setInstance(SviKorisnici korisniciLista) {
		instance = korisniciLista;
	}
	
	public ArrayList<Korisnik> getKorisnici() {
		return this.korisnici;
	}
	
	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	public Korisnik dodajKorisnika(Korisnik korisnik) {
		this.korisnici.add(korisnik);
		return korisnik;
	}
	
	public void izmeniKorisnika(String ime,String prezime,String telefon,String email,String stariEmail) {
		Korisnik korisnik = dobaviKorisnikaPoEmailAdresi(stariEmail);
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setTelefon(telefon);
		korisnik.setEmail(email);
		
		for (int i = 0; i < korisnici.size(); i++) {
			if (korisnici.get(i).getId() == korisnik.getId()) {
				korisnici.remove(i);
				korisnici.add(i, korisnik);
			}
		}
	}
	
	public void izmeniKorisnika(Korisnik korisnik) {
		Korisnik stariKorisnik = dobaviKorisnikaPoJmbg(korisnik.getJmbg());
		stariKorisnik.setIme(korisnik.getIme());
		stariKorisnik.setPrezime(korisnik.getPrezime());
		stariKorisnik.setTelefon(korisnik.getTelefon());
		stariKorisnik.setEmail(korisnik.getEmail());
		stariKorisnik.setDatumRodjenja(korisnik.getDatumRodjenja());
		stariKorisnik.setKorisnickiNalog(korisnik.getKorisnickiNalog());
		
		for (int i = 0; i < korisnici.size(); i++) {
			if (korisnici.get(i).getId() == stariKorisnik.getId()) {
				korisnici.remove(i);
				korisnici.add(i, stariKorisnik);
			}
		}
	}
	
	public Korisnik dobaviKorisnikaPoKorisnickomImenu(String korisnickoIme) {
		ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
				.stream()
				.filter(korisnik -> korisnik.getKorisnickiNalog().getKorisnickoIme().equals(korisnickoIme))
				.collect(Collectors.toList());
		if (korisnikLista.size() == 0) {
			return null;
		}
		
		return korisnikLista.get(0);
	}
	
	public Korisnik dobaviKorisnikaPoEmailAdresi(String email) {
		ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
				.stream()
				.filter(korisnik -> korisnik.getEmail().equals(email))
				.collect(Collectors.toList());
		if (korisnikLista.size() == 0) {
			return null;
		}
		
		return korisnikLista.get(0);
	}
	
	public Korisnik dobaviKorisnikaPoJmbg(String jmbg) {
		ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
				.stream()
				.filter(korisnik -> korisnik.getJmbg().equals(jmbg))
				.collect(Collectors.toList());
		if (korisnikLista.size() == 0) {
			return null;
		}
		
		return korisnikLista.get(0);
	}
}