package vml.prinzly.com.rxretrofitdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public class App extends Application {

    private AppComponent component;

    private static App instance;

    public App() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = component();
    }

    public static App of() {
        return (App) getContext();
    }

    public AppComponent component() {
        if (component == null) buildComponent();
        return component;
    }

    //We can call this method anytime we want to rebuild de Dagger dependency graph
    public  AppComponent getAppComponent() {
        if (component == null) buildComponent();
        return component;
    }

    public void buildComponent() {
        component = AppComponentBuilder.build();
    }

}
