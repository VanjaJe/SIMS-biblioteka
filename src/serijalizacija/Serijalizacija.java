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
		xstream.processAnnotations(SvaIznajmljivanja.class);
		xstream.processAnnotations(SvaPlacanja.class);
	}
	
	public void sacuvaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		File fajlNaslovi = new File("./podaci/naslovi.xml");
		File fajlPrimerci = new File("./podaci/primerci.xml");
		File fajlIznajmljivanja = new File("./podaci/iznajmljivanja.xml");
		File fajlPlacanja = new File("./podaci/placanja.xml");
		
		
		OutputStream osKorisnici = new BufferedOutputStream(new FileOutputStream(fajlKorisnici));
		OutputStream osNaslovi = new BufferedOutputStream(new FileOutputStream(fajlNaslovi));
		OutputStream osPrimerci = new BufferedOutputStream(new FileOutputStream(fajlPrimerci));
		OutputStream osIznjamljivanja = new BufferedOutputStream(new FileOutputStream(fajlIznajmljivanja));
		OutputStream osPlacanja = new BufferedOutputStream(new FileOutputStream(fajlPlacanja));


	
		try {
			xstream.toXML(SviKorisnici.getInstance(), osKorisnici);
			xstream.toXML(SviNaslovi.getInstance(),osNaslovi);
			xstream.toXML(SviPrimerci.getInstance(),osPrimerci);
			xstream.toXML(SvaIznajmljivanja.getInstance(),osIznjamljivanja);
			xstream.toXML(SvaPlacanja.getInstance(),osPlacanja);


		} finally {
			osKorisnici.close();
			osNaslovi.close();
			osPrimerci.close();
			osIznjamljivanja.close();
			osPlacanja.close();
		}
	}
	
	public void ucitaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		File fajlNaslovi = new File("./podaci/naslovi.xml");
		File fajlPrimerci = new File("./podaci/primerci.xml");
		File fajlIznajmljivanja = new File("./podaci/iznajmljivanja.xml");
		File fajlPlacanja = new File("./podaci/placanja.xml");


		InputStream isKorisnici = new BufferedInputStream(new FileInputStream(fajlKorisnici));
		InputStream isNaslovi = new BufferedInputStream(new FileInputStream(fajlNaslovi));
		InputStream isPrimerci = new BufferedInputStream(new FileInputStream(fajlPrimerci));
		InputStream isIznajmljivanja = new BufferedInputStream(new FileInputStream(fajlIznajmljivanja));
		InputStream isPlacanja = new BufferedInputStream(new FileInputStream(fajlPlacanja));


		SviKorisnici korisniciLista = null;
		SviNaslovi nasloviLista=null;
		SviPrimerci primerciLista=null;
		SvaIznajmljivanja iznajmljivanjaLista=null;
		SvaPlacanja placanjaLista=null;

		try {
			korisniciLista = ((SviKorisnici) xstream.fromXML(isKorisnici));
			nasloviLista= ((SviNaslovi)xstream.fromXML(isNaslovi));
			primerciLista= ((SviPrimerci)xstream.fromXML(isPrimerci));
			iznajmljivanjaLista=((SvaIznajmljivanja)xstream.fromXML(isIznajmljivanja));
			placanjaLista=((SvaPlacanja)xstream.fromXML(isPlacanja));

		} finally {
			isKorisnici.close();
			isNaslovi.close();
			isPrimerci.close();
			isIznajmljivanja.close();
			isPlacanja.close();
		}
		SviKorisnici.setInstance(korisniciLista);
		SviNaslovi.setInstance(nasloviLista);
		SviPrimerci.setInstance(primerciLista);
		SvaIznajmljivanja.setInstance(iznajmljivanjaLista);
		SvaPlacanja.setInstance(placanjaLista);
	}
	

	public XStream getXStream() {
		return xstream;
	}	
}
