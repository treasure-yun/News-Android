package com.example.news.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.news.tool.MyDatabaseHelper;
import com.example.news.R;

public class RegistActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        dbHelper=new MyDatabaseHelper(this,"News.db",null,3);
        Button btn_regist= findViewById(R.id.btn_regist);
        btn_regist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText editText1= findViewById(R.id.username);
                String username=editText1.getText().toString();
                EditText editText2= findViewById(R.id.password);
                String password=editText2.getText().toString();
                RadioGroup radioGroup= findViewById(R.id.radio);
                RadioButton radioButton= findViewById(radioGroup.getCheckedRadioButtonId());
                String sex=radioButton.getText().toString();
                EditText editText3= findViewById(R.id.tel);
                String tel=editText3.getText().toString();
                EditText editText4= findViewById(R.id.birthday);
                String birthday=editText4.getText().toString();
                if(username!=null&&password!=null&&username.length()!=0&&password.length()!=0){
                    SQLiteDatabase db=dbHelper.getWritableDatabase();
                    Cursor cursor = db.rawQuery("select id from users where username=" + "'" + username + "'", null);
                    if (cursor == null || cursor.getCount() <= 0){
                        SQLiteDatabase db1=dbHelper.getWritableDatabase();
                        ContentValues values=new ContentValues();
                        values.put("username",username);
                        values.put("password",password);
                        values.put("sex",sex);
                        values.put("tel",tel);
                        values.put("birthday",birthday);
                        db1.insert("users",null,values);
                        Intent intent=new Intent(RegistActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    else{
                        AlertDialog.Builder dialog=new AlertDialog.Builder(RegistActivity.this);
                        dialog.setTitle("提示");
                        dialog.setMessage("该用户名已存在");
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
                else if(username==null||username.length()==0){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(RegistActivity.this);
                    dialog.setTitle("提示");
                    dialog.setMessage("请输入用户名");
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
                else if(password==null||password.length()==0){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(RegistActivity.this);
                    dialog.setTitle("提示");
                    dialog.setMessage("请输入密码");
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
        });
    }
}
