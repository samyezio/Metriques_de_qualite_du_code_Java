

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TRLmetricGUI extends JFrame {
    private JTextField directoryPathTextField;
    private JButton browseButton;
    private JButton calculateButton;

    public TRLmetricGUI() {
        setTitle("TRL Metric Calculator");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for directory path input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBackground(new Color(230, 240, 250));
        directoryPathTextField = new JTextField(25);
        browseButton = new JButton("Browse");
        calculateButton = new JButton("Calculate");

        inputPanel.add(new JLabel("Directory Path:"));
        inputPanel.add(directoryPathTextField);
        inputPanel.add(browseButton);
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.CENTER);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);

        // Title Label
        JLabel titleLabel = new JLabel("Java Logical Regularity Score (LRS) Calculator", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(100, 149, 237));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, BorderLayout.NORTH);

        // Action Listeners
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser directoryChooser = new JFileChooser();
                directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = directoryChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    directoryPathTextField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String directoryPath = directoryPathTextField.getText();
                try {
                    double lrs = TRLmetric.calculateLRS(directoryPath);
                    displayResultDialog(lrs);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error reading files: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid directory: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void displayResultDialog(double lrs) {
        JTextArea resultArea = new JTextArea(3, 30);
        resultArea.setFont(new Font("Arial", Font.BOLD, 16));

        // Change color based on LRS value
        if (lrs > 0.5) {
            resultArea.setForeground(new Color(0, 128, 0)); // Green
        } else {
            resultArea.setForeground(Color.RED); // Red
        }

        resultArea.setText("\nLogical Regularity Score: " + lrs);
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JOptionPane.showMessageDialog(null, scrollPane, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
    }

    
}
