package kontroler;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import enums.Stanje;
import enums.TipNadoknade;
import izuzeci.MissingValueException;
import izuzeci.NaslovNePostojiException;
import izuzeci.PrimerciNePostojeException;
import izuzeci.ResultEmptyException;
import model.Clan;
import model.Iznajmljivanje;
import model.Korisnik;
import model.Naslov;
import model.Placanje;
import model.PrijavljenKorisnik;
import model.Primerak;
import model.podaci.SvaIznajmljivanja;
import model.podaci.SvaPlacanja;
import model.podaci.SviClanovi;
import model.podaci.SviKorisnici;
import model.podaci.SviNaslovi;
import model.podaci.SviPrimerci;
import serijalizacija.Serijalizacija;


public class IznajmljivanjeKontroler {
	
	private List<Iznajmljivanje>iznajmljivanja;
	
	public IznajmljivanjeKontroler() {
		iznajmljivanja = new ArrayList<Iznajmljivanje>();
		}
	
	private boolean checkIfNullOrEmpty(String input) {
		return input == null || input.equals("");
	}

	public Naslov dobaviNaslov(String unetNaslov) throws MissingValueException, NaslovNePostojiException {
		if (checkIfNullOrEmpty(unetNaslov)) {
			throw new MissingValueException("Nije validno unet naslov knjige.");
		}
		for (Naslov naslov : SviNaslovi.getInstance().getNaslovi()) {
			if(naslov.getNaslovDela().equalsIgnoreCase(unetNaslov)) {
				return naslov;
			}
		}
		throw new NaslovNePostojiException("Naslov knjige koji ste uneli se ne nalazi u sistemu biblioteke.");
	}


	public List<Primerak> dobaviPrimerke(Naslov unetNaslov) throws PrimerciNePostojeException {
		List<Primerak> primerci = new ArrayList<Primerak>();
		for (Primerak primerak : SviPrimerci.getInstance().getPrimerci()) {
			if(primerak.getNaslov().getIsbn() == unetNaslov.getIsbn()) {
				primerci.add(primerak);
			}
		}
		if(primerci.isEmpty()) {
			throw new PrimerciNePostojeException("Knjiga ne sadrzi primerke.");
		}
		return primerci;
	}
	
	
	public List<Iznajmljivanje> dobaviPrimerke() throws ResultEmptyException {
        List<Iznajmljivanje>aktivnaIznajmljivanja=new ArrayList<Iznajmljivanje>();
        for (Iznajmljivanje iznajmljivanje : SvaIznajmljivanja.getInstance().getIznajmljivanja()) {
            if(!iznajmljivanje.getZavrseno()) {
                aktivnaIznajmljivanja.add(new Iznajmljivanje(iznajmljivanje.getDatumIznjamljivanja(),iznajmljivanje.getProduzeno(),
                    iznajmljivanje.getPrimerak(),iznajmljivanje.getClan()));
        }
        }
        return aktivnaIznajmljivanja;
    }
	
	
	public Placanje naplatiNadoknadu(TipNadoknade tipNadokande, String razlog, String iznos) {
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        String dateString = currentDate.format(dateFormatter);
        Placanje placanje=new Placanje(dateString,razlog,Double.parseDouble(iznos),tipNadokande);
        SvaPlacanja.instance.dodajPlacanje(placanje);
        return placanje;
	}



	public Primerak dobaviDostupanPrimerak(List<Primerak> primerci) throws PrimerciNePostojeException {
		for(Primerak primerak : primerci) {
			Stanje dostupan = Stanje.DOSTUPAN;
			if(primerak.getStanje().equals(dostupan)) {
				return primerak;
			}
		}
		throw new PrimerciNePostojeException("Nema dostupnih primeraka");
	}
	
	public Clan dobaviClana() {
		PrijavljenKorisnik prijavljeniKorisnik = PrijavljenKorisnik.getInstance();
		String korisnickoImeClana = prijavljeniKorisnik.getKorisnickoIme();
		Korisnik korisnik = SviKorisnici.getInstance().dobaviKorisnikaPoKorisnickomImenu(korisnickoImeClana);
		Clan clan = new Clan(korisnik.getId(),korisnik.getIme(),korisnik.getPrezime(),
				korisnik.getTelefon(),korisnik.getJmbg(),korisnik.getEmail()
				,korisnik.getDatumRodjenja(),korisnik.getKorisnickiNalog());
		
		return clan;
	}


	public void iznajmiPrimerak(Primerak primerak) {
		Date danasnjiDatum = new Date();
		Clan clan = dobaviClana();
		Iznajmljivanje iznajmljivanje = new Iznajmljivanje(danasnjiDatum,false,primerak,clan);
		primerak.setStanje(Stanje.IZNAJMLJEN);
		System.out.println(iznajmljivanje);
		SvaIznajmljivanja.getInstance().dodajIznajmljivanje(iznajmljivanje);
		Serijalizacija serijalizacija = new Serijalizacija();
		try {
			serijalizacija.sacuvaj();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public HashMap<String, Integer> filtrirajNaslove() {
		HashMap<String, Integer> izvestaj = new HashMap<String, Integer>();
		
		for (Iznajmljivanje iznajmljivanje : SvaIznajmljivanja.getInstance().getIznajmljivanja()) {
			if (izvestaj.containsKey(iznajmljivanje.getPrimerak().getNaslov().getIsbn())) {
				izvestaj.put(iznajmljivanje.getPrimerak().getNaslov().getIsbn(), izvestaj.get(iznajmljivanje.getPrimerak().getNaslov().getIsbn()) + 1); 
			}
			else {
				izvestaj.put(iznajmljivanje.getPrimerak().getNaslov().getIsbn(), 1);
			}
		}
		HashMap<String, Integer> sortirana = sort(izvestaj, false);
		
		return sortirana;
	}
	
	
	public HashMap<String, Integer> sort(HashMap<String, Integer> unsortMap, final boolean order) {
		
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
	}
}

