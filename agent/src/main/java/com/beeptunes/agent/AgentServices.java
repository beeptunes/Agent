package com.beeptunes.agent;

import com.beeptunes.agent.Models.Album;
import com.beeptunes.agent.Models.Artist;
import com.beeptunes.agent.Models.DownloadLinks;
import com.beeptunes.agent.Models.SearchResult;
import com.beeptunes.agent.Models.Track;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by javad on 12/10/2018 AD.
 */




public interface AgentServices {

    @GET("public/agent/search/album")
    Call<SearchResult.Albums> getLatestAlbums (@Query("size") String size, @Query("page") String page);

    @GET("public/agent/album/info")
    Call<Album> getAlbum (@Query("id") String id);

    @GET("public/agent/track/info")
    Call<Track> getTrack (@Query("id") String id);

    @GET("public/agent/album/tracks")
    Call<List<Track>> getAlbumTracks (@Query("id") String id);

    @GET("public/agent/track/download")
    Call<DownloadLinks> getDownloadLinks (@Query("id") String id);

    @GET("public/agent/artist/info")
    Call<Artist> getArtist (@Query("id") String id);

    @GET("public/agent/artist/albums")
    Call<SearchResult.Albums> getArtistAlbum (@Query("id") String id, @Query("page")
            String page, @Query("size") String size);

    @GET("public/agent/artist/albums")
    Call<SearchResult.Albums> getArtistAlbum ();
}
