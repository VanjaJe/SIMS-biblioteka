package Pogled.meni;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Pogled.FormaDugme;

public class MeniStavka extends JPanel {

	private static final long serialVersionUID = 7627665089080505037L;
	private FormaDugme btnStavka;
	
	public MeniStavka() {}
	
	public MeniStavka(String naziv) {
		
		setPreferredSize(new Dimension(250, 30));
		setBackground(new Color(228,242,242,255));
		
		btnStavka = new FormaDugme(naziv, new Color(228,242,242,255), Color.BLACK, 170, 30);
		add(btnStavka);
	}
	
	public JButton getDugmeStavke() {
		return this.btnStavka;
	}
}
