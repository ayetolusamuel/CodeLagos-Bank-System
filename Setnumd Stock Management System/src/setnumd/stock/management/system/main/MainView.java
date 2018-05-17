/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setnumd.stock.management.system.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class MainView extends JFrame{
private JPanel jPanel;
private JButton btnDailyStock,btnNewUpdate,btnUpdateNewStock,btnReturnUpdate,btnProductList;

    public JButton getBtnDailyStock() {
        return btnDailyStock;
    }

    public JButton getBtnNewUpdate() {
        return btnNewUpdate;
    }

    public JButton getBtnUpdateNewStock() {
        return btnUpdateNewStock;
    }

    public JButton getBtnReturnUpdate() {
        return btnReturnUpdate;
    }

    public JButton getBtnProductList() {
        return btnProductList;
    }
MainModel mainModel;
    public MainView(MainModel mainModel) throws HeadlessException {
        this.mainModel = mainModel;
        getGUI();
        
        
        
        
        
    }
    
    
    
    
 

    private void getGUI() {
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
					catch(InterruptedException e)
					{
					}
				}
				g.drawImage(img,0,0,600,600,null);
			}
        };
        jPanel.setLayout(null);
        
          setVisible(true);
          setLocation(300,100);
          setResizable(false);
          setSize(440,520);
        btnDailyStock = new JButton("Daily Stock");
        btnDailyStock.setFont(new Font("Times New Roman",Font.ITALIC,18));
        jPanel.add(btnDailyStock).setBounds(10,10,205,200);
        
        
        btnNewUpdate = new JButton("New Products");
        btnNewUpdate.setFont(new Font("Times New Roman",Font.ITALIC,18));
        jPanel.add(btnNewUpdate).setBounds(220,10,200,200);
        
        
        
        btnUpdateNewStock = new JButton("Update New Products");
        btnUpdateNewStock.setFont(new Font("Times New Roman",Font.ITALIC,18));
        jPanel.add(btnUpdateNewStock).setBounds(220,220,200,200);
        
        
        btnReturnUpdate = new JButton("Return Product Update");
        btnReturnUpdate.setFont(new Font("Times New Roman",Font.ITALIC,18));
        jPanel.add(btnReturnUpdate).setBounds(10,220,205,200);
        
        
        btnProductList = new JButton("Product Lists");
        btnProductList.setFont(new Font("Times New Roman",Font.ITALIC,18));
        jPanel.add(btnProductList).setBounds(0,430,420,40);
         
        getContentPane().add(jPanel, BorderLayout.CENTER);
     }
    
    
    
       
//    public static void main(String[] args) {
//        MainView mainView = new MainView();
//        mainView.setVisible(true);
//        mainView.setLocation(300,100);
//       // mainView.setResizable(false);
//        mainView.setSize(440,520);
//        
//        
//    }
}
