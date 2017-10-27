package com.ai.test.socket;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Adler32;

public class SocketOutput implements Closeable {

	private DataOutputStream innerOutput;
	
	public SocketOutput(OutputStream stream){
		innerOutput = new DataOutputStream(new BufferedOutputStream(stream,256));
	}
	
	public void write(SocketPacket packet) throws Exception{
		innerOutput.write(SocketPacket.HEADER.getBytes());
		byte[] data = packet.drawAll();
		Adler32 check = new Adler32();
		check.update(data);
		long cs = check.getValue();
		innerOutput.writeLong(cs);
		innerOutput.writeInt(data.length);
		innerOutput.write(data);
		innerOutput.flush();
	}

	@Override
	public void close() throws IOException {
		innerOutput.close();
		
	}
}
