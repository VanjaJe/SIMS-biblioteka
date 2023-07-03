package Pogled.meni;

public class MeniClan extends Meni {

	/**
	 * 
	 */
	private static final long serialVersionUID = -670002200747993656L;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaOdjava;

	
	public MeniClan() {
		super();
		stavkaRezervacije = new MeniStavka("Rezervacije");
		stavkaOdjava = new MeniStavka("Odjava");
		add(stavkaRezervacije, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");

	}
	
	public MeniStavka getStavkaRezervacije() {
		return this.stavkaRezervacije;
	}
	
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
}
