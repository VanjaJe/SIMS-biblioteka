package Pogled.meni;

public class MeniClan extends Meni {

	/**
	 * 
	 */
	private static final long serialVersionUID = -670002200747993656L;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaOdjava;
	private MeniStavka stavkaIznajmljivanje;
	
	public MeniClan() {
		super();
		stavkaRezervacije = new MeniStavka("Rezervacije");
		stavkaIznajmljivanje = new MeniStavka("Iznajmljivanje");
		stavkaOdjava = new MeniStavka("Odjava");
		add(stavkaRezervacije, "wrap, align center");
		add(stavkaIznajmljivanje, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");

	}
	
	public MeniStavka getStavkaIznajmljivanje() {
		return this.stavkaIznajmljivanje;
	}
	public MeniStavka getStavkaRezervacije() {
		return this.stavkaRezervacije;
	}
	
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
}
