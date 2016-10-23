package vml.prinzly.com.rxretrofitdemo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vml.prinzly.com.rxretrofitdemo.R;
import vml.prinzly.com.rxretrofitdemo.domain.Github;

/**
 * Created by prinzlyngotoum on 8/3/16.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.GithubHolder> {

    List<Github> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<Github>();
    }

    public void addData(Github github) {
        mItems.add(github);
        notifyDataSetChanged();
    }

    public void setItems(List<Github> list){
        mItems=list;
        notifyDataSetChanged();
    }

    public List<Github> getItems() {
        return mItems;
    }


    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public GithubHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        GithubHolder viewHolder = new GithubHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GithubHolder holders, int position) {
        Github github = mItems.get(position);
        GithubHolder holder=(GithubHolder)holders;
        holder.setFields(github);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class GithubHolder extends RecyclerView.ViewHolder {

        private final GithubFieldBinder githubFieldBinder;

        @BindView(R.id.login) TextView login;
        @BindView(R.id.repos) TextView repos;
        @BindView(R.id.blog) TextView blog;

        public GithubHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            githubFieldBinder=new GithubFieldBinder(this);
        }

        public void setFields(Github github){
            githubFieldBinder.setField(github);
        }
    }

}