package codelagos.bank.system2;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import javax.swing.Timer;

//class LoginFirst
//{
//	public static void main(String args[])
//	{
//		Frame f=new Frame();
//		f.setVisible(true);
//		f.setDefaultCloseOperation(3);
//		
//		
//	}
//}
class LoginFirst extends JFrame
{
	
	JTextField tf=new JTextField(12);
	
	JPasswordField pf=new JPasswordField(12);
	Connection conn;
	Statement stat;
	ResultSet set;
	
	JPanel progressPanel;
	JProgressBar bar;
	private Timer activityMonitor;
	private SimulatedActivity activity;
	Container c;
	JPanel main;
	int width;
	int height;
	Dimension screenSize;
	private String msAccDB;
	private String dbURL;
	private Statement st;
        DatabaseConnection databaseConnection = new DatabaseConnection();
	LoginFirst()
	{
            
             
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/3;
		height=screenSize.height/3;
		setSize(width,height);
		setResizable(false);
		setLocation(screenSize.width/3,screenSize.height/4);
		//MainMenuFrame.setDefaultLookAndFeelDecorated(true);
		
		setTitle("Login");
		

		c=getContentPane();
                Image img=Toolkit.getDefaultToolkit().getImage("images//codelagos.jpg");
		setIconImage(img);
		tf.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
		pf.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
		tf.setMaximumSize(tf.getPreferredSize());
		pf.setMaximumSize(tf.getPreferredSize());
		tf.setText("codelagos");
                tf.setCaretPosition(tf.getText().length());
		JButton ok=new JButton("OK");
		JButton clear=new JButton("Clear");
		JButton exit=new JButton("Exit ");
		exit.setMnemonic(KeyEvent.VK_F4);
		//changepw=new JButton("Change Password");
		progressPanel=new JPanel()
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
				g.drawImage(img,0,0,width,height+100,null);
			}

		};
		bar=new JProgressBar();
		bar.setStringPainted(true);
		bar.setMaximum(1000);
		bar.setString("Loading...");
		progressPanel.add(bar);
		bar.setVisible(false);
		c.add("South",progressPanel);
		activity = new SimulatedActivity(1000);
        activity.start();
		activityMonitor = new Timer(500, new
		 ActionListener()
		 {
			public void actionPerformed(ActionEvent event)
			{
			   int current = activity.getCurrent();

			   // show progress
			   bar.setValue(current);

			   // check if task is completed
			   if (current == activity.getTarget())
			   {
				  activityMonitor.stop();
				
				
				CodeLagosBankSystem2 bankSystem2 = new CodeLagosBankSystem2();
                                bankSystem2.setLocation(300, 100);
                                bankSystem2.setResizable(false);
                                bankSystem2.setSize(550, 430); 
                                bankSystem2.setVisible(true);
                        
				 try
				 {
					DataInputStream sin=new DataInputStream(new FileInputStream("images//status.dat"));
					String st=sin.readUTF();
					boolean flag=false;
					if(st.equals("true"))
						flag=true;
					
				  	
				}
				 catch(Exception ex)
				 {
				 }
				  ;


				dispose();
			   }
			}
 		});
 		main=new JPanel()
 		{
                        @Override
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
				g.drawImage(img,0,0,width,height+20,null);
			}
		};
		JPanel im=new JPanel()
		{
                        @Override
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
				g.drawImage(img,0,0,width,height,null);
			}

		};
		//im.add(changepw);
		main.setLayout(new GridBagLayout());
		GridBagConstraints cons=new GridBagConstraints();
		cons.fill=GridBagConstraints.HORIZONTAL;
		cons.anchor=GridBagConstraints.EAST;
		cons.weightx=10;
		cons.weighty=00;

		cons.insets = new Insets(7, 25, 0, 5);
                JLabel lblUsername = new JLabel("<html><b>Username ");
                lblUsername.setForeground(Color.white);
                lblUsername.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		add(lblUsername,cons,0,0,1,1);
		
                cons.insets = new Insets(0, 25, 0, 0);
                JLabel lblPassword = new JLabel("<html><b>Password");
                lblPassword.setForeground(Color.white);
                lblPassword.setFont(new Font("Times New Roman", Font.ITALIC, 18));
                add(lblPassword,cons,0,1,1,1);
		cons.fill=GridBagConstraints.BOTH;
		cons.weightx=40;
		cons.insets = new Insets(7, 0, 5, 13);

		add(tf,cons,1,0,2,1);
		cons.insets = new Insets(0, 0, 5, 13);
		add(pf,cons,1,1,2,1);
		cons.insets = new Insets(10, 5, 0, 0);
                ok.setForeground(Color.magenta);
                exit.setForeground(Color.magenta);
                clear.setForeground(Color.magenta);
		add(ok,cons,0,2,1,1);
		cons.insets = new Insets(10, 5, 0, 0);
		add(clear,cons,1,2,1,1);
		cons.insets = new Insets(10, 5, 0, 5);
		add(exit,cons,2,2,1,1);
		cons.insets = new Insets(10, 0, 0, 0);
		add(im,cons,0,3,3,1);
		ok.setToolTipText("Save Password");
		clear.setToolTipText("Clear Text");
		exit.setToolTipText("Exit");
		tf.setToolTipText("Enter the User Name");
		pf.setToolTipText("Enter the Password");
		
		//changepw.setToolTipText("Change The password");
		
		pf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if((e.getKeyCode())==KeyEvent.VK_ENTER)
				{
				boolean flag=false;
				String s="";
				s=tf.getText();
				char a[]=pf.getPassword();
				String u_name=null;
				String p_name=null;
			
				
				
				
				if(s.isEmpty())
				{
					setSize(width,height);
					bar.setVisible(true);
					activityMonitor.start();

				}
				else
				{
					Icon error=new ImageIcon("images//error.png");
					 JOptionPane.showMessageDialog(LoginFirst.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
				}
			}
			}
		});

		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
                            char[] pass = pf.getPassword();
                            String password = new String(pass);
				
                                String s=tf.getText();

				
				if(password.equals("codelagos") && (s.equals("codelagos")))
				{
                                    
					
					setSize(width,height);
					bar.setVisible(true);
					activityMonitor.start();
					
					
				}
				else
				{
					Icon error=new ImageIcon("images//error.png");
					 JOptionPane.showMessageDialog(LoginFirst.this,"<html><font size=4 color=red>Invalid Password \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
				}
			}
		});
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				tf.setText("");
				pf.setText("");

			}
		});
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});



	}
	public void add(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
	{
		cons.gridx=x;
		cons.gridy=y;
		cons.gridwidth=w;
		cons.gridheight=h;
		comp.setPreferredSize(comp.getPreferredSize());
		main.add(comp,cons);
		c.add(main);
	}
	class SimulatedActivity extends Thread
	{
	   /**
	      Constructs the simulated activity thread object. The
	      thread increments a counter from 0 to a given target.
	      @param t the target value of the counter.
	   */
	   public SimulatedActivity(int t)
	   {
	      current = 0;
	      target = t;
	   }

	   public int getTarget()
	   {
	      return target;
	   }

	   public int getCurrent()
	   {
	      return current;
	   }

	   public void run()
	   {
	      try
	      {
                  databaseConnection.open();//open database
	         while (current < target)
	         {
                     
	            sleep(5);
	            current++;
	         }
	      }
	      catch(InterruptedException e)
	      {
	      }

	   }

	   private int current;
	   private final int target;
	   
	}


	
	public static void main(String args[])
	{
            {
		try{
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			System.out.println("error in loading theme "+e.getMessage());
		}
                }
		Events events = new Events();
                events.loginWindowOpen();
		}
	
}