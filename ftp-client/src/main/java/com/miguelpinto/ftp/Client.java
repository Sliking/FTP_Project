package com.miguelpinto.ftp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
	
	private String _serverName;
	private int _port;
	private Socket _socket = null;
	private DataOutputStream _output = null;
	private DataInputStream _input = null;
	
	public Client(String serverName, int port) throws UnknownHostException, IOException{
		_serverName = serverName;
		_port = port;
		
		createStructures();
		
	}
	
	/**
	 * Method that creates the socket and the output and input streaming data
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void createStructures() throws UnknownHostException, IOException{
		setSocket(new Socket(getserverName(), getPort()));		
		setOutputStream();		
		setInputStream();
	}
	
	/* Getters */
	
	public DataOutputStream getOutput(){
		return _output;
	}
	
	public DataInputStream getInput(){
		return _input;
	}
	
	public Socket getSocket(){
		return _socket;
	}
	
	protected String getserverName(){
		return _serverName;
	}
	
	protected int getPort(){
		return _port;
	}
	
	/* Setters */
	
	protected void setserverName(String name){
		_serverName = name;
	}
	
	protected void setPort(int port){
		_port = port;
	}
	
	protected void setSocket(Socket socket){
		_socket = socket;
	}
	
	protected void setOutputStream() throws IOException{
		OutputStream out = getSocket().getOutputStream();
		_output = new DataOutputStream(out);
	}
	
	protected void setInputStream() throws IOException{
		InputStream in = getSocket().getInputStream();
		_input = new DataInputStream(in);
	}
	
	/**
	 * Method to close the socket
	 * @throws IOException
	 */
	public void closeSocket() throws IOException{
		getSocket().close();
	}
	
	/**
	 * Method to send a message
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException{
		getOutput().writeUTF(message);
	}
	
	/**
	 * Method to receive a message
	 * @return
	 * @throws IOException
	 */
	public String receiveMessage() throws IOException{
		return getInput().readUTF();
	}
	
	
	
}