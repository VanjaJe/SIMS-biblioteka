package model;

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
}
