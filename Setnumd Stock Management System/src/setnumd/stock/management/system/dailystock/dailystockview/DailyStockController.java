/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setnumd.stock.management.system.dailystock.dailystockview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class DailyStockController implements ActionListener{
    DailyStockView dailyStockView;
    DailyStockModel dailyStockModel;
 

    public DailyStockController(DailyStockView dailyStockView,DailyStockModel dailyStockModel) {
    this.dailyStockView = dailyStockView;
    this.dailyStockModel = dailyStockModel;
     actionListenerDailyStock(this);
    
    }
    private void validation(){
           
            String id = dailyStockView.txtPCode.getText();
            
            String idNum = dailyStockModel.validateId(id);
            dailyStockView.txtPCode.setText(idNum);
        //  JOptionPane.showMessageDialog(dailyStockView, dailyStockModel.showError(idNum));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object object = event.getSource();
        if (object.equals(dailyStockView.getBtnComfirm())) {
            validation();
           
          
        }
    
    }
    private void actionListenerDailyStock(ActionListener e){
        dailyStockView.getBtnSave().addActionListener(e);
        dailyStockView.getBtnComfirm().addActionListener(e);
        
    }
    
    
}
