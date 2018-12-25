package com.kk.socket.thread;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
 
public class ServerThread extends Thread {
 
	private InputStream is = null;
	private OutputStream os = null;
	private Socket client = null;
 
	public ServerThread(Socket client) {
		try {
			this.is = client.getInputStream();
			this.os = client.getOutputStream();
			this.client = client;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
 
			System.out.println(getName() + " say : " + br.readLine());
			
			bw.write("Hello " + Thread.currentThread().getName() + " , this is server..." + "\r\n");
			bw.flush();
			
			client.close();
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
