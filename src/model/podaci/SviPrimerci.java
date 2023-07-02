package model.podaci;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import model.Primerak;


@XStreamAlias("sviPrimerci")
public class SviPrimerci {
	public static SviPrimerci instance = null;
	
	@XStreamAlias("primerci")	
	private ArrayList<Primerak> primerci;
		
	public SviPrimerci(){
		this.primerci = new ArrayList<Primerak>();
	}
	
	public static SviPrimerci getInstance() {
		if (instance == null) {
			instance = new SviPrimerci();
		}
		return instance;
	}

	public long generisiId() {
		int brojNaslova = primerci.size();
		return ++brojNaslova;
	}
	
	public static void setInstance(SviPrimerci sviPrimerci) {
		instance = sviPrimerci;
	}
	
	public ArrayList<Primerak> getPrimerci() {
		return this.primerci;
	}
	
	public void setPrimerak(ArrayList<Primerak> primerci) {
		this.primerci = primerci;
	}
	
	public Primerak dodajPrimerak(Primerak primerak) {
		this.primerci.add(primerak);
		return primerak;
	}
	
//	
//		public void izmeniKorisnika(String ime,String prezime,String telefon,String email,String stariEmail) {
//			Korisnik korisnik = dobaviKorisnikaPoEmailAdresi(stariEmail);
//			korisnik.setIme(ime);
//			korisnik.setPrezime(prezime);
//			korisnik.setTelefon(telefon);
//			korisnik.setEmail(email);
//			
//			for (int i = 0; i < korisnici.size(); i++) {
//				if (korisnici.get(i).getId() == korisnik.getId()) {
//					korisnici.remove(i);
//					korisnici.add(i, korisnik);
//				}
//			}
//		}
//	
//		public Korisnik dobaviKorisnikaPoKorisnickomImenu(String korisnickoIme) {
//			ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
//					.stream()
//					.filter(korisnik -> korisnik.getKorisnickiNalog().getKorisnickoIme().equals(korisnickoIme))
//					.collect(Collectors.toList());
//			if (korisnikLista.size() == 0) {
//				return null;
//			}
//			
//			return korisnikLista.get(0);
//		}
//	
//		public Korisnik dobaviKorisnikaPoEmailAdresi(String email) {
//			ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
//					.stream()
//					.filter(korisnik -> korisnik.getEmail().equals(email))
//					.collect(Collectors.toList());
//			if (korisnikLista.size() == 0) {
//				return null;
//			}
//			
//			return korisnikLista.get(0);
//		}

}
