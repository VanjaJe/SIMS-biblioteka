package kontroler;

import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import model.Korisnik;
import model.PrijavljenKorisnik;
import model.podaci.SviKorisnici;


public class LogInKontroler {
	
	public LogInKontroler() {}
	
	public String login(String korisnickoIme, String lozinka) throws MissingValueException, BadCredentialsException {
		if (checkIfNullOrEmpty(korisnickoIme)) {
			throw new MissingValueException("Nije validno uneto korisnicko ime.");
		} else if (checkIfNullOrEmpty(lozinka)) {
			throw new MissingValueException("Nije validno uneta lozinka.");
		}
		
		Korisnik korisnik = SviKorisnici.getInstance().dobaviKorisnikaPoKorisnickomImenu(korisnickoIme);
		if (korisnik == null || !korisnik.getKorisnickiNalog().getLozinka().equals(lozinka)) {
			throw new BadCredentialsException("Uneseni kredencijali nisu odgovarajuci.");
		}
		
		PrijavljenKorisnik prijavljenKorisnik = PrijavljenKorisnik.getInstance();
		prijavljenKorisnik.setKorisnickoIme(korisnickoIme);
		prijavljenKorisnik.setTipKorisnika(korisnik.getKorisnickiNalog().getTipKorisnika());
		
		return korisnik.getKorisnickiNalog().getTipKorisnika().toString();
	}
	
	private boolean checkIfNullOrEmpty(String input) {
		return input == null || input.equals("");
	}
}
