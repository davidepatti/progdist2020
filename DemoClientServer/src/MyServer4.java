import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MyServer4 {

    ServerSocket socket;
    Socket client_socket;
    private int port;

    ArrayList<Person>  list = new ArrayList<Person>();

    public static void main(String args[]) {

        if (args.length!=1) {
            System.out.println("Usage java MyServer <port>");
            return;
        }

        MyServer4 server = new MyServer4(Integer.parseInt(args[0]));
        server.start();
    }

    public MyServer4(int port) {
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
                    System.out.println("Server Received: "+message);
                    Scanner msg_scanner = new Scanner(message);

                    String cmd = msg_scanner.next();
                    System.out.println("Received command:"+cmd);

                    if (cmd.equals("ADD")) {
                        String name = msg_scanner.next();
                        String surname = msg_scanner.next();
                        int age = msg_scanner.nextInt();
                        Person p = new Person();
                        p.setName(name);
                        p.setAge(age);
                        p.setSurname(surname);
                        list.add(p);
                        System.out.println("SERVER LOG:Added "+p);
                        // we always return OK, but in a more complex
                        // scenario, e.g., age>18, etc... an ADD_ERROR
                        // could be returned
                        pw.println("ADD_OK");
                        pw.flush();
                    }
                    else if (cmd.equals("REMOVE")){
                        System.out.println("Executing command REMOVE");
                    }
                    else if (cmd.equals("LIST")) {
                        pw.println("BEGIN");
                        pw.flush();

                        for (Person p: list) {
                            pw.println(p);
                            pw.flush();
                        }
                        pw.println("END");
                        pw.flush();
                    }
                    else if (cmd.equals("SAVE")) {
                        try {
                            var oos = new ObjectOutputStream(new FileOutputStream("x.ser"));
                            oos.writeObject(list);
                            oos.close();
                            pw.println("SAVE_OK");
                            pw.flush();
                            System.out.println("SERVER LOG: list saved correctly");

                        } catch (IOException e) {
                            pw.println("SAVE_ERROR");
                            pw.flush();
                            e.printStackTrace();
                        }

                    }
                    else if (cmd.equals("QUIT")) {
                        System.out.println("Server: Closing connection to "+client_socket.getRemoteSocketAddress());
                        client_socket.close();
                        go = false;
                    }
                    else {
                        System.out.println("Unknown command "+ message);
                        pw.println("ERROR_CMD");
                        pw.flush();
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Could not start server on port "+port);
            e.printStackTrace();
        }

    }


}
