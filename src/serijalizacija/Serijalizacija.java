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

import model.podaci.SviKorisnici;


public class Serijalizacija {

	private XStream xstream;
	
	public Serijalizacija() {
		xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
		xstream.processAnnotations(SviKorisnici.class);

	}
	
	public void sacuvaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");

		OutputStream osKorisnici = new BufferedOutputStream(new FileOutputStream(fajlKorisnici));

		try {
			xstream.toXML(SviKorisnici.getInstance(), osKorisnici);

		} finally {
			osKorisnici.close();
		}
	}
	
	public void ucitaj() throws IOException {
		File fajlKorisnici = new File("./podaci/korisnici.xml");
		InputStream isKorisnici = new BufferedInputStream(new FileInputStream(fajlKorisnici));
		SviKorisnici korisniciLista = null;

		try {
			korisniciLista = ((SviKorisnici) xstream.fromXML(isKorisnici));

		} finally {
			isKorisnici.close();

		}
		SviKorisnici.setInstance(korisniciLista);
	}
	
	public XStream getXStream() {
		return xstream;
	}
	
}
