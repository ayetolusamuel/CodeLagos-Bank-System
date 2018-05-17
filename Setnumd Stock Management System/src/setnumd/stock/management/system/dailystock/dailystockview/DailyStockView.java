/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setnumd.stock.management.system.dailystock.dailystockview;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import setnumd.stock.management.system.database.DatabaseConnection;
import setnumd.stock.management.system.main.MainView;
//import products.controller.DatabaseConnection;

public class DailyStockView extends JFrame  {

    private JLabel lblPCode, lblPName, lblPDescription, lblpPrice, lblPCategory, lblPlatform, lblPayment;
    private JTextField txtPName, txtPPrice, txtDate;
    private JTextArea txtPDescription;
    JTextField txtPCode;
    private JButton btnSave;

    public JButton getBtnSave() {
        return btnSave;
    }

    public JTextField getTxtPName() {
        return txtPName;
    }

    public JButton getBtnComfirm() {
        return btnComfirm;
    }

    private String[] cat = {"Gadgets & Accessories ",};
    private String[] payment = {"COD", "Transfer", "Prepaid", "Cash", "USSD Transfer"};
    private String[] platform = {"Jumia", "Konga", "Walk - In", "Despatch", "Others"};

    private JComboBox<String> jcmbPDescription, jcmbPayment, jcmbPlatform;
    private JPanel jPanel;
    private final static String DEFAULT = "SET";
    private static java.util.Date currDate = new java.util.Date();					//Creating Object.
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
    private static String d = sdf.format(currDate);
    static DateTimeFormatter formatter;
    static String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());

    private JTextField txtPCategory;
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private JTextField txtDespatchName;
    private JTextField txtJumiaOrderNumber;
    private JButton btnComfirm;
    private String mPrice;
    private JComboBox jcmbPAccount;
    private String[] account = {"Akwe gadgets", "Setnumdstores", "optun", "Godpower", "Opeoluwasegun", "Other"};
    private JTextField txtQuantity;
    private JLabel lblQuantity;
    private JLabel lblRemark;
    private JTextArea txtRemark;
    private JLabel lblPaymentMode;
    private JLabel lblpPlatform;
    DailyStockModel dailyStockModel;
    public DailyStockView(DailyStockModel dailyStockModel) {
       this.dailyStockModel = dailyStockModel;
       
        displayGui();
        txtPCode.setText("SET0001");
      
    }

    private void displayGui() {
        
        
		
		addWindowListener(new WindowAdapter()
			{
                                @Override
				public void windowClosing(WindowEvent e)
				{       
					
					
				
				}
			});
		
        
        jPanel = new JPanel(){
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
        setVisible(true);
        setLocation(300, 100);
        setSize(550, 520);
        

        lblPCode = new JLabel("Product Code");
        jPanel.add(lblPCode).setBounds(10, 10, 100, 25);

        txtPCode = new JTextField(2);
        String code = "SET";
        txtPCode.setText(code);
        txtPCode.setCaretPosition(code.length());
        txtPCode.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        txtPCode.addKeyListener(new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (! ( (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'||c==':')) {
								getToolkit().beep ();
								ke.consume ();}}}});
			
        jPanel.add(txtPCode).setBounds(140, 12, 80, 25);

        txtDate = new JTextField(d);
        txtDate.setToolTipText("The current Date!!!!!!");
        txtDate.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        jPanel.add(txtDate).setBounds(250, 12, 80, 25);

        
        btnComfirm = new JButton(new ImageIcon("images//sam.gif"));
        jPanel.add(btnComfirm).setBounds(340, 12, 37, 25);
        
        lblPName = new JLabel("Product Name");
        jPanel.add(lblPName).setBounds(10, 45, 100, 25);

        txtPName = new JTextField();
        txtPName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        jPanel.add(txtPName).setBounds(140, 48, 350, 25);

        lblpPrice = new JLabel("Product Price");
        jPanel.add(lblpPrice).setBounds(10, 80, 100, 25);

        txtPPrice = new JTextField();
        txtPPrice.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        jPanel.add(txtPPrice).setBounds(140, 82, 100, 25);

        lblpPlatform = new JLabel("Platform");
        jPanel.add(lblpPlatform).setBounds(250, 80, 100, 25);

        jcmbPlatform = new JComboBox<>(platform);
        jcmbPlatform.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        jPanel.add(jcmbPlatform).setBounds(350, 82, 170, 25);

        lblQuantity = new JLabel("Quantity");
        jPanel.add(lblQuantity).setBounds(10, 115, 100, 25);

        txtQuantity = new JTextField();
        txtQuantity.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        jPanel.add(txtQuantity).setBounds(140, 117, 100, 25);

        lblPaymentMode = new JLabel("Payment Mode");
        jPanel.add(lblPaymentMode).setBounds(250, 115, 100, 25);

        jcmbPayment = new JComboBox<>(payment);
        jcmbPayment.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        jPanel.add(jcmbPayment).setBounds(350, 117, 170, 25);

        lblPCategory = new JLabel("Product Category");
        jPanel.add(lblPCategory).setBounds(10, 145, 100, 25);

        txtPCategory = new JTextField();
        txtPCategory.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        jPanel.add(txtPCategory).setBounds(140, 147, 300, 25);

        lblPDescription = new JLabel("Product Descript.");
        jPanel.add(lblPDescription).setBounds(10, 190, 120, 25);

        txtPDescription = new JTextArea();
        txtPDescription.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        txtPDescription.setWrapStyleWord(true);
        txtPDescription.setLineWrap(true);

        JScrollPane jScrollPane = new JScrollPane(txtPDescription);
        jScrollPane.setMaximumSize(getPreferredSize());

        jPanel.add(jScrollPane).setBounds(140, 192, 300, 100);

        btnSave = new JButton("Save");
        jPanel.add(btnSave).setBounds(10, 230, 100, 25);
        
        getContentPane().add(jPanel, BorderLayout.CENTER);

        JLabel lbldespathName = new JLabel("Despath Name|Plaform");
        lbldespathName.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        lbldespathName.setToolTipText("Enter Despath name");
        jPanel.add(lbldespathName).setBounds(10, 310, 350, 25);

        txtDespatchName = new JTextField();
        txtDespatchName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        txtDespatchName.setToolTipText("Enter Despath PLatform/Name");

        jPanel.add(txtDespatchName).setBounds(140, 310, 350, 25);

        JLabel lblJumiaOrderNumber = new JLabel("<html><i>Jumia|Konga Order Num.");
        lblJumiaOrderNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
        jPanel.add(lblJumiaOrderNumber).setBounds(10, 340, 350, 25);

        txtJumiaOrderNumber = new JTextField();
        txtJumiaOrderNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));

        txtJumiaOrderNumber.setToolTipText("Enter Jumia|Order Order Number, must be nine digit");
        jPanel.add(txtJumiaOrderNumber).setBounds(140, 342, 350, 25);

        JLabel lblAccount = new JLabel("<html><i>Account.");
        lblAccount.setFont(new Font("Times New Roman", Font.BOLD, 12));
        jPanel.add(lblAccount).setBounds(10, 380, 350, 25);

        jcmbPAccount = new JComboBox<>(account);
        jcmbPAccount.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        jPanel.add(jcmbPAccount).setBounds(140, 380, 200, 25);

        lblRemark = new JLabel("<html><b>Remark....");
        jPanel.add(lblRemark).setBounds(10, 420, 120, 25);
        lblRemark.setFont(new Font("Times New Roman", Font.ITALIC, 15));

        txtRemark = new JTextArea();
        txtRemark.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
        txtRemark.setWrapStyleWord(true);
        txtRemark.setLineWrap(true);

        JScrollPane jScrollPaneRemark = new JScrollPane(txtRemark);
        jScrollPaneRemark.setMaximumSize(getPreferredSize());

        jPanel.add(jScrollPaneRemark).setBounds(140, 422, 350, 60);

     
    }


}
