import javax.swing.SwingUtilities;

public class Driver {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MiniTwitter miniTwitterApp = MiniTwitter.getInstance();
            miniTwitterApp.run();
        });
    }
}
