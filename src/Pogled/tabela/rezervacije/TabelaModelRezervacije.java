package Pogled.tabela.rezervacije;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Rezervacija;
import observer.IzmenaTabeleEvent;
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
		return 7;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ID rezervacije";
		case 1:
			return "Datum zahteva";
		case 2:
			return "Datum pocetka";
		case 3:
			return "Korisnicko ime";
		case 4:
			return "Naslov";
		case 5:
			return "Preuzeto";
		case 6:
			return "Istekla";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return long.class;
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
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
			return rezervacija.getId();
		case 1:
			return rezervacija.getDatumZahtevaRezervacije().toString();
		case 2:
			return rezervacija.getDatumPocetkaRezervacije().toString();
		case 3:
			return rezervacija.getClan().getKorisnickiNalog().getKorisnickoIme();
		case 4:
			return rezervacija.getNaslov().getNaslovDela();
		case 5:
			return rezervacija.getPreuzeto().toString();
		case 6:
			return rezervacija.getIstekla().toString();
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
		for (Observer observer : observers) {
			observer.updatePerformed(new IzmenaTabeleEvent());
		}
	}

}
