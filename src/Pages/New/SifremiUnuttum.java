package Pages;

import CodeFactory.IconsFactory;
import CodeFactory.ShadowPanel;
import Pages.New.Giris;
import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SifremiUnuttum extends JFrame {

    DbAccess dbAccess;
    DbCrud dbCrud;

    IconsFactory iconsFactory = new IconsFactory();


    public SifremiUnuttum() {


        dbAccess = new DbAccess(
                "root",
                "Zurtex96!",
                "otoparkdb",
                3306
        );
        dbCrud = new DbCrud(dbAccess.getConnection());

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 750); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("AutoDia Yetkili Kullanıcı Anasayfa");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Giris g = new Giris();
                g.setVisible(true);
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

        JLabel baslik = new JLabel("Şifre Güncelleme", JLabel.CENTER);
        baslik.setForeground(new java.awt.Color(241, 236, 236));
        baslik.setFont(new Font("Futura", Font.PLAIN, 20));

        JPanel newPanel2 = new JPanel();
        newPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel2.setBackground(new java.awt.Color(107, 123, 137));
        newPanel2.setBounds(270, 220, 450, 50);
        newPanel2.add(baslik);
        add(newPanel2);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 680, 150, 30);
        last.setFont(new Font("Futura", Font.PLAIN, 14));
        add(last);

        String text = "Kullanıcı adı ya da email adresinizden herhangi biri veritabanında \nkayıtlı ise şifreniz email adresinize gönderilecektir.";

        JTextArea textArea = new JTextArea(text);
        textArea.setBounds(280, 290, 450, 50);
        textArea.setFont(new java.awt.Font("Futura", 1, 12));
        textArea.setBackground(new java.awt.Color(107, 123, 137));
        textArea.setForeground(new java.awt.Color(253, 253, 253));
        add(textArea);

        JPanel shadowPanel = new ShadowPanel();
        shadowPanel.setLayout(new GridBagLayout());
        shadowPanel.setBackground(new java.awt.Color(39, 74, 112));
        shadowPanel.setBounds(320, 360, 350, 250);

        JLabel usernameLabel = new JLabel("Kullanıcı adınız");
        usernameLabel.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        usernameLabel.setForeground(new java.awt.Color(241, 236, 236));

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Futura", Font.PLAIN, 14));
        usernameField.setPreferredSize(new Dimension(180, 30));

        JLabel emailLabel = new JLabel("Email adresiniz");
        emailLabel.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        emailLabel.setForeground(new java.awt.Color(241, 236, 236));

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Futura", Font.PLAIN, 14));
        emailField.setPreferredSize(new Dimension(180, 30));

        JButton bilgileriGonder = new JButton("Bilgileri Gönder");
        bilgileriGonder.setFont(new java.awt.Font("Futura", Font.PLAIN, 14));
        bilgileriGonder.setBackground(new java.awt.Color(241, 236, 236));
        bilgileriGonder.setPreferredSize(new Dimension(120, 50));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 5, 0);
        shadowPanel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 5, 0);
        shadowPanel.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(15, 0, 5, 0);
        shadowPanel.add(emailLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 30, 5, 0);
        shadowPanel.add(emailField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(15, 0, 5, 0);
        shadowPanel.add(bilgileriGonder, constraints);

        add(shadowPanel);


        bilgileriGonder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "SELECT username, email FROM yetkili WHERE username = ? OR email = ?";

                try {
                    PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                    ps.setString(1, usernameField.getText().trim());
                    ps.setString(2, emailField.getText().trim());
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        String usernameFromDB = rs.getString("username");
                        String emailFromDB = rs.getString("email");

                        if (usernameFromDB.equals(usernameField.getText().trim()) || emailFromDB.equals(emailField.getText().trim())) {
                            JOptionPane.showMessageDialog(null, "Şifre sıfırlama linki veritabanında kayıtlı email adresinize gönderilmiştir", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Kullanıcı adı veya email adresi veritabanında kayıtlı değil!", "Hata", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                }

                usernameField.setText("");
                emailField.setText("");

                // Sayfayı yenile
                SwingUtilities.updateComponentTreeUI(SifremiUnuttum.this);

            }
        });


    }

    public static void main(String[] args) {
        SifremiUnuttum sifremiUnuttum = new SifremiUnuttum();
        sifremiUnuttum.setVisible(true);

    }

}
