import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class description extends JFrame {
    public description() {
        // Set the title of the window
        setTitle("New Methods");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the title label
        JLabel titleLabel = new JLabel("<html><u>Nouvelles Métriques Description </u></html>", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Create a panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setOpaque(true); // Make the panel transparent

        // Create the back button
        RippleEffectButton backButton = new RippleEffectButton("Back");
        backButton.setBackground(Color.decode("#A9A9A9"));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("SansSerif", Font.ITALIC, 13));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current frame
                principalFrame mainFrame = new principalFrame(); // Open principalFrame
                mainFrame.setVisible(true);
            }
        });
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setForeground(Color.black);
            }

            Color c= backButton.getForeground();
            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setForeground(c);
            }
        });

        buttonPanel.add(titleLabel, BorderLayout.SOUTH);

        // Add the button to the top left corner
        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.setBackground(Color.decode("#D3D3D3"));
        add(buttonPanel, BorderLayout.NORTH);

        // Create a panel to hold the lines
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

        String[] lines = {
                "Indice de Complexité Méthodologique (ICM)",
                "methods calculator (MC) :",
                "ReusabilityMetric :",
                "Métrique de détection de code mort (DCM) : ",
                "Indice de Structuration du Code ISC : ",
                "Taille de la Redondance Logique (TRL) :"
        };

        for (String line : lines) {
            JLabel label = new JLabel(line, JLabel.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setForeground(Color.BLUE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(Color.BLACK);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    ourMetricDetailFrame omf = new ourMetricDetailFrame(line);
                    omf.setVisible(true);
                }
            });

            centerPanel.add(label);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between labels
        }

        add(centerPanel, BorderLayout.CENTER);
        
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        left.setPreferredSize(new Dimension(50,0));
        right.setPreferredSize(new Dimension(50,0));
        left.setBackground(Color.decode("#D3D3D3"));
        right.setBackground(Color.decode("#D3D3D3"));
        left.setOpaque(true);
        add(left, BorderLayout.EAST);
        add(right, BorderLayout.WEST);
        
    }
}