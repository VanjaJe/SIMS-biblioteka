package Pogled.paneli;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Pogled.FormaDugme;
import Pogled.Labela;
import Pogled.TekstPolje;
import izuzeci.MissingValueException;
import izuzeci.NaslovNePostojiException;
import izuzeci.PrimerciNePostojeException;
import kontroler.RezervacijaKontroler;
import model.Naslov;
import model.Primerak;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class PanelRezervacije extends JPanel {

	private static final long serialVersionUID = 2428310626343765569L;
	private Font fntTekstPolje;
	private Color clrForeground;
	private Labela lblNaslov;
	private TekstPolje poljeNaslov;
    private FormaDugme dugme; 
    private RezervacijaKontroler kontroler;

	public PanelRezervacije() {
		setName("Rezervacije");
		kontroler = new RezervacijaKontroler();
		fntTekstPolje = PogledUtil.getTeksPoljeFont();
		clrForeground = PogledUtil.getForegroundColor();
		lblNaslov = new Labela("Unesi naslov knjige: ", fntTekstPolje, clrForeground);
		poljeNaslov = new TekstPolje("", fntTekstPolje, 100, 30);
        dugme = new FormaDugme("Rezervacija knjige", new Color(228,242,242,255), Color.BLACK, 170, 30);
        setLayout(new MigLayout("", "[][]", "50[]50[]10[]20[]"));
        add(lblNaslov, "gapleft 30");
        add(poljeNaslov, "wrap, pushx, growx, gapright 30");
        add(dugme, "span2, split2, align center");
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
	}
}
