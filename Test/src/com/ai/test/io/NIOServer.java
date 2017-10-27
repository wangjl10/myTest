package com.ai.test.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {

		private Selector selector;
		
		
		public void initServer(int port) throws IOException {
			
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(port));
			this.selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			
		}
		
		
		
		public void listen() throws IOException{
			System.out.println("服务端启动！");
			
			while (true) {
				selector.select();
				Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					iterator.remove();
					if (selectionKey.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
						SocketChannel channel = server.accept();
						channel.configureBlocking(false);
						channel.write(ByteBuffer.wrap(new String("向客户端发送消息").getBytes("UTF-8")));
						channel.register(selector, selectionKey.OP_READ);
					}else if (selectionKey.isReadable()) {
						read(selectionKey);
					}
				}
			}
		}



		public void read(SelectionKey selectionKey) throws IOException {
		  
				SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
				ByteBuffer allocate = ByteBuffer.allocate(10);
				socketChannel.read(allocate);
				byte[] data = allocate.array();
				String msg = new String(data).trim();
				System.out.println("服务端接受的信息为" + msg);
				ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes("UTF-8"));
				socketChannel.write(byteBuffer);
			
		}
		
		public static void main(String[] args) throws IOException {
			NIOServer nioServer = new NIOServer();
			nioServer.initServer(9999);
			nioServer.listen();
		}
		
		
	
}
