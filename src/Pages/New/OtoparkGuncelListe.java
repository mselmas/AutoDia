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

public class GuncelKayitlariListele2 extends JFrame {

    DbAccess dbAccess;
    DbCrud dbCrud;

    IconsFactory iconsFactory = new IconsFactory();

    public GuncelKayitlariListele2() {

        dbAccess = new DbAccess("root",
                "Zurtex96!", "otoparkdb", 3306);

        dbCrud = new DbCrud(dbAccess.getConnection());

        getContentPane().setBackground(new java.awt.Color(107, 123, 137));
        setLocation(650, 200); //Sayfanın ekrandaki konumunu gösteriyor
        setLayout(null);
        setSize(1000, 850); //Sayfanın gerçek büyüklüğünü gösteriyor
        setTitle("AutoDia Yetkili Kullanıcı Anasayfa");
        setResizable(false); //ekran boyutunu değiştirmeyi engelliyor
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Burada back button oluşturmak için IconsFactory içindeki bir metotu çağırdık
        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage2().setVisible(true);
                dispose();
            }
        };

        JButton backButton = iconsFactory.createBackButton(backListener);
        add(backButton);


        //Label'i panel oluşturarak ekledik
        JLabel label = new JLabel("AutoDia Otopark Kayıt Sistemi");
        label.setFont(new Font("Futura", Font.PLAIN, 26));
        label.setForeground(new java.awt.Color(241, 236, 236));

        //Logoyu iconsfactory'deki metot ile ürettik - Global'de tanımladık nesneyi ilk önce
        JLabel logo = iconsFactory.createAutoDiaLogo(410, 160, 150, 80);
        add(logo);

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        newPanel.setBackground(new java.awt.Color(107, 123, 137));
        newPanel.setBounds(300, 80, 370, 50);
        newPanel.add(label);
        add(newPanel);


        DefaultTableModel defModel = new DefaultTableModel();
        Object[] colNames = {"DB id", "Plaka", "Marka", "Renk", "Tür", "Konum", "Giriş Saati"};
        Object[] rowData = new Object[7];

        JTable table = new JTable(defModel);
        table.setModel(defModel);
        table.setFont(new Font("Futura", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.setPreferredSize(new Dimension(1000, 500)); //Tablonun tamamının boyutunu ayarladık
        table.setGridColor(new java.awt.Color(94, 163, 224));

        JTableHeader header = table.getTableHeader(); //Tablonun kolon adlarının fontu
        header.setFont(new Font("Futura", Font.PLAIN, 14));

        defModel.setColumnIdentifiers(colNames);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(200, 280, 600, 400); //Tablonun scroll olması için gerekli boyutu verdik.
        scrollPane.setViewportView(table);
        add(scrollPane);

        String sql2 = "SELECT giriskayit.arplaka, konum.konumlar, giriskayit.id, giriskayit.armarka_id, giriskayit.arrenk_id, giriskayit.artur_id, giriskayit.konum_id, giriskayit.girissaati, armarka.markalar, arrenk.renkler, artur.turler FROM giriskayit JOIN konum ON giriskayit.konum_id = konum.id JOIN arrenk ON giriskayit.arrenk_id = arrenk.id JOIN artur ON giriskayit.artur_id = artur.id JOIN armarka ON giriskayit.armarka_id = armarka.id";

        try {
            PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rowData[0] = rs.getString("giriskayit.id");
                rowData[1] = rs.getString("giriskayit.arplaka");
                rowData[2] = rs.getString("armarka.markalar"); // Retrieve from the 'armarka' table
                rowData[3] = rs.getString("arrenk.renkler"); // Retrieve from the 'arrenk' table
                rowData[4] = rs.getString("artur.turler"); // Retrieve from the 'artur' table
                rowData[5] = rs.getString("konum.konumlar"); // Retrieve from the 'konum' table
                rowData[6] = rs.getString("giriskayit.girissaati");

                defModel.addRow(rowData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JPopupMenu popup = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Veriyi Sil");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    String sql = "DELETE FROM giriskayit WHERE id = ?";

                    try {
                        PreparedStatement ps = dbCrud.getConnection().prepareStatement(sql);
                        ps.setString(1, table.getValueAt(selectedRow, 0).toString());
                        ps.executeUpdate();

                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(selectedRow);

                        JOptionPane.showMessageDialog(null, "Kayıt Silindi");

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        throw new RuntimeException(ex);
                    }

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


    public static void main(String[] args) {
        new GuncelKayitlariListele2().setVisible(true);
    }
}
