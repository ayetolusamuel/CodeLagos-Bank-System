/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setnumd.stock.management.system.dailystock.dailystockview;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class DailyStockModel {
    private final String DEFAULT_ID_VALUE = "SET";
    
    public String showError(String error){
      return error;
    }
    
    public String validateId(String id) {
            String error;
        if (id.length() > 3 && id.length() == 7) {
            String i = id.substring(0, 3);

            if (!i.matches(DEFAULT_ID_VALUE)) {
                //JOptionPane.showMessageDialog(parentComponent, this);
                error = "Invalid ID Format,Start with \"SET\"";
                showError(error);
                //System.out.println("Invalid ID Format,Start with \"SET\"");
                id = DEFAULT_ID_VALUE;
            }
        } else {
            error = "ID must be seven characters";
            showError(error);
           // System.out.println("ID must be seven characters");
        }
        return id;
    }
  
    public void validateText(String despatch,String quantity ){
        
        
        
        if (despatch.length() == 0 || quantity.length()==0) {
            System.out.println("Fill editable fields");
           
            
        }
        
    }
    
}
