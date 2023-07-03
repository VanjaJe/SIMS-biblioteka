package kontroler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import enums.Stanje;
import enums.TipNadoknade;
import izuzeci.ResultEmptyException;
import model.Iznajmljivanje;
import model.Naslov;
import model.Placanje;
import model.Primerak;
import model.podaci.SvaIznajmljivanja;
import model.podaci.SvaPlacanja;
import model.podaci.SviPrimerci;
public class IznajmljivanjeKontroler {
	private List<Iznajmljivanje>iznajmljivanja;
	
	public IznajmljivanjeKontroler() {
		iznajmljivanja = new ArrayList<Iznajmljivanje>();
	}
	public List<Iznajmljivanje> dobaviPrimerke() throws ResultEmptyException {
		for (Iznajmljivanje iznajmljivanje : SvaIznajmljivanja.getInstance().getIznajmljivanja()) {
			if(SviPrimerci.instance.dobaviStanjePrimerka(iznajmljivanje.getPrimerak().getInventarniBroj())
					==Stanje.IZNAJMLJEN) {
			iznajmljivanja.add(new Iznajmljivanje(iznajmljivanje.getDatumIznjamljivanja(),iznajmljivanje.getProduzeno(),
					iznajmljivanje.getPrimerak(),iznajmljivanje.getClan()));	
		}
		}
		
		return iznajmljivanja;

	}
	public void naplatiNadoknadu(TipNadoknade tipNadokande, String razlog, String iznos) {
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        String dateString = currentDate.format(dateFormatter);
        Placanje placanje=new Placanje(dateString,razlog,Double.parseDouble(iznos),tipNadokande);
        SvaPlacanja.instance.dodajPlacanje(placanje);
        
		
	}

}
