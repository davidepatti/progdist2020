import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<String> song_list = new ArrayList<>();

        song_list.add("Imagine");
        song_list.add("Brain Damage");
        song_list.add("Enjoy the silence");

        System.out.println("Printing with for loop");
        for (String s:song_list) {
            System.out.println(s);
        }

        System.out.println(song_list);

        Collections.sort(song_list);
        System.out.println(song_list);


        Song s1 = new Song("brain damage","the dark side of the moon",300,1974 );
        Song s2 = new Song("enjoy the silence","violator",250,1989);
        Song s3 = new Song("november rain","use your illusion I",540,1992);

        Song sx;

        sx = s2;




        ArrayList<Song> complete_list = new ArrayList<>();

        complete_list.add(s3);
        complete_list.add(s1);
        complete_list.add(s2);
        complete_list.add(sx);

        for (Song s: complete_list) {
            System.out.println(s);
        }

        System.out.println(complete_list);
        Collections.sort(complete_list);
        System.out.println(complete_list);
        System.out.println("--------------------------");


        System.out.println("Sorted by year:");

        YearComparator yc = new YearComparator();

        Collections.sort(complete_list,yc);
        System.out.println(complete_list);

        System.out.println("Sorted by length:");

        LengthCompator lc = new LengthCompator();

        Collections.sort(complete_list,lc);
        System.out.println(complete_list);


    }
}
