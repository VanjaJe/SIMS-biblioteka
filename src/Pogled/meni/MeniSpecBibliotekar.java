package Pogled.meni;

public class MeniSpecBibliotekar extends Meni {

	private static final long serialVersionUID = 4294229498194545072L;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaOdjava;
	private MeniStavka stavkaDodavanjePrimerka;
	private MeniStavka stavkaPrimerci;
	private MeniStavka stavkaClanovi;
	
	public MeniSpecBibliotekar() {
		super();
		stavkaRezervacije = new MeniStavka( "Rezervacije");
		stavkaOdjava = new MeniStavka("Odjava");
		stavkaDodavanjePrimerka = new MeniStavka("Dodavanje primerka");
		stavkaPrimerci = new MeniStavka("Pregled primeraka");
		stavkaClanovi = new MeniStavka("Pregled clanova");

		add(stavkaRezervacije, "wrap, align center");
		add(stavkaDodavanjePrimerka, "wrap, align center");
		add(stavkaPrimerci, "wrap, align center");
		add(stavkaClanovi, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
		
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
	
	public MeniStavka getStavkaPrimerci() {
		return this.stavkaPrimerci;
	}
	
	public MeniStavka getStavkaClanovi() {
		return this.stavkaClanovi;
	}
}
