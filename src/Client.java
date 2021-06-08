import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;

public class Client {
	
	Socket connection;
	BufferedInputStream dis;
	DataOutputStream dos;
	Queue<Integer> readBuffer;
	
	public Client(String ip, int port) {
		
		readBuffer = new LinkedList<Integer>();
		
		try {
			connection = new Socket(ip, port);
			dis = new BufferedInputStream(connection.getInputStream());
			dos = new DataOutputStream(connection.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Runnable task = () -> {
			try {
				while (connection.isConnected()) {
					int id = dis.read();
					synchronized (readBuffer) {
						readBuffer.add(id);
						System.out.println(id +", " + Thread.currentThread());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
		Thread t = new Thread(task);
		t.start();
	}

	public int read() {
		synchronized (readBuffer) {
			System.out.println("++++++++++++++++++++++++++" + readBuffer.size());
			int t = readBuffer.poll();
			System.out.println("==========================" + t);
			return t;
		}
	}

	public void write(int x) {
		try {
			dos.writeInt(x);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
