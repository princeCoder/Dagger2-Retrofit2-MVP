package vml.prinzly.com.rxretrofitdemo.ui.home;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import vml.prinzly.com.rxretrofitdemo.domain.Github;
import vml.prinzly.com.rxretrofitdemo.domain.MainInteractor;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public class MainPresenter {

    private MainView mainView;

    private MainInteractor mainInteractor;

    private CompositeSubscription subscription;


    public MainPresenter(MainInteractor mainInteractor) {
        this.mainInteractor = mainInteractor;
        this.subscription=new CompositeSubscription();
    }

    public void setView(MainView mainView) {
        this.mainView=mainView;
    }

    public void fetchData() {
            subscription.add(getMainInteractor().getUsers()
                    .compose(this.applySchedulers())
                    .subscribe(this::onFetchData,Throwable::printStackTrace));
    }

    public void clear() {
        //We clear the recycler view
        mainView.getAdapter().clear();
    }

    public void onDestroy() {
        //Avoid the memory leak
        subscription.unsubscribe();
        setView(null);
    }

    public MainInteractor getMainInteractor() {
        return mainInteractor;
    }

    public void onFetchData(List<Github> githubList) {
        //We populate the recycler View
        mainView.getAdapter().setItems(githubList);
    }

    protected <T> Observable.Transformer<T, T> applySchedulers() {
        return o -> o
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
