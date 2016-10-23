package vml.prinzly.com.rxretrofitdemo;

import vml.prinzly.com.rxretrofitdemo.data.RepositoryModule;
import vml.prinzly.com.rxretrofitdemo.domain.DomainModule;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;
import vml.prinzly.com.rxretrofitdemo.ui.PresenterModule;

/**
 * Created by prinzlyngotoum on 9/20/16.
 */
public final class AppComponentBuilder {
    public static AppComponent build(){
        return  DaggerAppComponent.builder()
                .presenterModule(new PresenterModule())
                .domainModule(new DomainModule())
                .repositoryModule(new RepositoryModule(GithubService.SERVICE_ENDPOINT))
                .build();
    }
}
