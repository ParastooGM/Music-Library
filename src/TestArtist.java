import org.junit.Test;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import static org.junit.Assert.*;

public class TestArtist {

    Artist a = new Artist("Test");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);

    @Test
    public void TestAddAlbum(){
        a.addAlbum(album);
        try {
            Field albumsFiled = Artist.class.getDeclaredField("aDiscography");
            albumsFiled.setAccessible(true);
            assertTrue (((List<Album>) albumsFiled.get(a)).contains(album));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestRemoveAlbum(){
        try {
            Field albumsFiled = Artist.class.getDeclaredField("aDiscography");
            albumsFiled.setAccessible(true);
            ((List<Album>) albumsFiled.get(a)).add(album);

            a.removeAlbum(album);
            assertFalse (((List<Album>) albumsFiled.get(a)).contains(album));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void TestAddSong(){
        a.addSong(song);
        try {
            Field SongsFiled = Artist.class.getDeclaredField("aSongs");
            SongsFiled.setAccessible(true);
            assertTrue (((List<Song>) SongsFiled.get(a)).contains(song));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestRemoveSong(){
        try {
            Field SongsFiled = Artist.class.getDeclaredField("aSongs");
            SongsFiled.setAccessible(true);
            ((List<Song>) SongsFiled.get(a)).add(song);

            a.removeSong(song);
            assertFalse (((List<Song>) SongsFiled.get(a)).contains(song));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }



}
