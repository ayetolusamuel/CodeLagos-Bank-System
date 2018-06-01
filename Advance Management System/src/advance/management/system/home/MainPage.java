/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advance.management.system.home;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class MainPage extends JFrame implements ActionListener
{
	JPanel main;
	Container c=getContentPane();
	
	private JDesktopPane desktop = new JDesktopPane ();
	PreparedStatement ps=null;
CheckboxGroup cbmf;
Checkbox cbm,cbf;
JPanel statusbar =new JPanel();

	private JTable table;
	boolean therty=false;
	boolean twentynine=false;
	boolean twentyeight=false;
	
	String coursename;
	
	JMenuBar mbar;
	Connection conn;
	Statement st;
	ResultSet resultSet =null;
	
	JMenuItem report_summary_list;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15;
	JMenu studs_Archieves,query_menu,view_menu,file_menu,registration_menu,setting_menu,reports_menu,help_menu;
	JMenu showStudentMenu;
	JMenuItem   monthly_report_Item;
	 JMenuItem preview_all_report_item;
	JMenuItem report_base_date_Item;
	 JMenuItem  search_staff_item,monthly_summary_item;
	JMenuItem nepa_report_date_item,generator_report_date_item,nepa_generator_report_date_item;
	JMenuItem studentMasterList_Archieves,staff_item,staffReg,schedule_item,guest_item,classlist_item,classmaster_list_item;
	JMenu faculty_master_menu;
	JMenuItem faculty_master_item;
	 JMenuItem nepa_report_item,generator_report_item, nepa_generator_report_item;
	JMenuItem about_item,staffList_item;
	JMenuItem administrative_item;
	JMenuItem menu_nepa_report,menu_generator_report,menu_nepa_generator_report;
	JMenu report_list_item;
	JMenuItem nepa_List,generator_List,generatornepa_List;				//List items
	JMenuItem signout_item,exit_item;
	JMenuItem studentmaster_item;
	JMenuItem facultyloading_item;
	JMenuItem about_us_item,about_software_item,website_item,help_shortcut_item,feedback_item;   //aboutus,about software jmenu
	JMenuItem guest_report_item,courseItem;
	JMenuItem Class_Schedules_Archieves,student_masterList,faculty_masterList,course_masterList,studentMasterRecord;
	JMenuItem  staff_payrollList,discharge_List,staff_dailyTranList;
	JMenuItem course_detailsItem;
	JMenuItem course_item,staffentry_item,room_item,grade_item,reamain_fees_item;
	JMenuItem short_term_courses_item;

	JMenuItem by_YearLevel,stud_contact,search_stud,calcy,caln,by_EnrollmentStatus;
	String StrBusinessTitle;
   	JLabel BusinessTitleLabel = new JLabel();
   	StudentInfoHandler h=new StudentInfoHandler();
   
   	int height;
   	int width;
   	Dimension screenSize;
	//private JMenu preview_all_report_item;
	private JMenuItem site_list_item;
	private JMenuItem site_registration_item;
	private String msAccDB;
	private String dbURL;
	private JMenuItem search_month_report;
	private JMenuItem modify_update_log_List;
	private JMenuItem print_log_List;
	private JMenuItem delete_log_List;
        private JButton button;
        
        
        private final static  String  DEFAULT= "SET";
	private static java.util.Date currDate = new java.util.Date ();					//Creating Object.
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
	private static String d = sdf.format (currDate);
	static DateTimeFormatter formatter;
	static String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());
        
        
    private final JMenu product_view_menu;
    private JLabel lblPCode;
    private JTextField txtPCode;
  
    private JTextField txtDate;
   
    private JTextField txtTime;
    private JButton btnComfirm;
    private JLabel lblPName;
    private JTextField txtPName;
    private JLabel lblpPrice;
    private JTextField txtPPrice;
    private JComboBox<String> jcmbPlatform,jcmbPayment;
    private String[] platform = {"Jumia","Konga","Walk - In","Despatch","Others"};
    private JLabel lblInStock;
    private JTextField txtPInStock;
    private String[] account = {"Akwe gadgets","Setnumdstores","optun","Godpower","Opeoluwasegun","Other"};
    private String[] cat= {"Gadgets & Accessories ",};
    private String[] payment = {"COD","Transfer","Prepaid","Cash","USSD Transfer"};
    private JLabel lblPCategory;
    private JTextField txtPCategory;
    private JLabel lblQuantity;
    private JTextField txtQuantity;
    private JLabel lblPDescription;
    private JTextArea txtPDescription;
    private JTextField txtDespatchName;
    private JLabel lblRemark;
    private JTextArea txtRemark;
    private JTextField txtJumiaOrderNumber;
    private JComboBox<String> jcmbPAccount;
    private JButton btnSave;
    private JLabel lblpPlatform;
    private JLabel lblTime;
    private String myTime;
	
	
    //Time thread value...........
               private   Calendar cal; 
               private   int hour,minute,second;
               String TimeResult;
    
    
	
	
	@SuppressWarnings("unchecked")
	MainPage()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		setSize(width+180,height+300);
		setTitle("Student Information");
		setLocation(screenSize.width/6,20);
		
		
		
		
		
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
//					
//					main sam=new main();
//					sam.setVisible(true);
//					//dis_charge_report.setDefaultLookAndFeelDecorated(true);
//					setVisible(false);
//					
				
				}
			});
		
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				/*dispose();
				cr.dispose();
				new MainMenuFrame();
				setVisible(false);*/
			}
		});
		//StaffsInfo.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setTitle("BREM Operation System");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		main=new JPanel()
		{
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
				g.drawImage(img,0,0,width+180,height+260,null);
			}
		};
		main.setLayout(null);
		//main.setBackground(new Color(245,240,255));
		 
		 
		 
		
		
		mbar=new JMenuBar();
		mbar.setBackground(new Color(232,222,222));
     	setJMenuBar(mbar);

		file_menu=new JMenu("File");
     	file_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
       	file_menu.setMnemonic('F');

     	registration_menu=new JMenu("Registration");
     	registration_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	registration_menu.setMnemonic('R');

     	setting_menu=new JMenu("System");
     	setting_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        setting_menu.setMnemonic('S');

     	view_menu=new JMenu("Operation Log");
     	view_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        view_menu.setMnemonic('O');

        product_view_menu = new JMenu("Products");
     	product_view_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        product_view_menu.setMnemonic('P');
        
     	help_menu=new JMenu("Help");
     	help_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        help_menu.setMnemonic('H');


     	reports_menu=new JMenu(" Report");
     	reports_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	reports_menu.setMnemonic('R');

     	
     	
     	
     	
     	//jmenuItem for website
     	website_item=new JMenuItem("Visit our Website?");
     	website_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	website_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
     	website_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images//mainicon.png")));
     	website_item.addActionListener(h);
     	
     	
     	about_software_item=new JMenuItem("About Software?");
     	about_software_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	about_software_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
     	about_software_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images//mainicon.png")));
     	about_software_item.addActionListener(h);
     	
     	//---JMenuItem for about the software
     	about_software_item=new JMenuItem("About Software?");
     	about_software_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	about_software_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
     	about_software_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images//mainicon.png")));
     	about_software_item.addActionListener(h);

		// Jmenuitem for about us
		about_us_item=new JMenuItem("About US");
		about_us_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		about_us_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		about_us_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images//mainicon.png")));
		about_us_item.addActionListener(h);
		
		// Jmenuitem for help_shortcut
				help_shortcut_item=new JMenuItem("Help|Shortcut");
				help_shortcut_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
				help_shortcut_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
				help_shortcut_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images//mainicon.png")));
				help_shortcut_item.addActionListener(h);

				
				// Jmenuitem for feedback
						feedback_item=new JMenuItem("FeedBack");
						feedback_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
						feedback_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
						feedback_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images//mainicon.png")));
						feedback_item.addActionListener(h);
				
				
				
     	signout_item=new JMenuItem("Sign Out");
     	signout_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	signout_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		signout_item.setIcon(new ImageIcon("images//lockapplication.png"));
		signout_item.addActionListener(h);

		exit_item=new JMenuItem("Exit");
     	exit_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	exit_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		exit_item.setIcon(new ImageIcon("images//EXIT.PNG"));
		exit_item.addActionListener(h);

		studentmaster_item=new JMenuItem(" ");//enrollment master file
		studentmaster_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentmaster_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        studentmaster_item.setIcon(new ImageIcon("images//RESET.PNG"));
	//studentmaster_item.addActionListener(this);

//#############################################
		studentMasterList_Archieves=new JMenuItem("  ");//enrollment master file
		studentMasterList_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentMasterList_Archieves.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        studentMasterList_Archieves.setIcon(new ImageIcon("images//SUPPLIER.PNG"));
		//studentMasterList_Archieves.addActionListener(this);


