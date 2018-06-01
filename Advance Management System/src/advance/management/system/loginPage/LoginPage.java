/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advance.management.system.loginPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Utils;

/**
 *
 * @author DELL
 */
public class LoginPage extends JFrame implements ActionListener
{

    private JLabel lblUserName, lblPassword, lblPosition;
    private JTextField txtUserName, txtPassword;
    private JComboBox<String> jcmbPosition;
    private JPanel jPanel;
    private String[] position = {"Select","Manager","Admin","Clerk"};
    private JButton btnSave,btnClear,btnCancel,btnChangePassword;
    Utils utils = new Utils();

    private LoginPage() {

        setSize(400, 400);
        setLocation(300, 100);
        setResizable(false);
        setTitle("                          Login Page!!!!!");

        jPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Toolkit kit = Toolkit.getDefaultToolkit();
                Image img = kit.getImage("images//background.png");
                MediaTracker t = new MediaTracker(this);
                t.addImage(img, 1);
                while (true) {
                    try {
                        t.waitForID(1);
                        break;
                    } catch (Exception e) {
                    }
                }
                g.drawImage(img, 0, 0, 400, 400, null);
            }

        };
        Image img = Toolkit.getDefaultToolkit().getImage("images//logo.png");
        setIconImage(img);
        jPanel.setLayout(null);

        lblUserName = new JLabel("<html><b>UserName ");
        lblUserName.setForeground(Color.white);
        lblUserName.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        jPanel.add(lblUserName).setBounds(10, 90, 100, 20);

        txtUserName = new JTextField();
        txtUserName.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
        jPanel.add(txtUserName).setBounds(120, 90, 250, 25);

        lblPassword = new JLabel("<html><b>PassWord ");
        lblPassword.setForeground(Color.white);
        lblPassword.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        jPanel.add(lblPassword).setBounds(10, 140, 100, 20);

        txtPassword = new JTextField();
        txtPassword.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
        jPanel.add(txtPassword).setBounds(120, 140, 250, 25);

        lblPosition = new JLabel("<html><b>Position");
        lblPosition.setForeground(Color.white);
        lblPosition.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        jPanel.add(lblPosition).setBounds(10, 190, 100, 20);

        jcmbPosition = new JComboBox<>(position);
        jcmbPosition.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
        jPanel.add(jcmbPosition).setBounds(120, 190, 250, 25);

        btnSave = new JButton("Save");
        btnSave.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
        jPanel.add(btnSave).setBounds(20, 240, 90, 30);
        btnSave.addActionListener(this);

        btnClear = new JButton("Clear Text");
        btnClear.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
        jPanel.add(btnClear).setBounds(130, 240, 120, 30);
        btnClear.addActionListener(this);

        btnCancel = new JButton("Cancel");
        btnCancel.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
        jPanel.add(btnCancel).setBounds(270, 240, 100, 30);
        btnCancel.addActionListener(this);

        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
        jPanel.add(btnChangePassword).setBounds(70, 290, 300, 30);
        btnChangePassword.addActionListener(this);


        getContentPane().add(jPanel, BorderLayout.CENTER);

    }

    public static LoginPage getSwingInstance() {

        return new LoginPage();
    }

    public static void main(String[] args) {

        LoginPage.getSwingInstance().setVisible(true);

    }

    void clearText(){
       
        txtUserName.setText("");
        txtPassword.setText("");
        jcmbPosition.setSelectedIndex(0);
        
    }
    
    private void saveDatacomilation(){
        String username = txtUserName.getText(),password = txtPassword.getText(),position = jcmbPosition.getSelectedItem().toString();
        boolean isTextVerification = utils.loginClearTextVerification(username, password, position);
        try {
            boolean isExistInDatabase = utils.isExistInDatabase(username, password, position);
             System.out.println("Is Exist in Database" +isExistInDatabase);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if (isTextVerification){
             boolean isUserNamePasswordSame = utils.isUserNamePasswordSame(username, password);
        if (isTextVerification && isUserNamePasswordSame) {
            System.out.println("continue");
        }
        }
        
       
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (btnClear.equals(source)) {
           clearText();
            
        }
        if (source.equals(btnSave)) {
            saveDatacomilation();
        }
       
        
        
    }

}
