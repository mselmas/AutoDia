package CodeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * UI'de kenarları gölgelendirilmiş gölge efekti eklemek için üretilen özel bir JPanel alt sınıfıdır.
 */
public class ShadowPanel extends JPanel {

    private static final int SHADOW_SIZE = 4; // Gölge boyutu
    private static final Color SHADOW_COLOR = new Color(0, 0, 0, 50); // Gölge rengi

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Orijinal paneli çiz
        super.paintComponent(g2d);

        // Gölge için yeni bir yuvarlak dikdörtgen oluştur
        Shape shadow = new RoundRectangle2D.Double(SHADOW_SIZE, SHADOW_SIZE, getWidth() - SHADOW_SIZE * 2, getHeight() - SHADOW_SIZE * 2, SHADOW_SIZE, SHADOW_SIZE);

        // Gölge rengini ve kalınlığını ayarla
        g2d.setColor(SHADOW_COLOR);
        g2d.setStroke(new BasicStroke(SHADOW_SIZE));

        // Gölgeyi çiz
        g2d.draw(shadow);

        g2d.dispose();
    }
}
