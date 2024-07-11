import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.lang.Exception;
import  java.sql.*;

public  class  App  extends  JFrame  implements  ActionListener
{
	JLabel  l1,l2,l3,l4,l5,l6;
	JTextField  t1,t2,t3,t4,t5,t6;
	JButton  b,b1;

	App()
	{
		l1=new  JLabel("NAME    ");
		l2=new  JLabel("CLASS   ");
		l3=new  JLabel("ROLLNO  ");
		l4=new  JLabel("ADDRESS ");
		l5=new  JLabel("PHONENO ");
		l6=new  JLabel("GUARDIAN");
		t1=new  JTextField(20);
		t2=new  JTextField(20);
		t3=new  JTextField(20);
		t4=new  JTextField(20);
		t5=new  JTextField(20);
		t6=new  JTextField(20);
		b=new  JButton("SUBMIT");

		setLayout(new  FlowLayout());
		getContentPane().setBackground(Color.lightGray);

		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(l6);
		add(t6);
		add(b);


		setTitle("CLASS DETAILS");
		setSize(300,300);

		b.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}
	
	public  void  actionPerformed(ActionEvent  ae)
	{
		String  NAME=t1.getText();
		String  CLASS=t2.getText();
		String  ROLLNO=t3.getText();
		String  ADDRESS=t4.getText();
		String  PHONENO=t5.getText();
		String  GUARDIAN=t6.getText();
		int len=PHONENO.length();
		if(len!=10)
		JOptionPane.showMessageDialog(b,"ENTER VALID PHONE NUMBER");
		
		try  
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection  connection  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student",  "root",  "Avani@02#ctapct");
			String query="INSERT INTO st values('"+ NAME +"','"+ CLASS + "','"+ ROLLNO + "','"+ ADDRESS +"','"+ PHONENO +"','"+ GUARDIAN +"')";
			System.out.println(query);
			Statement  sta  =  connection.createStatement();
			int  x  =  sta.executeUpdate(query);

			if  (x ==  0) 
				JOptionPane.showMessageDialog(b,  "This is already exist");
			else  
				JOptionPane.showMessageDialog(b,"You have sucessfully submited");
			connection.close();
		}

		catch  (Exception  exception)
		{
			System.out.println(exception);
		}
	}

		

	public  static  void  main(String  args[])
	{
		new  App();
	}

}