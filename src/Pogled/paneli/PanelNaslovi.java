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
//
//	/**
//	 * 
//	 */
	private static final long serialVersionUID = -7893396793228337113L;
	private List<Naslov> naslovi;
	private NaslovKontroler naslovKontroler;
//	private TipJelaKontroler tipJelaKontroler;
//	private String[] naziviTipovaJela = new String[] {"Rostilj", "Paste", "Supe"};
	
	private TabelaNaslovi tabelaKnjiga;

	public PanelNaslovi() throws ResultEmptyException {
		setName("Knjige");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(Color.LIGHT_GRAY);
		
		naslovKontroler = new NaslovKontroler();
		this.naslovi=naslovKontroler.dobaviNaslove();
//		tipJelaKontroler = new TipJelaKontroler();
//		try {
//			this.jelovnik = jeloKontroler.dobaviJelaSaCenama();
//		} catch (ResultEmptyException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.INFORMATION_MESSAGE);
//		}
		//Labela lblNaslov = new Labela("Jelovnik restorana", fntNaslov, clrForeground);
		
//		JLabel lblImage = new JLabel("");
//		lblImage.setPreferredSize(new Dimension(80, 80));
//		Image image = new ImageIcon(this.getClass().getResource("/menu96.png")).getImage();
//		lblImage.setIcon(new ImageIcon(image));
//		
//		this.naziviTipovaJela = tipJelaKontroler.dobaviNaziveTipovaJela();
//		
//		Labela lblTipJela = new Labela("Tip jela:", fntTekstPolje, clrForeground);
//		PadajucaLista plTipoviZaposlenih = new PadajucaLista(naziviTipovaJela, 
//				clrPrimarna, clrForeground, fntTekstPolje, 140, 30);
//
//		FormaDugme btnDodajJelo = new FormaDugme("Dodaj jelo", clrPrimarna, clrForeground, 150, 20);
//		btnDodajJelo.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				DijalogDodavanjeJela dijalogDodavanjeJela = new DijalogDodavanjeJela(jeloKontroler, naziviTipovaJela, (TabelaModelJelovnik) tabelaJelovnik.getModel());
//				dijalogDodavanjeJela.setVisible(true);
//			}
//		});
//		
//		FormaDugme btnPretrazi = new FormaDugme("Pretraži", clrPrimarna, clrForeground, 75, 20);
//		
		//setLayout(new MigLayout("","20[]20[]", "20[]30[]40[]"));
		
//		add(lblNaslov, "wrap, span2, align center");
//		add(lblImage, "wrap, span2, align center");
//		add(lblTipJela, "cell 0 2, align left");
//		add(plTipoviZaposlenih, "cell 0 2, align left");
//		add(btnPretrazi, "cell 0 2, gapleft 10, align left");
//		add(btnDodajJelo, "cell 1 2, wrap, align right");
//		if (PrijavljenKorisnik.getInstance().getUloga() != Uloga.SEF_KUHINJE) {
//			btnDodajJelo.setVisible(false);
//
//		}
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
		

		tabelaKnjiga.setPreferredScrollableViewportSize(new Dimension(600,300));
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
