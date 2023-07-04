package Pogled.paneli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EventObject;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Pogled.FormaDugme;
import Pogled.dijalog.DijalogDodavanjeNaslova;
import Pogled.tabela.naslovi.TabelaModelNaslovi;
import Pogled.tabela.naslovi.TabelaNaslovi;
import izuzeci.ResultEmptyException;
import kontroler.NaslovKontroler;
import model.Naslov;
import model.podaci.SviNaslovi;
import observer.Observer;
import serijalizacija.Serijalizacija;
import util.PogledUtil;

public class PanelIzmenaNaslova  extends JPanel implements Observer {
	

	private static final long serialVersionUID = -5134230726173005608L;
	private List<Naslov> naslovi;
	private NaslovKontroler naslovKontroler;
	private Color clrPrimarna;
	private Color clrForeground;
	
	private TabelaNaslovi tabelaKnjiga;

	public PanelIzmenaNaslova() throws ResultEmptyException {
		setName("Izmena naslova");
		setVisible(true);

		
		setBackground(Color.WHITE);
		this.clrPrimarna = PogledUtil.getPrimarnaBoja();
		this.clrForeground = PogledUtil.getForegroundColor();
		
		naslovKontroler = new NaslovKontroler();
		this.naslovi=naslovKontroler.dobaviNaslove();
		this.inicijalizujTabeluKnjiga();
	}
	
	private void inicijalizujTabeluKnjiga() {
		
		TabelaModelNaslovi tabelaModelNaslovi= new TabelaModelNaslovi(naslovi);
		tabelaModelNaslovi.addObserver(this);
		this.tabelaKnjiga = new TabelaNaslovi(tabelaModelNaslovi);
		formirajTabelu();
		JScrollPane scrollPane = new JScrollPane(tabelaKnjiga);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "wrap, span2, align center");
		
		FormaDugme btnIzmeniNaslov = new FormaDugme("Izmeni", clrPrimarna, clrForeground, 75, 30);
		btnIzmeniNaslov.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!tabelaKnjiga.getSelectionModel().isSelectionEmpty()) {
					int row = tabelaKnjiga.getSelectedRow();
					String isbnBroj = tabelaKnjiga.getValueAt(row,3).toString();
					Naslov naslov = naslovKontroler.dobaviNaslovPoISBN(isbnBroj);
					
					DijalogDodavanjeNaslova dijalog = new DijalogDodavanjeNaslova(naslov.getNaslovDela(), naslov.getOpis(),
							naslov.getUdk(), naslov.getIsbn(), true);
					dijalog.setVisible(true);
					
					
					Serijalizacija s=new Serijalizacija();
					try {
						s.sacuvaj();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					azurirajPrikaz();
				}
				else {
					JOptionPane.showMessageDialog(null, "Selektujte red");
				}
			}
		});
		
		add(btnIzmeniNaslov, "wrap, span2, align center");

		this.azurirajPrikaz();
	}
	
	
	private void formirajTabelu() {
		final TableColumnModel columnModel = tabelaKnjiga.getColumnModel();
	    for (int column = 0; column < tabelaKnjiga.getColumnCount(); column++) {
	        int width = 15;
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
	}
	
	
	private void azurirajPrikaz() {
		naslovi= SviNaslovi.getInstance().getNaslovi();
		TabelaModelNaslovi tabelaModeNaslov = new TabelaModelNaslovi(naslovi);
		tabelaKnjiga.setModel(tabelaModeNaslov);
		formirajTabelu();
	}

	@Override
	public void updatePerformed(EventObject e) {
		azurirajPrikaz();
	}
}
