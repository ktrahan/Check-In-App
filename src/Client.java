import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket connection;
	DataOutputStream os;
	DataInputStream is;

	public Client() {
		String ip = "localhost";

		// 2. Create an integer for the server's port number
		int p = 8080;

		// 3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
		try {
			connection = new Socket(ip, p);
			is = new DataInputStream(connection.getInputStream());
			os = new DataOutputStream(connection.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void read() {
		try {
			int id = is.readInt();
			update(new Update(id > 0, Math.abs(id))); //UI needs to make the update(Update u) method
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(int x) {
		try {
			os.writeInt(x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
