package Pages.New;

import CodeFactory.IconsFactory;
import Model.*;
import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AboneKayitIslemi extends JFrame {

    DbAccess dbAccess;
    DbCrud dbCrud;
    IconsFactory iconsFactory = new IconsFactory();

    /**
     * Veritabanından tüm markaları getirir.
     * @return Veritabanından alınan markaların bir listesi olan ArrayList
     */
    public ArrayList<Marka> markalariGetir() {

        ArrayList<Marka> markaArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "armarka");

        try {
            while (rs.next()) {
                Marka m = new Marka();
                m.setId(rs.getInt("id"));
                m.setMarkalar(rs.getString("markalar"));
                markaArrayList.add(m);
            }
        } catch (Exception e) {
        }
        return markaArrayList;
    }

    /**
     * Veritabanından tüm araç türlerini getirir.
     * @return   Veritabanından alınan araç türlerin bir listesi olan ArrayList
     */
    public ArrayList<Tur> turleriGetir() {
        ArrayList<Tur> turArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "artur");

        try {
            while (rs.next()) {
                Tur t = new Tur();
                t.setId(rs.getInt("id"));
                t.setTurler(rs.getString("turler"));
                turArrayList.add(t);
            }
        } catch (Exception e) {
        }

        return turArrayList;
    }

    /**
     * Veritabanından tüm renkleri getirir.
     * @return Veritabanından alınan renklerin bir listesi olan ArrayList
     */
    public ArrayList<Renk> renkleriGetir() {
        ArrayList<Renk> renkArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "arrenk");

        try {
            while (rs.next()) {
                Renk r = new Renk();
                r.setId(rs.getInt("id"));
                r.setRenkler(rs.getString("renkler"));
                renkArrayList.add(r);
            }
        } catch (Exception e) {
        }
        return renkArrayList;
    }

    /**
     * Veritabanından tüm yılları getirir.
     * @return Veritabanından alınan yılların bir listesi olan ArrayList
     */

    public ArrayList<Yil> yillariGetir() {
        ArrayList<Yil> yilArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "aryil");
        try {
            while (rs.next()) {
                Yil y = new Yil();
                y.setId(rs.getInt("id"));
                y.setYillar(rs.getString("yillar"));
                yilArrayList.add(y);
            }
        } catch (Exception e) {
        }
        return yilArrayList;
    }

    /**
     * Veritabanından tüm abonelik türlerini getirir.
     * @return
     */

    public ArrayList<AboneTur> abonelikTurleriGetir() {
        ArrayList<AboneTur> turArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "aboneTur");
        try {
            while (rs.next()) {
                AboneTur t = new AboneTur();
                t.setId(rs.getInt("id"));
                t.setAboneTur(rs.getString("aboneTurler"));
                turArrayList.add(t);
            }
        } catch (Exception e) {
        }
        return turArrayList;
    }

    /**
     * Veritabanından tüm tarihleri getirir.
     * @return  Veritabanından alınan tarihlerin bir listesi olan ArrayList
     */
    public ArrayList<AboneTarih> abonelikTarihleriGetir() {
        ArrayList<AboneTarih> tarihArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "abonetarihler");
        try {
            while (rs.next()) {
                AboneTarih t = new AboneTarih();
                t.setId(rs.getInt("id"));
                t.setTarihler(rs.getDate("tarihler"));
                tarihArrayList.add(t);
            }
        } catch (Exception e) {
        }
        return tarihArrayList;
    }

    /**
     * Veritabanından tüm abonelik ücretlerini getirir.
     * @return  Veritabanından alınan ücretlerin bir listesi olan ArrayList
     */
    public ArrayList<Ucret> abonelikUcretleriniGetir() {
        ArrayList<Ucret> ucretArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "aboneucretler");
        try {
            while (rs.next()) {
                Ucret u = new Ucret();
                u.setId(rs.getInt("id"));
                u.setUcretler(rs.getInt("ucretler"));
                ucretArrayList.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ucretArrayList;
    }


    public AboneKayitIslemi() {

        dbAccess = new DbAccess("root", "Zurtex96!", "otoparkdb", 3306);
        dbCrud = new DbCrud(dbAccess.getConnection());

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 950); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("AutoDia OOS Abonelik İşlemleri");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 880, 150, 30);
        last.setFont(new Font("Futura", Font.PLAIN, 14));
        add(last);

        //Optionpane'deki ikon için resize ediyoruz
        int newWidth = 75; // Yeni boyut için genişlik ve yükseklik değerlerini belirleyin
        int newHeight = 75;

        Image image1 = new ImageIcon(AracGirisKayit.class.getResource("/images/greylogo3.png")).getImage(); // Resmi al
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

        JLabel baslik = new JLabel("Abone Kayıt İşlemi", JLabel.CENTER);
        baslik.setForeground(new java.awt.Color(241, 236, 236));
        baslik.setFont(new Font("Futura", Font.PLAIN, 20));

        JPanel newPanel2 = new JPanel();
        newPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel2.setBackground(new java.awt.Color(107, 123, 137));
        newPanel2.setBounds(270, 220, 450, 50);
        newPanel2.add(baslik);
        add(newPanel2);

        JLabel aracBilgisi = new JLabel("Araç Bilgileri");
        aracBilgisi.setForeground(new java.awt.Color(241, 236, 236));
        aracBilgisi.setFont(new Font("Futura", Font.PLAIN, 15));
        aracBilgisi.setBounds(100, 290, 100, 25);
        add(aracBilgisi);

        JLabel arPlaka = new JLabel("Araç Plakası");
        arPlaka.setForeground(new java.awt.Color(241, 236, 236));
        arPlaka.setFont(new Font("Futura", Font.PLAIN, 15));
        arPlaka.setBounds(100, 330, 100, 25);
        add(arPlaka);

        JTextField arPlakaText = new JTextField();
        arPlakaText.setFont(new Font("Futura", Font.PLAIN, 13));
        arPlakaText.setForeground(new java.awt.Color(73, 69, 69));
        arPlakaText.setBackground(new java.awt.Color(211, 218, 225));
        arPlakaText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 236, 236), 2, true));
        arPlakaText.setBounds(255, 330, 170, 25);
        add(arPlakaText);

        JLabel aracMarka = new JLabel("Araç Markası");
        aracMarka.setForeground(new java.awt.Color(241, 236, 236));
        aracMarka.setFont(new Font("Futura", Font.PLAIN, 15));
        aracMarka.setBounds(100, 370, 100, 25);
        add(aracMarka);

        JComboBox aracMarkaCombo = new JComboBox(markalariGetir().toArray());
        aracMarkaCombo.setFont(new Font("Futura", Font.PLAIN, 13));
        aracMarkaCombo.setForeground(new java.awt.Color(73, 69, 69));
        aracMarkaCombo.setBackground(new java.awt.Color(162, 172, 182));
        aracMarkaCombo.setBounds(250, 370, 180, 25);
        aracMarkaCombo.insertItemAt("Araç markasını seçiniz", 0);
        aracMarkaCombo.setSelectedIndex(0);
        add(aracMarkaCombo);

        JLabel aracModel = new JLabel("Araç Modeli");
        aracModel.setForeground(new java.awt.Color(241, 236, 236));
        aracModel.setFont(new Font("Futura", Font.PLAIN, 15));
        aracModel.setBounds(100, 410, 100, 25);
        add(aracModel);

        JTextField aracModelText = new JTextField();
        aracModelText.setFont(new Font("Futura", Font.PLAIN, 13));
        aracModelText.setForeground(new java.awt.Color(73, 69, 69));
        aracModelText.setBackground(new java.awt.Color(211, 218, 225));
        aracModelText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 236, 236), 2, true));
        aracModelText.setBounds(255, 410, 170, 25);
        add(aracModelText);

        JLabel aracYil = new JLabel("Araç Yılı");
        aracYil.setForeground(new java.awt.Color(241, 236, 236));
        aracYil.setFont(new Font("Futura", Font.PLAIN, 15));
        aracYil.setBounds(100, 450, 100, 25);
        add(aracYil);

        JComboBox aracYilCombo = new JComboBox(yillariGetir().toArray());
        aracYilCombo.setFont(new Font("Futura", Font.PLAIN, 13));
        aracYilCombo.setForeground(new java.awt.Color(73, 69, 69));
        aracYilCombo.setBackground(new java.awt.Color(162, 172, 182));
        aracYilCombo.setBounds(250, 450, 180, 25);
        aracYilCombo.insertItemAt("Araç yılını seçiniz", 0);
        aracYilCombo.setSelectedIndex(0);
        add(aracYilCombo);

        JLabel aracTur = new JLabel("Araç Türü");
        aracTur.setForeground(new java.awt.Color(241, 236, 236));
        aracTur.setFont(new Font("Futura", Font.PLAIN, 15));
        aracTur.setBounds(100, 490, 100, 25);
        add(aracTur);

        JComboBox aracTurCombo = new JComboBox(turleriGetir().toArray());
        aracTurCombo.setFont(new Font("Futura", Font.PLAIN, 13));
        aracTurCombo.setForeground(new java.awt.Color(73, 69, 69));
        aracTurCombo.setBackground(new java.awt.Color(162, 172, 182));
        aracTurCombo.setBounds(250, 490, 180, 25);
        aracTurCombo.insertItemAt("Araç türünü seçiniz", 0);
        aracTurCombo.setSelectedIndex(0);
        add(aracTurCombo);

        JLabel aracRenk = new JLabel("Araç Rengi");
        aracRenk.setForeground(new java.awt.Color(241, 236, 236));
        aracRenk.setFont(new Font("Futura", Font.PLAIN, 15));
        aracRenk.setBounds(100, 530, 100, 25);
        add(aracRenk);

        JComboBox aracRenkCombo = new JComboBox(renkleriGetir().toArray());
        aracRenkCombo.setFont(new Font("Futura", Font.PLAIN, 13));
        aracRenkCombo.setForeground(new java.awt.Color(73, 69, 69));
        aracRenkCombo.setBackground(new java.awt.Color(162, 172, 182));
        aracRenkCombo.setBounds(250, 530, 180, 25);
        aracRenkCombo.insertItemAt("Araç rengini seçiniz", 0);
        aracRenkCombo.setSelectedIndex(0);
        add(aracRenkCombo);

        JLabel aboneBilgileri = new JLabel("Abone Bilgileri");
        aboneBilgileri.setForeground(new java.awt.Color(241, 236, 236));
        aboneBilgileri.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneBilgileri.setBounds(550, 290, 150, 25);
        add(aboneBilgileri);

        JLabel aboneAd = new JLabel("Adı");
        aboneAd.setForeground(new java.awt.Color(241, 236, 236));
        aboneAd.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneAd.setBounds(550, 330, 100, 25);
        add(aboneAd);

        JTextField aboneAdText = new JTextField();
        aboneAdText.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneAdText.setForeground(new java.awt.Color(73, 69, 69));
        aboneAdText.setBackground(new java.awt.Color(211, 218, 225));
        aboneAdText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 236, 236), 2, true));
        aboneAdText.setBounds(700, 330, 170, 25);
        add(aboneAdText);

        JLabel aboneSoyad = new JLabel("Soyadı");
        aboneSoyad.setForeground(new java.awt.Color(241, 236, 236));
        aboneSoyad.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneSoyad.setBounds(550, 370, 100, 25);
        add(aboneSoyad);

        JTextField aboneSoyadText = new JTextField();
        aboneSoyadText.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneSoyadText.setForeground(new java.awt.Color(73, 69, 69));
        aboneSoyadText.setBackground(new java.awt.Color(211, 218, 225));
        aboneSoyadText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 236, 236), 2, true));
        aboneSoyadText.setBounds(700, 370, 170, 25);
        add(aboneSoyadText);

        JLabel aboneTelefon = new JLabel("Telefon");
        aboneTelefon.setForeground(new java.awt.Color(241, 236, 236));
        aboneTelefon.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneTelefon.setBounds(550, 410, 100, 25);
        add(aboneTelefon);

        JTextField aboneTelefonText = new JTextField();
        aboneTelefonText.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneTelefonText.setForeground(new java.awt.Color(73, 69, 69));
        aboneTelefonText.setBackground(new java.awt.Color(211, 218, 225));
        aboneTelefonText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 236, 236), 2, true));
        aboneTelefonText.setBounds(700, 410, 170, 25);
        add(aboneTelefonText);

        JLabel aboneEMail = new JLabel("E-Mail");
        aboneEMail.setForeground(new java.awt.Color(241, 236, 236));
        aboneEMail.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneEMail.setBounds(550, 450, 100, 25);
        add(aboneEMail);

        JTextField aboneEMailText = new JTextField();
        aboneEMailText.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneEMailText.setForeground(new java.awt.Color(73, 69, 69));
        aboneEMailText.setBackground(new java.awt.Color(211, 218, 225));
        aboneEMailText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 236, 236), 2, true));
        aboneEMailText.setBounds(700, 450, 170, 25);
        add(aboneEMailText);

        JLabel aboneAdres = new JLabel("Açık Adres");
        aboneAdres.setForeground(new java.awt.Color(241, 236, 236));
        aboneAdres.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneAdres.setBounds(550, 490, 100, 25);
        add(aboneAdres);

        JTextField aboneAdresText = new JTextField();
        aboneAdresText.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneAdresText.setForeground(new java.awt.Color(73, 69, 69));
        aboneAdresText.setBackground(new java.awt.Color(211, 218, 225));
        aboneAdresText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 236, 236), 2, true));
        aboneAdresText.setBounds(700, 490, 170, 25);
        add(aboneAdresText);

        JLabel aboneTur = new JLabel("Abonelik Tipi");
        aboneTur.setForeground(new java.awt.Color(241, 236, 236));
        aboneTur.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneTur.setBounds(550, 530, 100, 25);
        add(aboneTur);

        JComboBox aboneTurCombo = new JComboBox(abonelikTurleriGetir().toArray());
        aboneTurCombo.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneTurCombo.setForeground(new java.awt.Color(73, 69, 69));
        aboneTurCombo.setBackground(new java.awt.Color(211, 218, 225));
        aboneTurCombo.setBounds(697, 530, 180, 25);
        add(aboneTurCombo);

        JLabel aboneBaslangic = new JLabel("Abonelik Başlangıç");
        aboneBaslangic.setForeground(new java.awt.Color(241, 236, 236));
        aboneBaslangic.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneBaslangic.setBounds(550, 570, 150, 25);
        add(aboneBaslangic);

        JComboBox aboneBaslangicCombo = new JComboBox(abonelikTarihleriGetir().toArray());
        aboneBaslangicCombo.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneBaslangicCombo.setForeground(new java.awt.Color(73, 69, 69));
        aboneBaslangicCombo.setBackground(new java.awt.Color(211, 218, 225));
        aboneBaslangicCombo.setBounds(697, 570, 180, 25);
        add(aboneBaslangicCombo);

        JLabel aboneBitis = new JLabel("Abonelik Bitiş");
        aboneBitis.setForeground(new java.awt.Color(241, 236, 236));
        aboneBitis.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneBitis.setBounds(550, 610, 150, 25);
        add(aboneBitis);

        JComboBox aboneBitisCombo = new JComboBox(abonelikTarihleriGetir().toArray());
        aboneBitisCombo.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneBitisCombo.setForeground(new java.awt.Color(73, 69, 69));
        aboneBitisCombo.setBackground(new java.awt.Color(211, 218, 225));
        aboneBitisCombo.setBounds(697, 610, 180, 25);
        add(aboneBitisCombo);

        JLabel aboneUcret = new JLabel("Abonelik Ücreti");
        aboneUcret.setForeground(new java.awt.Color(241, 236, 236));
        aboneUcret.setFont(new Font("Futura", Font.PLAIN, 15));
        aboneUcret.setBounds(550, 650, 150, 25);
        add(aboneUcret);

        JComboBox aboneUcretCombo = new JComboBox(abonelikUcretleriniGetir().toArray());
        aboneUcretCombo.setFont(new Font("Futura", Font.PLAIN, 13));
        aboneUcretCombo.setForeground(new java.awt.Color(73, 69, 69));
        aboneUcretCombo.setBackground(new java.awt.Color(211, 218, 225));
        aboneUcretCombo.setBounds(697, 650, 180, 25);
        add(aboneUcretCombo);

        JPanel ucretPanel = new JPanel();
        ucretPanel.setBounds(700, 690, 170, 35);
        ucretPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ucretPanel.setBackground(new java.awt.Color(222, 80, 80));
        ucretPanel.setForeground(Color.WHITE);

        JCheckBox ucretAlindiCheckBox = new JCheckBox();
        JLabel ucretAlindiLabel = new JLabel("Ücret Tahsil Onayı");
        ucretAlindiLabel.setFont(new Font("Futura", Font.PLAIN, 14));
        ucretPanel.add(ucretAlindiCheckBox);
        ucretPanel.add(ucretAlindiLabel);
        add(ucretPanel);

        ucretAlindiCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*

                //Component JLabel, JTextField, JCombobox gibi tüm bileşenleri içerisinde tutabilen bir sınıftır.
                //Bu sınıfı kullanarak for döngüsü ile kodu daha okunur hale getirdik
                Component[] components = {aboneAdText,aboneSoyadText,aboneTelefonText,aboneAdresText,aboneEMailText,aboneTurCombo,aboneBaslangicCombo,aboneBitisCombo,aboneUcretCombo, arPlakaText,aracModelText,aracMarkaCombo,aracRenkCombo,aracTurCombo,aracYilCombo};

                for (int i = 0; i < components.length; i++) {
                    components[i].setEnabled(!ucretAlindiCheckBox.isSelected());
                }

                if(ucretAlindiCheckBox.isSelected()) {
                    ucretPanel.setBackground(new java.awt.Color(110, 215, 114));
                    ucretAlindiLabel.setText("  Ücret Tahsil Edildi");
                } else {
                    ucretPanel.setBackground(new java.awt.Color(222, 80, 80));
                    ucretAlindiLabel.setText("  Ücret Tahsil Onayı");
                }


                 */

                if (ucretAlindiCheckBox.isSelected()) {
                    ucretPanel.setBackground(new java.awt.Color(110, 215, 114));
                    aboneAdText.setEnabled(false);
                    aboneSoyadText.setEnabled(false);
                    aboneTelefonText.setEnabled(false);
                    aboneEMailText.setEnabled(false);
                    aboneAdresText.setEnabled(false);
                    aboneTurCombo.setEnabled(false);
                    aboneBaslangicCombo.setEnabled(false);
                    aboneBitisCombo.setEnabled(false);
                    aboneUcretCombo.setEnabled(false);
                    arPlakaText.setEnabled(false);
                    aracMarkaCombo.setEnabled(false);
                    aracModelText.setEnabled(false);
                    aracYilCombo.setEnabled(false);
                    aracTurCombo.setEnabled(false);
                    aracRenkCombo.setEnabled(false);
                    ucretAlindiLabel.setText("Ücret Tahsil Edildi");
                } else {
                    ucretPanel.setBackground(new java.awt.Color(222, 80, 80));
                    aboneAdText.setEnabled(true);
                    aboneSoyadText.setEnabled(true);
                    aboneTelefonText.setEnabled(true);
                    aboneEMailText.setEnabled(true);
                    aboneAdresText.setEnabled(true);
                    aboneTurCombo.setEnabled(true);
                    aboneBaslangicCombo.setEnabled(true);
                    aboneBitisCombo.setEnabled(true);
                    aboneUcretCombo.setEnabled(true);
                    arPlakaText.setEnabled(true);
                    aracMarkaCombo.setEnabled(true);
                    aracModelText.setEnabled(true);
                    aracYilCombo.setEnabled(true);
                    aracTurCombo.setEnabled(true);
                    aracRenkCombo.setEnabled(true);
                    ucretAlindiLabel.setText("Ücret Tahsil Onayı");
                }

            }

        });

        JButton btnKaydet = new JButton("Aboneyi Kaydet");
        btnKaydet.setBackground(new java.awt.Color(26, 75, 115));
        btnKaydet.setFont(new Font("Futura", Font.PLAIN, 14));
        btnKaydet.setBounds(685, 750, 200, 100);
        add(btnKaydet);

        btnKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (arPlakaText.getText().isEmpty()
                        || aracMarkaCombo.getSelectedIndex() == -1
                        || aracModelText.getText().isEmpty()
                        || aracYilCombo.getSelectedIndex() == -1
                        || aracTurCombo.getSelectedIndex() == -1
                        || aracRenkCombo.getSelectedIndex() == -1
                        || aboneAdText.getText().isEmpty()
                        || aboneSoyadText.getText().isEmpty()
                        || aboneTelefonText.getText().isEmpty()
                        || aboneEMailText.getText().isEmpty()
                        || aboneAdresText.getText().isEmpty()
                        || aboneTurCombo.getSelectedIndex() == -1
                        || aboneBaslangicCombo.getSelectedIndex() == -1
                        || aboneBitisCombo.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Tüm alanlar doldurulmalıdır.\nBoş alan bırakılamaz!", "Hata", JOptionPane.ERROR_MESSAGE, iconResized);
                    new AboneKayitIslemi().setVisible(true);
                    return;


                }

                if (!ucretAlindiCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Ücret onayı alınmadan kayıt yapılamaz.\nLütfen ücreti tahsilatını onaylayınız!", "Hata", JOptionPane.ERROR_MESSAGE, iconResized);
                    return;
                }


                String sql = "INSERT INTO aboneler (arplaka, armarka_id, armodel, arrenk_id, aryil, artur_id, abad, absoyad, abtel, abadres, abemail, abbaslangic, abbitis, abtur_id, abucret_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try {
                    PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                    ps.setString(1, arPlakaText.getText().toUpperCase().trim());
                    ps.setInt(2, markalariGetir().get((aracMarkaCombo.getSelectedIndex())-1).getId());
                    ps.setString(3, aracModelText.getText().toUpperCase().trim());
                    ps.setInt(4, renkleriGetir().get((aracRenkCombo.getSelectedIndex())-1).getId());
                    ps.setString(5, String.valueOf(yillariGetir().get((aracYilCombo.getSelectedIndex())-1)));
                    ps.setInt(6, turleriGetir().get((aracTurCombo.getSelectedIndex())-1).getId());
                    ps.setString(7, aboneAdText.getText().toUpperCase().trim());
                    ps.setString(8, aboneSoyadText.getText().toUpperCase().trim());
                    ps.setString(9, aboneTelefonText.getText().toUpperCase().trim());
                    ps.setString(10, aboneAdresText.getText().toUpperCase().trim());
                    ps.setString(11, aboneEMailText.getText().toUpperCase().trim());

                    java.util.Date utilDateBaslangic = abonelikTarihleriGetir().get(aboneBaslangicCombo.getSelectedIndex()).getTarihler();
                    java.util.Date utilDateBitis = abonelikTarihleriGetir().get(aboneBitisCombo.getSelectedIndex()).getTarihler();
                    java.sql.Date sqlDateBaslangic = new java.sql.Date(utilDateBaslangic.getTime());
                    java.sql.Date sqlDateBitis = new java.sql.Date(utilDateBitis.getTime());
                    ps.setDate(12, sqlDateBaslangic);
                    ps.setDate(13, sqlDateBitis);
                    ps.setInt(14, abonelikTurleriGetir().get(aboneTurCombo.getSelectedIndex()).getId());
                    ps.setInt(15, abonelikUcretleriniGetir().get(aboneUcretCombo.getSelectedIndex()).getId());

                    int c = ps.executeUpdate();

                    if (c > 0) {
                        JOptionPane.showMessageDialog(null, "Abone bilgileri başarı ile kaydedildi", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);

                    } else {
                        JOptionPane.showMessageDialog(null, "Abone kaydedilemedi!", "Hata", JOptionPane.ERROR_MESSAGE, iconResized);
                    }

                    MainPage mp2 = new MainPage();
                    mp2.setVisible(true);
                    setVisible(false);


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


    }


}
