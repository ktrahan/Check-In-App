import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;

public class Client {
	
	Socket connection;
	DataOutputStream dos;
	DataInputStream dis;
	Queue<Integer> readBuffer;
	
	public Client(String ip, int port) {
		
		readBuffer = new LinkedList<Integer>();
		
		// 3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
		try {
			connection = new Socket(ip, port);
			dis = new DataInputStream(connection.getInputStream());
			dos = new DataOutputStream(connection.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Runnable task = () -> {
			try {
				while (!connection.isClosed()) {
					int id = dis.read();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
		Thread t = new Thread(task);
		t.start();
	}

	public void read() {
		try {
			int id = dis.readInt();
			System.out.println(id);
			// update(new Update(id > 0, Math.abs(id))); //UI needs to make the
			// update(Update u) method
		} catch (IOException e) {
			e.printStackTrace();
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
