import java.awt.Color;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTextPane;
import javax.swing.text.*;

public class analyser {

    private static Set<String> usedMethods = new HashSet<>();
    private JTextPane resultTextPane;

    public analyser() {
        this(null);
    }

    public analyser(JTextPane resultTextPane) {
        this.resultTextPane = resultTextPane;
    }

// Collecter les noms des méthodes déclarées dans la classe selectionnée
    public void analyzeCode(Class<?> clazz) {
        
        String className = clazz.getSimpleName();
        appendResult("          Analyse de la classe :" + className + "          \n", new Color(70,130,180), true);

        
        boolean utiliser = false;
        // Vérifier les méthodes déclarées mais non utilisées
        for (Method method : clazz.getDeclaredMethods()) {
            String methodName = method.getName();
            if (!usedMethods.contains(methodName)) {
                appendResult("<!> Code mort détecté, nom de la methode : " + methodName + ".\n", new Color(217, 1, 21), false);
                utiliser = true;
            }
        }
        if (!utiliser) {
            appendResult(" (!) Aucun code mort détecté dans cette classe !\n", new Color(20, 148, 20), false);
        }
    }

    public static void registerMethodCall(String methodName) {
        // Enregistrer automatiquement le nom de la méthode appelée
        usedMethods.add(methodName);
    }

//partie pour l'interface graphique 
    private void appendResult(String message, Color color, boolean bold) {
        if (resultTextPane != null) {
            StyledDocument doc = resultTextPane.getStyledDocument();
            SimpleAttributeSet style = new SimpleAttributeSet();
            StyleConstants.setForeground(style, color);
            StyleConstants.setBackground(style, Color.white); 
            StyleConstants.setBold(style, bold);
            try {
                doc.insertString(doc.getLength(), message, style);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        } else {
            System.out.print(message);
        }
    }
}
