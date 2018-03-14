package ravi.com.instashop.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import ravi.com.instashop.ApiManager.ApiClient;
import ravi.com.instashop.ApiResponse.subcategoryResponse;
import ravi.com.instashop.FragmentChild;
import ravi.com.instashop.R;
import ravi.com.instashop.ViewPagerAdapter;
import ravi.com.instashop.interfaces.ApiInterface;
import ravi.com.instashop.model.Money;
import ravi.com.instashop.model.SubcatModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubcatActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static final String TAG = "SubcatActivity";
    private static int itemCount = 0;

    List<SubcatModel> subcatModelscat = new ArrayList<SubcatModel>();
    private ViewPagerAdapter adapter;

    private TextView checkOutAmount;
    private static TextView itemCountTextView;
    private TextView offerBanner;

    private BigDecimal checkoutAmount = new BigDecimal(BigInteger.ZERO);


    String cat_id;
    int selectedTabPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getApplicationContext();
        setContentView(R.layout.activity_subcat);

        offerBanner = ((TextView) findViewById(R.id.new_offers_banner));

        itemCountTextView = (TextView) findViewById(R.id.item_count);
        itemCountTextView.setSelected(true);
        itemCountTextView.setText(String.valueOf(itemCount));

        checkOutAmount = (TextView) findViewById(R.id.checkout_amount);
        checkOutAmount.setSelected(true);
        checkOutAmount.setText(Money.rupees(checkoutAmount).toString());
        offerBanner.setSelected(true);
        updateItemCount(false);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


        adapter = new ViewPagerAdapter(getSupportFragmentManager(), context, viewPager, tabLayout);
        viewPager.setAdapter(adapter);


//        tabLayout.addTab(tabLayout.newTab().setText("SUB_CAT_2"));
//        tabLayout.addTab(tabLayout.newTab().setText("SUB_CAT_3"));

    }
    public void addPage(String sub_cat_name,String sub_cat_id,String cat_id) {
        Bundle bundle = new Bundle();
        bundle.putString("cat_name", sub_cat_name);
        bundle.putString("sub_cat_id", sub_cat_id);
        bundle.putString("cat_id", cat_id);
        FragmentChild fragmentChild = new FragmentChild();
        fragmentChild.setArguments(bundle);
        adapter.addFrag(fragmentChild, sub_cat_name);
        adapter.notifyDataSetChanged();

        if (adapter.getCount() > 0) tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(adapter.getCount() - 1);
        setupTabLayout();
    }
    public void setupTabLayout() {
        selectedTabPosition = viewPager.getCurrentItem();
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(adapter.getTabView(i));
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        cat_id = getIntent().getStringExtra("CAT_ID");
        SubcatLoad();
    }

    public  void updateItemCount(boolean ifIncrement) {
        if (ifIncrement) {
            itemCount++;
            itemCountTextView.setText(String.valueOf(itemCount));

        } else {
            itemCountTextView.setText(String.valueOf(itemCount <= 0 ? 0
                    : --itemCount));
        }

        toggleBannerVisibility();
    }

    public void toggleBannerVisibility() {
        if (itemCount == 0) {

            findViewById(R.id.checkout_item_root).setVisibility(View.GONE);
            findViewById(R.id.new_offers_banner).setVisibility(View.VISIBLE);

        } else {
            findViewById(R.id.checkout_item_root).setVisibility(View.VISIBLE);
            findViewById(R.id.new_offers_banner).setVisibility(View.GONE);
        }
    }
    private void SubcatLoad() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<subcategoryResponse> call = apiService.subcategory(cat_id);
        call.enqueue(new Callback<subcategoryResponse>() {
            @Override
            public void onResponse(Call<subcategoryResponse> call, Response<subcategoryResponse> response) {
                if (response.body().getStatus() == 200) {

                    subcatModelscat = response.body().getSub_categories();
                    //recycleCategory.setAdapter(new SubCategoryAdapter(SubcatActivity.this,subcatModelscat));
                    for (int i = 0; i<subcatModelscat.size(); i++){
//                    for (int i =subcatModelscat.size(); i>=0 ;i--){
                        Log.e(TAG, "run: "+"=" + subcatModelscat.get(i).getSub_category_name());
                        addPage(subcatModelscat.get(i).getSub_category_name(),subcatModelscat.get(i).getSub_category_id(),
                                subcatModelscat.get(i).getCategory_id());
//                        tabLayout.addTab(tabLayout.newTab().setText(subcatModelscat.get(i).getSub_category_name()));
                    }
                    tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.colorPrimary));
                    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//                    FragmentTabAdapter adapter = new FragmentTabAdapter(getSupportFragmentManager(), tabLayout.getTabCount(),subcatModelscat);

//                    viewPager.setAdapter(adapter);
//        viewPager.setAdapter(new AllSubCatFragment());

                    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            viewPager.setCurrentItem(tab.getPosition());
                            Log.e(TAG, "onTabSelected: " +tab.getText() );
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                    });
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                } else {

                }
            }

            @Override
            public void onFailure(Call<subcategoryResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, "Error" + t.toString());
            }
        });
    }
}
