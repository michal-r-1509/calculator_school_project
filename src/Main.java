import ui.UserInterface;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static final int width = 230;
    private static final int height = 370;
    private static final int fill_gap = 15;

    public static void main(String[] args) {

        JFrame window = new JFrame("Kalkulator");
        window.add(new UserInterface(width, height, window));
        window.setMinimumSize(new Dimension(width + fill_gap, height));
        window.requestFocusInWindow();
        window.setLocationByPlatform(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
