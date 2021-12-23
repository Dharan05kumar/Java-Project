import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class User_peronal extends User
{
	String u_email;
	char u_gender;
	void up_get(String u)
	{
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
			Statement stmt=con.createStatement();
			String query="select * from User where u_id='"+u+"';";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				u_name=rs.getString(2);
				u_id=rs.getString(1);
				u_pass=rs.getString(3);
				u_number=rs.getInt(4);
				u_address=rs.getString(5);
				u_city=rs.getString(6);
			}
			
			JFrame frame=new JFrame("Ecommerce Site");
			JLabel label=new JLabel("");
			frame.getContentPane().setBackground(new Color(255, 182, 193));
			frame.getContentPane().setForeground(SystemColor.activeCaption);
			
			JLabel user = new JLabel("User Email : ");
			user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			user.setBounds(230, 171, 155, 33);
			frame.getContentPane().add(user);
			
			JLabel name = new JLabel("User Gender : ");
			name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			name.setBounds(230, 208, 155, 44);
			frame.getContentPane().add(name);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(349, 171, 252, 24);
			frame.getContentPane().add(textArea);
			
			JTextArea textArea_1 = new JTextArea();
			textArea_1.setBounds(349, 220, 252, 24);
			frame.getContentPane().add(textArea_1);
			
			JButton button=new JButton("Add");
		    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
			button.setBackground(SystemColor.activeCaption);
			button.setForeground(SystemColor.desktop);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
					Statement stmt=con.createStatement();
					u_email=textArea.getText();
					u_gender=textArea_1.getText().charAt(0);
					String query="insert into User_personal values('"+u_id+"','"+u_name+"','"+u_address+"','"+u_email+"','"+u_gender+"')";
					stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(frame,"SUCUUESSFULLY ADDED");
					up_display(u);
					}
					catch(Exception e1)
					{
						
					}
				}
			});
			button.setBounds(300, 450, 150, 46);
			frame.getContentPane().add(button);
			
			frame.getContentPane().add(label);
			frame.setSize(800, 600); 
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
		}catch(Exception e1) {}
	}
	void up_display(String u)
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel Label = new JLabel("Customer");
		Label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		Label.setBounds(340, 100, 155, 44);
		frame.getContentPane().add(Label);
		
		
		JLabel user = new JLabel("User ID : ");
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		user.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(user);
		
		JLabel name = new JLabel("User Name : ");
		name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		name.setBounds(230, 208, 155, 44);
		frame.getContentPane().add(name);
		
		JLabel ph_number = new JLabel("Phone Number : ");
		ph_number.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		ph_number.setBounds(230, 259, 155, 44);
		frame.getContentPane().add(ph_number);
		
		JLabel Address = new JLabel("Address : ");
		Address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		Address.setBounds(230, 306, 155, 44);
		frame.getContentPane().add(Address);
		
		JLabel city = new JLabel("City : ");
		city.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		city.setBounds(230, 358, 155, 44);
		frame.getContentPane().add(city);
		
		JLabel email = new JLabel("Email : ");
		email.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		email.setBounds(230, 404, 155, 44);
		frame.getContentPane().add(email);
		
		JLabel gender = new JLabel("Gender : ");
		gender.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		gender.setBounds(230, 450, 155, 44);
		frame.getContentPane().add(gender);
		
		JLabel textArea = new JLabel(u_id);
		textArea.setBounds(349, 171, 252, 24);
		frame.getContentPane().add(textArea);
		
		JLabel textArea_1 = new JLabel(u_name);
		textArea_1.setBounds(349, 220, 252, 24);
		frame.getContentPane().add(textArea_1);
		
		JLabel textArea_2 = new JLabel(String.valueOf(u_number));
		textArea_2.setBounds(349, 269, 252, 24);
		frame.getContentPane().add(textArea_2);
		
		JLabel textArea_3 = new JLabel(u_address);
		textArea_3.setBounds(349, 318, 252, 24);
		frame.getContentPane().add(textArea_3);
		
		JLabel textArea_4 = new JLabel(u_city);
		textArea_4.setBounds(349, 367, 252, 24);
		frame.getContentPane().add(textArea_4);
		
		JLabel textArea_5 = new JLabel(u_email);
		textArea_5.setBounds(349, 416, 252, 24);
		frame.getContentPane().add(textArea_5);
		
		JLabel textArea_6 = new JLabel(Character.toString(u_gender));
		textArea_6.setBounds(349, 465, 252, 24);
		frame.getContentPane().add(textArea_6);
		
		JButton button5=new JButton("Back");
	    button5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button5.setBackground(SystemColor.activeCaption);
		button5.setForeground(SystemColor.desktop);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new u_user_setting(u);
			}
		});
		button5.setBounds(300, 490, 150, 46);
		frame.getContentPane().add(button5);
		
		frame.getContentPane().add(label);
		frame.setSize(800, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
	}
}
public class User 
{
	String u_name,u_id,u_pass,u_address,u_city;
	int u_number;
	int check(String u)throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from User");
		while(rs.next())
		{
			u_name=rs.getString(2);
			u_id=rs.getString(1);
			u_pass=rs.getString(3);
			u_number=rs.getInt(4);
			u_address=rs.getString(5);
			u_city=rs.getString(6);
			if(u_id.equals(u))
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
		ResultSet rs=stmt.executeQuery("select * from User");
		while(rs.next())
		{
			u_name=rs.getString(2);
			u_id=rs.getString(1);
			u_pass=rs.getString(3);
			u_number=rs.getInt(4);
			if(u_id.equals(u) && u_pass.equals(p))
			{
				return 1;
			}
		}
		return 0;
	}
	void u_get()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Register Customer");
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
		
