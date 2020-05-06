import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient4 {
    Socket socket;
    private String address;
    private int port;

    public static void main(String args[]) {

        if (args.length!=2)  {
            System.out.println("Usage: java MyClient <address> <port>");
            return;
        }

        MyClient4 client = new MyClient4(args[0],Integer.parseInt(args[1]));
        client.start();
    }

    public MyClient4(String address, int port) {
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
            Scanner server_scanner = new Scanner(socket.getInputStream());
            // from user
            Scanner user_scanner = new Scanner(System.in);

            String msg_to_send;
            String msg_received;

            boolean go = true;
            int choice;

            while (go) {

                System.out.println("-------------------------------");
                System.out.println("0 - Add person");
                System.out.println("1 - Remove person");
                System.out.println("2 - List all");
                System.out.println("3 - Save");
                System.out.println("4 - Quit");
                System.out.println("-------------------------------");
                System.out.print("enter choice->");
                choice = user_scanner.nextInt();

                switch (choice) {
                    case 0: // add
                        System.out.print("Insert name:");
                        String name = user_scanner.next();
                        System.out.print("Insert surname:");
                        String surname = user_scanner.next();
                        System.out.println("Insert age:");
                        int age = user_scanner.nextInt();

                        msg_to_send = "ADD "+name+" "+surname+" "+age;
                        System.out.println("DEBUG: Sending "+msg_to_send);
                        pw.println(msg_to_send);
                        pw.flush();

                        msg_received = server_scanner.nextLine();
                        if (msg_received.equals("ADD_OK")) {
                            System.out.println("Person added correctly!");
                        }
                        else if (msg_received.equals("ADD_ERROR")) {
                            System.out.println("Error adding person!!!");
                        }
                        else {
                            System.out.println("ERROR: unkown message->"+msg_received);

                        }
                        break;
                    case 1: // remove
                        break;
                    case 2: // list
                        msg_to_send = "LIST";
                        pw.println(msg_to_send);
                        pw.flush();

                        msg_received = server_scanner.nextLine();
                        boolean listing = true;
                        if (msg_received.equals("BEGIN")) {
                            System.out.println("Receiving list....");
                            while (listing) {
                                msg_received = server_scanner.nextLine();
                                if (msg_received.equals("END")) {
                                    listing = false;
                                    System.out.println("List ended");
                                } else {
                                    // printing the person
                                    System.out.println(msg_received);
                                }
                            }
                        }
                        else {
                            System.out.println("Unknown Response:"+msg_received);
                        }
                        break;
                    case 3: // save
                        pw.println("SAVE");
                        pw.flush();

                        msg_received = server_scanner.nextLine();
                        if (msg_received.equals("SAVE_OK")) {
                            System.out.println("File save correctly");
                        }
                        else if (msg_received.equals("SAVE_ERROR")) {
                            System.out.println("Error saving file");
                        }
                        else {
                            System.out.println("Unknown message: "+msg_received);
                        }

                        break;
                    case 4: // quit
                        go = false;
                        System.out.println("Quitting client...");
                        msg_to_send = "QUIT";
                        pw.println(msg_to_send);
                        pw.flush();
                        break;

                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
