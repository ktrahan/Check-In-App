/*
Test program demonstrating how to use Server.java (Socket Server) and ServerSocketThread.java (Socket Client)
*/

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws Exception {
        Server s = new Server(8080);
        Client c1 = new Client("localhost", 8080);
        Client c2 = new Client("localhost", 8080);
        Client c3 = new Client("localhost", 8080);
        System.out.println("a");
        System.out.println(c1.read());
        c1.write(3);
        System.out.println("aaaaaaaaaaa");
        c2.write(44141);
        System.out.println("bbbbbbbbbb");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(s.getAllIds());

        System.out.println("gggggggggg");
        System.out.println(c1.read());
        System.out.println("ddddddddddd");
        System.out.println(c2.read());
        System.out.println(c3.read());
        System.out.println(c3.read());
        System.out.println(c3.read());
        System.out.println("ccccccccccccc");
        System.out.println(s.getAllIds());
        c2.write(-3);

        c3.read();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(s.getAllIds());
        System.out.println("eeeeeeeeeeeeee");
        System.out.println(c2.read());
        System.out.println(c3.read());
        System.out.println(c3.read());

        c3.close();
        c1.write(5);
        c1.close();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(c2.read());
        c2.close();
        try {
            s.ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("c");
    }
}
