package Pogled.tabela.iznajmljivanja;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Autor;
import model.Clan;
import model.Iznajmljivanje;
import model.Korisnik;
import model.Naslov;
import model.Primerak;
import observer.Observer;
import observer.Publisher;

public class TabelaModelIznajmljivanja extends AbstractTableModel implements Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2987067730871371449L;
	private List<Iznajmljivanje> iznajmljivanja;
	private List<Observer> observers;
	
	public TabelaModelIznajmljivanja(List<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}
	
	public void dodajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanja.add(iznajmljivanje);
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return iznajmljivanja.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Datum";
		case 1:
			return "Produzeno";
		case 2:
			return "Naslov primerka";
		case 3:
			return "Inventarni broj";
		case 4:
			return "Clanska karta";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return int.class;
		case 4:
			return String.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Iznajmljivanje iznajmljivanje = iznajmljivanja.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return iznajmljivanje.getDatumIznjamljivanja();
		case 1:
			return iznajmljivanje.getProduzeno().toString();
		case 2:
			return iznajmljivanje.getPrimerak().getNaslov().getNaslovDela();
		case 3:
			return iznajmljivanje.getPrimerak().getInventarniBroj();
		case 4:
			return iznajmljivanje.getClan().getClanskaKarta().getBrojClanskeKarte();
		default:
			return "";
		}
	}

	@Override
	public void addObserver(Observer observer) {
		if (observers == null)
			observers = new ArrayList<Observer>();
		observers.add(observer);	
	}

	@Override
	public void removeObserver(Observer observer) {
		if (null == observers)
			return;
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			//observer.updatePerformed(new IzmenaTabeleEvent());
		}
	}

}
