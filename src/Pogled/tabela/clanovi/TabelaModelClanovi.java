package Pogled.tabela.clanovi;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Autor;
import model.Clan;
import observer.Observer;
import observer.Publisher;

public class TabelaModelClanovi extends AbstractTableModel implements Publisher {
	private List<Clan> clanovi;
	private List<Observer> observers;
	
	public TabelaModelClanovi(List<Clan> clanovi) {
		this.clanovi = clanovi;
	}
	
	public void dodajClana(Clan clan) {
		this.clanovi.add(clan);
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return clanovi.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Ime";
		case 1:
			return "Prezime";
		case 2:
			return "Email";
		case 3:
			return "Korisnicko ime";
		case 4:
			return "Broj clanske karte";
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
			return String.class;
		case 4:
			return Integer.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Clan clan = clanovi.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return clan.getIme();
		case 1:
			return clan.getPrezime();
		case 2:
			return clan.getEmail();
		case 3:
			return clan.getKorisnickiNalog().getKorisnickoIme();
		case 4:
			return clan.getClanskaKarta().getBrojClanskeKarte();
			
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
