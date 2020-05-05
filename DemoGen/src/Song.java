import java.util.Objects;

public class Song implements Comparable<Song> {
    String title;
    String album;
    Integer length;
    Integer year;

    public Song(String title, String album, int length, int year) {
        this.title = title;
        this.album = album;
        this.length = length;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public Integer getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", length=" + length +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(Song song) {

        // put some arbitrary logic here ....
        if (this.length < song.length) return -1;
        if (this.length > song.length) return  1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) &&
                Objects.equals(album, song.album) &&
                Objects.equals(length, song.length) &&
                Objects.equals(year, song.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, album, length, year);
    }
}
