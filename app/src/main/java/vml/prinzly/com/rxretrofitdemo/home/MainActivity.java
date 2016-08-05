package vml.prinzly.com.rxretrofitdemo.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import vml.prinzly.com.rxretrofitdemo.App;
import vml.prinzly.com.rxretrofitdemo.R;
import vml.prinzly.com.rxretrofitdemo.adapter.CardAdapter;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    //Adapter
    CardAdapter mCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Set up Android CardView/RecycleView
         */
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCardAdapter= new CardAdapter();
        mRecyclerView.setAdapter(mCardAdapter);

        ((App)getApplication()).getAppComponent().inject(this);
        mainPresenter.setView(this);

        /**
         * START: button set up
         */
        Button bClear = (Button) findViewById(R.id.button_clear);
        Button bFetch = (Button) findViewById(R.id.button_fetch);
        bClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainPresenter.clear();
            }
        });

        bFetch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // @Todo - Call the presenter to do the job
                mainPresenter.fetchData();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Avoid the memory leak
        mainPresenter.setView(null);
    }

    @Override
    public CardAdapter getAdapter() {
        return mCardAdapter;
    }

}
