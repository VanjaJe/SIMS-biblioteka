package model;

import java.time.LocalDate;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import enums.VrstaClana;

@XStreamAlias("clan")
public class Clan extends Korisnik{
	private ClanskaKarta clanskaKarta;
	private List<Placanje> placanja;
	private int popust;
	
	public Clan(long id, String ime, String prezime, String telefon, String jmbg, String email, LocalDate datumRodjenja,
            KorisnickiNalog korisnickiNalog) {
        super(id,ime,prezime,telefon,jmbg,email,datumRodjenja,korisnickiNalog);
    }
	
	public Clan(long id, String ime, String prezime, String telefon, String jmbg, String email, LocalDate datumRodjenja,
			KorisnickiNalog korisnickiNalog, int popust, ClanskaKarta clanskaKarta, List<Placanje> placanja) {
		super(id, ime, prezime, telefon, jmbg, email, datumRodjenja, korisnickiNalog);
		this.popust = popust;
		this.clanskaKarta = clanskaKarta;
		this.placanja = placanja;
	}
	

	public List<Placanje> getPlacanja() {
		return placanja;
	}

	public void setPlacanja(List<Placanje> placanja) {
		this.placanja = placanja;
	}

	public ClanskaKarta getClanskaKarta() {
		return clanskaKarta;
	}

	public void setClanskaKarta(ClanskaKarta clanskaKarta) {
		this.clanskaKarta = clanskaKarta;
	}
	
	 @Override
	    public String toString() {
	        return "Clan [clanskaKarta=" + clanskaKarta + ", placanja=" + placanja + "]";
	 }
}
