package com.example.news.tool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USERS="create table users("+"id integer primary key autoincrement,"
            +"username text unique,"+"password text,"+"sex text,"+"tel text,"+"birthday text)";
    public static final String CREATE_RELATION="create table relation("+"uid integer not null,"
            +"rid integer not null,foreign key(uid) references users(id),foreign key(rid) references users(id))";
    public static final String CREATE_TALK="create table talk("+"id integer primary key autoincrement,"
            +"username text not null,"+"content text,"+"date text,foreign key(username) references users(username))";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context,name,factory,version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERS);
        db.execSQL(CREATE_RELATION);
        db.execSQL(CREATE_TALK);
        Toast.makeText(mContext,"Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists relation");
        db.execSQL("drop table if exists talk");
        onCreate(db);
    }
}
