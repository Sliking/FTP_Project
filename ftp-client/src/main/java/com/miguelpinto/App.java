package com.miguelpinto;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.miguelpinto.ftp.Client;

public class App{
	
    public /*static void main( String[] args )*/ App(String username, char[] password){
    	String _password = String.copyValueOf(password);
    	System.out.println("Username: " + username + "\n" + "Password: " + _password);
    	
        String serverName = "localhost";
        Client client = null;
        int port = 50000;
        
    	try{
        	client = new Client(serverName, port);
        	Socket socket = client.getSocket();

    		System.out.println("Connecting to " + serverName + " on port " + port);
    		System.out.println("Just connected to " + socket.getRemoteSocketAddress());
    		try {
    			client.sendMessage("Hello from "+ socket.getLocalSocketAddress());
    			try {
        			System.out.println("Server says " + client.receiveMessage());
        			try {
            			client.closeSocket();
            		} catch (IOException e) {
            			System.err.println("[ERROR] Failed to close the sockets");
            		}
        		} catch (IOException e) {
        			System.err.println("[ERROR] Failed to receive the message");
        		}       		
    		} catch (IOException e) {
    			System.err.println("[ERROR] Failed to send the message");
    		}
    		
    	}catch(UnknownHostException e){
        	System.err.println("[ERROR] Unknown Host");
        }catch(IOException e){
        	System.err.println("[ERROR] IO exception");
        }
        
    }
}
