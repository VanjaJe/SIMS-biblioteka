package model.podaci;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Clan;
import model.Korisnik;


@XStreamAlias("sviClanovi")
public class SviClanovi {
	public static SviClanovi instance = null;
	
	@XStreamAlias("clanovi")	
	private ArrayList<Clan> clanovi;
		
	public SviClanovi(){
		this.clanovi = new ArrayList<Clan>();
	}
	
	public static SviClanovi getInstance() {
		if (instance == null) {
			instance = new SviClanovi();
		}
		
		return instance;
	}

	public long generisiId() {
		int brojClanova = clanovi.size();
		return ++brojClanova;
	}
	
	public static void setInstance(SviClanovi sviClanovi) {
		instance = sviClanovi;
	}
	
	public ArrayList<Clan> getNaslovi() {
		return this.clanovi;
	}
	
	public void setClanovi(ArrayList<Clan> clanovi) {
		this.clanovi = clanovi;
	}
	
	public Clan dodajClana(Clan clan) {
		this.clanovi.add(clan);
		return clan;
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
