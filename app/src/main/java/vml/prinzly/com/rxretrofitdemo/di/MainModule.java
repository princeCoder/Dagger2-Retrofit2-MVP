package vml.prinzly.com.rxretrofitdemo.di;

import dagger.Module;
import dagger.Provides;
import vml.prinzly.com.rxretrofitdemo.home.MainInteractor;
import vml.prinzly.com.rxretrofitdemo.home.MainInteractorImpl;
import vml.prinzly.com.rxretrofitdemo.home.MainPresenter;
import vml.prinzly.com.rxretrofitdemo.home.MainPresenterImpl;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */

@Module
public class MainModule {
    /*
    MainInteractorImpl and MainPresenterImpl are dependencies of those two methods but there is no
    provider for those classes, so I will have to inject their constructors.

     */

    @Provides
    MainInteractor provideMainInteractor(MainInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    MainPresenter provideMainPresenter(MainPresenterImpl presenter) {
        return presenter;
    }
}
