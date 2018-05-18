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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private double result;
    private String preAmount;
    
    private String amtDeposited;
    private String customerBalance;
    public DepositCash() throws HeadlessException {
        databaseConnection.open();
        displayGUI();
        addWindowListener(new WindowAdapter()
			{
                                @Override
				public void windowClosing(WindowEvent e)
				{       
                                    CodeLagosBankSystem2 bankSystem2 = new CodeLagosBankSystem2();
                                    bankSystem2.setLocation(300, 100);
                                    bankSystem2.setResizable(false);
                                    bankSystem2.setSize(550, 430); 
                                    bankSystem2.setVisible(true);
				}
			});
		
        
    }
    
    private void displayGUI(){
        setResizable(false);
        setTitle("Deposit Cash!!!!!!!!!!!");
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
        txtPhoneNumber.setText("08167137007");
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
        txtPreviousAmount.setText("0.00");
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
        btnSave.addActionListener(this);

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
          
            if (number.length() != 11) {
                JOptionPane.showMessageDialog(null, "Invalid phone number number!!!!");
                //System.out.println("Invalid phone number number!!!!");
            } else {

                String query = "SELECT * FROM accountopening where pnumber like '" + number + "'";

                ResultSet resultSet;
                Statement statement = databaseConnection.getStatement();
                resultSet = statement.executeQuery(query);

                if (!resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "No Record found this user!!!");
                    clearText();

                } else {
                    String fname = resultSet.getString("fname").trim();
                    String lname = resultSet.getString("lname").trim();

                    result = lname + " " + fname;

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(OpenAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }
    
     
     private void clearText(){
         txtFullName.setText("");
         txtAmountDeposited.setText("");
         txtPreviousAmount.setText("");
         txtPhoneNumber.setText("");
         txtBalance.setText("");
    }
     
     private String returnUserAmountBasedOnPhone(String pNumber){
         String result;
         String previousAmount = txtPreviousAmount.getText();
         try{
//             "Select * from generatorNepa where site like '"
//                     + d
//                     + "' AND nepaonofdate between '"
//                     + startDate
//                     + "' AND '"
//                     + stopDate
//                     + "' order by nepaonofdate  "
//             
             
               // String query = "SELECT * FROM amountdeposited where pnumber like '" + pNumber + "'AND pin like '"+pin+"'";
                     String query = "SELECT * FROM amountdeposited where pnumber like '"+pNumber+"'";
                ResultSet resultSet;
                Statement statement = databaseConnection.getStatement();
                resultSet = statement.executeQuery(query);
             
                if (!resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "No Record found this user!!!");
                    clearText();

                } else {
                    String  preAmount;
                    preAmount = resultSet.getString("pamount").trim();
                  //  System.out.println("Pre Amount "+preAmount);
                    
                    
//                  int  preAmountInt = Integer.parseInt(preAmount);
                  
                  
                   String amtDeposited = resultSet.getString("adeposited").trim();
                   String customerBalance = resultSet.getString("balance").trim();
                    
                   double preAmountDouble = Double.parseDouble(preAmount);
                   double amtDepositedtDouble = Double.parseDouble(amtDeposited);
                   double customerBalanceDouble = Double.parseDouble(customerBalance);
                  if (!preAmount.equals("0") ) {
                    
                  
                   
                   updateToDatabase(preAmountDouble, amtDepositedtDouble, customerBalanceDouble);
                   clearText();

                }
                  else{
                     updateToDatabase(preAmountDouble, amtDepositedtDouble, customerBalanceDouble);
                     clearText();
   
                  }
                
                   
                
                }
              

     }catch(Exception ex){
         ex.printStackTrace();
     }
         return preAmount;
     }
     
     private double balanceCompute(double previousAmount,double amountDeposited ){
         double result = previousAmount + amountDeposited;
         return result;
     }
     
     private double returnBalanceFromDatabase(String pNumber ){
           
         try{
         String query = "SELECT * FROM amountdeposited where pnumber like '"+pNumber+"'";
                ResultSet resultSet;
                Statement statement = databaseConnection.getStatement();
                resultSet = statement.executeQuery(query);

                if (!resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "No Record found this user!!!");
                    clearText();

                } else {
                   String balance = resultSet.getString("balance").trim();
                    
                   result = Double.parseDouble(balance);
                   //System.out.println("Balnce "+balance);

                    

                }
              

     }catch(Exception ex){
         
     }
     
         
    
        
         return result;
     }
     
     private void saveToDatabase(){
            PreparedStatement ps;
         try {
        String pAmount, aDeposited,custBalance;
      pAmount = txtPreviousAmount.getText();
      aDeposited = txtAmountDeposited.getText();
      custBalance = txtBalance.getText();
        
        String sql = "INSERT INTO  amountdeposited(pamount,adeposited,balance)values(?,?,?)";
        databaseConnection.open();
        
	ps = databaseConnection.getConnection().prepareStatement(sql);
        ps.setString(1, pAmount);
	ps.setString(2, aDeposited);
	ps.setString(3, custBalance);
	
			
	ps.executeUpdate();
        
    JOptionPane.showMessageDialog(null, "Account Created Successfully!!!!");
       
         } catch (Exception e) {
             //e.printStackTrace();
             System.err.println("Error in creating account!!!!!");
         }
         
        
         
         
         
     }
     
    private void updateToDatabase(double pAmount,double pAmountDeposited,double balance){
        
         pAmount = Double.parseDouble(txtPreviousAmount.getText());
         pAmountDeposited = Double.parseDouble(txtAmountDeposited.getText());
         balance = Double.parseDouble(txtBalance.getText());
         String pNumber = txtPhoneNumber.getText();
        
         try{
             PreparedStatement ps;

           //  System.out.println("ID Number" + pNumber);
           //  System.out.println("pAmount " + pAmount);
           //  System.out.println("AmountDeposited " + pAmountDeposited);
            // System.out.println("Balance " + balance);

             databaseConnection.open();

             ps = databaseConnection.getConnection().prepareStatement("UPDATE amountdeposited SET pamount = ?, adeposited = ?, balance = ? WHERE pnumber = ?");

             ps.setString(1, String.valueOf(pAmount));
             ps.setString(2, String.valueOf(pAmountDeposited));
             ps.setString(3, String.valueOf(balance));
             ps.setString(4, pNumber);


		
	ps.executeUpdate();
        
	JOptionPane.showMessageDialog(null, "Account Updated Successfully!!!!");
        btnSave.setEnabled(false);
        txtAmountDeposited.setEditable(false);
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
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
            String number = null,result;
            try{
            
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
        
        if (source.equals(btnSave)) {
            
           String balanceToDatabase;
           String  pNumber = txtPhoneNumber.getText();
           String amountDeposited = txtAmountDeposited.getText();
           String pAmount = txtPreviousAmount.getText();
           String custBalance = txtBalance.getText();
           String aDeposited = txtAmountDeposited.getText();
            try{
                
             double returnBalance = returnBalanceFromDatabase(pNumber);
                //System.out.println("returnbalance "+returnBalance);
            if ( returnBalance != 0) {
                txtPreviousAmount.setText(Double.toString(returnBalance));
                double balance = returnBalanceFromDatabase(pNumber);
                double  totalBalance = balanceCompute(balance, Double.parseDouble(amountDeposited));
                txtBalance.setText(Double.toString(totalBalance));
                }
            else{
                
              txtPreviousAmount.setText("0.00");
              String previousAmount = txtPreviousAmount.getText();
              double preAmountDouble = Double.parseDouble(previousAmount);
              double  totalBalance = balanceCompute(preAmountDouble, Double.parseDouble(amountDeposited));
              txtBalance.setText(Double.toString(totalBalance));
                
                
            }
            returnUserAmountBasedOnPhone(pNumber);
            
               
        }catch(Exception ex){
           // ex.printStackTrace();
        }
            
        }
    
    
    
    }}
