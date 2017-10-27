package com.ai.test.socket;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Adler32;

public class SocketInput implements Closeable{

	private DataInputStream innerInput;
	
	public SocketInput(InputStream stream){
		innerInput = new DataInputStream(new BufferedInputStream(stream, 256));
	}
	
	public SocketPacket receive() throws Exception{
		byte[] hb = new byte[SocketPacket.HB_SIZE];
		//check header
		innerInput.readFully(hb);
		String ph = new String(hb);
		if(!ph.equals(SocketPacket.HEADER)){
			throw new IOException("Data is miss,please reconnect server!");
		}
		//check checksum
		long cs = innerInput.readLong();
		//check data 
		int dl = innerInput.readInt();//data length;
		//get data
		byte[] data = new byte[dl];
		innerInput.readFully(data);
		Adler32 check = new Adler32();
		check.update(data);
		long ccs = check.getValue();
		if(ccs != cs){
			throw new IOException("Data is lost or modified,please reconnect server!");
		}
		SocketPacket packet = new SocketPacket();
		packet.append(data);
		return packet;
	}

	@Override
	public void close() throws IOException {
		innerInput.close();
		
	}
}
