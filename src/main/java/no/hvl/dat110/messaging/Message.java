package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

    public Message(byte[] data) {

        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (data.length > MessageUtils.SEGMENTSIZE) {
            throw new IllegalArgumentException("Data too long");
        }

        this.data = data;
    }


	public byte[] getData() {
		return this.data; 
	}

}
