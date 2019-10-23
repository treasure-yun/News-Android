package com.example.news.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.news.activity.TwoActivity;
import com.example.news.tool.MyDatabaseHelper;
import com.example.news.activity.MyGzActivity;
import com.example.news.bean.MyItem;
import com.example.news.adapter.MyListAdapter;
import com.example.news.activity.NewsActivity;
import com.example.news.R;
import com.example.news.activity.EditActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class MyFragment1 extends Fragment {

    private List<MyItem> myItemList=new ArrayList<>();
    private MyDatabaseHelper dbHelper;
    public static final int REQUEST_CODE = 111;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.my_fragment1,container,false);
        TextView text_username= view.findViewById(R.id.username);
        SharedPreferences pref=getContext().getSharedPreferences("data",MODE_PRIVATE);
        int userid=pref.getInt("userid",0);
        dbHelper=new MyDatabaseHelper(getActivity(),"News.db",null,3);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select username from users where id=" + "'" + userid + "'", null);
        cursor.moveToFirst();
        String username=cursor.getString(cursor.getColumnIndex("username"));
        cursor.close();
        text_username.setText(username);
        initMyItems();
        MyListAdapter adapter=new MyListAdapter(getActivity(),R.layout.my_list_item,myItemList);
        ListView listView= view.findViewById(R.id.my_listView);
        listView.setAdapter(adapter);
        Button loginout= view.findViewById(R.id.loginout_button);
        loginout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=getActivity().getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                Intent intent=new Intent(getActivity(), NewsActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyItem myItem=myItemList.get(position);
                if(myItem.getTitle().equals("扫一扫")){
                    Intent intent = new Intent(getActivity(), TwoActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
                }
                if(myItem.getTitle().equals("编辑资料")){
                    Intent intent=new Intent(getActivity(), EditActivity.class);
                    startActivity(intent);
                }
                if(myItem.getTitle().equals("我的关注")){
                    Intent intent=new Intent(getActivity(), MyGzActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    private void initMyItems(){
        MyItem myItem1=new MyItem("编辑资料");
        myItemList.add(myItem1);
        MyItem myItem2=new MyItem("我的关注");
        myItemList.add(myItem2);
        MyItem myItem3=new MyItem("扫一扫");
        myItemList.add(myItem3);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
