import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MyServer5 {

    ServerSocket socket;
    Socket client_socket;
    private int port;

    int client_id = 0;

    PersonList list = new PersonList();

    public static void main(String args[]) {

        if (args.length!=1) {
            System.out.println("Usage java MyServer <port>");
            return;
        }

        MyServer5 server = new MyServer5(Integer.parseInt(args[0]));
        server.start();
    }

    public MyServer5(int port) {
        // we could also put port value checks here...
        System.out.println("Initializing server with port "+port);
        this.port = port;
    }

    public void start() {
        try {
            System.out.println("Starting server on port "+port);
            socket = new ServerSocket(port);
            System.out.println("Started server on port "+port);
            while (true) {
                System.out.println("Listening on port " + port);
                client_socket = socket.accept();
                System.out.println("Accepted connection from " + client_socket.getRemoteSocketAddress());

                ClientManager5 cm = new ClientManager5(client_socket,list);
                Thread t = new Thread(cm,"client_"+client_id);
                client_id++;
                t.start();
            }

        } catch (IOException e) {
            System.out.println("Could not start server on port "+port);
            e.printStackTrace();
        }

    }


}
