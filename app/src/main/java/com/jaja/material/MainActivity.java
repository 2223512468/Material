package com.jaja.material;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.jaja.material.adapter.MenuAdapter;
import com.jaja.material.model.BackColorSelect;
import com.jaja.material.widget.AutoListView;
import com.jaja.material.widget.FloatingActionButton;
import com.jaja.material.widget.ProgressBarCircular;
import com.jaja.material.widget.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private AutoListView listView;
    private Toolbar toolbar;
    private SlidingTabLayout slidingTabLayout;
    private ActionBarDrawerToggle drawerToggle;
    private MenuAdapter adapter;
    private FloatingActionButton fab;
    private ProgressBarCircular progressBarCircular;
    private List<BackColorSelect> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (AutoListView) findViewById(R.id.navdrawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        progressBarCircular = (ProgressBarCircular) findViewById(R.id.progress);
        fab = (FloatingActionButton) findViewById(R.id.fabButton);
        fab.setDrawableIcon(getResources().getDrawable(R.mipmap.plus));

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.mipmap.ic_ab_drawer);
        }

        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);

        list.add(new BackColorSelect("默认"));
        list.add(new BackColorSelect("红色"));
        list.add(new BackColorSelect("蓝色"));
        list.add(new BackColorSelect("灰色"));
        adapter = new MenuAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        listView.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case 1:
                        listView.setBackgroundColor(getResources().getColor(R.color.orange_user));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.orange_user));
                        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.orange_user));
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                    case 2:
                        listView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                    case 3:
                        listView.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
