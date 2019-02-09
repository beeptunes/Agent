package Models;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    Albums albums;
    Artists artists;
    Tracks tracks;

    public ArrayList<MediaMaterial> getMediaMaterials(){
        ArrayList<MediaMaterial> list = new ArrayList<MediaMaterial>();

        if(artists.data != null)
            list.addAll(artists.data);
        if(albums != null)
            list.addAll(albums.data);
        if(tracks != null)
            list.addAll(tracks.data);



        return list;
    }

    public int[] getCountArray(){
        int[] c = new int[3];
        c[0] = artists == null ? 0 : artists.data.size();
        c[1] = albums == null ? 0 : albums.data.size();
        c[2] = tracks == null ? 0 : tracks.data.size();

        return c;
    }

    public abstract class SearchMasterItems<T> {
        public List<T> data;
        public Pagination pagination;
    }
    public class Pagination {
        public int numPages;
        public String next;
    }
    public class Albums extends SearchMasterItems<Album> {

    }
    public class Tracks extends SearchMasterItems<Track> {

    }
    public class Artists extends SearchMasterItems<Artist> {

    }
}
