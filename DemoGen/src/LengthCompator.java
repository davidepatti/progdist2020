import java.util.Comparator;

public class LengthCompator implements Comparator<Song> {

    @Override
    public int compare(Song song, Song t1) {

        return song.length - t1.length;
    }
}
