package com.ai.test.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOClient {

	private Selector selector;

	public void initClient(String ip, int port) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		this.selector = Selector.open();
		socketChannel.connect(new InetSocketAddress(ip, port));
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
	}
	
	
	public void listen() throws IOException{
		System.out.println("客户端启动");
		while (true) {
			selector.select();
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				iterator.remove();
				if (selectionKey.isConnectable()) {
					SocketChannel socketChannel =  (SocketChannel) selectionKey.channel();
					if (socketChannel.isConnectionPending()) {
						socketChannel.finishConnect();
					}
					socketChannel.configureBlocking(false);
					socketChannel.write(ByteBuffer.wrap(new String("向服务端发送一条消息").getBytes("UTF-8")));
					socketChannel.register(selector, SelectionKey.OP_READ);
				}else if (selectionKey.isReadable()) {
					read(selectionKey);					
				}
			}
		}
	}


	private void read(SelectionKey selectionKey) throws IOException {
		
		SocketChannel socketChannel =  (SocketChannel) selectionKey.channel();
		ByteBuffer allocate = ByteBuffer.allocate(10);
		socketChannel.read(allocate);
		byte[] array = allocate.array();
		String msg = new String(array).trim();
		ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes("UTF-8"));
		socketChannel.write(wrap);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		NIOClient nioClient = new NIOClient();
		nioClient.initClient("localhost",9999);
		nioClient.listen();
		
	}
	
	

}
