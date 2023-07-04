package kontroler;

import java.util.ArrayList;
import java.util.List;

import izuzeci.ResultEmptyException;
import model.Naslov;
import model.Primerak;
import model.podaci.SviNaslovi;
import model.podaci.SviPrimerci;

public class PrimerakKontroler {
	
	private List<Primerak>primerci;
	
	public PrimerakKontroler() {
		primerci = new ArrayList<Primerak>();
	}
	
	public List<Primerak> dobaviPrimerke() throws ResultEmptyException {
		for (Primerak primerak : SviPrimerci.getInstance().getPrimerci()) {
			primerci.add(new Primerak(primerak.getInventarniBroj(), primerak.getJezik(), primerak.getFormat(), 
					primerak.getTipKoricenja(), primerak.getStanje(), primerak.getInventar(), primerak.getNaslov()));	
		}
		
		if (primerci.size() == 0) {
			throw new ResultEmptyException("Nema primerka.");
		}
		return primerci;
	}
}
