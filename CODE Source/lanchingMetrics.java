import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.reflect.Method;

public class lanchingMetrics extends JFrame {

    public lanchingMetrics(String metricName, Class<?> loadedClass,String directoryPathTextField) throws IOException {
        
        switch (metricName) {
            case "Indice de Complexité Méthodologique (ICM)":
                new ProjectAnalyzer(directoryPathTextField);
                break;
            case "methods calculator (MC) :":
                displayMethodChoiceFrame(loadedClass);
                break;

            case "Reusability Metric (RM) :":
                FilePathInputGUIANIS.displayMethodChoiceDialogANIS(loadedClass);
                break;

            case "Métrique de détection de code mort (DCM) : ":
                show.analyseClass(loadedClass);
                break;

            case "Indice de Structuration du Code (ISC) : ":
            new MaxValuesInputGUI(loadedClass.getName()).setVisible(true);
            dispose();
                break;

            case "Taille de la Redondance Logique (TRL) :":
            
            double lrs = TRLmetric.calculateLRS(directoryPathTextField);
            TRLmetricGUI.displayResultDialog(lrs);
                break;
            default:

                break;

        }
        
    }

    private void displayMethodChoiceFrame(Class<?> loadedClass) {
        JFrame methodChoiceFrame = new JFrame("Method Choice");
        methodChoiceFrame.setSize(650, 500);
        methodChoiceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        methodChoiceFrame.setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the position of the frame relative to the screen dimensions
        int x = (screenSize.width - 650) / 2;
        int y = (screenSize.height - 550) / 2;
        // Set the frame's location
        methodChoiceFrame.setLocation(x, y);

        JPanel methodPanel = createMethodsPanel(loadedClass);
        JScrollPane scrollPane = new JScrollPane(methodPanel);
        methodChoiceFrame.add(scrollPane, BorderLayout.CENTER);

        methodChoiceFrame.setVisible(true);
    }

    private JPanel createMethodsPanel(Class<?> loadedClass) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

        String[] methods = {
            "totalMethods",
            "publicDeclaredInClassMethods",
            "allPublicMethods",
            "privateDeclaredInClassMethods",
            "allPrivateMethods",
            "protectedDeclaredInClassMethods",
            "allProtectedMethods",
            "defaultAccessModifierDeclaredInClassMethods",
            "allDefaultAccessModifierMethods",
            "finalMethods",
            "staticMethods",
            "abstractMethods",
            "inheritedMethods",
            "overrideMethods"
        };

        for (String method : methods) {
            JPanel linePanel = new JPanel();
            linePanel.setLayout(new BoxLayout(linePanel, BoxLayout.X_AXIS));
            linePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            linePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add space between lines

            JLabel label = new JLabel(method);
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    executeMethod(loadedClass, method);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setForeground(Color.BLUE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(Color.BLACK);
                }
            });

            JButton button = new JButton("liste des noms de méthodes");
            button.addActionListener(e -> executeMethod1(loadedClass, method));

            linePanel.add(label);
            linePanel.add(Box.createHorizontalGlue()); // Pushes the button to the right
            linePanel.add(button);

            panel.add(linePanel);
        }

        return panel;
    }

    private void executeMethod1(Class<?> loadedClass, String methodName) {
        

        try {
           switch (methodName) {
            case "totalMethods":
                methodName="namesTotalMethod";
                break;
            case "publicDeclaredInClassMethods":
            methodName="namesPublicDeclaredInClassMetohd";
                break;
             case "allPublicMethods":
             methodName="namesAllPublicMetohd";
                break;
                case "privateDeclaredInClassMethods":
             methodName="namesPrivateDeclaredInClassMetohd";
                break;
                case "allPrivateMethods":
             methodName="namesAllPrivateMethods";
                break;
                case "protectedDeclaredInClassMethods":
             methodName="namesProtectedDeclaredInClassMetohd";
                break;
                case "allProtectedMethods":
             methodName="namesAllProtectedMethods";
                break;
                case "defaultAccessModifierDeclaredInClassMethods":
             methodName="namesDefaultAccessModifierDeclaredInClassMetohd";
                break;
                case "allDefaultAccessModifierMethods":
             methodName="namesAllDefaultAccessModifierMethods";
                break;
                case "finalMethods":
             methodName="namesFinalMethods";
                break;
                case "staticMethods":
             methodName="namesStaticMethods";
                break;
                case "abstractMethods":
             methodName="namesAbstractMethods";
                break;
                case "inheritedMethods":
             methodName="namesInheritedMetohd";
                break;
                case "overrideMethods":
             methodName="namesOverrideMetohd";
                break;
            default:
                break;
           }
           
           String[] result = invokeMethodWithStringArrayResult(loadedClass, methodName);
                    JOptionPane.showMessageDialog(null,
                            "Results for " + methodName + ":\n" + String.join("\n", result));
           
            /*Method method = Calculter.class.getMethod(methodName, Class.class);
            result = (int) method.invoke(null, loadedClass);
            System.out.println(methodName);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
    private String[] invokeMethodWithStringArrayResult(Class<?> loadedClass, String methodName) {
        try {
            Method method = Calculter.class.getMethod(methodName, Class.class);
            return (String[]) method.invoke(null, loadedClass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error invoking method: " + e.getMessage());
            return new String[0];
        }
    }
    private void executeMethod(Class<?> loadedClass, String methodName) {
        int result = 0;

        try {
            Method method = Calculter.class.getMethod(methodName, Class.class);
            result = (int) method.invoke(null, loadedClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, methodName + ": " + result);
    }

}


/*
 * private void displayMethodChoiceFrame(Class<?> loadedClass) {
 * JFrame methodChoiceFrame = new JFrame("Method Choice");
 * methodChoiceFrame.setSize(650, 500);
 * methodChoiceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 * methodChoiceFrame.setLayout(new GridLayout(0, 1));
 * 
 * Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 * // Calculate the position of the frame relative to the screen dimensions
 * int x = (screenSize.width - 650) / 2;
 * int y = (screenSize.height - 550) / 2;
 * // Set the frame's location
 * methodChoiceFrame.setLocation(x, y);
 * 
 * // Methods to choose from in the Calculator class
 * String[] methodNames = {
 * "totalMethods",
 * "publicDeclaredInClassMethods",
 * "allPublicMethods",
 * "privateDeclaredInClassMethods",
 * "allPrivateMethods",
 * "protectedDeclaredInClassMethods",
 * "allProtectedMethods",
 * "defaultAccessModifierDeclaredInClassMethods",
 * "allDefaultAccessModifierMethods",
 * "finalMethods",
 * "staticMethods",
 * "abstractMethods",
 * "inheritedMethods",
 * "overrideMethods"
 * };
 * JButton[] methodButtons = new JButton[methodNames.length];
 * for (int i = 0; i < methodNames.length; i++) {
 * final String methodName = methodNames[i];
 * JButton button = new JButton(methodName);
 * button.addActionListener(new ActionListener() {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * // Call the corresponding method based on the button text
 * int result = invokeMethod(loadedClass, methodName);
 * JOptionPane.showMessageDialog(null, "Result for " + methodName + ": " +
 * result);
 * }
 * });
 * methodChoiceFrame.add(button);
 * }
 * 
 * methodChoiceFrame.setVisible(true);
 * }
 */
