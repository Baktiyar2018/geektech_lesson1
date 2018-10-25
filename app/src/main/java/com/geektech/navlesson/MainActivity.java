package com.geektech.navlesson;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.geektech.navlesson.study.fragments.CalculatorFragment;
import com.geektech.navlesson.study.util.FragmentsPagerAdapter;
import com.geektech.navlesson.util.SectionsPagerAdapter;

import java.util.Arrays;
import java.util.List;

//TODO: Первые задачи можно решать переписывая код здесь
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    //private FragmentsPagerAdapter mAdapter;
    private TabLayout mTabLayout;
    private SectionsPagerAdapter mAdapter;
    CalculatorFragment calculatorFragment;
    private BottomNavigationView bottomNavigationView;


    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();
    }

    //region Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                showToast("Settings");
                return true;
            case R.id.action_help:
                showToast("Help");
                return true;
            case R.id.action_exit:
                showToast("Exit");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //endregion

    //endregion

    //region Private

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void init() {
        // mAdapter = new FragmentsPagerAdapter(getSupportFragmentManager());
        mAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.main_viewpager);
        mTabLayout = findViewById(R.id.main_tab_layout);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        mViewPager.setAdapter(mAdapter);

        initTabLayout();

        //Связываем ViewPager и TabLayout
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        /*
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_home:
                                //initHome();
                                //break;
                            case R.id.navigation_dashboard:
                                //initList();
                                //break;
                            case R.id.navigation_notifications:
                                //initCalc();
                                //break;
                        }
                        return false;

                    }
                }
        );
    }

    private void initHome(){
        mTabLayout.getTabAt(0);
    }
    private void initList(){
        mTabLayout.getTabAt(1);
    }
    private void initCalc(){
        mTabLayout.getTabAt(2);
    }
    */
    }
    private void initTabLayout(){
        //Добавляем табы
        mTabLayout.addTab(getTab("Home"));
        mTabLayout.addTab(getTab("List"));
        mTabLayout.addTab(getTab("Calculator"));

    }

    private TabLayout.Tab getTab(String text){
        return mTabLayout.newTab().setText(text);
    }

    //endregion

}
