import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class RippleEffectButton extends JButton {
    private int rippleX = -1;
    private int rippleY = -1;
    private int rippleRadius = 0;
    private Timer rippleTimer;
    private ActionListener rippleEndListener;

    public RippleEffectButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.ITALIC, 13));

        rippleTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rippleRadius += 5;
                if (rippleRadius > getWidth()) {
                    rippleTimer.stop();
                    rippleX = -1;
                    rippleY = -1;
                    rippleRadius = 0;
                    if (rippleEndListener != null) {
                        rippleEndListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
                    }
                }
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                rippleX = e.getX();
                rippleY = e.getY();
                rippleRadius = 0;
                rippleTimer.restart();
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw button background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Draw ripple effect
        if (rippleX != -1 && rippleY != -1) {
            g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20));
            g2.setColor(new Color(255, 255, 255, 150));
            g2.fillOval(rippleX - rippleRadius, rippleY - rippleRadius, rippleRadius * 2, rippleRadius * 2);
        }

        // Draw button text
        FontMetrics fm = g2.getFontMetrics();
        Rectangle textRect = fm.getStringBounds(getText(), g2).getBounds();
        int textX = (getWidth() - textRect.width) / 2;
        int textY = (getHeight() - textRect.height) / 2 + fm.getAscent();
        g2.setColor(getForeground());
        g2.drawString(getText(), textX, textY);

        g2.dispose();
        super.paintComponent(g);
    }


   
}