
import java.awt.Color;  // abstract window toolkit - graphical UI to applications - creates static components
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.*; // used to provide the life to static components.
import java.sql.*;
import javax.swing.*; // enhance graphical interface
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

// jab bhi koi class kisi interface ko implement karti he to uss interfcace ka koi bhi method ko uss class me overrride karwana padta he
public class login extends JFrame implements ActionListener // jo bhi method Jframe class me he wo login class bhi use kar sktra he - inheritance
{
	/*
      JFrame is used when working with Swing.
      JFrame creates the view and ActionListener is used to create the application responsive, i.e., control what happens when user clicks on a button etc.
      To implement the ActionListener, we need to override the actionPerformed method.
    */
	static JFrame f = new JFrame("RaktSeva - Login");
	JLabel JL1,JL3,JL4,JL5; //These are basically the text views - name,password
	JComboBox JCB1; //dropdown menu option
	JTextField JT1,JT2; //These are the places where user enters the data (edit texts)
	JPasswordField JP1; //The text field in which the input method is of type password. ( dot dot type)
	JButton JB1,JB2,JB3,JB4,JB5,JB6; //The buttons
	JComboBox JR1;

	/* JB1 Login
	 * JB2 FORGOT PASSWORD
	 * JB3 SIGNUP
	 * JB4 RESET
	 */
	login() { //in this constructor, we will define the global variables
		setContentPane(new JLabel((new ImageIcon(("C:\\Users\\star\\Downloads\\img_5.jpeg.jpg")))));


		setTitle("Blood Bank Management System"); // method or function
		// This is the title which appears at the top of the application

		//Labels
		JL1=new JLabel(" RaktSeva - Blood Bank ");
		JL1.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,38));//using the HTML properties
		JL1.setForeground(Color.red);
		//Here, Trebuchet MS is the font, 38 is the text size and CENTER_BASELINE is its position in the particular block
        JL5=new JLabel("Click Here");
		JL5.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,12));//using the HTML properties
		JL5.setForeground(Color.red);
		String X[]= {"ID","PhoneNumber"};
		JCB1=new JComboBox(X);
		JCB1.setFont(new Font("",Font.BOLD,15));

		JL3=new JLabel("Password:");
		JL3.setFont(new Font("Trebuchet MS",Font.BOLD,20));

		JL4=new JLabel("User Type:"); // user type - donor or staff
		JL4.setFont(new Font("Trebuchet MS",Font.BOLD,15));

		//Text and password
		String user[]= {"Donor","Staff"};

		JR1=new JComboBox(user);

		JT1=new JTextField(15); //Here, 15 means that the text entry can be of length 15(i.e., 15 columns) // text can be id or password
		JP1=new JPasswordField(8);

		//Buttons
		JB1=new JButton("Login"); //Login is the argument. It appears on the button
		JB1.setForeground(Color.black);//Text color is black

		JB2=new JButton("Forgot Password");
		JB2.setForeground(Color.black);

		JB3=new JButton("Signup");
		JB3.setForeground(Color.black);

		JB4=new JButton("Reset");
		JB4.setForeground(Color.black);
		JB6=new JButton("Need Blood? Click Here");
		JB6.setForeground(Color.red);
		setLayout(null); //null so that the layout can be set manually


		//setBounds(X coordinate,-Y coordinate, width,height)
		//This is a method of jawa.awt.Component class, used to set the position and size of a component.

		JL1.setBounds(175,0,900,200);//applied to a label
		add(JL1);//to show it in the frame // baxxe me daalne ke liye

		JCB1.setBounds(125,240,150,25); //to avoid overlapping we change the x,y coordinates for each
		add(JCB1);

		JL3.setBounds(125,210,375,200);
		add(JL3);

		JT1.setFont(new Font("Trebuchet MS",Font.BOLD,15));//setting the font and size for the text entered in the text field
		JT1.setBounds(300,240,230,30);
		add(JT1);

		JP1.setFont(new Font("Trebuchet MS",Font.BOLD,15));
		JP1.setBounds(300,300,230,30);
		add(JP1);


		JL4.setBounds(125,180,100,30);
		add(JL4);
		JR1.setBounds(210,180,100,30);
		add(JR1);

		JB1.setFont(new Font("Trebuchet MS",Font.BOLD,15));//setting the font for the text that is written on the button b1
		JB1.setBounds(300,350,100,30);
		add(JB1);

		JB2.setFont(new Font("Trebuchet MS",Font.BOLD,15));
		JB2.setBounds(320,400,200,30);
		add(JB2);
		JB6.setFont(new Font("Trebuchet MS",Font.BOLD,12));
		JB6.setForeground(Color.red);
		JB6.setBounds(340,170,180,50);
		add(JB6);

		JB3.setFont(new Font("Trebuchet MS",Font.BOLD,15));
		JB3.setBounds(440,350,90,30);
		add(JB3);
		JL5.setBounds(480,170,180,50);


		JB4.setFont(new Font("Trebuchet MS",Font.BOLD,15));
	  	JB4.setBounds(500,450,100,30);



		JB1.addActionListener(this); //jaise hi button par click hoga wo ek overridden method(actionlistner waala) me jaayega// what happens when user clicks on b1 button
		JB2.addActionListener(this);
		JB3.addActionListener(this);
		JB4.addActionListener(this);
		JB6.addActionListener(this);

		getContentPane().setBackground(Color.pink);//setting the background color in the frame

		ImageIcon icon = new ImageIcon("C:\\Users\\star\\OneDrive\\Desktop\\BloodBankManagement-master\\BloodBankManagement-master\\BloodBank Management\\tree-736885__480.jpg");
		JLabel background = new JLabel(icon);
		background.setBounds(2000, 300, icon.getIconWidth(), icon.getIconHeight());
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(background);

		add(panel);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		setSize(820,620);//size of the frame
		setLocation(500,20);//the location where the frame appears when the code is run
		//500 is the X coordinate and 20 is the negative Y coordinate
		setVisible(true);//by default the frame is invisible

	}

	@Override
	public void actionPerformed(ActionEvent a) //a is the object of ActionEvent class
	// this is method in actionListener interface
	{
		//surrounded with try catch because here we are dealing with an external file(i.e. the database)SQL
		try // it first goes in try
		{
			connect c=new connect();//creating the object of connection class so that we can use our database
			String user=JT1.getText();//ID or phonenumber
			String password=JP1.getText();
			//getText() is used to retrieve the data from any textfield etc.
			String query; //the mysql query
			String q2;
			if(a.getSource()==JB1)//if button jb1 is clicked ( lpogin waala button)
			{
				if(JCB1.getSelectedItem().equals("ID")) //if the user is logging in using his user id
				{
					query="select*from user where UserID='"+user+"'and password='"+password+"'";
					ResultSet r=c.s.executeQuery(query); // ResultSet is an interface to represent a database table
					// r is a reference variable  of resultSet interface which holds the data retrieved from a table after an SQL query is executed.
					if(r.next())
					//to retrieve the data from the database we use next().
					//it jumps column by column till it reaches the last column
					//we are using it to match the user entered data to the database
					{
						q2="select post from user where UserID='"+user+"'";
						ResultSet rs=c.s.executeQuery(q2);
						if(rs.next()) {
							if(!(rs.getString("post").equals((String)JR1.getSelectedItem()))) {
								JOptionPane.showMessageDialog(null,"Check your User Type");
							} else if(JR1.getSelectedItem().equals("Donor")) {
								setVisible(false);//making the current frame invisible // true hua to bg me chalta rahega
								new home_donor().setVisible(true); //opens the home_donor class
							} else if(JR1.getSelectedItem().equals("Staff")) {
								setVisible(false);
								new staff().setVisible(true); //opens the staff class
							}
						}
					} else
					//if the user entered data does not match with the database
					{
						JOptionPane.showMessageDialog(null,"Invalid UserID or Password"); //used to give a pop up message
					}
				} else //if the user is logging in using his phone number
				{
					query="select*from user where phonenumber='"+user+"'and password='"+password+"'";
					ResultSet r=c.s.executeQuery(query);
					if(r.next()) {
						q2="select post from user where phonenumber='"+user+"'";
						ResultSet rs=c.s.executeQuery(q2);
						if(rs.next()) {
							if(!(rs.getString("post").equals((String)JR1.getSelectedItem()))) {
								JOptionPane.showMessageDialog(null,"Check your User Type");
							} else if(JR1.getSelectedItem().equals("Donor")) {
								setVisible(false);
								new home_donor().setVisible(true);
							} else if(JR1.getSelectedItem().equals("Staff")) {
								setVisible(false);
								new staff().setVisible(true);
							}
						}

					}else {
						JOptionPane.showMessageDialog(null,"Invalid phonenumber or Password");
					}
				}
			} else if(a.getSource()==JB2)  // forgot passsword
			{//when jb2 button is clicked
				JTextField JT2;
				JT2=new JTextField(10);
				String ID=JOptionPane.showInputDialog(JT2,"Enter ID");
				String phonenumber=JOptionPane.showInputDialog(JT2,"Enter Phone Number");
				String fp="select * from user where UserID="+"'"+ID+"'"+"AND phonenumber=" +"'"+phonenumber+"'";
				ResultSet q=c.s.executeQuery(fp);
				if(q.next()) // check if exists
				{
					String x=q.getString("password");
					JOptionPane.showMessageDialog(null,"Password is "+x);
				} else {
					JOptionPane.showMessageDialog(null,"ID not found");
				}
				//System.out.println(s);
			} else if(a.getSource()==JB3) // signup
			{
				new signup().setVisible(true);
				setVisible(false);
			}
			else if(a.getSource()==JB6) // need
			{
				new need().setVisible(true);
				setVisible(false);}

			else if(a.getSource()==JB4) // clear (txt field empty)
			{
				JT1.setText(""); // null kardiya empty the txt fields
				JP1.setText("");
			}
			// catch me tabhi aayga jab try me error aayega
		}catch(Exception e)
		// exception is the highest class in hierarchy order// badi parent class

		// contains or handle all the exceptions like sql,i/o,arithmetic etc

		// exception can be sql or i/o exception.
		{
			e.printStackTrace(); // helps u find in which class or in which line there is an error
			//System.out.println("Sorry for inconvenience");
			JOptionPane.showMessageDialog(null,"Sorry for inconvenience");
		}

	}

	public static void main(String [] args) {
		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\star\\OneDrive\\Desktop\\BloodBankManagement-master\\BloodBankManagement-master\\BloodBank Management\\tree-736885__480.jpg")));


		new login().setVisible(true);
	}
}
