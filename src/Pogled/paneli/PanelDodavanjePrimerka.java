package Pogled.paneli;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JPanel;

import Pogled.FormaDugme;
import Pogled.Labela;
import Pogled.PocetniProzor;
import Pogled.TekstPolje;
import Pogled.dijalog.DijalogDodavanjeNaslova;
import Pogled.dijalog.DijalogDodavanjePrimerka;
import izuzeci.ResultEmptyException;
import kontroler.NaslovKontroler;
import model.Naslov;
import net.miginfocom.swing.MigLayout;
import observer.Observer;
import util.PogledUtil;


public class PanelDodavanjePrimerka extends JPanel implements Observer{
	
	private static final long serialVersionUID = -7893396793228337113L;
	private TekstPolje isbnBroj;
	private NaslovKontroler naslovKontroler;


	public PanelDodavanjePrimerka(PocetniProzor pocetniProzor) throws ResultEmptyException {
		setName("Dodavanje primerka");
		setVisible(true);
		
		
		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrForeground = PogledUtil.getForegroundColor();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		
		setBackground(Color.WHITE);
	
		JPanel dodavanjePrimerkaJP = new JPanel();
		Labela lblNaslov = new Labela("Dodavanje novog primerka", fntNaslov, clrForeground);
		
		
		Labela lblIsbnBroj = new Labela("ISBN broj knjige: ", fntTekstPolje, clrForeground);
		isbnBroj = new TekstPolje("", fntTekstPolje, 100, 30);
		
		naslovKontroler = new NaslovKontroler();
		
		FormaDugme proveraISBN = new FormaDugme("Potvrdi", clrPrimarna, clrForeground, 75, 30);
		proveraISBN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Naslov naslov = naslovKontroler.dobaviNaslovPoISBN(isbnBroj.getText());
				if (naslov != null) {
					DijalogDodavanjePrimerka primerakDijalog = new DijalogDodavanjePrimerka(isbnBroj.getText());
					primerakDijalog.setVisible(true);
				}
				else {
					DijalogDodavanjeNaslova naslovDijalog = new DijalogDodavanjeNaslova();
					naslovDijalog.setVisible(true);
				}
			}
		});

		
		dodavanjePrimerkaJP.setLayout(new MigLayout("", "[][]", "100[]50[]30[]"));
		dodavanjePrimerkaJP.setBackground(Color.WHITE);
		
		dodavanjePrimerkaJP.add(lblNaslov, "wrap, span2, align center");
		dodavanjePrimerkaJP.add(lblIsbnBroj, "gapleft 30");
		dodavanjePrimerkaJP.add(isbnBroj, "wrap, pushx, growx, gapright 30");
		dodavanjePrimerkaJP.add(proveraISBN, "wrap, span2, align center");
		add(dodavanjePrimerkaJP);
	}
	
	private void azurirajPrikaz() {
		validate();
	}

	@Override
	public void updatePerformed(EventObject e) {
		azurirajPrikaz();
	}
}