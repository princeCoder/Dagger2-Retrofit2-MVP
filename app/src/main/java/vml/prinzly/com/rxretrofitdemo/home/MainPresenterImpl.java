package vml.prinzly.com.rxretrofitdemo.home;

import javax.inject.Inject;

import vml.prinzly.com.rxretrofitdemo.model.Github;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public class MainPresenterImpl implements MainPresenter, MainInteractor.OnFetchCompletedListener{

    private MainView mainView;


    private MainInteractor mainInteractor;

    @Inject
    public MainPresenterImpl(MainInteractor mainInteractor) {
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void setView(MainView mainView) {
        this.mainView=mainView;
    }

    @Override
    public void fetchData() {
        //I will call the interactor here
        mainInteractor.fetchData(this);
    }

    @Override
    public void clear() {
        //We clear the recycler view
        mainView.getAdapter().clear();
    }

    @Override
    public void onFetchData(Github github) {
        //We populate the recycler View
        mainView.getAdapter().addData(github);
    }

}
