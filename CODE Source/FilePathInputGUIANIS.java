import javax.swing.*;
import java.lang.reflect.Method;

public class FilePathInputGUIANIS extends JFrame {
   

    public static void displayMethodChoiceDialogANIS(Class<?> loadedClass) {
        // Methods to choose from
        String[] methodNames = {
                "calculateCohesionScore",
                "calculateCouplingScore",
                "calculateInterfaceUsageScore",
                "calculateReusability"
        };

        // Create dialog to choose a method
        String chosenMethod = (String) JOptionPane.showInputDialog(null, "Choose a method to calculate:",
                "Method Selection", JOptionPane.PLAIN_MESSAGE, null, methodNames, methodNames[0]);

        if (chosenMethod != null) {
           try {
                
                double result = invokeMethod(loadedClass, chosenMethod);
                JOptionPane.showMessageDialog(null, "Result for " + chosenMethod + ": " + result);
           } catch (Exception e) {

                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error invoking method: " + chosenMethod + "\n" + e.getMessage());


            }
        }
    }

    private static double invokeMethod(Class<?> loadedClass, String methodName) throws Exception {
        // Invoke method from the ReusabilityMetric class
        Method method = ReusabilityMetric.class.getMethod(methodName, Class.class);
        return (double) method.invoke(null, loadedClass);
    }

   
}
