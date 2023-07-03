package kontroler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.Stanje;
import izuzeci.MissingValueException;
import izuzeci.NaslovNePostojiException;
import izuzeci.PrimerciNePostojeException;
import model.Clan;
import model.Iznajmljivanje;
import model.Korisnik;
import model.Naslov;
import model.PrijavljenKorisnik;
import model.Primerak;
import model.podaci.SvaIznajmljivanja;
import model.podaci.SviKorisnici;
import model.podaci.SviNaslovi;
import model.podaci.SviPrimerci;
import serijalizacija.Serijalizacija;

public class IznajmljivanjeKontroler {
	
	public IznajmljivanjeKontroler() {};
	
	
	private boolean checkIfNullOrEmpty(String input) {
		return input == null || input.equals("");
	}

	public Naslov dobaviNaslov(String unetNaslov) throws MissingValueException, NaslovNePostojiException {
		if (checkIfNullOrEmpty(unetNaslov)) {
			throw new MissingValueException("Nije validno unet naslov knjige.");
		}
		for (Naslov naslov : SviNaslovi.getInstance().getNaslovi()) {
			if(naslov.getNaslovDela().equalsIgnoreCase(unetNaslov)) {
				return naslov;
			}
		}
		throw new NaslovNePostojiException("Naslov knjige koji ste uneli se ne nalazi u sistemu biblioteke.");
	}


	public List<Primerak> dobaviPrimerke(Naslov unetNaslov) throws PrimerciNePostojeException {
		List<Primerak> primerci = new ArrayList<Primerak>();
		for (Primerak primerak : SviPrimerci.getInstance().getPrimerci()) {
			if(primerak.getNaslov().getIsbn() == unetNaslov.getIsbn()) {
				primerci.add(primerak);
			}
		}
		if(primerci.isEmpty()) {
			throw new PrimerciNePostojeException("Knjiga ne sadrzi primerke.");
		}
		return primerci;
	}


	public Primerak dobaviDostupanPrimerak(List<Primerak> primerci) throws PrimerciNePostojeException {
		for(Primerak primerak : primerci) {
			Stanje dostupan = Stanje.DOSTUPAN;
			if(primerak.getStanje().equals(dostupan)) {
				return primerak;
			}
		}
		throw new PrimerciNePostojeException("Nema dostupnih primeraka");
	}
	
	public Clan dobaviClana() {
		PrijavljenKorisnik prijavljeniKorisnik = PrijavljenKorisnik.getInstance();
		String korisnickoImeClana = prijavljeniKorisnik.getKorisnickoIme();
		Korisnik korisnik = SviKorisnici.getInstance().dobaviKorisnikaPoKorisnickomImenu(korisnickoImeClana);
		Clan clan = new Clan(korisnik.getId(),korisnik.getIme(),korisnik.getPrezime(),
				korisnik.getTelefon(),korisnik.getJmbg(),korisnik.getEmail()
				,korisnik.getDatumRodjenja(),korisnik.getKorisnickiNalog());
		return clan;
	}


	public void iznajmiPrimerak(Primerak primerak) {
		Date danasnjiDatum = new Date();
		Clan clan = dobaviClana();
		Iznajmljivanje iznajmljivanje = new Iznajmljivanje(danasnjiDatum,false,primerak,clan);
		primerak.setStanje(Stanje.IZNAJMLJEN);
		System.out.println(iznajmljivanje);
		SvaIznajmljivanja.getInstance().dodajPrimerak(iznajmljivanje);
		Serijalizacija serijalizacija = new Serijalizacija();
		try {
			serijalizacija.sacuvaj();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//upisi primerak zbog stanja i upisi iznajmljivanje
	}

}
