package vml.prinzly.com.rxretrofitdemo.domain;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prinzlyngotoum on 10/16/16.
 */

@Module
public class DomainModule {
    @Provides
    @Singleton
    MainInteractor provideMainInteractor(MainRepository mainRepository) {
        return new MainInteractor(mainRepository);
    }
}
