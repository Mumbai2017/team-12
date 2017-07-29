package com.cfg.team12.makeawish;

import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class StaffActivity extends AppCompatActivity {
    //Layout views
    private ViewPager viewPager;
    private TabLayout tabLayout;
 

    private Window window;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        setContentView(R.layout.activity_main);

        //custom toolbar
        setSupportActionBar(toolbar);

       /* todayFragment = new TodayFragment();
        weeklyFragment = new WeeklyFragment();
        tomorrowFragment = new TomorrowFragment();
        weather = new Weather();*/
        window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        //links all views
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        //viewPager.setPagingEnabled(false);
        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);


    }

    //add fragments
    private void setViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


       /* viewPagerAdapter.addFragment(todayFragment, "Today");
        viewPagerAdapter.addFragment(tomorrowFragment, "Tomorrow");
        viewPagerAdapter.addFragment(weeklyFragment, "Weekly");*/
        viewPager.setAdapter(viewPagerAdapter);
    }

    //viewpageradapter
    class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}
