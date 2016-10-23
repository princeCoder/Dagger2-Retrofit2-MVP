package vml.prinzly.com.rxretrofitdemo;

import javax.inject.Singleton;

import dagger.Component;
import vml.prinzly.com.rxretrofitdemo.data.RepositoryModule;
import vml.prinzly.com.rxretrofitdemo.domain.DomainModule;
import vml.prinzly.com.rxretrofitdemo.ui.home.MainActivity;
import vml.prinzly.com.rxretrofitdemo.ui.PresenterModule;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
@Singleton
@Component(modules = {PresenterModule.class, DomainModule.class, RepositoryModule.class} )
public interface AppComponent {
    void inject(MainActivity activity);
}
