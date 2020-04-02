import java.io.*;
import java.util.Scanner;

public class MyApp {
    Archive archive;

    public void start(){
        archive = new Archive();
        System.out.println("Starting the App...");
        showMenu();
    }

    private void saveArchive(){
        Scanner s = new Scanner(System.in);
        System.out.print("Save to filename:");
        String filename = s.next();

        try {
            var fos = new FileOutputStream(filename);
            var oos = new ObjectOutputStream(fos);
            oos.writeObject(archive);
            oos.close();
            System.out.println("File saved!");

        } catch (FileNotFoundException e) {
            System.out.println("Error writing file "+filename);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error writing object ");
            e.printStackTrace();
        }


    }

    public void loadArchive() {
        Scanner s = new Scanner(System.in);
        System.out.print("Load filename:");
        String filename = s.next();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            archive = (Archive) ois.readObject();
            System.out.println("Archive loaded!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void showMenu(){
        int choice;
        Scanner input = new Scanner(System.in);
        boolean continue_to_show = true;

        while (continue_to_show) {
            System.out.println("______m_y___a_p_p____________________");
            System.out.println(" 1 - Create to new archive");
            System.out.println("-------------------------------------");
            System.out.println(" 2 - Load archive");
            System.out.println("-------------------------------------");
            System.out.println(" 3 - Save archive");
            System.out.println("-------------------------------------");
            System.out.println(" 4 - Insert element");
            System.out.println("-------------------------------------");
            System.out.println(" 5 - Show archive ");
            System.out.println("-------------------------------------");
            System.out.println(" 0 - quit ");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice:");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    archive.create();
                    break;
                case 2:
                    loadArchive();
                    break;
                case 3:
                    this.saveArchive();
                    break;
                case 4:
                    Scanner ts = new Scanner(System.in);
                    Person temperson = new Person();
                    String name;
                    int age;
                    System.out.print("Name:");
                    name = ts.next();
                    System.out.print("Age:");
                    age = ts.nextInt();
                    temperson.setName(name);
                    temperson.setAge(age);
                    archive.add(temperson);
                    break;
                case 5:
                    archive.show();
                    break;
                case 0:
                    continue_to_show = false;
                    break;
                default:
                    System.out.println("Choice not valid!"+choice);
            }

        }

    }
}
