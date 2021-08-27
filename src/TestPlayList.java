import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertFalse;

public class TestPlayList {
    PlayList pl = new PlayList("Test");
    Artist a = new Artist("Test");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);
    Song s2 = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong2", 2021, "English", "Studio", 3);


    @Test
    public void TestRename(){
        pl.rename("new");
        assert pl.getTitle().equals("new");
    }

    @Test
    public void TestAddAlbum(){
        album.addSong(song);
        album.addSong(s2);
        pl.addAlbum(album);
        pl.getSongList().containsAll(album.getSongList());
    }

    @Test
    public void TestRemoveSong(){
        pl.addSong(song);
        pl.removeSong(song);
        assertFalse (pl.getSongList().contains(song));

    }
}
