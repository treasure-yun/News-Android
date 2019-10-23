package com.example.news.adapter;

import android.content.Context;
import android.content.DialogInterface;
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
import com.example.news.bean.User;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class UserAdapter extends ArrayAdapter<User> {

    private int resourceId;
    private MyDatabaseHelper dbHelper;
    private User user;

    public UserAdapter(Context context, int textViewResourceId, List<User> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        user=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView text_username= view.findViewById(R.id.user_username);
        dbHelper=new MyDatabaseHelper(getContext(),"News.db",null,3);
        String username="";
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select username from users where id=" + "'" + user.getUserid() + "'", null);
        if(cursor.moveToFirst()){
            do{
                username=cursor.getString(cursor.getColumnIndex("username"));
            }while(cursor.moveToNext());
        }
        cursor.close();
        text_username.setText(username);
        Button qxgz= view.findViewById(R.id.qxgz_button);
        qxgz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db1=dbHelper.getWritableDatabase();
                SharedPreferences pref=getContext().getSharedPreferences("data",MODE_PRIVATE);
                int uid=pref.getInt("userid",0);
                int rid=user.getUserid();
                db1.delete("relation","uid=? and rid=?",new String[]{String.valueOf(uid),String.valueOf(rid)});
                AlertDialog.Builder dialog=new AlertDialog.Builder(getContext());
                dialog.setTitle("提示");
                dialog.setMessage("取消关注成功");
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
        });
        return view;
    }
}
