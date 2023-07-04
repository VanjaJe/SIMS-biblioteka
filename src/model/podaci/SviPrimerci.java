package model.podaci;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import enums.Stanje;
import model.Autor;
import model.Naslov;
import model.Primerak;


@XStreamAlias("sviPrimerci")
public class SviPrimerci {
	public static SviPrimerci instance = null;
	
	@XStreamAlias("primerci")	
	private ArrayList<Primerak> primerci;
		
	public SviPrimerci(){
		this.primerci = new ArrayList<Primerak>();
	}
	
	public static SviPrimerci getInstance() {
		if (instance == null) {
			instance = new SviPrimerci();
		}
		return instance;
	}

	public long generisiId() {
		int brojNaslova = primerci.size();
		return ++brojNaslova;
	}
	
	public static void setInstance(SviPrimerci sviPrimerci) {
		instance = sviPrimerci;
	}
	
	public ArrayList<Primerak> getPrimerci() {
		return this.primerci;
	}
	
	public void setPrimerak(ArrayList<Primerak> primerci) {
		this.primerci = primerci;
	}
	
	public Primerak dodajPrimerak(Primerak primerak) {
		this.primerci.add(primerak);
		return primerak;
	}
	
	public void postaviStanjePrimerka(int invBroj, Stanje stanje) {

		for (Primerak primerak:primerci) {
			if (primerak.getInventarniBroj()==invBroj) 
			{
				primerak.setStanje(stanje);
			}
		}
		
	}
	public  Stanje dobaviStanjePrimerka(int invBroj) {
		for (Primerak primerak:primerci) {
			if (primerak.getInventarniBroj()==invBroj) 
			{
				return primerak.getStanje();
			}
		}
		return null;
	}
	
	public void izmeniNaslov(Naslov naslov, int inventarniBr) {
		Primerak primerak = dobaviPrimerakPoInventaru(inventarniBr);
		
		primerak.setNaslov(naslov);
		
		for (int i = 0; i < primerci.size(); i++) {
			if (primerci.get(i).getInventarniBroj() == inventarniBr) {
				primerci.remove(i);
				primerci.add(i, primerak);
			}
		}
	}
	
	public Primerak dobaviPrimerakPoInventaru(int inventarniBr) {
		ArrayList<Primerak> primerakLista = (ArrayList<Primerak>) primerci
				.stream()
				.filter(primerak -> primerak.getInventarniBroj() == inventarniBr)
				.collect(Collectors.toList());
		if (primerakLista.size() == 0) {
			return null;
		}
		
		return primerakLista.get(0);
	}
	
	public List<Primerak> dobaviPrimerkePoISBN(String isbn) {
		ArrayList<Primerak> primerakLista = (ArrayList<Primerak>) primerci
				.stream()
				.filter(primerak -> primerak.getNaslov().getIsbn().equals(isbn))
				.collect(Collectors.toList());
		if (primerakLista.size() == 0) {
			return null;
		}
		
		return primerakLista;
	}
}
