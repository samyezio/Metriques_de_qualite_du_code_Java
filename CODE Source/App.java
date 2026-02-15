import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                principalFrame frame = new principalFrame();
                frame.setVisible(true);
            }
        });
    }
}
 