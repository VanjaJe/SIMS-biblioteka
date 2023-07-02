package Pogled.meni;

public class MeniBiblioteka {

	public MeniBiblioteka() {}
	
	public Meni napraviMeni(String uloga) {
		switch (uloga) {
		case "Obicni bibliotekar":
			return new MeniBibliotekar();
		case "Specijalni bibliotekar":
			return new MeniSpecBibliotekar();
		case "Clan":
			return new MeniClan();
		default:
			return new Meni();
		}
	}
	
}
