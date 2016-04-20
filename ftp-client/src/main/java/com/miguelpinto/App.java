package com.miguelpinto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//import com.miguelpinto.ftp.Client;

public class App{
    public static void main( String[] args ){
        String serverName = "localhost";
        int port = 50000;
        
    	try{
        	//Client client = new Client();
        	System.out.println("Connecting to " + serverName +
        			 " on port " + port);
        	         Socket client = new Socket(serverName, port);
        	         System.out.println("Just connected to " 
        			 + client.getRemoteSocketAddress());
        	         OutputStream outToServer = client.getOutputStream();
        	         DataOutputStream out = new DataOutputStream(outToServer);
        	         out.writeUTF("Hello from "
        	                      + client.getLocalSocketAddress());
        	         InputStream inFromServer = client.getInputStream();
        	         DataInputStream in = new DataInputStream(inFromServer);
        	         System.out.println("Server says " + in.readUTF());
        	         client.close();
        }catch(UnknownHostException e){
        	System.err.println("[ERROR] Unknown Host");
        }catch(IOException e){
        	System.err.println("[ERROR] IO exception");
        }
    }
}
