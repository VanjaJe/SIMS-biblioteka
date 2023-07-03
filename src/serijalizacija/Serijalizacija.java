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
import model.podaci.SviAutori;
import model.podaci.SviInventari;
import model.podaci.SviIzdavaci;
import model.podaci.SviKorisnici;


public class Serijalizacija {

	private XStream xstream;
	
	public Serijalizacija() {
		xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
		xstream.processAnnotations(SviKorisnici.class);
		xstream.processAnnotations(SviNaslovi.class);
		xstream.processAnnotations(SviPrimerci.class);
		xstream.processAnnotations(SviInventari.class);
		xstream.processAnnotations(SviIzdavaci.class);
		xstream.processAnnotations(SviAutori.class);
	}
	
	public void sacuvaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		File fajlNaslovi = new File("./podaci/naslovi.xml");
		File fajlPrimerci = new File("./podaci/primerci.xml");
		File fajlInventari = new File("./podaci/inventari.xml");
		File fajlIzdavaci = new File("./podaci/izdavaci.xml");

		
		OutputStream osKorisnici = new BufferedOutputStream(new FileOutputStream(fajlKorisnici));
		OutputStream osNaslovi = new BufferedOutputStream(new FileOutputStream(fajlNaslovi));
		OutputStream osPrimerci = new BufferedOutputStream(new FileOutputStream(fajlPrimerci));
		OutputStream osInventari = new BufferedOutputStream(new FileOutputStream(fajlInventari));
		OutputStream osIzdavaci = new BufferedOutputStream(new FileOutputStream(fajlIzdavaci));


		try {
			xstream.toXML(SviKorisnici.getInstance(), osKorisnici);
			xstream.toXML(SviNaslovi.getInstance(), osNaslovi);
			xstream.toXML(SviPrimerci.getInstance(), osPrimerci);
			xstream.toXML(SviInventari.getInstance(), osInventari);
			xstream.toXML(SviIzdavaci.getInstance(), osIzdavaci);

		} finally {
			osKorisnici.close();
			osNaslovi.close();
			osPrimerci.close();
			osIzdavaci.close();
			osInventari.close();
			osInventari.close();
		}
	}
	
	public void ucitaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		File fajlNaslovi = new File("./podaci/naslovi.xml");
		File fajlPrimerci = new File("./podaci/primerci.xml");
		File fajlInvenatri = new File("./podaci/inventari.xml");
		File fajlIzdavaci = new File("./podaci/izdavaci.xml");
		File fajlAutori = new File("./podaci/autori.xml");

		InputStream isKorisnici = new BufferedInputStream(new FileInputStream(fajlKorisnici));
		InputStream isNaslovi = new BufferedInputStream(new FileInputStream(fajlNaslovi));
		InputStream isPrimerci = new BufferedInputStream(new FileInputStream(fajlPrimerci));
		InputStream isInventari = new BufferedInputStream(new FileInputStream(fajlInvenatri));
		InputStream isIzdavaci = new BufferedInputStream(new FileInputStream(fajlIzdavaci));
		InputStream isAutori = new BufferedInputStream(new FileInputStream(fajlAutori));


		SviKorisnici korisniciLista = null;
		SviNaslovi nasloviLista=null;
		SviPrimerci primerciLista=null;
		SviInventari inventariLista=null;
		SviIzdavaci izdavaciLista=null;
		SviAutori autoriLista=null;

		try {
			korisniciLista = ((SviKorisnici) xstream.fromXML(isKorisnici));
			nasloviLista = ((SviNaslovi)xstream.fromXML(isNaslovi));
			primerciLista = ((SviPrimerci)xstream.fromXML(isPrimerci));
			inventariLista = ((SviInventari)xstream.fromXML(isInventari));
			izdavaciLista = ((SviIzdavaci)xstream.fromXML(isIzdavaci));
			autoriLista = ((SviAutori)xstream.fromXML(isAutori));

		} finally {
			isKorisnici.close();
			isNaslovi.close();
			isPrimerci.close();
			isInventari.close();
			isIzdavaci.close();
			isAutori.close();
		}
		
		SviKorisnici.setInstance(korisniciLista);
		SviNaslovi.setInstance(nasloviLista);
		SviPrimerci.setInstance(primerciLista);
		SviInventari.setInstance(inventariLista);
		SviIzdavaci.setInstance(izdavaciLista);
		SviAutori.setInstance(autoriLista);
	}

	public XStream getXStream() {
		return xstream;
	}	
}
