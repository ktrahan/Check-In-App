/*
Socket Server class
Handles client connections and distributes student IDs to all connected clients
*/

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Server {
	ServerSocket sc;
	List<ServerSocketThread> socketList;
	HashSet<Integer> ids;

	public Server() {
		try {
			sc = new ServerSocket(8080);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		socketList = new ArrayList<ServerSocketThread>();
		ids = new HashSet<Integer>();
		Runnable task = () -> {
			try {
				while (true) {
					ServerSocketThread sst = new ServerSocketThread(sc.accept(), this);
					addSST(sst);
					sst.start();
					sendAllIds(sst);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread t = new Thread(task);
		t.start();
	}

	public void addSST(ServerSocketThread sst) {
		synchronized (socketList) {
			socketList.add(sst);
		}
	}

	public void removeSST(ServerSocketThread sst) {
		synchronized (socketList) {
			socketList.remove(sst);
		}
	}

	public void sendNewIdToAll(Update u, ServerSocketThread sender) {
		synchronized (socketList) {
			Iterator<ServerSocketThread> i = socketList.iterator();
			while (i.hasNext()) {
				ServerSocketThread tmp = i.next();
				if (tmp != sender) {
					tmp.write((u.getStatus() ? 1 : -1) * u.getID());
				}
			}
		}
	}

	public void updateID(Update u, ServerSocketThread sender) {
		synchronized (ids) {
			if (u.getStatus()) {
				ids.add(u.getID());
			} else {
				ids.remove(u.getID());
			}
		}
		sendNewIdToAll(u, sender);
	}

	public synchronized void sendAllIds(ServerSocketThread sst) {
		synchronized (ids) {
			Iterator<Integer> i = ids.iterator();
			while (i.hasNext()) {
				sst.write(i.next());
			}
		}
	}

	public ArrayList<Integer> getAllIds() {
		synchronized (ids) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			Iterator<Integer> i = ids.iterator();
			while (i.hasNext()) {
				arr.add(i.next());
			}
			return arr;
		}
	}
}
