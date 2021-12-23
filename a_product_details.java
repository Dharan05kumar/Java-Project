import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class a_product_details 
{
	public a_product_details()
	{
		JFrame frame=new JFrame("Ecommerce Site");
		JLabel label=new JLabel("",SwingConstants.CENTER);
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Website");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(200, 50, 255, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon("D:\\a1.jpg"));
		lblNewLabel1.setBounds(160, 100, 250, 170);
		frame.getContentPane().add(lblNewLabel1);
	
		JButton button=new JButton("Add New Product");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product p=new Product();
					p.p_get();
				}catch(SQLException e1) {}
			}
		});
		button.setBounds(200, 290, 200, 46);
		frame.getContentPane().add(button);
		
		JButton button1=new JButton("Update the Product Details");
	    button1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button1.setBackground(SystemColor.activeCaption);
		button1.setForeground(SystemColor.desktop);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product p=new Product();
					p.p_update();
					}catch(SQLException e1) {}
			}
		});
		button1.setBounds(200, 330, 200, 46);
		frame.getContentPane().add(button1);
		
		JButton button2=new JButton("View the Product Details");
	    button2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button2.setBackground(SystemColor.activeCaption);
		button2.setForeground(SystemColor.desktop);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Product p=new Product();
					p.p_display();
			}
		});
		button2.setBounds(200, 370, 200, 46);
		frame.getContentPane().add(button2);
		
		JButton button3=new JButton("Search the Product");
	    button3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button3.setBackground(SystemColor.activeCaption);
		button3.setForeground(SystemColor.desktop);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Product p=new Product();
					p.p_search();
			}
		});
		button3.setBounds(200, 410, 200, 46);
		frame.getContentPane().add(button3);
		
		JButton button4=new JButton("Delete the Product");
	    button4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button4.setBackground(SystemColor.activeCaption);
		button4.setForeground(SystemColor.desktop);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Product p=new Product();
					p.p_delete();
			}
		});
		button4.setBounds(200, 450, 200, 46);
		frame.getContentPane().add(button4);
		
		JButton button5=new JButton("Back to Admin Page");
	    button5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button5.setBackground(SystemColor.activeCaption);
		button5.setForeground(SystemColor.desktop);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new home_admin();
			}
		});
		button5.setBounds(200, 490, 200, 46);
		frame.getContentPane().add(button5);
		
		frame.getContentPane().add(label);
		frame.setSize(600, 600); 
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new a_product_details();
	}

}
