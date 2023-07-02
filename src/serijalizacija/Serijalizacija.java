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
	}
	
	public void sacuvaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		File fajlNaslovi = new File("./podaci/naslovi.xml");
		File fajlPrimerci = new File("./podaci/primerci.xml");
		File fajlClanovi = new File("./podaci/clanovi.xml");
		
		OutputStream osKorisnici = new BufferedOutputStream(new FileOutputStream(fajlKorisnici));
		OutputStream osNaslovi = new BufferedOutputStream(new FileOutputStream(fajlNaslovi));
		OutputStream osPrimerci = new BufferedOutputStream(new FileOutputStream(fajlPrimerci));
		OutputStream osClanovi = new BufferedOutputStream(new FileOutputStream(fajlClanovi));

		try {
			xstream.toXML(SviKorisnici.getInstance(), osKorisnici);
			xstream.toXML(SviNaslovi.getInstance(),osNaslovi);
			xstream.toXML(SviPrimerci.getInstance(),osPrimerci);
			xstream.toXML(SviClanovi.getInstance(),osClanovi);

		} finally {
			osKorisnici.close();
			osNaslovi.close();
			osClanovi.close();
		}
	}
	
	public void ucitaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		File fajlNaslovi = new File("./podaci/naslovi.xml");
		File fajlPrimerci = new File("./podaci/primerci.xml");
		File fajlClanovi = new File("./podaci/clanovi.xml");

		InputStream isKorisnici = new BufferedInputStream(new FileInputStream(fajlKorisnici));
		InputStream isNaslovi = new BufferedInputStream(new FileInputStream(fajlNaslovi));
		InputStream isPrimerci = new BufferedInputStream(new FileInputStream(fajlPrimerci));
		InputStream isClanovi = new BufferedInputStream(new FileInputStream(fajlClanovi));

		SviKorisnici korisniciLista = null;
		SviNaslovi nasloviLista=null;
		SviPrimerci primerciLista=null;
		SviClanovi clanoviLista = null;

		try {
			korisniciLista = ((SviKorisnici) xstream.fromXML(isKorisnici));
			nasloviLista= ((SviNaslovi)xstream.fromXML(isNaslovi));
			primerciLista= ((SviPrimerci)xstream.fromXML(isPrimerci));
			clanoviLista= ((SviClanovi)xstream.fromXML(isClanovi));

		} finally {
			isKorisnici.close();
			isNaslovi.close();
			isPrimerci.close();
			isClanovi.close();
		}
		SviKorisnici.setInstance(korisniciLista);
		SviNaslovi.setInstance(nasloviLista);
		SviPrimerci.setInstance(primerciLista);
		SviClanovi.setInstance(clanoviLista);
	}
	

	public XStream getXStream() {
		return xstream;
	}	
}
