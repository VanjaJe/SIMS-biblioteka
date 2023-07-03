package model;

public class Adresa {
	private String ulica;
	private int broj;
	private String grad;
	
	
	public Adresa(String ulica, int broj, String grad) {
		super();
		this.ulica = ulica;
		this.broj = broj;
		this.grad = grad;
	}


	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}


	@Override
	public String toString() {
		return "Adresa [ulica=" + ulica + ", broj=" + broj + ", grad=" + grad + "]";
	}
	
}
