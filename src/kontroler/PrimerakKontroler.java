package kontroler;

import java.util.ArrayList;
import java.util.List;

import izuzeci.ResultEmptyException;
import model.Naslov;
import model.podaci.SviNaslovi;

public class PrimerakKontroler {
	
	private List<Naslov>naslovi;
	
	public PrimerakKontroler() {
		naslovi = new ArrayList<Naslov>();
	}
	
	public List<Naslov> dobaviNaslove() throws ResultEmptyException {
		for (Naslov naslov : SviNaslovi.getInstance().getNaslovi()) {
			naslovi.add(new Naslov(naslov.getNaslovDela(),naslov.getOpis(),naslov.getUdk(),naslov.getIsbn(),naslov.getAutori()));	
		}
		
		if (naslovi.size() == 0) {
			throw new ResultEmptyException("Nema naslova.");
		}
		return naslovi;
	}
}
