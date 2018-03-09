package ravi.com.instashop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ravi.com.instashop.ApiManager.ApiClient;
import ravi.com.instashop.ApiResponse.subcategoryItemResponse;
import ravi.com.instashop.adapter.SubCategoryAdapter;
import ravi.com.instashop.interfaces.ApiInterface;
import ravi.com.instashop.model.SubcatItemModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DAT on 9/1/2015.
 */
public class FragmentChild extends Fragment {
    String cat_name,sub_cat_id,cat_id;

    private static final String TAG = "FragmentChild";

    List<SubcatItemModel> subcatItemModels = new ArrayList<SubcatItemModel>();

    SubCategoryAdapter subCategoryAdapter;
    RecyclerView sub_cat_list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child, container, false);
        Bundle bundle = getArguments();
        cat_name = bundle.getString("cat_name");
        sub_cat_id = bundle.getString("sub_cat_id");
        cat_id = bundle.getString("cat_id");

        Log.e(TAG, "onCreateView: "+cat_id +" " +cat_name+" "+sub_cat_id  );

        getIDs(view);
        setEvents();
        SubcatitemLoad();
        return view;
    }

    private void getIDs(View view) {
        sub_cat_list = view.findViewById(R.id.sub_cat_list);

    }

    private void setEvents() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        sub_cat_list.setLayoutManager(gridLayoutManager);
        sub_cat_list.setItemAnimator(new DefaultItemAnimator());
//        sub_cat_list.setAdapter(subCategoryAdapter = new SubCategoryAdapter(getContext(),listItemsHorizontal));
    }

    private void SubcatitemLoad() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<subcategoryItemResponse> call = apiService.subcategoryitem(sub_cat_id);
        call.enqueue(new Callback<subcategoryItemResponse>() {
            @Override
            public void onResponse(Call<subcategoryItemResponse> call, Response<subcategoryItemResponse> response) {
                if (response.body().getStatus() == 200) {
                    subcatItemModels = response.body().getProducts();
                    Log.e(TAG, "onResponse: " +subcatItemModels );
                    sub_cat_list.setAdapter(new SubCategoryAdapter(getActivity(),subcatItemModels));

                } else {

                }
            }

            @Override
            public void onFailure(Call<subcategoryItemResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, "Error" + t.toString());
            }
        });
    }
}
