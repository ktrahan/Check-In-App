/*
Socket Client class
Allows for communication of Student IDs with Master device
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 * A thread for the server to handle a client connection.
 * @author Artin Kim, Arman Aryan, Devin Merriett
 * @version 1.0
 * @since 2021-05-27
*/
public class ServerSocketThread extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Server server;

  /**
  *@param socket Socket created by accepting new client
  *@param server Refernce to the server object which created ServerScoketThread
  * Takes in a reference of the server object 
  *Initailzes DataInputStream and DataOutputStream from the socket
  */
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
  /**
  *@param x Integer to send to client from DataOutputStream 

  */
	public void write(int x) {
		try {
			dos.writeInt(x);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  /**
  *implements abstract run method from thread.
  *Waits to recieve new integer representing id.Then notifies server that a new id has been receieved by using an update object created from a recieved id and a reference to this ServerSocketThread. 
  */
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
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * closes the socket, datainputstream, and dataoutputstream
	 */
	public void close() {
		try {
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
