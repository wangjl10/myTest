package com.ai.test.socket.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static void main(String[] args) throws IOException {
		
		//服务端监听20006端口
		ServerSocket serverSocket = new ServerSocket(28080);
		Socket client = null;
		
		boolean flag = true;
		while (flag) {
			//等待客户端的连接
			client = serverSocket.accept();
			System.out.println("与客户端连接成功！");
			//为每个客户端连接开启一个线程
			new Thread(new ServerThread(client)).start();
		}
		serverSocket.close();
		
	}
	

}