		JLabel Address = new JLabel("Address : ");
		Address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		Address.setBounds(230, 358, 155, 44);
		frame.getContentPane().add(Address);
		
		JLabel city = new JLabel("City : ");
		city.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		city.setBounds(230, 412, 155, 44);
		frame.getContentPane().add(city);
		
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
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(349, 367, 252, 24);
		frame.getContentPane().add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(349, 416, 252, 24);
		frame.getContentPane().add(textArea_5);
		
		JButton button=new JButton("Add the user");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
				Statement stmt=con.createStatement();
				u_id=textArea.getText();
				u_name=textArea_1.getText();
				u_pass=textArea_2.getText();
				u_number=Integer.parseInt(textArea_3.getText());
				u_address=textArea_4.getText();
				u_city=textArea_5.getText();
				String query="insert into User values('"+u_id+"','"+u_name+"','"+u_pass+"',"+u_number+",'"+u_address+"','"+u_city+"')";
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(frame,"SUCUUESSFULLY ADDED");
				return;
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		button.setBounds(300, 450, 150, 46);
		frame.getContentPane().add(button);
		
		frame.getContentPane().add(label);
		frame.setSize(800, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	void u_update()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Update Customer");
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
				
				JLabel Address = new JLabel("Address : ");
				Address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				Address.setBounds(230, 358, 155, 44);
				frame.getContentPane().add(Address);
				
				JLabel city = new JLabel("City : ");
				city.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				city.setBounds(230, 412, 155, 44);
				frame.getContentPane().add(city);
				
				JTextArea textArea_1 = new JTextArea(u_name);
				textArea_1.setBounds(349, 220, 252, 24);
				frame.getContentPane().add(textArea_1);
				
				JTextArea textArea_2 = new JTextArea(u_pass);
				textArea_2.setBounds(349, 269, 252, 24);
				frame.getContentPane().add(textArea_2);
				
				JTextArea textArea_3 = new JTextArea(String.valueOf(u_number));
				textArea_3.setBounds(349, 318, 252, 24);
				frame.getContentPane().add(textArea_3);
				
				JTextArea textArea_4 = new JTextArea(u_address);
				textArea_4.setBounds(349, 367, 252, 24);
				frame.getContentPane().add(textArea_4);
				
				JTextArea textArea_5 = new JTextArea(u_city);
				textArea_5.setBounds(349, 416, 252, 24);
				frame.getContentPane().add(textArea_5);
				
				JButton button=new JButton("Update the User");
			    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
				button.setBackground(SystemColor.activeCaption);
				button.setForeground(SystemColor.desktop);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
						Statement stmt=con.createStatement();
						u_name=textArea_1.getText();
						u_pass=textArea_2.getText();
						u_number=Integer.parseInt(textArea_3.getText());
						u_address=textArea_4.getText();
						u_city=textArea_5.getText();
						String query="update User set u_name='"+u_name+"',u_pass='"+u_pass+"',u_number="+u_number+",u_address='"+u_address+"',u_city='"+u_city+"' where u_id='"+u+"';";
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(frame,"SUCUUESSFULLY UPDATED");
						new a_user_setting();
						}
						catch(Exception e1)
						{
							
						}
					}
				});
				button.setBounds(300, 450, 150, 46);
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
					new a_user_setting();
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
	void u_display()throws SQLException
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
			Statement stmt=con.createStatement();
			
			
			JFrame frame=new JFrame("Ecommerce Site");
			JLabel label=new JLabel("");
			frame.getContentPane().setBackground(new Color(255, 182, 193));
			frame.getContentPane().setForeground(SystemColor.activeCaption);
			
			JLabel lblNewLabel = new JLabel("User Details");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel.setBounds(300, 50, 255, 44);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel user = new JLabel("Customer ID");
			user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user.setBounds(180, 100, 100, 33);
			frame.getContentPane().add(user);
			
			JLabel user1 = new JLabel("Customer name");
			user1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user1.setBounds(330, 100, 155, 33);
			frame.getContentPane().add(user1);
			
			JLabel user2 = new JLabel("Customer number");
			user2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user2.setBounds(460, 100, 155, 33);
			frame.getContentPane().add(user2);
			
			int i=40;
			String query="select * from User;";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				u_id=rs.getString(1);
				u_name=rs.getString(2);
				u_pass=rs.getString(3);
				u_number=rs.getInt(4);
				
				JLabel p1 = new JLabel(u_id);
				p1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p1.setBounds(180, 100+i, 100, 33);
				frame.getContentPane().add(p1);
				
				JLabel p2 = new JLabel(u_name);
				p2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p2.setBounds(330, 100+i, 155, 33);
				frame.getContentPane().add(p2);
				
				JLabel p3 = new JLabel(String.valueOf(u_number));
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
					new a_user_setting();
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
	void u_search()throws SQLException
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
						
						String query="select * from User where a_id='"+u+"';";
						ResultSet rs=stmt.executeQuery(query);
						while(rs.next())
						{
							u_name=rs.getString(2);
							u_id=rs.getString(1);
							u_pass=rs.getString(3);
							u_number=rs.getInt(4);
							u_address=rs.getString(5);
							u_city=rs.getString(6);
						}
						
						JLabel Label = new JLabel("Customer");
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
						
						JLabel Address = new JLabel("Address : ");
						Address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						Address.setBounds(230, 306, 155, 44);
						frame1.getContentPane().add(Address);
						
						JLabel city = new JLabel("City : ");
						city.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						city.setBounds(230, 358, 155, 44);
						frame1.getContentPane().add(city);
						
						JLabel textArea = new JLabel(u_id);
						textArea.setBounds(349, 171, 252, 24);
						frame1.getContentPane().add(textArea);
						
						JLabel textArea_1 = new JLabel(u_name);
						textArea_1.setBounds(349, 220, 252, 24);
						frame1.getContentPane().add(textArea_1);
						
						JLabel textArea_2 = new JLabel(String.valueOf(u_number));
						textArea_2.setBounds(349, 269, 252, 24);
						frame1.getContentPane().add(textArea_2);
						
						JLabel textArea_3 = new JLabel(u_address);
						textArea_3.setBounds(349, 318, 252, 24);
						frame1.getContentPane().add(textArea_3);
						
						JLabel textArea_4 = new JLabel(u_city);
						textArea_4.setBounds(349, 367, 252, 24);
						frame1.getContentPane().add(textArea_4);
						
						JButton button5=new JButton("Back to Admin Page");
					    button5.setFont(new Font("Times New Roman", Font.BOLD, 14));
						button5.setBackground(SystemColor.activeCaption);
						button5.setForeground(SystemColor.desktop);
						button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new a_user_setting();
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
	void u_delete()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Delete Customer");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(300, 100, 255, 44);
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
						String query="delete from User where u_id='"+u+"';";
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(frame,"Record is Deleted");
						new a_user_setting();
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Record not Found");
						new a_user_setting();
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
	public static void main(String args[])
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e)
		{
			
		}
	}
}
