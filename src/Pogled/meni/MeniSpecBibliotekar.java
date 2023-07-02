package Pogled.meni;

public class MeniSpecBibliotekar extends Meni {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4294229498194545072L;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaOdjava;
	
	public MeniSpecBibliotekar() {
		super();
		stavkaRezervacije = new MeniStavka( "Rezervacije");
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
