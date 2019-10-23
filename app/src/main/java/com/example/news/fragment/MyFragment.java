package com.example.news.fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.news.activity.TwoActivity;
import com.example.news.bean.MyItem;
import com.example.news.adapter.MyListAdapter;
import com.example.news.R;
import com.example.news.activity.LoginActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {

    private List<MyItem> myItemList=new ArrayList<>();
    public static final int REQUEST_CODE = 111;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.my_fragment,container,false);
        initMyItems();
        MyListAdapter adapter=new MyListAdapter(getActivity(),R.layout.my_list_item,myItemList);
        ListView listView= view.findViewById(R.id.my_listView);
        listView.setAdapter(adapter);
        Button login_button= view.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
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
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
                if(myItem.getTitle().equals("我的关注")){
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    private void initMyItems(){
        MyItem myItem=new MyItem("编辑资料");
        myItemList.add(myItem);
        MyItem myItem1=new MyItem("我的关注");
        myItemList.add(myItem1);
        MyItem myItem2=new MyItem("扫一扫");
        myItemList.add(myItem2);
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