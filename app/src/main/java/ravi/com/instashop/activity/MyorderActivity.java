package ravi.com.instashop.activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ravi.com.instashop.DatabseHelper.ExampleDBHelper;
import ravi.com.instashop.R;
import ravi.com.instashop.adapter.CartProductAdapter;
import ravi.com.instashop.model.CartProductModel;
import ravi.com.instashop.model.Money;

public class MyorderActivity extends AppCompatActivity {
    private static final String TAG = "MyorderActivity";

    ExampleDBHelper myDB;
    List<CartProductModel> arrayList = new ArrayList<>();
    RecyclerView cart_list;
    TextView totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        myDB = new ExampleDBHelper(this);

        totalAmount = findViewById(R.id.totalAmount);
        cart_list = findViewById(R.id.cart_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        cart_list.setLayoutManager(layoutManager);
        cart_list.setItemAnimator(new DefaultItemAnimator());
        ProductList();
        updateItemCount(false);
    }
    public  void updateItemCount(boolean ifIncrement) {
        int total = myDB.totleamount();
        Log.e(TAG, "updateItemCount: total " +total );
        BigDecimal checkoutAmount = BigDecimal.valueOf(total);
        totalAmount.setText(String.valueOf(Money.rupees(checkoutAmount))+" incl. Tax");
    }
    public void ProductList() {
        Cursor res = myDB.getAllProduct();
        if (res.getCount() == 0){
            return;
        }
        while (res.moveToNext()){
            Log.e(TAG, "ProductList: CART_COLUMN_CART_ID " +res.getString(0) );
            Log.e(TAG, "ProductList: CART_COLUMN_PID " +res.getString(1) );
            Log.e(TAG, "ProductList: CART_COLUMN_PNAME " +res.getString(2) );
            Log.e(TAG, "ProductList: CART_COLUMN_PPRICE " +res.getString(3) );
            Log.e(TAG, "ProductList: CART_COLUMN_PQNTY " +res.getString(4) );
            Log.e(TAG, "ProductList: CART_COLUMN_PTOTAL " +res.getString(5) );
            Log.e(TAG, "ProductList: CART_COLUMN_PIMG " +res.getString(6) );


            CartProductModel model = new CartProductModel();
            model.setCart_id(res.getString(0));
            model.setP_id(res.getString(1));
            model.setP_name(res.getString(2));
            model.setP_price(res.getInt(3));
            model.setP_q(res.getString(4));
            model.setP_total(res.getInt(5));
            model.setP_image(res.getString(6));
            arrayList.add(model);
        }
        CartProductAdapter adapter = new CartProductAdapter(this,arrayList);
        cart_list.setAdapter(adapter);

    }
}
