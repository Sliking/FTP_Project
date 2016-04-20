package com.miguelpinto.ftp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Server{
	
	private int _port;
	private ServerSocket _socket = null;
	private int _timeout = -1;
	
	public Server(int port) throws UnknownHostException, IOException{
		_port = port;
		createStructures(getPort(), getTimeout());
	}
	
	public Server(int port, int timeout) throws UnknownHostException, IOException{
		_port = port;
		_timeout = timeout;
		createStructures(getPort(), getTimeout());
		
	}
	
	/* Getters */
	
	protected int getPort(){
		return _port;
	}
	
	public ServerSocket getSocket(){
		return _socket;
	}
	
	public int getTimeout(){
		return _timeout;
	}
	
	/* Setters */
	
	protected void setPort(int port){
		_port = port;
	}
	
	protected void setSocket(ServerSocket socket){
		_socket = socket;
	}
	
	/**
	 * Create the serversocket and set the timeout if it was provided
	 * @param port
	 * @param timeout
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void createStructures(int port, int timeout) throws UnknownHostException, IOException{
		setSocket(new ServerSocket(port));
		if(timeout>0){
			getSocket().setSoTimeout(timeout);
		}	    
	}
}