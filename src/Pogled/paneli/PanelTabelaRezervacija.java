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

import Pogled.tabela.rezervacije.TabelaModelRezervacije;
import Pogled.tabela.rezervacije.TabelaRezervacija;
import izuzeci.ResultEmptyException;
import kontroler.RezervacijaKontroler;
import model.Rezervacija;
import observer.Observer;
import util.PogledUtil;

public class PanelTabelaRezervacija extends JPanel implements Observer {
	
	private static final long serialVersionUID = -7893396793228337113L;
	private List<Rezervacija> rezervacije;
	private RezervacijaKontroler kontroler;
	private TabelaRezervacija tabelaRezervacija;
	
	public PanelTabelaRezervacija() throws ResultEmptyException {
		setName("Tabela Rezervacija");
		setVisible(true);
		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		setBackground(Color.WHITE);
		kontroler = new RezervacijaKontroler();
		this.rezervacije = kontroler.DobaviRezervacije();
		this.InicijalizujTabeluRezervacija();
	}
	
	public void InicijalizujTabeluRezervacija() {
		TabelaModelRezervacije tabelaModelRezervacije = new TabelaModelRezervacije(rezervacije);
		tabelaModelRezervacije.addObserver(this);
		this.tabelaRezervacija = new TabelaRezervacija(tabelaModelRezervacije);
		final TableColumnModel columnModel = tabelaRezervacija.getColumnModel();
			for (int column = 0; column < tabelaRezervacija.getColumnCount(); column++) {
		        int width = 200;
		        if(width > 300)
		            width=300;
		        columnModel.getColumn(column).setPreferredWidth(width);
			}
			tabelaRezervacija.setPreferredScrollableViewportSize(new Dimension(630,300));
			tabelaRezervacija.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane scrollPane = new JScrollPane(tabelaRezervacija);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			add(scrollPane, "wrap, span2, align center");
			
			this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelRezervacije model = (TabelaModelRezervacije) tabelaRezervacija.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	@Override
	public void updatePerformed(EventObject e) {
		azurirajPrikaz();
	}

}
