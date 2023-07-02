package model.podaci;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Naslov;
import model.Korisnik;


@XStreamAlias("sviNaslovi")
public class SviNaslovi {
	public static SviNaslovi instance = null;
	
	@XStreamAlias("naslovi")	
	private ArrayList<Naslov> naslovi;
		
	public SviNaslovi(){
		this.naslovi = new ArrayList<Naslov>();
	}
	
	public static SviNaslovi getInstance() {
		if (instance == null) {
			instance = new SviNaslovi();
		}
		
		return instance;
	}

	public long generisiId() {
		int brojNaslova = naslovi.size();
		return ++brojNaslova;
	}
	
	public static void setInstance(SviNaslovi sviNaslovi) {
		instance = sviNaslovi;
	}
	
	public ArrayList<Naslov> getNaslovi() {
		return this.naslovi;
	}
	
	public void setNaslovi(ArrayList<Naslov> naslovi) {
		this.naslovi = naslovi;
	}
	
	public Naslov dodajNaslov(Naslov naslov) {
		this.naslovi.add(naslov);
		return naslov;
	}
//	
//	public void izmeniKorisnika(String ime,String prezime,String telefon,String email,String stariEmail) {
//		Korisnik korisnik = dobaviKorisnikaPoEmailAdresi(stariEmail);
//		korisnik.setIme(ime);
//		korisnik.setPrezime(prezime);
//		korisnik.setTelefon(telefon);
//		korisnik.setEmail(email);
//		
//		for (int i = 0; i < korisnici.size(); i++) {
//			if (korisnici.get(i).getId() == korisnik.getId()) {
//				korisnici.remove(i);
//				korisnici.add(i, korisnik);
//			}
//		}
//	}
//	
//	public Korisnik dobaviKorisnikaPoKorisnickomImenu(String korisnickoIme) {
//		ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
//				.stream()
//				.filter(korisnik -> korisnik.getKorisnickiNalog().getKorisnickoIme().equals(korisnickoIme))
//				.collect(Collectors.toList());
//		if (korisnikLista.size() == 0) {
//			return null;
//		}
//		
//		return korisnikLista.get(0);
//	}
//	
//	public Korisnik dobaviKorisnikaPoEmailAdresi(String email) {
//		ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
//				.stream()
//				.filter(korisnik -> korisnik.getEmail().equals(email))
//				.collect(Collectors.toList());
//		if (korisnikLista.size() == 0) {
//			return null;
//		}
//		
//		return korisnikLista.get(0);
//	}

}
