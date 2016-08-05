package vml.prinzly.com.rxretrofitdemo;

import android.app.Application;

import vml.prinzly.com.rxretrofitdemo.di.AppComponent;
import vml.prinzly.com.rxretrofitdemo.di.AppModule;
import vml.prinzly.com.rxretrofitdemo.di.DaggerAppComponent;
import vml.prinzly.com.rxretrofitdemo.di.MainModule;
import vml.prinzly.com.rxretrofitdemo.di.ServiceModule;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .serviceModule(new ServiceModule(GithubService.SERVICE_ENDPOINT))
                .mainModule(new MainModule())
                .build();
    }


    public  AppComponent getAppComponent() {
        return appComponent;
    }

}
