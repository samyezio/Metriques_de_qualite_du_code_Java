
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MetricsButtonsGUI extends JFrame {
    private String filePath;
    private int maxLCOM;
    private int maxCBO;

    public MetricsButtonsGUI(String filePath, int maxLCOM, int maxCBO) {
        this.filePath = filePath;
        this.maxLCOM = maxLCOM;
        this.maxCBO = maxCBO;

        setTitle("Code Metrics");
        setSize(400, 300);
        
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 4, 10, 10));

        JButton lcomButton = createMetricButton("LCOM", "Lack of Cohesion of Methods");
        JButton cboButton = createMetricButton("CBO", "Coupling Between Objects");
        JButton modularityButton = createMetricButton("MODULARITY", "Modularity");
        JButton iscButton = createMetricButton("ISC", "indice de Structuration de Code");

        buttonPanel.add(lcomButton);
        buttonPanel.add(cboButton);
        buttonPanel.add(modularityButton);
        buttonPanel.add(iscButton);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the position of the frame relative to the screen dimensions
        int x = (screenSize.width - 650) / 2;
        int y = (screenSize.height  - 550) / 2;
        // Set the frame's location
        setLocation(x, y);

        add(buttonPanel, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel infoLabel = new JLabel("Click a button to see the normalized metric and its formula.", JLabel.CENTER);
        infoPanel.add(infoLabel, BorderLayout.CENTER);

        add(infoPanel, BorderLayout.NORTH);
    }

    private JButton createMetricButton(String metric, String description) {
        JButton button = new JButton("<html><center>" + metric + "<br><small>" + description + "</small></center></html>");
        button.addActionListener(new MetricsButtonListener(metric));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    private class MetricsButtonListener implements ActionListener {
        private String metric;

        public MetricsButtonListener(String metric) {
            this.metric = metric;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            CodeQualityAnalyzer.analyzeAndDisplayResults(filePath, maxLCOM, maxCBO);
        }
    }
}
