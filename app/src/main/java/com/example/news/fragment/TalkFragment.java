package com.example.news.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.news.R;
import com.example.news.activity.AddTalkActivity;
import com.example.news.activity.LoginActivity;
import com.example.news.adapter.TalkAdapter;
import com.example.news.bean.Talk;
import com.example.news.tool.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class TalkFragment extends Fragment {
    private MyDatabaseHelper dbHelper;
    private List<Talk> talkList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.talk_fragment,container,false);
        FloatingActionButton add= view.findViewById(R.id.add_button);
        dbHelper=new MyDatabaseHelper(getActivity(),"News.db",null,3);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getActivity().getSharedPreferences("data",MODE_PRIVATE);
                int uid=pref.getInt("userid",0);
                if(uid==0){
                    Intent intent1=new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent1);
                }else {
                    Intent intent1 = new Intent(getActivity(), AddTalkActivity.class);
                    startActivity(intent1);
                }
            }
        });
        initTalks();
        TalkAdapter adapter=new TalkAdapter(getActivity(),R.layout.talk_item,talkList);
        ListView listView= view.findViewById(R.id.talk_listView);
        listView.setAdapter(adapter);
        return view;
    }

    private void initTalks(){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from talk order by date desc",null);
        if(cursor.moveToFirst()){
            do{
                String username=cursor.getString(cursor.getColumnIndex("username"));
                String content=cursor.getString(cursor.getColumnIndex("content"));
                String date=cursor.getString(cursor.getColumnIndex("date"));
                Talk talk=new Talk(username,content,date);
                talkList.add(talk);
            }while(cursor.moveToNext());
        }
        cursor.close();
    }
}