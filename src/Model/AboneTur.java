package Model;

public class AboneTur {

    private int id;

    private String aboneTur;

    public AboneTur() {
    }

    public AboneTur(int id, String aboneTur) {
        this.id = id;
        this.aboneTur = aboneTur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAboneTur() {
        return aboneTur;
    }

    public void setAboneTur(String aboneTur) {
        this.aboneTur = aboneTur;
    }

    @Override
    public String toString() {
        return getAboneTur();
    }
}
