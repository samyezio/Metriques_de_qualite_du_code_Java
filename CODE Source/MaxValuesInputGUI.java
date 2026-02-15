
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxValuesInputGUI extends JFrame {
    private JTextField maxLCOMTextField;
    private JTextField maxCBOTextField;
    private JButton nextButton;
    private String filePath;

    public MaxValuesInputGUI(String filePath) {
        this.filePath = filePath;

        setTitle("Entrer les Bonnes Valeurs maximal pour votre Projet ");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        maxLCOMTextField = new JTextField(5);
        maxCBOTextField = new JTextField(5);
        nextButton = new JButton("Next");

        add(new JLabel("Max LCOM:"));
        add(maxLCOMTextField);
        add(new JLabel("Max CBO:"));
        add(maxCBOTextField);
        add(nextButton);
      
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the position of the frame relative to the screen dimensions
        int x = (screenSize.width - 650) / 2;
        int y = (screenSize.height  - 550) / 2;
        // Set the frame's location
        setLocation(x, y);

        nextButton.addActionListener(new NextButtonListener());
    }

    private class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int maxLCOM;
            int maxCBO;

            try {
                maxLCOM = Integer.parseInt(maxLCOMTextField.getText());
                maxCBO = Integer.parseInt(maxCBOTextField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for max LCOM and max CBO.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new MetricsButtonsGUI(filePath, maxLCOM, maxCBO).setVisible(true);
            dispose();
        }
    }
}

