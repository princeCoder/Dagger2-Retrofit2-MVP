package vml.prinzly.com.rxretrofitdemo.home;

import android.util.Log;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import vml.prinzly.com.rxretrofitdemo.Data;
import vml.prinzly.com.rxretrofitdemo.model.Github;
import vml.prinzly.com.rxretrofitdemo.service.GithubService;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public class MainInteractorImpl implements MainInteractor {

    @Inject
    GithubService githubService;

    @Inject
    public MainInteractorImpl() {
    }

    @Override
    public void fetchData(final OnFetchCompletedListener listener) {
        for(String login : Data.githubList) {

            Observable<Github> service = githubService.getUser(login);

            //Subscriber
            service.subscribeOn(Schedulers.newThread()) // Any subscriber will run on a different thread
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Github>() { // We define the subscriber to this observable Github object
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(getClass().getSimpleName(),e.getMessage());
                        }

                        @Override
                        public void onNext(Github github) {
                            listener.onFetchData(github);
                        }
                    });


        }
    }
}
