package izuzeci;

public class PrimerciNePostojeException extends Exception{

	private static final long serialVersionUID = 2531125782277251691L;
	private String naslov;
	
	public PrimerciNePostojeException(String message) {
		super(message);
		this.naslov = "Naslov ne postoji";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}