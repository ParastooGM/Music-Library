import java.util.*;

public class Library {

    final private Map<String, HashSet<Song>> aSongs = new HashMap<>();
    final private Map<String, Artist> aArtists = new HashMap<>();
    final private Map< String, HashSet<Album>> aAlbums = new HashMap<>();
    private String aName = "Music Library";
    private static final Library INSTANCE = new Library(); //Singleton design

    private enum AUDIO_FORMAT {
        MP4, MP3, WAV, FLAC, M4A, AAC, WMA
    }

    ;

    /**
     * Private constructor to enable single creation of a library instance.
     */
    private Library() {}

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

        if (aArtists.get(pArtist.getName()) == null) {
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

        if (aArtists.get(pArtist.getName()) == null) {
            throw new IllegalArgumentException(pArtist + " does not currently exist in the library.");
        } else {
            return pArtist.getSongs();
        }
    }

    /**
     * Adds an Artist with their songs and albums to the library.
     * @param pArtist the artist to be added.
     * @pre pArtist != null
     * @throws IllegalArgumentException if an artist with the same name is already in the database.
     */
    public void addArtist(Artist pArtist) {
        assert pArtist != null;

        if (aArtists.get(pArtist.getName()) == null){ //if the artist is not already in the database

            aArtists.put(pArtist.getName() , pArtist);
            Iterator iter = pArtist.getAlbums();

            while (iter.hasNext()) {
                Album albm = (Album) iter.next();

                HashSet<Album> albm_list = aAlbums.get(albm.getTitle());
                if (albm_list != null){
                    albm_list.add(albm);
                    aAlbums.put(albm.getTitle(), albm_list);
                }else{
                    HashSet<Album> new_list = new HashSet<>();
                    new_list.add(albm);
                    aAlbums.put(albm.getTitle(), new_list);
                }

                Iterator iter_song = albm.getSongs();
                while (iter_song.hasNext()) {

                    Song s = (Song) iter.next();

                    HashSet<Song> song_list = aSongs.get(s.getTitle());
                    if (song_list != null){
                        song_list.add(s);
                        aSongs.put(s.getTitle(), song_list);
                    }else{
                        HashSet<Song> new_list = new HashSet<>();
                        new_list.add(s);
                        aSongs.put(s.getTitle(), new_list);
                    }
                }
            }
        }else{
            throw new IllegalArgumentException("Cannot add artist because an artist with the same name already exists in the library.");
        }

    }

    /**
     * Removes an Artist with their songs and albums from the library.
     * @param pArtist the artist to be removed.
     * @pre pArtist != null
     */
    public void removeArtist(Artist pArtist) {
        assert pArtist != null;
        if (aArtists.get(pArtist.getName()) != null) {
            aArtists.remove(pArtist.getName());
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
    }

    /**
     * Retrieves a list of songs with the parameter title from the database; used in searching.
     * @param title the string / key with which the songs list will be retrieved.
     * @return The optional of the retrieved songs list or an Optional.empty object.
     */
    public Optional<HashSet<Song>> getSong(String title ){
        if (aSongs.containsKey(title)){
            return Optional.of(aSongs.get(title));
        }else{
            return Optional.empty();
        }

    }


    /**
     * Retrieves a list of albums with the parameter title from the database; used in searching.
     * @param title the string / key with which the albums list will be retrieved.
     * @return The optional of the retrieved albums list or an Optional.empty object.
     */
    public Optional<HashSet<Album>> getAlbum(String title ){
        if (aAlbums.containsKey(title)){
            return Optional.of(aAlbums.get(title));
        }else{
            return Optional.empty();
        }
    }

    /**
     * Retrieves an artist object with their name from the database; used in searching.
     * @param name the string / key with which the artist object will be retrieved.
     * @return The optional of the retrieved artist or an Optional.empty object.
     */
    public Optional<Artist> getArtist(String name){
        if (aArtists.containsKey(name)){
            return Optional.of(aArtists.get(name));
        }else {
            return Optional.empty();
        }
    }

}
