package Model;

public class Tur {

    private int id;
    private String turler;


    public Tur() {
    }


    public Tur(int id, String turler) {
        this.id = id;
        this.turler = turler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTurler() {
        return turler;
    }

    public void setTurler(String turler) {
        this.turler = turler;
    }

    @Override
    public String toString() {
        return getTurler();
    }
}
