package kontroler;

import java.util.List;

import model.podaci.SviIzdavaci;


public class IzdavacKontroler {
	
	
	public String[] dobaviNaziveIzdavaca() {
		List<String> izdavaci = SviIzdavaci.getInstance().dobaviNaziveIzdavaca();

		
		String[] nazivi = new String[izdavaci.size()];
		return izdavaci.toArray(nazivi);
	}
}
