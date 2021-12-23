import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class intro {

	public intro()
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
        
	    JButton button=new JButton("Admin Login");
	    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(SystemColor.desktop);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new JFrame("Ecommerce Site");
				JLabel label=new JLabel("",SwingConstants.CENTER);
				frame.getContentPane().setBackground(new Color(255, 182, 193));
				frame.getContentPane().setForeground(SystemColor.activeCaption);
				
				JLabel user = new JLabel("User ID : ");
				user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				user.setBounds(230, 171, 155, 33);
				frame.getContentPane().add(user);
				
				JLabel pass = new JLabel("Password : ");
				pass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				pass.setBounds(230, 208, 155, 44);
				frame.getContentPane().add(pass);
				
				JTextArea textArea = new JTextArea();
				textArea.setBounds(349, 171, 252, 24);
				frame.getContentPane().add(textArea);
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(349, 220, 252, 24);
				frame.getContentPane().add(textArea_1);
				
				JButton button=new JButton("Login");
			    button.setFont(new Font("Times New Roman", Font.BOLD, 14));
				button.setBackground(SystemColor.activeCaption);
				button.setForeground(SystemColor.desktop);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						String u=textArea.getText();
						String p=textArea_1.getText();
						Admin a=new Admin();
						if(a.check(u,p)==1)
						{
							new home_admin();
						}
						else
						{
							new intro();
						}
						}
						catch(Exception e1) {}
					}
				});
				button.setBounds(220, 310, 150, 46);
			    frame.getContentPane().add(button);
				
				frame.getContentPane().add(label);
				frame.setSize(800, 600); 
		        frame.setLocationRelativeTo(null);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);
			}
		});
	    button.setBounds(340, 330, 150, 46);
	    frame.getContentPane().add(button);
	    
	    JButton button1=new JButton("Customer Login");
	    button1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button1.setBackground(SystemColor.activeCaption);
		button1.setForeground(SystemColor.desktop);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new home_customer();
			}
		});
	    button1.setBounds(90, 330, 150, 46);
	    frame.getContentPane().add(button1);
	    
	    frame.getContentPane().add(label);
        frame.setSize(600, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public static void main(String[] args) 
	{
	    	new intro();
	}

}
