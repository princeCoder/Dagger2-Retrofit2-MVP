package vml.prinzly.com.rxretrofitdemo.adapter;

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
import vml.prinzly.com.rxretrofitdemo.model.Github;

/**
 * Created by prinzlyngotoum on 8/3/16.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<Github> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<Github>();
    }

    public void addData(Github github) {
        mItems.add(github);
        notifyDataSetChanged();
    }

    public void setItems(ArrayList<Github> list){
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
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Github github = mItems.get(i);
        viewHolder.login.setText(github.getLogin());
        viewHolder.repos.setText("repos: " + github.getPublicRepos());
        viewHolder.blog.setText("blog: " + github.getBlog());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.login) TextView login;
        @BindView(R.id.repos) TextView repos;
        @BindView(R.id.blog) TextView blog;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}