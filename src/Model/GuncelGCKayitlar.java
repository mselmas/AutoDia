package Model;

public class GuncelGCKayitlar {

    private int id;

    private String arplaka;

    private String armarka_id;

    private String arrenk_id;

    private String artur_id;

    private String konum_id;

    private String girissaati;

    private String cikissaati;

    private double odenecekucret;

    private String konum2;

    private String renkler;

    private String turler;

    private String markalar;

    private String konumlar;

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

    public GuncelGCKayitlar(String renkler, String turler, String markalar, String konumlar) {
        this.renkler = renkler;
        this.turler = turler;
        this.markalar = markalar;
        this.konumlar = konumlar;
    }


    public GuncelGCKayitlar(String arplaka, String armarka_id, String arrenk_id, String artur_id, String konum_id, String girissaati) {
        this.arplaka = arplaka;
        this.armarka_id = armarka_id;
        this.arrenk_id = arrenk_id;
        this.artur_id = artur_id;
        this.konum_id = konum_id;
        this.girissaati = girissaati;
    }

    public GuncelGCKayitlar(int id, String arplaka, String armarka_id, String arrenk_id, String artur_id, String konum_id, String girissaati) {
        this.id = id;
        this.arplaka = arplaka;
        this.armarka_id = armarka_id;
        this.arrenk_id = arrenk_id;
        this.artur_id = artur_id;
        this.konum_id = konum_id;
        this.girissaati = girissaati;
    }

    public GuncelGCKayitlar(int id, String arplaka, String armarka_id, String arrenk_id, String artur_id, String konum_id, String girissaati, String cikissaati, double odenecekucret, String konum2, String renkler, String turler, String markalar, String konumlar) {
        this.id = id;
        this.arplaka = arplaka;
        this.armarka_id = armarka_id;
        this.arrenk_id = arrenk_id;
        this.artur_id = artur_id;
        this.konum_id = konum_id;
        this.girissaati = girissaati;
        this.cikissaati = cikissaati;
        this.odenecekucret = odenecekucret;
        this.konum2 = konum2;
        this.renkler = renkler;
        this.turler = turler;
        this.markalar = markalar;
        this.konumlar = konumlar;
    }

    public GuncelGCKayitlar() {
    }

    public GuncelGCKayitlar(int id, String arplaka, String armarka_id, String arrenk_id, String artur_id, String konum_id, String girissaati, String cikissaati, double odenecekucret, String konum2) {
        this.id = id;
        this.arplaka = arplaka;
        this.armarka_id = armarka_id;
        this.arrenk_id = arrenk_id;
        this.artur_id = artur_id;
        this.konum_id = konum_id;
        this.girissaati = girissaati;
        this.cikissaati = cikissaati;
        this.odenecekucret = odenecekucret;
        this.konum2 = konum2;
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

    public double getOdenecekucret() {
        return odenecekucret;
    }

    public void setOdenecekucret(double odenecekucret) {
        this.odenecekucret = odenecekucret;
    }

    public String getKonum2() {
        return konum2;
    }

    public void setKonum2(String konum2) {
        this.konum2 = konum2;
    }

}
