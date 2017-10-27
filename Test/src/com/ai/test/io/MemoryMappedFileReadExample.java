package com.ai.test.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMappedFileReadExample {

	private static String bigExcelFile = "bigFile.xls";

	public static void main(String[] args) throws IOException {

		File file = new File(bigExcelFile);

		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
		FileChannel channel = randomAccessFile.getChannel();

		MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

		System.out.println(mappedByteBuffer.isLoaded());
		System.out.println(mappedByteBuffer.capacity());

		for (int i = 0; i < mappedByteBuffer.limit(); i++) {
			System.out.print(mappedByteBuffer.getChar());
		}

	}

}
