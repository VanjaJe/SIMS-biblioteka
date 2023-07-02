package Pogled.paneli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.NumberFormatter;

import Pogled.FormaDugme;
import Pogled.PocetniProzor;
import Pogled.PocetniProzorBiblioteka;
import Pogled.TekstPolje;
import Pogled.tabela.naslovi.TabelaModelNaslovi;
import Pogled.tabela.naslovi.TabelaNaslovi;
import enums.TipKorisnika;
import enums.VrstaClana;
import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import izuzeci.ResultEmptyException;
import kontroler.NaslovKontroler;
import kontroler.RegistracijaKontroler;
import model.Naslov;
import model.Placanje;
import net.miginfocom.swing.MigLayout;
import observer.Observer;
import util.PogledUtil;

public class PanelRegistracija extends JPanel {
	private TekstPolje Ime;
	private TekstPolje Prezime;
	private JFormattedTextField Telefon;
	private TekstPolje Email;
	private JFormattedTextField Jmbg;
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
		
		Font fntNaslov = PogledUtil.getMaliNaslovFont();
		Font fntLabela = PogledUtil.getLabelaFont();
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
        JLabel datumRodjenjaLabel = new JLabel("Datum rodjenja:");
        JLabel korisnickoLabel = new JLabel("Korisnidko ime:");
        JLabel lozinkaLabel = new JLabel("Lozinka:");
        JLabel tipLabel = new JLabel("Tip:");
		
		
        Ime = new TekstPolje("", fntTekstPolje, 100, 30);
        Prezime = new TekstPolje("", fntTekstPolje, 100, 30);
        Telefon =  new JFormattedTextField(formatter);
        Telefon.setColumns(15);
        Email = new TekstPolje("", fntTekstPolje, 100, 30);
        Jmbg =  new JFormattedTextField(formatter);
        Jmbg.setColumns(15);
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
				registruj();
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
	
	public void registruj() {
		//id
		Random random = new Random();
        int id = random.nextInt();

        //ime
    	String ime = Ime.getText();
    	
    	//prezime
    	String prezime = Prezime.getText();

    	//telefon
    	String telefon;
        Object vrednost = Telefon.getValue();
        if (vrednost != null) {
            telefon = String.valueOf(vrednost);
        }

    	//email
    	String email = Email.getText();

    	//jmbg
    	String jmbg;
        vrednost = Telefon.getValue();
        if (vrednost != null) {
            jmbg = String.valueOf(vrednost);
        }

    	//datum rodjenja
    	String datRodj = DatumRodjenja.getText();

    	//korisnicko ime
    	String korisnicko = Korisnicko.getText();

    	//lozinka
    	String lozinka = Lozinka.getText();
		
		//datum uclanjivanja
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayString = today.format(formatter);
        
        //broj clanske karte
        int brClKarte = random.nextInt();
        
        //placanja
        List<Placanje> placanja = new ArrayList<Placanje>();
		
		//tip clanstva
		String selectedValue = (String) Tip.getSelectedItem();
		VrstaClana vrsta;
		if (selectedValue.equals(VrstaClana.DETE.toString())) {
			vrsta = VrstaClana.DETE;
		} else if (selectedValue.equals(VrstaClana.PENZIONER.toString())) {
			vrsta = VrstaClana.PENZIONER;
		} else if (selectedValue.equals(VrstaClana.STUDENT.toString())) {
			vrsta = VrstaClana.STUDENT;
		} else {
			vrsta = VrstaClana.OBICAN;
		}
		
		//validacija!!!!!!

	}
	
}
