package com.ai.test.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {

	private Socket client;

	public ServerThread() {
		super();
	}

	public ServerThread(Socket client) {
		super();
		this.client = client;
	}

	@Override
	public void run() {

		try {
			//获得socket的输出流，用来向客户端发送数据
			PrintStream out = new PrintStream(client.getOutputStream());
			//获得socket的输入流，用来接收从客户端发送过来的数据
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			boolean flag = true;
			while (flag) {
				//接收从客户端发送过来的数据
				String readLine = buf.readLine();
				if (readLine == null || "".equals(readLine)) {
					flag = false;
				} else {
					if ("bye".equals(readLine)) {
						flag = true;
					} else {
						//将接收到的字符串前面加上echo，发送到对应的客户端
						out.print("echo:" + readLine);
					}
				}
			}
			out.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}