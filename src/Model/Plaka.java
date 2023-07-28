package Model;

import java.sql.Time;

public class Plaka {

    private int id;
    private String plakalar;

    private int armarka_id;
    private Marka marka;

    private Time giriSaati;

    public Time getGiriSaati() {
        return giriSaati;
    }

    public void setGiriSaati(Time giriSaati) {
        this.giriSaati = giriSaati;
    }

    public Plaka(Time giriSaati) {
        this.giriSaati = giriSaati;
    }

    public Plaka(int id, String plakalar, int armarka_id) {
        this.id = id;
        this.plakalar = plakalar;
        this.armarka_id = armarka_id;
    }

    public Plaka(int id, String plakalar, Marka marka) {
        this.id = id;
        this.plakalar = plakalar;
        this.marka = marka;
    }

    public Plaka() {
    }

    public Plaka(int id, String plakalar) {
        this.id = id;
        this.plakalar = plakalar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlakalar() {
        return plakalar;
    }

    public void setPlakalar(String plakalar) {
        this.plakalar = plakalar;
    }

    public int getArmarka_id() {
        return armarka_id;
    }

    public void setArmarka_id(int armarka_id) {
        this.armarka_id = armarka_id;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    @Override
    public String toString() {
        return getPlakalar();
    }
}
