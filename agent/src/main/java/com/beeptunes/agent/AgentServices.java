package com.beeptunes.agent;

import com.beeptunes.agent.Models.Album;
import com.beeptunes.agent.Models.Artist;
import com.beeptunes.agent.Models.DownloadLinks;
import com.beeptunes.agent.Models.ListenInfo;
import com.beeptunes.agent.Models.SearchResult;
import com.beeptunes.agent.Models.Track;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/*
   Copyright 2019 https://beeptunes.ca/

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

/**
 * Created by javad on 12/10/2018 AD.
 */

public interface AgentServices {

    @GET("public/agent/search/album")
    Call<SearchResult.Albums> getLatestAlbums (@Query("size") Integer size, @Query("page") Integer page);

    @GET("public/agent/album/info")
    Call<Album> getAlbum (@Query("id") Long id);

    @GET("public/agent/track/info")
    Call<Track> getTrack (@Query("id") Long id);

    @GET("public/agent/album/tracks")
    Call<List<Track>> getAlbumTracks (@Query("id") Long id);

    @GET("public/agent/track/download")
    Call<DownloadLinks> getDownloadLinks (@Query("id") Long id);

    @GET("public/agent/artist/info")
    Call<Artist> getArtist (@Query("id") Long id);

    @GET("public/agent/artist/albums")
    Call<SearchResult.Albums> getArtistAlbums (@Query("id") Long id, @Query("page")
            Integer page, @Query("size") Integer size);

    @GET("public/agent/search?albums=6&tracks=6&artists=6")
    Call<SearchResult> search(@Query("q") String key);

    @GET("public/agent/search/album")
    Call<SearchResult.Albums> searchAlbums (@Query("q") String key,@Query("size") Integer size, @Query("page") Integer page);

    @GET("public/agent/search/track")
    Call<SearchResult.Tracks> searchTracks (@Query("q") String key,@Query("size") Integer size, @Query("page") Integer page);

    @GET("public/agent/search/artist")
    Call<SearchResult.Artists> searchArtists (@Query("q") String key,@Query("size") Integer size, @Query("page") Integer page);

    @POST("/public/agent/listen/start")
    Call<ResponseBody> start(@Body ListenInfo info);

    @POST("/public/agent/listen/finish")
    Call<ResponseBody> finish(@Body ListenInfo info);

}
