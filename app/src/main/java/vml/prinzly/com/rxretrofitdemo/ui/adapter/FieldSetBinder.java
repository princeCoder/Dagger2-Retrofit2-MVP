package vml.prinzly.com.rxretrofitdemo.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by prinzlyngotoum on 8/25/16.
 */
public abstract class FieldSetBinder <T> {

    public abstract void setField(T t);

    protected void setText(TextView textView, String text) {
        if (textView != null) {
            textView.setText(text);
        }
    }

    protected void setTextOrHide(TextView textView, String text) {
        if (text == null || text.isEmpty()) {
            textView.setVisibility(View.GONE);
        } else {
            setText(textView, text);
        }
    }

    protected void setImage(ImageView imageView, String uri) {
        if (imageView != null) {
            Picasso.with(imageView.getContext()).load(uri).into(imageView);
        }
    }
}
