package Pogled.paneli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import Pogled.FormaDugme;
import Pogled.Labela;
import Pogled.TekstPolje;
import Pogled.tabela.rezervacije.TabelaModelRezervacije;
import Pogled.tabela.rezervacije.TabelaRezervacija;
import izuzeci.MissingValueException;
import izuzeci.NaslovNePostojiException;
import izuzeci.PrimerciNePostojeException;
import kontroler.RezervacijaKontroler;
import model.Naslov;
import model.Rezervacija;
import net.miginfocom.swing.MigLayout;
import observer.Observer;
import util.PogledUtil;

public class PanelRezervacije extends JPanel implements Observer {

	private static final long serialVersionUID = 2428310626343765569L;
	private Font fntTekstPolje;
	private Color clrForeground;
	private Labela lblNaslov;
	private TekstPolje poljeNaslov;
    private FormaDugme dugme; 
    private RezervacijaKontroler kontroler;
    private List<Rezervacija> rezervacije;
    private TabelaRezervacija tabelaRezervacija;

	public PanelRezervacije() {
		setName("Rezervacije");
		kontroler = new RezervacijaKontroler();
		fntTekstPolje = PogledUtil.getTeksPoljeFont();
		clrForeground = PogledUtil.getForegroundColor();
		lblNaslov = new Labela("Unesi naslov knjige: ", fntTekstPolje, clrForeground);
		poljeNaslov = new TekstPolje("", fntTekstPolje, 100, 30);
        dugme = new FormaDugme("Rezervacija knjige", new Color(228,242,242,255), Color.BLACK, 170, 30);
        setLayout(new MigLayout("", "[][]", "50[]50[]10[]20[]50[]"));
        add(lblNaslov, "gapleft 30");
        add(poljeNaslov, "wrap, pushx, growx, gapright 30");
        add(dugme, "span2, split2, align center, wrap");
		setVisible(true);
		
		dugme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Naslov naslov = kontroler.DobaviNaslov(poljeNaslov.getText());
					kontroler.Rezervisi(naslov);
				} catch (MissingValueException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (NaslovNePostojiException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (PrimerciNePostojeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		setBackground(Color.WHITE);
		kontroler = new RezervacijaKontroler();
		this.rezervacije = kontroler.DobaviLicneRezervacije(kontroler.DobaviClana());
		this.InicijalizujTabeluRezervacija();
		FormaDugme btnPreuzmi = new FormaDugme("Preuzmi", clrPrimarna, clrForeground, 150, 20);
		btnPreuzmi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!tabelaRezervacija.getSelectionModel().isSelectionEmpty())
				{
					int row=tabelaRezervacija.getSelectedRow();
					long id=Integer.parseInt(tabelaRezervacija.getValueAt(row,0).toString());
					Rezervacija rezervacija = kontroler.DobaviRezervaciju(id);
					boolean preuzeta = kontroler.PreuzmiRezervaciju(rezervacija);
					if(preuzeta) {
						JOptionPane.showMessageDialog(null, "Preuzeta knjiga.\nMolimo da je vratite u odredjenom roku, bez ostecenja!\nHvala!",
								"Potvrda", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Selektujte red u tabeli", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		add(btnPreuzmi, "wrap, span2, align center");
		this.azurirajPrikaz();
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
