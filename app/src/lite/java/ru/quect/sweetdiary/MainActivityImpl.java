package ru.quect.sweetdiary;

import android.app.Fragment;
import android.view.MenuItem;

public class MainActivityImpl extends MainActivity {
    @Override
    public Fragment getFragment(MenuItem menuItem) {
        Fragment fragment;

        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.drawer_diary:
                fragmentClass = DiaryFragment.class;
                break;
            case R.id.drawer_reports:
                fragmentClass = ReportsFragment.class;
                break;
            case R.id.drawer_settings:
                fragmentClass = SettingsFragment.class;
                break;
            default:
                fragmentClass = DiaryFragment.class;
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return fragment;
    }
}
