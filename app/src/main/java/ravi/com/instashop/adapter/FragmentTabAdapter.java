package ravi.com.instashop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ravi.com.instashop.fragment.AllSubCatFragment;

/**
 * Created by nikpatel on 08/09/17.
 */

public class FragmentTabAdapter extends FragmentStatePagerAdapter {

    int tabcount;

    public FragmentTabAdapter(FragmentManager fm, int tabcount) {
        super(fm);
        this.tabcount = tabcount;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment fragment = new AllSubCatFragment();
                return fragment;
            case 1:
                Fragment fragment1 = new AllSubCatFragment();
                return fragment1;
            case 2:
                Fragment fragment2 = new AllSubCatFragment();
                return fragment2;
            case 3:
                Fragment fragment3 = new AllSubCatFragment();
                return fragment3;
            default:
                return null;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return tabcount;
    }
}
