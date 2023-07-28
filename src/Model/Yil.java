package Model;

public class Yil {

    private int id;
    private String yillar;

    public Yil() {
    }

    public Yil(int id, String yillar) {
        this.id = id;
        this.yillar = yillar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYillar() {
        return yillar;
    }

    public void setYillar(String yillar) {
        this.yillar = yillar;
    }

    @Override
    public String toString() {
        return getYillar();
    }

}
