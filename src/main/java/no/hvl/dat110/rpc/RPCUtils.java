package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
        rpcmsg = new byte[1 + payload.length];
        rpcmsg[0] = rpcid;
        System.arraycopy(payload, 0, rpcmsg, 1, payload.length);
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
        payload = Arrays.copyOfRange(rpcmsg, 1, rpcmsg.length);
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START 
        byte[] strbytes = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        ByteBuffer bb = ByteBuffer.allocate(4 + strbytes.length);
        bb.putInt(strbytes.length);
        bb.put(strbytes);
        encoded = bb.array();
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 
        ByteBuffer bb = ByteBuffer.wrap(data);
        int len = bb.getInt();
        byte[] strbytes = new byte[len];
        bb.get(strbytes);
        decoded = new String(strbytes, java.nio.charset.StandardCharsets.UTF_8);
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 
        encoded = new byte[0];
		// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		//Trenger ikkje noke sida det er void
		
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		// TODO - START 
        encoded = ByteBuffer.allocate(4).putInt(x).array();
		// TODO - END
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
        decoded = ByteBuffer.wrap(data).getInt();
		// TODO - END
		
		return decoded;
		
	}
}
