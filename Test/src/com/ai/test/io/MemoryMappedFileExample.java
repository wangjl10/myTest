package com.ai.test.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMappedFileExample {

	static int length = 0x8FFFF;

	public static void main(String[] args) throws IOException {

		FileChannel channel = new RandomAccessFile("", "rw").getChannel();
		MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, length);

		for (int i = 0; i < length; i++) {
			map.put((byte) 'a');
		}

		System.out.println("Finished Writing");

	}

}
