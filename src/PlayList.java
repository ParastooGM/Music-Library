public class PlayList extends SongList{

    public PlayList(String aTitle) {
        super(aTitle);
    }

    public void rename(String aName){
        assert aName !=null;
        aTitle = aName;
    }

    public void removeSong(Song pSong){
        assert pSong != null;
        if (aSongs.contains(pSong)) {
            aSongs.remove(pSong);
            numSongs--;
        }
    };


}
