package com.example.news.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.news.tool.MyDatabaseHelper;
import com.example.news.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTalkActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private EditText talk_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_talk);
        talk_content= findViewById(R.id.talk_content);
        Button submit= findViewById(R.id.submit);
        dbHelper=new MyDatabaseHelper(AddTalkActivity.this,"News.db",null,3);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
                int userid=pref.getInt("userid",0);
                dbHelper=new MyDatabaseHelper(AddTalkActivity.this,"News.db",null,3);
                SQLiteDatabase db1 = dbHelper.getWritableDatabase();
                Cursor cursor = db1.rawQuery("select username from users where id=" + "'" + userid + "'", null);
                cursor.moveToFirst();
                String username=cursor.getString(cursor.getColumnIndex("username"));
                cursor.close();
                String content=talk_content.getText().toString();
                Log.d("Log",content);
                ContentValues values=new ContentValues();
                values.put("username",username);
                values.put("content",content);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
                Date date = new Date(System.currentTimeMillis());
                values.put("date",simpleDateFormat.format(date));
                db.insert("talk",null,values);
                Intent intent1=new Intent(AddTalkActivity.this, NewsActivity.class);
                startActivity(intent1);
            }
        });
    }
}
