package model;

import java.time.LocalDate;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("clan")
public class Clan extends Korisnik{
	private ClanskaKarta clanskaKarta;
	private List<Placanje> placanja;
	
	
	public Clan(long id, String ime, String prezime, String telefon, String jmbg, String email, LocalDate datumRodjenja,
			KorisnickiNalog korisnickiNalog, ClanskaKarta clanskaKarta, List<Placanje> placanja) {
		super(id, ime, prezime, telefon, jmbg, email, datumRodjenja, korisnickiNalog);
		this.clanskaKarta = clanskaKarta;
		this.placanja = placanja;
	}

	public ClanskaKarta getClanskaKarta() {
		return clanskaKarta;
	}

	public void setClanskaKarta(ClanskaKarta clanskaKarta) {
		this.clanskaKarta = clanskaKarta;
	}
}
