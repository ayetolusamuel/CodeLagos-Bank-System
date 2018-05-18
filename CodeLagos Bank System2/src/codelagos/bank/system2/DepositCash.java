/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelagos.bank.system2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class DepositCash extends JFrame implements ActionListener{
       private JPanel  jPanel;
       private JLabel lblPhoneNumber,lblFullName,lblPreviousAmount,lblAmountDeposited,lblBalance;
       private  JTextField txtPhoneNumber,txtFullName, txtPreviousAmount,txtAmountDeposited,txtBalance;
       private JButton btnCheck,btnSave;
       DatabaseConnection databaseConnection = new DatabaseConnection();
    public DepositCash() throws HeadlessException {
        databaseConnection.open();
        displayGUI();
        
    }
    
    private void displayGUI(){
         jPanel = new JPanel(){
                @Override
             public void paintComponent(Graphics g)
			{
				                        Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//background.jpg");
				                        MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,600,600,null);
			}
          
        };
        jPanel.setLayout(null);
        lblPhoneNumber = new JLabel("Phone Number ");
        jPanel.add(lblPhoneNumber).setBounds(15, 50, 100, 20);
        lblPhoneNumber.setForeground(Color.white);
        lblPhoneNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        
        txtPhoneNumber = new JTextField();
         txtPhoneNumber.addKeyListener(new KeyAdapter () {
                                @Override
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
								getToolkit().beep ();
								ke.consume ();}}}});
	
        jPanel.add(txtPhoneNumber).setBounds(150, 51, 250, 20);
        
        btnCheck = new JButton(new ImageIcon("images//sam.gif"));
        btnCheck.addActionListener(this);
        jPanel.add(btnCheck).setBounds(410,50,38,25);
        
        
        
         lblFullName = new JLabel("Full Name ");
        jPanel.add(lblFullName).setBounds(15, 90, 100, 20);
        lblFullName.setForeground(Color.white);
        lblFullName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        
        txtFullName = new JTextField();
        txtFullName.setEditable(false);
         txtFullName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        jPanel.add(txtFullName).setBounds(150, 91, 250, 20);

         lblPreviousAmount = new JLabel("Previous Balance ");
        jPanel.add(lblPreviousAmount).setBounds(15, 130, 140, 20);
        lblPreviousAmount.setForeground(Color.white);
        lblPreviousAmount.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        
        txtPreviousAmount = new JTextField();
        jPanel.add(txtPreviousAmount).setBounds(150, 131, 250, 20);

         lblAmountDeposited = new JLabel("Amount Deposited ");
        jPanel.add(lblAmountDeposited).setBounds(15, 170, 140, 20);
        lblAmountDeposited.setForeground(Color.white);
        lblAmountDeposited.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        
        txtAmountDeposited = new JTextField();
        jPanel.add(txtAmountDeposited).setBounds(150, 171, 250, 20);

         lblBalance = new JLabel("Balance ");
        jPanel.add(lblBalance).setBounds(15, 210, 100, 20);
        lblBalance.setForeground(Color.white);
        lblBalance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        
        txtBalance = new JTextField();
        jPanel.add(txtBalance).setBounds(150, 211, 250, 20);
        
        btnSave = new JButton("<html><b>Save to Database");
        btnSave.setForeground(Color.MAGENTA);
        btnSave.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        jPanel.add(btnSave).setBounds(30,260,150,25);

         setInvisible();
        
        getContentPane().add(jPanel,BorderLayout.CENTER);
        
    }
    
    private void setInvisible(){
        lblFullName.setEnabled(false);
        txtFullName.setEnabled(false);
        lblPreviousAmount.setEnabled(false);
        txtPreviousAmount.setEditable(false);
        lblAmountDeposited.setEnabled(false);
        txtAmountDeposited.setEditable(false);
        lblBalance.setEnabled(false);
        txtBalance.setEditable(false);
        btnSave.setEnabled(false);
        
        
    }
    
    private void setVisible(){
        lblFullName.setEnabled(true);
        txtFullName.setEnabled(true);
        lblPreviousAmount.setEnabled(true);
        txtPreviousAmount.setEditable(false);
        lblAmountDeposited.setEnabled(true);
        txtAmountDeposited.setEditable(true);
        lblBalance.setEnabled(true);
        txtBalance.setEditable(false);
        btnSave.setEnabled(true);
        
        
    }
    
    
    private String fetchDataBaseOnPhoneNumber(String number){
        String result = null;
          try {
            String query = "SELECT * FROM accountopening where pnumber like '" +number+"'";
		
            ResultSet resultSet;
            Statement statement = databaseConnection.getStatement();
            resultSet = statement.executeQuery(query);
            
            if (!resultSet.next() ) {
                JOptionPane.showMessageDialog(null, "No Record found this user!!!");
           
            } 
            else{
               String fname = resultSet.getString("fname").trim();
               String lname = resultSet.getString("lname").trim();
               
                result = lname +" "+fname;
               
               
                
          
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OpenAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
	return result;	
     }
     
     
   
    
     
     
    public static void main(String[] args) {
        DepositCash cash = new DepositCash();
        cash.setVisible(true);
        cash.setSize(500,500);
        cash.setLocation(300,100);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source =  event.getSource();
        if (source.equals(btnCheck)) {
            try{
            String number,result;
            number = txtPhoneNumber.getText();
            result = fetchDataBaseOnPhoneNumber(number);
            if (result != null) {
                txtFullName.setText(result);
                setVisible();
            }
                
            }
        catch(Exception ex){
                
                }
        }
     }

  
    
    
    
    
}
