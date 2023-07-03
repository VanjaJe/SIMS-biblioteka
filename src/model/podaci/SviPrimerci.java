package model.podaci;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import enums.Stanje;
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

}
