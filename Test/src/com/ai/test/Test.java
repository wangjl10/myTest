package com.ai.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test {

	static int BUFFER_SIZE = 512;

	public static void main(String[] args) throws IOException {
		
		int x = 0xff;
		
		x = (x & 0x55) + ((x >> 1) & 0x55);    
		x = (x & 0x33) + ((x >> 2) & 0x33);    
		x = (x & 0x0f) + ((x >> 4) & 0x0f);    
		
		
		String s = "fqwjfjwqpfejpwq";
		
		
		System.out.println(x);
		

//		// 创建12个字节的字节缓冲区
//		ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
//		// 存入字符串
//		bb.asCharBuffer().put("abdcef");
//		System.out.println(Arrays.toString(bb.array()));
//
//		// 反转缓冲区
//		bb.rewind();
//		// 设置字节存储次序
//		bb.order(ByteOrder.BIG_ENDIAN);
//		bb.asCharBuffer().put("abcdef");
//		System.out.println(Arrays.toString(bb.array()));
//
//		// 反转缓冲区
//		bb.rewind();
//		// 设置字节存储次序
//		bb.order(ByteOrder.LITTLE_ENDIAN);
//		bb.asCharBuffer().put("abcdef");
//		System.out.println(Arrays.toString(bb.array()));
//
//		File file = new File("");
//		FileChannel fileChannel = new FileInputStream(file).getChannel();
//		MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_ONLY,
//				0, fileChannel.size());
//
//		byte[] b = new byte[BUFFER_SIZE];
//
//		int len = (int) file.length();
//
//		for (int i = 0; i < len; i += BUFFER_SIZE) {
//			if (len - i > BUFFER_SIZE) {
//				mappedByteBuffer.get(b);
//			} else {
//				mappedByteBuffer.get(new byte[len - i]);
//			}
//		}

	}

	@org.junit.Test
	public void testPrint() {
		char[] chars = new char[] { '\u0097' };
		String str = new String(chars);
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));

	}

	@org.junit.Test
	public void testMathMin() {
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
	}

	@org.junit.Test
	public void testDateFormat() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss Z");
		System.out.println(format.format(date));
		//
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);

		java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
		System.out.println(sqlDate.getTime());

		// System.out.println(sqlDate);
	}

	private byte[] getBytes(char[] chars) {
		Charset cs = Charset.forName("UTF-8");
		CharBuffer cb = CharBuffer.allocate(chars.length);
		cb.put(chars);
		cb.flip();
		ByteBuffer bb = cs.encode(cb);
		return bb.array();
	}

	private char[] getChars(byte[] bytes) {

		Charset cs = Charset.forName("UTF-8");
		ByteBuffer bb = ByteBuffer.allocate(bytes.length);
		bb.put(bytes);
		bb.flip();
		CharBuffer cb = cs.decode(bb);
		return cb.array();
	}

}
