package com.beeptunes.agent;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.beeptunes.agent.Models.Album;
import com.beeptunes.agent.Models.Artist;
import com.beeptunes.agent.Models.DownloadLinks;
import com.beeptunes.agent.Models.ListenInfo;
import com.beeptunes.agent.Models.SearchResult;
import com.beeptunes.agent.Models.Track;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
    Only 2 public methods. One for initializing The Agent in Application class,
    second one for using the agent's methods
*/

public class Agent {

    private static Context context;
    private static AgentClient client;
    private static String token = "";
    //--------------------------------
    private static Agent instance = null;

    private Agent (Context ctx) {
        context = ctx;
        try {
            ApplicationInfo info = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = info.metaData;
            token = bundle.getString("com.beeptunes.agent.btToken");

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e("Beeptunes", "Beeptunes agent token not set in Manifest");
        }

        client = new AgentClient(token);
    }

    // Should be called in App class, otherwise using get()
    // method will throw NPE
    public static void init(Context ctx){
        instance = new Agent(ctx);
    }

    //Should be called when needed
    private static synchronized Agent getInstance() {
        try{
            if(instance == null)
                instance = new Agent(context);
            return instance;
        }
        catch (NullPointerException e){
            throw e;
        }

    }

    public static Agent get(){
        return getInstance();
    }

    public static void search(String s , AgentCallback<SearchResult> callback){
        getInstance().searchAll(s, callback);
    }


    public void latestAlbums (Integer size, Integer page, AgentCallback<SearchResult.Albums> callback) {
        request(client.getAgent().getLatestAlbums(size, page), callback);
    }

    public void album (Long id, AgentCallback<Album> callback) {
        request(client.getAgent().getAlbum(id), callback);
    }

    public void track (Long id, AgentCallback<Track> callback) {
        request(client.getAgent().getTrack(id), callback);
    }

    public void downloadLinks (Long id, AgentCallback<DownloadLinks> callback) {
        request(client.getAgent().getDownloadLinks(id), callback);
    }

    public void artist (Long id, AgentCallback<Artist> callback) {
        request(client.getAgent().getArtist(id), callback);
    }

    public void albumTrackList (Long id, AgentCallback<List<Track>> callback) {
        request(client.getAgent().getAlbumTracks(id), callback);
    }

    public void artistAlbums (Long id, Integer page, Integer size, AgentCallback<SearchResult.Albums> callback) {
        request(client.getAgent().getArtistAlbums(id, page, size), callback);
    }

    private void searchAll(String term, AgentCallback<SearchResult> callback){
        request(client.getAgent().search(term), callback);
    }

    public void searchForAlbums(String key, Integer page, Integer size, AgentCallback<SearchResult.Albums> callback){
        request(client.getAgent().searchAlbums(key, size, page), callback);
    }

    public void searchForTracks(String key, Integer size, Integer page, AgentCallback<SearchResult.Tracks> callback){
        request(client.getAgent().searchTracks(key, size, page), callback);
    }

    public void searchForArtists(String key, Integer size, Integer page, AgentCallback<SearchResult.Artists> callback){
        request(client.getAgent().searchAlbums(key, size, page), callback);
    }

    public void start(ListenInfo info, AgentCallback<ResponseBody> callback){
        request(client.getAgent().start(info), callback);
    }

    public void finish(ListenInfo info, AgentCallback<ResponseBody> callback){
        request(client.getAgent().finish(info), callback);
    }

    private void request(Call call, AgentCallback callback){
        call.enqueue(new Callback() {
            @Override
            public void onResponse (Call call, Response response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure (Call call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

}
