package Pages.New;

import CodeFactory.IconsFactory;
import CodeFactory.QueryFactory;
import CodeFactory.ShadowPanel;
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

public class AracGirisKayit extends JFrame {

    DbAccess dbAccess;
    DbCrud dbCrud;
    IconsFactory ic = new IconsFactory();
    QueryFactory q = new QueryFactory();

    /**
     * Veritabanından tüm markaları getirir.
     * @return  Veritabanından alınan markaların bir listesi olan ArrayList
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
     * @return  Veritabanından alınan araç türlerin bir listesi olan ArrayList
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
     * @return  Veritabanından alınan renklerin bir listesi olan ArrayList
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
     * @return  Veritabanından alınan yılların bir listesi olan ArrayList
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
     * Veritabanından tüm park konumlarını getirir.
     * @return      Veritabanından alınan park konumlarının bir listesi olan ArrayList
     */
    public ArrayList<Konum> konumlariGetir() {

        ArrayList<Konum> konumArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "konum");

        try {
            while (rs.next()) {
                Konum k = new Konum();
                k.setId(rs.getInt("id"));
                k.setKonum(rs.getString("konumlar"));
                konumArrayList.add(k);
            }
        } catch (Exception e) {
        }
        return konumArrayList;

    }

    /**
     * Veritabanından tüm saatleri getirir.
     * @return      Veritabanından alınan saatlerin bir listesi olan ArrayList
     */
    public ArrayList<Saat> saatleriGetir() {
        ArrayList<Saat> saatArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("*", "girissaati2");

        try {
            while (rs.next()) {
                Saat s = new Saat();
                s.setId(rs.getInt("id"));
                s.setGirissaati(rs.getTime("girissaati"));
                saatArrayList.add(s);
            }
        } catch (Exception e) {
        }
        return saatArrayList;
    }

    /**
     * Veritabanından tüm tarihleri getirir.
     * @return      Veritabanından alınan tarihlerin bir listesi olan ArrayList
     */
    public ArrayList<AboneTarih> tarihleriGetir() {

        ArrayList<AboneTarih> tarihArrayList = new ArrayList<>();
        ResultSet rs = dbCrud.getSelectResult("tarihler", "abonetarihler");

        try {
            while (rs.next()) {
                AboneTarih tarih = new AboneTarih();
                tarih.setTarihler(rs.getDate("tarihler"));
                tarihArrayList.add(tarih);
            }
        } catch (Exception e) {
        }
        return tarihArrayList;

    }

    public AracGirisKayit() {

        dbAccess = new DbAccess("root", "Zurtex96!", "otoparkdb", 3306);
        dbCrud = new DbCrud(dbAccess.getConnection());

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200);
        setLayout(null);
        setSize(1000, 900);
        setTitle("AutoDia OOS Araç Giriş Kayıt Ekranı");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        JButton backButton = ic.createBackButton(backListener);
        add(backButton);

        //Logoyu iconsfactory'deki metot ile ürettik - Global'de tanımladık nesneyi ilk önce
        JLabel logo = ic.createAutoDiaLogo(400, 110, 200, 80);
        add(logo);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 830, 150, 30);
        last.setFont(new Font("Futura", Font.PLAIN, 14));
        add(last);

        //Label'i panel oluşturarak ekledik
        JLabel label = new JLabel("AutoDia Otopark Otomasyon Sistemi", JLabel.CENTER);
        label.setFont(new Font("Futura", Font.PLAIN, 26));
        label.setForeground(new java.awt.Color(241, 236, 236));

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel.setBackground(new java.awt.Color(107, 123, 137));
        newPanel.setBounds(280, 40, 450, 50);
        newPanel.add(label);
        add(newPanel);

        JLabel baslik = new JLabel("Araç Giriş Kayıt", JLabel.CENTER);
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
        shadowPanel.setBounds(300, 280, 400, 500);

        JLabel arPlaka = new JLabel("Araç Plakası");
        arPlaka.setForeground(new java.awt.Color(241, 236, 236));
        arPlaka.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arPlakaText = new JTextField();
        arPlakaText.setPreferredSize(new Dimension(180, 30));
        arPlakaText.setFont(new Font("Futura", Font.PLAIN, 14));

        JButton aboneKontrol = new JButton("Abone Kontrol");
        aboneKontrol.setFont(new Font("Futura", Font.PLAIN, 12));
        aboneKontrol.setBackground(new java.awt.Color(39, 74, 112));

        JLabel arMarka = new JLabel("Araç Markası");
        arMarka.setForeground(new java.awt.Color(241, 236, 236));
        arMarka.setFont(new Font("Futura", Font.PLAIN, 14));

        JComboBox arMarkaCombo = new JComboBox(markalariGetir().toArray());
        arMarkaCombo.setPreferredSize(new Dimension(180, 30));
        arMarkaCombo.setFont(new Font("Futura", Font.PLAIN, 14));
        arMarkaCombo.insertItemAt("Marka seçiniz", 0);
        arMarkaCombo.setSelectedIndex(0);

        JLabel arModel = new JLabel("Araç Modeli");
        arModel.setForeground(new java.awt.Color(241, 236, 236));
        arModel.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField arModelText = new JTextField();
        arModelText.setPreferredSize(new Dimension(180, 30));
        arModelText.setFont(new Font("Futura", Font.PLAIN, 14));

        JLabel arTur = new JLabel("Araç Türü");
        arTur.setForeground(new java.awt.Color(241, 236, 236));
        arTur.setFont(new Font("Futura", Font.PLAIN, 14));

        JComboBox arTurCombo = new JComboBox(turleriGetir().toArray());
        arTurCombo.setPreferredSize(new Dimension(180, 30));
        arTurCombo.setFont(new Font("Futura", Font.PLAIN, 14));
        arTurCombo.insertItemAt("Tür seçiniz", 0);
        arTurCombo.setSelectedIndex(0);

        JLabel arRenk = new JLabel("Araç Rengi");
        arRenk.setForeground(new java.awt.Color(241, 236, 236));
        arRenk.setFont(new Font("Futura", Font.PLAIN, 14));

        JComboBox arRenkCombo = new JComboBox(renkleriGetir().toArray());
        arRenkCombo.setPreferredSize(new Dimension(180, 30));
        arRenkCombo.setFont(new Font("Futura", Font.PLAIN, 14));
        arRenkCombo.insertItemAt("Renk seçiniz", 0);
        arRenkCombo.setSelectedIndex(0);

        JLabel arKonum = new JLabel("Araç Konumu");
        arKonum.setForeground(new java.awt.Color(241, 236, 236));
        arKonum.setFont(new Font("Futura", Font.PLAIN, 14));

        JComboBox arKonumCombo = new JComboBox(konumlariGetir().toArray());
        arKonumCombo.setPreferredSize(new Dimension(180, 30));
        arKonumCombo.setFont(new Font("Futura", Font.PLAIN, 14));
        arKonumCombo.insertItemAt("Konum seçiniz", 0);
        arKonumCombo.setSelectedIndex(0);

        JLabel arGirissaati = new JLabel("Giriş Saati");
        arGirissaati.setForeground(new java.awt.Color(241, 236, 236));
        arGirissaati.setFont(new Font("Futura", Font.PLAIN, 14));

        JComboBox arGirissaatiCombo = new JComboBox(saatleriGetir().toArray());
        arGirissaatiCombo.setPreferredSize(new Dimension(180, 30));
        arGirissaatiCombo.setFont(new Font("Futura", Font.PLAIN, 14));
        arGirissaatiCombo.insertItemAt("Saati seçiniz", 0);
        arGirissaatiCombo.setSelectedIndex(0);

        JButton btnKaydet = new JButton("Kaydet");
        btnKaydet.setBackground(new java.awt.Color(39, 74, 112));
        btnKaydet.setFont(new Font("Futura", Font.PLAIN, 14));
        btnKaydet.setPreferredSize(new Dimension(120, 50));

        JLabel arGirisTarihi = new JLabel("Giriş Tarihi");
        arGirisTarihi.setForeground(new java.awt.Color(241, 236, 236));
        arGirisTarihi.setFont(new Font("Futura", Font.PLAIN, 14));

        JComboBox arGirisTarihiCombo = new JComboBox(tarihleriGetir().toArray());
        arGirisTarihiCombo.setPreferredSize(new Dimension(180, 30));
        arGirisTarihiCombo.setFont(new Font("Futura", Font.PLAIN, 14));
        arGirisTarihiCombo.insertItemAt("Tarihi seçiniz", 0);
        arGirisTarihiCombo.setSelectedIndex(0);


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arPlaka, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arPlakaText, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 0);
        shadowPanel.add(aboneKontrol, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arMarka, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arMarkaCombo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arModel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arModelText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arTur, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arTurCombo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arRenk, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arRenkCombo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arKonum, constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arKonumCombo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arGirisTarihi, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arGirisTarihiCombo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(arGirissaati, constraints);

        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 0, 0);
        shadowPanel.add(arGirissaatiCombo, constraints);

        constraints.gridx = 1;
        constraints.gridy = 9;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        constraints.insets = new Insets(15, 0, 0, 0);
        shadowPanel.add(btnKaydet, constraints);

        /*
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 0, 0);
        panel.add(aboneKontrol, constraints);

         */

        add(shadowPanel);

        aboneKontrol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Burada plakanın abone olup olmadığı kontrol ediliyor.
                String sql = "SELECT arplaka FROM aboneler WHERE arplaka = ?";

                try {
                    PreparedStatement statement = dbCrud.getConnection().prepareStatement(sql);
                    statement.setString(1, arPlakaText.getText());
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "Abone kaydı bulundu", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);

                        //Burada plakanın abone olup olmadığı kontrol edildikten sonra QueryFactory sınıfındaki metotları kullanarak alttaki gerekli textField'lara atama yapıyoruz.
                        //Aracın adının değil de markanın indeks numarasına göre atama yapıyoruz setSelectedIndex diyerek.
                        //Combobox olduğu için textfield'daki gibi string bir metot ile doldurma yapamadık, onun için integer indeks numarasın
                        //dönen bir metot ile doldurma işlemi yaptı


                        String abonePlaka = arPlakaText.getText().trim().toUpperCase();
                        int abMarkaID = q.getMarkaByAbonePlaka(abonePlaka);
                        int abRenkID = q.getRenkByAbonePlaka(abonePlaka); //Metotda burası string, çünkü araç plakasını string olarak alıyoruz
                        String abModel = q.getModelByAbonePlaka(abonePlaka);
                        int abTurID = q.getTurByAbonePlaka(abonePlaka);

                        arMarkaCombo.setSelectedIndex(abMarkaID);
                        arMarkaCombo.setEnabled(false);
                        arRenkCombo.setSelectedIndex(abRenkID);
                        arRenkCombo.setEnabled(false);
                        arModelText.setText(abModel);
                        arModelText.setEnabled(false);
                        arTurCombo.setSelectedIndex(abTurID);
                        arTurCombo.setEnabled(false);



                    } else if (!resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "Abone kaydı bulunamadı", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);
                        arMarkaCombo.setEnabled(true);
                        arMarkaCombo.setSelectedIndex(0);
                        arRenkCombo.setEnabled(true);
                        arRenkCombo.setSelectedIndex(0);
                        arModelText.setEnabled(true);
                        arModelText.setText("");
                        arTurCombo.setEnabled(true);
                        arTurCombo.setSelectedIndex(0);


                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }

        });


        btnKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if (arPlakaText.getText().isEmpty()
                            || arMarkaCombo.getSelectedIndex() == 0 //0. indeks seçim yapınız olarak eklediğimiz itemleri temsil ediyor, yoksa normalde -1 olması gerekiyordu.
                            || arModelText.getText().isEmpty()
                            || arTurCombo.getSelectedIndex() == 0
                            || arRenkCombo.getSelectedIndex() == 0
                            || arKonumCombo.getSelectedIndex() == 0
                            || arGirissaatiCombo.getSelectedIndex() == 0
                            || arGirisTarihiCombo.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Tüm alanlar doldurulmalıdır.\nBoş alan bırakılamaz!", "Hata", JOptionPane.INFORMATION_MESSAGE, iconResized);
                        return;
                    }

                    String sql = "SELECT konum_id FROM giriskayit WHERE konum_id = ?";

                    PreparedStatement ps1 = dbCrud.getConnection().prepareStatement(sql);
                    ps1.setInt(1, konumlariGetir().get((arKonumCombo.getSelectedIndex()) - 1).getId());
                    ResultSet rs = ps1.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Araç Konumu Dolu!", "Hata", JOptionPane.INFORMATION_MESSAGE, iconResized);
                        return;
                    }

                    //getSelectedIndex() no'sunu -1 çıkardık çünkü "Lütfen tür seçiniz" diyerek onu 0. indekse atadığımızda, tüm seçeneklerin de indeksleri kaymış oldu.
                    PreparedStatement ps = dbCrud.getConnection().prepareStatement("INSERT INTO giriskayit (arplaka, armarka_id, armodel, artur_id, arrenk_id, konum_id, girissaati, giristarihi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    ps.setString(1, arPlakaText.getText().toUpperCase().trim());
                    ps.setInt(2, markalariGetir().get((arMarkaCombo.getSelectedIndex()) - 1).getId());
                    ps.setString(3, arModelText.getText().toUpperCase().trim());
                    ps.setInt(4, turleriGetir().get((arTurCombo.getSelectedIndex()) - 1).getId());
                    ps.setInt(5, renkleriGetir().get((arRenkCombo.getSelectedIndex()) - 1).getId());
                    ps.setInt(6, konumlariGetir().get((arKonumCombo.getSelectedIndex()) - 1).getId());
                    ps.setTime(7, saatleriGetir().get((arGirissaatiCombo.getSelectedIndex() - 1)).getGirissaati());
                    ps.setDate(8, tarihleriGetir().get((arGirisTarihiCombo.getSelectedIndex() - 1)).getTarihler());

                    int c = ps.executeUpdate();

                    if (c > 0) {
                        JOptionPane.showMessageDialog(null, "Araç Kaydı Tamamlandı", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);
                    } else {
                        JOptionPane.showMessageDialog(null, "Araç Kaydı Yapılamadı!", "Hata", JOptionPane.INFORMATION_MESSAGE, iconResized);
                    }

                    MainPage m = new MainPage();
                    m.setVisible(true);
                    setVisible(false);


                } catch (Exception ex) {

                }

            }
        });

    }


}
