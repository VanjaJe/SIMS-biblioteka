package kontroler;

import java.util.List;

import model.podaci.SviInventari;

public class InventarKontroler {
	
	public String[] dobaviNaziveInventara() {
		List<String> inventari = SviInventari.getInstance().dobaviNaziveInventara();
		
		String[] nazivi = new String[inventari.size()];
		return inventari.toArray(nazivi);
	}
}
