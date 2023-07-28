package Pages.New;

import CodeFactory.IconsFactory;
import CodeFactory.ShadowPanel;
import com.aribilgi.java.Database.DbAccess;
import com.aribilgi.java.Database.DbCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Giris extends JFrame {

    DbAccess dbAccess;
    DbCrud dbCrud;

    IconsFactory iconsFactory = new IconsFactory();
    public Giris() {

        dbAccess = new DbAccess("root",
                "Zurtex96!", "otoparkdb", 3306);

        dbCrud = new DbCrud(dbAccess.getConnection());

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 750); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("AutoDia OOS Yetkili Kullanıcı Giriş Sorgu Ekranı");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Label'i panel oluşturarak ekledik
        JLabel label = new JLabel("AutoDia Otopark Otomasyon Sistemi", JLabel.CENTER);
        label.setFont(new Font("Futura", Font.PLAIN, 26));
        label.setForeground(new java.awt.Color(241, 236, 236));

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel.setBackground(new java.awt.Color(107, 123, 137));
        newPanel.setBounds(280, 95, 450, 50);
        newPanel.add(label);
        add(newPanel);

        JLabel logo = iconsFactory.createAutoDiaLogo(400, 160, 200, 80);
        add(logo);

        JLabel ykGiris = new JLabel("Yetkili Kullanıcı Girişi", JLabel.CENTER);
        ykGiris.setForeground(new java.awt.Color(241, 236, 236));
        ykGiris.setFont(new Font("Futura", Font.PLAIN, 20));

        JPanel newPanel2 = new JPanel();
        newPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel2.setBackground(new java.awt.Color(107, 123, 137));
        newPanel2.setBounds(270, 280, 450, 50);
        newPanel2.add(ykGiris);
        add(newPanel2);

        //Optionpane'deki ikon için resize ediyoruz
        int newWidth = 75; // Yeni boyut için genişlik ve yükseklik değerlerini belirledik
        int newHeight = 75;

        Image image1 = new ImageIcon(Giris.class.getResource("/images/greylogo3.png")).getImage(); // Resmi al
        Image newImage = image1.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH); // Resmi yeni boyutla yeniden ölçeklendirin
        ImageIcon iconResized = new ImageIcon(newImage); // Yeniden boyutlandırılmış resmi kullanarak yeni bir ImageIcon oluştur

        JPanel panel = new ShadowPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(39, 74, 112));
        panel.setBounds(320, 330, 350, 250);

        JLabel usernameLabel = new JLabel("Kullanıcı Adınız");
        usernameLabel.setForeground(new java.awt.Color(241, 236, 236));
        usernameLabel.setFont(new Font("Futura", Font.PLAIN, 14));

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(180, 40));

        JLabel passwordLabel = new JLabel("Şifreniz");
        passwordLabel.setForeground(new java.awt.Color(241, 236, 236));
        passwordLabel.setFont(new Font("Futura", Font.PLAIN, 14));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(180, 40));

        JLabel forgotPassword = new JLabel("Şifremi unuttum");
        forgotPassword.setFont(new Font("Futura", Font.PLAIN, 14));
        forgotPassword.setForeground(new java.awt.Color(232, 226, 226));
        forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(forgotPassword);

        JButton btngiris = new JButton("GİRİŞ");
        btngiris.setPreferredSize(new Dimension(120, 50));
        btngiris.setFont(new Font("Futura", Font.PLAIN, 12));
        btngiris.setBackground(new java.awt.Color(210, 205, 205));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 0, 0, 0);
        panel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 20, 0, 0);
        panel.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(5, 0, 0, 0);
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(5, 20, 0, 0);
        panel.add(passwordField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(10, 0, 0, 0);
        panel.add(btngiris, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(10, 0, 0, 0);
        panel.add(forgotPassword, constraints);

        add(panel);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 680, 150, 30);
        last.setFont(new Font("Futura", Font.PLAIN, 14));
        add(last);

        usernameField.setText("sgungor");
        usernameField.setFont(new Font("Futura", Font.PLAIN, 14));
        passwordField.setText("1234");
        passwordField.setFont(new Font("Futura", Font.PLAIN, 14));

        btngiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                String sql = "SELECT * FROM yetkili WHERE username = ? AND password = ?";

                try {
                    PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ResultSet c = ps.executeQuery();

                    if (c.next()) {

                        int delay = 1000; // 1 saniye
                        Timer timer = new Timer(delay, e2 -> {
                            JOptionPane.getRootFrame().dispose(); // İletişim kutusunu kapat
                        });
                        timer.setRepeats(false); // Tek seferlik çalışmasını sağla
                        timer.start();

                        JOptionPane.showMessageDialog(null, "Giriş Başarılı", "Hoşgeldiniz", JOptionPane.INFORMATION_MESSAGE, iconResized);
                        new MainPage().setVisible(true); //Yeni üretilen sayfanın görünmesini
                        setVisible(false);

                    } else {
                        int delay = 3000;
                        Timer timer = new Timer(delay, e3 -> {
                            JOptionPane.getRootFrame().dispose(); // İletişim kutusunu kapat
                        });
                        timer.setRepeats(false); // Tek seferlik çalışmasını sağla
                        timer.start();
                        JOptionPane.showMessageDialog(null, "Kullanıcı Adı ya da Şifre Hatalı!", "Hatalı Giriş", JOptionPane.INFORMATION_MESSAGE, iconResized);

                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                usernameField.setText("");
                passwordField.setText("");

                // Sayfayı yenile
                SwingUtilities.updateComponentTreeUI(Giris.this);


            }
        });


        forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SifremiUnuttum s = new SifremiUnuttum();
                s.setVisible(true);
            }


        });


    }

    public static void main(String[] args) {
        Giris form = new Giris(); //Giriş sayfanına girişi temsil ediyor
        form.setVisible(true);

    }
}
