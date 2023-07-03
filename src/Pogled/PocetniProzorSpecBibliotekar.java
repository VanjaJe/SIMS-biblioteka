package Pogled;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import Pogled.meni.MeniBiblioteka;
import Pogled.meni.MeniSpecBibliotekar;
import Pogled.paneli.PanelDodavanjePrimerka;
import Pogled.paneli.PanelNaslovi;
import Pogled.paneli.PanelPregledClanova;
import Pogled.paneli.PanelPregledPrimeraka;
import Pogled.paneli.PanelProfil;
import Pogled.paneli.PanelRezervacije;
import izuzeci.ResultEmptyException;
import model.PrijavljenKorisnik;

public class PocetniProzorSpecBibliotekar extends PocetniProzor {

	private static final long serialVersionUID = -5303103792307993741L;
	private MeniSpecBibliotekar meni;
	
	public PocetniProzorSpecBibliotekar() throws ResultEmptyException {
		this.setName("SpecijalniBibliotekarPocetniMeni");
		MeniBiblioteka meniBiblioteka = new MeniBiblioteka();
		meni = (MeniSpecBibliotekar) meniBiblioteka.napraviMeni("Specijalni bibliotekar");
		paneli = new ArrayList<>(Arrays.asList(new PanelProfil(this),new PanelNaslovi(),new PanelRezervacije(),
				new PanelDodavanjePrimerka(this), new PanelPregledPrimeraka(), new PanelPregledClanova()));	    
		
		add(paneli.get(0), BorderLayout.CENTER);
		add(meni, BorderLayout.WEST);
		
		meni.getStavkaProfil().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Profil");
				osveziProzor();
			}
		});
		
		meni.getStavkaKnjige().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Knjige");
				osveziProzor();
			}
		});
		
		meni.getStavkaRezervacije().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Rezervacije");
				osveziProzor();
			}
		});
		
		meni.getStavkaDodavanjePrimerka().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Dodavanje primerka");
				osveziProzor();
			}
		});
		
		meni.getStavkaOdjava().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijavljenKorisnik.setInstanceToNull();
				zatvori();
				PrijavaProzor prijavaProzor = new PrijavaProzor();
				prijavaProzor.setVisible(true);
			}
		});
		
		meni.getStavkaPrimerci().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Primerci");
				osveziProzor();
			}
		});
		
		meni.getStavkaClanovi().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Clanovi");
				osveziProzor();
			}
		});
	}
}
