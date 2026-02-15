import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FilePathInputGUI extends JFrame {
    private JButton browseButton;
    private JButton submitButton;
    private JTextField directoryPathTextField;
    private JComboBox<String> classComboBox;

    public FilePathInputGUI() {
        setTitle("Code Analyzer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Top panel for directory selection and class selection
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        JPanel inputPanel = new JPanel(new FlowLayout());
        directoryPathTextField = new JTextField(30);
        browseButton = new JButton("Browse");
        submitButton = new JButton("Submit");
        inputPanel.add(new JLabel("Select Project Directory:"));
        inputPanel.add(directoryPathTextField);
        inputPanel.add(browseButton);
        topPanel.add(inputPanel);

        // Panel for class selection
        JPanel classPanel = new JPanel(new FlowLayout());
        classComboBox = new JComboBox<>();
        classPanel.add(new JLabel("Select Class:"));
        classPanel.add(classComboBox);
        topPanel.add(classPanel);

        add(topPanel, BorderLayout.CENTER);

        // Action Listeners
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    directoryPathTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    populateClassComboBox(fileChooser.getSelectedFile());
                }
            }
        });

        browseButton.addMouseListener(new MouseListener() {

            Color defaultBackground= browseButton.getBackground();
            Color defaultForeground=browseButton.getForeground();
            Color hoverBackground = new Color(173, 216, 230);

            @Override
            public void mouseEntered(MouseEvent e) {
                defaultBackground = browseButton.getBackground();
                
                browseButton.setBackground(hoverBackground);
                browseButton.setForeground(Color.blue);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                browseButton.setBackground(defaultBackground);
                browseButton.setForeground(defaultForeground);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
               }

            @Override
            public void mousePressed(MouseEvent e) {
             }

            @Override
            public void mouseReleased(MouseEvent e) {
           }

        } );

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classComboBox.getSelectedItem();
                if (selectedClass != null) {
                    String classPath = directoryPathTextField.getText() + File.separator + selectedClass + ".java";

                    try {
                        // Load the class dynamically
                        Class<?> loadedClass = loadClassFromFile(classPath, selectedClass);

                        // Analyze the loaded class for dead code
                        dispose();
                        metricChosing mc= new metricChosing(loadedClass,directoryPathTextField.getText());
                       mc.setVisible(true);

                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Class not found at path: " + classPath);
                    }
                }
            }
        });

        submitButton.addMouseListener(new MouseListener() {

            Color defaultBackground= submitButton.getBackground();
            Color defaultForeground=submitButton.getForeground();
            Color hoverBackground = new Color(173, 216, 230);

            @Override
            public void mouseEntered(MouseEvent e) {
                defaultBackground = browseButton.getBackground();
                
                submitButton.setBackground(hoverBackground);
                submitButton.setForeground(Color.blue);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitButton.setBackground(defaultBackground);
                submitButton.setForeground(defaultForeground);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
               }

            @Override
            public void mousePressed(MouseEvent e) {
             }

            @Override
            public void mouseReleased(MouseEvent e) {
         }

        } );
    
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
   
    // Create a panel for the button
    JPanel buttonPanel2 = new JPanel();
    buttonPanel2.setLayout(new BorderLayout());
    buttonPanel2.setOpaque(false); // Make the panel transparent

    // Create the back button
    RippleEffectButton backButton = new RippleEffectButton("Back");
    backButton.setBackground(Color.decode("#A9A9A9"));
    backButton.setForeground(Color.WHITE);
    backButton.setFont(new Font("SansSerif", Font.ITALIC, 13));
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); // Close current frame
            principalFrame mainFrame = new principalFrame(); // Open principalFrame
            mainFrame.setVisible(true);
        }
    });
    backButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            backButton.setForeground(Color.black);
        }

        Color c= backButton.getForeground();
        @Override
        public void mouseExited(MouseEvent e) {
            backButton.setForeground(c);
        }
    });

    // Add the button to the top left corner
    buttonPanel2.add(backButton, BorderLayout.WEST);
    add(buttonPanel2, BorderLayout.NORTH);
    pack();
}

    private void populateClassComboBox(File directory) {
        classComboBox.removeAllItems();
        try {
            List<String> classFiles = Files.walk(Paths.get(directory.getAbsolutePath()))
                    .filter(Files::isRegularFile)
                    .map(path -> path.getFileName().toString())
                    .filter(name -> name.endsWith(".java"))
                    .map(name -> name.substring(0, name.lastIndexOf('.')))
                    .collect(Collectors.toList());

            for (String className : classFiles) {
                classComboBox.addItem(className);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Class<?> loadClassFromFile(String classPath, String className) throws ClassNotFoundException {
        try {
            // Load the class file dynamically
            File file = new File(classPath);
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { file.toURI().toURL() });
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