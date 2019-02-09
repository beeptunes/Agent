import Models.*;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    Only 2 public methods. One for initializing The Agent in Application class,
    second one for using the agent's methods
*/

public class Agent {

    private static AgentClient client;
    private static String apiKey = "";
    //--------------------------------
    private static Agent instance = null;

    private Agent(String apiKey){
        client = new AgentClient(apiKey);
    }


    public static void init(String apiKey){
        if(instance == null)
            instance = new Agent(apiKey);
    }


    //Should be called when needed
    private static synchronized Agent getInstance() {
            if(instance == null)
                instance = new Agent(apiKey);
            return instance;
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
        request(client.getAgent().searchArtists(key, size, page), callback);
    }

    public void start(ListenInfo info, AgentCallback<ResponseBody> callback){
        request(client.getAgent().start(info), callback);
    }

    public void finish(ListenInfo info, AgentCallback<ResponseBody> callback){
        request(client.getAgent().finish(info), callback);
    }

    private void request(final Call call, final AgentCallback callback){
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
