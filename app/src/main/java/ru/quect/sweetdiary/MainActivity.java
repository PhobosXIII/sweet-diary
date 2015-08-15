package ru.quect.sweetdiary;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String SELECTED_NAV_ITEM_ID = "selected_nav_item_id";
    
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private int mSelectedNavItemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        setupDrawerLayout();

        if (savedInstanceState == null) {
            mSelectedNavItemId = R.id.drawer_diary;
        } else {
            mSelectedNavItemId = savedInstanceState.getInt(SELECTED_NAV_ITEM_ID);
        }

        mNavigationView.getMenu().performIdentifierAction(mSelectedNavItemId, 0);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_NAV_ITEM_ID, mSelectedNavItemId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment fragment;

        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.drawer_diary:
                fragmentClass = DiaryFragment.class;
                break;
            case R.id.drawer_basal:
                fragmentClass = BasalFragment.class;
                break;
            case R.id.drawer_reports:
                fragmentClass = ReportsFragment.class;
                break;
            default:
                fragmentClass = DiaryFragment.class;
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();

        return true;
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawerLayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);
    }
}
