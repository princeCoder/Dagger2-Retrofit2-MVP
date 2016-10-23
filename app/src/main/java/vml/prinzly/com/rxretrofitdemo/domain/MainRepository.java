package vml.prinzly.com.rxretrofitdemo.domain;

import java.util.List;

import rx.Observable;

/**
 * Created by prinzlyngotoum on 10/16/16.
 */

public interface MainRepository {

    Observable<List<Github>> getUsers();
}