///################################################
		schedule_item=new JMenuItem(" ");
		schedule_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		schedule_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
        schedule_item.setIcon(new ImageIcon("images//RESET.png"));
		//schedule_item.addActionListener(this);

     

	    staffReg=new JMenuItem("Staff Registration");
        staffReg.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staffReg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        staffReg.setIcon(new ImageIcon("images//delete.png"));
		staffReg.addActionListener(h);
		 

		staffList_item=new JMenuItem("Staff List ");
		staffList_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staffList_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		staffList_item.setIcon(new ImageIcon("images//purchaseorder.png"));
		staffList_item.addActionListener(h);

			search_staff_item=new JMenuItem("Search Staff ");
	        search_staff_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	        search_staff_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
	        search_staff_item.setIcon(new ImageIcon("images//customer.png"));
	        search_staff_item.addActionListener(h);
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        site_registration_item=new JMenuItem("Site Registration");
	        site_registration_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	        site_registration_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
	        site_registration_item.setIcon(new ImageIcon("images//delete.png"));
	        site_registration_item.addActionListener(h);
		
			site_list_item=new JMenuItem("Site List ");
			site_list_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
			site_list_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
			site_list_item.setIcon(new ImageIcon("images//purchaseorder.png"));
			site_list_item.addActionListener(h);

		      
			
			
			
			
			
			
			
			
			
			
			
		staff_item=new JMenuItem(" ");
		staff_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staff_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        staff_item.setIcon(new ImageIcon("images//purchaseorder.png"));
		staff_item.addActionListener(h);

		studentMasterRecord=new JMenuItem(" ");
		studentMasterRecord.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentMasterRecord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        studentMasterRecord.setIcon(new ImageIcon("images//SalesRep.png"));
		//studentMasterRecord.addActionListener(this);

		staffentry_item=new JMenuItem(" ");
		staffentry_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staffentry_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        staffentry_item.setIcon(new ImageIcon("images//RECIEVE.png"));
		staffentry_item.addActionListener(h);

		administrative_item=new JMenuItem("User Accounts");
		administrative_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		administrative_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        administrative_item.setIcon(new ImageIcon("images//SalesRep.png"));
		administrative_item.addActionListener(h);

		
		////###################################################
		grade_item=new JMenuItem(" Monthly Summary ");
		grade_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		grade_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        grade_item.setIcon(new ImageIcon("images//SEARCH.png"));
		//grade_item.addActionListener(this);

		monthly_summary_item=new JMenuItem(" Monthly Summary ");
		monthly_summary_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		monthly_summary_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		monthly_summary_item.setIcon(new ImageIcon("images//newinvoice.png"));
		monthly_summary_item.addActionListener(h);


  

	    student_masterList=new JMenuItem("Daily Operation Log");
	    student_masterList.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    student_masterList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    student_masterList.addActionListener(h);
	    student_masterList.setIcon(new ImageIcon("images//CUSTOMER.PNG"));
	   
	   

	    
	    modify_update_log_List=new JMenuItem("Modify|Update Log");
	    modify_update_log_List.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    modify_update_log_List.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    modify_update_log_List.addActionListener(h);
	    modify_update_log_List.setIcon(new ImageIcon("images//modify.PNG"));

	    
	    delete_log_List=new JMenuItem("Delete Log");
	    delete_log_List.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    delete_log_List.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    delete_log_List.addActionListener(h);
	    delete_log_List.setIcon(new ImageIcon("images//delete.PNG"));

	    print_log_List=new JMenuItem("Print Log");
	    print_log_List.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    print_log_List.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    print_log_List.addActionListener(h);
	    print_log_List.setIcon(new ImageIcon("images//print.PNG"));
	    
	    
	    monthly_report_Item=new JMenuItem("Monthly Report ");
	    monthly_report_Item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	 //   monthly_report_Item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	    monthly_report_Item.setIcon(new ImageIcon("images//EXPENSE.PNG"));
	    monthly_report_Item.addActionListener(h);
	    
	   
	    
	    menu_nepa_generator_report=new JMenuItem("Nepa|Generator ");
	    menu_nepa_generator_report.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    menu_nepa_generator_report.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    menu_nepa_generator_report.addActionListener(h);
	    menu_nepa_generator_report.setIcon(new ImageIcon("images//CUSTOMER.PNG"));
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


	    report_list_item=new JMenu("Report List  ");
	    report_list_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    //report_list_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    report_list_item.setIcon(new ImageIcon("images//newrecieve.png"));
	    report_list_item.addActionListener(h);

	 
	    
	    nepa_generator_report_date_item=new JMenuItem("<html><i>Nepa|Generator Report List ");
	    nepa_generator_report_date_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    nepa_generator_report_date_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    nepa_generator_report_date_item.setIcon(new ImageIcon("images//newrecieve.png"));
	    nepa_generator_report_date_item.addActionListener(h);
	    
	    
	    
	    
	    

	    report_summary_list=new JMenuItem("Report Summary  ");
	    report_summary_list.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    report_summary_list.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    report_summary_list.setIcon(new ImageIcon("images//newrecieve.png"));
	    report_summary_list.addActionListener(h);
	    
	    
	    
	    
	    
	    

	    courseItem=new JMenuItem("Modify Report  ");
	    courseItem.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    courseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    courseItem.setIcon(new ImageIcon("images//newrecieve.png"));
	    courseItem.addActionListener(h);

	    preview_all_report_item =new JMenuItem("Preview All Report ");
	    preview_all_report_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	   
	    preview_all_report_item.setIcon(new ImageIcon("images//newrecieve.png"));
	    preview_all_report_item.addActionListener(h);
	    
	   
	    
	    nepa_generator_report_item =new JMenuItem("Nepa|Generator");
	    nepa_generator_report_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    nepa_generator_report_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    nepa_generator_report_item.setIcon(new ImageIcon("images//newrecieve.png"));
	    nepa_generator_report_item.addActionListener(h);
	    
	    

	    report_base_date_Item=new JMenuItem("Report Base On Date");
	    report_base_date_Item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	   // report_base_date_Item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
	    report_base_date_Item.setIcon(new ImageIcon("images//EXPENSE.PNG"));
	    report_base_date_Item.addActionListener(h);

	   
	    nepa_report_date_item=new JMenuItem("<html><i>Nepa Report List");
	    nepa_report_date_item.setFont(new Font("Times New Roman",Font.PLAIN,14));
	    nepa_report_date_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    nepa_report_date_item.setIcon(new ImageIcon("images//newrecieve.png"));
	    nepa_report_date_item.addActionListener(h);
	    
	    
	    generator_report_date_item=new JMenuItem("<html><i>Generator Report List ");
	    generator_report_date_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    generator_report_date_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    generator_report_date_item.setIcon(new ImageIcon("images//newrecieve.png"));
	    generator_report_date_item.addActionListener(h);
	    
	    
	    nepa_generator_report_date_item=new JMenuItem("<html><i>Nepa|Generator Report List ");
	    nepa_generator_report_date_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    nepa_generator_report_date_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    nepa_generator_report_date_item.setIcon(new ImageIcon("images//newrecieve.png"));
	    nepa_generator_report_date_item.addActionListener(h);
	    
	    search_month_report=new JMenuItem("Generate Monthly Report");
	    search_month_report.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    search_month_report.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
	    search_month_report.setIcon(new ImageIcon("images//SEARCH.png"));
	    search_month_report.addActionListener(h);

		calcy=new JMenuItem("Calculator");
		calcy.setFont(new Font("Times New Roman",Font.PLAIN,13));
		calcy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		calcy.setIcon(new ImageIcon("images//newrecieve.png"));
		calcy.addActionListener(h);


		caln=new JMenuItem("Calendar");
		caln.setFont(new Font("Times New Roman",Font.PLAIN,13));
		caln.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		caln.setIcon(new ImageIcon("images//purchaseorder.png"));
	    caln.addActionListener(h);

	    by_EnrollmentStatus=new JMenuItem(" Search Month Report");
	    by_EnrollmentStatus.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    by_EnrollmentStatus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	    by_EnrollmentStatus.setIcon(new ImageIcon("images//SEARCH.png"));
	    //by_EnrollmentStatus.addActionListener(this);

	    studs_Archieves=new JMenu(" ");
	    studs_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    studs_Archieves.setIcon(new ImageIcon("images//EXPENSE.PNG"));

	    Class_Schedules_Archieves=new JMenuItem(" ");
	    Class_Schedules_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
        Class_Schedules_Archieves.setIcon(new ImageIcon("images//EXPENSE.PNG"));
	    //Class_Schedules_Archieves.addActionListener(this);


     	//---Add to JMenu
     	file_menu.add(signout_item);
     	file_menu.addSeparator();
        file_menu.add(exit_item);

        //studs_Archieves.add(studentmaster_item);
        //studs_Archieves.addSeparator();
        //studs_Archieves.add(studentMasterList_Archieves);
        //studs_Archieves.addSeparator();
        //studs_Archieves.add(Class_Schedules_Archieves);

        //registration_menu.add(studs_Archieves);
        //registration_menu.addSeparator();
        //registration_menu.add(studentMasterRecord);
        //registration_menu.add(schedule_item);
        //registration_menu.addSeparator();
       
        registration_menu.add(staffReg);
        registration_menu.addSeparator();
        registration_menu.add(staffList_item);
        registration_menu.addSeparator();
        registration_menu.add(search_staff_item);
        registration_menu.addSeparator();
        registration_menu.add(site_registration_item);
        registration_menu.addSeparator();
        registration_menu.add(site_list_item);

   
        //preview_all_report_item.add(nepa_generator_report_item);
      
        
        
        
        
        

       //monthly_report_Item.add(menu_nepa_generator_report);  
        
        
        
       // reports_menu.add( );
		reports_menu.addSeparator();
		reports_menu.add( monthly_report_Item);
		reports_menu.addSeparator();
		reports_menu.add(monthly_summary_item);
		reports_menu.addSeparator();
		reports_menu.add(staff_item);
		reports_menu.addSeparator();
		reports_menu.add(preview_all_report_item);
		reports_menu.addSeparator();
		reports_menu.add(  report_base_date_Item);
		reports_menu.addSeparator();
		reports_menu.add(search_month_report);
	   // reports_menu.addSeparator();
	   // reports_menu.add(by_Birthdate);
	   // reports_menu.addSeparator();
	   // reports_menu.add(by_Faculty_Load);
	   // reports_menu.addSeparator();
       // reports_menu.add(by_EnrollmentStatus);

        view_menu.add(student_masterList);
        view_menu.addSeparator();
        view_menu.add(modify_update_log_List);
        view_menu.addSeparator();
        view_menu.add(delete_log_List);
        view_menu.addSeparator();
        view_menu.add(print_log_List);
        
        
       /* report_base_date_Item.add(nepa_report_date_item);
        report_base_date_Item.addSeparator();
        report_base_date_Item.add(generator_report_date_item);
        report_base_date_Item.addSeparator();
        report_base_date_Item.add(nepa_generator_report_date_item);*/
        
        
       
       // query_menu.add(query_builderItem);

        setting_menu.add(administrative_item);
		setting_menu.addSeparator();
		setting_menu.add(calcy);
		setting_menu.addSeparator();
       	setting_menu.add(caln);

       	
       	//menu for about us,about software
       	help_menu.add(website_item);
       	help_menu.addSeparator();
        help_menu.add(about_us_item);
        help_menu.addSeparator();
        help_menu.add(about_software_item);
        help_menu.addSeparator();
        help_menu.add(help_shortcut_item);
        help_menu.addSeparator();
        help_menu.add(feedback_item);

        //reports_menu.add(facultyloading_item);
     	//---Add to JMenuBar
     	mbar.add(file_menu);
     	mbar.add(registration_menu);
        mbar.add(reports_menu);
        mbar.add(view_menu);
        mbar.add(product_view_menu);
        mbar.add(reports_menu);
        mbar.add(setting_menu);
        mbar.add(help_menu);
        
        Icon img1=new ImageIcon("images//ICON1.JPG");
        btn1=new JButton();
        btn1.setIcon(img1);
       	btn1.addActionListener(h);
        btn1.setToolTipText("New Staff Entry");

        
        BusinessTitleLabel.setText(StrBusinessTitle);
		BusinessTitleLabel.setFont(new Font("Verdana",Font.PLAIN,12));
		BusinessTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        Icon img2=new ImageIcon("images//ICON2.JPG");
        btn2=new JButton();
        btn2.setIcon(img2);
		btn2.setToolTipText("Search Operation Log");
		btn2.addActionListener(h);

        Icon img3=new ImageIcon("images//ICON3.JPG");
        btn3=new JButton();
        btn3.setIcon(img3);
        btn3.setToolTipText("Daily Operation Log");
		btn3.addActionListener(h);

        Icon img4=new ImageIcon("images//ICON4.JPG");
        btn4=new JButton();
        btn4.setIcon(img4);
		btn4.setToolTipText("");
		btn4.addActionListener(h);

        Icon img5=new ImageIcon("images//ICON5.JPG");
        btn5=new JButton();
        btn5.setToolTipText("Sign Out");
        btn5.setIcon(img5);
		btn5.addActionListener(h);

        Icon img6=new ImageIcon("images//ICON6.JPG");
        btn6=new JButton();
        btn6.setIcon(img6);
		btn6.setToolTipText("Calculator");
        btn6.addActionListener(h);

        Icon img7=new ImageIcon("images//ICON7.JPG");
        btn7=new JButton();
        btn7.setIcon(img7);
        btn7.setToolTipText("Calendar");
        btn7.addActionListener(h);


        Icon img8=new ImageIcon("images//ICON8.JPG");
        btn8=new JButton();
        btn8.setIcon(img8);
        btn8.setToolTipText("Staff Contact's");
		btn8.addActionListener(h);


        Icon img9=new ImageIcon("images//ICON9.JPG");
        btn9=new JButton();
        btn9.setToolTipText("");
        btn9.setIcon(img9);
        btn9.addActionListener(h);

        Icon img10=new ImageIcon("images//ICON10.JPG");
        btn10=new JButton();
        btn10.setIcon(img10);
		btn10.setToolTipText("");
		btn10.addActionListener(h);

        Icon img11=new ImageIcon("images//ICON11.JPG");
        btn11=new JButton();
        btn11.setIcon(img11);
        btn11.setToolTipText("");
        btn11.addActionListener(h);

        Icon img12=new ImageIcon("images//ICON12.jpg");
        btn12=new JButton();
        btn12.setIcon(img12);
        btn12.setToolTipText("Home");
        btn12.addActionListener(h);
        
        Icon img13=new ImageIcon("images//ICON13.jpg");
        btn13=new JButton();
        btn13.setIcon(img13);
        btn13.setToolTipText("Help|Shortcut");
        btn13.addActionListener(h);
        
        Icon img14=new ImageIcon("images//ICON14.jpg");
        btn14=new JButton();
        btn14.setIcon(img14);
        btn14.setToolTipText("");
        btn14.addActionListener(h);
        
        Icon img15=new ImageIcon("images//ICON15.jpg");
        btn15=new JButton();
        btn15.setIcon(img15);
        btn15.setToolTipText("About Us");
        btn15.addActionListener(h);
        
        JToolBar toolbar=new JToolBar("Tools");
        c.add(toolbar);

        toolbar.setBounds(0,0,1200,40);
		toolbar.setRollover(true);
		toolbar.setBackground(Color.white);
		toolbar.setFloatable(false);
        toolbar.add(btn1);
        toolbar.add(btn2);
        toolbar.add(btn3);
        toolbar.add(btn4);
        toolbar.add(btn5);
        toolbar.add(btn6);
        toolbar.add(btn7);
        toolbar.add(btn8);
        toolbar.add(btn9);
        toolbar.add(btn10);
        toolbar.add(btn11);
        toolbar.add(btn12);
        toolbar.add(btn13);
        toolbar.add(btn14);
        toolbar.add(btn15);
        
         button = new JButton("SAMUELSSSSSSSSSSSSSSS");
         button.setForeground(Color.red);
      // main.add(button).setBounds(20,70,200,30);
       
        

		displayGui();
         toolbar.add(BusinessTitleLabel);
        getContentPane().add(main,BorderLayout.CENTER);
        //getContentPane().add (desktop, BorderLayout.CENTER);
     
	
	}
        
        
        
        
        
        
        
        
        private void displayGui() {
		          Timer t = new Timer(1000, this);
                    t.start();
		
		lblPCode = new  JLabel("<html><b>Product Code");
                lblPCode.setForeground(Color.white);
                lblPCode.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		main.add(lblPCode).setBounds(10, 70, 200, 25);
		
		txtPCode = new JTextField(2);
		txtPCode.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		txtPCode.setText(DEFAULT+1);
		txtPCode.setCaretPosition(txtPCode.getText().length());
                txtPCode.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
		main.add(txtPCode).setBounds(180,72,80,25);
		
		txtDate = new JTextField(d);
		txtDate.setToolTipText("The current Date!!!!!!");
                txtDate.setFont(new Font("Times New Roman", Font.ITALIC, 24));
                txtDate.setForeground(Color.red);
                txtDate.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
		main.add(txtDate).setBounds(740,45,130,25);
		          
		          System.out.println("Dear me not "+TimeResult);
		 lblTime = new JLabel("<html><b>");
		lblTime.setToolTipText("The current Time!!!!!!!");
                lblTime.setForeground(Color.white);
                lblTime.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		main.add(lblTime).setBounds(590,45,120,25);
		
                clock1();  //time thread for display time
                 
                 
		btnComfirm = new JButton(new ImageIcon("images//check.gif"));
		main.add(btnComfirm).setBounds(270,72,37,25);
		btnComfirm.addActionListener(this);
		
		lblPName= new  JLabel("<html><b>Product Name");
                lblPName.setFont(new Font("Times New Roman", Font.ITALIC, 24));
                lblPName.setForeground(Color.WHITE);
		main.add(lblPName).setBounds(10, 120, 160, 25);
//		
		txtPName = new JTextField();
                txtPName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
                txtPName.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
		main.add(txtPName).setBounds(180,120,350,25);
//		
		lblpPrice = new  JLabel("<html><b>Product Price");
                lblpPrice.setForeground(Color.white);
                lblpPrice.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		main.add(lblpPrice).setBounds(10, 160, 200, 25);
//		
		txtPPrice = new JTextField();
                txtPPrice.setFont(new Font("Times New Roman", Font.ITALIC, 16));
                txtPPrice.setBorder(BorderFactory.createBevelBorder(1, new Color(192, 192, 255), new Color(192, 192, 255)));
		main.add(txtPPrice).setBounds(180,162,100,25);
//		
//		
		lblpPlatform = new  JLabel("<html><b>Platform");
                lblpPlatform.setForeground(Color.white);
                lblpPlatform.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		main.add(lblpPlatform).setBounds(10, 200, 200, 25);
//		
		jcmbPlatform = new JComboBox<>(platform);
		main.add(jcmbPlatform).setBounds(180,202,170,25);
//		
//		
//		
		lblInStock = new  JLabel("Product In- Stock");
		//main.add(lblInStock).setBounds(10, 115, 100, 25);
//		
		txtPInStock= new JTextField("5");
		//main.add(txtPInStock).setBounds(140,117,100,25);
//		
//		
		lblInStock = new  JLabel("Payment Mode");
		//main.add(lblInStock).setBounds(250, 115, 100, 25);
//		
		jcmbPayment = new JComboBox<>(payment);
		//main.add(jcmbPayment).setBounds(350,117,170,25);
//		
		lblPCategory = new  JLabel("Product Category");
		//main.add(lblPCategory).setBounds(10, 145, 100, 25);
//		
//	
		txtPCategory = new JTextField("null");
		//main.add(txtPCategory).setBounds(140,147,300,25);
//		
//
		lblQuantity = new  JLabel("QTY");
		//main.add(lblQuantity).setBounds(473, 145, 100, 25);
//		
//	
		txtQuantity = new JTextField();
		//main.add(txtQuantity).setBounds(460,167,50,25);
//		
//		
//		
//		
//		
//
//		
		lblPDescription = new  JLabel("Product Descript.");
		//main.add(lblPDescription).setBounds(10, 190, 120, 25);
//		
		txtPDescription = new JTextArea();
		txtPDescription.setWrapStyleWord(true);
		txtPDescription.setLineWrap(true);
//		
//		
//		
		JScrollPane jScrollPane = new JScrollPane(txtPDescription);
		jScrollPane.setMaximumSize(getPreferredSize());
//
               // main.add(jScrollPane).setBounds(140,192,300,100);
//		
//		
		btnSave = new JButton("Save");
		//main.add(btnSave).setBounds(10,230,100,25);
		btnSave.addActionListener(this);
                
                
                
                JLabel lbldespathName = new JLabel("Despath Name|Plaform");
		lbldespathName.setFont(new Font("Times New Roman",Font.ITALIC,12));
		lbldespathName.setToolTipText("Enter Despath name");
		//main.add(lbldespathName).setBounds(10,310,350,25);
//		
		txtDespatchName = new JTextField("null");
		txtDespatchName.setToolTipText("Enter Despath PLatform/Name");
//		
		//main.add(txtDespatchName).setBounds(140,310,350,25);
//		
//		
		JLabel lblJumiaOrderNumber = new JLabel("<html><i>Jumia|Konga Order Num.");
		lblJumiaOrderNumber.setFont(new Font("Times New Roman",Font.BOLD,12));
		//main.add(lblJumiaOrderNumber).setBounds(10,340,350,25);
//		
//		
		txtJumiaOrderNumber = new JTextField("null");
		txtJumiaOrderNumber.setToolTipText("Enter Jumia|Order Order Number, must be nine digit");
               // main.add(txtJumiaOrderNumber).setBounds(140,342,350,25);
//		
//		
		JLabel lblAccount = new JLabel("<html><i>Account.");
		lblAccount.setFont(new Font("Times New Roman",Font.BOLD,12));
		//main.add(lblAccount).setBounds(10,380,350,25);
//		
//		
		jcmbPAccount = new JComboBox<>(account );
		jcmbPAccount.setFont(new Font("Times New Roman",Font.ITALIC,12));
		//main.add(jcmbPAccount).setBounds(140,380,200,25);
//		
//		
		lblRemark = new  JLabel("<html><b>Remark....");
		//main.add(lblRemark).setBounds(10, 420, 120, 25);
		lblRemark.setFont(new Font("Times New Roman",Font.ITALIC,15));
		
		txtRemark = new JTextArea();
		txtRemark .setWrapStyleWord(true);
		txtRemark .setLineWrap(true);
	
		JScrollPane jScrollPaneRemark = new JScrollPane(txtRemark);
		jScrollPaneRemark.setMaximumSize(getPreferredSize());

		//main.add(jScrollPaneRemark).setBounds(140,422,350,60);
                

	}
        
        
        
        
        
        
        public String  clock1()
{
    
    Thread clock1 = new Thread(){
        String myTime;
        public void run()
        {
            for(;;)
            {
                try
                {
                    cal = new GregorianCalendar();
                    second = cal.get(Calendar.SECOND);
                    minute = cal.get(Calendar.MINUTE);
                   hour = cal.get(Calendar.HOUR_OF_DAY);
                    
                   myTime = "Time "+hour+ ":"+minute+ ":"+second;
                   lblTime.setText(myTime);
                   TimeResult = myTime;
                    //System.out.println("COunt "+myTime);
                   // System.out.println("Time "+hour+ ":"+minute+ ":"+second);
                   // lblTime.setText("Time: " + hour + ":" + minute + ":" + second);
                    sleep(1000);

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }

        }
    };

    clock1.start();
    return myTime;
}
        
        
        public void initialize() {

            Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {            
        Calendar cal = Calendar.getInstance();
        second = cal.get(Calendar.SECOND);
        minute = cal.get(Calendar.MINUTE);
        hour = cal.get(Calendar.HOUR);
        //System.out.println(hour + ":" + (minute) + ":" + second);
        lblTime.setText(hour + ":" + (minute) + ":" + second);
    }),
         new KeyFrame(Duration.seconds(1))
    );
    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	
	void report(){
		String date="Enter the Date";
		String S = JOptionPane.showInputDialog(null,date,"Search report via Date",JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showInputDialog(null,date,JOptionPane.YES_NO_OPTION);
		
	}
	
	
	
		

	void siteInsertionToDatabase(){
		String s=	JOptionPane.showInputDialog(null,"Enter Site Name","");
		  try{
			  if(s.equals("")){
				 JOptionPane.showMessageDialog(null, "Site field is empty"); 
			  }
			 
			  else{
				  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					msAccDB = "C:/Users/User/Documents/brem_database.accdb";
					dbURL = "jdbc:ucanaccess://" + msAccDB; 
					conn = DriverManager.getConnection(dbURL+";jackcessOpener=CryptCodecOpener", "", "brem"); 
					
		            st=conn.createStatement();
			             String sql="INSERT INTO site(site)values(?)";
			             ps =conn.prepareStatement(sql);
			             ps.setString(1, s);
			             
			             
			            //ps.setString(6, position);
			             
			             ps.executeUpdate();
			             
			             JOptionPane.showMessageDialog(null, "Record inserted successfully");
			            // textclear();
			                }

		  }
			      catch(Exception ex){
			      
			     JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
			  }
		
			  		
			  		 // Step 3: Closing database connection
		            try {
		                if(null != conn) {
		 
		                    // cleanup resources, once after processing
		                    ps.close();
		                    st.close();
		 
		                    // and then finally close connection
		                    conn.close();
		                }
		            }
		            catch (SQLException sqlex) {
		                sqlex.printStackTrace();
		            }}
		
		
	
	
	
	class StudentInfoHandler implements ActionListener
	{
		
		

		public void actionPerformed(ActionEvent e)
		{
			String s=e.getActionCommand();
			Object source=e.getSource();
			
			//klkk
			if(s.equals("Search"))
			{	/*Search_Dialog sa=new Search_Dialog();
			sa.setVisible(true);
			sa.setSize(400, 140);
			sa.setLocationRelativeTo(null);
			sa.setResizable(true);
			setVisible(false);*/
			

			}
			if(s.equals("Modify"))
			{
				ModifyInfo info=new ModifyInfo();
				info.setVisible(true);
				setVisible(false);

			}
			
			if(source == site_registration_item)
			{
				siteInsertionToDatabase();
			}
			
			if(source==signout_item||source==btn5)
			{
				Icon warning=new ImageIcon("images//warning.png");
				Icon question=new ImageIcon("images//question.png");
				int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?","Logout",JOptionPane.YES_NO_OPTION,1,question);

              	if(ans==JOptionPane.YES_OPTION)
              	{
              		setVisible(false);
              		main mMenuframe = new main();
              		mMenuframe.setVisible(true);
              		mMenuframe.setLocationRelativeTo(null);	
              		
              		
              	}
              	if(ans==JOptionPane.NO_OPTION)
              	{
              		JOptionPane.showMessageDialog(null,"Termination Attempt Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
              		
              		
              	}
			}
			if(source==about_software_item)
			{
				AboutDialog dl=new AboutDialog();
				dl.setVisible(true);
			}
			
			
			if(source==staffReg || source ==btn1)
			{
				registrationAdmin dl;
				try {
					dl = new registrationAdmin();
					dl.setSize(500, 370);
					dl.setLocationRelativeTo(null);
					dl.setVisible(true);
					setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			if(source==student_masterList|| source == btn3)
			{
				dailyoperationlog dl=new dailyoperationlog();
				
				dl.setSize(600, 600);
				dl.setLocationRelativeTo(null);
				dl.setVisible(true);
				setVisible(false);
				
			}
			if(source==btn10||source==administrative_item)
			{
				JOptionPane.showMessageDialog(null, "Work in progress.............");
				/*ChangePass pass=new ChangePass();
				pass.setVisible(true);
				setVisible(false);*/
			}
			
//calendar
			if(source==btn7||source==caln)
			{
				calcadmin l=new calcadmin();
				l.setVisible(true);

			}
			
			
			if(source==monthly_summary_item)
			{ 
				setVisible(false);
				new summaryForReport().setVisible(false);
			}
			
			if(source==staffList_item)
			{
				setVisible(false);
				stafflist cl=new stafflist();
				cl.setVisible(true);
			}
			if(source==nepa_List)
			{
				//setVisible(false);
				nepalist cl=new nepalist();
				cl.setSize(1320, 520);
				cl.setLocation(0, 20);
				cl.setVisible(true);
			}
			if(source==search_month_report)
			{
				
				report cl;
				try {
					setVisible(false);
					cl = new report();
					cl.setSize(1320, 520);
					cl.setLocation(0, 20);
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			if(source==generatornepa_List)
			{
				setVisible(false);
				
				nepageneratorlist cl=new nepageneratorlist();
				cl.setSize(1320, 520);
				cl.setLocation(0, 20);
				cl.setVisible(true);
			}
			
			if(source==btn12)
			{
				main ct=new main();
				ct.setVisible(true);
				//ct.setSize(790, 520);
				setVisible(false);
				
				
			}
			
			if (source == site_list_item) {
				setVisible(false);
				sitelist sam = new sitelist();
				sam.setLocationRelativeTo(null);
				sam.setVisible(true);
			}
			
			if(source == nepa_report_date_item)
			
			{
				setVisible(false);
				nepa_list_date ct=new nepa_list_date();
				ct.setVisible(true);
				ct.setSize(950, 520);
				ct.setLocation(50,50);
				
				
			}
			if(source == monthly_report_Item)
				
			{setVisible(false);
				Monthly_report ct;
				
				try {
					ct = new Monthly_report();
					ct.setSize(1320, 520);
					ct.setLocation(1, 10);
					ct.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			if(source == report_base_date_Item)
				
			{
				setVisible(false);
				
				NepaGeneratorViaDate ct=new NepaGeneratorViaDate();
				ct.setVisible(true);
				ct.setSize(1320, 520);
				ct.setLocation(0,0);
				setVisible(false);
				
				
			}
			  
			if(source == search_staff_item){
				setVisible(false);
				search_staff monthly_List = new search_staff();
				monthly_List.setVisible(true);
				monthly_List.setSize(880,520);
			}
			
			
			if(source == menu_generator_report){
				setVisible(false);
				MonthlyReportGenerator m = new MonthlyReportGenerator();
				m.setVisible(true);
				m.setSize(1200,520);
				m.setLocation(10,10);

				
			}
			
			if(source == menu_nepa_report){
				setVisible(false);
				MonthlyReportNepa m = new MonthlyReportNepa();
				m.setVisible(true);
				m.setSize(1200,520);
				m.setLocation(10,10);

				
			}
			if (source == help_shortcut_item) {
				JOptionPane.showMessageDialog(null, "Work in Progress...............");
			}
			
			if (source == feedback_item) {
				JOptionPane.showMessageDialog(null, "Work in Progress.................");
			}
			if(source == menu_nepa_generator_report){
				/*setVisible(false);
				MonthlyReportNepaGenerator m = new MonthlyReportNepaGenerator();
				m.setVisible(true);
				m.setSize(1200,520);
				m.setLocation(10,10);
*/
				
			}
			
			if(source==btn15 || source==about_us_item)
			{
				setVisible(false);
			adminAbout hlpKey = new adminAbout ("Vitae Topics & Explanation", "C://Java_Projects_Workspace//MichealProject//htmlfiles/advice.html");
			
				hlpKey.setVisible(true);
				hlpKey.setResizable(false);
				hlpKey.setLocationRelativeTo(null);
				hlpKey.show ();
				//setVisible(true);
				
			}
			
			
			if(source==exit_item){
				Icon warning=new ImageIcon("images//warning.png");
				Icon question=new ImageIcon("images//question.png");
				int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to Exit the Software?","Exit Applictation",JOptionPane.YES_NO_OPTION,1,question);

              	if(ans==JOptionPane.YES_OPTION)
              	{
              		System.exit(0);
              		
              		
              	}
              	if(ans==JOptionPane.NO_OPTION)
              	{
              		JOptionPane.showMessageDialog(null,"Termination Attempt Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
              		
              		
              	}
			}
			if(source==nepa_report_item)
			{
				nepalist ls=new nepalist();
				ls.setVisible(true);
				ls.setSize(1320,580);
				ls.setLocation(20,80);
				setVisible(false);
			}
			if(source == preview_all_report_item)
			{
				NepaGeneratorPreviewBaseSite ls=new NepaGeneratorPreviewBaseSite();
				ls.setVisible(true);
				ls.setSize(1320,580);
				ls.setLocation(20,80);
				setVisible(false);
			}
		}
	}
	class AboutDialog extends JDialog
	{
		JButton ok;
		Container c;
		AboutDialog()
		{
			super(Home.this,"About",true);
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+90, height2+80);
			setLocation(width2-20,height2-30);
			setResizable(false);
			setTitle("About");
			ok=new JButton("Ok");
			c=getContentPane();
			JPanel p=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("images//Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					Image img2=Toolkit.getDefaultToolkit().getImage("images//mainicon.png");
					t.addImage(img,1);
					t.addImage(img,2);
					while(true)
					{
						try
						{
							t.waitForID(1);
							t.waitForID(2);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width2+89,height+40,null);
					g.drawImage(img2,10,10,50,50,null);
				}

			};
			JLabel l=new JLabel("<html><font size=6 color=#800080<br><br><B>BREM OPERATION MANAGEMENT SYSTEM </B></dl></font><br><p><font size=4 color=blue align=left><B><dl>Developed By : </B></font><font size=4 color=#800000 align=left><B>SETNUMD TECHNOLOGIES</dd><br><p><font size=4 color=blue align=left><B><dl>Contact : </B></font><font size=4 color=#800000 align=left><B>+2348167137007<br><hr>+2348033739907<br><font size=4 color=green align=left>Email:</font>setnumd@gmail.com</dd><dd><font size=3 color=black><br><center>version 1.0<br>Copyright 2017 All Rights Reserved");
			p.add(l);
			c.add(p);
			JPanel butpan=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("images//Gradien.jpg");
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
					g.drawImage(img,0,0,660,660,null);
				}

			};
			butpan.add(ok);
			c.add("South",butpan);
			ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			});
		}
		public void paintComponent(Graphics g)
		{
			Image img=Toolkit.getDefaultToolkit().getImage("images//mainicon.gif");
			ImageIcon ic=new ImageIcon(img,"Center");
			g.drawImage(img,20,30,20,30,null);
		}
	}
	
	class CourseHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			/*cr = new CourseAddition();
			cr.setVisible(true);*/
		}
	}




class ModifyInfo extends JFrame
{
	Container c=getContentPane();
	JTable table;
	JPanel main;
	DefaultTableModel model;
	ModifyDialog mdl;
	String stcode;
	ModifyInfo()
	{
		setSize(1350,600);
		setTitle("Staff Information");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				Home sam=new Home();
				sam.setVisible(true);
				sam.setLocationRelativeTo(null);
			//	payroll_list.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
			}});
		
		ModifyInfo.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Row To Modify");
		JPanel title=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//HEADER.gif");
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
				g.drawImage(img,0,0,1350,100,null);
			}
		};
		title.add(l);
		c.add("North",title);

		main=new JPanel();
		main.setLayout(new BorderLayout());
		
		try
		{
			 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
 			
 			conn = DriverManager.getConnection(url,"root","");
 			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from staff");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			DefaultTableModel model=new DefaultTableModel(new String[]{"Staff_ID","Name","Address","Position","Email","State","phone_Number","Certification","L.G.A ","DOB","DOE","Gender ","Guar.Name","Guar.Num." ,"Guar.Address"},row);
			
			
			table=new JTable(model);
			set=st.executeQuery("select * from staff");
			while(set.next())
			{
				model.setValueAt(set.getString(1).trim(),i,0);
				model.setValueAt(set.getString(2).trim(),i,1);
				model.setValueAt(set.getString(3).trim(),i,2);
				model.setValueAt(set.getString(4).trim(),i,3);
				model.setValueAt(set.getString(5).trim(),i,4);
				model.setValueAt(set.getString(6).trim(),i,5);
				model.setValueAt(set.getString(7).trim(),i,6);
				model.setValueAt(set.getString(8).trim(),i,7);
				model.setValueAt(set.getString(9).trim(),i,8);
				model.setValueAt(set.getString(10).trim(),i,9);
				model.setValueAt(set.getString(11).trim(),i,10);
				model.setValueAt(set.getString(12).trim(),i,11);
				model.setValueAt(set.getString(13).trim(),i,12);
				model.setValueAt(set.getString(14).trim(),i,13);
				model.setValueAt(set.getString(15).trim(),i,14);
				
				i++;
			}
			table=new JTable(model);
		}
		catch(Exception ex)
		{
		}
		JScrollPane sp=new JScrollPane(table);
		main.add(sp);
		
		table.addMouseListener(new ModifyStudList());
		table.setSelectionMode(0);
		table.setToolTipText("Select The ROW For Modify");
		table.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(1);
		table.setEditingColumn(3);
		table.setEnabled(false);
		table.setFont(new Font("Times New Roman",Font.PLAIN,13));
		table.setForeground(Color.MAGENTA);
		table.setGridColor(new Color(0,128,192));
	  	table.setBackground(new Color(0,128,192));
        table.getTableHeader().setReorderingAllowed(false);
        
        c.add(main);
      
	}
		
		class SelectedCourse implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				//String cors=(String)cour.getSelectedItem();
				try
				{
					int x=0;
					st=conn.createStatement();
					ResultSet set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						//if(cr.equals(cors))
							break;
					}

					if(dur.equals("Two Semester")||dur.equals("One Year"))
						x=1;
					if(dur.equals("Four Semester")||dur.equals("Two Year"))
						x=2;
					if(dur.equals("Six Semester")||dur.equals("Three Year"))
						x=3;
					if(dur.equals("Eight Semester")||dur.equals("Four Year"))
						x=4;

					//appyredmd.removeAllItems();
					//int y=Integer.parseInt((String)appyrstmd.getSelectedItem());
				//	y=y+x;
					//appyredmd.addItem(Integer.toString(y));
					st.close();
					int row=0;
					int i=0;
					//String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
					//PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					//ps.setString(1,appyear);
					ResultSet stset=ps.executeQuery();

					while(stset.next())
					{
						row++;
					}
					model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
			//		ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					//ps.setString(1,appyear);
					stset=ps.executeQuery();
					while(stset.next())
					{
						model.setValueAt(stset.getString(1).trim(),i,0);
						String ft=stset.getString(2).trim();
						ft=ft+" "+stset.getString(4).trim();
						model.setValueAt(ft,i,1);
						model.setValueAt(stset.getString(6).trim(),i,2);
						i++;
					}
				//	stud.setModel(model);

				}
				catch(Exception ex)
				{
				}
			}
		}
		
		void powerSelection(){
			
			
			
			
		}
		
		
		class ModifyStudList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				int ro=table.getSelectedRow();
				stcode=(String)table.getValueAt(ro,0);
				mdl=new ModifyDialog(stcode);
				mdl.setSize(800,660);
				mdl.setLocationRelativeTo(null);
				mdl.setResizable(false);
				mdl.setVisible(true);
				setVisible(false);
			}
		}
		
				public class ModifyDialog extends JDialog implements ActionListener {
					private JLabel lblsId,lblfName,lblPosition,lblsofOrigin,lblpNumber,lblLGA,lblDOE,lblCert,lblAddress,lblGender,lblEmail,lblgName,lblgpNumber,lblgAddress;
						private JPanel main;
						String mstud;
						private JTextField txtsCode,txtfName,txtEmail,txtpNumber,txtLGA,txtCert,txtgName,txtgpNumber,txtPosition,txtDob,txtDoe,txtGender;
						private JComboBox cmbsofOrigin;
						JTextArea addfield1,gAddress;
						private JButton btnUpdate,btnClear,btnCancel;
						
						String[] Day1={"DAYS","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
						String[] month1={"MONTH","January","February","March","April","May","June","July","August","September","October","November","December",};
						String[] yrs1={"YEAR","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};

						
						String[] state={"select","Abia" ,"Adamawa","Akwa-Ibom","Bauchi","Bayelsa","Benue","Borno","Cross-River","Delta","Ekiti","Ebonyi","Edo","Enugu","Gombe","Imo","Jigawa","Kaduna","Kastina","Kano","Kebbi","Kogi","Kwara","Lagos","Nassarawa","Niger","Ogun","Ondo","Osun","Oyo","Plateau","Rivers","Sokoto","Taraba","Yobe","Zamfara","FCT"};
						PreparedStatement ps=null;
						CheckboxGroup cbmf;
						Checkbox cbm,cbf;
						//ModifyStud ms=new ModifyStud();
						ModifyDialog(String s){
							mstud=s;
							main=new JPanel();
							main=new JPanel()
							{
								public void paintComponent(Graphics g)
								{
									Toolkit kit=Toolkit.getDefaultToolkit();
									Image img=kit.getImage("images//backgroud.jpg");
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
									g.drawImage(img,0,0,800,650,null);
								}
							};
							
							
							
							setSize(800,670);
							setLocation(20,20);
							setResizable(false);
							main.setLayout(null);
						
						
						
						
						
						
						lblsId=new JLabel("<html><b><i>Staff ID Number:</i></b></html>");
						main.add(lblsId).setBounds(10,60,500,20);
						//scode=new JTextField();
						txtsCode=new JTextField(10);
						txtsCode.setEditable(false);
						txtsCode.setToolTipText("Staff Identification Number");
						txtsCode.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtsCode.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtsCode).setBounds(120,62,200,20);
						
						lblfName=new JLabel("<html><b><i>Staff Full name :</i></b></html>");
						main.add(lblfName).setBounds(10,90,500,20);
						txtfName=new JTextField(20);
						main.add(txtfName).setBounds(120,92,550,20);
						//sname.addKeyListener(onlyText);
						txtfName.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtfName.setToolTipText("Enter Staff full Name");
						txtfName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						
						
						
						lblPosition=new JLabel("<html><b><i>Position :</i></b></html>");
						//main.add(lblPosition).setBounds(10,210,500,20);
						main.add(lblPosition).setBounds(10,240,500,20);
						
						txtPosition=new JTextField(20);
						txtPosition.setFont(new Font("Times New Roman",Font.ITALIC,18));
						//lname.addKeyListener(onlyText);
						txtPosition.setToolTipText("Enter Staff Email Address");
						txtPosition.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtPosition).setBounds(120,242,200,20);
						
						
						lblEmail=new JLabel("<html><b><i>Email :</i></b></html>");
						//main.add(lblEmail).setBounds(10,240,500,20);
						main.add(lblEmail).setBounds(10,210,500,20);
						
						txtEmail=new JTextField(20);
						txtEmail.setFont(new Font("Times New Roman",Font.ITALIC,18));
						//txtEmail.addKeyListener(onlyText);
						txtEmail.setToolTipText("Enter Staff Email Address");
						txtEmail.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtEmail).setBounds(120,212,500,20);
						
						//
						
						
						lblpNumber=new JLabel("<html><b><i>Phone Number :</i></b></html>");
						main.add(lblpNumber).setBounds(380,240,500,20);
						txtpNumber=new JTextField(20);
						//txtpNumber.addKeyListener(onlyText);
						txtpNumber.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtpNumber.setToolTipText("Enter Staff Phone number ");
						txtpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtpNumber).setBounds(490,242,200,20);

						lblsofOrigin=new JLabel("<html><b><i>State Of Origin :</i></b></html>");
						main.add(lblsofOrigin).setBounds(10,270,500,20);
						cmbsofOrigin=new JComboBox(state);
						cmbsofOrigin.setFont(new Font("serif",Font.ITALIC,15));
						cmbsofOrigin.setToolTipText("Select The State");
						cmbsofOrigin.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						cmbsofOrigin.setEditable(false);
						cmbsofOrigin.setMaximumRowCount(5);
						main.add(cmbsofOrigin).setBounds(120,270,100,25);
						
						
						lblLGA=new JLabel("<html><b><i>Local Govt. Area :</i></b></html>");
						main.add(lblLGA).setBounds(10,310,500,20);
						txtLGA=new JTextField(20);
						//txtLGA.addKeyListener(onlyText);
						txtLGA.setToolTipText("Enter Local Government Area");
						txtLGA.setFont(new Font("Times New Roman",Font.ITALIC,18));
						
						txtLGA.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtLGA).setBounds(120,312,200,20);
						
						lblGender=new JLabel("<html><b><i>Gender :</i></b></html>");
						main.add(lblGender).setBounds(380,310,100,20);
						txtGender =new JTextField();
						txtGender.setBounds(490,315,90,15);
						main.add(txtGender);
					  
						lblDOE=new JLabel("<html><b><i>Date Of Birth :</i></b></html>");
					   	main.add(lblDOE).setBounds(10,350,200,20);
					   	
					   txtDob=new JTextField();
						main.add(txtDob).setBounds(120,350,80,20);
					   
						lblDOE=new JLabel("<html><b><i>Date Of Employment :</i></b></html>");
					   	main.add(lblDOE).setBounds(380,350,200,20);
					   	 txtDoe=new JTextField();
					   	txtDoe.setFont(new Font("serif",Font.BOLD,12));
					 	txtDoe.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					   	main.add(txtDoe).setBounds(510,350,80,20);
					   	

					   	lblCert=new JLabel("<html><b><i>Certification :</i></b></html>");
						main.add(lblCert).setBounds(380,270,500,20);
						txtCert=new JTextField(20);
						//txtCert.addKeyListener(onlyText);
						txtCert.setFont(new Font("Times New Roman",Font.ITALIC,18));
						
						txtCert.setToolTipText("Enter Staff Certification");
						txtCert.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtCert).setBounds(490,272,200,20);
						
						lblAddress=new JLabel("<html><b><i>Address :</i></b></html>");
						main.add(lblAddress).setBounds(10,120,500,20);
						
						
						
						addfield1=new JTextArea(2,20);
						addfield1.setToolTipText("Enter Staff Address");
						addfield1.setFont(new Font("Times New Roman",Font.ITALIC,18));
						addfield1.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						addfield1.setWrapStyleWord(true);
						addfield1.setLineWrap(true);
						
						JScrollPane addfield=new JScrollPane(addfield1);
						main.add(addfield).setBounds(120,122,550,80);
						

					   

						JLabel l=new JLabel("<html><font size=6 color=#800080><i>Enter The  Guarantor Details Below Correctly.");
						l.setBounds(100,370,900,80);
						main.add(l);
							
						JLabel lbl1 = new JLabel(new ImageIcon("images//HEADER.gif"));
						lbl1.setBounds(0,390,900,50);
						main.add(lbl1);
						
						lblgName=new JLabel("<html><b><i>Guarantor Name :</i></b></html>");
						main.add(lblgName).setBounds(10,450,500,20);
						txtgName=new JTextField();
						txtgName.setToolTipText("Enter The Guarantor Full Name");
						txtgName.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtgName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255))); 
						main.add(txtgName).setBounds(120,452,500,23);
						
						lblgpNumber=new JLabel("<html><b><i>Phone Number :</i></b></html>");
						main.add(lblgpNumber).setBounds(10,480,500,20);
						txtgpNumber=new JTextField(20);
						//txtgpNumber.addKeyListener(onlyText);
						txtgpNumber.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtgpNumber.setToolTipText("Enter The Guarantor Phone number ");
						txtgpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtgpNumber).setBounds(120,482,200,20);
						
						
						lblgAddress=new JLabel("<html><b><i>Address :</i></b></html>");
						main.add(lblgAddress).setBounds(10,510,500,20);
						gAddress=new JTextArea(2,20);
						gAddress.setFont(new Font("Times New Roman",Font.ITALIC,18));
						gAddress.setToolTipText("Enter The Guarantor Address");
						gAddress.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						gAddress.setWrapStyleWord(true);
						gAddress.setLineWrap(true);
						
						JScrollPane gAddress1=new JScrollPane(gAddress);
						
						main.add(gAddress1).setBounds(120,512,550,80);
						
						btnUpdate=new JButton("Update");
						main.add(btnUpdate).setBounds(250,610,100,20);
						btnUpdate.addActionListener(this);
						btnClear=new JButton("Clear");
						main.add(btnClear).setBounds(380,610,100,20);
						btnClear.addActionListener(this);
					
						btnCancel=new JButton("Cancel");
						main.add(btnCancel).setBounds(500,610,100,20);
					btnCancel.addActionListener(this);	
						
						getContentPane().add(main,BorderLayout.CENTER);
						
						
				
				
						try {
							
							
							
							
							st=conn.createStatement();
							
							
							ResultSet minfo=st.executeQuery("select * from staff order by staffid");
							
							String stco="";
							while(minfo.next())
							{
								stco=minfo.getString(1).trim();
								if(stco.equals(mstud))
									break;
									
									
						}
							
							txtsCode.setText(stco);
							txtfName.setText(minfo.getString(2));
							addfield1.setText(minfo.getString(3));
							txtEmail.setText(minfo.getString(5));
							txtPosition.setText(minfo.getString(4));
							cmbsofOrigin.setSelectedItem(minfo.getString(6));
							txtpNumber.setText(minfo.getString(7).trim());
							txtCert.setText(minfo.getString(8));
							txtLGA.setText(minfo.getString(9));
							txtDob.setText(minfo.getString(10));
							txtDoe.setText(minfo.getString(11));
							txtGender.setText(minfo.getString(12));
							txtgName.setText(minfo.getString(13));
							txtgpNumber.setText(minfo.getString(14));
							gAddress.setText(minfo.getString(15));
							
							
							
						}
						catch(Exception ed)
						{
							ed.printStackTrace();
							//ed.getMessage();
						//	System.out.println(ed);
					
						} 
				
						}

						 public  void UpdateRecords(){
							   String url = "jdbc:mysql://localhost:3306/rakedomanagement";
								
								try {
									conn = DriverManager.getConnection(url,"root","");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								//private	JTextField txtsCode,txtfName,txtEmail,txtpNumber,txtLGA,txtCert,txtgName,txtgpNumber,txtPosition,txtDob,txtDoe,txtGender;
								
								
								
								
								
								//UPDATE `staff` SET `staffid`=[value-1],`fName`=[value-2],`address`=[value-3],`position`=[value-4],`email`=[value-5],`sofOrigin`=[value-6],`phone`=[value-7],`cert`=[value-8],`lgArea`=[value-9],`dob`=[value-10],`doe`=[value-11],`gender`=[value-12],`gname`=[value-13],`gpnumber`=[value-14],`gaddress`=[value-15] WHERE 1
								
								
								
								String update1 = "Update staff set staffid = '" + txtsCode.getText() +"' where staffid = '" + txtsCode.getText() + "'" ;
								
								
								
								
								
								
								
							String update2 = "Update staff set fName = '" + txtfName.getText() +"' where staffid = '" + txtsCode.getText() + "'" ;
						      String update3 = "Update staff set address = '" + addfield1.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update4 = "Update staff set email = '" + txtEmail.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
							  String update5 = "Update staff set position = '" + txtPosition.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update6 = "Update staff set sofOrigin = '" + cmbsofOrigin.getSelectedItem() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update7 = "Update staff set phone = '" + txtpNumber.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update8 = "Update staff set cert = '" + txtCert.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update9 = "Update staff set lgArea = '" + txtLGA.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update10 = "Update staff set dob = '" + txtDob.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update11= "Update staff set doe = '" + txtDoe.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update12 = "Update staff set gender = '" + txtGender.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update13= "Update staff set gname = '" + txtgName.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update14= "Update staff set gpnumber = '" + txtgpNumber.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update15= "Update staff set gaddress = '" + gAddress.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      
						      
						      try{
						          st = conn.createStatement();
						          st.executeUpdate(update1);
						          st.executeUpdate(update2);
						          st.executeUpdate(update3);
						          st.executeUpdate(update4);
						          st.executeUpdate(update5);
						          st.executeUpdate(update6);
						          st.executeUpdate(update7);
						          st.executeUpdate(update8);
						          st.executeUpdate(update9);
						          st.executeUpdate(update10);
						          st.executeUpdate(update11);
						          st.executeUpdate(update12);
						          st.executeUpdate(update13);
						          st.executeUpdate(update14);
						          st.executeUpdate(update15);
						          
						          
						        st.close();
						          conn.close();
						      }
						      catch(SQLException ex){
						          System.err.println(ex.getMessage());
						      }
						      JOptionPane.showMessageDialog(null,"Update Finished!");
						     // fillEmpty();
						     // clearText();
						     dispose();
						     
						    // ModifyStudList
						     ModifyInfo sam=new  ModifyInfo();
						     
								sam.setVisible(true);
								//sam.setSize(490,510);
								sam.setLocationRelativeTo(null);
								//payroll_list.setDefaultLookAndFeelDecorated(true);
								setVisible(false);
						
						  }

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							
							Object obj = e.getSource();
							
							if(obj==btnCancel){
								ModifyInfo sam=new ModifyInfo();
								sam.setSize(1200, 520);
								sam.setVisible(true);
								sam.setLocationRelativeTo(null);
								setVisible(false);
							// TODO Auto-generated method stub
							}
							
							if(obj==btnClear){
								
								//fillEmpty();
								
							}
							
							
							if(obj==btnUpdate){
								
								 UpdateRecords();
								
									

								
							
						}
						}
						 
						 
						 
						 
						
			}
				
		
}

