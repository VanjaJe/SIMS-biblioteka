package model;

public class Bibliotekar extends Korisnik{
	private Boolean specijalizovan;

	public Boolean getSpecijalizovan() {
		return specijalizovan;
	}

	public void setSpecijalizovan(Boolean specijalizovan) {
		this.specijalizovan = specijalizovan;
	}

	public Bibliotekar(Boolean specijalizovan) {
		super();
		this.specijalizovan = specijalizovan;
	}

	@Override
	public String toString() {
		return "Bibliotekar [specijalizovan=" + specijalizovan + "]";
	}
	
}	
