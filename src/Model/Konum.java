package Model;

public class Konum {

    private int id;
    private String konum;

    public Konum() {
    }

    public Konum(int id, String konum) {
        this.id = id;
        this.konum = konum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    @Override
    public String toString() {
        return getKonum();
    }
}
