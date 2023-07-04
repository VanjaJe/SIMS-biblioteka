package Pogled.paneli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.EventObject;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Pogled.tabela.clanovi.TabelaClanovi;
import Pogled.tabela.clanovi.TabelaModelClanovi;
import Pogled.tabela.primerci.TabelaModelPrimerci;
import Pogled.tabela.primerci.TabelaPrimerci;
import izuzeci.ResultEmptyException;
import kontroler.PrimerakKontroler;
import kontroler.RegistracijaKontroler;
import model.Clan;
import model.Primerak;
import observer.Observer;
import util.PogledUtil;

public class PanelPregledClanova extends JPanel implements Observer {
	private List<Clan> clanovi;
	private RegistracijaKontroler clanKontroler;
	
	private TabelaClanovi tabelaClanovi;

	public PanelPregledClanova() throws ResultEmptyException {
		setName("Clanovi");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(Color.WHITE);
		
		clanKontroler = new RegistracijaKontroler();
		this.clanovi=clanKontroler.dobaviClanove();
		this.inicijalizujTabeluClanova();
	}
	
	private void inicijalizujTabeluClanova() {
		
		TabelaModelClanovi tabelaModelClanovi= new TabelaModelClanovi(clanovi);
		tabelaModelClanovi.addObserver(this);
		this.tabelaClanovi = new TabelaClanovi(tabelaModelClanovi);
		 final TableColumnModel columnModel = tabelaClanovi.getColumnModel();
		    for (int column = 0; column < tabelaClanovi.getColumnCount(); column++) {
		        int width = 120; // Min width
		        for (int row = 0; row < tabelaClanovi.getRowCount(); row++) {
		            TableCellRenderer renderer = tabelaClanovi.getCellRenderer(row, column);
		            Component comp = tabelaClanovi.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnModel.getColumn(column).setPreferredWidth(width);
		    }
		

		tabelaClanovi.setPreferredScrollableViewportSize(new Dimension(610,300));
		tabelaClanovi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(tabelaClanovi);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelClanovi model = (TabelaModelClanovi) tabelaClanovi.getModel();
		model.fireTableDataChanged();
		validate();
	}

	@Override
	public void updatePerformed(EventObject e) {
		azurirajPrikaz();
	}
}
