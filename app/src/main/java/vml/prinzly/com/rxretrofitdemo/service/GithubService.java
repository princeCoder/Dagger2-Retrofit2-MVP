package vml.prinzly.com.rxretrofitdemo.service;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import vml.prinzly.com.rxretrofitdemo.model.Github;

/**
 * Created by prinzlyngotoum on 8/3/16.
 */
public interface GithubService {
    String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{login}")

    //In case I want to provide this service in a parallel environment
    Observable<Github> getUser(@Path("login") String login);

    //In Case I provide this service in a non-parallel environment
//    Call<Github> getUser(@Path("login") String login);
}






