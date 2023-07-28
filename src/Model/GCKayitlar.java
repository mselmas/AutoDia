package Model;

public class GCKayitlar {

    private int id;
    private String arplaka;
    private String armarka_id;
    private String arrenk_id;
    private String artur_id;
    private String konum_id;
    private String girissaati;
    private String cikissaati;
    private double odenenucret;

    private String renkler;

    private String turler;

    private String markalar;

    private String konumlar;



    public GCKayitlar(String renkler, String turler, String markalar, String konumlar) {
        this.renkler = renkler;
        this.turler = turler;
        this.markalar = markalar;
        this.konumlar = konumlar;
    }

    public GCKayitlar(int id, String arplaka, String armarka_id, String arrenk_id, String artur_id, String konum_id, String girissaati, String cikissaati, double odenenucret, String renkler, String turler, String markalar, String konumlar) {
        this.id = id;
        this.arplaka = arplaka;
        this.armarka_id = armarka_id;
        this.arrenk_id = arrenk_id;
        this.artur_id = artur_id;
        this.konum_id = konum_id;
        this.girissaati = girissaati;
        this.cikissaati = cikissaati;
        this.odenenucret = odenenucret;
        this.renkler = renkler;
        this.turler = turler;
        this.markalar = markalar;
        this.konumlar = konumlar;
    }

    public String getRenkler() {
        return renkler;
    }

    public void setRenkler(String renkler) {
        this.renkler = renkler;
    }

    public String getTurler() {
        return turler;
    }

    public void setTurler(String turler) {
        this.turler = turler;
    }

    public String getMarkalar() {
        return markalar;
    }

    public void setMarkalar(String markalar) {
        this.markalar = markalar;
    }

    public String getKonumlar() {
        return konumlar;
    }

    public void setKonumlar(String konumlar) {
        this.konumlar = konumlar;
    }

    public GCKayitlar() {
    }

    public GCKayitlar(int id, String arplaka, String armarka_id, String arrenk_id, String artur_id, String konum_id, String girissaati, String cikissaati, double odenenucret) {
        this.id = id;
        this.arplaka = arplaka;
        this.armarka_id = armarka_id;
        this.arrenk_id = arrenk_id;
        this.artur_id = artur_id;
        this.konum_id = konum_id;
        this.girissaati = girissaati;
        this.cikissaati = cikissaati;
        this.odenenucret = odenenucret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArplaka() {
        return arplaka;
    }

    public void setArplaka(String arplaka) {
        this.arplaka = arplaka;
    }

    public String getArmarka_id() {
        return armarka_id;
    }

    public void setArmarka_id(String armarka_id) {
        this.armarka_id = armarka_id;
    }

    public String getArrenk_id() {
        return arrenk_id;
    }

    public void setArrenk_id(String arrenk_id) {
        this.arrenk_id = arrenk_id;
    }

    public String getArtur_id() {
        return artur_id;
    }

    public void setArtur_id(String artur_id) {
        this.artur_id = artur_id;
    }

    public String getKonum_id() {
        return konum_id;
    }

    public void setKonum_id(String konum_id) {
        this.konum_id = konum_id;
    }

    public String getGirissaati() {
        return girissaati;
    }

    public void setGirissaati(String girissaati) {
        this.girissaati = girissaati;
    }


    public String getCikissaati() {
        return cikissaati;
    }

    public void setCikissaati(String cikissaati) {
        this.cikissaati = cikissaati;
    }

    public double getOdenenucret() {
        return odenenucret;
    }

    public void setOdenenucret(double odenenucret) {
        this.odenenucret = odenenucret;
    }
}
