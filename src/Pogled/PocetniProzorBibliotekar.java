package Pogled;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import Pogled.meni.MeniBiblioteka;
import Pogled.meni.MeniBibliotekar;
import Pogled.meni.MeniSpecBibliotekar;
import Pogled.paneli.PanelNaslovi;
import Pogled.paneli.PanelProfil;
import Pogled.paneli.PanelRegistracija;
import Pogled.paneli.PanelRezervacije;
import Pogled.paneli.PanelVracanje;
import izuzeci.ResultEmptyException;
import model.PrijavljenKorisnik;
//import pogled.PrijavaProzor;
//import pogled.meni.MeniFabrika;
//import pogled.meni.MeniSefKuhinje;
//import pogled.panel.PanelJelovnik;
//import pogled.panel.PanelProfil;
//import pogled.panel.PanelTipoviJela;
//import pogled.panel.PanelZahteviZaJelo;

public class PocetniProzorBibliotekar extends PocetniProzor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5303103792307993741L;
	private MeniBibliotekar meni;
	
	public PocetniProzorBibliotekar() throws ResultEmptyException {
		this.setName("BibliotekarPocetniMeni");
		MeniBiblioteka meniBiblioteka = new MeniBiblioteka();
		meni = (MeniBibliotekar) meniBiblioteka.napraviMeni("Obicni bibliotekar");		
		paneli = new ArrayList<>(Arrays.asList(new PanelProfil(this),new PanelNaslovi(),new PanelRezervacije(), 
				new PanelRegistracija(), new PanelVracanje()));	    
		add(paneli.get(0), BorderLayout.CENTER);
		add(meni, BorderLayout.WEST);
		
		meni.getStavkaProfil().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Profil");
				osveziProzor();
			}
		});
		
		meni.getStavkaVracanje().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Vracanje");
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
		
		meni.getStavkaRegistracija().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Registracija");
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
	}
}
