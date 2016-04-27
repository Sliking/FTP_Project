package com.miguelpinto.ftp.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.miguelpinto.ftp.Connectiondb;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FTP_GUI {

	private JFrame frame;
	private static JTextField textField;
	private static JPasswordField passwordField;
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FTP_GUI window = new FTP_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FTP_GUI() {
		initialize();
		connection = Connectiondb.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				char[] _password = passwordField.getPassword();
				String password = String.copyValueOf(_password);
				
				String query = "SELECT * FROM Users WHERE username=? and password=?";
				try {
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(0, username);
					ps.setString(1, password);
					ResultSet rs = ps.executeQuery();
					
					int count = 0;
					
					while(rs.next()){
						count = count + 1;
					}
					if(count == 1){
						JOptionPane.showMessageDialog(null, "Logged in");
					}
					else if (count >= 1){
						JOptionPane.showMessageDialog(null, "Duplicate username and password");
					}
					else{
						JOptionPane.showMessageDialog(null, "Username and password are incorrect");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e);
				}
				finally{
					try {
						connection.close();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				frame.dispose();
				frame.setVisible(false);
				LoggedIn logged = new LoggedIn();
				logged.loggedIn();
				
			}
		});
		btnNewButton.setBounds(111, 192, 232, 80);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(172, 70, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(59, 75, 79, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(59, 121, 79, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblLogin.setBounds(193, 21, 63, 26);
		frame.getContentPane().add(lblLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 116, 130, 26);
		frame.getContentPane().add(passwordField);
	}
}
