package Pogled.meni;

public class MeniBibliotekar extends Meni {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4213576067747275882L;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaOdjava;
	private MeniStavka stavkaRegistracija;
	
	public MeniBibliotekar() {
		super();
		
		stavkaRezervacije = new MeniStavka("Rezervacije");
		stavkaRegistracija = new MeniStavka("Registracija");
		stavkaOdjava = new MeniStavka("Odjava");
		
		add(stavkaRezervacije, "wrap, align center");
		add(stavkaRegistracija, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
	}
	
	public MeniStavka getStavkaRezervacije() {
		return this.stavkaRezervacije;
	}
	
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}

	public MeniStavka getStavkaRegistracija() {
		return this.stavkaRegistracija;
	}
}
