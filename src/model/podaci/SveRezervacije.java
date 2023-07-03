package model.podaci;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Rezervacija;

@XStreamAlias("sveRezervacije")
public class SveRezervacije {
	public static SveRezervacije instance = null;

    private ArrayList<Rezervacija> rezervacije;

    public SveRezervacije(){
        this.rezervacije = new ArrayList<Rezervacija>();
    }

    public static SveRezervacije getInstance() {
        if (instance == null) {
            instance = new SveRezervacije();
        }
        return instance;
    }

    public long generisiId() {
        int brojRez = rezervacije.size();
        return ++brojRez;
    }

    public static void setInstance(SveRezervacije sveRezervacije) {
        instance = sveRezervacije;
    }

    public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public Rezervacija dodajRezervaciju(Rezervacija rezervacija) {
		if (this.rezervacije == null) {
	        this.rezervacije = new ArrayList<Rezervacija>();
	    }
        this.rezervacije.add(rezervacija);
        return rezervacija;
    }

}
