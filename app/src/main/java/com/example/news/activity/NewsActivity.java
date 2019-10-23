package com.example.news.activity;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.news.HomeFragment;
import com.example.news.R;
import com.example.news.fragment.TalkFragment;
import com.example.news.fragment.VideoFragment;
import com.example.news.fragment.MyFragment;
import com.example.news.fragment.MyFragment1;

public class NewsActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);//新闻页面布局
        RadioGroup radioGroup= findViewById(R.id.chat_button);
        radioGroup.check(R.id.chart_home);
        radioGroup.setOnCheckedChangeListener(this);
        replaceFragment(new HomeFragment());
    }

    public void onCheckedChanged(RadioGroup group,int checkedId){
        switch(checkedId){
            case R.id.chart_home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.chart_video:
                replaceFragment(new VideoFragment());
                break;
            case R.id.chart_talk:
                replaceFragment(new TalkFragment());
                break;
            case R.id.chart_my:
                SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
                int userid=pref.getInt("userid",0);
                if(userid==0)
                    replaceFragment(new MyFragment());
                else
                    replaceFragment(new MyFragment1());
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.above_layout,fragment);
        transaction.commit();
    }
}
