package com.ai.test.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

	public static void main(String[] args) throws IOException {

		//与服务端进行连接
		Socket client = new Socket("localhost",28080);
		client.setSoTimeout(10000);
		
		
		//获得键盘输入
		Scanner scanner = new Scanner(System.in);
		//获取输出流，用来发送数据到服务端
		PrintStream out = new PrintStream(client.getOutputStream());
		//获取输入流，用来接收服务端发来的数据
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		boolean flag = true;
		while (flag) {
			System.out.print("输入信息：");
			String in = scanner.nextLine();
			//发送到服务端
			out.print(in);
			if ("bye".equals(in)) {
				flag = false;
			}else {
				String echo = buf.readLine();
				System.out.println(echo);
			}
		}
		scanner.close();
		if (client != null) {
			client.close();
		}
	}
}