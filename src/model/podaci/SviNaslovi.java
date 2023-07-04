package model.podaci;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Naslov;
import model.Autor;
import model.Korisnik;


@XStreamAlias("sviNaslovi")
public class SviNaslovi {
	public static SviNaslovi instance = null;
	
	@XStreamAlias("naslovi")	
	private ArrayList<Naslov> naslovi;
		
	public SviNaslovi(){
		this.naslovi = new ArrayList<Naslov>();
	}
	
	public static SviNaslovi getInstance() {
		if (instance == null) {
			instance = new SviNaslovi();
		}
		
		return instance;
	}

	public long generisiId() {
		int brojNaslova = naslovi.size();
		return ++brojNaslova;
	}
	
	public static void setInstance(SviNaslovi sviNaslovi) {
		instance = sviNaslovi;
	}
	
	public ArrayList<Naslov> getNaslovi() {
		return this.naslovi;
	}
	
	public void setNaslovi(ArrayList<Naslov> naslovi) {
		this.naslovi = naslovi;
	}
	
	public Naslov dodajNaslov(Naslov naslov) {
		this.naslovi.add(naslov);
		return naslov;
	}

		
	public List<String> dobaviSveISBNBrojeve(String korisnickoIme) {
		ArrayList<String> isbn = new ArrayList<String>();
		naslovi.forEach(inventar -> {
			isbn.add(inventar.getIsbn());
		});
		return isbn;
	}
	
	
	public void izmeniNaslov(String naslovDela, String opis, String udk, String isbn, List<Autor> autori) {
		Naslov naslov = dobaviNaslovPoISBN(isbn);
		naslov.setNaslovDela(naslovDela);
		naslov.setOpis(opis);
		naslov.setUdk(udk);
		naslov.setIsbn(isbn);
		naslov.setAutori(autori);
		
		for (int i = 0; i < naslovi.size(); i++) {
			if (naslovi.get(i).getIsbn() == naslov.getIsbn()) {
				naslovi.remove(i);
				naslovi.add(i, naslov);
			}
		}
	}
	
	public Naslov obrisiNaslov(Naslov naslov) {
		this.naslovi.remove(naslov);
		return naslov;
	}
	

	public Naslov dobaviNaslovPoISBN(String isbn) {
		ArrayList<Naslov> naslovLista = (ArrayList<Naslov>) naslovi
				.stream()
				.filter(naslov -> naslov.getIsbn().equals(isbn))
				.collect(Collectors.toList());
		if (naslovLista.size() == 0) {
			return null;
		}
		
		return naslovLista.get(0);
	}
}
