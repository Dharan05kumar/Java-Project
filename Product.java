import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Ship
{
	String s_date,s_id;
}
class buy extends Product
{
	double pro_total;
	public buy(String u)
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel pro_id = new JLabel("Product ID : ");
		pro_id.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		pro_id.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(pro_id);
		
		JLabel pro_qua = new JLabel("Quantity : ");
		pro_qua.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		pro_qua.setBounds(230, 208, 155, 44);
		frame.getContentPane().add(pro_qua);
		
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
				if(check(textArea.getText())==1)
				{
					
					
					
					tran(u,textArea.getText(),Integer.parseInt(textArea_1.getText()));
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Product not found");
					new buy(u);
				}
			}	
		});
		button.setBounds(300, 400, 150, 46);
		frame.getContentPane().add(button);
		
		frame.getContentPane().add(label);
		frame.setSize(800, 700); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public void tran(String u,String id,int a)
	{
		try {
			p_id=id;
			p_quat=a;
			pro_total=p_price*p_quat;
			JFrame frame1=new JFrame("Ecommerce Site");
			JLabel label=new JLabel("");
			frame1.getContentPane().setBackground(new Color(255, 182, 193));
			frame1.getContentPane().setForeground(SystemColor.activeCaption);
			
			JLabel TOTAL = new JLabel("TOTAL AMOUNT : ");
			TOTAL.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			TOTAL.setBounds(230, 100, 155, 44);
			frame1.getContentPane().add(TOTAL);
			
			JLabel Amount = new JLabel(String.valueOf(pro_total));
			Amount.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			Amount.setBounds(349, 100, 155, 44);
			frame1.getContentPane().add(Amount);
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
			Statement stmt=con.createStatement();
			
			String query="insert into Transcation values('"+u+"','"+p_id+"',"+p_quat+","+pro_total+");";
			stmt.executeUpdate(query);
			
			JLabel lblNewLabel1 = new JLabel("");
			lblNewLabel1.setIcon(new ImageIcon("D:\\a5.png"));
			lblNewLabel1.setBounds(160, 160, 400, 320);
			frame1.getContentPane().add(lblNewLabel1);
			
			JButton button=new JButton("Card");
		    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
			button.setBackground(SystemColor.activeCaption);
			button.setForeground(SystemColor.desktop);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame frame=new JFrame("Ecommerce Site");
					JLabel label=new JLabel("",SwingConstants.CENTER);
					frame.getContentPane().setBackground(new Color(255, 182, 193));
					frame.getContentPane().setForeground(SystemColor.activeCaption);
					
					JLabel user = new JLabel("Card Number : ");
					user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
					user.setBounds(230, 171, 155, 33);
					frame.getContentPane().add(user);
					
					JLabel pass = new JLabel("CVV Number : ");
					pass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
					pass.setBounds(230, 208, 155, 44);
					frame.getContentPane().add(pass);
					
					JTextArea textArea = new JTextArea();
					textArea.setBounds(349, 171, 252, 24);
					frame.getContentPane().add(textArea);
					
					JTextArea textArea_1 = new JTextArea();
					textArea_1.setBounds(349, 220, 252, 24);
					frame.getContentPane().add(textArea_1);
					
					JButton button=new JButton("Enter");
				    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
					button.setBackground(SystemColor.activeCaption);
					button.setForeground(SystemColor.desktop);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(frame,"Your order is Successfull");
							new u_product_details(u);
						}
					});
					button.setBounds(320, 310, 150, 46);
				    frame.getContentPane().add(button);
					
					frame.getContentPane().add(label);
					frame.setSize(800, 600); 
			        frame.setLocationRelativeTo(null);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setVisible(true);
				}
			});
		    button.setBounds(360, 460, 150, 46);
		    frame1.getContentPane().add(button);
		    
		    JButton button1=new JButton("Cash on Delivery");
		    button1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			button1.setBackground(SystemColor.activeCaption);
			button1.setForeground(SystemColor.desktop);
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frame1,"Your order is Successfull");
					new u_product_details(u);
				}
			});
		    button1.setBounds(200, 460, 150, 46);
		    frame1.getContentPane().add(button1);
			
			frame1.getContentPane().add(label);
			frame1.setSize(800, 700); 
	        frame1.setLocationRelativeTo(null);
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.setVisible(true);
			}catch(Exception e1) {}
	}
}
public class Product extends Ship
{
	String p_name,p_brand,p_id;
	int p_quat;
	double p_price,pro_tot;
	int check(String u)
	{
		try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select p_id,p_name,p_price,p_brand from Product");
		while(rs.next())
		{
			p_name=rs.getString(2);
			p_id=rs.getString(1);
			p_price=Double.parseDouble(rs.getString(3));
			p_brand=rs.getString(4);
			if(p_id.equals(u))
			{
				return 1;
			}
		}
		}catch(Exception e) {}
		return 0;
	}
	void p_get()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Add the Product");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(340, 100, 255, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel user = new JLabel("Product ID : ");
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		user.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(user);
		
		JLabel name = new JLabel("Product Name : ");
		name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		name.setBounds(230, 208, 155, 44);
		frame.getContentPane().add(name);
		
		JLabel password = new JLabel("Product Price : ");
		password.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		password.setBounds(230, 259, 155, 44);
		frame.getContentPane().add(password);
		
		JLabel ph_number = new JLabel("Product Brand : ");
		ph_number.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		ph_number.setBounds(230, 306, 155, 44);
		frame.getContentPane().add(ph_number);
		
		JLabel Address = new JLabel("Product Quatity : ");
		Address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		Address.setBounds(230, 358, 155, 44);
		frame.getContentPane().add(Address);
		
		JLabel city = new JLabel("Shipping ID : ");
		city.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		city.setBounds(230, 412, 155, 44);
		frame.getContentPane().add(city);
		
		JLabel city1 = new JLabel("Shipping Date : ");
		city1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		city1.setBounds(230, 468, 155, 44);
		frame.getContentPane().add(city1);
		
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
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(349, 465, 252, 24);
		frame.getContentPane().add(textArea_6);
		
		JButton button=new JButton("Add the Product");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
				Statement stmt=con.createStatement();
				p_id=textArea.getText();
				p_name=textArea_1.getText();
				p_price=Double.parseDouble(textArea_2.getText());
				p_brand=textArea_3.getText();
				p_quat=Integer.parseInt(textArea_4.getText());
				s_id=textArea_4.getText();
				s_date=textArea_5.getText();
				String query="insert into Product values('"+p_id+"','"+p_name+"',"+p_price+",'"+p_brand+"',"+p_quat+")";
				stmt.executeUpdate(query);
				String query1="insert into Ship values('"+p_id+"','"+s_id+"','"+s_date+"')";
				stmt.executeUpdate(query1);
				JOptionPane.showMessageDialog(frame,"SUCUUESSFULLY ADDED");
				new a_product_details();
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		button.setBounds(300, 520, 150, 46);
		frame.getContentPane().add(button);
		
		frame.getContentPane().add(label);
		frame.setSize(800, 700); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	void p_display()
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
			Statement stmt=con.createStatement();
			
			JFrame frame=new JFrame("Ecommerce Site");
			JLabel label=new JLabel("");
			frame.getContentPane().setBackground(new Color(255, 182, 193));
			frame.getContentPane().setForeground(SystemColor.activeCaption);
			
			JLabel lblNewLabel = new JLabel("Product Details");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel.setBounds(300, 50, 255, 10);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel user = new JLabel("Product ID");
			user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user.setBounds(100, 100, 100, 33);
			frame.getContentPane().add(user);
			
			JLabel user1 = new JLabel("Product Name");
			user1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user1.setBounds(220, 100, 155, 33);
			frame.getContentPane().add(user1);
			
			JLabel user2 = new JLabel("Product Price");
			user2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user2.setBounds(340, 100, 155, 33);
			frame.getContentPane().add(user2);
			
			JLabel user3 = new JLabel("Product Brand");
			user3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user3.setBounds(460, 100, 155, 33);
			frame.getContentPane().add(user3);
			
			JLabel user4 = new JLabel("Product Quantity");
			user4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user4.setBounds(580, 100, 155, 33);
			frame.getContentPane().add(user4);
			
			int i=40;
			String query="select * from Product;";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				p_id=rs.getString(1);
				p_name=rs.getString(2);
				p_price=rs.getDouble(3);
				p_brand=rs.getString(4);
				p_quat=rs.getInt(5);
				
				JLabel p1 = new JLabel(p_id);
				p1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p1.setBounds(100, 100+i, 100, 33);
				frame.getContentPane().add(p1);
				
				JLabel p2 = new JLabel(p_name);
				p2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p2.setBounds(220, 100+i, 155, 33);
				frame.getContentPane().add(p2);
				
				JLabel p3 = new JLabel(String.valueOf(p_price));
				p3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p3.setBounds(340, 100+i, 155, 33);
				frame.getContentPane().add(p3);
				
				JLabel p4 = new JLabel(p_brand);
				p4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p4.setBounds(460, 100+i, 155, 33);
				frame.getContentPane().add(p4);
				
				JLabel p5 = new JLabel(String.valueOf(p_quat));
				p5.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p5.setBounds(580, 100+i, 155, 33);
				frame.getContentPane().add(p5);
				
				i+=40;
			}
			
			JButton button5=new JButton("Back");
		    button5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			button5.setBackground(SystemColor.activeCaption);
			button5.setForeground(SystemColor.desktop);
			button5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new a_product_details();
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
	void p_tran(String u)
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","dharankumar05@02");   
			Statement stmt=con.createStatement();
			
			
			JFrame frame=new JFrame("Ecommerce Site");
			JLabel label=new JLabel("");
			frame.getContentPane().setBackground(new Color(255, 182, 193));
			frame.getContentPane().setForeground(SystemColor.activeCaption);
			
			JLabel lblNewLabel = new JLabel("Transcation Details");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel.setBounds(300, 50, 255, 44);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel user = new JLabel("User ID");
			user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user.setBounds(120, 100, 100, 33);
			frame.getContentPane().add(user);
			
			JLabel user1 = new JLabel("Product ID");
			user1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user1.setBounds(250, 100, 155, 33);
			frame.getContentPane().add(user1);
			
			JLabel user2 = new JLabel("Product Quantity");
			user2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user2.setBounds(400, 100, 155, 33);
			frame.getContentPane().add(user2);
			
			JLabel user3 = new JLabel("Product Total");
			user3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			user3.setBounds(580, 100, 155, 33);
			frame.getContentPane().add(user3);
			
			int i=40;
			String query="select * from Transcation where u_id='"+u+"';";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				u=rs.getString(1);
				p_id=rs.getString(2);
				p_quat=rs.getInt(3);
				pro_tot=rs.getDouble(4);
				
				JLabel p1 = new JLabel(u);
				p1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p1.setBounds(120, 100+i, 100, 33);
				frame.getContentPane().add(p1);
				
				JLabel p2 = new JLabel(p_id);
				p2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p2.setBounds(250, 100+i, 155, 33);
				frame.getContentPane().add(p2);
				
				JLabel p3 = new JLabel(String.valueOf(p_quat));
				p3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p3.setBounds(400, 100+i, 155, 33);
				frame.getContentPane().add(p3);
				
				JLabel p4 = new JLabel(String.valueOf(pro_tot));
				p4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				p4.setBounds(580, 100+i, 155, 33);
				frame.getContentPane().add(p4);
				i+=40;
			}
			
			JButton button5=new JButton("Back");
		    button5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			button5.setBackground(SystemColor.activeCaption);
			button5.setForeground(SystemColor.desktop);
			button5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new home_customer();
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
	void p_update()throws SQLException
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Upate Product Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(340, 100, 255, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel user = new JLabel("Product ID : ");
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		user.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(user);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(349, 171, 252, 24);
		frame.getContentPane().add(textArea);
		
		JButton button=new JButton("Check Product");
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
				
				JLabel name = new JLabel("Product Name : ");
				name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				name.setBounds(230, 208, 155, 44);
				frame.getContentPane().add(name);
				
				JLabel password = new JLabel("Product Price : ");
				password.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				password.setBounds(230, 259, 155, 44);
				frame.getContentPane().add(password);
				
				JLabel ph_number = new JLabel("Product Brand : ");
				ph_number.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				ph_number.setBounds(230, 306, 155, 44);
				frame.getContentPane().add(ph_number);
				
				JLabel Address = new JLabel("Product Quantity : ");
				Address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				Address.setBounds(230, 358, 155, 44);
				frame.getContentPane().add(Address);
				
				JLabel city = new JLabel("Shipping Date : ");
				city.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				city.setBounds(230, 412, 155, 44);
				frame.getContentPane().add(city);
				
				JTextArea textArea_1 = new JTextArea(p_name);
				textArea_1.setBounds(349, 220, 252, 24);
				frame.getContentPane().add(textArea_1);
				
				JTextArea textArea_2 = new JTextArea(String.valueOf(p_price));
				textArea_2.setBounds(349, 269, 252, 24);
				frame.getContentPane().add(textArea_2);
				
				JTextArea textArea_3 = new JTextArea(p_brand);
				textArea_3.setBounds(349, 318, 252, 24);
				frame.getContentPane().add(textArea_3);
				
				JTextArea textArea_4 = new JTextArea(String.valueOf(p_quat));
				textArea_4.setBounds(349, 367, 252, 24);
				frame.getContentPane().add(textArea_4);
				
				JTextArea textArea_5 = new JTextArea(String.valueOf(s_date));
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
						p_name=textArea_1.getText();
						p_price=Double.parseDouble(textArea_2.getText());
						p_brand=textArea_3.getText();
						p_quat=Integer.parseInt(textArea_4.getText());
						s_date=textArea_5.getText();
						String query="update product set p_name='"+p_name+"',p_price="+p_price+",p_brand='"+p_brand+"',p_quat="+p_quat+" where p_id='"+u+"';";
						stmt.executeUpdate(query);
						String query1="update Ship set s_date='"+s_date+"' where p_id='"+p_id+"';";
						stmt.executeUpdate(query1);
						JOptionPane.showMessageDialog(frame,"SUCUUESSFULLY UPDATED");
						new a_product_details();
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
					new a_product_details();
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
	void p_search()
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Search for the Particular Product");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(240, 100, 305, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel user = new JLabel("Product ID : ");
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
						
						String query="select * from Product where p_id='"+u+"';";
						ResultSet rs=stmt.executeQuery(query);
						while(rs.next())
						{
							p_id=rs.getString(1);
							p_name=rs.getString(2);
							p_price=rs.getDouble(3);
							p_brand=rs.getString(4);
							p_quat=rs.getInt(5);
						}
						
						JLabel Label = new JLabel("Product Details");
						Label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
						Label.setBounds(340, 100, 155, 44);
						frame1.getContentPane().add(Label);
						
						
						JLabel user = new JLabel("Product ID : ");
						user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						user.setBounds(230, 171, 155, 33);
						frame1.getContentPane().add(user);
						
						JLabel name = new JLabel("Product Name : ");
						name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						name.setBounds(230, 208, 155, 44);
						frame1.getContentPane().add(name);
						
						JLabel ph_number = new JLabel("Product Price : ");
						ph_number.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						ph_number.setBounds(230, 259, 155, 44);
						frame1.getContentPane().add(ph_number);
						
						JLabel Address = new JLabel("Product Quantity : ");
						Address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
						Address.setBounds(230, 306, 155, 44);
						frame1.getContentPane().add(Address);
						
						JLabel textArea = new JLabel(p_id);
						textArea.setBounds(349, 171, 252, 24);
						frame1.getContentPane().add(textArea);
						
						JLabel textArea_1 = new JLabel(p_name);
						textArea_1.setBounds(349, 220, 252, 24);
						frame1.getContentPane().add(textArea_1);
						
						JLabel textArea_2 = new JLabel(String.valueOf(p_price));
						textArea_2.setBounds(349, 269, 252, 24);
						frame1.getContentPane().add(textArea_2);
						
						JLabel textArea_3 = new JLabel(p_brand);
						textArea_3.setBounds(349, 318, 252, 24);
						frame1.getContentPane().add(textArea_3);
						
						JLabel textArea_4 = new JLabel(String.valueOf(p_quat));
						textArea_4.setBounds(349, 367, 252, 24);
						frame1.getContentPane().add(textArea_4);
						
						JButton button5=new JButton("Back to Admin Page");
					    button5.setFont(new Font("Times New Roman", Font.BOLD, 14));
						button5.setBackground(SystemColor.activeCaption);
						button5.setForeground(SystemColor.desktop);
						button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new a_product_details();
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
						new a_product_details();
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
	void p_delete()
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("");
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Delete Product");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(340, 100, 155, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel user = new JLabel("Product ID : ");
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		user.setBounds(230, 171, 155, 33);
		frame.getContentPane().add(user);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(349, 171, 252, 24);
		frame.getContentPane().add(textArea);
		
		JButton button=new JButton("Delete");
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
						String query="delete from Product where p_id='"+u+"';";
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(frame,"Record is Deleted");
						new a_product_details();
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Record not Found");
						new a_product_details();
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
		catch(Exception e)
		{
			
		}
		
	}

}
