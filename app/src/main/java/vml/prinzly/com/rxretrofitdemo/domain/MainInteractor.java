package vml.prinzly.com.rxretrofitdemo.domain;

import java.util.List;

import rx.Observable;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public class MainInteractor {

    MainRepository mainRepository;

    public MainInteractor(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public Observable<List<Github>> getUsers(){
       return mainRepository.getUsers();
    }
}
