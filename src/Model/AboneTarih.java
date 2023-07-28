package Model;

import java.sql.Date;
import java.util.Calendar;

public class AboneTarih {
    private int id;
    private Date tarihler;

    public AboneTarih() {
    }

    public AboneTarih(int id, Date tarihler) {
        this.id = id;
        this.tarihler = tarihler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTarihler() {
        return tarihler;
    }

    public void setTarihler(Date tarihler) {
        this.tarihler = tarihler;
    }

    @Override
    public String toString() {
        return getTarihler().toString();
    }

    public void setTarihler(java.util.Date utilDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(utilDate);
        this.tarihler = new Date(calendar.getTimeInMillis());
    }

}
