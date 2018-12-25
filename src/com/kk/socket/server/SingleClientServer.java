package com.kk.socket.server;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.kk.socket.utils.ArgumentsUtil;
 
public class SingleClientServer {
	
	@SuppressWarnings("resource")
	public SingleClientServer() {
		try {
			ServerSocket server = new ServerSocket(ArgumentsUtil.port);
			Socket client = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("client say : " + br.readLine());
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write("Hello client, this is server...");
			bw.write("\r\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SingleClientServer();
	}
}
