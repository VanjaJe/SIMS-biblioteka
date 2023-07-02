package model;

import java.util.Date;

public class DrzavniPraznik {
	private String naziv;
	private Date datum;
	
	
	public DrzavniPraznik(String naziv, Date datum) {
		super();
		this.naziv = naziv;
		this.datum = datum;
	}


	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getDatum() {
		return datum;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
	}
}
