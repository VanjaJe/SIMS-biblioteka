package model.podaci;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Autor;
import model.Naslov;

//@XStreamAlias("sviAutori")	
public class SviAutori {
public static SviAutori instance = null;
	
	@XStreamAlias("autori")	
	private ArrayList<Autor> autori;
		
	public SviAutori(){
		this.autori = new ArrayList<Autor>();
	}
	
	public static SviAutori getInstance() {
		if (instance == null) {
			instance = new SviAutori();
		}
		
		return instance;
	}

	public long generisiId() {
		int brojAutora = autori.size();
		return ++brojAutora;
	}
	
	public static void setInstance(SviAutori sviAutori) {
		instance = sviAutori;
	}
	
	public ArrayList<Autor> getAutori() {
		return this.autori;
	}
	
	public void setNaslovi(ArrayList<Autor> autori) {
		this.autori = autori;
	}
	
	public Autor dodajAutora(Autor autor) {
		this.autori.add(autor);
		return autor;
	}

}
