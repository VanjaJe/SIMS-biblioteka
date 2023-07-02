package Pogled.meni;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Meni extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6278113298569448196L;
	private MeniStavka stavkaProfil;
	private MeniStavka stavkaKnjige;
	
	public Meni() {
		setPreferredSize(new Dimension(300, 100));
		setBackground(new Color(16, 97, 4));
		setLayout(new MigLayout("", "[300]", "50"));
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		//Image image = new ImageIcon(this.getClass().getResource("/bookshelf.png")).getImage();
		//lblImage.setIcon(new ImageIcon(image));
		
		stavkaProfil = new MeniStavka( "Profil");
		stavkaKnjige = new MeniStavka("Knjige");
		
		add(lblImage, "wrap, gaptop 25, gapbottom 40, align center");
		add(stavkaProfil, "wrap, align center");
		add(stavkaKnjige, "wrap, align center");
	}
	
	public MeniStavka getStavkaProfil() {
		return this.stavkaProfil;
	}
	
	public MeniStavka getStavkaKnjige() {
		return this.stavkaKnjige;
	}
	
}
