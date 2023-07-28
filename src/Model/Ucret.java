package Model;

public class Ucret {

    private int id;

    private int ucretler;

    public Ucret() {
    }

    public Ucret(int id, int ucretler) {
        this.id = id;
        this.ucretler = ucretler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUcretler() {
        return ucretler;
    }

    public void setUcretler(int ucretler) {
        this.ucretler = ucretler;
    }

    @Override
    public String toString() {
        return getUcretler() + " TL ";
    }
}
