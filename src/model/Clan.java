package model;

import java.time.LocalDate;
import java.util.List;

public class Clan extends Korisnik{
	private ClanskaKarta clanskaKarta;
	private List<Placanje> placanja;
	
	
	public ClanskaKarta getClanskaKarta() {
		return clanskaKarta;
	}

	public void setClanskaKarta(ClanskaKarta clanskaKarta) {
		this.clanskaKarta = clanskaKarta;
	}

	
	public Clan(long id, String ime, String prezime, String telefon, String jmbg, String email, LocalDate datumRodjenja,
			KorisnickiNalog korisnickiNalog) {
		super(id,ime,prezime,telefon,jmbg,email,datumRodjenja,korisnickiNalog);
	}

	@Override
	public String toString() {
		return "Clan [clanskaKarta=" + clanskaKarta + ", placanja=" + placanja + "]";
	}
	
}
