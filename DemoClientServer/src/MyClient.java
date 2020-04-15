import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    Socket socket;
    private String address;
    private int port;

    public static void main(String args[]) {

        if (args.length!=2)  {
            System.out.println("Usage: java MyClient <address> <port>");
            return;
        }

        MyClient client = new MyClient(args[0],Integer.parseInt(args[1]));
        client.start();
    }

    public MyClient(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void start() {
        System.out.println("Starting Client connection to "+address+":"+port);

        try {
            socket = new Socket(address,port);
            System.out.println("Started Client connection to "+address+":"+port);

            // to server
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            // from server
            Scanner scanner = new Scanner(socket.getInputStream());
            // from user
            Scanner user_scanner = new Scanner(System.in);

            boolean go = true;

            while (go) {
                System.out.print("Insert a string to send:");
                String message_to_send =  user_scanner.nextLine();
                System.out.println("Sending "+message_to_send);
                pw.println(message_to_send);
                pw.flush();
                String received_message = scanner.nextLine();
                System.out.println("Received: "+received_message);

                // client could attach a scanner to the string received message ...


                if (message_to_send.equals("QUIT")) {
                    System.out.println("Closing connection to "+socket.getRemoteSocketAddress());
                    socket.close();
                    go = false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
