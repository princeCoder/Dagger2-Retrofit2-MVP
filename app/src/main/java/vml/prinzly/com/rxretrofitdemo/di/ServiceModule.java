package vml.prinzly.com.rxretrofitdemo.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;
import vml.prinzly.com.rxretrofitdemo.service.ServiceFactory;

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
    Retrofit provideRetrofitInstance(){
        return ServiceFactory.getAdapter(mEndPoint);
    }


    @Provides @Singleton
    GithubService provideGithubService(Retrofit adapter){
        return ServiceFactory.createRetrofitService(GithubService.class,adapter);
    }


}
