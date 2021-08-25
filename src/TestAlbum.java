import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

import static org.junit.Assert.*;

public class TestAlbum {

    PlayList playList = new PlayList("Test");
    Artist a = new Artist("Test");
    Album album = new Album(a, "TestAlbum", 1999, "English", "Studio", null);
    Song s1 = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong1", 2021, "English", "Studio", 3);
    Song s2 = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong2", 2021, "English", "Studio", 3);

    @BeforeEach
    public void init(){
        album.addSong(s1);
        album.addSong(s2);
    }


    @Test
    public void testAddToPlayList(){
        album.addToPlayList(playList);
       assertTrue(playList.getSongList().containsAll(album.getSongList()));
    }

}
