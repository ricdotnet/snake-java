import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        add(new Board());

        setResizable(false);
        pack();

        setLocation(150, 150);
        setTitle("Main Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(Main::new);
    }
}