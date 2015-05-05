package com.two_two.offshoreview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.two_two.offshoreview.R;
import com.two_two.offshoreview.data.Article;
import com.two_two.offshoreview.volley.AppController;

import java.util.List;

/**
 * Created by marazm on 04.05.15.
 */
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Article> articleList;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<Article> articleList){
        this.activity = activity;
        this.articleList = articleList;
    }
    @Override
    public int getCount() {
        return articleList.size();
    }

    @Override
    public Article getItem(int position) {
        return articleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_menu, null);
        }
        if (imageLoader == null) {
            imageLoader = AppController.getInstance().getImageLoader();
        }
        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.articleImg);
        TextView title = (TextView) convertView.findViewById(R.id.articleTitle);
        TextView date = (TextView) convertView.findViewById(R.id.articleDate);
        Article article = articleList.get(position);
        thumbNail.setImageUrl(article.getThumbnailUrl(), imageLoader);
        title.setText(article.getTitle());
        date.setText(article.getDate());
        return convertView;
    }


}
