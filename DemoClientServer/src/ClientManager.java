import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientManager implements Runnable {

    private Socket client_socket;

    public ClientManager(Socket myclient) {
        client_socket = myclient;
    }

    @Override
    public void run() {
        String tid = Thread.currentThread().getName();

        System.out.println(tid+"-> Accepted connection from " + client_socket.getRemoteSocketAddress());

        PrintWriter pw = null;
        Scanner client_scanner = null;

        try {
            client_scanner = new Scanner(client_socket.getInputStream());
            pw = new PrintWriter(client_socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean go = true;
        while (go) {
            String message = client_scanner.nextLine();
            System.out.println(tid+"-> Server Received: "+message);

            if (message.startsWith("TOUP")) {
                System.out.println(tid+"-> TOUP command received");
                String answer;
                answer = message.substring(4);
                pw.println(answer.toUpperCase());
                pw.flush();
            }
            else if (message.startsWith("CMD1")) {
                System.out.println(tid+"-> Executing CMD1 on "+message.substring(4));
                // something happens....
                pw.println("CMD1_OK");
                pw.flush();
            }
            else if (message.equals("QUIT")) {
                System.out.println(tid+"-> Server: Closing connection to "+client_socket.getRemoteSocketAddress());
                try {
                    client_socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                go = false;
            }
            else {
                System.out.println(tid+"-> Unknown command "+ message);
                pw.println("ERROR_CMD");
                pw.flush();
            }

        }
    }
}
