import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    final private List<Song> aSongs = new ArrayList<>();
    final private List<Artist> aArtists = new ArrayList<>();
    final private List<Album> aAlbums = new ArrayList<>();
    private String aName = "Music Library";
    private static final Library INSTANCE = new Library(); //Singleton design

    private enum AUDIO_FORMAT {
        MP4, MP3, WAV, FLAC, M4A, AAC, WMA
    }

    ;

    /**
     * Private constructor to enable single creation of a library instance.
     */
    private Library() {
    }

    /**
     * @return the single library instance.
     */
    public static Library Instance() {
        return INSTANCE;
    }

    /**
     * Setter method to change the name of the library.
     *
     * @param pName new name of the library.
     * @pre pName != null
     */
    public void setName(String pName) {
        assert pName != null;
        aName = pName;
    }

    /**
     * @return current name of the library.
     */
    public String getName() {
        return aName;
    }

    /**
     * @param pArtist the artist to retrieve all available albums in the current music library.
     * @return an iterator on the albums of the input artist.
     * @throws IllegalArgumentException if the artist does not exist in the current library.
     * @pre pArtist != null;
     */
    public Iterator<Album> getAlbums(Artist pArtist) throws IllegalArgumentException {
        assert pArtist != null;

        if (!aArtists.contains(pArtist)) {
            throw new IllegalArgumentException(pArtist + " does not currently exist in the library.");
        } else {
            return pArtist.getAlbums();
        }
    }

    /**
     * @param pArtist the artist to retrieve all available songs in the current music library.
     * @return an iterator on the songs of the input artist.
     * @throws IllegalArgumentException if the artist does not exist in the current library.
     * @pre pArtist != null;
     */
    public Iterator<Song> getSongs(Artist pArtist) throws IllegalArgumentException {
        assert pArtist != null;

        if (!aArtists.contains(pArtist)) {
            throw new IllegalArgumentException(pArtist + " does not currently exist in the library.");
        } else {
            return pArtist.getSongs();
        }
    }

    /**
     * Adds an Artist with their songs and albums to the library.
     * @param pArtist the artist to be added.
     * @pre pArtist != null
     */
    public void addArtist(Artist pArtist) {
        assert pArtist != null;
        aArtists.add(pArtist);
        Iterator iter = pArtist.getAlbums();
        while (iter.hasNext()) {
            Album albm = (Album) iter.next();
            aAlbums.add(albm);
            Iterator iter_song = albm.getSongs();
            while (iter_song.hasNext()) {
                aSongs.add((Song) iter_song.next());
            }
        }


    }

    /**
     * Removes an Artist with their songs and albums from the library.
     * @param pArtist the artist to be removed.
     * @pre pArtist != null
     */
    public void removeArtist(Artist pArtist) {
        assert pArtist != null;
        aArtists.remove(pArtist);
        Iterator iter = pArtist.getAlbums();
        while (iter.hasNext()) {
            Album albm = (Album) iter.next();
            aAlbums.remove(albm);
            Iterator iter_song = albm.getSongs();
            while (iter_song.hasNext()) {
                aSongs.remove((Song) iter_song.next());
            }
        }
    }

    public Song getSong(String title , String Artist){
        //ToDO
        return null;
    }

    public Album getAlbum(String title , String Artist){
        //ToDo
        return null;
    }

    public Artist getArtist(String name){
        //ToDo
        return null;
    }

}
