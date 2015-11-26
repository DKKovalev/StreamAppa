package com.moodappinc.streamappa.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.SearchView;

import com.moodappinc.streamappa.Fragments.HitboxTab;
import com.moodappinc.streamappa.Fragments.TwitchTab;
import com.moodappinc.streamappa.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_1 extends AppCompatActivity {

    private Toolbar toolbar;
    private SearchView searchView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchView = (SearchView)findViewById(R.id.searchview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        /*fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById();
        if (fragment == null) {
            fragment = new Fragment();
            fragmentManager.beginTransaction()
                    .add()
                    .commit();
        }*/
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new TwitchTab(), "Twitch");
        adapter.addFragments(new HitboxTab(), "Hitbox");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> titles = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragments(Fragment fragment, String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
