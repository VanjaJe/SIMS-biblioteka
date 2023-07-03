package model.podaci;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Iznajmljivanje;

@XStreamAlias("svaIznajmljivanja")
public class SvaIznajmljivanja {
	public static SvaIznajmljivanja instance = null;
	
	@XStreamAlias("iznajmljivanja")	
	private ArrayList<Iznajmljivanje> iznajmljivanja;
		
	public SvaIznajmljivanja(){
		this.iznajmljivanja = new ArrayList<Iznajmljivanje>();
	}
	
	public static SvaIznajmljivanja getInstance() {
		if (instance == null) {
			instance = new SvaIznajmljivanja();
		}
		return instance;
	}

	public long generisiId() {
		int brojNaslova = iznajmljivanja.size();
		return ++brojNaslova;
	}
	
	public static void setInstance(SvaIznajmljivanja svaIznajmljivanja) {
		instance = svaIznajmljivanja;
	}
	
	public ArrayList<Iznajmljivanje> getIznjamljivanja() {
		return this.iznajmljivanja;
	}
	
	public void setPrimerak(ArrayList<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}
	
	public Iznajmljivanje dodajPrimerak(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanja.add(iznajmljivanje);
		return iznajmljivanje;
	}
}
