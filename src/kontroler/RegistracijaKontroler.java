package kontroler;

import java.util.ArrayList;
import java.util.List;

import izuzeci.ResultEmptyException;
import model.Clan;
import model.Naslov;
import model.podaci.SviClanovi;
import model.podaci.SviNaslovi;

public class RegistracijaKontroler {
	private List<Clan> clanovi;
	
	public RegistracijaKontroler() {
		clanovi = new ArrayList<Clan>();
	}
	public List<Clan> dobaviClanove() throws ResultEmptyException {
		clanovi.removeAll(clanovi);
		for (Clan clan : SviClanovi.getInstance().getNaslovi()) {
			clanovi.add(clan);	
		}
		
		if (clanovi.size() == 0) {
			throw new ResultEmptyException("Nema clanova.");
		}
		
		return clanovi;

	}
}
