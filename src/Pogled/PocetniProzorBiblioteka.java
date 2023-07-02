package Pogled;

import izuzeci.ResultEmptyException;

public class PocetniProzorBiblioteka {

	public PocetniProzorBiblioteka() {}
	
	public PocetniProzor napraviPocetniProzor(String uloga) throws ResultEmptyException {
		switch (uloga) {
		case "Obicni bibliotekar":
			return new PocetniProzorBibliotekar();
		case "Specijalni bibliotekar":
		return new PocetniProzorSpecBibliotekar();
		case "Clan":
			return new PocetniProzorClan();

		default:
			return new PocetniProzor();
		}
	}
	
}
