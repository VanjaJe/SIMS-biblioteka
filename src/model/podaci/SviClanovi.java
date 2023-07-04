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
	
	public ArrayList<Clan> getClanovi() {
		return this.clanovi;
	}
	
	public void setClanovi(ArrayList<Clan> clanovi) {
		this.clanovi = clanovi;
	}
	
	public Clan dodajClana(Clan clan) {
		this.clanovi.add(clan);
		return clan;
	}
	
	public void izmeniClana(Clan clan) {
		Clan stariClan = dobaviClanaPoJmbg(clan.getJmbg());
		stariClan.setIme(clan.getIme());
		stariClan.setPrezime(clan.getPrezime());
		stariClan.setTelefon(clan.getTelefon());
		stariClan.setEmail(clan.getEmail());
		stariClan.setDatumRodjenja(clan.getDatumRodjenja());
		stariClan.setKorisnickiNalog(clan.getKorisnickiNalog());
		stariClan.setClanskaKarta(clan.getClanskaKarta());
		stariClan.setPlacanja(clan.getPlacanja());
		stariClan.setPopust(clan.getPopust());
		
		for (int i = 0; i < clanovi.size(); i++) {
			if (clanovi.get(i).getId() == stariClan.getId()) {
				clanovi.remove(i);
				clanovi.add(i, stariClan);
			}
		}
	}
	
	public Clan dobaviClanaPoJmbg(String jmbg) {
		ArrayList<Clan> clanLista = (ArrayList<Clan>) clanovi
				.stream()
				.filter(clan -> clan.getJmbg().equals(jmbg))
				.collect(Collectors.toList());
		if (clanLista.size() == 0) {
			return null;
		}
		
		return clanLista.get(0);
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
