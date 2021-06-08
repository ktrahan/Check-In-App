/*
Client Object that allows for asynchronous communication with the server
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Artin Kim, Arman Aryan, Adin Ackerman, Devin Merriett
 * @version 1.0
 * @since 2021-05-27
 */
public class Client {

	Socket connection;
	DataInputStream dis;
	DataOutputStream dos;
	Queue<Integer> readBuffer;

	public Client(String ip, int port) {

		readBuffer = new LinkedList<Integer>();

		try {
			connection = new Socket(ip, port);
			dis = new DataInputStream(connection.getInputStream());
			dos = new DataOutputStream(connection.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * sets up new thread to continually read data, and adds all data to the
		 * readBuffer LinkedList.
		 */
		Runnable task = () -> {
			try {
				while (connection.isConnected()) {
					int id = dis.readInt();
					synchronized (readBuffer) {
						readBuffer.add(id);
						// System.out.println(id + ", " + Thread.currentThread());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
		Thread t = new Thread(task);
		t.start();
	}

	/**
	 * removes the last item in readBuffer
	 * 
	 * @return the last item in readBuffer, or if the list is empty, 0
	 */
	public int read() {
		synchronized (readBuffer) {
			if (readBuffer.size() == 0) {
				return 0;
			}
			return readBuffer.poll();
		}
	}

	/**
	 * writes data to the socket
	 * 
	 * @param x data to send, an int
	 */
	public void write(int x) {
		try {
			dos.writeInt(x);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * closes the socket, datainputstream, and dataoutputstream
	 */
	public void close() {
		try {
			dis.close();
			dos.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
