import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class home_cust 
{
	public home_cust(String u)
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
		lblNewLabel1.setBounds(160, 100, 250, 205);
		frame.getContentPane().add(lblNewLabel1);
		
		JButton button=new JButton("Personal Details");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new u_user_setting(u);
			}
		});
		button.setBounds(220, 310, 150, 46);
	    frame.getContentPane().add(button);
		
		JButton button1=new JButton("Product Details");
	    button1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button1.setBackground(SystemColor.activeCaption);
		button1.setForeground(SystemColor.desktop);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new u_product_details(u);
			}
		});
		button1.setBounds(220, 350, 150, 46);
	    frame.getContentPane().add(button1);
		
		JButton button2=new JButton("Back to Main");
	    button2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button2.setBackground(SystemColor.activeCaption);
		button2.setForeground(SystemColor.desktop);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new intro();
			}
		});
		button2.setBounds(220, 390, 150, 46);
	    frame.getContentPane().add(button2);
		
		frame.getContentPane().add(label);
		frame.setSize(600, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new home_customer();
	}

}
