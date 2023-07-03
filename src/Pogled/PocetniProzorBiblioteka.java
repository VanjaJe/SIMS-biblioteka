package Pogled;

import izuzeci.PrimerciNePostojeException;
import izuzeci.ResultEmptyException;
import kontroler.RezervacijaKontroler;

public class PocetniProzorBiblioteka {

	public PocetniProzorBiblioteka() {}
	
	public PocetniProzor napraviPocetniProzor(String uloga) throws ResultEmptyException {
		switch (uloga) {
		case "Obicni bibliotekar":
			return new PocetniProzorBibliotekar();
		case "Specijalni bibliotekar":
		return new PocetniProzorSpecBibliotekar();
		case "Clan":
			RezervacijaKontroler rk = new RezervacijaKontroler();
			try {
				rk.ProveriDostupnostRezervisanih();
			} catch (PrimerciNePostojeException e) {
				e.printStackTrace();
			}
			return new PocetniProzorClan();

		default:
			return new PocetniProzor();
		}
	}
	
}
