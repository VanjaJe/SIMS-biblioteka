package kontroler;

import java.util.ArrayList;
import java.util.List;

import model.Autor;
import model.podaci.SviAutori;


public class AutorKontroler {
	
	
	public String[] dobaviNaziveAutora() {
		List<String> autori = SviAutori.getInstance().dobaviNaziveAutora();
		
		String[] nazivi = new String[autori.size()];
		return autori.toArray(nazivi);
	}
	
	
	public Autor dobaviAutoraPoImenuIPrezimenu(String ime, String prezime) {
		ArrayList<Autor> autori = SviAutori.getInstance().getAutori();
		for (Autor autor : autori) {
			if (autor.getIme().equals(ime) && autor.getPrezime().equals(prezime)) {
				return autor;
			}
		}
		return null;
	}
	
	public Boolean proveriZauzetostISBN(String isbn) {
		List<String> listaISBN = SviAutori.getInstance().dobaviNaziveAutora();
		
		if (listaISBN.contains(isbn)) {
			return true;
		}
		return false;
	}
}
