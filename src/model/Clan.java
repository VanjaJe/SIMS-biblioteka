package model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("clan")
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
