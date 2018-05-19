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
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
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
public class CodeLagosBankSystem2 extends JFrame implements ActionListener{

    private JPanel jPanel;
    private JButton btnOpenAccount;
    private JButton btnDepositCash;
    private JButton btnTransferFunds;
    private JButton btnWithdrawCash;
    private JButton btnCheckBalance;
    DatabaseConnection databaseConnection = new DatabaseConnection();
   
    public CodeLagosBankSystem2() {
        getGUI();
    }
    private void getGUI() {
        	
		addWindowListener(new WindowAdapter()
			{
                                @Override
				public void windowClosing(WindowEvent e)
				{       
					
//		LoginFirst loginFirst =new LoginFirst();
//		loginFirst.setVisible(true);
//		loginFirst.setDefaultCloseOperation(3);
				
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
        jPanel.setLayout(null);
       
          //System.out.print("1.\tOPEN ACCOUNT\n2.\tDEPOSIT CASH\n3.\tWITHDRAW CASH\n4.\tTRANSFER FUNDS\n5.\tCHECK BALANCE\n6.\tEXIT APPLICATION\n\n");
        JLabel lblWelcome = new JLabel("WELCOME TO CODE LAGOS BANK PLC");
        lblWelcome.setForeground(Color.white);
        lblWelcome.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        jPanel.add(lblWelcome).setBounds(120,10,290,20);
        
        
        
        JLabel lblMenuList = new JLabel("Menu List");
        lblMenuList.setForeground(Color.PINK);
        lblMenuList.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        jPanel.add(lblMenuList).setBounds(180,60,290,30);
        
        
       
        btnOpenAccount = new JButton("Open Account");
        btnOpenAccount.setToolTipText("Click to open account with us!!!");
        btnOpenAccount.setForeground(Color.red);
        jPanel.add(btnOpenAccount).setBounds(10,100,130,100);
        btnOpenAccount.addActionListener(this);
        
        btnDepositCash = new JButton("Deposit Cash");
        btnDepositCash.setToolTipText("deposit cash to your account!!!");
        btnDepositCash.setForeground(Color.red);
        jPanel.add(btnDepositCash).setBounds(400,100,130,100);
        btnDepositCash.addActionListener(this);
        
        btnWithdrawCash = new JButton("Withdraw Cash");
        btnWithdrawCash.setToolTipText("Feel free to withdraw from your account!!!!!!!!!");
        btnWithdrawCash.setForeground(Color.red);
        jPanel.add(btnWithdrawCash).setBounds(10,220,130,100);
        btnWithdrawCash.addActionListener(this);
        
        btnTransferFunds = new JButton("Transfer Funds");
        btnTransferFunds.setToolTipText("Transfer Funds to your Love one!!!!!!!!!");
        btnTransferFunds.setForeground(Color.red);
        jPanel.add(btnTransferFunds).setBounds(400,220,130,100);
        btnTransferFunds.addActionListener(this);
//        
        btnCheckBalance = new JButton("check Balance");
        btnCheckBalance.setToolTipText("Feel free to check your Balance!!!!!!!!!!!");
        btnCheckBalance.setForeground(Color.red);
        jPanel.add(btnCheckBalance).setBounds(10,340,510,50);
        btnCheckBalance.addActionListener(this);
//      
//        
//        
        
        
        
        
        getContentPane().add(jPanel, BorderLayout.CENTER);
    

    }
    public static void main(String[] args) {
        CodeLagosBankSystem2 bankSystem2 = new CodeLagosBankSystem2();
         bankSystem2.setLocation(300, 100);
        bankSystem2.setResizable(false);
        bankSystem2.setSize(550, 430); 
        bankSystem2.setVisible(true);
    }

   
    /////////////////////////////////////////////////////////
    private void popUp(){
        JTextField txtPhoneNumber = new JTextField();
        JTextField txtpin = new JTextField();
        txtPhoneNumber.setToolTipText("Enter your phone Here!!!!!!!!!!!!");
          txtPhoneNumber.addKeyListener(new KeyAdapter () {
                                @Override
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
								getToolkit().beep ();
								ke.consume ();}}}});
		
        
            txtpin.addKeyListener(new KeyAdapter () {
                                @Override
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
								getToolkit().beep ();
								ke.consume ();}}}});
		
        
        txtpin.setToolTipText("Enter your four digits pin number!!!!!!!!!!!");
        Object[] message = {"Phone Number", txtPhoneNumber, "Pin Number",txtpin };
	
        
   Icon error=new ImageIcon("images//info.jpg");
    //JOptionPane.showMessageDialog(this,"<html><font size=4 color=red>Invalid Password \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
				
        
        int option = JOptionPane.showConfirmDialog(null, message, "Customer Information",JOptionPane.PLAIN_MESSAGE,JOptionPane.INFORMATION_MESSAGE,error);
        
        if (option == JOptionPane.OK_OPTION) {
            String phoneNumber = txtPhoneNumber.getText();
            String pin = txtpin.getText();
        
            // int pin = Integer.parseInt(txtpin.getText());
           try{
            
            
               
                int pinInt = Integer.parseInt(txtpin.getText());
            
             if ((phoneNumber.length() != 0) && (pin.length() !=0)) {
			returnDataBasePhoneNumberPin(phoneNumber, pinInt);
			//System.out.println("Setonji");
			
		
             }else{
                    System.out.println("Exit");
                }
             
    }
            catch(Exception ex){
                
            }
        }}
    
    private void returnDataBasePhoneNumberPin(String number,int pin){
               try{   
                   
                    //String query = "SELECT * FROM amountdeposited where pnumber like '" + number + "'AND pin  '"+pin+"'";
                   String query = "SELECT * FROM amountdeposited where pin like '" + pin + "' AND pnumber like '"+number+"'"; 
                    ResultSet resultSet;
                    databaseConnection.open();
                    
                Statement statement = databaseConnection.getStatement();
                resultSet = statement.executeQuery(query);
                   
                if (!resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "No Record found this user!!!");
                    //clearText();

                } else {
                    String  preAmount;
                    preAmount = resultSet.getString("pamount").trim();
                   String amtDeposited = resultSet.getString("adeposited").trim();
                   String customerBalance = resultSet.getString("balance").trim();
                    
                   JOptionPane.showMessageDialog(null, "<html><i>Welcome "+number+"\n<html><i>Your Balance is \""+customerBalance+"\"");
                  // System.out.println("Pre Amount "+preAmount);
//                   double preAmountDouble = Double.parseDouble(preAmount);
//                   double amtDepositedtDouble = Double.parseDouble(amtDeposited);
//                   double customerBalanceDouble = Double.parseDouble(customerBalance);
//		
                }
                }catch(Exception ex){
                    
                }
        
    }
    
  
    
    ////////////////////////////////
    
    
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source.equals(btnOpenAccount)) {
            setVisible(false);
            OpenAccount openAccount = new OpenAccount();
            openAccount.setLocation(300, 100);
             openAccount.setResizable(false);
              openAccount.  setSize(550, 430); 
              openAccount.setVisible(true);
          
        }
        if (source.equals(btnCheckBalance)) {
        popUp();
        
        
        }
        if (source.equals(btnDepositCash)) {
            setVisible(false);
            DepositCash cash = new DepositCash();
        cash.setVisible(true);
        cash.setSize(500,500);
        cash.setLocation(300,100);
        }
        if (source.equals(btnTransferFunds)) {
            JOptionPane.showMessageDialog(null, "Loading..........\ncheck back");
        }
        if (source.equals(btnWithdrawCash)) {
            JOptionPane.showMessageDialog(null, "Loading..........\ncheck back");
        }
        }

    
}
