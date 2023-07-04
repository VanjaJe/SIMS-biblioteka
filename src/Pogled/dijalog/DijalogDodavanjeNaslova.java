package Pogled.dijalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Pogled.FormaDugme;
import Pogled.Labela;
import Pogled.PadajucaLista;
import Pogled.TekstPolje;
import enums.TipKoricenja;
import kontroler.AutorKontroler;
import kontroler.InventarKontroler;
import kontroler.IzdavacKontroler;
import model.Autor;
import model.Naslov;
import model.Primerak;
import model.podaci.SviAutori;
import model.podaci.SviNaslovi;
import model.podaci.SviPrimerci;
import net.miginfocom.swing.MigLayout;
import serijalizacija.Serijalizacija;
import util.PogledUtil;

public class DijalogDodavanjeNaslova extends JDialog{
	
	private static final long serialVersionUID = 6234675554509830067L;
	private TekstPolje tfNaslov;
	private TekstPolje tfOpis;
	private TekstPolje tfISBN;
	private TekstPolje tfUDK;
	private PadajucaLista lbAutori;
	private AutorKontroler autorKontroler = new AutorKontroler();
	private Boolean izmena;
	
	
	public DijalogDodavanjeNaslova(String naslovn, String opisn, String udkb, String isbnb, Boolean izmena) {
		
		setSize(new Dimension(700, 550));
		setLocationRelativeTo(null);
		setTitle("Dodavanje naslova");
		
		this.izmena = izmena;
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		this.getContentPane().setBackground(clrPrimarna);		
		
		
		Labela lblNaslov = new Labela("Naslov dela:", fntLabela, Color.BLACK);
		tfNaslov = new TekstPolje(naslovn, fntTekstPolje, 140, 30);
		
		Labela lblOpis = new Labela("Kratak opis:", fntLabela, Color.BLACK);
		tfOpis = new TekstPolje(opisn, fntTekstPolje, 140, 30);
				
		Labela lblISBN = new Labela("ISBN:", fntLabela, Color.BLACK);
		tfISBN = new TekstPolje(isbnb, fntTekstPolje, 140, 30);
		
		Labela lblUDK = new Labela("UDK:", fntLabela, Color.BLACK);
		tfUDK = new TekstPolje(udkb, fntTekstPolje, 140, 30);
			
		Labela lblAutori = new Labela("Autori:", fntLabela, Color.BLACK);
		lbAutori = new PadajucaLista(autorKontroler.dobaviNaziveAutora(), clrPrimarna, clrForeground, fntTekstPolje, 140, 30);
		
		List<Autor> autori = new ArrayList<Autor>();
		
		
		FormaDugme btnDodajAutora = new FormaDugme("Dodaj jos autora", clrPrimarna, clrForeground, 100, 20);
		btnDodajAutora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ime = lbAutori.getSelectedItem().toString().split(" ")[0];
				String prezime = lbAutori.getSelectedItem().toString().split(" ")[1];
				Autor autor = autorKontroler.dobaviAutoraPoImenuIPrezimenu(ime, prezime);
				if (autori.contains(autor)) {
					JOptionPane.showMessageDialog(null, "Izabrani autor je vec unet");
				}
				else { 			
					autori.add(autor);
					lbAutori.setSelectedItem(null);
				}
			}
		});
				
		FormaDugme btnPotvrda = new FormaDugme("Potvrdi", clrPrimarna, clrForeground, 150, 20);
		btnPotvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Primerak> sviPrimerci = new ArrayList<Primerak>();

				if (validacija()) {
					String ime = lbAutori.getSelectedItem().toString().split(" ")[0];
					String prezime = lbAutori.getSelectedItem().toString().split(" ")[1];
					Autor autor = autorKontroler.dobaviAutoraPoImenuIPrezimenu(ime, prezime);
					if (autori.contains(autor)) {
						JOptionPane.showMessageDialog(null, "Izabrani autor je vec unet");
					}
					else { 			
						autori.add(autor);
					}
					
					if (izmena) {
						SviNaslovi.getInstance().izmeniNaslov(tfNaslov.getText(), tfOpis.getText(), tfUDK.getText(), tfISBN.getText(), autori);
						Naslov naslov = new Naslov(tfNaslov.getText(), tfOpis.getText(), tfUDK.getText(),
								tfISBN.getText(), autori);
						sviPrimerci = SviPrimerci.getInstance().dobaviPrimerkePoISBN(tfISBN.getText());
						
						if (sviPrimerci != null) {
							for (Primerak primerak : sviPrimerci) {
								SviPrimerci.getInstance().izmeniNaslov(naslov, primerak.getInventarniBroj());
							}
						}
						JOptionPane.showMessageDialog(null, "Naslov je izmenjen");
					}
					else {
						SviNaslovi.getInstance().dodajNaslov(new Naslov(tfNaslov.getText(), tfOpis.getText(), tfUDK.getText(),
								tfISBN.getText(), autori));
						JOptionPane.showMessageDialog(null, "Naslov je dodat");
						zatvori();
						DijalogDodavanjePrimerka primerakDijalog = new DijalogDodavanjePrimerka(tfISBN.getText());
						primerakDijalog.setVisible(true);
					}
				}
			}
		});
		
		setLayout(new MigLayout("", "200[]25[]10[]", "100[]15[]15[]15[]30[]"));
		
		add(lblNaslov);
		add(tfNaslov, "wrap");
		add(lblOpis);
		add(tfOpis, "wrap");
		add(lblISBN);
		add(tfISBN, "wrap");
		add(lblUDK);
		add(tfUDK, "wrap");
		add(lblAutori);
		add(lbAutori);
		add(btnDodajAutora, "wrap, span2, align right");
		add(btnPotvrda, "wrap, span2, align center");
	}
	
	public Boolean validacija() {
		if (tfISBN.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Unesite ISBN");
			return false;
		}
		if (autorKontroler.proveriZauzetostISBN(tfISBN.getText())) {
			return false;
		}
		if (tfOpis.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Unesite opis");
			return false;
		}
		if (tfNaslov.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Unesite naslov");
			return false;
		}
		if (tfUDK.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Unesite UDK");
			return false;
		}
		return true;
	}
	
	private void zatvori() {
		this.dispose();
	}

}
