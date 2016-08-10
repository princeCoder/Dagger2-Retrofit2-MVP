package vml.prinzly.com.rxretrofitdemo.di;

import dagger.Module;
import dagger.Provides;
import vml.prinzly.com.rxretrofitdemo.home.MainInteractor;
import vml.prinzly.com.rxretrofitdemo.home.MainInteractorImpl;
import vml.prinzly.com.rxretrofitdemo.home.MainPresenter;
import vml.prinzly.com.rxretrofitdemo.home.MainPresenterImpl;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */

@Module
public class MainModule {

    @Provides
    MainPresenterImpl provideMainPresenterImpl(MainInteractor mainInteractor) {
        return new MainPresenterImpl(mainInteractor);
    }

    @Provides
    MainInteractorImpl provideMainInteractorImpl(GithubService service) {
        return new MainInteractorImpl(service);
    }

    @Provides
    MainPresenter provideMainPresenter(MainPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    MainInteractor provideMainInteractor(MainInteractorImpl interactor) {
        return interactor;
    }

}
