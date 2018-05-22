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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TransferFunds extends JFrame implements ActionListener{

    private JPanel jPanel;
    private JButton btnSearch;
    private JLabel lblSenderPhone;
    private JTextField txtSenderPhone;
    private JLabel lblReceiverPhone;
    private JTextField txtReceiverPhone;
    private JLabel lblAmountTransfer;
    private JTextField txtAmountTransfer;
    private JLabel lblRemainBalance;
    private JTextField txtRemainBalance;
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private JButton btnTransfer; 
    private JButton btnCheck;

    public TransferFunds() throws HeadlessException {
        displayGUI();
    }
    
    
    
    
    
    private void displayGUI() {
       
		addWindowListener(new WindowAdapter()
			{
                                @Override
				public void windowClosing(WindowEvent e)
				{       
//                                    CodeLagosBankSystem2 bankSystem2 = new CodeLagosBankSystem2();
//                                    bankSystem2.setLocation(300, 100);
//                                    bankSystem2.setResizable(false);
//                                    bankSystem2.setSize(550, 430); 
//                                    bankSystem2.setVisible(true);
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
       
        
          //System.out.print("1.\tOPEN ACCOUNT\n2.\tDEPOSIT CASH\n3.\tWITHDRAW CASH\n4.\tTRANSFER FUNDS\n5.\tCHECK BALANCE\n6.\tEXIT APPLICATION\n\n");
        JLabel lblWelcome = new JLabel("<html><b>Account Registration Portal");
        lblWelcome.setForeground(Color.MAGENTA);
        lblWelcome.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        jPanel.add(lblWelcome).setBounds(180,10,290,20);
        
        
        
        
        btnCheck = new JButton(new ImageIcon("images//sam.gif"));
        btnCheck.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        btnCheck.setToolTipText("Search customer with phone Number");
        jPanel.add(btnCheck).setBounds(480,70,30,30);
        btnCheck.addActionListener(this);
        
        lblSenderPhone = new JLabel("Phone Number <Sender > ");
        lblSenderPhone.setForeground(Color.white);
        lblSenderPhone.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        jPanel.add(lblSenderPhone).setBounds(10,60,180,50);
        
        txtSenderPhone = new JTextField();
        jPanel.add(txtSenderPhone).setBounds(160,75,300,20);
        txtSenderPhone.setText("08167137007");
        txtSenderPhone.addKeyListener(new KeyAdapter () {
                                @Override
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
								getToolkit().beep ();
								ke.consume ();}}}});
		
        
        
        lblReceiverPhone = new JLabel("Phone Number<Receiver> ");
        lblReceiverPhone.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        lblReceiverPhone.setForeground(Color.white);
        jPanel.add(lblReceiverPhone).setBounds(10,100,160,40);
        
        
        txtReceiverPhone = new JTextField();
        txtReceiverPhone.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        txtReceiverPhone.setForeground(Color.black);
        txtReceiverPhone.setText("08110993832");
        //txtReceiverPhone.setEditable(false);
          txtReceiverPhone.addKeyListener(new KeyAdapter () {
                                @Override
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
								getToolkit().beep ();
								ke.consume ();}}}});
		
        jPanel.add(txtReceiverPhone).setBounds(160,105,300,25);
        
       
        
        
        lblAmountTransfer = new JLabel("<html><b>Amount Transfer ");
        lblAmountTransfer.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblAmountTransfer.setForeground(Color.white);
        jPanel.add(lblAmountTransfer).setBounds(10,140,160,40);
        
        txtAmountTransfer = new JTextField();
        txtAmountTransfer.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        txtAmountTransfer.setForeground(Color.black);
        jPanel.add(txtAmountTransfer).setBounds(160,145,300,25);
       
        
        
        lblRemainBalance = new JLabel("<html><b>Remain Balance ");
        lblRemainBalance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblRemainBalance.setForeground(Color.white);
        jPanel.add(lblRemainBalance).setBounds(10,180,160,40);
        
        txtRemainBalance = new JTextField();
        txtRemainBalance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        txtRemainBalance.setForeground(Color.black);
        txtRemainBalance.setEditable(false);
        txtRemainBalance.addKeyListener(new KeyAdapter () {
                                @Override
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
								getToolkit().beep ();
								ke.consume ();}}}});
			
        jPanel.add(txtRemainBalance).setBounds(160,185,300,25);
        
       btnTransfer = new JButton(new ImageIcon("images//transfer.jpg"));
       btnTransfer.setFont(new Font("Times New Roman", Font.ITALIC, 15));
       btnTransfer.setToolTipText("Search customer with phone Number");
       jPanel.add(btnTransfer).setBounds(120,250,120,30);
       btnTransfer.addActionListener(this);
        
     
        
       // databaseConnection.open();
        
        getContentPane().add(jPanel, BorderLayout.CENTER);
       setInvisible();
        
    }
    
    
    private void setInvisible(){
        btnTransfer.setEnabled(false);
        txtAmountTransfer.setEnabled(false);
        lblAmountTransfer.setEnabled(false);
        txtRemainBalance.setEnabled(false);
        lblRemainBalance.setEnabled(false);
        txtAmountTransfer.setEditable(false);
    }
    
    private void setVisible(){
        btnTransfer.setEnabled(true);
        txtAmountTransfer.setEnabled(true);
        txtRemainBalance.setEnabled(true);
        txtAmountTransfer.setEditable(true);
    }

    
    private void verifyPhoneNumber(String senderNumber,String receiverNumber){
        try{
        String receiverPin = returnReceiverPin(receiverNumber);
        String senderPin = returnSenderPin(senderNumber);
      //  System.out.println("Sender Pin"+senderPin);
       // System.out.println("Receiver Number "+receiverNumber);
        if (senderNumber.length() !=11 || receiverNumber.length() != 11 ) {
            System.out.println("Invalid phone Number");
            setInvisible();
        }
        else if (senderNumber.equals(receiverNumber)){
            System.out.println("Sender number cant be same as Receiver Number");
            setInvisible();
        }
        else{
            if (senderPin != null && receiverPin !=null) {    //if record found setvisible true
                setVisible();
            }
            else{
             setInvisible();
            }
        
            
            
        }
        
    }catch(Exception ex){
            System.out.println("System Error!!!");
    }
    }
    
    private String returnSenderPin(String senderNumber){
        System.out.println("Reciver Number "+senderNumber);
        String pin = null;
        
        try {
          
            if (senderNumber.length() != 11) {
                JOptionPane.showMessageDialog(null, "Invalid phone number number!!!!");
                //System.out.println("Invalid phone number number!!!!");
            } else {

                String query = "SELECT * FROM accountopening where pnumber like '" + senderNumber+ "'";
                    databaseConnection.open();
                    
                ResultSet resultSet;
                Statement statement = databaseConnection.getStatement();       resultSet = statement.executeQuery(query);

                if (!resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "No Record found this user!!! "+senderNumber);
                    //clearText();

                } else {
                    pin = resultSet.getString("pin").trim();
                   
                     
                       System.out.println("Pin "+pin);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(OpenAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pin;

    }
    
  private String returnReceiverPin(String receiverNumber){
        System.out.println("Reciver Number "+receiverNumber);
        String pin = null;
        
        try {
          
            if (receiverNumber.length() != 11) {
                JOptionPane.showMessageDialog(null, "Invalid phone number number!!!!");
                //System.out.println("Invalid phone number number!!!!");
            } else {

                String query = "SELECT * FROM accountopening where pnumber like '" + receiverNumber+ "'";
                    databaseConnection.open();
                    
                ResultSet resultSet;
                Statement statement = databaseConnection.getStatement();
                resultSet = statement.executeQuery(query);

                if (!resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "No Record found this user!!!"+receiverNumber);
                    //clearText();

                } else {
                    pin = resultSet.getString("pin").trim();
                   
                     
                       System.out.println("Pin "+pin);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(OpenAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pin;

    }
    
   
  
  
  
  
  
  
  //btnTransfer 
  
  
  //check whether sender and receiver Number exist in the database
  
  private boolean senderAndReceiverVerification(String sender,String receiver){
      String senderPin,receiverPin;
      boolean flag;
      senderPin = returnSenderPin(sender);
      receiverPin = returnReceiverPin(receiver);
      
      if (senderPin != null && receiverPin != null) {
           System.out.println("Sender pin"+senderPin);
           System.out.println("Receiver Pin"+receiverPin);
           flag = true;
      }
      else{
          System.out.println("deposit");
           flag = false;
      }
      
     
//      if (senderPin) {
//          
//      }
      
      
      
      return flag;
  }
  
  
  
  
  
  
  
  
  
    
    
    private double returnBalanceFromDatabaseBaseNumber(String number){
        double balance = 0;
         try{
 
                   String query = "SELECT * FROM amountdeposited where pnumber like '"+number+"'";
                ResultSet resultSet;
                Statement statement = databaseConnection.getStatement();
                resultSet = statement.executeQuery(query);
             
                if (!resultSet.next()) {
                     
                   System.out.println("No data for this user yet!!!!!!!!!! <Receiver User");
                }
                else{
                     balance = Double.parseDouble(resultSet.getString("balance").trim());
                    System.out.println("Balance of the sender is "+balance);
                }
         }
         catch(Exception ex){
             
         }
        
        return balance;
    }
    
    
    
    private double calculateBalance(String number,double result){
        double preAmount = 0;
        
        result = returnBalanceFromDatabaseBaseNumber(number);
       double amountTransfer = Double.parseDouble(txtAmountTransfer.getText());
       double previousAmount;
       
        if (result>amountTransfer) {
             preAmount= returnPreAmount(amountTransfer, result);  //new balance
             previousAmount  = (preAmount - amountTransfer);
            System.out.println("Pre Amount "+previousAmount);
            System.out.println("Amount trnasfer "+amountTransfer);
            System.out.println("Amount after Transfer <Balance> "+preAmount);
            
            
            if (result == 0) {
                //save data
            }
            else{
                //update
            }
           
            System.out.println("Pre Amount "+pr);
            
            
            //update sender details after succesful transfer
            
        }
        else{
            System.out.println("Insufficient balance");
        }
         return result;
    }
    
    //dedute amt transfer from a balance  and return the result
    
    //private double return
    
    
    
    
    private double returnPreAmount(double amtTransfer, double balance){
        double preAmount;
        preAmount = balance -amtTransfer;
        return preAmount;
    }
        
         private double returnPreAmountBaseBalanceAfterTransaction(double balance,double amtToTransfer){
        double preAmountresultAfterTransfer =0;
        amtToTransfer = Double.parseDouble(txtAmountTransfer.getText());
        if (balance > amtToTransfer) {
             preAmountresultAfterTransfer  = balance - amtToTransfer;
        }
        
        return preAmountresultAfterTransfer;
    }
    
    private String returnBalanceBasePhone(String pNumber){
        
        String balance = null;
        
          try{
              System.out.println("P Number "+pNumber);
 
                   String query = "SELECT * FROM amountdeposited where pnumber like '"+pNumber+"'";
                   databaseConnection.open();
                ResultSet resultSet;
                Statement statement = databaseConnection.getStatement();
                resultSet = statement.executeQuery(query);
             
                if (!resultSet.next()) {
                    //JOptionPane.showMessageDialog(null, "No Record found this user!!!");
                    System.out.println("No data for this user yet!!!!!!!!!!");
                    //clearText();

                } else {
                   
                    balance = resultSet.getString("balance").trim();
                  
                    
                }
          }catch(Exception ex){
              
          }
        
        return balance;
    }
    
    
    
    public String returnReceiverAmountDetailsBasedOnPhone(String pNumber){
          String  preAmount = null;
         String balanceTransfer = txtAmountTransfer.getText();
         try{
 
                   String query = "SELECT * FROM amountdeposited where pnumber like '"+pNumber+"'";
                ResultSet resultSet;
                Statement statement = databaseConnection.getStatement();
                resultSet = statement.executeQuery(query);
             
                if (!resultSet.next()) {
                       String ReceiverNumber = txtReceiverPhone.getText();
                    //JOptionPane.showMessageDialog(null, "No Record found this user!!!");
                   // System.out.println("No data for this user yet!!!!!!!!!! <Receiver User");
                   
                    String pin = returnReceiverPin(ReceiverNumber);
                    
                    if (pin != null) {
                         saveToDatabase(pNumber, balanceTransfer);
                    }
                    
                    else{
                        System.out.println("Receiver did not exist in database");
                    }
      
                   
                  // save data

                } else {
                    //update
                    
                    
            }
     }
                catch(Exception ex){
         ex.printStackTrace();
     }
         return preAmount;
    }
    
    
    private void updateSenderAmountDetails(String number, String preAmount, String amountTransfer, String balanceaferTransfer){
        
         try{
             PreparedStatement ps;

            System.out.println("ID Number" + number);
             System.out.println("pre Amount " + preAmount);
            System.out.println("AmountDeposited " + amountTransfer);
            System.out.println("Balance " + balanceaferTransfer);

             databaseConnection.open();

             ps = databaseConnection.getConnection().prepareStatement("UPDATE amountdeposited SET pamount = ?, adeposited = ?, balance = ? WHERE pnumber = ?");

             ps.setString(1, String.valueOf(preAmount));
             ps.setString(2, String.valueOf(amountTransfer));
             ps.setString(3, String.valueOf(balanceaferTransfer));
             ps.setString(4, number);


		
	//ps.executeUpdate();
        
	            JOptionPane.showMessageDialog(null, "Account Updated Successfully!!!!");
        //btnSave.setEnabled(false);
        //txtAmountDeposited.setEditable(false);
       // clearText();
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
    }
    
    
  
    
    private void saveToDatabase(String ReceiverNumber,String custBalance){
            PreparedStatement ps;
         try {
      String preAmount = "0.0";
      String transfer = "0.0";
      String pin = returnReceiverPin(ReceiverNumber);
      
      custBalance = txtAmountTransfer.getText();
             System.out.println("Pin!!!!"+pin);
             System.out.println("Number "+ReceiverNumber);
        String sql = "INSERT INTO  amountdeposited(pnumber,pin,pamount,adeposited,balance)values(?,?,?,?,?)";
        databaseConnection.open();
        
	ps = databaseConnection.getConnection().prepareStatement(sql);
        ps.setString(1, ReceiverNumber);
        ps.setString(2, pin);
        ps.setString(3, preAmount);
	ps.setString(4, transfer);
	ps.setString(5, custBalance);
       
        
             System.out.println("Receiver Number "+ReceiverNumber);
              System.out.println("Receiver pin "+pin);
               System.out.println("Receiver pre Amount "+preAmount);
                System.out.println("Receiver tranfer "+transfer);
                 System.out.println("Receiver Balance "+custBalance);
	
			
	//ps.executeUpdate();
        
    JOptionPane.showMessageDialog(null, "Account Updated Successfully!!!!");
    btnTransfer.setEnabled(false);
   // clearText();
       
         } catch (Exception e) {
             //e.printStackTrace();
             System.err.println("Error in creating account!!!!!");
         }
         
        
         
         
         
     }
    
    
    
    
    private void updateReceiverAmountDetails(String number, String preAmount, String amountTransfer, String balanceaferTransfer){
        
         try{
             PreparedStatement ps;

            System.out.println("ID Number" + number);
             System.out.println("pre Amount " + preAmount);
            System.out.println("AmountDeposited " + amountTransfer);
            System.out.println("Balance " + balanceaferTransfer);

             databaseConnection.open();

             ps = databaseConnection.getConnection().prepareStatement("UPDATE amountdeposited SET pamount = ?, adeposited = ?, balance = ? WHERE pnumber = ?");

             ps.setString(1, String.valueOf(preAmount));
             ps.setString(2, String.valueOf(amountTransfer));
             ps.setString(3, String.valueOf(balanceaferTransfer));
             ps.setString(4, number);


		
	//ps.executeUpdate();
        
	            JOptionPane.showMessageDialog(null, "Account Updated Successfully!!!!");
        btnTransfer.setEnabled(false);
        txtAmountTransfer.setEditable(false);
       // clearText();
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
    }
    
    
    
    private void computeSenderTransfer(){
          String receiverNumber = txtReceiverPhone.getText();
            try{
            String senderNumber = txtSenderPhone.getText();
             //System.out.println("Sender "+senderNumber);
           String balance = returnBalanceBasePhone(senderNumber);
           // System.out.println("Sender Balance "+balance );
            
            double amtTransfer = Double.parseDouble(txtAmountTransfer.getText());    // amt transfer
            System.out.println("Amount Transfer "+txtAmountTransfer.getText());
            
            double balanceAfterTransfer = returnPreAmountBaseBalance(Double.parseDouble(balance));
            System.out.println("Balance After Transfer" +balanceAfterTransfer);   //balance after transfer
            double preAmountAfterTransfer = returnPreAmountBaseBalanceAfterTransaction(balanceAfterTransfer,amtTransfer) ;
          //  System.out.println("PreaAmount After Transfefr "+preAmountAfterTransfer);
            txtRemainBalance.setText(Double.toString(balanceAfterTransfer));
            
            if (preAmountAfterTransfer != 0 && balance != null) {
                System.out.println("########################################\n\n");
               // System.out.println("Pre Amount "+preAmountAfterTransfer);              //save this to preamount
              //  System.out.println("Transfer "+txtAmountTransfer.getText());
              //  System.out.println("balance After transfer "+balanceAfterTransfer);
              
              
              
                // updateSenderAmountDetails(senderNumber, Double.toString(preAmountAfterTransfer),Double.toString(amtTransfer),  Double.toString(balanceAfterTransfer));
           
                 
                 returnReceiverAmountDetailsBasedOnPhone(receiverNumber);
                 
                 
                 
                 
            }
            else{
                ///save the data
                
                
                txtRemainBalance.setText("Insufficient Funds");
                btnTransfer.setEnabled(false);
                System.out.println("insufficient Funds");
            }
            }
           catch(Exception ex){
               
           }
        }
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Object source = e.getSource();
        if (source.equals(btnCheck)) {
            String senderNumber = txtSenderPhone.getText();
            String receiverNumber = txtReceiverPhone.getText();
            verifyPhoneNumber(senderNumber, receiverNumber);
            
        }
        if (source.equals(btnTransfer)) {
           String senderNumber = txtSenderPhone.getText();
           String receiverNumber = txtReceiverPhone.getText();
            boolean comfirmSenderAndReceiver = senderAndReceiverVerification(senderNumber, receiverNumber);
            System.out.println("Comfirm "+comfirmSenderAndReceiver);
//            String balance = returnBalanceBasePhone(senderNumber);
//           
//            
//            //double balanceBaseSenderNumber = returnBalanceFromDatabaseBaseNumber(senderNumber);
//          try{
//           double calc = calculateBalance(senderNumber, Double.parseDouble(balance));
//              System.out.println("Calc "+calc);
//          }
//          catch(Exception ex){
//             // System.out.println("Deposit first!!! ");
//          }
//           
       }
    }

    public static void main(String[] args) {
        TransferFunds  transferFunds = new TransferFunds();
        transferFunds.setVisible(true);
        transferFunds.setSize(530,330);
        transferFunds.setLocation(300, 100);
    }
}
