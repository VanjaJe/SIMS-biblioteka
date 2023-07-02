package model;

import java.util.Date;

public class Rezervacija {
	private Date datumZahtevaRezervacije;
	private Date datumPocetkaRezervacije;
	private Boolean preuzeto;
	private Naslov naslov;
	private Clan clan;
	
	
	public Rezervacija(Date datumZahtevaRezervacije, Date datumPocetkaRezervacije, Boolean preuzeto, Naslov naslov,
			Clan clan) {
		super();
		this.datumZahtevaRezervacije = datumZahtevaRezervacije;
		this.datumPocetkaRezervacije = datumPocetkaRezervacije;
		this.preuzeto = preuzeto;
		this.naslov = naslov;
		this.clan = clan;
	}
	
	
	public Date getDatumZahtevaRezervacije() {
		return datumZahtevaRezervacije;
	}
	public void setDatumZahtevaRezervacije(Date datumZahtevaRezervacije) {
		this.datumZahtevaRezervacije = datumZahtevaRezervacije;
	}
	public Date getDatumPocetkaRezervacije() {
		return datumPocetkaRezervacije;
	}
	public void setDatumPocetkaRezervacije(Date datumPocetkaRezervacije) {
		this.datumPocetkaRezervacije = datumPocetkaRezervacije;
	}
	public Boolean getPreuzeto() {
		return preuzeto;
	}
	public void setPreuzeto(Boolean preuzeto) {
		this.preuzeto = preuzeto;
	}
	public Naslov getNaslov() {
		return naslov;
	}
	public void setNaslov(Naslov naslov) {
		this.naslov = naslov;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
}
