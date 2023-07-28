package CodeFactory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class IconsFactory {
    /**
     * Geri düğmesi oluşturur.
     * @param listener Geri düğmesine eklenecek ActionListener
     * @return Oluşturulan geri düğmesi
     */
    public static JButton createBackButton(ActionListener listener) {

        ImageIcon icon = new ImageIcon("/Users/msalih/Desktop/Developer/aribilgi_java/AutoDia/misc/back.png");
        Image image = icon.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        JButton backButton = new JButton(scaledIcon);
        backButton.setBounds(20, 35, 60, 60);
        backButton.setContentAreaFilled(false);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());

        backButton.addActionListener(listener);

        return backButton;

    }

    /**
     * AutoDia logosunu oluşturur.
     * @param x      Logo etiketinin X koordinatı
     * @param y      Logo etiketinin Y koordinatı
     * @param width  Logo etiketinin genişliği
     * @param height Logo etiketinin yüksekliği
     * @return Oluşturulan logo etiketi
     */
    public JLabel createAutoDiaLogo(int x, int y, int width, int height) {
        Image icon = new ImageIcon(IconsFactory.class.getResource("/images/greylogo3.png")).getImage();
        ImageIcon scaledIcon = new ImageIcon(icon);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(x, y, width, height);
        return label;
    }


}
