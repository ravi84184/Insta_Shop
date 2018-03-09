package ravi.com.instashop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

import ravi.com.instashop.fragment.AllSubCatFragment;
import ravi.com.instashop.model.SubcatModel;
import ravi.com.instashop.model.catModel;

/**
 * Created by nikpatel on 08/09/17.
 */

public class FragmentTabAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "FragmentTabAdapter";
    int tabcount;
    List<SubcatModel> list;

    public FragmentTabAdapter(FragmentManager fm, int tabcount, List<SubcatModel> list) {
        super(fm);
        this.tabcount = tabcount;
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        SubcatModel model = list.get(tabcount);
        Log.e(TAG, "getItem: " +model.getCategory_id() );

        Fragment fragment;
        if (tabcount <= position){
            Log.e(TAG, "getItem: " +model.getCategory_id() );
            fragment = new AllSubCatFragment();
        } else {
            fragment = new AllSubCatFragment();
        }
        return fragment;

//        switch (position){
//            case 0:
//                Fragment fragment = new AllSubCatFragment();
//                return fragment;
//            case 1:
//                Fragment fragment1 = new AllSubCatFragment();
//                return fragment1;
//            case 2:
//                Fragment fragment2 = new AllSubCatFragment();
//                return fragment2;
//            case 3:
//                Fragment fragment3 = new AllSubCatFragment();
//                return fragment3;
//            default:
//                return null;
//        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return tabcount;
    }
}
