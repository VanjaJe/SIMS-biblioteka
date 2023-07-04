package Pogled.tabela.primerci;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Autor;
import model.Naslov;
import model.Primerak;
import observer.Observer;
import observer.Publisher;

public class TabelaModelPrimerci extends AbstractTableModel implements Publisher {
	private static final long serialVersionUID = -2987067730871371449L;
	private List<Primerak> primerci;
	private List<Observer> observers;
	
	public TabelaModelPrimerci(List<Primerak> primerci) {
		this.primerci = primerci;
	}
	
	public void dodajNaslov(Primerak primerak) {
		this.primerci.add(primerak);
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return primerci.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Inventarni broj";
		case 1:
			return "Naslov";
		case 2:
			return "Stanje";
		case 3:
			return "Jezik";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
		case 2:
		case 3:
			return String.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Primerak primerak = primerci.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return primerak.getInventarniBroj();
		case 1:
			return primerak.getNaslov().getNaslovDela();
		case 2:
			return primerak.getStanje().toString();
		case 3:
			return primerak.getJezik();
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
