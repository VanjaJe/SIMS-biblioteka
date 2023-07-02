package Pogled.tabela.naslovi;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import model.Autor;
//import model.JeloCena;
import model.Naslov;
//import observer.IzmenaTabeleEvent;
import observer.Observer;
import observer.Publisher;

public class TabelaModelNaslovi extends AbstractTableModel implements Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2987067730871371449L;
	private List<Naslov> naslovi;
	private List<Observer> observers;
	
	public TabelaModelNaslovi(List<Naslov> naslovi) {
		this.naslovi = naslovi;
	}
	
	public void dodajNaslov(Naslov naslov) {
		this.naslovi.add(naslov);
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return naslovi.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Naslov";
		case 1:
			return "Opis";
		case 2:
			return "Udk";
		case 3:
			return "Isbn";
		case 4:
			return "Autor";
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
		Naslov naslov = naslovi.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return naslov.getNaslovDela();
		case 1:
			return naslov.getOpis();
		case 2:
			return naslov.getUdk();
		case 3:
			return naslov.getIsbn();
		case 4:
			ArrayList<Autor> autori=(ArrayList<Autor>) naslov.getAutori();
			String ispis="";
			for(Autor a:autori) {
				ispis+=a.getIme()+" "+a.getPrezime()+" ";
			}
			return ispis;
			
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
