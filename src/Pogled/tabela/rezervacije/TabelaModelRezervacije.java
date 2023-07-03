package Pogled.tabela.rezervacije;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Rezervacija;
import observer.Observer;
import observer.Publisher;

public class TabelaModelRezervacije extends AbstractTableModel implements Publisher {

	private static final long serialVersionUID = -2987067730871371449L;
	private List<Rezervacija> rezervacije;
	private List<Observer> observers;
	
	public TabelaModelRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	
	public void dodajRezervaciju(Rezervacija rezervacija) {
		this.rezervacije.add(rezervacija);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rezervacije.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Datum zahteva";
		case 1:
			return "Datum pocetka";
		case 2:
			return "Korisnicko ime";
		case 3:
			return "Naslov";
		case 4:
			return "Preuzeto";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return String.class;
		default:
			return null;
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Rezervacija rezervacija = rezervacije.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return rezervacija.getDatumZahtevaRezervacije().toString();
		case 1:
			return rezervacija.getDatumPocetkaRezervacije().toString();
		case 2:
			return rezervacija.getClan().getKorisnickiNalog().getKorisnickoIme();
		case 3:
			return rezervacija.getNaslov().getNaslovDela();
		case 4:
			return rezervacija.getPreuzeto().toString();
		default:
			return "";
		}
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		if (observers == null)
			observers = new ArrayList<Observer>();
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		if (null == observers)
			return;
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}
