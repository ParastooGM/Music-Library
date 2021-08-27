import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestTotalLengthVisitor {

    TotalLengthVisitor visitor = new TotalLengthVisitor();
    SongList sl = new PlayList("Test");
    Artist a = new Artist("Test");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);
    Song song1 = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong1", 2021, "English", "Studio", 2);



    @Test
    public void TestTotalLengthSongList(){
        sl.addSong(song);
        sl.addSong(song1);
        sl.acceptVisitor(visitor);
        assertEquals(visitor.getTotalLength(), 5);
    }

    @Test
    public void TestTotalLengthSong(){
        song.acceptVisitor(visitor);
        assertEquals(visitor.getTotalLength(), 3);
    }

}
