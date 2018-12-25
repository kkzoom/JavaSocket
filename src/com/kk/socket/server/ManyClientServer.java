package com.kk.socket.server;
 
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.kk.socket.thread.ServerThread;
import com.kk.socket.utils.ArgumentsUtil;
 
public class ManyClientServer {
	private Socket client = null;
	
	public ManyClientServer() {
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(ArgumentsUtil.port);
			while(true){
				client = server.accept();
				//print the context that is sent by client, and say hello to every client.
				new ServerThread(client).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ManyClientServer();
	}
}
