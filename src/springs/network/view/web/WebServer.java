package springs.network.view.web;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Creates a ServerSocket accepting requests,
 * and creates a threaded WebClientHandler to handle each request.<br/>
 * Usage : <b>new WebServer().start()</b>
 */
public class WebServer extends Thread {

    public void run() {
        try {
            go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() throws Exception {
        int port = 5000;
        ServerSocket Server = new ServerSocket (port, 10, InetAddress.getByName("127.0.0.1"));
        System.out.println ("Listening on 127.0.0.1:" + port);
        boolean stay = true;
        while(stay) {
            Socket client = Server.accept();
            new WebClientHandler(client).start();
        }
    }

}
