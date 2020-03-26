import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String filename = "prova.txt";
        String filetoread = "toberead.txt";

        File f = new File(filename);
        File fr = new File(filetoread);





        // in which cases it would be better to use two separate try/catch, even
        // if the exception is the same?
        try {
            var reader = new FileReader(filetoread);
            var writer = new FileWriter("copiato.txt");
            // chained to the writer...
            BufferedWriter bw = new BufferedWriter(writer);

            Scanner sf = new Scanner(fr);
            int x = reader.read();
            while (x!=-1) {
                x = reader.read();
                System.out.println("C:"+(char)x);
                writer.write(x);
            }
            writer.close();
            while (sf.hasNext()) {
                System.out.println("reading: "+sf.next());
            }
            System.out.println("file ended!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + filetoread);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /// file creation example
        try {
            if (f.createNewFile()) {
                System.out.println("file created!");
            }
            else {
                System.out.println("Cannot create file");
            }

        } catch (IOException e) {
            System.out.println("Cannot open file "+filename);
            e.printStackTrace();
        }

        System.out.println(f.getAbsolutePath());

	// write your code here
    }
}
