package CodeFactory;

import Model.AboneTarih;
import Model.Plaka;
import Model.Saat;
import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryFactory {

    DbAccess dbAccess = new DbAccess("root", "Zurtex96!", "otoparkdb", 3306);

    DbCrud dbCrud = new DbCrud(dbAccess.getConnection());

    /**
     * Veritabanından tüm plakaları getirir
     *
     * @return Veritabanından alınan plakaların bir listesi olan ArrayList
     */
    public ArrayList<Plaka> getPlakalar() {

        ArrayList<Plaka> plakalarArrayList = new ArrayList<>();
        String sql = "SELECT * FROM giriskayit";

        try {
            PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Plaka plaka = new Plaka();
                plaka.setPlakalar(rs.getString("arplaka"));
                plakalarArrayList.add(plaka);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {

        }

        return plakalarArrayList;
    }

    /**
     * Veritabanından giriş saatini alır.
     *
     * @return Veritabanından alınan saatlerin bir listesi olan ArrayList
     */
    public ArrayList<Saat> getSaatler() {
        ArrayList<Saat> saatArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "girissaati2");

        try {
            while (rs.next()) {
                Saat s = new Saat();
                s.setGirissaati(rs.getTime("girissaati"));
                saatArrayList.add(s);
            }
        } catch (Exception e) {
        }
        return saatArrayList;

    }


    /**
     *Veritabandan plaka numarasına göre aracın giriş saatini alır
     * @param plaka Aracın plakası
     * @return Veritabanından alınan aracın otoparka giriş saati
     */

    public String getSaatByPlaka(String plaka) {
        String saat = "";
        String sql = "SELECT girissaati FROM giriskayit WHERE arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                saat = resultSet.getString("girissaati");
            }

            resultSet.close();
            statement.close();

        } catch (SQLException ex) {

        }

        return saat;

    }

    /**
     *Veritabandan plaka numarasına göre aracın otoparka giriş tarihini alır
     * @param plaka Aracın plakası
     * @return Veritabanından alınan tarih
     */
    public String getGirisTarihiByPlaka(String plaka) {
        String tarih = "";
        String sql = "SELECT giristarihi FROM giriskayit WHERE arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                tarih = rs.getString("giristarihi");
            }

            rs.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tarih;

    }

    /**
     *Veritabandan plaka numarasına göre aracın rengini alır
     * @param plaka Aracın plakası
     * @return Veritabandan alınan aracın rengi
     */
    public String getRenkbyPlaka(String plaka) {
        String renk = "";
        String sql = "SELECT k.renkler FROM giriskayit g JOIN arrenk k ON g.arrenk_id = k.id WHERE g.arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                renk = resultSet.getString("renkler");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {

        }
        return renk;
    }

    /**
     *Veritabandan plaka numarasına göre aracın türünü alır
     * @param plaka Aracın plakası
     * @return Veritabandan alınan aracın türü
     */
    public String getTurByPlaka(String plaka) {
        String tur = "";
        String sql = "SELECT k.turler FROM giriskayit g JOIN artur k ON g.artur_id = k.id WHERE g.arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tur = resultSet.getString("turler");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {

        }
        return tur;
    }

    //Buradaki metot ile kapalı textField içine Plaka verisini yukarıda seçtikten sonra atanan konumun gelmesini sağlıyoruz.
    /**
     *Veritabanından plaka numarasına göre aracın park konumunu alır.
     * @param plaka Aracın plakası
     * @return Veritabandan alınan aracın park konumu
     */
    public String getKonumByPlaka(String plaka) {
        String konum = "";
        String sql = "SELECT k.konumlar FROM giriskayit g JOIN konum k ON g.konum_id = k.id WHERE g.arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                konum = resultSet.getString("konumlar");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return konum;
    }

    /**
     *Veritabandan plaka numarasına göre aracın markasını alır
     * @param plaka Aracın plakası
     * @return Veritabandan alınan aracın markası
     */
    public String getMarkaByPlaka(String plaka) {
        String marka = "";
        String sql = "SELECT k.markalar FROM giriskayit g JOIN armarka k ON g.armarka_id = k.id WHERE g.arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                marka = resultSet.getString("markalar");
            }
            resultSet.close();
            statement.close();

        } catch (SQLException ex) {

        }
        return marka;
    }

    /**
     * Veritabanından belli bir plakaya göre araç rengini alır
     *
     * @param plaka Abonenin plakası
     * @return Veritabanından alınan aracın rengi
     */
    public String getRenkByPlaka(String plaka) {
        String renk = "";
        String sql = "SELECT k.renkler FROM giriskayit g JOIN arrenk k ON g.arrenk_id = k.id WHERE g.arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                renk = rs.getString("renkler");
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return renk;
    }


    /**
     * Veritabanından belli bir plakaya göre aracın modelini alır.
     *
     * @param plaka Abonenin plakası
     * @return Veritabandan alınan aracın modeli
     */
    public String getModelByPlaka(String plaka) {
        String model = "";
        String sql = "SELECT armodel FROM giriskayit WHERE arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                model = rs.getString("armodel");
            }
            rs.close();
            statement.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return model;

    }

    /**
     * Veritabanından bir aboneye ait aracın araç modelini alır.
     *
     * @param plaka Abonenin plakası
     * @return Veritabandan alınan aracın modeli
     */
    public String getModelByAbonePlaka(String plaka) {
        String model = "";
        String sql = "SELECT armodel FROM aboneler WHERE arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                model = rs.getString("armodel");
            }
            rs.close();
            statement.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return model;


    }

    /**
     * Veritabanından bir abonenin araç markasını alır
     *
     * @param plaka Abonenin plakası
     * @return Veritabanından alınan aracın markası
     */
    public int getMarkaByAbonePlaka(String plaka) {
        int marka = 0;
        String sql = "SELECT armarka_id FROM aboneler WHERE arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                marka = rs.getInt("armarka_id");
            }
            rs.close();
            statement.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return marka;


    }

    /**
     * Veritabanından bir abonenin araç rengini alır.
     * @param plaka Abonenin plakası
     * @return  Veritabanından alınan aracın rengi
     */
    public int getRenkByAbonePlaka(String plaka) {
        int renk = 0;
        String sql = "SELECT arrenk_id FROM aboneler WHERE arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                renk = rs.getInt("arrenk_id");
            }
            rs.close();
            statement.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return renk;


    }

    /**
     * Veritabanından bir abonenin abonelik türünü alır.
     *
     * @param plaka Abonenin plakası
     * @return Veritabanından alınan abonenin abonelik türü
     */
    public int getTurByAbonePlaka(String plaka) {
        int tur = 0;
        String sql = "SELECT artur_id FROM aboneler WHERE arplaka = ?";

        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setString(1, plaka);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                tur = rs.getInt("artur_id");
            }
            rs.close();
            statement.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tur;


    }








}



