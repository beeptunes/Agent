/*
 * Copyright 2019 https://beeptunes.ca
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

import Models.*;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class AgentTest {

    CompletableFuture<Boolean> future;

    @BeforeClass
    public static void setUp() throws Exception {
        Agent.init(""); //Api Key here
    }

    @Before
    public void setFuture() throws Exception{
        future = new CompletableFuture<>();
    }
    @Test
    public void init() {
        Agent.start(new ListenInfo(503798065L, "0"), new AgentCallback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                super.onResponse(call, response);
                future.complete(response.code() != 401);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void latestAlbums() {
        Agent.latestAlbums(6, 1, new AgentCallback<SearchResult.Albums>() {
            @Override
            public void onResponse(Call<SearchResult.Albums> call, Response<SearchResult.Albums> response) {
                super.onResponse(call, response);
                SearchResult.Albums albums = response.body();
                future.complete(albums.getData().size() > 0);
            }

            @Override
            public void onFailure(Call<SearchResult.Albums> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void album() {
        Album mock = new Album("522983943"
                , "شهر دیوونه"
                , "https://storage.backtory.com/beeptunes/album/cover/506c9893-3be1-4ada-bbc2-41a3b45af123.jpg");
        Agent.album( 522983943L, new AgentCallback<Album>() {
            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                super.onResponse(call, response);
                if(response.body().equals(mock))
                    future.complete(true);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void track() {
        Track mock = new Track("517431296", "تصنیف قلاب");
        Agent.track(517431296L, new AgentCallback<Track>() {
            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                super.onResponse(call, response);
                Track actual = response.body();
                if(actual.equals(mock))
                    future.complete(true);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void downloadLinks() {
        DownloadLinks mock = new DownloadLinks();
        mock.setL64("https://box.backtory.com/beeptunes/690/01633/001/L_64/2_1uo8OU3Pik.mp3?sig=IpAKu-RfkL7n1UHt2vkSyg&exp=1549822929&filename=02-Homayoun_Shajarian_Sohrab_Pournazeri_Tasnife_Gholab.mp3"
                ,3787498
                ,"0f26521f");
        mock.setL128("https://box.backtory.com/beeptunes/690/01633/001/L_128/2_20wDVLfpvC.mp3?sig=jJcervxI9C0U73y-Jot82A&exp=1549822929&filename=02-Homayoun_Shajarian_Sohrab_Pournazeri_Tasnife_Gholab.mp3"
                ,7405612
                ,"1534a543");
        mock.setH320("https://box.backtory.com/beeptunes/690/01633/001/H/2_OcANBmjpzV.mp3?sig=Cj6QLhTf7992xzegyn48Lg&exp=1549822929&filename=02-Homayoun_Shajarian_Sohrab_Pournazeri_Tasnife_Gholab.mp3"
                ,18260430
                ,"b5ff062a");

        Agent.downloadLinks(517431296L, new AgentCallback<DownloadLinks>() {
            @Override
            public void onFailure(Call<DownloadLinks> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<DownloadLinks> call, Response<DownloadLinks> response) {
                super.onResponse(call, response);
                future.complete(response.body().equals(mock));
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void artist() {
        Artist mock = new Artist("3403927", "همایون شجریان");
        Agent.artist(3403927L, new AgentCallback<Artist>() {
            @Override
            public void onFailure(Call<Artist> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<Artist> call, Response<Artist> response) {
                super.onResponse(call, response);
                future.complete(response.body().equals(mock));
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void albumTrackList() {
        Agent.albumTrackList(522983943L, new AgentCallback<List<Track>>() {
            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                super.onResponse(call, response);
                future.complete(response.body().size() > 0);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void artistAlbums() {
        Agent.artistAlbums(3403927L, 1, 6, new AgentCallback<SearchResult.Albums>() {
            @Override
            public void onFailure(Call<SearchResult.Albums> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<SearchResult.Albums> call, Response<SearchResult.Albums> response) {
                super.onResponse(call, response);
                future.complete(response.body().getData().size() > 0);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchAll() {
        Agent.searchAll("چاوشی", new AgentCallback<SearchResult>() {
            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                super.onResponse(call, response);
                SearchResult result = response.body();
                future.complete(
                        result.getAlbums().getData().size() > 0
                        && result.getArtists().getData().size() > 0
                        && result.getTracks().getData().size() > 0
                );
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchForAlbums() {
        Agent.searchForAlbums("چاوشی", 1, 12, new AgentCallback<SearchResult.Albums>() {
            @Override
            public void onFailure(Call<SearchResult.Albums> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<SearchResult.Albums> call, Response<SearchResult.Albums> response) {
                super.onResponse(call, response);
                future.complete(response.body().getData().size() > 0);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchForTracks() {
        Agent.searchForTracks("چاوشی", 1, 12, new AgentCallback<SearchResult.Tracks>() {
            @Override
            public void onFailure(Call<SearchResult.Tracks> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<SearchResult.Tracks> call, Response<SearchResult.Tracks> response) {
                super.onResponse(call, response);
                future.complete(response.body().getData().size() > 0);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void searchForArtists() {
        Agent.searchForArtists("چاوشی", 1, 12, new AgentCallback<SearchResult.Artists>() {
            @Override
            public void onFailure(Call<SearchResult.Artists> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }

            @Override
            public void onResponse(Call<SearchResult.Artists> call, Response<SearchResult.Artists> response) {
                super.onResponse(call, response);
                future.complete(response.body().getData().size() > 0);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void start() {
        Agent.start(new ListenInfo(503798065L, "0"), new AgentCallback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                super.onResponse(call, response);
                future.complete(response.code() != 401);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void finish() {
        Agent.finish(new ListenInfo(503798065L, "123"), new AgentCallback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                super.onResponse(call, response);
                future.complete(response.code() != 401);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                super.onFailure(call, t);
                future.complete(false);
            }
        });

        try {
            assertTrue(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}