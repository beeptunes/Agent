package com.beeptunes.agent.Models;

public class ListenInfo {
    long trackId;
    String when;

    public ListenInfo (long trackId, String when) {
        this.trackId = trackId;
        this.when = when;
    }
}
