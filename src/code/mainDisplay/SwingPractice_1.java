package code.mainDisplay;

import javax.swing.*;

public class SwingPractice_1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginMain main = new LoginMain();
            }
        });
    }
}