package com.miguelpinto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.miguelpinto.ftp.Server;

public class App{

	public static void main(String[] args){
		
		int port = 50000;
		Server server = null;
		
		try {
			server = new Server(port);
		}catch(UnknownHostException e){
        	System.err.println("[ERROR] Unknown Host");
        }catch(IOException e){
        	System.err.println("[ERROR] IO exception");
        }
		
		ServerSocket socket = server.getSocket();

        System.out.println("Waiting for client on port " + socket.getLocalPort() + "...");
        
        while(true){
        	 Socket serverSocket = null;
			try {
				serverSocket = socket.accept();
				System.out.println("Just connected to "+ serverSocket.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(serverSocket.getInputStream());
		        System.out.println(in.readUTF());
		        DataOutputStream out = new DataOutputStream(serverSocket.getOutputStream());
		        out.writeUTF("Thank you for connecting to "+ serverSocket.getLocalSocketAddress() + "\nGoodbye!");
		        serverSocket.close();
			} catch (IOException e) {
				System.out.println("[ERROR] Failed to accept connection");
			}
        	 
        }
        
	}

	   
}
