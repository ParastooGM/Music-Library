import org.junit.Test;

import java.io.File;

public class TestNowPlayingObserver {
    NowPlayingObserver observer = new NowPlayingObserver("Observer1");
    Artist a = new Artist("Test");
    Artist b = new Artist("Test2");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);



    @Test
    public void TestNoticed(){
        observer.noticed(song);
        assert observer.getMsg().equals("Now Playing " + song.getTitle() + " by " + song.getArtist());

    }

    @Test
    public void TestNoticed2(){
        song.addCollab(b);
        observer.noticed(song);
        assert observer.getMsg().equals("Now Playing " + song.getTitle() + " by " + song.getArtist() + ", and " + song.getCollabs());

    }
}
