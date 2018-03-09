package ravi.com.instashop.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ravi.com.instashop.R;
import ravi.com.instashop.adapter.SubCategoryAdapter;
import ravi.com.instashop.model.PopularModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllSubCatFragment extends Fragment {
    public static final String[] lan = new String[]{"Android 1","Android 2","Android 3","Android 4"};
    public static final Integer[] image = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4};
    List<PopularModel> listItemsHorizontal = new ArrayList<PopularModel>();

    SubCategoryAdapter subCategoryAdapter;
    RecyclerView sub_cat_list;

    public AllSubCatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_sub_cat, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        for (int j = 0; j<5; j++){
            for (int i =0; i<lan.length ; i++){
                PopularModel items = new PopularModel(lan[i],image[i]);
                listItemsHorizontal.add(items);
            }
        }
        sub_cat_list = view.findViewById(R.id.sub_cat_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        sub_cat_list.setLayoutManager(gridLayoutManager);
        sub_cat_list.setItemAnimator(new DefaultItemAnimator());
//        sub_cat_list.setAdapter(subCategoryAdapter = new SubCategoryAdapter(getContext(),listItemsHorizontal));

    }
}
