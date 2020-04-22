import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServerMulti {

    ServerSocket socket;
    Socket client_socket;
    private int port;

    private int client_id = 0;

    public static void main(String args[]) {

        if (args.length!=1) {
            System.out.println("Usage java MyServer <port>");
            return;
        }

        MyServerMulti server = new MyServerMulti(Integer.parseInt(args[0]));
        server.start();
    }

    public MyServerMulti(int port) {
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

                ClientManager cm = new ClientManager(client_socket);
                Thread t = new Thread(cm,"client_"+client_id);
                t.start();
                client_id++;
            }

        } catch (IOException e) {
            System.out.println("Could not start server on port "+port);
            e.printStackTrace();
        }

    }


}
