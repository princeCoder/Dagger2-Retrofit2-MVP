package vml.prinzly.com.rxretrofitdemo.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vml.prinzly.com.rxretrofitdemo.App;
import vml.prinzly.com.rxretrofitdemo.R;
import vml.prinzly.com.rxretrofitdemo.adapter.CardAdapter;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenterImpl mainPresenter;

    //Adapter
    CardAdapter mCardAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.button_clear)
    Button bClear;

    @BindView(R.id.button_fetch)
    Button bFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        /**
         * Set up Android CardView/RecycleView
         */

        init();
    }

    /**
     * Initialize fields
     */
    private void init() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCardAdapter= new CardAdapter();
        mRecyclerView.setAdapter(mCardAdapter);

        ((App)getApplication()).getAppComponent().inject(this);
        mainPresenter.setView(this);
    }


    @OnClick(R.id.button_fetch)
    public void onFetchClick() {
        mainPresenter.fetchData();
    }


    @OnClick(R.id.button_clear)
    public void onClearClick() {
        mainPresenter.clear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }

    @Override
    public CardAdapter getAdapter() {
        return mCardAdapter;
    }

}
