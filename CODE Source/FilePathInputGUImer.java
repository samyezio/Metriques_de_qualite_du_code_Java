import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;

public class FilePathInputGUImer extends JFrame {
    private JTextField filePathTextField;
    private JButton browseButton;
    private JButton submitButton;

   

    public static void displayMethodChoiceDialogmer(Class<?> loadedClass) {
        // Methods to choose from
        String[] methodNames = {
                "calculateLRS",
                "countPatterns",
                "countKeywordOccurrences",
                "generateReport"
        };

        // Create dialog to choose a method
        String chosenMethod = (String) JOptionPane.showInputDialog(null, "Choose a method to calculate:",
                "Method Selection", JOptionPane.PLAIN_MESSAGE, null, methodNames, methodNames[0]);

        if (chosenMethod != null) {
            try {
                System.out.println(chosenMethod);
                double result = invokeMethod(loadedClass, chosenMethod);
                JOptionPane.showMessageDialog(null, "Result for " + chosenMethod + ": " + result);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error invoking method: " + chosenMethod + "\n" + e.getMessage());
            }
        }
    }

    private static double invokeMethod(Class<?> loadedClass, String methodName) throws Exception {
        // Find the method in the loaded class with a matching name
        Method method = TRLmetric.class.getMethod(methodName, Class.class);
        return (double) method.invoke(null, loadedClass);
    }

    private static Class<?> loadClassFromFile(String classPath) throws ClassNotFoundException {
        try {
            // Load the class file dynamically
            File file = new File(classPath);
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()});
            String className = getClassNameFromPath(classPath);
            return Class.forName(className, true, classLoader);
        } catch (Exception e) {
            throw new ClassNotFoundException("Failed to load class from file: " + e.getMessage(), e);
        }
    }

    private static String getClassNameFromPath(String classPath) {
        // Extract the class name from the file path
        String className = new File(classPath).getName();
        // Remove the ".class" extension
        className = className.substring(0, className.lastIndexOf('.'));
        return className;
    }

    
}