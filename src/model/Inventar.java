package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("inventar")
public class Inventar {
	private String naziv;
	private String identifikacioniBroj;
	

	public Inventar(String naziv, String identifikacioniBroj) {
		super();
		this.naziv = naziv;
		this.identifikacioniBroj = identifikacioniBroj;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}
	
	public void setIdentifikacioniBroj(String identifikacioniBroj) {
		this.identifikacioniBroj = identifikacioniBroj;
	}	
}
