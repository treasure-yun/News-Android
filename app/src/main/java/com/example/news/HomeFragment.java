package com.example.news;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.news.adapter.MyFragmentPagerAdapter;
import com.example.news.fragment.ENTFragment;
import com.example.news.fragment.EducationFragment;
import com.example.news.fragment.FashionFragment;
import com.example.news.fragment.GameFragment;
import com.example.news.fragment.JSFragment;
import com.example.news.fragment.PhoneFragment;
import com.example.news.fragment.SPFragment;
import com.example.news.fragment.TechnologyFragment;
import com.example.news.fragment.TtFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> tab_title_list = new ArrayList<>();//存放标签页标题
    private ArrayList<Fragment> fragment_list = new ArrayList<>();//存放ViewPager下的Fragment
    private Fragment[] fragment;
    private MyFragmentPagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home_fragment,container,false);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.vp);
        tab_title_list.add("头条");
        tab_title_list.add("娱乐");
        tab_title_list.add("科技");
        tab_title_list.add("军事");
        tab_title_list.add("运动");
        tab_title_list.add("时尚");
        tab_title_list.add("手机");
        tab_title_list.add("教育");
        tab_title_list.add("游戏");
        for(int i=0;i<tab_title_list.size();i++)
            tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(i)));
        fragment=new Fragment[tab_title_list.size()];
        fragment[0] = new TtFragment();
        fragment[1] = new ENTFragment();
        fragment[2] = new TechnologyFragment();
        fragment[3] = new JSFragment();
        fragment[4] = new SPFragment();
        fragment[5] = new FashionFragment();
        fragment[6] = new PhoneFragment();
        fragment[7] = new EducationFragment();
        fragment[8] = new GameFragment();
        for(int i=0;i<fragment.length;i++)
            fragment_list.add(fragment[i]);
        adapter = new MyFragmentPagerAdapter(getChildFragmentManager(), tab_title_list, fragment_list);
        viewPager.setAdapter(adapter);//给ViewPager设置适配器
        tabLayout.setupWithViewPager(viewPager);//将TabLayout与Viewpager联动起来
        return view;
    }
}