/**
 * A data object used in the Library Application to illustrate information about a playlist.
 */
public class DataOBJ {

        //Storing data in String Format.
        final private String length;
        final private String artists;

        //Constructor
        DataOBJ(String l , String list){
            assert l != null && list != null;
            length = l;
            artists = list;
        }

        //Getter methods
        public String getLength(){
            return length;
        }

        public String getArtists(){
            return artists;
        }
    }
