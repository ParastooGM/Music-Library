import javafx.scene.image.Image;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAlbum {

    PlayList playList = new PlayList("Test");
    Artist a = new Artist("Test");
    Image img = new Image("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\Images\\clocks_1.png");
    Album album = new Album(a, "TestAlbum", 1999, "English", "Studio", img);

    @Test
    public void testAddToPlayList(){
        album.addToPlayList(playList);
       assertTrue(playList.getSongList().contains(album));
    }

}
