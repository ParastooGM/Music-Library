import org.junit.Test;
import java.io.File;
import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TestSongList {

    SongList sl = new PlayList("Test");
    Artist a = new Artist("Test");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);


    @Test
    public void TestAddSong(){
        sl.addSong(song);
        try {
            Field songsField = SongList.class.getDeclaredField("aSongs");
            songsField.setAccessible(true);
            List<Song> l = (List<Song>) songsField.get(sl);

            Field lengthField = SongList.class.getDeclaredField("aLength");
            lengthField.setAccessible(true);
            long length = (long) lengthField.get(sl);

            assert l.contains(song);
            assert length == song.getLength();
            assert  sl.getNumSongs() == 1;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestGetNextSong(){
        sl.addSong(song);
        assert sl.getNextSong().equals(song);
    }

    @Test
    public void TestGetPreviousSongException(){

        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
               sl.getPreviousSong();
            }
        });
    }

    @Test
    public void TestGetPreviousSong(){
        Song s1 = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong1", 2021, "English", "Studio", 3);
        sl.addSong(song);
        sl.addSong(s1);

        try {
            Field curField = SongList.class.getDeclaredField("currentSongNum");
            curField.setAccessible(true);
            curField.set(sl, 1);
            assertEquals(song, sl.getPreviousSong() );

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }



}
