import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ProjectAnalyzer {

    // Recursively traverses the directory to find Java files (.java). For each file
    // found, it calls analyzeClass(file) to gather metrics
    public List<ClassMetrics> analyzeProject(String projectPath) {
        List<ClassMetrics> classMetricsList = new ArrayList<>();
        File projectDir = new File(projectPath);

        if (projectDir.isDirectory()) {
            for (File file : projectDir.listFiles()) {
                if (file.isDirectory()) {
                    classMetricsList.addAll(analyzeProject(file.getAbsolutePath()));
                } else if (file.getName().endsWith(".java")) {
                    ClassMetrics metrics = analyzeClass(file);
                    if (metrics != null) {
                        classMetricsList.add(metrics);
                    }
                }
            }
        }
        // returning a list of ClassMetrics objects, each representing the metrics of a
        // class.
        return classMetricsList;
    }

    private ClassMetrics analyzeClass(File file) {
        try {
            // Compile the .java file
            compileJavaFile(file);

            // Load the compiled class
            String className = file.getName().replace(".java", "");
            Class<?> clazz = loadClassFromFile(file.getParentFile(), className);

            int publicMethods = Calculter.publicDeclaredInClassMethods(clazz);
            int privateMethods = Calculter.privateDeclaredInClassMethods(clazz);
            int protectedMethods = Calculter.protectedDeclaredInClassMethods(clazz);
            int defaultMethods = Calculter.defaultAccessModifierDeclaredInClassMethods(clazz);
            int ntm = defaultMethods + protectedMethods + privateMethods + publicMethods;
            int finalMethods = Calculter.finalMethods(clazz);
            int staticMethods = Calculter.staticMethods(clazz);
            int abstractMethods = Calculter.abstractMethods(clazz);
            int inheritedMethods = Calculter.inheritedMethods(clazz);
            int overriddenMethods = Calculter.overrideMethods(clazz);
            String name = clazz.getName();

            return new ClassMetrics(ntm, publicMethods, privateMethods, protectedMethods, defaultMethods,
                    finalMethods, staticMethods, abstractMethods, inheritedMethods, overriddenMethods, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void compileJavaFile(File javaFile) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new IllegalStateException(
                    "Cannot find the system Java compiler. Check that your class path includes tools.jar");
        }
        int result = compiler.run(null, null, null, javaFile.getPath());
        if (result != 0) {
            throw new IOException("Compilation failed.");
        }
    }

    public static Class<?> loadClassFromFile(File dir, String className) throws IOException, ClassNotFoundException {
        URL[] urls = { dir.toURI().toURL() };
        try (URLClassLoader classLoader = new URLClassLoader(urls)) {
            return classLoader.loadClass(className);
        }
    }

    public ProjectAnalyzer(){}
    public ProjectAnalyzer(String directoryPathTextField) {
        String projectPath = directoryPathTextField;
        ProjectAnalyzer analyzer = new ProjectAnalyzer();
        List<ClassMetrics> classMetricsList = analyzer.analyzeProject(projectPath);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                analyzer.createAndShowGUI(classMetricsList);
            }
        });

        /*  ICMCalculator calculator = new ICMCalculator(classMetricsList);
        for (ClassMetrics metrics : classMetricsList) {
            double icm = calculator.calculateICM(metrics);
            System.out.println("ICM for " + metrics.getName() + ": " + icm);
        }*/
    }

   

    public void createAndShowGUI(List<ClassMetrics> classMetricsList) {
        // Create the frame
        JFrame frame = new JFrame("Class Metrics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the position of the frame relative to the screen dimensions
        int x = (screenSize.width - 700) / 2;
        int y = (screenSize.height - 450) / 2;
        // Set the frame's location
        frame.setLocation(x, y);

        // Create the panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create a scroll pane to add the panel
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ICMCalculator calculator = new ICMCalculator(classMetricsList);
        // Add each class metrics to the panel
        for (ClassMetrics metrics : classMetricsList) {
            JPanel rowPanel = new JPanel();
            rowPanel.setLayout(new BorderLayout());
            rowPanel.setBackground(Color.lightGray);

            // Create and add button at the start of the line
            JButton button = new JButton("Details");
            rowPanel.add(button, BorderLayout.WEST);

            double icm = calculator.calculateICM(metrics);
            // Create and add the label with metrics in the center
            JLabel label = new JLabel(getMetricsString(metrics, icm));
            rowPanel.add(label, BorderLayout.CENTER);

            // Create and add a placeholder label for text at the right of the frame

            JLabel textLabel = new JLabel();
            if (icm <= 3) {
                textLabel.setText("Classe extrêmement simple");
                textLabel.setForeground(new Color(0x90EE90));
            } else if (icm <= 10) {
                textLabel.setText("Classe relativement simple");
                textLabel.setForeground(new Color(0x7FFF00));
            } else if (icm <= 50) {
                textLabel.setText("Classe de complexité moyenne");
                textLabel.setForeground(new Color(0x006400));
            } else if (icm <= 250) {
                textLabel.setText("Classe complexe");
                textLabel.setForeground(new Color(0xFFFF00));
            } else {
                textLabel.setText("Classe très complexe");
                textLabel.setForeground(Color.red);
           }

            rowPanel.add(textLabel, BorderLayout.EAST);

            // Add action listener to button to show detailed metrics
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double cma = calculator.calculateCMA(metrics);
                    double ih = calculator.calculateIH(metrics);
                    double psm = calculator.calculatePSM(metrics);
                    double icm = calculator.calculateICM(metrics);
                    JOptionPane.showMessageDialog(frame, getDetailedMetricsString(metrics, cma, ih, psm, icm),
                            "Class Metrics Details",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });

            panel.add(rowPanel);
        }

        // Add the scroll pane to the frame
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
      
      
        // Create the title label
        JLabel titleLabel = new JLabel("<html><u>Métrique : Indice de Complexité Méthodologique (ICM) </u></html>", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Create a panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setOpaque(false); // Make the panel transparent

        // Create the back button
        RippleEffectButton backButton = new RippleEffectButton("Back");
        backButton.setBackground(Color.decode("#A9A9A9"));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("SansSerif", Font.ITALIC, 13));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close current frame
                FilePathInputGUI mainFrame = new FilePathInputGUI(); // Open principalFrame
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

        // Create the Description button
        RippleEffectButton descButton = new RippleEffectButton("Description");
        descButton.setBackground(Color.decode("#A9A9A9"));
        descButton.setForeground(Color.WHITE);
        descButton.setFont(new Font("SansSerif", Font.ITALIC, 13));
        descButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ourMetricDetailFrame omf = new ourMetricDetailFrame("Indice de Complexité Méthodologique (ICM)");
                    omf.setVisible(true);
            }
        });
        descButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                descButton.setForeground(Color.black);
            }
    Color c= descButton.getForeground();
            @Override
            public void mouseExited(MouseEvent e) {
                descButton.setForeground(c);
            }
        });


        buttonPanel.add(titleLabel, BorderLayout.CENTER);
        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(descButton, BorderLayout.EAST);
        frame.add(buttonPanel,BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private String getMetricsString(ClassMetrics metrics, double icm) {
        return "Class: " + metrics.getName() + " - ICM: " + icm;
    }

    private String getDetailedMetricsString(ClassMetrics metrics, double cma, double psm, double ih, double icm) {
        Double dm = icm / (metrics.getNtm() * (cma + psm + ih));
        String s;
        if (icm <= 3) {
            s="Classe extrêmement simple, probablement sous-développée ou avec très peu de méthodes.";
        } else if (icm <= 10) {
            s="Classe relativement simple, avec peu de méthodes et une faible complexité.";
        } else if (icm <= 50) {
            s="Classe de complexité moyenne, bien équilibrée en termes de méthodes et de modificateurs d'accès";
        } else if (icm <= 250) {
            s="Classe complexe avec un grand nombre de méthodes et une diversité élevée. Peut nécessiter une refactorisation pour améliorer la maintenabilité.";
        } else {
            s="Classe très complexe. Forte probabilité de problèmes de maintenabilité et de besoin urgent de refactorisation.";
        }
        return "                                                                                Class Name : " + metrics.getName() +
                "\nICM = NTM x ( CMA + PSM + IH) x DM " +
                "\nICM = " + metrics.getNtm() + "x(" + cma + "+" + psm + "+" + ih + ") x" + dm +
                 "\n\nIndication:\n" + s+  
                "\n\n       NTM: " + metrics.getNtm() +
                "\n          Public Methods: " + metrics.getPublicMethods() +
                "\n          Private Methods: " + metrics.getPrivateMethods() +
                "\n          Protected Methods: " + metrics.getProtectedMethods() +
                "\n          Default Methods: " + metrics.getDefaultMethods() +
                "\n          Final Methods: " + metrics.getFinalMethods() +
                "\n          Static Methods: " + metrics.getStaticMethods() +
                "\n          Abstract Methods: " + metrics.getAbstractMethods() +
                "\n          Inherited Methods: " + metrics.getInheritedMethods() +
                "\n          Overridden Methods: " + metrics.getOverriddenMethods();
    }
}
