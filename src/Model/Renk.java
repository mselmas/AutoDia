package Model;

public class Renk {

    private int id;
    private String renkler;

    public Renk() {
    }

    public Renk(int id, String renkler) {
        this.id = id;
        this.renkler = renkler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRenkler() {
        return renkler;
    }

    public void setRenkler(String renkler) {
        this.renkler = renkler;
    }

    @Override
    public String toString() {
        return getRenkler();
    }
}
