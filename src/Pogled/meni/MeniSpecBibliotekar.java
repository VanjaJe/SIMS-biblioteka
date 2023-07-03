package Pogled.meni;

public class MeniSpecBibliotekar extends Meni {

	private static final long serialVersionUID = 4294229498194545072L;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaOdjava;
	private MeniStavka stavkaDodavanjePrimerka;
	private MeniStavka stavkaIzvestaj;
	
	public MeniSpecBibliotekar() {
		super();
		stavkaRezervacije = new MeniStavka( "Rezervacije");
		stavkaOdjava = new MeniStavka("Odjava");
		stavkaDodavanjePrimerka = new MeniStavka("Dodavanje primerka");

		add(stavkaRezervacije, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
		add(stavkaDodavanjePrimerka, "wrap, align center");
	}
	
	public MeniStavka getStavkaRezervacije() {
		return this.stavkaRezervacije;
	}

	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
	
	public MeniStavka getStavkaDodavanjePrimerka() {
		return this.stavkaDodavanjePrimerka;
	}
}
