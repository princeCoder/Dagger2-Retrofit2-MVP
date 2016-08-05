package vml.prinzly.com.rxretrofitdemo.home;

/**
 * Created by prinzlyngotoum on 8/5/16.
 */
public interface MainPresenter {

    //Set the reference of the view
    void setView(MainView mainView);

    //Fetch Data
    void fetchData();

    //Clear the RecyclerView
    void  clear();

}
