package Pogled.dijalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.UniqueValueException;
import kontroler.IznajmljivanjeKontroler;
import model.Korisnik;
import net.miginfocom.swing.MigLayout;
import Pogled.FormaDugme;
import Pogled.Labela;
import Pogled.TekstPolje;
import enums.TipNadoknade;
import util.PogledUtil;

public class NadoknadaPrimerakDijalog extends JDialog{
	private static final long serialVersionUID = 5983854443986119609L;
	private TekstPolje tfRazlog;
	private TekstPolje tfCena;
	
	public NadoknadaPrimerakDijalog(TipNadoknade tipNadoknade) {
		setSize(new Dimension(400, 250));
		setLocationRelativeTo(null);
		setTitle("Nadoknada za primerak");
		
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		this.getContentPane().setBackground(clrPrimarna);

		
		Labela lblRazlog = new Labela("Razlog:", fntLabela, Color.black);
		tfRazlog = new TekstPolje("",fntTekstPolje, 140, 30);
		Labela lblCena = new Labela("Iznos nadoknade:", fntLabela, Color.black);
		tfCena = new TekstPolje("",fntTekstPolje, 140, 30);
		
		
		
		FormaDugme btnPotvrdi = new FormaDugme("Potvrdi", Color.LIGHT_GRAY, clrForeground, 150, 20);
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjeKontroler kontrolner=new IznajmljivanjeKontroler();
				kontrolner.naplatiNadoknadu(tipNadoknade,tfRazlog.getText(),tfCena.getText());
				
			}
		});
		
		setLayout(new MigLayout());
		
		add(lblRazlog);
		add(tfRazlog, "wrap,span 2, align left, gapleft 20px");
		add(lblCena);
		add(tfCena, "wrap,span 2, align left, gapleft 20px");
		
		add(btnPotvrdi,  "span 2, align left, gaptop 30px");
	}
	
	private void zatvori() {
		this.dispose();
	}

}
