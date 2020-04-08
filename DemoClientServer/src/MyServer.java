import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

    ServerSocket socket;
    Socket client_socket;
    private int port;

    public static void main(String args[]) {

        if (args.length!=1) {
            System.out.println("Usage java MyServer <port>");
            return;
        }

        MyServer server = new MyServer(Integer.parseInt(args[0]));
        server.start();
    }

    public MyServer(int port) {
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

                Scanner client_scanner = new Scanner(client_socket.getInputStream());
                PrintWriter pw = new PrintWriter(client_socket.getOutputStream());

                boolean go = true;
                while (go) {
                    String message = client_scanner.nextLine();
                    System.out.println("Server: Received "+message);

                    String message_big = message.toUpperCase();
                    System.out.println("Server: Sending "+message_big+" to "+client_socket.getRemoteSocketAddress());
                    pw.println(message_big);
                    pw.flush(); // DO NOT FORGET!
                    if (message.equals("QUIT")) {
                        System.out.println("Server: Closing connection to "+client_socket.getRemoteSocketAddress());
                        client_socket.close();
                        go = false;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Could not start server on port "+port);
            e.printStackTrace();
        }

    }


}
