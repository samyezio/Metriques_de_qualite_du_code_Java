

import javax.swing.*;
import java.awt.*;

public class ResultsDisplayGUI extends JFrame {
    public ResultsDisplayGUI(int lcom, int cbo, int fanIn, int fanOut, double normalizedLCOM, double normalizedCBO, double normalizedMODULARITY, double isc, int maxLCOM, int maxCBO) {
        setTitle("Analysis Results");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JLabel lcomLabel = new JLabel("Normalized LCOM = 1 - LCOM / " + maxLCOM + " = 1 - " + lcom + " / " + maxLCOM + " = " + normalizedLCOM);
        JLabel cboLabel = new JLabel("Normalized CBO = 1 - CBO / " + maxCBO + " = 1 - " + cbo + " / " + maxCBO + " = " + normalizedCBO);
        JLabel modularityLabel = new JLabel("Normalized MODULARITY = (Fan-In + Fan-Out) / (2 * max(Fan-In, Fan-Out)) = (" + fanIn + " + " + fanOut + ") / (2 * " + Math.max(fanIn, fanOut) + ") = " + normalizedMODULARITY);
        JLabel iscLabel = new JLabel("ISC = ((Normalized LCOM + Normalized MODULARITY) - (Normalized CBO) + 1  / 2  = ((" + normalizedLCOM + " + " + normalizedMODULARITY + ") - (" + normalizedCBO + ") + 1/ 2 = " + isc);

        add(lcomLabel);
        add(cboLabel);
        add(modularityLabel);
        add(iscLabel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the position of the frame relative to the screen dimensions
        int x = (screenSize.width - 650) / 2;
        int y = (screenSize.height  - 550) / 2;
        // Set the frame's location
        setLocation(x, y);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton);
    }
}

