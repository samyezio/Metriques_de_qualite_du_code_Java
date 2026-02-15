import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class principalFrame extends JFrame {
    public principalFrame() {
        // Set the title of the window
        setTitle("Project 10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the title label
        JLabel titleLabel = new JLabel("<html><u>Nouvelles métriques pour un programme orienté objet</u></html>",
                JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);
        Border lineBorder = BorderFactory.createLineBorder(Color.decode("#A9A9A9"), 3);
        titleLabel.setBorder(lineBorder);

        // Create the panel to hold options
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(1, 3));
        optionsPanel.setBorder(lineBorder);
        add(optionsPanel, BorderLayout.CENTER);

        // Option 1
        JPanel option1Panel = createOptionPanel("Métrique Existante", "image1.png");
        option1Panel.setBackground(Color.decode("#D3D3D3"));
        optionsPanel.add(option1Panel);

        // Option 2
        JPanel option2Panel = createOptionPanel1("Apply Metrics", "image2.png");
        option2Panel.setBackground(Color.decode("#A9A9A9"));
        optionsPanel.add(option2Panel);

        // Option 3
        JPanel option3Panel = createOptionPanel("Nouvelles Métriques", "image3.png");
        option3Panel.setBackground(Color.decode("#D3D3D3"));
        optionsPanel.add(option3Panel);
    }

    private JPanel createOptionPanel(String buttonText, String imagePath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);

        RippleEffectButton button = new RippleEffectButton(buttonText);
        button.setBackground(Color.decode("#A9A9A9"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Color c = button.getForeground();
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(c);
            }
        });

        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(imageLabel);
        panel.add(button);
        panel.add(Box.createVerticalGlue());

        button.addActionListener(new OptionButtonListener(buttonText, button));

        return panel;
    }

    private JPanel createOptionPanel1(String buttonText, String imagePath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);

        RippleEffectButton button = new RippleEffectButton(buttonText);
        button.setBackground(Color.decode("#D3D3D3"));
        button.setForeground(Color.GRAY);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Color c = button.getForeground();
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(c);
            }
        });
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(imageLabel);
        panel.add(button);
        panel.add(Box.createVerticalGlue());

        button.addActionListener(new OptionButtonListener(buttonText, button));

        return panel;
    }

    // ActionListener for option buttons
    private class OptionButtonListener implements ActionListener {
        private String option;
        private RippleEffectButton button;

        public OptionButtonListener(String option, RippleEffectButton button) {
            this.option = option;
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {
            
            if (option.equals("Métrique Existante")) {

                dispose(); // Close the current frame
                oldMetricsFrame oldMetrics = new oldMetricsFrame(); // Open oldMetricsFrame
                oldMetrics.setVisible(true);

            }
            if (option.equals("Nouvelles Métriques")) {

                dispose(); // Close the current frame
                description newMetrics = new description(); // Open oldMetricsFrame
                newMetrics.setVisible(true);

            }
            if (option.equals("Apply Metrics")) {

                dispose(); // Close the current frame
                FilePathInputGUI gui = new FilePathInputGUI();
                gui.setVisible(true);
            }
        }
    }

}