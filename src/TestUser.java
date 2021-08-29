import org.junit.Test;
import java.io.File;
import java.util.Iterator;

public class TestUser {
    User user = new User("User1");
    Artist a = new Artist("Test");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);


    @Test
    public void TestAddToFavoritesSong(){
        user.addToFavorites(song);
       assert user.getFavorites().getSongList().contains(song);
    }

    @Test
    public void TestAddToFavoritesAlbum(){
        user.addToFavorites(album);
       assert user.getFavorites().getSongList().containsAll(album.getSongList());
    }

    @Test
    public void TestAddToMyPlayLists(){
        PlayList pl = new PlayList("newPlayList");
        user.addToMyPlayLists(pl);
        assert user.getPlayListsList().contains(pl);
    }

    @Test
    public void TestCreateAndAddPlayList(){
        user.createAndAddPlayList("NewPlayList");
        PlayList found = null;
        Iterator<PlayList> iterator = user.getPlayLists();
        while (iterator.hasNext()){
            PlayList pl = iterator.next();
            if (pl.getTitle().equals("NewPlayList")){
                found = pl;
            }

            assert found != null;
        }

    }

}
