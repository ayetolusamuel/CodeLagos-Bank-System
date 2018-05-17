/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setnumd.stock.management.system;

import setnumd.stock.management.system.dailystock.dailystockview.DailyStockController;
import setnumd.stock.management.system.dailystock.dailystockview.DailyStockModel;
import setnumd.stock.management.system.dailystock.dailystockview.DailyStockView;
import setnumd.stock.management.system.main.MainContoller;
import setnumd.stock.management.system.main.MainModel;
import setnumd.stock.management.system.main.MainView;

/**
 *
 * @author DELL
 */
public class SetnumdStockManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        MainModel mainModel = new MainModel();
//        MainView mainView = new MainView(mainModel);
//        MainContoller mainContoller = new MainContoller(mainModel,mainView);
        // TODO code application logic here
        
        DailyStockModel dailyStockModel = new DailyStockModel();
        DailyStockView dailyStockView = new DailyStockView(dailyStockModel);
        DailyStockController  dailyStockController = new DailyStockController(dailyStockView, dailyStockModel);
        
    }
    
}
