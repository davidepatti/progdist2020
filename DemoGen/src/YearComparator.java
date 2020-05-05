import java.util.Comparator;

public class YearComparator implements Comparator<Song> {
    @Override
    public int compare(Song song, Song t1) {
        return song.year - t1.year;
    }
}
