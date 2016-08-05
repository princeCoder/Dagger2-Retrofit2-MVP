package vml.prinzly.com.rxretrofitdemo.di;

import javax.inject.Singleton;

import dagger.Component;
import vml.prinzly.com.rxretrofitdemo.home.MainActivity;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
@Singleton
@Component(modules = {AppModule.class, ServiceModule.class, MainModule.class} )
public interface AppComponent {
    void inject(MainActivity activity);
}
