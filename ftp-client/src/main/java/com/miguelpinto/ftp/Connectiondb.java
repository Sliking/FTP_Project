package com.miguelpinto.ftp;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connectiondb{
	
	public static Connection dbconnector(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/miguelpinto/Documents/FTP_Project/Database/FTP.sqlite");
			JOptionPane.showMessageDialog(null, "Connected!");
			return conn;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}
