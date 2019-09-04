package com.pa1.prography_5th_android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    private Fragment calls, contacts, chats;
    private MenuItem prevMenuItem;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* findViewById */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.viewpager);
        toolbar = findViewById(R.id.toolbar_main);

        /* Bottom NavigationView 액션 */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_menu1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_menu2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_menu3:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });

        /* ViewPager 연동 액션 */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) { }

            @Override
            public void onPageSelected(int i) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(i).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) { }
        });

        /* ViewPager Initializing */
        calls = new Fragment_studios();
        chats = new Fragment_films();
        contacts = new Fragment_contacts();
        ArrayList<Fragment> fragements = new ArrayList<>();
        fragements.add(calls);
        fragements.add(chats);
        fragements.add(contacts);
        adapter.setFragments(fragements);
        viewPager.setAdapter(adapter);
    }

    /* 커스텀 ViewPagerAdapter 클래스*/
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragments = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void setFragments(ArrayList<Fragment> fragments) {
            this.fragments = fragments;
        }
    }
}
