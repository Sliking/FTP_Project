package com.miguelpinto.ftp.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class LoggedIn {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void loggedIn() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoggedIn window = new LoggedIn();
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
	public LoggedIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoggedIn = new JLabel("Logged In");
		lblLoggedIn.setFont(new Font("Lucida Grande", Font.PLAIN, 31));
		lblLoggedIn.setBounds(137, 46, 234, 159);
		frame.getContentPane().add(lblLoggedIn);
	}
}
