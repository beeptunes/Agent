# Agent
An interface to benefit Persian Music

[![](https://jitpack.io/v/beeptunes/Agent.svg)](https://jitpack.io/#beeptunes/Agent)

### Gain Access to API Key 
To obtain your API key, [contact us](mailto://info@beeptunes.com) and after agreeing on a contract, we'll give you access to the archive.


### Installation

#### 1. Add Jitpack to your repositories (project-level `build.gradle`)
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
#### 2. Add Agent as a dependency (app-level `build.gradle`)
```
dependencies {
	        implementation 'com.github.beeptunes:Agent:1.0.0'
	}
```
#### 3. Initialize Agent inside your Application class extension
```
class App extends Application {
  @Override
    public void onCreate() {
        super.onCreate();
        Agent.init(this, YOUR_API_KEY);
        }
}
```

### Usage

You can make asynchronous calls by calling the Agent methods and giving it your desired callback.

### Example:
For getting data for a track:

```
Agent.get().track((long) 503798065, new AgentCallback<Track>() {
            @Override
            public void onFailure (Call<Track> call, Throwable t) {
                super.onFailure(call, t);
            }

            @Override
            public void onResponse (Call<Track> call, Response<Track> response) {
                super.onResponse(call, response);
                Log.d(TAG, response.body().image);
            }
        });
```
