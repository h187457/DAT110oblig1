package no.hvl.dat110.messaging;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MessageConnection {

    private DataOutputStream outStream;
    private DataInputStream inStream;
    private Socket socket;

    public MessageConnection(Socket socket) {

        try {

            this.socket = socket;

            outStream = new DataOutputStream(socket.getOutputStream());
            inStream = new DataInputStream(socket.getInputStream());

        } catch (IOException ex) {

            System.out.println("Connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void send(Message message) {

        try {

            byte[] segment = MessageUtils.encapsulate(message);

            outStream.write(segment);
            outStream.flush();

        } catch (IOException ex) {

            System.out.println("Send error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    public Message receive() {

        Message message = null;

        try {

            byte[] segment = new byte[MessageUtils.SEGMENTSIZE];

            inStream.readFully(segment);

            message = MessageUtils.decapsulate(segment);


        } catch (IOException ex) {

            System.out.println("Receive error: " + ex.getMessage());
            ex.printStackTrace();
        }

        return message;
    }

    public void close() {

        try {
            outStream.close();
            inStream.close();
            socket.close();
        } catch (IOException ex) {

            System.out.println("Connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
