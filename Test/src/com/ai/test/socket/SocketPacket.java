package com.ai.test.socket;

import java.nio.ByteBuffer;

public class SocketPacket {

	public static final String HEADER = "[MAGIC_HEADER]";
	public static final int MAX_SIZE = 2048;
	public static final int HB_SIZE = 14;//HEADER.getBytes().length
	private ByteBuffer buffer = ByteBuffer.allocate(MAX_SIZE);
	
	
	public void append(byte[] segment){
		buffer.put(segment);
	}
	
	/**
	 * 返回buffer中所有的可用数据
	 * @return
	 */
	public byte[] drawAll(){
		buffer.flip();
		byte[] all = new byte[buffer.limit()];
		buffer.get(all);
		buffer.clear();
		return all;
	}
	
	/**
	 * 获取buffer中可用的数据
	 *
	 * @param dst
	 * @return 获取到的byte数
	 */
	public int draw(byte[] dst){
		buffer.flip();
		int remaining = buffer.remaining();
		if(remaining > 0){
			buffer.get(dst);
			buffer.compact();//压缩
			buffer.position(buffer.limit());//重置position
		}
		buffer.limit(buffer.capacity());//重置limit
		//after this ,the buffer is ready for put.
		return remaining > dst.length ? dst.length : remaining;
	}
	
	public void clear(){
		buffer.clear();
	}
}
