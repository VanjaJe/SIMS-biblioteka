package model;

import java.util.List;

import enums.VrstaClana;

public class VrstaClanstva {
	private VrstaClana tipClanstva;
	private int maxBrKnjiga;
	private int maxBrDana;
	private List<Cenovnik> cenovnici;
	
	public VrstaClanstva(VrstaClana tipClanstva, int maxBrKnjiga, int maxBrDana, List<Cenovnik> cenovnici) {
		super();
		this.tipClanstva = tipClanstva;
		this.maxBrKnjiga = maxBrKnjiga;
		this.maxBrDana = maxBrDana;
		this.cenovnici = cenovnici;
	}
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
}
