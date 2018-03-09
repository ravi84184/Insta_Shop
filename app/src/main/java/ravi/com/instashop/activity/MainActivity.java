package ravi.com.instashop.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import ravi.com.instashop.ApiManager.ApiClient;
import ravi.com.instashop.ApiResponse.categoryResponse;
import ravi.com.instashop.R;
import ravi.com.instashop.adapter.CategoryAdapter;
import ravi.com.instashop.adapter.PopularAdapter;
import ravi.com.instashop.adapter.ViewPagerAdapter;
import ravi.com.instashop.interfaces.ApiInterface;
import ravi.com.instashop.model.PopularModel;
import ravi.com.instashop.model.catModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    List<PopularModel> listItemsHorizontal;
    public static final String[] lan = new String[]{"Android 1","Android 2","Android 3","Android 4"};
    public static final Integer[] image = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4};

    PopularAdapter listViewAdapter;
    private ViewPager viewPager;
    private LinearLayout sliderDotspanel;
    private ViewPagerAdapter viewPagerAdapter;
    private int dotscount;
    private ImageView[] dots;
    RecyclerView recycleHorizontal,recycleCategory;
    CategoryAdapter categoryAdapter;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait..");

        listItemsHorizontal = new ArrayList<PopularModel>();

        for (int i =0; i<lan.length ; i++){
            PopularModel items = new PopularModel(lan[i],image[i]);
            listItemsHorizontal.add(items);
        }
        recycleHorizontal = findViewById(R.id.recycleHorizontal);
        recycleHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recycleHorizontal.setAdapter(listViewAdapter = new PopularAdapter(this,listItemsHorizontal));


        recycleCategory = findViewById(R.id.recycleCategory);
        recycleCategory.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycleCategory.setLayoutManager(linearLayoutManager);

        slider();
        catLoad();
    }

    private void slider() {
        viewPager = findViewById(R.id.viewPager);
        sliderDotspanel = findViewById(R.id.SliderDots);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];
        Log.e(TAG, "slider: " +dots.length );
        Log.e(TAG, "slider dots: " +dotscount );
        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            if (MainActivity.this != null) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (viewPager.getCurrentItem() == 0) {
                            viewPager.setCurrentItem(1);
                        } else if (viewPager.getCurrentItem() == 1) {
                            viewPager.setCurrentItem(2);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void catLoad() {
        progressDialog.show();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<categoryResponse> call = apiService.category("categories");
        call.enqueue(new Callback<categoryResponse>() {
            @Override
            public void onResponse(Call<categoryResponse> call, Response<categoryResponse> response) {
                if (response.body().getStatus() == 200) {
                    progressDialog.dismiss();

                    List<catModel> cat = response.body().getCategories();

                    recycleCategory.setAdapter(new CategoryAdapter(MainActivity.this,cat));


                } else {
                    progressDialog.dismiss();

                }
            }
            @Override
            public void onFailure(Call<categoryResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, "Error" + t.toString());

                progressDialog.dismiss();

            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            startActivity(new Intent(MainActivity.this, MainActivity.class));

        } else if (id == R.id.nav_account) {
            startActivity(new Intent(MainActivity.this, MyAccount.class));
        } else if (id == R.id.nav_suggest_product) {
            startActivity(new Intent(MainActivity.this, SuggestProductActivity.class));

        } else if (id == R.id.nav_order) {
            startActivity(new Intent(MainActivity.this, MyorderActivity.class));
        }
        else if (id == R.id.nav_contact) {
            startActivity(new Intent(MainActivity.this, ContactUsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}