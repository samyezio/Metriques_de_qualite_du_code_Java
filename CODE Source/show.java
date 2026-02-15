import javax.swing.*;
import java.awt.*;

public class show extends JFrame {

    static void analyseClass(Class<?> loadedClass) {
        // Create a new window to display the analysis results
        JFrame resultFrame = new JFrame("Analysis Results");
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextPane resultTextPane = new JTextPane();
        resultTextPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        resultFrame.add(scrollPane);

        // Set font and background color
        Font font = new Font("Consolas", Font.PLAIN, 14);
        resultTextPane.setFont(font);
        resultTextPane.setBackground(Color.white);

        // Run the analysis and display the results
        analyser codeAnalyzer = new analyser(resultTextPane);

        // Simulate method calls for demonstration
        if (loadedClass == ex_GestionStock.class) {
            ex_GestionStock gestionStock = new ex_GestionStock();
            gestionStock.addProduct();
            gestionStock.updateProduct();
        } else if (loadedClass == ex_Commande.class) {
            ex_GestionStock gestionStock = new ex_GestionStock();
            ex_Commande commande = new ex_Commande(gestionStock);
            commande.processOrder();
        }

        // Analyze the code for dead methods
        codeAnalyzer.analyzeCode(loadedClass);

        resultFrame.pack();
        resultFrame.setVisible(true);
    }
  
}
