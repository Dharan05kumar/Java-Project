import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Admin 
{
	String a_name,a_id,a_pass;
	int a_number;
	int check(String u)throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from Admin");
		while(rs.next())
		{
			a_name=rs.getString(2);
			a_id=rs.getString(1);
			a_pass=rs.getString(3);
			a_number=rs.getInt(4);
			if(a_id.equals(u))
			{
				return 1;
			}
		}
		return 0;
	}
	int check(String u,String p)throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from Admin");
		while(rs.next())
		{
			a_name=rs.getString(2);
			a_id=rs.getString(1);
			a_pass=rs.getString(3);
			a_number=rs.getInt(4);
			if(a_id.equals(u) && a_pass.equals(p))
			{
				return 1;
			}
		}
		return 0;
	}
	void a_get()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Register Admin");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(340, 100, 155, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel user = new JLabel("User ID : ");
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		user.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(user);
		
		JLabel name = new JLabel("User Name : ");
		name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		name.setBounds(230, 208, 155, 44);
		frame.getContentPane().add(name);
		
		JLabel password = new JLabel("Password : ");
		password.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		password.setBounds(230, 259, 155, 44);
		frame.getContentPane().add(password);
		
		JLabel ph_number = new JLabel("Phone number : ");
		ph_number.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		ph_number.setBounds(230, 306, 155, 44);
		frame.getContentPane().add(ph_number);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(349, 171, 252, 24);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(349, 220, 252, 24);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(349, 269, 252, 24);
		frame.getContentPane().add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(349, 318, 252, 24);
		frame.getContentPane().add(textArea_3);
		
		JButton button=new JButton("Add the user");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
				Statement stmt=con.createStatement();
				a_id=textArea.getText();
				a_name=textArea_1.getText();
				a_pass=textArea_2.getText();
				a_number=Integer.parseInt(textArea_3.getText());
				String query="insert into Admin values('"+a_id+"','"+a_name+"','"+a_pass+"',"+a_number+")";
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(frame,"SUCUUESSFULLY ADDED");
				
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		button.setBounds(300, 390, 150, 46);
		frame.getContentPane().add(button);
		
		JButton button2=new JButton("Back");
	    button2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button2.setBackground(SystemColor.activeCaption);
		button2.setForeground(SystemColor.desktop);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_settings();
			}
		});
		button2.setBounds(330, 500, 150, 46);
	    frame.getContentPane().add(button2);
		
		frame.getContentPane().add(label);
		frame.setSize(800, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	void a_update()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Update Admin");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(340, 100, 155, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel user = new JLabel("User ID : ");
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		user.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(user);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(349, 171, 252, 24);
		frame.getContentPane().add(textArea);
		
		JButton button=new JButton("Check User");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				String u=textArea.getText();
				if(check(u)==1)
				{
				JFrame frame=new JFrame("Ecommerce Site");
				JLabel label=new JLabel("");
				frame.getContentPane().setBackground(new Color(255, 182, 193));
				frame.getContentPane().setForeground(SystemColor.activeCaption);
				
				JLabel name = new JLabel("User Name : ");
				name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				name.setBounds(230, 208, 155, 44);
				frame.getContentPane().add(name);
				
				JLabel password = new JLabel("Password : ");
				password.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				password.setBounds(230, 259, 155, 44);
				frame.getContentPane().add(password);
				
				JLabel ph_number = new JLabel("Phone number : ");
				ph_number.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				ph_number.setBounds(230, 306, 155, 44);
				frame.getContentPane().add(ph_number);
				
				JTextArea textArea_1 = new JTextArea(a_name);
				textArea_1.setBounds(349, 220, 252, 24);
				frame.getContentPane().add(textArea_1);
				
				JTextArea textArea_2 = new JTextArea(a_pass);
				textArea_2.setBounds(349, 269, 252, 24);
				frame.getContentPane().add(textArea_2);
				
				JTextArea textArea_3 = new JTextArea(String.valueOf(a_number));
				textArea_3.setBounds(349, 318, 252, 24);
				frame.getContentPane().add(textArea_3);
				
				JButton button=new JButton("Update the User");
			    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
				button.setBackground(SystemColor.activeCaption);
				button.setForeground(SystemColor.desktop);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
						Statement stmt=con.createStatement();
						a_name=textArea_1.getText();
						a_pass=textArea_2.getText();
						a_number=Integer.parseInt(textArea_3.getText());
						String query="update Admin set a_name='"+a_name+"',a_pass='"+a_pass+"',a_number="+a_number+" where a_id='"+u+"';";
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(frame,"SUCUUESSFULLY UPDATED");
						new admin_settings();
						}
						catch(Exception e1)
						{
							
						}
					}
				});
				button.setBounds(300, 390, 150, 46);
				frame.getContentPane().add(button);
				
				frame.getContentPane().add(label);
				frame.setSize(800, 600); 
		        frame.setLocationRelativeTo(null);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Record not Found");
					new admin_settings();
				}
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		button.setBounds(300, 220, 150, 46);
		frame.getContentPane().add(button);
		
		frame.getContentPane().add(label);
		frame.setSize(800, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	void a_display()throws SQLException
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
			Statement stmt=con.createStatement();
			
			
			JFrame frame=new JFrame("Ecommerce Site");
			JLabel label=new JLabel("");
			frame.getContentPane().setBackground(new Color(255, 182, 193));
			frame.getContentPane().setForeground(SystemColor.activeCaption);
			
			JLabel lblNewLabel = new JLabel("Admin Details");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel.setBounds(300, 50, 255, 44);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel user = new JLabel("Admin ID");
			user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user.setBounds(180, 100, 100, 33);
			frame.getContentPane().add(user);
			
			JLabel user1 = new JLabel("Admin name");
			user1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user1.setBounds(330, 100, 155, 33);
			frame.getContentPane().add(user1);
			
			JLabel user2 = new JLabel("Admin number");
			user2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user2.setBounds(460, 100, 155, 33);
			frame.getContentPane().add(user2);
			
			int i=40;
			String query="select * from Admin;";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				a_id=rs.getString(1);
				a_name=rs.getString(2);
				a_pass=rs.getString(3);
				a_number=rs.getInt(4);
				
				JLabel p1 = new JLabel(a_id);
				p1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p1.setBounds(180, 100+i, 100, 33);
				frame.getContentPane().add(p1);
				
				JLabel p2 = new JLabel(a_name);
				p2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p2.setBounds(330, 100+i, 155, 33);
				frame.getContentPane().add(p2);
				
				JLabel p3 = new JLabel(String.valueOf(a_number));
				p3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p3.setBounds(460, 100+i, 155, 33);
				frame.getContentPane().add(p3);
				
				i+=40;
			}
			
			JButton button5=new JButton("Back");
		    button5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			button5.setBackground(SystemColor.activeCaption);
			button5.setForeground(SystemColor.desktop);
			button5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new admin_settings();
				}
			});
			button5.setBounds(300, 490, 150, 46);
			frame.getContentPane().add(button5);
			
			frame.getContentPane().add(label);
			frame.setSize(800, 600); 
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
		}catch(Exception e1) {}
	}
	void a_delete()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Delete Admin");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(340, 100, 155, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel user = new JLabel("User ID : ");
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		user.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(user);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(349, 171, 252, 24);
		frame.getContentPane().add(textArea);
		
		JButton button=new JButton("Delete User");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
					Statement stmt=con.createStatement();
					String u=textArea.getText();
					if(check(u)==1)
					{
						String query="delete from Admin where a_id='"+u+"';";
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(frame,"Record is Deleted");
						new admin_settings();
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Record not Found");
						new admin_settings();
					}
				}
				catch(SQLException e1) {}
			}
				
		});
		button.setBounds(200, 290, 200, 46);
		frame.getContentPane().add(button);
		
		frame.getContentPane().add(label);
		frame.setSize(800, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	void a_search()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Search for the Particular Record");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(240, 100, 305, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel user = new JLabel("User ID : ");
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		user.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(user);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(349, 171, 252, 24);
		frame.getContentPane().add(textArea);
		
		JButton button=new JButton("Search");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
					Statement stmt=con.createStatement();
					String u=textArea.getText();
					if(check(u)==1)
					{
						JFrame frame1=new JFrame("Ecommerce Site");
						JLabel label=new JLabel("");
						frame1.getContentPane().setBackground(new Color(255, 182, 193));
						frame1.getContentPane().setForeground(SystemColor.activeCaption);
						
						String query="select * from Admin where a_id='"+u+"';";
						ResultSet rs=stmt.executeQuery(query);
						while(rs.next())
						{
							a_name=rs.getString(2);
							a_id=rs.getString(1);
							a_pass=rs.getString(3);
							a_number=rs.getInt(4);
						}
						
						JLabel Label = new JLabel("Admin");
						Label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
						Label.setBounds(340, 100, 155, 44);
						frame1.getContentPane().add(Label);
						
						
						JLabel user = new JLabel("User ID : ");
						user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						user.setBounds(230, 171, 155, 33);
						frame1.getContentPane().add(user);
						
						JLabel name = new JLabel("User Name : ");
						name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						name.setBounds(230, 208, 155, 44);
						frame1.getContentPane().add(name);
						
						JLabel ph_number = new JLabel("Phone Number : ");
						ph_number.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						ph_number.setBounds(230, 259, 155, 44);
						frame1.getContentPane().add(ph_number);
						
						JLabel textArea = new JLabel(a_id);
						textArea.setBounds(349, 171, 252, 24);
						frame1.getContentPane().add(textArea);
						
						JLabel textArea_1 = new JLabel(a_name);
						textArea_1.setBounds(349, 220, 252, 24);
						frame1.getContentPane().add(textArea_1);
						
						JLabel textArea_2 = new JLabel(String.valueOf(a_number));
						textArea_2.setBounds(349, 269, 252, 24);
						frame1.getContentPane().add(textArea_2);
						
						JButton button5=new JButton("Back to Admin Page");
					    button5.setFont(new Font("Times New Roman", Font.BOLD, 14));
						button5.setBackground(SystemColor.activeCaption);
						button5.setForeground(SystemColor.desktop);
						button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new admin_settings();
							}
						});
						button5.setBounds(200, 490, 200, 46);
						frame1.getContentPane().add(button5);
						
						frame1.getContentPane().add(label);
						frame1.setSize(800, 600); 
				        frame1.setLocationRelativeTo(null);
				        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame1.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Record not Found");
						return;
					}
					
				}
				catch(SQLException e1) {}
			}
				
		});
		button.setBounds(200, 290, 200, 46);
		frame.getContentPane().add(button);
		
		frame.getContentPane().add(label);
		frame.setSize(800, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public static void main(String[] args) 
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e1)
		{
			
		}
	}

}
