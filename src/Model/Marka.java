package Model;

public class Marka {

    private int id;
    private String markalar;

    public Marka() {
    }

    public Marka(int id, String markalar) {
        this.id = id;
        this.markalar = markalar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarkalar() {
        return markalar;
    }

    public void setMarkalar(String markalar) {
        this.markalar = markalar;
    }

    @Override
    public String toString() {
        return getMarkalar();
    }
}
