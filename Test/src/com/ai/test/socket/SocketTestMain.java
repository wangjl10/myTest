package com.ai.test.socket;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTestMain {

	private static final int port = 30008;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Thread server = new ServerThread();
		server.start();
		Thread client = new ClientThread();
		client.start();
		Thread.sleep(2000);
	}

	static class ServerThread extends Thread {
		@Override
		public void run() {
			try {
				ServerSocket socket = new ServerSocket();
				try{
					//socket.setSoTimeout(20000);
					socket.setReuseAddress(true);
					socket.bind(new InetSocketAddress(port));
					Socket accept = null;
					while ((accept = socket.accept()) != null) {
						accept.setTcpNoDelay(true);
						System.out.println("Connected Server");
						Thread thread = new HandlerThread(accept);
						thread.start();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class ClientThread extends Thread {
		@Override
		public void run() {
			try {
				Socket socket = new Socket();
				socket.setSoTimeout(20000);
				//socket.setTcpNoDelay(true);
				socket.connect(new InetSocketAddress(port));
				if (!socket.isConnected()) {
					System.out.println("Connect error!!");
				}
				System.out.println("Connected");
				SocketInput input = new SocketInput(socket.getInputStream());
				SocketOutput output = new SocketOutput(socket.getOutputStream());
				int i = 0;
				while (true) {
					if (i < 5) {
						SocketPacket sp = new SocketPacket();
						String send = ">>>>>>" + System.currentTimeMillis();
						sp.append(send.getBytes());
						output.write(sp);
					} else {
						SocketPacket packet = new SocketPacket();
						packet.append("quit".getBytes());
						output.write(packet);
						socket.close();
						Thread.sleep(1000);
						return;
					}
					SocketPacket rp = input.receive();
					System.out.println("Client receive data:"
							+ new String(rp.drawAll()));
					i++;
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class HandlerThread extends Thread {
		private Socket socket;

		HandlerThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				SocketInput input = new SocketInput(socket.getInputStream());
				SocketOutput output = new SocketOutput(socket.getOutputStream());
				while (true) {
					SocketPacket rp = input.receive();
					String receive =  new String(rp.drawAll());
					System.out.println("Server receives data : " + receive);
					if (receive.equalsIgnoreCase("quit")) {
						socket.close();
						return;
					}
					rp.clear();
					String data = "<<<<<<<< : " + System.currentTimeMillis();
					rp.append(data.getBytes());
					output.write(rp);
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
