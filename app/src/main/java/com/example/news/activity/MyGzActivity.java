package com.example.news.activity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.news.tool.MyDatabaseHelper;
import com.example.news.R;
import com.example.news.bean.User;
import com.example.news.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyGzActivity extends AppCompatActivity {

    private List<User> data=new ArrayList<>();
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gz);
        dbHelper=new MyDatabaseHelper(this,"News.db",null,3);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        int uid=pref.getInt("userid",0);
        Cursor cursor = db.rawQuery("select rid from relation where uid=" + "'" + uid + "'", null);
        if(cursor.moveToFirst()){
            do{
                int rid=cursor.getInt(cursor.getColumnIndex("rid"));
                User user=new User(rid);
                data.add(user);
            }while(cursor.moveToNext());
        }
        cursor.close();
        UserAdapter adapter=new UserAdapter(MyGzActivity.this,R.layout.user_item,data);
        ListView listView= findViewById(R.id.my_gz_listView);
        listView.setAdapter(adapter);
    }
}
