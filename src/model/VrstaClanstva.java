package model;

import java.util.List;

import enums.VrstaClana;

public class VrstaClanstva {
	private VrstaClana tipClanstva;
	private int maxBrKnjiga;
	private int maxBrDana;
	private List<Cenovnik> cenovnici;
	private List<ClanskaKarta> clanskeKarte;
	
	
	
	public VrstaClana getTipClanstva() {
		return tipClanstva;
	}
	public void setTipClanstva(VrstaClana tipClanstva) {
		this.tipClanstva = tipClanstva;
	}
	public int getMaxBrKnjiga() {
		return maxBrKnjiga;
	}
	public void setMaxBrKnjiga(int maxBrKnjiga) {
		this.maxBrKnjiga = maxBrKnjiga;
	}
	public int getMaxBrDana() {
		return maxBrDana;
	}
	public void setMaxBrDana(int maxBrDana) {
		this.maxBrDana = maxBrDana;
	}
	public List<Cenovnik> getCenovnici() {
		return cenovnici;
	}
	public void setCenovnici(List<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}
	public List<ClanskaKarta> getClanskeKarte() {
		return clanskeKarte;
	}
	public void setClanskeKarte(List<ClanskaKarta> clanskeKarte) {
		this.clanskeKarte = clanskeKarte;
	}
}
