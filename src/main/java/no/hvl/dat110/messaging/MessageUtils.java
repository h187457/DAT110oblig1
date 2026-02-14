package no.hvl.dat110.messaging;

public class MessageUtils {

    public static final int SEGMENTSIZE = 128;

    public static int MESSAGINGPORT = 8080;
    public static String MESSAGINGHOST = "localhost";

    public static byte[] encapsulate(Message message) {

        byte[] data = message.getData();

        byte[] segment = new byte[SEGMENTSIZE];

        segment[0] = (byte) data.length;

        System.arraycopy(data, 0, segment, 1, data.length);

        return segment;
    }

    public static Message decapsulate(byte[] segment) {

        int len = Byte.toUnsignedInt(segment[0]);

        byte[] payload = new byte[len];

        System.arraycopy(segment, 1, payload, 0, len);

        return new Message(payload);
    }
}
