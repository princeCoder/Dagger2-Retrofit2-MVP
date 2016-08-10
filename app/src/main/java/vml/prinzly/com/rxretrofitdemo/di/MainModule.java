package vml.prinzly.com.rxretrofitdemo.di;

import dagger.Module;
import dagger.Provides;
import vml.prinzly.com.rxretrofitdemo.home.MainInteractorImpl;
import vml.prinzly.com.rxretrofitdemo.home.MainPresenterImpl;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */

@Module
public class MainModule {

    @Provides
    MainPresenterImpl provideMainPresenter(MainInteractorImpl mainInteractor) {
        return new MainPresenterImpl(mainInteractor);
    }

    @Provides
    MainInteractorImpl provideMainInteractor(GithubService service) {
        return new MainInteractorImpl(service);
    }

}
