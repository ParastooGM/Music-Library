import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestSong {

    Artist a = new Artist("Test");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);



    @Test
    public void TestAddCollab(){
        Artist b = new Artist("Artist B");
        song.addCollab(b);
        try {
            Field collabsField = Song.class.getDeclaredField("aCollabs");
            collabsField.setAccessible(true);
            Optional<List<Artist>> l = (Optional<List<Artist>>) collabsField.get(song);
            assert l.get().contains(b);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestAddToPlayList(){
        PlayList playList = new PlayList("Test");
        song.addToPlyList(playList);
        assertTrue(playList.getSongList().contains(song));
    }

    @Test
    public void TestAcceptObserver(){
        Observer o = new NowPlayingObserver("Observer");
        song.acceptObserver(o);

        try {
            Field observersFiled = Song.class.getDeclaredField("aObservers");
            observersFiled.setAccessible(true);
            Set<Observer> observers = (Set<Observer>) observersFiled.get(song);
            assertTrue(observers.contains(o));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestRemoveObserver(){
        Observer o = new NowPlayingObserver("Observer");

        try {
            Field observersFiled = Song.class.getDeclaredField("aObservers");
            observersFiled.setAccessible(true);
            ((Set<Observer>) observersFiled.get(song)).add(o);
           song.removeObserver(o);
            assertFalse( ((Set<Observer>) observersFiled.get(song)).contains(o));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
