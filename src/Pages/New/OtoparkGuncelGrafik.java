package Pages.New;

import CodeFactory.DatabaseFactory;
import CodeFactory.IconsFactory;
import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OtoparkGuncelGrafik extends JFrame {

    DbCrud dbCrud;
    DbAccess dbAccess;

    IconsFactory iconsFactory = new IconsFactory();

    DatabaseFactory df = new DatabaseFactory();


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


    public OtoparkGuncelGrafik() {

        dbAccess = new DbAccess("root",
                "Zurtex96!", "otoparkdb", 3306);

        dbCrud = new DbCrud(dbAccess.getConnection());


        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200);
        setLayout(null);
        setSize(1000, 850);
        setTitle("AutoDia OOS Otopark Güncel Park Konumu Ekranı");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage().setVisible(true);
                dispose();
            }
        };

        JButton backButton = iconsFactory.createBackButton(backListener);
        add(backButton);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 770, 150, 30);
        last.setFont(new Font("Futura", Font.PLAIN, 14));
        add(last);

        //Label'i panel oluşturarak ekledik
        JLabel label = new JLabel("AutoDia Otopark Otomasyon Sistemi", JLabel.CENTER);
        label.setFont(new Font("Futura", Font.PLAIN, 26));
        label.setForeground(new java.awt.Color(241, 236, 236));

        //Logoyu iconsfactory'deki metot ile ürettik - Global'de tanımladık nesneyi ilk önce
        JLabel logo = iconsFactory.createAutoDiaLogo(400, 110, 200, 80);
        add(logo);

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel.setBackground(new java.awt.Color(107, 123, 137));
        newPanel.setBounds(280, 40, 450, 50);
        newPanel.add(label);
        add(newPanel);

        JLabel baslik = new JLabel("Otopark Konumları Güncel Durumu", JLabel.CENTER);
        baslik.setForeground(new java.awt.Color(241, 236, 236));
        baslik.setFont(new Font("Futura", Font.PLAIN, 20));

        JPanel newPanel2 = new JPanel();
        newPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel2.setBackground(new java.awt.Color(107, 123, 137));
        newPanel2.setBounds(270, 220, 450, 50);
        newPanel2.add(baslik);
        add(newPanel2);

        JButton[] buttons = new JButton[18];

        JButton p1 = new JButton("P1");
        p1.setBounds(100, 320, 120, 70);
        p1.setForeground(new java.awt.Color(0, 0, 0));
        p1.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p1);

        String konumQuery = "SELECT konum_id FROM giriskayit WHERE konum_id = ?";
        String plakaQuery = "SELECT arplaka FROM giriskayit WHERE konum_id = ?";

        df.updateButtonTextFromDB(p1, "P1", konumQuery, plakaQuery,1);

        JButton p2 = new JButton("P2");
        p2.setBounds(100, 400, 120, 70);
        p2.setForeground(new java.awt.Color(0, 0, 0));
        p2.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p2);

        df.updateButtonTextFromDB(p2, "P2", konumQuery, plakaQuery,2);

        JButton p3 = new JButton("P3");
        p3.setBounds(100, 480, 120, 70);
        p3.setForeground(new java.awt.Color(0, 0, 0));
        p3.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p3);

        df.updateButtonTextFromDB(p3, "P3", konumQuery, plakaQuery,3);

        JButton p4 = new JButton("P4");
        p4.setBounds(100, 560, 120, 70);
        p4.setForeground(new java.awt.Color(0, 0, 0));
        p4.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p4);

        df.updateButtonTextFromDB(p4, "P4", konumQuery, plakaQuery,4);

        JButton p5 = new JButton("P5");
        p5.setBounds(100, 640, 120, 70);
        p5.setForeground(new java.awt.Color(0, 0, 0));
        p5.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p5);

        df.updateButtonTextFromDB(p5, "P5", konumQuery, plakaQuery,5);

        JButton p6 = new JButton("P6");
        p6.setBounds(340, 320, 120, 70);
        p6.setForeground(new java.awt.Color(0, 0, 0));
        p6.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p6);

        df.updateButtonTextFromDB(p6, "P6", konumQuery, plakaQuery,6);

        JButton p7 = new JButton("P7");
        p7.setBounds(340, 400, 120, 70);
        p7.setForeground(new java.awt.Color(0, 0, 0));
        p7.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p7);

        df.updateButtonTextFromDB(p7, "P7", konumQuery, plakaQuery,7);

        JButton p8 = new JButton("P8");
        p8.setBounds(340, 480, 120, 70);
        p8.setForeground(new java.awt.Color(0, 0, 0));
        p8.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p8);

        df.updateButtonTextFromDB(p8, "P8", konumQuery, plakaQuery,8);

        JButton p9 = new JButton("P9");
        p9.setBounds(340, 560, 120, 70);
        p9.setForeground(new java.awt.Color(0, 0, 0));
        p9.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p9);

        df.updateButtonTextFromDB(p9, "P9", konumQuery, plakaQuery,9);

        JButton p10 = new JButton("P10");
        p10.setBounds(340, 640, 120, 70);
        p10.setForeground(new java.awt.Color(0, 0, 0));
        p10.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p10);

        df.updateButtonTextFromDB(p10, "P10", konumQuery, plakaQuery,10);

        JButton p11 = new JButton("P11");
        p11.setBounds(580, 320, 120, 70);
        p11.setForeground(new java.awt.Color(0, 0, 0));
        p11.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p11);

        df.updateButtonTextFromDB(p11, "P11", konumQuery, plakaQuery,11);

        JButton p12 = new JButton("P12");
        p12.setBounds(580, 400, 120, 70);
        p12.setForeground(new java.awt.Color(0, 0, 0));
        p12.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p12);

        df.updateButtonTextFromDB(p12, "P12", konumQuery, plakaQuery,12);

        JButton p13 = new JButton("P13");
        p13.setBounds(580, 480, 120, 70);
        p13.setForeground(new java.awt.Color(0, 0, 0));
        p13.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p13);

        df.updateButtonTextFromDB(p13, "P13", konumQuery, plakaQuery,13);

        JButton p14 = new JButton("P14");
        p14.setBounds(580, 560, 120, 70);
        p14.setForeground(new java.awt.Color(0, 0, 0));
        p14.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p14);

        df.updateButtonTextFromDB(p14, "P14", konumQuery, plakaQuery,14);


        JButton p15 = new JButton("P15");
        p15.setBounds(580, 640, 120, 70);
        p15.setForeground(new java.awt.Color(0, 0, 0));
        p15.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p15);

        df.updateButtonTextFromDB(p15, "P15", konumQuery, plakaQuery,15);

        JButton p16 = new JButton("P16");
        p16.setBounds(820, 400, 120, 70);
        p16.setForeground(new java.awt.Color(0, 0, 0));
        p16.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p16);

        df.updateButtonTextFromDB(p16, "P16", konumQuery, plakaQuery,16);


        JButton p17 = new JButton("P17");
        p17.setBounds(820, 480, 120, 70);
        p17.setForeground(new java.awt.Color(0, 0, 0));
        p17.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p17);

        df.updateButtonTextFromDB(p17, "P17", konumQuery, plakaQuery,17);


        JButton p18 = new JButton("P18");
        p18.setBounds(820, 560, 120, 70);
        p18.setForeground(new java.awt.Color(0, 0, 0));
        p18.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        add(p18);

        df.updateButtonTextFromDB(p18, "P18", konumQuery, plakaQuery,18);

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
