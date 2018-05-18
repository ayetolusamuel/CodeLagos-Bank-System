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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
   
    public CodeLagosBankSystem2() {
        getGUI();
    }
    private void getGUI() {
        	
		addWindowListener(new WindowAdapter()
			{
                                @Override
				public void windowClosing(WindowEvent e)
				{       
					
		LoginFirst loginFirst =new LoginFirst();
		loginFirst.setVisible(true);
		loginFirst.setDefaultCloseOperation(3);
				
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
//    public static void main(String[] args) {
//        CodeLagosBankSystem2 bankSystem2 = new CodeLagosBankSystem2();
//         bankSystem2.setLocation(300, 100);
//        bankSystem2.setResizable(false);
//        bankSystem2.setSize(550, 430); 
//        bankSystem2.setVisible(true);
//    }

   

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
            JOptionPane.showMessageDialog(null, "Loading..........\ncheck back");
        }
        if (source.equals(btnDepositCash)) {
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
