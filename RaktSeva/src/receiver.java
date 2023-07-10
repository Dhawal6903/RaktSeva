import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class receiver extends JFrame implements ActionListener
{
	JLabel JL1,JL2,JL3,JL4,JL5,JL6,JL7,JL8;
	JTextField JT1,JT2,JT3,JT4,JT5;
	JComboBox JC1,JC2;
	JButton JB1, JB2;
	receiver()
	{
		setContentPane(new JLabel((new ImageIcon(("C:\\Users\\star\\Downloads\\img_20.jpeg.jpg")))));
		JL1=new JLabel("Provide Blood");
		JL1.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,38));
		
		JL2=new JLabel("Enter Patient Name:");
		JL2.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,20));
		
		JL3=new JLabel("Enter Patient Age:");
		JL3.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,20));
		
		JL4=new JLabel("Staff ID:");
		JL4.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,20));
		
		JL5=new JLabel("Blood Group:");
		JL5.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,20));
		
		JL6=new JLabel("Quantity:");
		JL6.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,20));
		
		JL7=new JLabel("MobileNumber:");
		JL7.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,20));

		JL8=new JLabel("ML");
		JL8.setFont(new Font("Trebuchet MS",Font.ROMAN_BASELINE,18));
		
		
		JB1=new JButton("Finish");
		JB1.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,15));
		JB2=new JButton("Back");
		JB2.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,15));

		JT1=new JTextField(15);
		JT2=new JTextField(10);
		JT3=new JTextField(10);
		JT4=new JTextField(10);

		
		String volume[]= {"50","100","200","300","400","1000","2000"};
		JC1=new JComboBox(volume);
		String bloodGrp[]= {"A+","AB+","O+","B+","A-","B-","AB-","O-"};
		JC2=new JComboBox(bloodGrp);
		
		setLayout(null);
		
		JL1.setBounds(260,60,530,31);
		add(JL1);
		JL2.setBounds(150,150,230,28);
		add(JL2);
		JL3.setBounds(150,210,230,29);
		add(JL3);
		JL4.setBounds(150,270,130,29);
		add(JL4);
		JL5.setBounds(150,330,130,29);
		add(JL5);
		JL6.setBounds(150,390,130,29);
		add(JL6);
		JL7.setBounds(150,450,200,29);
		add(JL7);
		
		JT1.setBounds(350, 150, 230, 28);
		JT1.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		add(JT1);
		JT2.setBounds(350,210,230,28);
		JT2.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		add(JT2);
		JT3.setBounds(350,270,230,29);
		JT3.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		add(JT3);
		JC2.setBounds(350,330,230,29);
		add(JC2);
		JC1.setBounds(350,390,130,29);
		add(JC1);
		JL8.setBounds(500,390,100,29);
		add(JL8);
		JT4.setBounds(350, 450,230,29);
		JT4.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		add(JT4);
		JB1.setBounds(250,540,100,29);
		add(JB1);
		JB2.setBounds(450,540,100,29);
		add(JB2);

		JB1.addActionListener(this);
		JB2.addActionListener(this);

		setSize(800,800);
		setLocation(500,20);
		setVisible(true);
		getContentPane().setBackground(Color.pink);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now ;  
		boolean transaction=false;
		connect c=new connect();
		String query="select*from user where UserID="+"'"+JT3.getText()+"'"+" AND "+"post='Staff'";
		String blood="select*from bloodbank where BloodGrp= '"+(String)JC2.getSelectedItem()+"'";
		int quantity=0;
		//ResultSet r=null;
		ResultSet x=null;
		try {
			
			x = c.s.executeQuery(blood);
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			if(x.next())
			{
				quantity=x.getInt("Quantity");
			}
		} catch (NumberFormatException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if(quantity<Integer.parseInt((String)JC1.getSelectedItem()))
		{
			JOptionPane.showMessageDialog(null,"Not Sufficient Blood");
		}
		else
		{
			quantity=quantity-Integer.parseInt((String)JC1.getSelectedItem());
			String bloodbankUpdate="UPDATE ((bloodbank)) SET Quantity="+"'"+quantity+"'"+"WHERE BloodGrp="+"'"+(String)JC2.getSelectedItem()+"'";
			try
			{String d = dtf.format(LocalDateTime.now());
				
				if(e.getSource()==JB1) {
//					String pass=JOptionPane.showInputDialog(JT1,"Enter Your Password");
//					String q2="select*from user where password='"+"9999"+"'";

//					ResultSet r1=c.s.executeQuery(q2);
//					if(!r1.next())
//					{
//						JOptionPane.showMessageDialog(null,"Incorrect Password");
//					}

					ResultSet r2 = c.s.executeQuery(query);
					if (JT1.getText().isEmpty()) {
						JT1.setText(" ");
						JOptionPane.showMessageDialog(null, "Patient Name Cannot Be Empty");
					} else if (JT2.getText().isEmpty()) {
						JT2.setText(" ");
						JOptionPane.showMessageDialog(null, "Patient Age Cannot Be Empty");
					} else if (JT3.getText().isEmpty()) {
						JT2.setText(" ");
						JOptionPane.showMessageDialog(null, "Staff ID Cannot Be Empty");
					}
//						else if(!r2.next())
//						{
//							JT3.setText("Staff45 ");
//							JOptionPane.showMessageDialog(null,"Staff ID not in our record");
//						}
					else if (JT4.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "MobileNumber cannot be empty");
					} else if (JT4.getText().length() != 10 || JT4.getText().charAt(0) == '0' || JT4.getText().charAt(0) == '1' || JT4.getText().charAt(0) == '2' || JT4.getText().charAt(0) == '3' ||
							JT4.getText().charAt(0) == '4' || JT4.getText().charAt(0) == '5' || JT4.getText().charAt(0) == '+' || JT4.getText().charAt(0) == '-') {
						JT4.setText(" ");
						JOptionPane.showMessageDialog(null, "Incorrect Mobile Number");
					}
				}
							String q="insert into reciever (PatientName,PatientAge,StaffID,BloodGrp,volume,contactNumber,Date) VALUES"+"('"+JT1.getText()+"',"+"'"+JT2.getText()+"',"+"'"+
									JT3.getText()+"',"+"'"+(String)JC2.getSelectedItem()+"',"+"'"+(String)JC1.getSelectedItem()+"',"+"'"+JT4.getText()+"',"+"'"+d+"'"+")";
							c.s.executeUpdate(q);
							c.s.executeUpdate(bloodbankUpdate);
							setVisible(false);
							new staff().setVisible(true);

							if(transaction=true){
								JOptionPane.showMessageDialog(null,"Thank You");

														
							
						}

					if(transaction)
					{
						String t="insert into staff_transaction(StaffID,Date,status) VALUES ('"+JT3.getText()+"','"+d+"','"+true+"'"+")";
						c.s.executeUpdate(t);
					}else
					{
						String t="insert into staff_transaction(StaffID,Date,status) VALUES ('"+JT3.getText()+"','"+d+"','"+false+"'"+")";
						c.s.executeUpdate(t);
					}

			}catch(Exception a)
			{
				System.out.println(a);
			}
		}
		if(e.getSource()==JB2)
		{
			setVisible(false);
			new staff().setVisible(true);
		}


	}
	
	public static void main(String []args)
	{
		new receiver().setVisible(true);
	}
}
