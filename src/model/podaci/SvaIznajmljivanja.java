package model.podaci;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Iznajmljivanje;

@XStreamAlias("svaIznajmljivanja")
public class SvaIznajmljivanja {
    public static SvaIznajmljivanja instance = null;

    @XStreamAlias("iznajmljivanja")
    private ArrayList<Iznajmljivanje> iznajmljivanja;

    public SvaIznajmljivanja(){
        this.iznajmljivanja = new ArrayList<Iznajmljivanje>();
    }

    public static SvaIznajmljivanja getInstance() {
        if (instance == null) {
            instance = new SvaIznajmljivanja();
        }
        return instance;
    }

    public long generisiId() {
        int brojIzn = iznajmljivanja.size();
        return ++brojIzn;
    }

    public static void setInstance(SvaIznajmljivanja svaIznajmljivanja) {
        instance = svaIznajmljivanja;
    }

    public ArrayList<Iznajmljivanje> getIznajmljivanja() {
        return this.iznajmljivanja;
    }

    public void setIznajmljivanja(ArrayList<Iznajmljivanje> iznajmljivanja) {
        this.iznajmljivanja = iznajmljivanja;
    }

    public Iznajmljivanje dodajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        this.iznajmljivanja.add(iznajmljivanje);
        return iznajmljivanje;
    }

}