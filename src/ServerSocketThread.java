/*
Socket Client class
Allows for communication of Student IDs with Master device
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerSocketThread extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Server server;

	public ServerSocketThread(Socket s, Server ser) {
		socket = s;
		server = ser;
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
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

	public void run() {
		try {
			while (socket.isConnected()) {
				int id = dis.readInt();
				server.updateID(new Update(id >= 0, Math.abs(id)), this);
			}
			System.out.println("Thread" + this.getId());
		} catch (IOException e) { // Catches the IOException while the readInt method is blocking bc of closing
									// client.
			// e.printStackTrace();

		} finally {
			server.removeSST(this);
			System.out.println("yo we removed this boy");
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("clsoe no wrok");
				e.printStackTrace();
			}
		}
	}
}
