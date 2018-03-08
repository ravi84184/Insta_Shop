package ravi.com.instashop.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import ravi.com.instashop.R;
import ravi.com.instashop.adapter.FragmentTabAdapter;
import ravi.com.instashop.adapter.SubCategoryAdapter;
import ravi.com.instashop.model.PopularModel;

public class SubcatActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static final String TAG = "SubcatActivity";
    LinearLayout cart_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcat);

        cart_show = (LinearLayout) findViewById(R.id.cart_show);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("ALL"));
        tabLayout.addTab(tabLayout.newTab().setText("SUB_CAT_1"));
        tabLayout.addTab(tabLayout.newTab().setText("SUB_CAT_2"));
        tabLayout.addTab(tabLayout.newTab().setText("SUB_CAT_3"));

        tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FragmentTabAdapter adapter = new FragmentTabAdapter(getSupportFragmentManager() , tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        cart_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubcatActivity.this,MyorderActivity.class));
            }
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
