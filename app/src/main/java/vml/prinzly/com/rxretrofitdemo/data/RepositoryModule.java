package vml.prinzly.com.rxretrofitdemo.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vml.prinzly.com.rxretrofitdemo.domain.MainRepository;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;
import vml.prinzly.com.rxretrofitdemo.service.ServiceFactory;

/**
 * Created by prinzlyngotoum on 10/16/16.
 */

@Module
public class RepositoryModule {
    String mEndPoint;

    public RepositoryModule(String endPoint) {
        this.mEndPoint = endPoint;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitInstance() {
        return ServiceFactory.getAdapter(mEndPoint);
    }


    @Provides
    @Singleton
    GithubService provideGithubService(Retrofit adapter) {
        return ServiceFactory.createRetrofitService(GithubService.class, adapter);
    }

    @Provides
    MainRepository provideMainRepository(GithubService githubService) {
        return new MainRepositoryImpl(githubService);
    }
}
