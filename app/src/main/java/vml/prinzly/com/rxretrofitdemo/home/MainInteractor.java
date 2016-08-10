package vml.prinzly.com.rxretrofitdemo.home;

import rx.Subscription;
import vml.prinzly.com.rxretrofitdemo.model.Github;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public interface MainInteractor {
    void fetchData(OnFetchCompletedListener listener);

    //Handle the returned value
    interface OnFetchCompletedListener {
        void onFetchData(Github github );
        void setSubscription(Subscription subscription);

    }
}
