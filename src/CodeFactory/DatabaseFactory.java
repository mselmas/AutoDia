package CodeFactory;

import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseFactory {

    /**
     * Bu metot giriş yapan araçların plakalarını JButton nesnesi üzerinde güncellenmesini sağlar.
     * @param button        Metni güncellenecek JButton nesnesi
     * @param buttonText    Metinle değiştirilecek olan düğme başlangıç metni
     * @param konumQuery    Konum sorgusu
     * @param plakaQuery    Plaka sorgusu
     * @param konumID       Konum ID'si
     */
    public static void updateButtonTextFromDB(JButton button, String buttonText, String konumQuery, String plakaQuery, int konumID) {

        DbAccess dbAccess = new DbAccess("root", "Zurtex96!", "otoparkdb", 3306);
        DbCrud dbCrud = new DbCrud(dbAccess.getConnection());

        String originalText = button.getText();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getText().equals(originalText)) {
                    try {

                        PreparedStatement statement = dbCrud.getConnection().prepareStatement(konumQuery);
                        statement.setInt(1, konumID);
                        ResultSet rs = statement.executeQuery();

                        if (rs.next()) {
                            int konumID = rs.getInt("konum_id");

                            PreparedStatement statement2 = dbCrud.getConnection().prepareStatement(plakaQuery);
                            statement2.setInt(1, konumID);
                            ResultSet rs2 = statement2.executeQuery();

                            if (rs2.next()) {
                                String plaka = rs2.getString("arplaka");
                                button.setText(plaka.trim());
                            }
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    button.setText(originalText);
                }
            }
        });
    }


}
