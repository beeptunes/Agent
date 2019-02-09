import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

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

public abstract class AgentCallback<T> implements Callback<T> {

    protected int statusCode = 0;
    Gson gson = new GsonBuilder().create();
    protected Error error;

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void onFailure (Call<T> call, Throwable t) {
        System.out.println(TAG + "onFailure: " + call.request().url().toString());
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        System.out.println(TAG + "onFailure: " + "onResponse: " + response.toString());

        statusCode = response.code();
        if(response.code() >= 400) { //Error
            try {
                assert response.errorBody() != null;
                error = gson.fromJson(response.errorBody().string(), Error.class);
                onFailure(call, new Throwable(response.errorBody().string()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
