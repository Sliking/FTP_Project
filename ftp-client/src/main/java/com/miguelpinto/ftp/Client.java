package com.miguelpinto.ftp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
	
	public Client() throws UnknownHostException, IOException{
		Socket socket = new Socket("localhost", 50000);
		DataOutputStream output = null;
		DataInputStream input = null;
	}
	
}