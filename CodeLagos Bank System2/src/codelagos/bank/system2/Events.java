/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelagos.bank.system2;

/**
 *
 * @author DELL
 */
public class Events {
    
    
    public void depositCashWindowOpen(){
        DepositCash cash = new DepositCash();
        cash.setVisible(true);
        cash.setSize(500,330);
        cash.setLocation(300,100);
    }
    
    public void transferFundsWindowOpen(){
        TransferFunds  transferFunds = new TransferFunds();
        transferFunds.setVisible(true);
        transferFunds.setSize(530,320);
        transferFunds.setLocation(300, 100);
    }
    
    public void homePageWindowOpen(){
        CodeLagosBankSystem2 bankSystem2 = new CodeLagosBankSystem2();
        bankSystem2.setLocation(300, 100);
        bankSystem2.setResizable(false);
        bankSystem2.setSize(550, 430); 
        bankSystem2.setVisible(true);
    }
    
    public void openAccountWindowOpen(){
         OpenAccount openAccount = new OpenAccount();
         openAccount.setLocation(300, 100);
         openAccount.setResizable(false);
         openAccount.  setSize(550, 390); 
         openAccount.setVisible(true);
    }
    public  void loginWindowOpen(){
        LoginFirst loginFirst =new LoginFirst();
        loginFirst.setVisible(true);
	loginFirst.setDefaultCloseOperation(3);
    }
    
    
    
    
}
