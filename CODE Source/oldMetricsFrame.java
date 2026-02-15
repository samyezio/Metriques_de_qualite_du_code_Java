import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class oldMetricsFrame extends JFrame {
    public oldMetricsFrame() {
     // Set the title of the window
     setTitle("Old Metrics");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(600, 400);
     setLocationRelativeTo(null);
     setLayout(new BorderLayout());

     // Create the title label
     JLabel titleLabel = new JLabel("<html><u>Métrique Existante</u></html>", JLabel.CENTER);
     titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

     // Create a panel for the button
     JPanel buttonPanel = new JPanel();
     buttonPanel.setLayout(new BorderLayout());
     buttonPanel.setOpaque(false); // Make the panel transparent
     
     buttonPanel.add(titleLabel, BorderLayout.SOUTH);

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
     buttonPanel.add(backButton, BorderLayout.WEST);
     add(buttonPanel, BorderLayout.NORTH);

     // Create the central panel for additional labels
     JPanel centerPanel = new JPanel();
     centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
     centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

     JLabel tailleSubTitleLabel = new JLabel("Taille:");
     tailleSubTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
     tailleSubTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     centerPanel.add(tailleSubTitleLabel);

     // Add a little space between subtitle and the next lines
     centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

     // Add the Taille lines
     String[] tailleMetrics = {
         "<html><u>NMO (Number of Methods):</font></u></html>",
         "<html><u>LOC (Lines of Code):</font></u></html>",
         "<html><u>NOM (Number of Attributes):</font></u></html>",
         "<html><u>CLOC (Comment Lines of Code):</font></u></html>"
     };
     ImageIcon imageIcon = new ImageIcon("page.png");
     
     for (String metric : tailleMetrics) {
        // Create a panel to hold the image and label horizontally
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
        // Create a JLabel for the image
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setPreferredSize(new Dimension(20, 20)); // Set the size of the image
        panel.add(imageLabel); // Add the image label to the panel
    
        // Create a JLabel for the metric text
        JLabel label = new JLabel(metric);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBackground(Color.CYAN);
    
        // Add the mouse listener to the label
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MetricDetailFrame M = new MetricDetailFrame(label.getText());
                M.setVisible(true);
                // Add further action here if needed
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
    
        // Add the label to the panel
        panel.add(label);
    
        // Add the panel to the centerPanel
        centerPanel.add(panel);
    }
     // Add space before the Couplage subtitle
     centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

     JLabel couplageSubTitleLabel = new JLabel("Couplage:");
     couplageSubTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
     couplageSubTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     centerPanel.add(couplageSubTitleLabel);

     // Add a little space between subtitle and the next lines
     centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

     // Add the Couplage lines
     String[] couplageMetrics = {
         "<html><u>CBO (Coupling Between Objects):</font></u></html>",
         "<html><u>RFC (Reference For Class):</font></u></html>",
         "<html><u>CBM (Coupling Between Methods):</font></u></html>",
         "<html><u>Cd (Coupling Density):</font></u></html>"
     };
     for (String metric : couplageMetrics) {
         // Create a panel to hold the image and label horizontally
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
    
        // Create a JLabel for the image
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setPreferredSize(new Dimension(20, 20)); // Set the size of the image
        panel1.add(imageLabel); // Add the image label to the panel
    
        // Create a JLabel for the metric text
        JLabel label = new JLabel(metric);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBackground(Color.CYAN);
    
        // Add the mouse listener to the label
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MetricDetailFrame M = new MetricDetailFrame(label.getText());
                M.setVisible(true);
                // Add further action here if needed
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
    
        // Add the label to the panel
        panel1.add(label);
    
        // Add the panel to the centerPanel
        centerPanel.add(panel1);
    }

     // Add space before the Cohésion subtitle
     centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

     JLabel cohesionSubTitleLabel = new JLabel("Cohésion:");
     cohesionSubTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
     cohesionSubTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     centerPanel.add(cohesionSubTitleLabel);

     // Add a little space between subtitle and the next lines
     centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

     // Add the Cohésion lines
     String[] cohesionMetrics = {
         "<html><u>LCOM (Lack of Cohesion of Methods):</font></u></html>",
         "<html><u>CHC (Coupling Between Methods):</font></u></html>",
         "<html><u>TCC (Tight Class Cohesion) and LCC (Loose Class Cohesion):</font></u></html>",
         "<html><u>CAM (Class Access Metric):</font></u></html>"
     };
     for (String metric : cohesionMetrics) {
         // Create a panel to hold the image and label horizontally
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
    
        // Create a JLabel for the image
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setPreferredSize(new Dimension(20, 20)); // Set the size of the image
        panel2.add(imageLabel); // Add the image label to the panel
    
        // Create a JLabel for the metric text
        JLabel label = new JLabel(metric);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBackground(Color.CYAN);
    
        // Add the mouse listener to the label
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MetricDetailFrame M = new MetricDetailFrame(label.getText());
                M.setVisible(true);
                // Add further action here if needed
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
    
        // Add the label to the panel
        panel2.add(label);
    
        // Add the panel to the centerPanel
        centerPanel.add(panel2);
     }

     // Add space before the Hérédité subtitle
     centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

     JLabel herediteSubTitleLabel = new JLabel("Hérédité:");
     herediteSubTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
     herediteSubTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     centerPanel.add(herediteSubTitleLabel);

     // Add a little space between subtitle and the next lines
     centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

     // Add the Hérédité lines
     String[] herediteMetrics = {
         "<html><u>DIT (Depth of Inheritance Tree):</font></u></html>",
         "<html><u>NPM (Number of Public Methods) :</font></u></html>", 
         "<html><u>FAN (Fan-In) :</font></u></html>",   "<html><u>FOUT (Fan-Out):</font></u></html>"
     };
     for (String metric : herediteMetrics) {
         // Create a panel to hold the image and label horizontally
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
    
        // Create a JLabel for the image
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setPreferredSize(new Dimension(20, 20)); // Set the size of the image
        panel3.add(imageLabel); // Add the image label to the panel
    
        // Create a JLabel for the metric text
        JLabel label = new JLabel(metric);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBackground(Color.CYAN);
    
        // Add the mouse listener to the label
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MetricDetailFrame M = new MetricDetailFrame(label.getText());
                M.setVisible(true);
                // Add further action here if needed
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
    
        // Add the label to the panel
        panel3.add(label);
    
        // Add the panel to the centerPanel
        centerPanel.add(panel3);
     }

     // Add space before the Complexité subtitle
     centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

     JLabel complexiteSubTitleLabel = new JLabel("Complexité:");
     complexiteSubTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
     complexiteSubTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     centerPanel.add(complexiteSubTitleLabel);

     // Add a little space between subtitle and the next line
     centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

     // Add the Complexité line
     JLabel complexiteLabel = new JLabel("<html><u>WMC (Weighted Methods per Class):</font></u></html>");
     // Create a panel to hold the image and label horizontally
     JPanel panel4 = new JPanel();
     panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
 
     // Create a JLabel for the image
     JLabel imageLabel = new JLabel(imageIcon);
     imageLabel.setPreferredSize(new Dimension(20, 20)); // Set the size of the image
     panel4.add(imageLabel); // Add the image label to the panel

     complexiteLabel.setFont(new Font("Arial", Font.PLAIN, 14));
     complexiteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     complexiteLabel.setBackground(Color.CYAN);
     complexiteLabel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            MetricDetailFrame M = new MetricDetailFrame(complexiteLabel.getText());
            M.setVisible(true);
         }
         public void mouseEntered(MouseEvent e) {
            complexiteLabel.setForeground(Color.BLUE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            complexiteLabel.setForeground(Color.BLACK);
        }
        });
        panel4.add(complexiteLabel);
    
        // Add the panel to the centerPanel
        centerPanel.add(panel4);
     

     add(centerPanel, BorderLayout.CENTER);
     // Add the center panel to a JScrollPane
     JScrollPane scrollPane = new JScrollPane(centerPanel);
     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
     JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();

     // Set the unit increment and block increment
     verticalScrollBar.setUnitIncrement(10); // Adjust this value to make scrolling faster
     verticalScrollBar.setBlockIncrement(50); // Adjust this value to make scrolling faster
     
     verticalScrollBar.setBackground(Color.gray);
    
     // Add the scroll pane to the center of the frame
     add(scrollPane, BorderLayout.CENTER);
 }}