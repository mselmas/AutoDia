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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TumKayitlariListele extends JFrame {

    DbAccess dbAccess;
    DbCrud dbCrud;

    IconsFactory iconsFactory = new IconsFactory();

    public TumKayitlariListele() {

        dbAccess = new DbAccess("root",
                "Zurtex96!", "otoparkdb", 3306);

        dbCrud = new DbCrud(dbAccess.getConnection());

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 850); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("AutoDia OOS Otopark Giriş-Çıkış Liste Ekranı");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel last = new JLabel("2023 © AutoDia OOS");
        last.setForeground(new java.awt.Color(241, 236, 236));
        last.setBounds(430, 770, 150, 30);
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
                setVisible(false);
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

        JLabel baslik = new JLabel("Tüm Araç Giriş Çıkış Kayıtları Listesi", JLabel.CENTER);
        baslik.setForeground(new java.awt.Color(241, 236, 236));
        baslik.setFont(new Font("Futura", Font.PLAIN, 20));

        JPanel newPanel2 = new JPanel();
        newPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel2.setBackground(new java.awt.Color(107, 123, 137));
        newPanel2.setBounds(270, 220, 450, 50);
        newPanel2.add(baslik);
        add(newPanel2);

        DefaultTableModel defModel = new DefaultTableModel();
        Object[] colNames = {"ID", "Plaka", "Marka", "Model", "Renk", "Tür", "Park Konumu", "Giriş Tarihi", "Giriş Saati", "Çıkış Saati", "Ödenen Ücret"};
        Object[] rowData = new Object[11];

        JTable table = new JTable(defModel);
        table.setModel(defModel);
        table.setFont(new Font("Futura", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.setPreferredSize(new Dimension(1000, 500)); //Tablonun tamamının boyutunu ayarladık
        table.setGridColor(new java.awt.Color(94, 163, 224));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JTableHeader header = table.getTableHeader(); //Tablonun kolon adlarının fontu
        header.setFont(new Font("Futura", Font.PLAIN, 14));

        defModel.setColumnIdentifiers(colNames);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 280, 900, 400); //Tablonun scroll olması için gerekli boyutu verdik.
        scrollPane.setViewportView(table);
        add(scrollPane);

        String sql2 = "SELECT giriscikislar.arplaka, konum.konumlar, giriscikislar.id, giriscikislar.armarka_id, giriscikislar.armodel, giriscikislar.arrenk_id, giriscikislar.artur_id, giriscikislar.konum_id, giriscikislar.giristarihi, giriscikislar.girissaati, giriscikislar.cikissaati, giriscikislar.odenenucret, armarka.markalar, arrenk.renkler, artur.turler FROM giriscikislar JOIN konum ON giriscikislar.konum_id = konum.id JOIN arrenk ON giriscikislar.arrenk_id = arrenk.id JOIN artur ON giriscikislar.artur_id = artur.id JOIN armarka ON giriscikislar.armarka_id = armarka.id";

        try {
            PreparedStatement ps = dbAccess.getConnection().prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                rowData[0] = rs.getString("giriscikislar.id");
                rowData[1] = rs.getString("giriscikislar.arplaka"); //Burada doğrudan tablonun içinden çekiyoruz.
                rowData[2] = rs.getString("armarka.markalar"); //Markanın sayı karşılığını aldığımız için armarka tablosunda çekiyoruz.
                rowData[3] = rs.getString("giriscikislar.armodel");// Retrieve from the 'armarka' table
                rowData[4] = rs.getString("arrenk.renkler"); // Retrieve from the 'arrenk' table
                rowData[5] = rs.getString("artur.turler"); // Retrieve from the 'artur' table
                rowData[6] = rs.getString("konum.konumlar");
                rowData[7] = rs.getString("giriscikislar.giristarihi");// Retrieve from the 'konum' table
                rowData[8] = rs.getString("giriscikislar.girissaati");
                rowData[9] = rs.getString("giriscikislar.cikissaati");
                rowData[10] = rs.getString("giriscikislar.odenenucret");

                defModel.addRow(rowData);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JPopupMenu popup = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Araç Kaydını Sil");

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] secenekler = {"Evet", "Hayır"}; //YES NO yerine özelleştirmek için önce seçenekleri bir diziye attık, ve option pane içine yerleştirdik.
                int result = JOptionPane.showOptionDialog(null, "Araç kaydını silmek istediğinizden emin misiniz?\nBu işlem geri alınamaz!", "Onay",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, iconResized, secenekler, 1);

                if (result == JOptionPane.YES_OPTION) {
                    // Evet seçeneği seçildiğinde yapılacak işlemler burada yer alır
                    int selectedRow = table.getSelectedRow();

                    if (selectedRow != -1) {
                        String sql = "DELETE FROM giriscikislar WHERE id = ?";

                        try {
                            PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                            ps.setString(1, table.getValueAt(selectedRow, 0).toString());
                            ps.executeUpdate();

                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.removeRow(selectedRow);

                            JOptionPane.showMessageDialog(null, "Kayıt Silindi", "Bilgi", JOptionPane.INFORMATION_MESSAGE, iconResized);

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            throw new RuntimeException(ex);
                        }

                    }
                } else if (result == JOptionPane.NO_OPTION) {
                    return;
                }



            }
        });
        popup.add(menuItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popup.show(table, e.getX(), e.getY());
                }
            }
        });


    }

}