class ChangePass extends JDialog
{
	JTextField txtUsername;
	JPasswordField txtOldPassword;
	JPasswordField txtNewPassword;
	JPasswordField txtComfirmNewPassword;
	ResultSet set;
	ChangePass()
	{
		super(Home.this,"Change Password",true);

		final int width2=screenSize.width/3;
		final int height2=screenSize.height/3;
		setSize(width2,height2);setLocation(screenSize.width/3+20,screenSize.height/4+40);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//StaffsInfo.setDefaultLookAndFeelDecorated(true);
		Container c=getContentPane();
		txtUsername=new JTextField(10);
		txtUsername.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
		txtOldPassword=new JPasswordField(10);
		txtOldPassword.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
		txtNewPassword=new JPasswordField(10);
		txtNewPassword.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
		txtComfirmNewPassword=new JPasswordField(10);
		txtComfirmNewPassword.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));

		JPanel main=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//Gradien.jpg");
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
				g.drawImage(img,0,0,460,230,null);
			}
		};
		main.setLayout(new BorderLayout());
		Box vbox=Box.createVerticalBox();
		JPanel chun1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//Gradien.jpg");
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
				g.drawImage(img,0,0,660,660,null);
			}
		};
		chun1.add(new JLabel("    Username     "));
		chun1.add(txtUsername);
		chun1.setForeground(Color.RED);
		txtUsername.setForeground(Color.BLUE);
		chun1.setBackground(Color.white);
		//chuname1.setBackground(Color.WHITE);
		vbox.add(chun1);

		JPanel chpas1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//Gradien.jpg");
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
				g.drawImage(img,0,0,660,660,null);
			}
		};
		
		
		chpas1.add(new JLabel("  Old Password         "));
		txtOldPassword.setBackground(Color.white);
		chpas1.add(txtOldPassword);
		vbox.add(chpas1);

		JPanel chun2=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//Gradien.jpg");
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
				g.drawImage(img,0,0,660,660,null);
			}
		};
		chun2.add(new JLabel("New Password  "));
		chun2.add(txtNewPassword);
		vbox.add(chun2);

		JPanel chpas2=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//Gradien.jpg");
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
				g.drawImage(img,0,0,660,660,null);
			}
		};
		chpas2.add(new JLabel("Comfirm Password     "));
		chpas2.add(txtComfirmNewPassword);
		vbox.add(chpas2);
		vbox.add(Box.createVerticalStrut(20));

		JButton ok=new JButton("Ok");
		JButton clear=new JButton("clear");
		JButton exit=new JButton("exit");
		Box butpan=Box.createHorizontalBox();
		butpan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		butpan.add(ok);
		butpan.add(Box.createHorizontalStrut(20));
		butpan.add(clear);
		butpan.add(Box.createHorizontalStrut(20));
		butpan.add(exit);
		vbox.add(butpan);
		main.add(vbox);
		c.add(main);

		ok.setToolTipText("Save Password");
		clear.setToolTipText("Clear Text");
		exit.setToolTipText("Exit");
		txtUsername.setToolTipText("Enter User Name");
		txtOldPassword.setToolTipText("Enter Old Password");
		txtNewPassword.setToolTipText("Enter New Password");
		txtComfirmNewPassword.setToolTipText(" Comfirm New password");


		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				txtUsername.setText("");
				txtOldPassword.setText("");
				txtNewPassword.setText("");
				txtComfirmNewPassword.setText("");

			}
		});
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Icon warning=new ImageIcon("images//warning.png");
				Icon question=new ImageIcon("images//question.png");
				int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to Exit?","Exit",JOptionPane.YES_NO_OPTION,1,question);

              	if(ans==JOptionPane.YES_OPTION)
              	{
              		setVisible(false);
              		Home mMenuframe = new Home();
              		mMenuframe.setVisible(true);
              		mMenuframe.setLocationRelativeTo(null);	
              		
              		
              	}
              	if(ans==JOptionPane.NO_OPTION)
              	{
              		JOptionPane.showMessageDialog(null,"Termination Attempt Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
              		
              		
              	}
				
				
			}
		});

		chpass2.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if((e.getKeyCode())==KeyEvent.VK_ENTER)
				{
					boolean flag=false;
					String s="";
					s=txtUsername.getText();
					char a[]=((JPasswordField) txtUsername).getPassword();
					String u_name=null;
					String p_name=null;
					try
					{
				
					
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			  			
			  			String msAccDB = "C:/Users/User/Documents/brem_database.accdb";
			             String dbURL = "jdbc:ucanaccess://" + msAccDB; 
			             conn = DriverManager.getConnection(dbURL); 
					
						
						
			            // Step 2.B: Creating JDBC Statement 
			            st = conn.createStatement();
			 
			            // Step 2.C: Executing SQL & retrieve data into ResultSet
			            resultSet = st.executeQuery("SELECT * FROM registration");
			 
					
					
					
					
					
					set.next();
					u_name=set.getString(1);
					p_name=set.getString(2);
					}
					catch(Exception ex)
					{
					}
					if(s.equals(u_name) && a.length==p_name.length())
					{
						for(int i=0;i<p_name.length();i++)
						{
						  if(a[i]==p_name.charAt(i))
							   flag=true;
						  else
						  {
							   flag=false;
							   break;
						  }

						}
					 }
					if(flag==true)
					{
						if(chuname2.getText().equals("") || chpass2.getPassword().length==0)
						{
							Icon error=new ImageIcon("images//error.png");
							JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
						}
						else
						{


						try
						{
							
						PreparedStatement ps=conn.prepareStatement("UPDATE registration set username=?,password=? where username=?");
						ps.setString(1,chuname2.getText());
						ps.setString(2,String.copyValueOf(chpass2.getPassword()));
						ps.setString(3,chuname1.getText());
						ps.execute();
						Icon info=new ImageIcon("images//info.png");
						JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=green>Password Is Change</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
						dispose();
						}
						catch(Exception e2)
						{
						}
						}

					}
					else
					{
						Icon error=new ImageIcon("images//error.png");
						 JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
					}
				}
			}
		});
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					boolean flag=false;
					String s="";
					s=chuname1.getText();
					char a[]=chpass1.getPassword();
					String u_name=null;
					String p_name=null;
					try
					{
						
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			  			
			  			String msAccDB = "C:/Users/User/Documents/brem_database.accdb";
			             String dbURL = "jdbc:ucanaccess://" + msAccDB; 
			             conn = DriverManager.getConnection(dbURL); 
			            
			             st=conn.createStatement();
			             
						set=st.executeQuery("Select * from registration");
						set.next();
						u_name=set.getString(2);
						p_name=set.getString(3);
						
					}
					catch(Exception ex)
					{
					}
					if(s.equals(u_name) && a.length==p_name.length())
					{
						for(int i=0;i<p_name.length();i++)
						{
						  if(a[i]==p_name.charAt(i))
						   flag=true;
						  else
						  {
						   flag=false;
						   break;
						  }
						}
					 }
					if(flag==true)
					{
						if(chuname2.getText().equals("")|| chpass2.getPassword().length==0)
						{
							Icon error=new ImageIcon("images//error.png");
							JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
						}
						else
						{

						try
						{

							PreparedStatement ps=conn.prepareStatement("UPDATE registration set username=?,password=? where username=?");
							ps.setString(1,chuname2.getText());
							ps.setString(2,String.copyValueOf(chpass2.getPassword()));
							ps.setString(3,chuname1.getText());
							ps.execute();
							Icon info=new ImageIcon("images//info.png");
							JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=green>Password Is Change</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
							dispose();
						}
						catch(Exception e2)
						{
						}
						}
					}
					else
					{
						 Icon error=new ImageIcon("images//error.png");
						 JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
					}


			}
		});


	}

}
	
public static void main(String[] args) {
	MainPage sa=new  MainPage();
	 sa.setLocationRelativeTo(null);
	 
	sa.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
