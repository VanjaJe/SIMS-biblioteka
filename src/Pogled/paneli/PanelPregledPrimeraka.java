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

import Pogled.tabela.naslovi.TabelaModelNaslovi;
import Pogled.tabela.naslovi.TabelaNaslovi;
import Pogled.tabela.primerci.TabelaModelPrimerci;
import Pogled.tabela.primerci.TabelaPrimerci;
import izuzeci.ResultEmptyException;
import kontroler.NaslovKontroler;
import kontroler.PrimerakKontroler;
import model.Naslov;
import model.Primerak;
import observer.Observer;
import util.PogledUtil;

public class PanelPregledPrimeraka extends JPanel implements Observer {

	private static final long serialVersionUID = 5984267447935651526L;
	private List<Primerak> primerci;
	private PrimerakKontroler primerakKontroler;
	
	private TabelaPrimerci tabelaPrimerci;

	public PanelPregledPrimeraka() throws ResultEmptyException {
		setName("Primerci");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(Color.WHITE);
		
		primerakKontroler = new PrimerakKontroler();
		this.primerci=primerakKontroler.dobaviPrimerke();
		this.inicijalizujTabeluPrimeraka();
	}
	
	private void inicijalizujTabeluPrimeraka() {
		
		TabelaModelPrimerci tabelaModelPrimerci= new TabelaModelPrimerci(primerci);
		tabelaModelPrimerci.addObserver(this);
		this.tabelaPrimerci = new TabelaPrimerci(tabelaModelPrimerci);
		 final TableColumnModel columnModel = tabelaPrimerci.getColumnModel();
		    for (int column = 0; column < tabelaPrimerci.getColumnCount(); column++) {
		        int width = 150; // Min width
		        for (int row = 0; row < tabelaPrimerci.getRowCount(); row++) {
		            TableCellRenderer renderer = tabelaPrimerci.getCellRenderer(row, column);
		            Component comp = tabelaPrimerci.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnModel.getColumn(column).setPreferredWidth(width);
		    }
		

		tabelaPrimerci.setPreferredScrollableViewportSize(new Dimension(600,300));
		tabelaPrimerci.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(tabelaPrimerci);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelPrimerci model = (TabelaModelPrimerci) tabelaPrimerci.getModel();
		model.fireTableDataChanged();
		validate();
	}

	@Override
	public void updatePerformed(EventObject e) {
		azurirajPrikaz();
	}
}
