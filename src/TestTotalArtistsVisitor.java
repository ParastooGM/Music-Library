import org.junit.Test;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestTotalArtistsVisitor{

    TotalArtistsVisitor visitor = new TotalArtistsVisitor();
    SongList sl = new PlayList("Test");
    Artist a = new Artist("Test");
    Artist b = new Artist("Test1");
    Artist c = new Artist("Test2");
    Artist d = new Artist("Test3");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);
    Song song1 = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), b, album, "TestSong1", 2021, "English", "Studio", 2);



    @Test
    public void TestTotalLengthSongList(){
        song.addCollab(c);
        song1.addCollab(d);
        sl.addSong(song);
        sl.addSong(song1);
        sl.acceptVisitor(visitor);
        Set<Artist> artists = new HashSet<Artist>();
        artists.add(a);
        artists.add(b);
        artists.add(c);
        artists.add(d);
        assertEquals(visitor.getTotalArtists(),artists);
    }

    @Test
    public void TestTotalLengthSong(){
        song.addCollab(c);
        song.addCollab(d);
        song.acceptVisitor(visitor);
        Set<Artist> artists = new HashSet<Artist>();
        artists.add(a);
        artists.add(c);
        artists.add(d);
        assertEquals(visitor.getTotalArtists(),artists);
    }

}
