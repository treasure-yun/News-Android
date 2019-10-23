package com.example.news.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.news.tool.MyDatabaseHelper;
import com.example.news.R;

public class LoginActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView textView= findViewById(R.id.textView);
        String text="注册新用户";
        SpannableString spannableString=new SpannableString(text);
        spannableString.setSpan(new ClickableSpan(){
            public void onClick(View v){
                Intent intent=new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
            }
        },0,text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        Button btn= findViewById(R.id.button);
        dbHelper=new MyDatabaseHelper(this,"News.db",null,3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        EditText editText1 = findViewById(R.id.editText1);
                        EditText editText2 = findViewById(R.id.editText2);
                        String username = editText1.getText().toString();
                        String password = editText2.getText().toString();
                        Cursor cursor = db.rawQuery("select id,password from users where username=" + "'" + username + "'", null);
                        if (cursor == null || cursor.getCount() <= 0){
                       //     Toast.makeText(LoginActivity.this, "用户名错误", Toast.LENGTH_SHORT).show();
                            AlertDialog.Builder dialog=new AlertDialog.Builder(LoginActivity.this);
                            dialog.setTitle("错误提示");
                            dialog.setMessage("用户名输入错误");
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
                        else {
                            while (cursor.moveToNext()) {
                                String pwd = cursor.getString(cursor.getColumnIndex(("password")));
                                int id = cursor.getInt(cursor.getColumnIndex("id"));
                                if (!password.equals(pwd)){
                           //         Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_LONG).show();
                                    AlertDialog.Builder dialog=new AlertDialog.Builder(LoginActivity.this);
                                    dialog.setTitle("错误提示");
                                    dialog.setMessage("密码输入错误");
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
                                if (password.equals(pwd)) {
                                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                    SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                                    editor.putInt("userid",id);
                                    editor.apply();
                                    Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
                                    startActivity(intent);
                                }
                            }
                        }
                }
            }
        });
    }
}