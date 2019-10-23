package com.example.news.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.news.tool.MyDatabaseHelper;
import com.example.news.R;
import com.example.news.bean.Talk;
import com.example.news.activity.LoginActivity;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class TalkAdapter extends ArrayAdapter<Talk> {

    private int resourceId;
    private MyDatabaseHelper dbHelper;

    public TalkAdapter(Context context, int textViewResourceId, List<Talk> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Talk talk=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView username= view.findViewById(R.id.username_text);
        TextView content= view.findViewById(R.id.content);
        TextView date= view.findViewById(R.id.date);
        Button gz= view.findViewById(R.id.gz_button);
        username.setText(talk.getUsername());
        content.setText(talk.getContent());
        date.setText(talk.getDate());
        dbHelper=new MyDatabaseHelper(getContext(),"News.db",null,3);
        gz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                SQLiteDatabase db1=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                SharedPreferences pref=getContext().getSharedPreferences("data",MODE_PRIVATE);
                int uid=pref.getInt("userid",0);
                if(uid==0) {
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    getContext().startActivity(intent);
                }else{
                    values.put("uid",uid);
                    int rid=0;
                    Cursor cursor = db.rawQuery("select id from users where username=" + "'" + getItem(position).getUsername() + "'", null);
                    if(cursor.moveToFirst()){
                        do{
                            rid=cursor.getInt(cursor.getColumnIndex("id"));
                        }while(cursor.moveToNext());
                    }
                    cursor.close();
                    values.put("rid",rid);
                    if(uid!=rid){
                        db1.insert("relation",null,values);
                        AlertDialog.Builder dialog=new AlertDialog.Builder(getContext());
                        dialog.setTitle("提示");
                        dialog.setMessage("关注成功");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.show();
                    }
                    else{
                        AlertDialog.Builder dialog=new AlertDialog.Builder(getContext());
                        dialog.setTitle("错误提示");
                        dialog.setMessage("不能关注自己");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.show();
                    }
                }
            }
        });
        return view;
    }
}
