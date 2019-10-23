package com.example.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news.R;
import com.example.news.bean.Technology;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

public class TechnologyAdapter extends BaseAdapter {
    private Context context;

    private List<Technology.BA8D4A3RwangningBean> dataList;

    private LayoutInflater inflater;

    private BitmapUtils bitmapUtils;

    public TechnologyAdapter(Context context, List<Technology.BA8D4A3RwangningBean> dataList) {
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
        bitmapUtils = new BitmapUtils(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        Technology.BA8D4A3RwangningBean result = dataList.get(position);
        String imageUrls = result.getImgsrc();
        //根据currentType来加载不同的布局,并复用convertview
        ViewHolderOne viewHolderOne;
        //首先判断convertview==null
        if (convertView == null) {
            viewHolderOne = new ViewHolderOne();
            convertView = inflater.inflate(R.layout.news_item1, null);
            viewHolderOne.imageView = convertView.findViewById(R.id.image);
            viewHolderOne.textView = convertView.findViewById(R.id.title);
            convertView.setTag(viewHolderOne);
        } else {
            viewHolderOne = (ViewHolderOne) convertView.getTag();
        }
        bitmapUtils.display(viewHolderOne.imageView, imageUrls);
        viewHolderOne.textView.setText(result.getTitle());


        return convertView;
    }

    class ViewHolderOne {

        public ImageView imageView;

        public TextView textView;
    }
}