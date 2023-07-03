package kontroler;

import java.util.ArrayList;
import java.util.List;

import izuzeci.ResultEmptyException;
//import model.Cena;
//import model.Jelo;
//import model.JeloCena;
//import model.Knjiga;
//import model.podaci.CenovnikLista;
//import model.podaci.JelaLista;
import model.Naslov;
import model.podaci.SviNaslovi;

public class NaslovKontroler {
	private List<Naslov>naslovi;
	
	public NaslovKontroler() {
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
	
	
	