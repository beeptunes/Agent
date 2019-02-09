package Models;

import java.util.List;

public class SearchResult {
    private Albums albums;
    private Artists artists;
    private Tracks tracks;


    public abstract class SearchMasterItems<T> {
        List<T> data;
        Pagination pagination;

        public List<T> getData() {
            return data;
        }

        public void setData(List<T> data) {
            this.data = data;
        }

        public Pagination getPagination() {
            return pagination;
        }

        public void setPagination(Pagination pagination) {
            this.pagination = pagination;
        }

        @Override
        public String toString() {
            return "SearchMasterItems{" +
                    "data=" + data.size() +
                    '}';
        }
    }
    public class Pagination {
        int numPages;
        String next;

        public int getNumPages() {
            return numPages;
        }

        public void setNumPages(int numPages) {
            this.numPages = numPages;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }
    public class Albums extends SearchMasterItems<Album> {

    }
    public class Tracks extends SearchMasterItems<Track> {

    }
    public class Artists extends SearchMasterItems<Artist> {

    }

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }
}
