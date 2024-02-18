package code.layoutManager;

import javax.swing.*;

public class LayoutMain extends JFrame {
    public LayoutMain(int widthMain, int heightMain){
        setTitle("Swing Project");
        setSize(widthMain, heightMain);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}