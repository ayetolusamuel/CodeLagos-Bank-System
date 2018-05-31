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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class OpenAccount extends JFrame implements ActionListener{

    private JPanel jPanel;
    private JButton btnBackToMain,btnSave;
    private JLabel lblFirstName,lblLastName,lblPhoneNumber,lblAccountType,lblPin;
    private JTextField txtFirstName,txtLastName,txtPhoneNumber;
    JComboBox<String> jcmbAccountType;
    private String[] account = {"Saving","Current","Fixed"};
    private JLabel lblAccountNumber;
    private JTextField txtAccountNumber;
    private String accounNumber;
    private JButton btnClear;
    private JButton btnSearch;
    private JPasswordField txtPin;
    DatabaseConnection databaseConnection = new DatabaseConnection();
    private JButton btnCancel;

    public OpenAccount() throws HeadlessException {
        displayGUI();
    }
    
    
     private void displayGUI() {
       
		addWindowListener(new WindowAdapter()
			{
                                @Override
				public void windowClosing(WindowEvent e)
				{       
                                    mainPage();
				}
			});
		
        
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
        Image img=Toolkit.getDefaultToolkit().getImage("images//codelagos.jpg");
		setIconImage(img);
        jPanel.setLayout(null);
        setVisible(true);
        setLocation(300, 100);
        setResizable(false);
        setSize(550, 430);
        
          //System.out.print("1.\tOPEN ACCOUNT\n2.\tDEPOSIT CASH\n3.\tWITHDRAW CASH\n4.\tTRANSFER FUNDS\n5.\tCHECK BALANCE\n6.\tEXIT APPLICATION\n\n");
        JLabel lblWelcome = new JLabel("<html><b>Account Registration Portal");
        lblWelcome.setForeground(Color.MAGENTA);
        lblWelcome.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        jPanel.add(lblWelcome).setBounds(180,10,290,20);
        
        btnBackToMain = new JButton(new ImageIcon("images//backtomainpage1.jpg"));
        btnBackToMain.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        jPanel.add(btnBackToMain).setBounds(0,50,160,40);
        btnBackToMain.addActionListener(this);
        
        
        btnSearch = new JButton(new ImageIcon("images//search.jpg"));
        btnSearch.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        btnSearch.setToolTipText("Search customer with phone Number");
        jPanel.add(btnSearch).setBounds(480,50,60,50);
        btnSearch.addActionListener(this);
        
        lblPin = new JLabel("<html><b>Enter four digit pin....");
        lblPin.setForeground(Color.red);
        lblPin.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        jPanel.add(lblPin).setBounds(180,45,180,50);
        
        txtPin = new JPasswordField();
        jPanel.add(txtPin).setBounds(360,64,40,20);
        txtPin.addKeyListener(new KeyAdapter () {
                                @Override
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
								getToolkit().beep ();
								ke.consume ();}}}});
		
        
        
        lblFirstName = new JLabel("<html><b>First Name");
        lblFirstName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblFirstName.setForeground(Color.white);
        jPanel.add(lblFirstName).setBounds(10,100,160,40);
        
        
        txtFirstName = new JTextField();
        txtFirstName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        txtFirstName.setForeground(Color.black);
        jPanel.add(txtFirstName).setBounds(160,105,300,25);
        
       
        
        
        lblLastName = new JLabel("<html><b>Last Name|Surname");
        lblLastName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblLastName.setForeground(Color.white);
        jPanel.add(lblLastName).setBounds(10,140,160,40);
        
        txtLastName = new JTextField();
        txtLastName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        txtLastName.setForeground(Color.black);
        jPanel.add(txtLastName).setBounds(160,145,300,25);
       
        
        
        lblPhoneNumber = new JLabel("<html><b>Phone Number");
        lblPhoneNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblPhoneNumber.setForeground(Color.white);
        jPanel.add(lblPhoneNumber).setBounds(10,180,160,40);
        
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        txtPhoneNumber.setForeground(Color.black);
         txtPhoneNumber.addKeyListener(new KeyAdapter () {
                                @Override
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
								getToolkit().beep ();
								ke.consume ();}}}});
			
        jPanel.add(txtPhoneNumber).setBounds(160,185,300,25);
        
       
        
        
        
        lblAccountNumber = new JLabel("<html><b>Account Number");
        lblAccountNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblAccountNumber.setForeground(Color.white);
        jPanel.add(lblAccountNumber).setBounds(10,220,160,40);
        
        txtAccountNumber = new JTextField();
        txtAccountNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        txtAccountNumber.setEditable(false);
        txtAccountNumber.setForeground(Color.black);
        jPanel.add(txtAccountNumber).setBounds(160,225,300,25);
       
      
        lblAccountType = new JLabel("<html><b>Account Type");
        lblAccountType.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblAccountType.setForeground(Color.white);
        jPanel.add(lblAccountType).setBounds(10,260,160,40);
       
        
        jcmbAccountType = new JComboBox<>(account);
        jcmbAccountType.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        jcmbAccountType.setForeground(Color.MAGENTA);
        jPanel.add(jcmbAccountType).setBounds(160,265,160,25);
       
        
        btnSave = new JButton("Save");
        btnSave.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        btnSave.setForeground(Color.MAGENTA);
        jPanel.add(btnSave).setBounds(100,315,120,25);
        btnSave.addActionListener(this);
        
        btnClear = new JButton("Clear Fields");
        btnClear.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        btnClear.setForeground(Color.MAGENTA);
        jPanel.add(btnClear).setBounds(250,315,120,25);
        btnClear.addActionListener(this);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        btnCancel.setForeground(Color.MAGENTA);
        jPanel.add(btnCancel).setBounds(390,315,120,25);
        btnCancel.addActionListener(this);
        
        
        databaseConnection.open();
        
        getContentPane().add(jPanel, BorderLayout.CENTER);
    }

     
    
     
     
     //generate account Number
     private void generateAccountNumber(){
             long acountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;  //generate 10 digit Number
             String accountNumberToString = Long.toString(acountNumber);
             txtAccountNumber.setText(accountNumberToString);
             JOptionPane.showMessageDialog(null, "<html><i>Your Account Number is : <b>"+accountNumberToString);
             
     }
     
     private boolean verifyPhoneNumber(String number){
         boolean flag = true;
         if (number.length() != 11) {
             JOptionPane.showMessageDialog(null, "Invalid Number,must be 11 digit");
           flag = false;
         }
            return flag;
     }
     
    private boolean isFieldEmpty() {
        boolean flag = true;
        String fName, lastName, number,pin;
        fName = txtFirstName.getText();
        lastName = txtLastName.getText();
        number = txtPhoneNumber.getText();
        char[] pinChar = txtPin.getPassword();
        pin= new String(pinChar);
        
        if (fName.length() == 0 || lastName.length() == 0 || number.length() == 0 || pin.length() ==0) {
            JOptionPane.showMessageDialog(null, "Fill all editable fields");
            
            flag = false;
        }
        return flag;
    }
    
    private void userInDatabase(){
        boolean flag;
          try {
            String query = "SELECT * FROM accountopening order by fname";
		
            ResultSet resultSet;
            Statement statement = databaseConnection.getStatement();
            resultSet = statement.executeQuery(query);
            
            if (!resultSet.next() ) {
                System.out.println("No data");
         
            } else{
            
             // System.out.println("continue");
              String firstName,lastName,phoneNumber,accountType;
              firstName = txtFirstName.getText();
              lastName = txtLastName.getText();
              phoneNumber = txtPhoneNumber.getText();
              accountType = jcmbAccountType.getSelectedItem().toString();
             // System.out.println("fname"+firstName +"lname "+lastName+ "phone number "+phoneNumber+"account type "+accountType);  
              
              
               String fname = resultSet.getString("fname").trim();
               String lname = resultSet.getString("lname").trim();
               String atype = resultSet.getString("atype").trim();
               String num = resultSet.getString("pnumber").trim();
               String pin = resultSet.getString("pin").trim();
              
              // System.out.println("\n\n");
              // System.out.println("fName "+fname + "lat "+lname+ "atype "+atype+ "num "+num);
                if (firstName.equalsIgnoreCase(fname) && lastName.equalsIgnoreCase(lname) && phoneNumber.equalsIgnoreCase(num) && accountType.equalsIgnoreCase(atype)) {
                      JOptionPane.showMessageDialog(null, "User already exit in database");
                      clearText();
                    
                }
                else{
                      generateAccountNumber();
                    insertToDatabase();
                    clearText();
                }}
               
             
            }
            
          catch (SQLException ex) {
            Logger.getLogger(OpenAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
    }
    public void mainPage(){
        setVisible(false);
         CodeLagosBankSystem2 bankSystem2 = new CodeLagosBankSystem2();
         bankSystem2.setLocation(300, 100);
        bankSystem2.setResizable(false);
        bankSystem2.setSize(550, 430); 
        bankSystem2.setVisible(true);
    }
    
    
     private void saveToDatabaseVerification(){
         String number = txtPhoneNumber.getText();
         //verify if the user already exist in databse!!!!!!!!!!!
         if (isFieldEmpty() && verifyPhoneNumber(number) ) {
             userInDatabase();
          
         }
//         else{
//             //save to database
//               generateAccountNumber();
//                    insertToDatabase();
//                    clearText();
//         }
        
     }
     private void clearText(){
         txtFirstName.setText("");
         txtLastName.setText("");
         txtPhoneNumber.setText("");
         txtAccountNumber.setText("");
         txtPin.setText("");
     }
     
      private boolean saveCopyToAmountDepositedTable(String number,String pin){
         PreparedStatement ps;
         boolean flag;
         try {
                     
      String pAmount = "0.0",aDeposited = "0.0",balance = "0.0";
      
            
        String sql = "INSERT INTO  amountdeposited(pnumber,pin,pamount,adeposited,balance)values(?,?,?,?,?)";
        databaseConnection.open();
        
	ps = databaseConnection.getConnection().prepareStatement(sql);
        ps.setString(1, number);
	ps.setString(2, pin);
	ps.setString(3, pAmount);
	ps.setString(4, aDeposited);
	ps.setString(5, balance);
        
        ps.executeUpdate();
        flag = true;
        
         }
      catch(Exception ex){
          
        flag = false;  
        ex.printStackTrace();
      }
      return flag;
      }
     
     private void insertToDatabase(){
         PreparedStatement ps;
         try {
                     char[] pinChar = txtPin.getPassword();
        String fName, lastName, number, aNumber,aType,pin;
        fName = txtFirstName.getText(); lastName = txtLastName.getText(); number = txtPhoneNumber.getText();
        aNumber = txtAccountNumber.getText(); aType = jcmbAccountType.getSelectedItem().toString();pin = new String(pinChar);
            
        String sql = "INSERT INTO  accountopening(fname,lname,pnumber,anumber,atype,pin)values(?,?,?,?,?,?)";
        databaseConnection.open();
        
	ps = databaseConnection.getConnection().prepareStatement(sql);
        ps.setString(1, fName);
	ps.setString(2, lastName);
	ps.setString(3, number);
	ps.setString(4, aNumber);
	ps.setString(5, aType);
        ps.setString(6, pin);
			//save copy to amount deposited, number,pin,preAmount,adepost,balance
                        boolean comfirm = saveCopyToAmountDepositedTable(number, pin);
                        System.out.println("Comfirm "+comfirm);
                        if (comfirm) {
                 ps.executeUpdate();
        
                JOptionPane.showMessageDialog(null, "Account Created Successfully!!!!");
             }
	
       
         } catch (Exception e) {
             //e.printStackTrace();
             System.err.println("Error in creating account!!!!!");
         }
         
        
     }
     
     
     private void comfirmUserFromDatabase(String number){
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
               String anumber = resultSet.getString("anumber").trim();
               String atype = resultSet.getString("atype").trim();
               String pin = resultSet.getString("pin").trim();
              
               
               displayUserSearchResult(fname, lname, anumber, atype,pin);
                
          
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OpenAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
		
     }
     
     
     private void displayUserSearchResult(String fname,String lname,String anumber,String atype,String pin){
            JOptionPane.showMessageDialog(null, "Record Found for this user ");
                JOptionPane.showMessageDialog(null, "<html><i>  First Name : "+fname+
                                                              "\nLast Name :"+lname+
                                                              "\nAccount Number :"+anumber+
                                                               "\nAccount Type :"+atype+
                                                               "\nPin Number :"+pin);
  }
     
     private void searchUser(){
      String option = JOptionPane.showInputDialog(rootPane, "Enter Phone Number","Search User via Phone Number",JOptionPane.DEFAULT_OPTION);
      try{
          if (!option.equals(JOptionPane.OK_OPTION)){
            comfirmUserFromDatabase(option);
             
         }}
      catch(Exception ex){
      }
      }
     
     
     private void openMainPage(){
           setVisible(false);
            CodeLagosBankSystem2 bankSystem2 = new CodeLagosBankSystem2();
            bankSystem2.setLocation(300, 100);
            bankSystem2.setResizable(false);
            bankSystem2.setSize(550, 430); 
            bankSystem2.setVisible(true);
     }
     
    @Override
    public void actionPerformed(ActionEvent event) {
       
    Object source = event.getSource();
        if (source.equals(btnBackToMain)) {
            openMainPage();
        }
        if (source.equals(btnSave)) {
         saveToDatabaseVerification();
        }
        if (source.equals(btnSearch)) {
            searchUser();
            
        }
        if (source.equals(btnCancel)) {
            mainPage();
        }
        if (source.equals(btnClear)) {
            clearText();
        }
    
    
    
    
}
    
    public static void main(String[] args) {
        OpenAccount openAccount = new OpenAccount();
            openAccount.setLocation(300, 100);
             openAccount.setResizable(false);
              openAccount.  setSize(550, 390); 
              openAccount.setVisible(true);
    }
}