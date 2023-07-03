package Pogled;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import Pogled.meni.MeniBiblioteka;
import Pogled.meni.MeniBibliotekar;
import Pogled.meni.MeniClan;
import Pogled.meni.MeniSpecBibliotekar;
import Pogled.paneli.PanelIznajmljivanje;
import Pogled.paneli.PanelNaslovi;
import Pogled.paneli.PanelProfil;
import Pogled.paneli.PanelRezervacije;
import izuzeci.ResultEmptyException;
import model.PrijavljenKorisnik;


public class PocetniProzorClan extends PocetniProzor {

	private static final long serialVersionUID = -5303103792307993741L;
	private MeniClan meni;
	
	public PocetniProzorClan() throws ResultEmptyException {
		this.setName("ClanPocetniMeni");
		MeniBiblioteka meniBiblioteka = new MeniBiblioteka();
		meni = (MeniClan) meniBiblioteka.napraviMeni("Clan");
		paneli = new ArrayList<>(Arrays.asList(new PanelProfil(this),new PanelNaslovi(),new PanelRezervacije(),new PanelIznajmljivanje()));	    

		
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
		
		meni.getStavkaOdjava().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijavljenKorisnik.setInstanceToNull();
				zatvori();
				PrijavaProzor prijavaProzor = new PrijavaProzor();
				prijavaProzor.setVisible(true);
			}
		});
		
		meni.getStavkaIznajmljivanje().getDugmeStavke().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Iznajmi knjigu");
				osveziProzor();
			}
			
		});
	}
}