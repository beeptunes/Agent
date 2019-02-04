package com.beeptunes.agent;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class AgentClient {

    private static final String URL = "http://newapi.beeptunes.com";
    private String token;
    private HttpLoggingInterceptor logger;
    private OkHttpClient client;
    private Retrofit retrofit;
    private AgentServices agent;

    AgentClient (String token) {
        this.token = token;
        this.logger = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        this.client = new OkHttpClient.Builder()
                .addNetworkInterceptor(logger)
                .addInterceptor(chain -> {
                    Request request = chain
                            .request()
                            .newBuilder()
                            .addHeader("X-BT-AGENT-SECRET", token)
                            .addHeader("Accept", "Application/JSON")
                            .build();
                    return chain.proceed(request);
                })
                .build();
        this.retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        agent = retrofit.create(AgentServices.class);
    }

}
