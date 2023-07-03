package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Rezervacija {
	private long id;
	private LocalDateTime datumZahtevaRezervacije;
	private LocalDate datumPocetkaRezervacije;
	private Boolean preuzeto;
	private Naslov naslov;
	private Clan clan;
	
	
	public Rezervacija(long id, LocalDateTime datumZahtevaRezervacije, LocalDate datumPocetkaRezervacije, Boolean preuzeto, Naslov naslov,
			Clan clan) {
		super();
		this.id = id;
		this.datumZahtevaRezervacije = datumZahtevaRezervacije;
		this.datumPocetkaRezervacije = datumPocetkaRezervacije;
		this.preuzeto = preuzeto;
		this.naslov = naslov;
		this.clan = clan;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime getDatumZahtevaRezervacije() {
		return datumZahtevaRezervacije;
	}
	public void setDatumZahtevaRezervacije(LocalDateTime datumZahtevaRezervacije) {
		this.datumZahtevaRezervacije = datumZahtevaRezervacije;
	}
	public LocalDate getDatumPocetkaRezervacije() {
		return datumPocetkaRezervacije;
	}
	public void setDatumPocetkaRezervacije(LocalDate datumPocetkaRezervacije) {
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
