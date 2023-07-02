package main;

import java.io.IOException;

import Pogled.PrijavaProzor;
import serijalizacija.Serijalizacija;
//import util.Pokretanje;

public class Main {

	public static void main(String[] args) {
//		Pokretanje.inicijalizujJela();
		Serijalizacija serijalizacija = new Serijalizacija();
		try {
			serijalizacija.ucitaj();
		} catch (IOException e) {
			System.out.println("problem");
			e.printStackTrace();
		}
		PrijavaProzor prijavaProzor = new PrijavaProzor();
		prijavaProzor.setVisible(true);
	}
}
