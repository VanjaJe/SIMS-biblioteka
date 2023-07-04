package model.podaci;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Inventar;


@XStreamAlias("sviInventari")
public class SviInventari {
	
	public static SviInventari instance = null;
	
	@XStreamAlias("inventari")	
	private ArrayList<Inventar> inventari;
		
	public SviInventari(){
		this.inventari = new ArrayList<Inventar>();
	}
	
	public static SviInventari getInstance() {
		if (instance == null) {
			instance = new SviInventari();
		}
		return instance;
	}

	public long generisiId() {
		int brojInventara = inventari.size();
		return ++brojInventara;
	}
	
	public static void setInstance(SviInventari sviInventari) {
		instance = sviInventari;
	}
	
	public ArrayList<Inventar> getInventari() {
		return this.inventari;
	}
	
	public void setInventari(ArrayList<Inventar> inventari) {
		this.inventari = inventari;
	}
	
	public Inventar dodajInventar(Inventar inventar) {
		this.inventari.add(inventar);
		return inventar;
	}
	
	
	public ArrayList<String> dobaviNaziveInventara() {
		ArrayList<String> nazivi = new ArrayList<String>();
		inventari.forEach(inventar -> {
			nazivi.add(inventar.getNaziv());
		});
		return nazivi;
	}
	
	
	public Inventar dobaviInventarPoNazivu(String naziv) {
	ArrayList<Inventar> iznventarLista = (ArrayList<Inventar>) inventari
			.stream()
			.filter(korisnik -> korisnik.getNaziv().equals(naziv))
			.collect(Collectors.toList());
		if (iznventarLista.size() == 0) {
			return null;
		}
	return iznventarLista.get(0);
	}
}

