package com.beeptunes.agent;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    public AgentServices getAgent () {
        return agent;
    }
}
