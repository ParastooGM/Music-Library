public class PlayList extends SongList{

    public PlayList(String aTitle) {
        super(aTitle);
    }

    /**
     * Renames a playlist after its creation.
     * @param aName the new name of the playlist.
     * @pre aName != null
     */
    public void rename(String aName){
        assert aName !=null;
        aTitle = aName;
    }

    /**
     * Removes a song from the playlist.\, updates the number of songs and the duration of the playlist.
     * @param pSong the song to be removed.
     * @pre pSong != null
     */
    public void removeSong(Song pSong){
        assert pSong != null;
        if (aSongs.contains(pSong)) {
            aSongs.remove(pSong);
            numSongs--;
            aLength -= pSong.getLength();
        }
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "Title='" + aTitle + '\'' +
                ", number of songs=" + numSongs +
                '}';
    }
}
