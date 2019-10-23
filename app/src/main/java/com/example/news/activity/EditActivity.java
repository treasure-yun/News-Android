package com.example.news.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.news.tool.MyDatabaseHelper;
import com.example.news.R;

public class EditActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private TextView text_username;
    private RadioGroup radioGroup;
    private TextView text_tel;
    private TextView text_birthday;
    private int userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        dbHelper=new MyDatabaseHelper(this,"News.db",null,3);
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        userid=pref.getInt("userid",0);
        text_username= findViewById(R.id.eusername);
        RadioButton male= findViewById(R.id.male);
        RadioButton female= findViewById(R.id.female);
        text_tel= findViewById(R.id.etel);
        text_birthday= findViewById(R.id.ebirthday);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where id=" + "'" + userid + "'", null);
        if(cursor.moveToFirst()){
            do{
                String username=cursor.getString(cursor.getColumnIndex("username"));
                text_username.setText(username);
                String sex=cursor.getString(cursor.getColumnIndex("sex"));
                if(sex.equals("男"))
                    male.setChecked(true);
                else
                    female.setChecked(true);
                String tel=cursor.getString(cursor.getColumnIndex("tel"));
                text_tel.setText(tel);
                String birthday=cursor.getString(cursor.getColumnIndex("birthday"));
                text_birthday.setText(birthday);
            }while (cursor.moveToNext());
        }
        Button edit= findViewById(R.id.btn_edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db1=dbHelper.getWritableDatabase();
                String username=text_username.getText().toString();
                radioGroup= findViewById(R.id.eradio);
                RadioButton radioButton= findViewById(radioGroup.getCheckedRadioButtonId());
                String sex=radioButton.getText().toString();
                String tel=text_tel.getText().toString();
                String birthday=text_birthday.getText().toString();
                ContentValues values=new ContentValues();
                values.put("username",username);
                values.put("sex",sex);
                values.put("tel",tel);
                values.put("birthday",birthday);
                db1.update("users",values,"id=?",new String[]{String.valueOf(userid)});
                AlertDialog.Builder dialog=new AlertDialog.Builder(EditActivity.this);
                dialog.setTitle("提示");
                dialog.setMessage("修改成功");
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
        cursor.close();
    }
}
