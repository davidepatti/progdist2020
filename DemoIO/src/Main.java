import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);

        int choice = 200;

        /* MENU with catched exception
        try {
            while (choice != 0) {
                System.out.println("(1) do something ");
                System.out.println("(2) do something else");
                System.out.println("(0) quit");

                System.out.println("Choice-->");
                choice = sc.nextInt();

                sc.nextLine();

                System.out.println("You entered " + choice);
            }
        }
        catch (InputMismatchException im) {

            System.out.println("Error: Invalid input ->"+sc.nextLine());
        }
         */


        /* SIMPLE Scanner example
        String ans="";

        while (!ans.equals("quit")) {
            System.out.println("Insert something:");
            ans = sc.nextLine();
            System.out.println("You typed:"+ans);
        }
         */

        System.out.println("bye bye");


        while (true) {
           sc.findInLine("pippo");
            System.out.println("mi rimane"+sc.nextLine());
        }


    }
}
