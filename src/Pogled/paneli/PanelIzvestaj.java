package Pogled.paneli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Pogled.tabela.naslovi.TabelaModelNaslovi;
import Pogled.tabela.naslovi.TabelaNaslovi;
import izuzeci.ResultEmptyException;
import kontroler.IznajmljivanjeKontroler;
import kontroler.NaslovKontroler;
import model.Naslov;
import observer.Observer;
import util.PogledUtil;

public class PanelIzvestaj  extends JPanel implements Observer {

	private static final long serialVersionUID = 1186414723010863699L;
	private List<Naslov> naslovi;
	private NaslovKontroler naslovKontroler;
	private IznajmljivanjeKontroler iznajmljivanjeKontroler;
	
	private TabelaNaslovi tabelaKnjiga;

	public PanelIzvestaj() throws ResultEmptyException {
		setName("Izvestaj");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(Color.WHITE);
		
		naslovKontroler = new NaslovKontroler();
		iznajmljivanjeKontroler = new IznajmljivanjeKontroler();
		
		//this.naslovi=naslovKontroler.dobaviNaslove();
		
		filtrirajNaslove();

		this.inicijalizujTabeluKnjiga();
	}
	
	public void filtrirajNaslove() {
		HashMap<String, Integer> mapa = iznajmljivanjeKontroler.filtrirajNaslove();
		this.naslovi = new ArrayList<Naslov>();
		
		int brojac = 0;
		for (Entry<String, Integer> entry : mapa.entrySet())
        {
            brojac++;
            if (brojac <= 3) {
            	Naslov naslov = naslovKontroler.dobaviNaslovPoISBN(entry.getKey());
            	naslovi.add(naslov);
            }
        }
	}
	
	private void inicijalizujTabeluKnjiga() {
		
		TabelaModelNaslovi tabelaModelNaslovi= new TabelaModelNaslovi(naslovi);
		tabelaModelNaslovi.addObserver(this);
		this.tabelaKnjiga = new TabelaNaslovi(tabelaModelNaslovi);
		 final TableColumnModel columnModel = tabelaKnjiga.getColumnModel();
		    for (int column = 0; column < tabelaKnjiga.getColumnCount(); column++) {
		        int width = 15; // Min width
		        for (int row = 0; row < tabelaKnjiga.getRowCount(); row++) {
		            TableCellRenderer renderer = tabelaKnjiga.getCellRenderer(row, column);
		            Component comp = tabelaKnjiga.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnModel.getColumn(column).setPreferredWidth(width);
		    }
		

		tabelaKnjiga.setPreferredScrollableViewportSize(new Dimension(630,300));
		tabelaKnjiga.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(tabelaKnjiga);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelNaslovi model = (TabelaModelNaslovi) tabelaKnjiga.getModel();
		model.fireTableDataChanged();
		validate();
	}

	@Override
	public void updatePerformed(EventObject e) {
		azurirajPrikaz();
	}
}


