package kontroler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import enums.Stanje;
import izuzeci.MissingValueException;
import izuzeci.NaslovNePostojiException;
import izuzeci.PrimerciNePostojeException;
import model.Clan;
import model.Korisnik;
import model.Naslov;
import model.PrijavljenKorisnik;
import model.Primerak;
import model.Rezervacija;
import model.podaci.SveRezervacije;
import model.podaci.SviKorisnici;
import model.podaci.SviNaslovi;
import model.podaci.SviPrimerci;
import serijalizacija.Serijalizacija;

public class RezervacijaKontroler {
	
	public RezervacijaKontroler() {
		
	}
	
	private Rezervacija DobaviRezervaciju(long id) {
		for (Rezervacija rezervacija : DobaviRezervacije()) {
			if (rezervacija.getId() == id) {
				return rezervacija;
			}
		}
		return null;
	}
	
	public List<Rezervacija> DobaviRezervacije() {
		List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
		for (Rezervacija rezervacija : SveRezervacije.getInstance().getRezervacije()) {
			rezervacije.add(rezervacija);
		}
		return rezervacije;
	}
	
	public List<Rezervacija> DobaviLicneRezervacije() {
		List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
		Clan clan = DobaviClana();
		for (Rezervacija rezervacija : DobaviRezervacije()) {
			if (rezervacija.getClan().equals(clan)) {
				rezervacije.add(rezervacija);
			}
		}
		return rezervacije;
	}
	
	private boolean DaLiJeValidno(String tekst) {
		return tekst == null || tekst.equals("");
	}
	
	public Naslov DobaviNaslov(String unetNaslov) throws MissingValueException, NaslovNePostojiException {
		if (DaLiJeValidno(unetNaslov)) {
			throw new MissingValueException("Nije validno unet naslov knjige.");
		}
		for (Naslov naslov : SviNaslovi.getInstance().getNaslovi()) {
			if(naslov.getNaslovDela().equalsIgnoreCase(unetNaslov)) {
				return naslov;
			}
		}
		throw new NaslovNePostojiException("Naslov knjige koji ste uneli se ne nalazi u sistemu biblioteke.");
	}
	
	public List<Primerak> DobaviPrimerke(Naslov unetNaslov) throws PrimerciNePostojeException {
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
	
	public boolean ImaLiDostupnihPrimeraka(Naslov naslov) throws PrimerciNePostojeException {
		for (Primerak primerak : DobaviPrimerke(naslov)) {
			if (primerak.getStanje().equals(Stanje.DOSTUPAN)) {
				return true;
			}
		}
		return false;
	}
	
	public Primerak DobaviDostupanPrimerak(List<Primerak> primerci) {
		Primerak pr = null;
		for(Primerak primerak : primerci) {
			if(primerak.getStanje().equals(Stanje.DOSTUPAN)) {
				pr = primerak;
			}
		}
		return pr;
		//throw new PrimerciNePostojeException("Nema dostupnih primeraka");
	}
	
	public Clan DobaviClana() {
		PrijavljenKorisnik prijavljeniKorisnik = PrijavljenKorisnik.getInstance();
		String korisnickoImeClana = prijavljeniKorisnik.getKorisnickoIme();
		Korisnik korisnik = SviKorisnici.getInstance().dobaviKorisnikaPoKorisnickomImenu(korisnickoImeClana);
		Clan clan = new Clan(korisnik.getId(),korisnik.getIme(),korisnik.getPrezime(),
				korisnik.getTelefon(),korisnik.getJmbg(),korisnik.getEmail(),
				korisnik.getDatumRodjenja(),korisnik.getKorisnickiNalog());
		
		return clan;
	}
	
	public List<Clan> GetListaCekanja(Naslov naslov) {
		List<Clan> clanovi = new ArrayList<Clan>();
		List<Rezervacija> sveRezervacije = SveRezervacije.getInstance().getRezervacije();
		// sortira rezervacije po vremenu, a onda tim redom dodaje clanove u listu
		if (sveRezervacije!=null) {
			sveRezervacije.sort((r1, r2) -> r1.getDatumZahtevaRezervacije().compareTo(r2.getDatumZahtevaRezervacije()));
			for(Rezervacija rezervacija : sveRezervacije) {
				if (rezervacija.getNaslov().equals(naslov)) {
					clanovi.add(rezervacija.getClan());
				}
			}
		}
		return clanovi;
	}
	
	public void Rezervisi(Naslov naslov) throws PrimerciNePostojeException {
		LocalDateTime danasnjiDatum = LocalDateTime.now();
		Clan clan = DobaviClana();
		if (GetListaCekanja(naslov).contains(clan)) {
			JOptionPane.showMessageDialog(null, "Vec ste napravili rezervaciju za ovaj naslov!", "Greska", JOptionPane.WARNING_MESSAGE);
		}
		else {
			Rezervacija rezervacija;
			if (ImaLiDostupnihPrimeraka(naslov)) {
				// rezervacija uspesna, moze da dodje u roku od 2 dana
				Primerak primerak = DobaviDostupanPrimerak(DobaviPrimerke(naslov));
				primerak.setStanje(Stanje.REZERVISAN);
				rezervacija = new Rezervacija(SveRezervacije.getInstance().generisiId(), danasnjiDatum, LocalDate.now(), false, naslov, clan);
				JOptionPane.showMessageDialog(null, "Kreirana rezervacija! Mozete preuzeti knjigu u narednih 48 sati.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			} else {
				// rezervacija uspesna, obavesti kad bude dostupan primerak
				rezervacija = new Rezervacija(SveRezervacije.getInstance().generisiId(), danasnjiDatum, LocalDate.of(9999, 12, 31), false, naslov, clan);
				JOptionPane.showMessageDialog(null, "Kreirana rezervacija! Obavesticemo Vas kada primerak bude dostupan.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			}
			SveRezervacije.getInstance().dodajRezervaciju(rezervacija);
			Serijalizacija serijalizacija = new Serijalizacija();
			try {
				serijalizacija.sacuvaj();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ProveriDostupnostRezervisanih() throws PrimerciNePostojeException {
		List<Rezervacija> rezervacije = DobaviLicneRezervacije();
		for (Rezervacija rezervacija : rezervacije) {
			Naslov naslov = rezervacija.getNaslov();
			if (ImaLiDostupnihPrimeraka(naslov) && !rezervacija.getPreuzeto()) {
				Primerak primerak = DobaviDostupanPrimerak(DobaviPrimerke(naslov));
				primerak.setStanje(Stanje.REZERVISAN);
				rezervacija = DobaviRezervaciju(rezervacija.getId());
				rezervacija.setDatumPocetkaRezervacije(LocalDate.now());
				String obavestenje = "Knjiga \"" + naslov.getNaslovDela() + "\" je sada dostupna.\n"
	                    + "Imate 48 sati da je preuzmete.";
				JOptionPane.showMessageDialog(null, obavestenje, "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
}
