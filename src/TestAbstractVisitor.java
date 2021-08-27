import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertTrue;

public class TestAbstractVisitor {

    Boolean visited_songList = false;
    Boolean visited_song = false;
    Visitor stubVisitor = new AbstractVisitor() {

        @Override
        public void VisitSong(Song aSong) {
            visited_song = true;
        }

        @Override
        public void VisitSongList(SongList aSongList) {
            visited_songList = true;
        }
    };


    @Test
    public void TestVisitSongList(){
        SongList songList = new PlayList("pl");
        stubVisitor.VisitSongList(songList);
        assertTrue(visited_songList);
    }

    @Test
    public void TestVisitSong(){
        Artist a = new Artist("Test");
        Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
        Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);
        stubVisitor.VisitSong(song);
        assertTrue(visited_song);
    }

}
