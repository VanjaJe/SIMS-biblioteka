package Pogled.paneli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EventObject;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.thoughtworks.xstream.converters.Converter;

import Pogled.FormaDugme;
import Pogled.Labela;
import Pogled.TekstPolje;
import Pogled.dijalog.NadoknadaPrimerakDijalog;
import Pogled.tabela.iznajmljivanja.TabelaIznajmljivanja;
import Pogled.tabela.iznajmljivanja.TabelaModelIznajmljivanja;
import Pogled.tabela.naslovi.TabelaModelNaslovi;
import Pogled.tabela.naslovi.TabelaNaslovi;
import enums.Stanje;
import enums.TipNadoknade;
import izuzeci.ResultEmptyException;
import kontroler.IznajmljivanjeKontroler;
import kontroler.NaslovKontroler;
import model.Iznajmljivanje;
import model.Naslov;
import model.Primerak;
import model.podaci.SviPrimerci;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;
import observer.Observer;
import serijalizacija.Serijalizacija;

public class PanelVracanje extends JPanel implements Observer {
	//
//	/**
//	 * 
//	 */
	private static final long serialVersionUID = -7893396793228337113L;
	private List<Iznajmljivanje> iznajmljivanja;
	private IznajmljivanjeKontroler iznajmljivanjeKontroler;
	private TekstPolje tfStanje;
	private TekstPolje tfKasnjenje;
	
	private TabelaIznajmljivanja tabelaIznajmljivanje;

	public PanelVracanje() throws ResultEmptyException {
		setName("Vracanje");
		setVisible(true);
		
		setBackground(Color.LIGHT_GRAY);
		
		iznajmljivanjeKontroler = new IznajmljivanjeKontroler();
		this.iznajmljivanja=iznajmljivanjeKontroler.dobaviPrimerke();
		this.inicijalizujTabeluIznajmljivanja();
	}
	
	private void inicijalizujTabeluIznajmljivanja() {
		
		TabelaModelIznajmljivanja tabelaModeIznajmljivanja= new TabelaModelIznajmljivanja(iznajmljivanja);
		this.tabelaIznajmljivanje = new TabelaIznajmljivanja(tabelaModeIznajmljivanja);
		 final TableColumnModel columnModel = tabelaIznajmljivanje.getColumnModel();
		    for (int column = 0; column < tabelaIznajmljivanje.getColumnCount(); column++) {
		        int width = 100; // Min width
		        for (int row = 0; row < tabelaIznajmljivanje.getRowCount(); row++) {
		            TableCellRenderer renderer = tabelaIznajmljivanje.getCellRenderer(row, column);
		            Component comp = tabelaIznajmljivanje.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnModel.getColumn(column).setPreferredWidth(width);
		    }
		

		tabelaIznajmljivanje.setPreferredScrollableViewportSize(new Dimension(500,100));
		tabelaIznajmljivanje.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(tabelaIznajmljivanje);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		setLayout(new MigLayout("", "30[]25[]25", "30[]30[]15[]15[]15[]15[]15[]40[]"));
		add(scrollPane, "wrap, span3, align center");
		
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		
		Labela lblStanje = new Labela("Stanje:", fntLabela, Color.BLACK);
		JComboBox<Stanje> comboBox = new JComboBox<>(Stanje.values());
		comboBox.removeItem(Stanje.IZNAJMLJEN);
		add(lblStanje);
		add(comboBox, "wrap");
		FormaDugme btnVrati = new FormaDugme("Potvrdi", clrPrimarna, clrForeground, 150, 20);
		btnVrati.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!tabelaIznajmljivanje.getSelectionModel().isSelectionEmpty())
				{
					int row=tabelaIznajmljivanje.getSelectedRow();
					int invBroj=Integer.parseInt(tabelaIznajmljivanje.getValueAt(row,3).toString());
					
					if(comboBox.getSelectedItem()==Stanje.OSTECEN) {
						SviPrimerci.getInstance().postaviStanjePrimerka(invBroj,Stanje.OSTECEN);
						NadoknadaPrimerakDijalog dijalog=new NadoknadaPrimerakDijalog(TipNadoknade.OSTECENA_KNJIGA);
						dijalog.show();
					}else {
						if(comboBox.getSelectedItem()==Stanje.UKLONJEN) {
							SviPrimerci.getInstance().postaviStanjePrimerka(invBroj,Stanje.UKLONJEN);
							NadoknadaPrimerakDijalog dijalog=new NadoknadaPrimerakDijalog(TipNadoknade.IZGUBLJENA_KNJIGA);
							dijalog.show();
							
						}else {
							SviPrimerci.getInstance().postaviStanjePrimerka(invBroj,Stanje.DOSTUPAN);
						}
					}
				}else {
					System.out.println("Selektujte red u tabeli");
				}
				
			}
		});
		
		add(btnVrati, "wrap, span2, align left");
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelIznajmljivanja model = (TabelaModelIznajmljivanja) tabelaIznajmljivanje.getModel();
		model.fireTableDataChanged();
		validate();
	}

	@Override
	public void updatePerformed(EventObject e) {
		azurirajPrikaz();
	}

}
