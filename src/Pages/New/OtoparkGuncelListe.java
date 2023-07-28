package Pages.New;

import CodeFactory.IconsFactory;
import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OtoparkGuncelListe extends JFrame {

    DbAccess dbAccess;
    DbCrud dbCrud;

    IconsFactory iconsFactory = new IconsFactory();

    public OtoparkGuncelListe() {

        dbAccess = new DbAccess("root",
                "Zurtex96!", "otoparkdb", 3306);

        dbCrud = new DbCrud(dbAccess.getConnection());

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 850); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("AutoDia OOS Otopark Güncel Giriş Bilgileri Ekranı");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 780, 150, 30);
        last.setFont(new Font("Futura", Font.PLAIN, 14));
        add(last);

        //Optionpane'deki ikon için resize ediyoruz
        int newWidth = 75; // Yeni boyut için genişlik ve yükseklik değerlerini belirleyin
        int newHeight = 75;

        Image image1 = new ImageIcon(Giris.class.getResource("/images/greylogo3.png")).getImage(); // Resmi al
        Image newImage = image1.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH); // Resmi yeni boyutla yeniden ölçeklendirin
        ImageIcon iconResized = new ImageIcon(newImage); // Yeniden boyutlandırılmış resmi kullanarak yeni bir ImageIcon oluştur

        //Burada back button oluşturmak için IconsFactory içindeki bir metotu çağırdık
        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage().setVisible(true);
                dispose();
            }
        };

        JButton backButton = iconsFactory.createBackButton(backListener);
        add(backButton);


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

        JLabel baslik = new JLabel("Güncel Araç Giriş Kayıtları Listesi", JLabel.CENTER);
        baslik.setForeground(new java.awt.Color(241, 236, 236));
        baslik.setFont(new Font("Futura", Font.PLAIN, 20));

        JPanel newPanel2 = new JPanel();
        newPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel2.setBackground(new java.awt.Color(107, 123, 137));
        newPanel2.setBounds(270, 220, 450, 50);
        newPanel2.add(baslik);
        add(newPanel2);

        DefaultTableModel defModel = new DefaultTableModel();
        Object[] colNames = {"ID", "Plaka", "Marka", "Model", "Renk", "Tür", "Konum", "Giriş Tarihi", "Giriş Saati"};
        Object[] rowData = new Object[9];

        JTable table = new JTable(defModel);
        table.setModel(defModel);
        table.setFont(new Font("Futura", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.setPreferredSize(new Dimension(1000, 500)); //Tablonun tamamının boyutunu ayarladık
        table.setGridColor(new java.awt.Color(94, 163, 224));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setEnabled(false);

        JTableHeader header = table.getTableHeader(); //Tablonun kolon adlarının fontu
        header.setFont(new Font("Futura", Font.PLAIN, 14));

        defModel.setColumnIdentifiers(colNames);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 280, 900, 400); //Tablonun scroll olması için gerekli boyutu verdik.
        scrollPane.setViewportView(table);
        add(scrollPane);

        String sql2 = "SELECT giriskayit.arplaka, konum.konumlar, giriskayit.id, giriskayit.armarka_id, giriskayit.armodel, giriskayit.arrenk_id, giriskayit.artur_id, giriskayit.konum_id, giriskayit.giristarihi, giriskayit.girissaati, armarka.markalar, arrenk.renkler, artur.turler FROM giriskayit JOIN konum ON giriskayit.konum_id = konum.id JOIN arrenk ON giriskayit.arrenk_id = arrenk.id JOIN artur ON giriskayit.artur_id = artur.id JOIN armarka ON giriskayit.armarka_id = armarka.id";

        try {
            PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rowData[0] = rs.getString("giriskayit.id");
                rowData[1] = rs.getString("giriskayit.arplaka");
                rowData[2] = rs.getString("armarka.markalar"); // Retrieve from the 'armarka' table
                rowData[3] = rs.getString("giriskayit.armodel"); // Retrieve from the 'armodel' table
                rowData[4] = rs.getString("arrenk.renkler"); // Retrieve from the 'arrenk' table
                rowData[5] = rs.getString("artur.turler"); // Retrieve from the 'artur' table
                rowData[6] = rs.getString("konum.konumlar"); // Retrieve from the 'konum' table
                rowData[7] = rs.getString("giriskayit.giristarihi");
                rowData[8] = rs.getString("giriskayit.girissaati");

                defModel.addRow(rowData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
