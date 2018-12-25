package com.kk.socket.client;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.kk.socket.utils.ArgumentsUtil;
 
public class Client_1 {
 
	public Client_1() {
		try {
			Socket client = new Socket(ArgumentsUtil.host, ArgumentsUtil.port);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write("Hello server, this is " + this.getClass().getName() + " client..." + "\r\n");
			bw.write("\r\n");
			bw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println(br.readLine() );
			client.close();
			bw.close();
			br.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Client_1();
	}
}
