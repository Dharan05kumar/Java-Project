import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class home_admin 
{
	public home_admin()
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
		lblNewLabel1.setIcon(new ImageIcon("D:\\a6.png"));
		lblNewLabel1.setBounds(160, 100, 250, 250);
		frame.getContentPane().add(lblNewLabel1);
		
		JButton button=new JButton("Admin Settings");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_settings();
			}
		});
		button.setBounds(220, 330, 150, 46);
	    frame.getContentPane().add(button);
		
		JButton button1=new JButton("User Settings");
	    button1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button1.setBackground(SystemColor.activeCaption);
		button1.setForeground(SystemColor.desktop);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new a_user_setting();
			}
		});
		button1.setBounds(220, 370, 150, 46);
	    frame.getContentPane().add(button1);
		
		JButton button2=new JButton("Product Details");
	    button2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button2.setBackground(SystemColor.activeCaption);
		button2.setForeground(SystemColor.desktop);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new a_product_details();
			}
		});
		button2.setBounds(220, 410, 150, 46);
	    frame.getContentPane().add(button2);
		
		JButton button3=new JButton("Back to Main page");
	    button3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button3.setBackground(SystemColor.activeCaption);
		button3.setForeground(SystemColor.desktop);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new intro();
			}
		});
		button3.setBounds(220, 450, 150, 46);
	    frame.getContentPane().add(button3);
		
	    frame.getContentPane().add(label);
		frame.setSize(600, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public static void main(String args[])
	{
		new home_admin();
	}

}
