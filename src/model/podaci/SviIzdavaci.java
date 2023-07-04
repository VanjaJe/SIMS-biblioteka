package model.podaci;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Izdavac;

@XStreamAlias("sviIzdavaci")
public class SviIzdavaci {
	
	public static SviIzdavaci instance = null;
	
	@XStreamAlias("izdavaci")	
	private ArrayList<Izdavac> izdavaci;
		
	public SviIzdavaci(){
		this.izdavaci = new ArrayList<Izdavac>();
	}
	
	public static SviIzdavaci getInstance() {
		if (instance == null) {
			instance = new SviIzdavaci();
		}
		return instance;
	}

	public long generisiId() {
		int brojInventara = izdavaci.size();
		return ++brojInventara;
	}
	
	public static void setInstance(SviIzdavaci sviIzdavaci) {
		instance = sviIzdavaci;
	}
	
	public ArrayList<Izdavac> getIzdavace() {
		return this.izdavaci;
	}
	
	public void setIzdavace(ArrayList<Izdavac> izdavaci) {
		this.izdavaci = izdavaci;
	}
	
	public Izdavac dodajIzdavaca(Izdavac izdavac) {
		this.izdavaci.add(izdavac);
		return izdavac;
	}
	
	
	public Izdavac dobaviIzdavacaPoNazivu(String naziv) {
		ArrayList<Izdavac> izdavacLista = (ArrayList<Izdavac>) izdavaci
				.stream()
				.filter(korisnik -> korisnik.getNaziv().equals(naziv))
				.collect(Collectors.toList());
		if (izdavacLista.size() == 0) {
			return null;
		}
		return izdavacLista.get(0);
	}
	
	
	public ArrayList<String> dobaviNaziveIzdavaca() {
		ArrayList<String> nazivi = new ArrayList<String>();
		izdavaci.forEach(izdavac -> {
			nazivi.add(izdavac.getNaziv());
		});
		return nazivi;
	}

}
