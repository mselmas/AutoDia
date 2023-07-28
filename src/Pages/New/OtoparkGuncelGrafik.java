package Pages.New;

import CodeFactory.DatabaseFactory;
import CodeFactory.IconsFactory;
import Pages.MainPage;
import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OtoparkGuncelDurum extends JFrame {

    DbCrud dbCrud;
    DbAccess dbAccess;

    IconsFactory iconsFactory = new IconsFactory();


    private void kontrolEtVeDoldur(JButton button, int konumId) {
        String sql = "SELECT konum_id FROM giriskayit WHERE konum_id = ?";
        try {
            PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
            statement.setInt(1, konumId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                button.setFont(new Font("Futura", Font.BOLD, 14));
                button.setBackground(new java.awt.Color(236, 18, 18));
                button.setOpaque(true);
                button.setContentAreaFilled(true);
            } else {
                button.setFont(new Font("Futura", Font.PLAIN, 14));
                button.setBackground(new java.awt.Color(48, 182, 48));
                button.setOpaque(true);
                button.setContentAreaFilled(true);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    public OtoparkGuncelDurum() {

        dbAccess = new DbAccess("root",
                "Zurtex96!", "otoparkdb", 3306);

        dbCrud = new DbCrud(dbAccess.getConnection());


        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new java.awt.Color(197, 213, 243));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 750); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("Autodia Araç Kayıt İşlemleri");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage m = new MainPage();
                m.setVisible(true);
                dispose();
            }

        };

        JButton backButton = iconsFactory.createBackButton(backListener);
        add(backButton);

        JLabel oGuncelDurum = new JLabel("AutoDia Otopark Güncel Durumu");
        oGuncelDurum.setFont(new java.awt.Font("Futura", Font.PLAIN, 22));
        oGuncelDurum.setForeground(new java.awt.Color(0, 0, 0));
        oGuncelDurum.setBounds(180, 50, 350, 30);
        add(oGuncelDurum);

        JButton[] buttons = new JButton[18];

        JButton p1 = new JButton("P1");
        p1.setBounds(100, 160, 120, 70);
        p1.setForeground(new java.awt.Color(0, 0, 0));
        p1.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p1);

        String konumQuery = "SELECT konum_id FROM giriskayit WHERE konum_id = ?";
        String plakaQuery = "SELECT arplaka FROM giriskayit WHERE konum_id = ?";

        DatabaseFactory.updateButtonTextFromDatabase(p1, "P1", konumQuery, plakaQuery,1);

        JButton p2 = new JButton("P2");
        p2.setBounds(100, 240, 120, 70);
        p2.setForeground(new java.awt.Color(0, 0, 0));
        p2.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p2);

        DatabaseFactory.updateButtonTextFromDatabase(p2, "P2", konumQuery, plakaQuery,2);

        JButton p3 = new JButton("P3");
        p3.setBounds(100, 320, 120, 70);
        p3.setForeground(new java.awt.Color(0, 0, 0));
        p3.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p3);

        DatabaseFactory.updateButtonTextFromDatabase(p3, "P3", konumQuery, plakaQuery,3);

        JButton p4 = new JButton("P4");
        p4.setBounds(100, 400, 120, 70);
        p4.setForeground(new java.awt.Color(0, 0, 0));
        p4.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p4);

        DatabaseFactory.updateButtonTextFromDatabase(p4, "P4", konumQuery, plakaQuery,4);

        JButton p5 = new JButton("P5");
        p5.setBounds(100, 480, 120, 70);
        p5.setForeground(new java.awt.Color(0, 0, 0));
        p5.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p5);

        DatabaseFactory.updateButtonTextFromDatabase(p5, "P5", konumQuery, plakaQuery,5);

        JButton p6 = new JButton("P6");
        p6.setBounds(340, 160, 120, 70);
        p6.setForeground(new java.awt.Color(0, 0, 0));
        p6.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p6);

        DatabaseFactory.updateButtonTextFromDatabase(p6, "P6", konumQuery, plakaQuery,6);


        JButton p7 = new JButton("P7");
        p7.setBounds(340, 240, 120, 70);
        p7.setForeground(new java.awt.Color(0, 0, 0));
        p7.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p7);

        DatabaseFactory.updateButtonTextFromDatabase(p7, "P7", konumQuery, plakaQuery,7);


        JButton p8 = new JButton("P8");
        p8.setBounds(340, 320, 120, 70);
        p8.setForeground(new java.awt.Color(0, 0, 0));
        p8.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p8);

        DatabaseFactory.updateButtonTextFromDatabase(p8, "P8", konumQuery, plakaQuery,8);

        JButton p9 = new JButton("P9");
        p9.setBounds(340, 400, 120, 70);
        p9.setForeground(new java.awt.Color(0, 0, 0));
        p9.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p9);

        DatabaseFactory.updateButtonTextFromDatabase(p9, "P9", konumQuery, plakaQuery,9);


        JButton p10 = new JButton("P10");
        p10.setBounds(340, 480, 120, 70);
        p10.setForeground(new java.awt.Color(0, 0, 0));
        p10.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p10);

        DatabaseFactory.updateButtonTextFromDatabase(p10, "P10", konumQuery, plakaQuery,10);


        JButton p11 = new JButton("P11");
        p11.setBounds(580, 160, 120, 70);
        p11.setForeground(new java.awt.Color(0, 0, 0));
        p11.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p11);

        DatabaseFactory.updateButtonTextFromDatabase(p11, "P11", konumQuery, plakaQuery,11);

        JButton p12 = new JButton("P12");
        p12.setBounds(580, 240, 120, 70);
        p12.setForeground(new java.awt.Color(0, 0, 0));
        p12.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p12);

        DatabaseFactory.updateButtonTextFromDatabase(p12, "P12", konumQuery, plakaQuery,12);

        JButton p13 = new JButton("P13");
        p13.setBounds(580, 320, 120, 70);
        p13.setForeground(new java.awt.Color(0, 0, 0));
        p13.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p13);

        DatabaseFactory.updateButtonTextFromDatabase(p13, "P13", konumQuery, plakaQuery,13);

        JButton p14 = new JButton("P14");
        p14.setBounds(580, 400, 120, 70);
        p14.setForeground(new java.awt.Color(0, 0, 0));
        p14.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p14);

        DatabaseFactory.updateButtonTextFromDatabase(p14, "P14", konumQuery, plakaQuery,14);


        JButton p15 = new JButton("P15");
        p15.setBounds(580, 480, 120, 70);
        p15.setForeground(new java.awt.Color(0, 0, 0));
        p15.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p15);

        DatabaseFactory.updateButtonTextFromDatabase(p15, "P15", konumQuery, plakaQuery,15);

        JButton p16 = new JButton("P16");
        p16.setBounds(820, 240, 120, 70);
        p16.setForeground(new java.awt.Color(0, 0, 0));
        p16.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p16);

        DatabaseFactory.updateButtonTextFromDatabase(p16, "P16", konumQuery, plakaQuery,16);


        JButton p17 = new JButton("P17");
        p17.setBounds(820, 320, 120, 70);
        p17.setForeground(new java.awt.Color(0, 0, 0));
        p17.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p17);

        DatabaseFactory.updateButtonTextFromDatabase(p17, "P17", konumQuery, plakaQuery,17);


        JButton p18 = new JButton("P18");
        p18.setBounds(820, 400, 120, 70);
        p18.setForeground(new java.awt.Color(0, 0, 0));
        p18.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p18);

        DatabaseFactory.updateButtonTextFromDatabase(p18, "P18", konumQuery, plakaQuery,18);

        buttons[0] = p1;
        buttons[1] = p2;
        buttons[2] = p3;
        buttons[3] = p4;
        buttons[4] = p5;
        buttons[5] = p6;
        buttons[6] = p7;
        buttons[7] = p8;
        buttons[8] = p9;
        buttons[9] = p10;
        buttons[10] = p11;
        buttons[11] = p12;
        buttons[12] = p13;
        buttons[13] = p14;
        buttons[14] = p15;
        buttons[15] = p16;
        buttons[16] = p17;
        buttons[17] = p18;

        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            int konumId = i + 1;
            kontrolEtVeDoldur(button, konumId);
        }



    }

}
