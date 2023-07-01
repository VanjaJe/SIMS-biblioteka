package Pogled;


public class PocetniProzorBiblioteka {

	public PocetniProzorBiblioteka() {}
	
	public PocetniProzor napraviPocetniProzor(String uloga) {
		switch (uloga) {
		case "Specijalni biblitekar":
//			return new PocetniProzorVlasnik();
			System.out.println("spec");
		case "Obicni biblitekar":
//			return new PocetniProzorMenadzer();
			System.out.println("obic");
		case "Clan":
//			return new PocetniProzorSef();
			System.out.println("clan");
		default:
			return new PocetniProzor();
		}
	}
	
}
