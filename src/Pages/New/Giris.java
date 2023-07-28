package Pages;

import CodeFactory.BackgroundPanel;
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

    public Giris() {

        dbAccess = new DbAccess("root",
                "Zurtex96!", "otoparkdb", 3306);

        dbCrud = new DbCrud(dbAccess.getConnection());

        /*
        ImageIcon imageIcon = new ImageIcon("/Users/msalih/Desktop/Developer/aribilgi_java/AutoDia/src/images/gradient.png");
        Image image2 = imageIcon.getImage();

        BackgroundPanel backgroundPanel = new BackgroundPanel(image2,2);
        backgroundPanel.getPreferredSize();
        add(backgroundPanel);
        --------
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Arka plan resmini yükleyin
                ImageIcon imageIcon = new ImageIcon("/Users/msalih/Desktop/Developer/aribilgi_java/AutoDia/src/images/gradient.png");
                Image image = imageIcon.getImage();
                // Resmi tüm panel boyutuna ölçekleyin ve çizin
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundPanel);

         */

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 750); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("Yetkili Kullanıcı Girişi");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Label'i panel oluşturarak ekledik
        JLabel label = new JLabel("AutoDia Otopark Kayıt Sistemi");
        label.setFont(new Font("Futura", Font.PLAIN, 26));
        label.setForeground(new java.awt.Color(241, 236, 236));

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel.setBackground(new java.awt.Color(107, 123, 137));
        newPanel.setBounds(310, 80, 370, 50);
        newPanel.add(label);
        add(newPanel);

        Image image1 = new ImageIcon(Giris.class.getResource("/images/greylogo3.png")).getImage(); // Resmi al
        JLabel icon = new JLabel(new ImageIcon(image1));
        icon.setBounds(420, 160, 150, 80);
        add(icon);

        //Optionpane'deki ikon için resize ediyoruz
        int newWidth = 75; // Yeni boyut için genişlik ve yükseklik değerlerini belirleyin
        int newHeight = 75;

        Image newImage = image1.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH); // Resmi yeni boyutla yeniden ölçeklendirin
        ImageIcon iconResized = new ImageIcon(newImage); // Yeniden boyutlandırılmış resmi kullanarak yeni bir ImageIcon oluştur

        JPanel panel = new ShadowPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(39, 74, 112));
        panel.setBounds(320, 290, 350, 250);

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


        /*
        JLabel label1 = new JLabel("Kullanıcı Adınız");
        label1.setFont(new Font("Futura", Font.PLAIN, 14));
        label1.setBounds(253, 200, 150, 30);
        add(label1);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(248, 221, 180, 30);
        usernameField.setForeground(new java.awt.Color(0, 0, 0));
        add(usernameField);

        JLabel label2 = new JLabel("Şifreniz");
        label2.setFont(new Font("Futura", Font.PLAIN, 14));
        label2.setBounds(253, 250, 150, 30);
        add(label2);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(248, 271, 180, 30);
        passwordField.setForeground(new java.awt.Color(0, 0, 0));
        add(passwordField);

        JButton btngiris = new JButton("GİRİŞ");
        btngiris.setBounds(248, 320, 180, 80);
        btngiris.setBackground(Color.GRAY);
        btngiris.setForeground(new java.awt.Color(0, 0, 0));
        add(btngiris);



         */

        /*
//Herhangi bir icon ya da resim eklemek için
        JLabel background = new JLabel(new ImageIcon("/Users/msalih/Desktop/Developer/aribilgi_java/AutoDia/misc/autodiadark.png"));
        background.setBounds(500, 0, 1000, 750);
        getContentPane().add(background);

         */

        /*
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.setBounds(20,250,300,220);
        panel2.setBackground(new java.awt.Color(77, 87, 164));
        add(panel2);

        JButton b1 = new JButton("Kayıt Ol");
        b1.setBackground(Color.GRAY);
        JButton b2 = new JButton("Giriş");
        b2.setBackground(Color.GRAY);
        JButton b3 = new JButton("Çıkış");
        b3.setBackground(Color.GRAY);
        JButton b4 = new JButton("Yenile");
        b4.setBackground(Color.GRAY);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        panel2.add(b4);


         */


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

        JLabel last = new JLabel("2023 © AutoDia");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(450, 680, 150, 30);
        last.setFont(new Font("Futura", Font.PLAIN, 14));
        add(last);


        usernameField.setText("msalih");
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
                        //dispose();
                        new MainPage2().setVisible(true); //Yeni üretilen sayfanın görünmesini
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
