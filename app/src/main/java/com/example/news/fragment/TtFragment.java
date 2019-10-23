package com.example.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.news.R;
import com.example.news.adapter.TtAdapter;
import com.example.news.activity.NewsDetailActivity;
import com.example.news.bean.Toutiao;
import com.google.gson.Gson;

import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TtFragment extends Fragment {

    private ListView listView;
    private Handler handler;
    private Toutiao toutiao;
    private TtAdapter adapter;
    private List<Toutiao.T1348647853363Bean> resultList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tab_fragment,container,false);
        listView= view.findViewById(R.id.list_view);
        handler=new Handler();
        initNews();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                if(position>0) {
                                                    Toutiao.T1348647853363Bean bean = resultList.get(position);
                                                    String url = bean.getUrl();
                                                    Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                                                    intent.putExtra("url", url);
                                                    Log.d("TtFragment", url);
                                                    startActivity(intent);
                                                }
                                            }
                                        }
        );
        return view;
    }
    private void initNews(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("http://c.m.163.com/nc/article/headline/T1348647853363/0-20.html").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    Gson gson=new Gson();
                    toutiao=gson.fromJson(responseData, Toutiao.class);
                    Runnable   runnableUi=new  Runnable(){
                        @Override
                        public void run() {
                            //更新界面
                            List<Toutiao.T1348647853363Bean> list=toutiao.getT1348647853363();
                            resultList=list;
                            Log.d("HomeFragment",resultList.toString());
                            if (resultList != null) {
                                adapter = new TtAdapter(getActivity(), resultList);
                                if (adapter != null) {
                                    listView.setAdapter(adapter);
                                }
                            }
                        }
                    };
                    handler.post(runnableUi);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}