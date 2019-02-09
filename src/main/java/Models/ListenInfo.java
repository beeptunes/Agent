package Models;

public class ListenInfo {


    /**
     * {@link #trackId}
     * is the id of the track in question
     * {@link #when}
     * the moment to send the server in second. i.e: 0 for start of a song,
     * 134 for 2:14 and 35 for 0:35
     */
    private long trackId;
    private String when;

    public ListenInfo (long trackId, String when) {
        this.trackId = trackId;
        this.when = when;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }
}
