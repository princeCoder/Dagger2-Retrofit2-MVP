package vml.prinzly.com.rxretrofitdemo.ui.adapter;

import vml.prinzly.com.rxretrofitdemo.domain.Github;

/**
 * Created by prinzlyngotoum on 8/25/16.
 */
public class GithubFieldBinder extends FieldSetBinder<Github> {

    CardAdapter.GithubHolder holder;

    public GithubFieldBinder(CardAdapter.GithubHolder holder) {
        this.holder = holder;
    }

    @Override
    public void setField(Github github) {
        setText(holder.login,github.getLogin());
        setText(holder.repos,"repos: " +github.getPublicRepos());
        setText(holder.blog,"blog: " +github.getBlog());
    }

}
