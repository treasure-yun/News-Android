package com.example.news.adapter;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.bean.Video;
import java.util.List;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoAdapter extends BaseAdapter {
    private Context context;

    private List<Video.VideoRecomBean> dataList;

    private LayoutInflater inflater;

    private MediaPlayer mediaPlayer;

    public VideoAdapter(Context context, List<Video.VideoRecomBean> dataList) {
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
        mediaPlayer = new MediaPlayer();
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

        Video.VideoRecomBean result = dataList.get(position);
        String videoUrls = result.getMp4_url();
        //根据currentType来加载不同的布局,并复用convertview
        ViewHolderOne viewHolderOne;
        //首先判断convertview==null
        if (convertView == null) {
            viewHolderOne = new ViewHolderOne();
            convertView = inflater.inflate(R.layout.video_item, null);
            viewHolderOne.videoView = convertView.findViewById(R.id.video);
            viewHolderOne.videosource = convertView.findViewById(R.id.videosource);
            viewHolderOne.topicName = convertView.findViewById(R.id.topicName);
            convertView.setTag(viewHolderOne);
        } else {
            viewHolderOne = (ViewHolderOne) convertView.getTag();
        }
        viewHolderOne.videoView.setUp(videoUrls, JCVideoPlayer.SCREEN_LAYOUT_NORMAL,result.getTitle());
        ImageView thumbImageView = viewHolderOne.videoView.thumbImageView;
        //使用Glide添加
        Glide.with(context).load(result.getCover()).into(thumbImageView );
        viewHolderOne.videosource.setText(result.getVideosource());
        viewHolderOne.topicName.setText(result.getTopicName());
        return convertView;
    }

    class ViewHolderOne {
        public JCVideoPlayerStandard videoView;
        public TextView videosource;
        public TextView topicName;
    }
}