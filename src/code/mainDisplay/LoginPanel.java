package code.mainDisplay;

import code.layoutManager.LayoutMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginPanel extends JPanel {
    public Font font = new Font("MS Gothic",Font.PLAIN,30);
    public Dimension labelDimension = new Dimension(70,40);
    public Dimension txtDimension = new Dimension(200,40);
    public Dimension btnDimension = new Dimension(275,40);
    public LoginPanel() {
        setLayout(new BorderLayout());
        setOpaque(false);
        add(new LoginId(), BorderLayout.NORTH);
        add(new LoginPw(), BorderLayout.CENTER);
        add(new LoginBtn(), BorderLayout.SOUTH);
    }

    public class LoginId extends JPanel {
        private JLabel labelId;
        private JTextField txtId;
        public LoginId(){
            setOpaque(false);
            add(getLabelId());
            add(getTxtId());
        }

        private JLabel getLabelId() {
            if (labelId == null) {
                labelId = new JLabel("ID :");
                labelId.setFont(font);
                labelId.setPreferredSize(labelDimension);
                labelId.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            }
            return labelId;
        }
        private JTextField getTxtId() {
            if (txtId == null) {
                txtId = new JTextField();
                txtId.setFont(font);
                txtId.setPreferredSize(txtDimension);
                txtId.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

                txtId.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER){
                            ((LoginBtn) getParent().getComponent(2)).getLoginBtn().doClick();
                        }
                    }
                });
            }
            return txtId;
        }
    }
    public class LoginPw extends JPanel {
        private JLabel labelPw;
        private JPasswordField txtPw;
        public LoginPw(){
            setOpaque(false);
            add(getLabelPw());
            add(getTxtPw());
        }
        private JLabel getLabelPw() {
            if (labelPw == null) {
                labelPw = new JLabel("PW :");
                labelPw.setFont(font);
                labelPw.setPreferredSize(labelDimension);
                labelPw.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            }
            return labelPw;
        }
        private JPasswordField getTxtPw() {
            if (txtPw == null) {
                txtPw = new JPasswordField();
                txtPw.setFont(font);
                txtPw.setPreferredSize(txtDimension);
                txtPw.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

                txtPw.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER){
                            ((LoginBtn) getParent().getComponent(2)).getLoginBtn().doClick();
                        }
                    }
                });
            }
            return txtPw;
        }
    }

    public class LoginBtn extends JPanel {
        private JButton loginBtn;
        public LoginBtn() {
            setOpaque(false);
            add(getLoginBtn());
        }
        public JButton getLoginBtn() {
            if (loginBtn == null) {
                loginBtn = new JButton("Login");
                loginBtn.setBackground(Color.PINK);
                loginBtn.setFont(font);
                loginBtn.setPreferredSize(btnDimension);
                loginBtn.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

                loginBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String adminId = "admin";
                        String adminPw = "1111";

                        String enteredId = ((LoginId) getParent().getComponent(0)).getTxtId().getText();
                        String enteredPw = new String(((LoginPw) getParent().getComponent(1)).getTxtPw().getPassword());

                        if (enteredId.equals("") || enteredPw.equals("")) {
                            JOptionPane.showMessageDialog(LoginPanel.this, "ID or Password is not entered.");
                        } else if(enteredId.equals(adminId) && enteredPw.equals(adminPw)){
                            SwingUtilities.getWindowAncestor(LoginPanel.this).dispose();
                            LayoutMain layoutMain = new LayoutMain(LoginMain.getWidthMain(), LoginMain.getHeightMain());
                        } else {
                            JOptionPane.showMessageDialog(LoginPanel.this, "Login Ng");
                        }
                    }
                });
            }
            return loginBtn;
        }
    }
}