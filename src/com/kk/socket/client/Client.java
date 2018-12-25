package com.kk.socket.client;
 
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

import com.kk.socket.utils.ArgumentsUtil;
 
/**
 * �ͻ���
 */
public class Client extends Socket{
     
    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;
     
    public Client(){
        try {
            try {
                client =new Socket(ArgumentsUtil.host, ArgumentsUtil.port);
                //�����˴����ļ�
                File file =new File("C:\\Users\\Administrator\\Downloads\\6163805.xlsx");
                fis =new FileInputStream(file);
                dos =new DataOutputStream(client.getOutputStream());
                 
                //�ļ����ͳ���
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();
                 
                //�����ļ�
                byte[] sendBytes =new byte[1024];
                int length =0;
                while((length = fis.read(sendBytes,0, sendBytes.length)) >0){
                    dos.write(sendBytes,0, length);
                    dos.flush();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(fis !=null)
                    fis.close();
                if(dos !=null)
                    dos.close();
                client.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    @SuppressWarnings("resource")
	public static void main(String[] args)throws Exception {
        new Client();
    }
}
