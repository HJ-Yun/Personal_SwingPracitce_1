package code.mainDisplay;

import javax.swing.*;
import java.awt.*;

public class LoginMain extends JFrame {
    private static int widthMain = 1280;
    private static int heightMain = 960;
    private String bgMainUrl = "../../source/background_main.jpg";

    public LoginMain() {
        setTitle("Swing Project");
        setSize(widthMain, heightMain);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundMain backgroundMain = new BackgroundMain();
        LoginPanel loginMain = new LoginPanel();

        JPanel loginEast = new JPanel(new BorderLayout());
        loginEast.setOpaque(false);

        loginEast.add(loginMain, BorderLayout.SOUTH);
        backgroundMain.setLayout(new BorderLayout());
        backgroundMain.setBorder(BorderFactory.createEmptyBorder(0,0,100,200));
        backgroundMain.add(loginEast, BorderLayout.EAST);

        JLabel tittleMain = new JLabel("Java Swing Practice");
        tittleMain.setFont(new Font("MS Gothic",Font.PLAIN,60));
        tittleMain.setBorder(BorderFactory.createEmptyBorder(30,20,0,0));
        backgroundMain.add(tittleMain, BorderLayout.NORTH);

        add(backgroundMain);
        setVisible(true);
    }

    public static int getWidthMain(){
        return widthMain;
    }
    public static int getHeightMain(){
        return  heightMain;
    }

    private class BackgroundMain extends JLabel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon bgImgIcon = new ImageIcon(this.getClass().getResource(bgMainUrl));
            Image bgImg = bgImgIcon.getImage();
            if (bgImg != null) {
                g.drawImage(bgImg, 0, 0, widthMain, heightMain, this);
                System.out.println("painted");
            } else {
                System.out.println("Can not paint");
            }
        }
    }
}