package Pogled.paneli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import izuzeci.ResultEmptyException;
//import kontroler.KorisnikKontroler;
import kontroler.LogInKontroler;
import model.Korisnik;
import model.PrijavljenKorisnik;
import net.miginfocom.swing.MigLayout;
//import observer.IzmenaKorisnikaEvent;
//import observer.Observer;
import Pogled.FormaDugme;
import Pogled.Labela;
//import Pogled.dijalog.DialogIzmenaProfila;
import Pogled.PocetniProzor;
import util.PogledUtil;

public class PanelProfil extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2302967480314898683L;
	private PrijavljenKorisnik prijavljenKorisnik = PrijavljenKorisnik.getInstance();
	private Korisnik korisnik;
	private LogInKontroler korisnikKontroler;
	
	private Labela lblImeVr;
	private Labela lblPrezimeVr;
	private Labela lblTelefonVr;
	private Labela lblEmailVr;
	
	public PanelProfil(PocetniProzor pocetniProzor) {
		setName("Profil");
		setVisible(true);
		
		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntLabela = PogledUtil.getLabelaFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(Color.white);
		
		korisnikKontroler = new LogInKontroler();
		try {
			korisnik = LogInKontroler.dobaviKorisnikaPoKorImenu(prijavljenKorisnik.getKorisnickoIme());	
		} catch (ResultEmptyException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);
		}
		//korisnikKontroler.setKorisnik(korisnik);
		//korisnik.addObserver(this);
//		if (pocetniProzor.getName().equals("VlasnikPocetniProzor")) {
//			korisnik.addObserver((((PocetniProzorVlasnik)pocetniProzor).getPanelZaposleni()));
//		}
		
		Labela lblNaslov = new Labela("Pregled profilnih podataka", fntNaslov, clrForeground);
		
//		JLabel lblImage = new JLabel("");
//		lblImage.setPreferredSize(new Dimension(80, 80));
//		Image image = new ImageIcon(this.getClass().getResource("/profile96.png")).getImage();
//		lblImage.setIcon(new ImageIcon(image));
		
		Labela lblIme = new Labela("Ime:", fntLabela, Color.black);
		lblImeVr = new Labela(korisnik.getIme(), fntLabela, clrForeground);
		
		Labela lblPrezime = new Labela("Prezime:", fntLabela, Color.black);
		lblPrezimeVr = new Labela(korisnik.getPrezime(), fntLabela, clrForeground);
		
		Labela lblKorIme = new Labela("Korisnicko ime:", fntLabela, Color.black);
		Labela lblKorImeVr = new Labela(korisnik.getKorisnickiNalog().getKorisnickoIme(), fntLabela, clrForeground);
		
		Labela lblUloga = new Labela("Uloga:", fntLabela, Color.black);
		Labela lblUlogaVr = new Labela(korisnik.getKorisnickiNalog().getTipKorisnika().toString(), fntLabela, clrForeground);
		
		Labela lblTelefon = new Labela("Telefon:", fntLabela, Color.black);
		lblTelefonVr = new Labela(korisnik.getTelefon(), fntLabela, clrForeground);
		
		Labela lblEmail = new Labela("Email:", fntLabela, Color.black);
		lblEmailVr = new Labela(korisnik.getEmail(), fntLabela, clrForeground);
		
		Labela lblDatumRodj = new Labela("Datum rodjenja:", fntLabela, Color.black);
		Labela lblDatumRodjVr = new Labela(PogledUtil.getFormatDatuma().format(korisnik.getDatumRodjenja()), fntLabela, clrForeground);
//	
//		FormaDugme btnIzmena = new FormaDugme("Izmena", clrPrimarna, clrForeground, 150, 20);
//		btnIzmena.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				DialogIzmenaProfila dialogIzmenaProfila = new DialogIzmenaProfila(korisnik, korisnikKontroler);
//				dialogIzmenaProfila.setVisible(true);
//			}
//		});
		
		FormaDugme btnIzmenaLozinke = new FormaDugme("Promena lozinke", clrPrimarna, clrForeground, 150, 20);
	
		setLayout(new MigLayout("", "120[]5[]30[]5[]", "150[]30[]40[]15[]15[]15[]35[]150[]"));
		
		add(lblNaslov, "wrap, span4, gapright 240, align center");
		//add(lblImage, "wrap, span4, gapright 270, align center");
		add(lblIme);
		add(lblImeVr);
		add(lblPrezime);
		add(lblPrezimeVr, "wrap");
		add(lblKorIme);
		add(lblKorImeVr);
		add(lblUloga);
		add(lblUlogaVr, "wrap");
		add(lblTelefon);
		add(lblTelefonVr);
		add(lblEmail);
		add(lblEmailVr, "wrap");
		add(lblDatumRodj);
		add(lblDatumRodjVr, "wrap");
//		add(btnIzmena, "wrap, span4, gapright 280, align center");
//		add(btnIzmenaLozinke, "span4, gapleft 600, align right");
	}

}
