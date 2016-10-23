package vml.prinzly.com.rxretrofitdemo.data;

import java.util.List;

import rx.Observable;
import vml.prinzly.com.rxretrofitdemo.Data;
import vml.prinzly.com.rxretrofitdemo.domain.MainRepository;
import vml.prinzly.com.rxretrofitdemo.domain.Github;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public class MainRepositoryImpl implements MainRepository {

    //My Github service
    GithubService githubService;

    public MainRepositoryImpl(GithubService service) {
        this.githubService=service;
    }

    @Override
    public Observable<List<Github>> getUsers() {
           return Observable.from(Data.githubList)
                   .flatMap(githubService::getUser)
                   .toList();
    }
}
