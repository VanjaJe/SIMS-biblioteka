package Pogled.paneli;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

import Pogled.FormaDugme;
import Pogled.TekstPolje;
import enums.TipKorisnika;
import enums.VrstaClana;
import izuzeci.ResultEmptyException;
import kontroler.RegistracijaKontroler;
import model.Cenovnik;
import model.Clan;
import model.ClanskaKarta;
import model.KorisnickiNalog;
import model.Korisnik;
import model.Placanje;
import model.VrstaClanstva;
import model.podaci.SviClanovi;
import model.podaci.SviKorisnici;
import net.miginfocom.swing.MigLayout;
import serijalizacija.Serijalizacija;
import util.PogledUtil;

public class PanelRegistracija extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TekstPolje Ime;
	private TekstPolje Prezime;
	private TekstPolje Telefon;
	private TekstPolje Email;
	private TekstPolje Jmbg;
	private TekstPolje DatumRodjenja;
	private TekstPolje Korisnicko;
	private TekstPolje Lozinka;
	private JComboBox<String> Tip;

	private RegistracijaKontroler registracijaKontroler;

	public PanelRegistracija() throws ResultEmptyException {
		setName("Registracija");
		setVisible(true);
		
		setBackground(Color.white);
		
		registracijaKontroler = new RegistracijaKontroler();

		this.setLayout(new MigLayout("", "[][]", "50[]50[]10[]20[]"));
		this.inicijalizujPolja();
	}
	
	private void inicijalizujPolja() {
		
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		NumberFormatter formatter = new NumberFormatter();
        formatter.setValueClass(Long.class); 
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        

        JLabel imeLabel = new JLabel("Ime:"); 	
        JLabel prezimeLabel = new JLabel("Prezime:");
        JLabel telefonLabel = new JLabel("Telefon:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel jmbgLabel = new JLabel("JMBG:");
        JLabel datumRodjenjaLabel = new JLabel("Datum rodjenja (yyyy-MM-dd):");
        JLabel korisnickoLabel = new JLabel("Korisnidko ime:");
        JLabel lozinkaLabel = new JLabel("Lozinka:");
        JLabel tipLabel = new JLabel("Tip:");
		
		
        Ime = new TekstPolje("", fntTekstPolje, 100, 30);
        Prezime = new TekstPolje("", fntTekstPolje, 100, 30);
        Telefon = new TekstPolje("", fntTekstPolje, 100, 30);
        Email = new TekstPolje("", fntTekstPolje, 100, 30);
        Jmbg =  new TekstPolje("", fntTekstPolje, 100, 30);
        DatumRodjenja = new TekstPolje("", fntTekstPolje, 100, 30);
        Korisnicko = new TekstPolje("", fntTekstPolje, 100, 30);
        Lozinka = new TekstPolje("", fntTekstPolje, 100, 30);
        Tip = new JComboBox<>();
		VrstaClana[] tipovi = VrstaClana.values();
		String[] tipoviStrings = new String[tipovi.length];

		for (int i = 0; i < tipovi.length; i++) {
		    tipoviStrings[i] = tipovi[i].toString();
		}
		Tip = new JComboBox<>(tipoviStrings);
		
		FormaDugme btnRegistracija = new FormaDugme("Registracija", clrPrimarna, clrForeground, 75, 30);
		btnRegistracija.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					registruj();
				} catch (ResultEmptyException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		add(imeLabel, "gapleft 30");
		add(Ime, "wrap, pushx, growx, gapright 30");
		add(prezimeLabel, "gapleft 30");
        add(Prezime, "wrap, pushx, growx, gapright 30");
        add(telefonLabel, "gapleft 30");
        add(Telefon, "wrap, pushx, growx, gapright 30");
        add(emailLabel, "gapleft 30");
        add(Email, "wrap, pushx, growx, gapright 30");
        add(jmbgLabel, "gapleft 30");
        add(Jmbg, "wrap, pushx, growx, gapright 30");
        add(datumRodjenjaLabel, "gapleft 30");
        add(DatumRodjenja, "wrap, pushx, growx, gapright 30");
        add(korisnickoLabel, "gapleft 30");
        add(Korisnicko, "wrap, pushx, growx, gapright 30");
        add(lozinkaLabel, "gapleft 30");
        add(Lozinka, "wrap, pushx, growx, gapright 30");
        add(tipLabel, "gapleft 30");
        add(Tip, "wrap, pushx, growx, gapright 30");
		add(btnRegistracija, "span2, split2, align center");
	}
	
	public void registruj() throws ResultEmptyException, IOException {
		//id
		long id = SviKorisnici.getInstance().generisiId();

        //ime
    	String ime = Ime.getText();
    	
    	//prezime
    	String prezime = Prezime.getText();

    	//telefon
    	String telefon = Telefon.getText();

    	//email
    	String email = Email.getText();

    	//jmbg
    	String jmbg = Jmbg.getText();

    	//datum rodjenja
    	String datRodj = DatumRodjenja.getText();
    	LocalDate datum = null;
    	try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            datum = LocalDate.parse(datRodj, formatter);
    	} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Niste uneli datum u ispravnom formatu. Pokusajte ponovo!");
    		return;
    	}

    	//korisnicko ime
    	String korisnicko = Korisnicko.getText();

    	//lozinka
    	String lozinka = Lozinka.getText();
    	

    	if(ime==null || prezime==null || telefon==null || email==null || jmbg==null || korisnicko==null || lozinka==null) {
    		JOptionPane.showMessageDialog(this, "Niste uneli sve podatke. Popunite sva polja pa pokusajte opet!");
    		return;
    	}
    	if(ime.equals("") || prezime.equals("") || telefon.equals("") || email.equals("") || jmbg.equals("") || korisnicko.equals("") || lozinka.equals("")) {
    		JOptionPane.showMessageDialog(this, "Niste uneli podatke. Popunite sva polja pa pokusajte opet!");
    		return;
    	}
    	if(!email.contains("@")) {
    		JOptionPane.showMessageDialog(this, "Niste uneli ispravan email! Pokusajte ponovo!");
    		return;
    	}
    	if(lozinka.length()<8) {
    		JOptionPane.showMessageDialog(this, "Lozinka mora da ima bar 8 karaktera, pokusajte opet!");
    		return;
    	}
    	if(!telefon.matches("\\d+")) {
    		JOptionPane.showMessageDialog(this, "Niste uneli ispravan broj telefona!");
    		return;
    	}
    	if(!jmbg.matches("\\d+")) {
    		JOptionPane.showMessageDialog(this, "Niste uneli ispravan jmbg!");
    		return;
    	}
		
		//datum uclanjivanja
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayString = today.format(formatter);
        
        //broj clanske karte
        Random random = new Random();
        int brClKarte = random.nextInt();
        
        //placanja
        List<Placanje> placanja = new ArrayList<Placanje>();
		
		//tip clanstva
		String selectedValue = (String) Tip.getSelectedItem();
		VrstaClana vrsta;
		VrstaClanstva vrstaClanstva;
		int popust = 0;
		if (selectedValue.equals(VrstaClana.DETE.toString())) {
			vrsta = VrstaClana.DETE;
			popust = 300;
			vrstaClanstva = new VrstaClanstva(vrsta, 3, 15, new ArrayList<Cenovnik>());
		} else if (selectedValue.equals(VrstaClana.PENZIONER.toString())) {
			vrsta = VrstaClana.PENZIONER;
			vrstaClanstva = new VrstaClanstva(vrsta, 5, 25, new ArrayList<Cenovnik>());
			popust = 200;
		} else if (selectedValue.equals(VrstaClana.STUDENT.toString())) {
			vrsta = VrstaClana.STUDENT;
			vrstaClanstva = new VrstaClanstva(vrsta, 5, 35, new ArrayList<Cenovnik>());
			popust = 100;
		} else {
			vrsta = VrstaClana.OBICAN;
			vrstaClanstva = new VrstaClanstva(vrsta, 3, 30, new ArrayList<Cenovnik>());
		}
		
		List<Clan> clanovi = registracijaKontroler.dobaviClanove();
		System.out.println(clanovi.size());
		for(Clan clan : clanovi) {
			if(clan.getJmbg().equals(jmbg)) {
				JOptionPane.showMessageDialog(this, "korisnik sa ovim jmbg-om se vec nalazi u sistemu!");
				return;
			}
			if(clan.getKorisnickiNalog().getKorisnickoIme().equals(korisnicko)) {
				JOptionPane.showMessageDialog(this, "ovo korisnicko ime je zauzeto");
				return;
			}
		}
		
		Clan noviClan = new Clan(id, ime, prezime, telefon, jmbg, email, datum, 
				new KorisnickiNalog(korisnicko, lozinka, TipKorisnika.CLAN), popust, 
				new ClanskaKarta(todayString, brClKarte, vrstaClanstva), placanja);
		Korisnik noviKorisnik = new Korisnik(id, ime, prezime, telefon, jmbg, email, datum, 
				new KorisnickiNalog(korisnicko, lozinka, TipKorisnika.CLAN));
		
		SviKorisnici.getInstance().dodajKorisnika(noviKorisnik);
		SviClanovi.getInstance().dodajClana(noviClan);
		
		Serijalizacija s = new Serijalizacija();
		s.sacuvaj();
		
		JOptionPane.showMessageDialog(this, "Clanska karta se izradjuje! Bicete obavesteni kada bude spremna.");
		return;
	}
	
}
