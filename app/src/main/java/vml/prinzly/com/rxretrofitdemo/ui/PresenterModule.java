package vml.prinzly.com.rxretrofitdemo.ui;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vml.prinzly.com.rxretrofitdemo.domain.MainInteractor;
import vml.prinzly.com.rxretrofitdemo.ui.home.MainPresenter;

/**
 * Created by prinzlyngotoum on 10/16/16.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    MainPresenter provideMainPresenter(MainInteractor mainInteractor) {
        return new MainPresenter(mainInteractor);
    }

}
