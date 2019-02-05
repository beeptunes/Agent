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
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;



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

    public static SearchResult search(String s){
        return getInstance().searchAll(s);
    }


    public SearchResult.Albums latestAlbums (String size, String page) {
        return null;
    }

    public Album album (String id) {
        return null;
    }

    public Track track (String id) {
        return null;
    }

    public DownloadLinks downloadLinks (String id) {
        return null;
    }

    public Artist artist (String id) {
        return null;
    }

    public List<Track> albumTrackList (String id) {
        return null;
    }

    public SearchResult.Albums artistAlbums (String id, String page, String size) {
        return null;
    }

    private SearchResult searchAll(String term){
        return null;
    }

    public SearchResult.Albums searchForAlbums(String key, int size, int page){
        return null;
    }

    public SearchResult.Tracks searchForTracks(String key, int size, int page){
        return null;
    }

    public SearchResult.Artists searchForArtists(String key, int size, int page){
        return null;
    }

    public boolean start(ListenInfo info){
        return true;
    }

    public boolean finish(ListenInfo info){
        return true;
    }


}
