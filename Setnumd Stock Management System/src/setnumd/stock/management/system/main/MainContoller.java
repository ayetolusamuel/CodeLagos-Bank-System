/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setnumd.stock.management.system.main;

import com.sun.glass.ui.Cursor;
import com.sun.org.apache.xerces.internal.util.DOMUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import setnumd.stock.management.system.dailystock.dailystockview.DailyStockView;

/**
 *
 * @author DELL
 */
public class MainContoller implements ActionListener{
    MainView mainView;
    MainModel mainModel;
    public MainContoller(MainModel mainModel,MainView mainView) {
        
        this.mainModel = mainModel;
        this.mainView = mainView;
        myListener(this);
        
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if (mainView.getBtnDailyStock().equals(object)) {
            mainView.setVisible(false);
            DailyStockView dailyStockView = new DailyStockView();
            dailyStockView.setVisible(true);
            
            
       }
         if (mainView.getBtnNewUpdate().equals(object)) {
            System.out.println("new Update");
            
       }
          if (mainView.getBtnProductList().equals(object)) {
            System.out.println("Product List");
            
       }
           if (mainView.getBtnReturnUpdate().equals(object)) {
            System.out.println("Return Update");
            
       }
            if (mainView.getBtnUpdateNewStock().equals(object)) {
            System.out.println("Update New Products");
            
       }
        
 
    
    }

    private void myListener(MainContoller listener) {
        mainView.getBtnDailyStock().addActionListener(listener);
         mainView.getBtnNewUpdate().addActionListener(listener); 
         mainView.getBtnProductList().addActionListener(listener); 
         mainView.getBtnReturnUpdate().addActionListener(listener);
         mainView.getBtnUpdateNewStock().addActionListener(listener);
        
        }
    
}
