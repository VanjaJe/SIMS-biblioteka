package Pogled;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import Pogled.meni.MeniBiblioteka;
import Pogled.meni.MeniSpecBibliotekar;
import Pogled.paneli.PanelNaslovi;
import Pogled.paneli.PanelProfil;
import Pogled.paneli.PanelRezervacije;
import izuzeci.ResultEmptyException;
import model.PrijavljenKorisnik;

public class PocetniProzorSpecBibliotekar extends PocetniProzor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5303103792307993741L;
private MeniSpecBibliotekar meni;
	
	public PocetniProzorSpecBibliotekar() throws ResultEmptyException {
		this.setName("SpecijalniBibliotekarPocetniMeni");
		MeniBiblioteka meniBiblioteka = new MeniBiblioteka();
		meni = (MeniSpecBibliotekar) meniBiblioteka.napraviMeni("Specijalni bibliotekar");
		paneli = new ArrayList<>(Arrays.asList(new PanelProfil(this),new PanelNaslovi(),new PanelRezervacije()));	    
//	                          new PanelTipoviJela(),
//	                          new PanelZahteviZaJelo()));
//		
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
				postaviPanel("TipoviJela");
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
