package Pogled.paneli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Pogled.tabela.naslovi.TabelaNaslovi;
import Pogled.tabela.naslovi.TabelaModelNaslovi;
//import enums.Uloga;
import izuzeci.ResultEmptyException;
import kontroler.NaslovKontroler;
//import kontroler.JeloKontroler;
//import kontroler.TipJelaKontroler;
//import model.JeloCena;
import model.Naslov;
import model.PrijavljenKorisnik;
import net.miginfocom.swing.MigLayout;
import observer.Observer;
//import pogled.FormaDugme;
//import pogled.Labela;
//import pogled.PadajucaLista;
//import pogled.dijalog.DijalogDodavanjeJela;
//import pogled.tabela.jelovnik.TabelaJelovnik;
//import pogled.tabela.jelovnik.TabelaModelJelovnik;
import util.PogledUtil;

public class PanelNaslovi extends JPanel implements Observer {

//	/**
//	 * 
//	 */
	private static final long serialVersionUID = -7893396793228337113L;
	private List<Naslov> naslovi;
	private NaslovKontroler naslovKontroler;
//	private String[] naziviTipovaJela = new String[] {"Rostilj", "Paste", "Supe"};
	
	private TabelaNaslovi tabelaKnjiga;

	public PanelNaslovi() throws ResultEmptyException {
		setName("Knjige");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(Color.WHITE);
		
		naslovKontroler = new NaslovKontroler();
		this.naslovi=naslovKontroler.dobaviNaslove();
		this.inicijalizujTabeluKnjiga();
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
