package serijalizacija;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import model.podaci.SviNaslovi;
import model.podaci.SviPrimerci;
import model.podaci.SviClanovi;

import model.podaci.SviAutori;
import model.podaci.SviInventari;
import model.podaci.SviIzdavaci;

import model.podaci.SvaIznajmljivanja;
import model.podaci.SvaPlacanja;

import model.podaci.SviKorisnici;


public class Serijalizacija {

	private XStream xstream;
	
	public Serijalizacija() {
		xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
		xstream.processAnnotations(SviKorisnici.class);
		xstream.processAnnotations(SviNaslovi.class);
		xstream.processAnnotations(SviPrimerci.class);
		xstream.processAnnotations(SviClanovi.class);
		xstream.processAnnotations(SviInventari.class);
		xstream.processAnnotations(SviIzdavaci.class);
		xstream.processAnnotations(SviAutori.class);
		xstream.processAnnotations(SvaIznajmljivanja.class);
		xstream.processAnnotations(SvaPlacanja.class);

	}
	
	public void sacuvaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		File fajlNaslovi = new File("./podaci/naslovi.xml");
		File fajlPrimerci = new File("./podaci/primerci.xml");
		File fajlClanovi = new File("./podaci/clanovi.xml");
		File fajlInventari = new File("./podaci/inventari.xml");
		File fajlIzdavaci = new File("./podaci/izdavaci.xml");
		File fajlIznajmljivanja = new File("./podaci/iznajmljivanja.xml");
		File fajlPlacanja = new File("./podaci/placanja.xml");
		
		
		OutputStream osKorisnici = new BufferedOutputStream(new FileOutputStream(fajlKorisnici));
		OutputStream osNaslovi = new BufferedOutputStream(new FileOutputStream(fajlNaslovi));
		OutputStream osPrimerci = new BufferedOutputStream(new FileOutputStream(fajlPrimerci));
		OutputStream osClanovi = new BufferedOutputStream(new FileOutputStream(fajlClanovi));
		OutputStream osInventari = new BufferedOutputStream(new FileOutputStream(fajlInventari));
		OutputStream osIzdavaci = new BufferedOutputStream(new FileOutputStream(fajlIzdavaci));
		OutputStream osIznjamljivanja = new BufferedOutputStream(new FileOutputStream(fajlIznajmljivanja));
		OutputStream osPlacanja = new BufferedOutputStream(new FileOutputStream(fajlPlacanja));



	
		try {
			xstream.toXML(SviKorisnici.getInstance(), osKorisnici);
			xstream.toXML(SviClanovi.getInstance(),osClanovi);
			xstream.toXML(SviNaslovi.getInstance(), osNaslovi);
			xstream.toXML(SviPrimerci.getInstance(), osPrimerci);
			xstream.toXML(SviInventari.getInstance(), osInventari);
			xstream.toXML(SviIzdavaci.getInstance(), osIzdavaci);
			xstream.toXML(SvaIznajmljivanja.getInstance(),osIznjamljivanja);
			xstream.toXML(SvaPlacanja.getInstance(),osPlacanja);


		} finally {
			osKorisnici.close();
			osNaslovi.close();
			osClanovi.close();
			osPrimerci.close();
			osIzdavaci.close();
			osInventari.close();
			osIznjamljivanja.close();
			osPlacanja.close();
		}
	}
	
	public void ucitaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		File fajlNaslovi = new File("./podaci/naslovi.xml");
		File fajlPrimerci = new File("./podaci/primerci.xml");
		File fajlClanovi = new File("./podaci/clanovi.xml");
		File fajlInvenatri = new File("./podaci/inventari.xml");
		File fajlIzdavaci = new File("./podaci/izdavaci.xml");
		File fajlAutori = new File("./podaci/autori.xml");
		File fajlIznajmljivanja = new File("./podaci/iznajmljivanja.xml");
		File fajlPlacanja = new File("./podaci/placanja.xml");


		InputStream isKorisnici = new BufferedInputStream(new FileInputStream(fajlKorisnici));
		InputStream isNaslovi = new BufferedInputStream(new FileInputStream(fajlNaslovi));
		InputStream isPrimerci = new BufferedInputStream(new FileInputStream(fajlPrimerci));
		InputStream isClanovi = new BufferedInputStream(new FileInputStream(fajlClanovi));
		InputStream isInventari = new BufferedInputStream(new FileInputStream(fajlInvenatri));
		InputStream isIzdavaci = new BufferedInputStream(new FileInputStream(fajlIzdavaci));
		InputStream isAutori = new BufferedInputStream(new FileInputStream(fajlAutori));
		InputStream isIznajmljivanja = new BufferedInputStream(new FileInputStream(fajlIznajmljivanja));
		InputStream isPlacanja = new BufferedInputStream(new FileInputStream(fajlPlacanja));


		SviKorisnici korisniciLista = null;
		SviNaslovi nasloviLista=null;
		SviPrimerci primerciLista=null;
		SviClanovi clanoviLista = null;
		SviInventari inventariLista=null;
		SviIzdavaci izdavaciLista=null;
		SviAutori autoriLista=null;
		SvaIznajmljivanja iznajmljivanjaLista=null;
		SvaPlacanja placanjaLista=null;

		try {
			korisniciLista = ((SviKorisnici) xstream.fromXML(isKorisnici));
			nasloviLista = ((SviNaslovi)xstream.fromXML(isNaslovi));
			primerciLista = ((SviPrimerci)xstream.fromXML(isPrimerci));
			clanoviLista= ((SviClanovi)xstream.fromXML(isClanovi));
			inventariLista = ((SviInventari)xstream.fromXML(isInventari));
			izdavaciLista = ((SviIzdavaci)xstream.fromXML(isIzdavaci));
			autoriLista = ((SviAutori)xstream.fromXML(isAutori));
			iznajmljivanjaLista=((SvaIznajmljivanja)xstream.fromXML(isIznajmljivanja));
			placanjaLista=((SvaPlacanja)xstream.fromXML(isPlacanja));

		} finally {
			isKorisnici.close();
			isNaslovi.close();
			isPrimerci.close();
			isClanovi.close();
			isInventari.close();
			isIzdavaci.close();
			isAutori.close();
			isIznajmljivanja.close();
			isPlacanja.close();
		}
		
		SviKorisnici.setInstance(korisniciLista);
		SviNaslovi.setInstance(nasloviLista);
		SviPrimerci.setInstance(primerciLista);		
		SviClanovi.setInstance(clanoviLista);
		SviInventari.setInstance(inventariLista);
		SviIzdavaci.setInstance(izdavaciLista);
		SviAutori.setInstance(autoriLista);
		SvaIznajmljivanja.setInstance(iznajmljivanjaLista);
		SvaPlacanja.setInstance(placanjaLista);
	}

	public XStream getXStream() {
		return xstream;
	}	
}
