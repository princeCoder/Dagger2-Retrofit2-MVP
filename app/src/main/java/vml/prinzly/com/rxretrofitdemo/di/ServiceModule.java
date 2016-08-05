package vml.prinzly.com.rxretrofitdemo.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */

@Module
public class ServiceModule {

    String mEndPoint;

    public ServiceModule(String endPoint){
        this.mEndPoint=endPoint;
    }


    @Provides @Singleton
    GithubService provideGithubService(Retrofit retrofit){
        return retrofit.create(GithubService.class);
    }

    @Provides @Singleton
    Retrofit provideRetrofitInstance(){
        return new Retrofit.Builder().baseUrl(mEndPoint)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //We need to provide an adapter in case we use Observables/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
