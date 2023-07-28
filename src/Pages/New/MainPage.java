package Pages.New;

import CodeFactory.IconsFactory;
import CodeFactory.ShadowPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    IconsFactory iconsFactory = new IconsFactory();

    public MainPage() {

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 900); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("AutoDia OOS Yetkili Kullanıcı Anasayfa");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Burada back button oluşturmak için IconsFactory içindeki bir metotu çağırdık
        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Giris().setVisible(true);
                dispose();
            }
        };

        JButton backButton = iconsFactory.createBackButton(backListener);
        add(backButton);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 830, 150, 30);
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

        JLabel baslik = new JLabel("Yetkili Kullanıcı İşlemleri", JLabel.CENTER);
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

        JButton btnAbonelikIslemleri = new JButton("Abone Kayıt İşlemi");
        btnAbonelikIslemleri.setPreferredSize(new Dimension(200, 50));
        btnAbonelikIslemleri.setFont(new Font("Futura", Font.PLAIN, 14));
        btnAbonelikIslemleri.setBackground(new java.awt.Color(210, 205, 205));

        JButton btnGirisKayit = new JButton("Araç Giriş Kayıt");
        btnGirisKayit.setPreferredSize(new Dimension(200, 50));
        btnGirisKayit.setFont(new Font("Futura", Font.PLAIN, 14));
        btnGirisKayit.setBackground(new java.awt.Color(210, 205, 205));

        JButton btnCikisKayit = new JButton("Araç Çıkış Kayıt");
        btnCikisKayit.setPreferredSize(new Dimension(200, 50));
        btnCikisKayit.setFont(new Font("Futura", Font.PLAIN, 14));
        btnCikisKayit.setBackground(new java.awt.Color(210, 205, 205));

        JButton btnOtoparkGuncel = new JButton("Otopark Güncel Grafik");
        btnOtoparkGuncel.setPreferredSize(new Dimension(200, 50));
        btnOtoparkGuncel.setFont(new Font("Futura", Font.PLAIN, 14));
        btnOtoparkGuncel.setBackground(new java.awt.Color(210, 205, 205));

        JButton btnTumKayitlariListele = new JButton("Tüm Kayıtları Listele");
        btnTumKayitlariListele.setPreferredSize(new Dimension(200, 50));
        btnTumKayitlariListele.setFont(new Font("Futura", Font.PLAIN, 14));
        btnTumKayitlariListele.setBackground(new java.awt.Color(210, 205, 205));

        JButton btnGuncelKayitlariListele = new JButton("Otopark Güncel Liste");
        btnGuncelKayitlariListele.setPreferredSize(new Dimension(200, 50));
        btnGuncelKayitlariListele.setFont(new Font("Futura", Font.PLAIN, 14));
        btnGuncelKayitlariListele.setBackground(new java.awt.Color(210, 205, 205));

        JButton btnCikis = new JButton("Çıkış");
        btnCikis.setPreferredSize(new Dimension(200, 50));
        btnCikis.setFont(new Font("Futura", Font.PLAIN, 14));
        btnCikis.setBackground(new java.awt.Color(210, 205, 205));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0);
        shadowPanel.add(btnAbonelikIslemleri, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0);
        shadowPanel.add(btnGirisKayit, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0);
        shadowPanel.add(btnCikisKayit, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0);
        shadowPanel.add(btnOtoparkGuncel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0);
        shadowPanel.add(btnGuncelKayitlariListele, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0);
        shadowPanel.add(btnTumKayitlariListele, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(40, 0, 5, 0);
        shadowPanel.add(btnCikis, gbc);

        add(shadowPanel);


        btnAbonelikIslemleri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboneKayitIslemi().setVisible(true);
                setVisible(false);
            }
        });

        btnGirisKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AracGirisKayit aracGirisKayit3 = new AracGirisKayit();
                aracGirisKayit3.setVisible(true);
                setVisible(false);
            }
        });

        btnCikisKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AracCikisKayit aracCikisKayit = new AracCikisKayit();
                aracCikisKayit.setVisible(true);
                setVisible(false);
            }
        });

        btnOtoparkGuncel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OtoparkGuncelGrafik otoparkGuncelGrafik = new OtoparkGuncelGrafik();
                otoparkGuncelGrafik.setVisible(true);
                setVisible(false);

            }
        });

        btnTumKayitlariListele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TumKayitlariListele tumKayitlariListele = new TumKayitlariListele();
                tumKayitlariListele.setVisible(true);
                setVisible(false);
            }
        });

        btnGuncelKayitlariListele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OtoparkGuncelListe otoparkGuncelListe = new OtoparkGuncelListe();
                otoparkGuncelListe.setVisible(true);
                setVisible(false);

            }
        });

        btnCikis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Giris g = new Giris();
                g.setVisible(true);
                setVisible(false);

            }
        });
    }


}
