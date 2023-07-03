package Pogled.dijalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import kontroler.InventarKontroler;
import kontroler.IzdavacKontroler;
import kontroler.NaslovKontroler;
import model.Inventar;
import model.Izdavac;
import model.Naslov;
import model.Primerak;
import model.podaci.SviInventari;
import model.podaci.SviIzdavaci;
import model.podaci.SviNaslovi;
import model.podaci.SviPrimerci;
import net.miginfocom.swing.MigLayout;
import Pogled.PadajucaLista;
import Pogled.FormaDugme;
import Pogled.Labela;
import Pogled.TekstPolje;
import enums.Stanje;
import enums.TipKoricenja;
import util.PogledUtil;

public class DijalogDodavanjePrimerka extends JDialog{
	
	private static final long serialVersionUID = 5983854443986119609L;
	private TekstPolje tfInventarniBroj;
	private TekstPolje tfJezik;
	private TekstPolje tfFormat;
	private PadajucaLista plTipKoricenja;
	private PadajucaLista plIzdavac;
	private PadajucaLista plInventar;
	private InventarKontroler inventariKontroler = new InventarKontroler();
	private IzdavacKontroler izdavaciKontroler = new IzdavacKontroler();
	private NaslovKontroler naslovKontroler = new NaslovKontroler();
	private String isbnNaslova;
	
	
	public DijalogDodavanjePrimerka(String isbn) {
		
		setSize(new Dimension(700, 550));
		setLocationRelativeTo(null);
		setTitle("Dodavanje primerka");
		this.isbnNaslova = isbn;
		
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		this.getContentPane().setBackground(clrPrimarna);		
		
		
		Labela lblInventarniBroj = new Labela("Inventari broj:", fntLabela, Color.BLACK);
		tfInventarniBroj = new TekstPolje("", fntTekstPolje, 140, 30);
		
		Labela lblJezik = new Labela("Jezik:", fntLabela, Color.BLACK);
		tfJezik = new TekstPolje("", fntTekstPolje, 140, 30);
				
		Labela lblFormat = new Labela("Format:", fntLabela, Color.BLACK);
		tfFormat = new TekstPolje("", fntTekstPolje, 140, 30);
		
		String[] koricenja = Stream.of(TipKoricenja.values()).map(Enum::name).toArray(String[]::new);
		
		Labela lblTipKoricenja = new Labela("Tip koricenja:", fntLabela, Color.BLACK);
		plTipKoricenja = new PadajucaLista(koricenja, clrPrimarna, clrForeground, fntTekstPolje, 140, 30);
		
		Labela lblIzdavac = new Labela("Izdavac:", fntLabela, Color.BLACK);
		plIzdavac = new PadajucaLista(izdavaciKontroler.dobaviNaziveIzdavaca(), clrPrimarna, clrForeground, fntTekstPolje, 140, 30);
		
		Labela lblInventar = new Labela("Inventar:", fntLabela, Color.BLACK);
		plInventar = new PadajucaLista(inventariKontroler.dobaviNaziveInventara(), clrPrimarna, clrForeground, fntTekstPolje, 140, 30);
		
		
		
		FormaDugme btnPotvrda = new FormaDugme("Potvrdi", clrPrimarna, clrForeground, 150, 20);
		btnPotvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validacija()) {
					String koricenje = plTipKoricenja.getSelectedItem().toString();
					Naslov naslov = naslovKontroler.dobaviNaslovPoISBN(isbnNaslova); 
					Izdavac izdavac = SviIzdavaci.getInstance().dobaviIzdavacaPoNazivu(plIzdavac.getSelectedItem().toString());
					Inventar inventar = SviInventari.getInstance().dobaviInventarPoNazivu(plInventar.getSelectedItem().toString());
					SviPrimerci.getInstance().dodajPrimerak(new Primerak(Integer.parseInt(tfInventarniBroj.getText()), 
							tfJezik.getText(), tfFormat.getText(), TipKoricenja.valueOf(koricenje), Stanje.DOSTUPAN, izdavac, inventar, naslov));
					JOptionPane.showMessageDialog(null, "Primerak je dodat");
					zatvori();
				}
			}
		});
		
		setLayout(new MigLayout("", "200[]25[]", "30[]15[]15[]15[]40[]40[]40[]"));
		
		add(lblInventarniBroj);
		add(tfInventarniBroj, "wrap");
		add(lblJezik);
		add(tfJezik, "wrap");
		add(lblFormat);
		add(tfFormat, "wrap");
		add(lblTipKoricenja);
		add(plTipKoricenja, "wrap");
		add(lblIzdavac);
		add(plIzdavac, "wrap");
		add(lblInventar);
		add(plInventar, "wrap");
		add(btnPotvrda, "wrap, span2, align center");
	}
	
	private void zatvori() {
		this.dispose();
	}
	
	
	private Boolean validacija() {
		if (tfInventarniBroj.getText().equals("") || !isNumeric(tfInventarniBroj.getText())) {
			JOptionPane.showMessageDialog(null, "Unesite inventarni broj");
			return false;
		}
		if (tfJezik.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Unesite jezik");
			return false;
		}
		if (tfFormat.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Unesite format");
			return false;
		}
		return true;
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
