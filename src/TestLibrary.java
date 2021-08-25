import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class TestLibrary {
    Artist a = new Artist("Test");
    Album album = new Album(a, "TestAlbum", 2020, "English", "Studio", null );
    Song song = new Song(new File("C:\\Users\\paras\\OneDrive\\Desktop\\Docs\\park.mp3"), a, album, "TestSong", 2021, "English", "Studio", 3);
    Library lib =  Library.Instance();


    @Test
    public void testAddArtist(){
        lib.addArtist(a);
        try {
            Field artistsField = Library.class.getDeclaredField("aArtists");
            artistsField.setAccessible(true);
            assertEquals(((Map<String, Artist>) artistsField.get(lib)).get(a.getName()), a);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveArtist(){
        try {
           Field artistsField = Library.class.getDeclaredField("aArtists");
            artistsField.setAccessible(true);
            ((Map<String, Artist>) artistsField.get(lib)).put(a.getName(), a);

            lib.removeArtist(a);
            assertNull(((Map<String, Artist>) artistsField.get(lib)).get(a.getName()));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetSong(){
        try {
            Field SongsField = Library.class.getDeclaredField("aSongs");
            SongsField.setAccessible(true);
            HashSet<Song> set = new HashSet<>();
            set.add(song);
            ((Map<String, HashSet<Song>>) SongsField.get(lib)).put(song.getTitle(), set);

            assertTrue(lib.getSong(song.getTitle()).get().contains(song));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAlbum(){
        try {
            Field AlbumsField = Library.class.getDeclaredField("aAlbums");
            AlbumsField.setAccessible(true);
            HashSet<Album> set = new HashSet<>();
            set.add(album);
           ((Map<String, HashSet<Album>>) AlbumsField.get(lib)).put(album.getTitle(), set);

            assertTrue(lib.getAlbum(album.getTitle()).get().contains(album));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetArtist(){

        try {
            Field artistsField = Library.class.getDeclaredField("aArtists");
            artistsField.setAccessible(true);
            ((Map<String, Artist>) artistsField.get(lib)).put(a.getName(), a);
            assertEquals(lib.getArtist(a.getName()).get(), a);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testGetSongEmpty(){
        try {
            Field SongsField = Library.class.getDeclaredField("aSongs");
            SongsField.setAccessible(true);
            SongsField.set(lib, new HashMap<>());
            assertEquals(lib.getSong(song.getTitle()), Optional.empty());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAlbumEmpty(){
        try {
            Field AlbumsField = Library.class.getDeclaredField("aAlbums");
            AlbumsField.setAccessible(true);
            AlbumsField.set(lib, new HashMap<>());

            assertEquals(lib.getAlbum(album.getTitle()), Optional.empty());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetArtistEmpty(){

        try {
            Field artistsField = Library.class.getDeclaredField("aArtists");
            artistsField.setAccessible(true);
            artistsField.set(lib, new HashMap<>());

            assertEquals(lib.getArtist(a.getName()), Optional.empty());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }


}
