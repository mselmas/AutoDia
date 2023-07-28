package Model;

import java.sql.Time;
import java.util.Calendar;

public class Saat {

    private int id;
    private Time girissaati;

    private int saat;

    private int dakika;

    public Saat(int saat, int dakika) {
        this.saat = saat;
        this.dakika = dakika;
    }

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public int getDakika() {
        return dakika;
    }

    public void setDakika(int dakika) {
        this.dakika = dakika;
    }

    public Saat() {
    }

    public Saat(int id, Time girissaati) {
        this.id = id;
        this.girissaati = girissaati;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getGirissaati() {
        return girissaati;
    }

    public void setGirissaati(Time girissaati) {
        this.girissaati = girissaati;
    }

    @Override
    public String toString() {
        return getGirissaati().toString();

    }

    //Dönüşüm metodu: Model.Saat'ten java.sql.Time'a dönüşüm
    public Time toSqlTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, saat);
        calendar.set(Calendar.MINUTE, dakika);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Time(calendar.getTimeInMillis());
    }
}
