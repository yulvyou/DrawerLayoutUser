package com.example.drawerlayouttest;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.appbar)
    AppBarLayout mAppbar;
    @Bind(R.id.frame_content)
    FrameLayout mFrameContent;
    @Bind(R.id.main_content)
    CoordinatorLayout mMainContent;
    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    //左侧菜单开关
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //使用Toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("DrawerLayout");
        //初始化“开关”
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();//同步
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //设置左侧菜单的点击事件
        setupDrawerContent(mNavigationView);

    }//onCreate


    /**
     * 设置左侧菜单MenuItem的点击事件
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        Toast.makeText(MainActivity.this, "点击了" + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        ;
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }//setupDrawerContent


}//End

