package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Rezervacija {
	private long id;
	private LocalDateTime datumZahtevaRezervacije;
	private LocalDate datumPocetkaRezervacije;
	private Boolean preuzeto;
	private Boolean istekla;
	private Naslov naslov;
	private int invBrPrimerka;
	private Clan clan;
	
	
	public Rezervacija(long id, LocalDateTime datumZahtevaRezervacije, LocalDate datumPocetkaRezervacije, Boolean preuzeto, Boolean istekla, Naslov naslov,
			int invBrPrimerka, Clan clan) {
		super();
		this.id = id;
		this.datumZahtevaRezervacije = datumZahtevaRezervacije;
		this.datumPocetkaRezervacije = datumPocetkaRezervacije;
		this.preuzeto = preuzeto;
		this.istekla = istekla;
		this.naslov = naslov;
		this.invBrPrimerka = invBrPrimerka;
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
	public Boolean getIstekla() {
		return istekla;
	}
	public void setIstekla(Boolean istekla) {
		this.istekla = istekla;
	}
	public Naslov getNaslov() {
		return naslov;
	}
	public void setNaslov(Naslov naslov) {
		this.naslov = naslov;
	}
	public int getInvBrPrimerka() {
		return invBrPrimerka;
	}
	public void setInvBrPrimerka(int invBrPrimerka) {
		this.invBrPrimerka = invBrPrimerka;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
}
