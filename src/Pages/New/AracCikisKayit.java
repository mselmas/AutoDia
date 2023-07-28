package Pages.New;

import CodeFactory.IconsFactory;
import CodeFactory.QueryFactory;
import CodeFactory.ShadowPanel;
import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AracCikisKayit extends JFrame {

    DbAccess dbAccess;
    DbCrud dbCrud;

    IconsFactory iconsFactory = new IconsFactory();

    QueryFactory qf = new QueryFactory();


    public AracCikisKayit() {

        dbAccess = new DbAccess("root", "Zurtex96!", "otoparkdb", 3306);
        dbCrud = new DbCrud(dbAccess.getConnection());

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 1020); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("AutoDia OOS Araç Çıkış Kayıt Ekranı");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 950, 150, 30);
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

        JLabel baslik = new JLabel("Araç Çıkış Kayıt İşlemleri", JLabel.CENTER);
        baslik.setForeground(new java.awt.Color(241, 236, 236));
        baslik.setFont(new Font("Futura", Font.PLAIN, 20));

        JPanel newPanel2 = new JPanel();
        newPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel2.setBackground(new java.awt.Color(107, 123, 137));
        newPanel2.setBounds(270, 220, 450, 50);
        newPanel2.add(baslik);
        add(newPanel2);

        //Mavi ShadowPanel
        JPanel shadowPanel = new ShadowPanel();
        shadowPanel.setLayout(new GridBagLayout());
        shadowPanel.setBackground(new java.awt.Color(39, 74, 112));
        shadowPanel.setBounds(300, 280, 400, 650);

        JLabel arPlaka = new JLabel("Araç Plakası");
        arPlaka.setForeground(new java.awt.Color(241, 236, 236));
        arPlaka.setFont(new Font("Futura", Font.PLAIN, 14));

        JComboBox arPlakaCombo = new JComboBox(qf.getPlakalar().toArray());
        arPlakaCombo.setPreferredSize(new Dimension(180, 30));
        arPlakaCombo.setFont(new Font("Futura", Font.PLAIN, 14));
        arPlakaCombo.insertItemAt("Lütfen Seçim Yapınız", 0);
        arPlakaCombo.setSelectedIndex(0);

        JLabel arGirisTarihi = new JLabel("Giriş Tarihi");
        arGirisTarihi.setForeground(new java.awt.Color(241, 236, 236));
        arGirisTarihi.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arGirisTarihiText = new JTextField(qf.getGirisTarihiByPlaka(arPlakaCombo.getSelectedItem().toString()));
        arGirisTarihiText.setFont(new Font("Futura", Font.PLAIN, 14));
        arGirisTarihiText.setEnabled(false);
        arGirisTarihiText.setPreferredSize(new Dimension(180, 30));

        JLabel arGirisSaati = new JLabel("Giriş Saati");
        arGirisSaati.setForeground(new java.awt.Color(241, 236, 236));
        arGirisSaati.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arGirisSaatiText = new JTextField(qf.getSaatByPlaka(arPlakaCombo.getSelectedItem().toString()));
        arGirisSaatiText.setFont(new Font("Futura", Font.PLAIN, 14));
        arGirisSaatiText.setEnabled(false);
        arGirisSaatiText.setPreferredSize(new Dimension(180, 30));

        JLabel arCikisSaati = new JLabel("Çıkış Saati");
        arCikisSaati.setForeground(new java.awt.Color(241, 236, 236));
        arCikisSaati.setFont(new Font("Futura", Font.PLAIN, 14));

        JComboBox arCikisSaatiCombo = new JComboBox(qf.getSaatler().toArray());
        arCikisSaatiCombo.setPreferredSize(new Dimension(180, 30));
        arCikisSaatiCombo.setFont(new Font("Futura", Font.PLAIN, 14));
        arCikisSaatiCombo.setPreferredSize(new Dimension(180, 30));
        arCikisSaatiCombo.insertItemAt("Çıkış saatini seçiniz", 0);
        arCikisSaatiCombo.setSelectedIndex(0);

        JLabel arMarka = new JLabel("Araç Markası");
        arMarka.setForeground(new java.awt.Color(241, 236, 236));
        arMarka.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arMarkaText = new JTextField(qf.getMarkaByPlaka(arPlakaCombo.getSelectedItem().toString()));
        arMarkaText.setFont(new Font("Futura", Font.PLAIN, 14));
        arMarkaText.setEnabled(false);
        arMarkaText.setPreferredSize(new Dimension(180, 30));

        JLabel arModel = new JLabel("Araç Modeli");
        arModel.setForeground(new java.awt.Color(241, 236, 236));
        arModel.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arModelText = new JTextField(qf.getModelByPlaka(arPlakaCombo.getSelectedItem().toString()));
        arModelText.setFont(new Font("Futura", Font.PLAIN, 14));
        arModelText.setPreferredSize(new Dimension(180, 30));
        arModelText.setEnabled(false);
        arModelText.setPreferredSize(new Dimension(180, 30));

        JLabel arRenk = new JLabel("Araç Rengi");
        arRenk.setForeground(new java.awt.Color(241, 236, 236));
        arRenk.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arRenkText = new JTextField(qf.getRenkByPlaka(arPlakaCombo.getSelectedItem().toString()));
        arRenkText.setFont(new Font("Futura", Font.PLAIN, 14));
        arRenkText.setEnabled(false);
        arRenkText.setPreferredSize(new Dimension(180, 30));

        JLabel arTur = new JLabel("Araç Türü");
        arTur.setForeground(new java.awt.Color(241, 236, 236));
        arTur.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arTurText = new JTextField(qf.getTurByPlaka(arPlakaCombo.getSelectedItem().toString()));
        arTurText.setFont(new Font("Futura", Font.PLAIN, 14));
        arTurText.setEnabled(false);
        arTurText.setPreferredSize(new Dimension(180, 30));

        JLabel arKonum = new JLabel("Araç Konumu");
        arKonum.setForeground(new java.awt.Color(241, 236, 236));
        arKonum.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arKonumText = new JTextField(qf.getKonumByPlaka(arPlakaCombo.getSelectedItem().toString()));
        arKonumText.setFont(new Font("Futura", Font.PLAIN, 14));
        arKonumText.setEnabled(false);
        arKonumText.setPreferredSize(new Dimension(180, 30));

        JLabel ucret = new JLabel("Ödenecek Ücret");
        ucret.setForeground(new java.awt.Color(241, 236, 236));
        ucret.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField ucretText = new JTextField();
        ucretText.setFont(new Font("Futura", Font.PLAIN, 14));
        ucretText.setEnabled(false);
        ucretText.setPreferredSize(new Dimension(180, 30));

        JCheckBox ucretAlindiCheckBox = new JCheckBox("Ücret Alındı");
        ucretAlindiCheckBox.setFont(new Font("Futura", Font.PLAIN, 14));
        ucretAlindiCheckBox.setForeground(new java.awt.Color(241, 236, 236));

        JButton btnIzinVer = new JButton("Çıkış İzni Ver");
        btnIzinVer.setFont(new Font("Futura", Font.PLAIN, 14));
        btnIzinVer.setPreferredSize(new Dimension(120, 50));

        JButton btnAraciTeslimEt = new JButton("Aracı teslim et");
        btnAraciTeslimEt.setFont(new Font("Futura", Font.PLAIN, 14));
        btnAraciTeslimEt.setPreferredSize(new Dimension(120, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arPlaka, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arPlakaCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arKonum, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arKonumText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arGirisTarihi, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arGirisTarihiText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arGirisSaati, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arGirisSaatiText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arCikisSaati, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arCikisSaatiCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arMarka, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arMarkaText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arModel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arModelText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arRenk, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arRenkText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arTur, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arTurText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(ucret, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(ucretText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(ucretAlindiCheckBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(btnIzinVer, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(btnAraciTeslimEt, gbc);

        add(shadowPanel);

        ucretAlindiCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (ucretAlindiCheckBox.isSelected()) {
                    ucretText.setEnabled(false);
                    ucretAlindiCheckBox.setForeground(new Color(148, 199, 114));
                } else {
                    ucretText.setEnabled(true);
                    ucretAlindiCheckBox.setForeground(new java.awt.Color(241, 236, 236));
                    ucretText.setEnabled(false);

                }
            }
        });


        // Plaka ComboBox'ına ActionListener ekleme
        arPlakaCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Seçilen plaka
                String selectedPlaka = arPlakaCombo.getSelectedItem().toString();

                // Plakaya karşılık gelen konumun alınması
                String konum = qf.getKonumByPlaka(selectedPlaka); // Örnek bir metot
                String saat = qf.getSaatByPlaka(selectedPlaka);
                String marka = qf.getMarkaByPlaka(selectedPlaka);
                String tur = qf.getTurByPlaka(selectedPlaka);
                String renk = qf.getRenkbyPlaka(selectedPlaka);
                String model = qf.getModelByPlaka(selectedPlaka);
                String tarih = qf.getGirisTarihiByPlaka(selectedPlaka);

                // Park yeri JTextField'ına konumu yerleştirme
                arKonumText.setText(konum);
                arGirisSaatiText.setText(saat);
                arMarkaText.setText(marka);
                arTurText.setText(tur);
                arRenkText.setText(renk);
                arModelText.setText(model);
                arGirisTarihiText.setText(tarih);

                //SELECT * FROM aboneler WHERE arplaka = ?
                //Burada plakanın abone listesinde olup olmadığını kontrol etmek istiyoruz. Eğer abone listesinde plaka kayıtlı ise ödeme yapmaya gerek yok.
                String sql = "SELECT arplaka FROM aboneler WHERE arplaka = ?";

                try {

                    PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                    ps.setString(1, selectedPlaka);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Araç AutoDia abonesidir", "Bilgi", JOptionPane.INFORMATION_MESSAGE,iconResized);
                        ucretAlindiCheckBox.setForeground(new Color(148, 199, 114));
                        ucretAlindiCheckBox.setSelected(true);
                        ucretAlindiCheckBox.setEnabled(false);
                        ucretText.setText("0");

                    } else if (!rs.next()) {
                        ucretAlindiCheckBox.setForeground(new Color(241, 236, 236));
                        ucretAlindiCheckBox.setSelected(false);
                        ucretAlindiCheckBox.setEnabled(true);
                        ucretText.setText("");
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }


        });

        arCikisSaatiCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //1 saate kadar 10 TL, 1-3 saate kadar 20, 3-5 saat 40, 5 saat ve üzeri 60 TL olacak.

                String girisSaati = arGirisSaatiText.getText();
                String cikisSaati = arCikisSaatiCombo.getSelectedItem().toString();

                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

                try {
                    Date girisSaati2 = dateFormat.parse(girisSaati);
                    Date cikisSaati2 = dateFormat.parse(cikisSaati);

                    long diffInMilliseconds = cikisSaati2.getTime() - girisSaati2.getTime();
                    long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMilliseconds);

                    int otoparkUcreti = 0;

                    String sql = "SELECT artur_id FROM giriskayit WHERE arplaka = ?";

                    try {
                        PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                        ps.setString(1, arPlakaCombo.getSelectedItem().toString());
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {

                            int artur_id = rs.getInt("artur_id");

                            if (artur_id == 1 || artur_id == 4) {
                                if (diffInMinutes <= 60) {
                                    otoparkUcreti = 10;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 60 && diffInMinutes <= 180) {
                                    otoparkUcreti = 20;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 180 && diffInMinutes <= 300) {
                                    otoparkUcreti = 40;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 300) {
                                    otoparkUcreti = 60;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                }
                                ucretText.setText(String.valueOf(otoparkUcreti));
                                ucretText.setEnabled(false);
                            } else if (artur_id == 2 || artur_id == 3) {
                                if (diffInMinutes <= 60) {
                                    otoparkUcreti = 15;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 60 && diffInMinutes <= 180) {
                                    otoparkUcreti = 25;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 180 && diffInMinutes <= 300) {
                                    otoparkUcreti = 50;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 300) {
                                    otoparkUcreti = 70;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                }
                                ucretText.setText(String.valueOf(otoparkUcreti));
                                ucretText.setEnabled(false);

                            } else if (artur_id == 5) {
                                if (diffInMinutes <= 60) {
                                    otoparkUcreti = 20;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 60 && diffInMinutes <= 180) {
                                    otoparkUcreti = 40;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 180 && diffInMinutes <= 300) {
                                    otoparkUcreti = 80;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                } else if (diffInMinutes > 300) {
                                    otoparkUcreti = 120;
                                    ucretText.setText(String.valueOf(otoparkUcreti));
                                    ucretText.setEnabled(false);
                                }

                            }


                            //Otopark abonesi olanların ücret ödememesi için gerekli kontrol yapılıyor. Eğer abone ise boşuna ücret hesaplanmıyor.
                            String sql2 = "SELECT arplaka FROM aboneler WHERE arplaka = ?";

                            PreparedStatement ps2 = dbCrud.getConnection().prepareStatement(sql2);
                            ps2.setString(1, arPlakaCombo.getSelectedItem().toString());
                            ResultSet rs2 = ps2.executeQuery();

                            if (rs2.next()) {
                                otoparkUcreti = 0;
                                ucretText.setText(String.valueOf(otoparkUcreti));
                                ucretText.setEnabled(false);
                            }

                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                } catch (ParseException e2) {
                    throw new RuntimeException(e2);
                }


                String selectedPlaka = arPlakaCombo.getSelectedItem().toString();
                String selectedCikisSaati = arCikisSaatiCombo.getSelectedItem().toString();

                String query = "UPDATE giriskayit SET cikissaati = '" + selectedCikisSaati + "' WHERE arplaka = '" + selectedPlaka + "'";

                try {
                    PreparedStatement ps = dbCrud.getConnection().prepareStatement(query);
                    int update = ps.executeUpdate(query);

                    if (update > 0) {
                        JOptionPane.showMessageDialog(null, "Araç Çıkış Saati Kaydedildi", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);
                    } else {
                        JOptionPane.showMessageDialog(null, "Araç Çıkış Kayıt Kaydedilemedi", "Hata", JOptionPane.INFORMATION_MESSAGE, iconResized);
                    }

                } catch (SQLException ex2) {

                }


            }
        });


        btnIzinVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (arPlakaCombo.getSelectedIndex() == 0
                        || arKonumText.getText().isEmpty()
                        || arGirisTarihiText.getText().isEmpty()
                        || arGirisSaatiText.getText().isEmpty()
                        || arCikisSaatiCombo.getSelectedIndex() == 0
                        || arMarkaText.getText().isEmpty()
                        || arModelText.getText().isEmpty()
                        || arTurText.getText().isEmpty()
                        || arRenkText.getText().isEmpty()
                        || ucretText.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Tüm alanlar doldurulmalıdır.\nBoş alan bırakılamaz!", "Hata", JOptionPane.INFORMATION_MESSAGE, iconResized);
                    return;
                }


                if (!ucretAlindiCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Ücret Alınmadı.Lütfen ücreti tahsil ediniz!", "Uyarı", JOptionPane.INFORMATION_MESSAGE, iconResized);
                    return;
                }

                String sql = "UPDATE giriskayit SET konum2 = konum_id, konum_id = '', odenecekucret = ? WHERE arplaka = ?";
                String selectedPlaka = arPlakaCombo.getSelectedItem().toString();

                try {
                    PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(ucretText.getText()));
                    ps.setString(2, selectedPlaka);

                    int update = ps.executeUpdate();

                    if (update > 0) {
                        JOptionPane.showMessageDialog(null, "Çıkış izni verildi", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);

                        String sql2 = "INSERT INTO giriscikislar (arplaka, armarka_id, armodel, arrenk_id,artur_id,konum_id,giristarihi, girissaati,cikissaati,odenenucret) SELECT arplaka, armarka_id, armodel, arrenk_id,artur_id,konum2, giristarihi, girissaati,cikissaati,odenecekucret FROM giriskayit WHERE arplaka=?";

                        PreparedStatement ps2 = dbCrud.getConnection().prepareStatement(sql2);
                        ps2.setString(1, selectedPlaka);
                        int update2 = ps2.executeUpdate();

                        String sql3 = "DELETE FROM giriskayit WHERE arplaka=?";
                        PreparedStatement ps3 = dbCrud.getConnection().prepareStatement(sql3);
                        ps3.setString(1, selectedPlaka);
                        int update3 = ps3.executeUpdate();

                        if (update2 > 0 && update3 > 0) {
                            JOptionPane.showMessageDialog(null, "Veritabanı güncellemesi tamamlandı", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);
                        } else {
                            JOptionPane.showMessageDialog(null, "Veritabanı güncellemesi tamamlanamadı.\nLütfen bilgileri kontrol ediniz!!!", "Hata", JOptionPane.INFORMATION_MESSAGE, iconResized);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Çıkış İzni Yok", "Hata", JOptionPane.INFORMATION_MESSAGE, iconResized);
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        btnAraciTeslimEt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "SELECT arplaka FROM giriscikislar WHERE arplaka = ?";

                try {
                    PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                    ps.setString(1, arPlakaCombo.getSelectedItem().toString());
                    ResultSet rs = ps.executeQuery();

                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null, "Araç teslim edilmek üzere getiriliyor", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);
                        MainPage mainPage = new MainPage();
                        mainPage.setVisible(true);
                        setVisible(false);
                    } else if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Lütfen aracın çıkış izni alıp almadığını kontrol ediniz!", "Hata", JOptionPane.INFORMATION_MESSAGE, iconResized);
                    }

                } catch (SQLException ex) {
                    ex.getMessage();
                }

            }
        });


    }

}


