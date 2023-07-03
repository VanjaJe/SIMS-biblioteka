package model.podaci;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Autor;
import model.Placanje;
@XStreamAlias("svaPlacanja")	
public class SvaPlacanja {

	public static SvaPlacanja instance = null;
		
		@XStreamAlias("placanja")	
		private ArrayList<Placanje> placanja;
			
		public SvaPlacanja(){
			this.placanja = new ArrayList<Placanje>();
		}
		
		public static SvaPlacanja getInstance() {
			if (instance == null) {
				instance = new SvaPlacanja();
			}
			
			return instance;
		}

		public long generisiId() {
			int brojPlacanja = placanja.size();
			return ++brojPlacanja;
		}
		
		public static void setInstance(SvaPlacanja svaPlacanja) {
			instance = svaPlacanja;
		}
		
		public ArrayList<Placanje> getPlacanja() {
			return this.placanja;
		}
		
		public void setPlacanja(ArrayList<Placanje> placanja) {
			this.placanja = placanja;
		}
		
		public Placanje dodajPlacanje(Placanje placanje) {
			this.placanja.add(placanje);
			return placanje;
		}

}
