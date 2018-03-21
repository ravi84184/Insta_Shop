package ravi.com.instashop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ravi.com.instashop.DatabseHelper.ExampleDBHelper;
import ravi.com.instashop.R;
import ravi.com.instashop.activity.SubcatActivity;
import ravi.com.instashop.interfaces.ItemClickListener;
import ravi.com.instashop.model.PopularModel;
import ravi.com.instashop.model.SubcatItemModel;
import ravi.com.instashop.viewholder.CategoryViewHolder;
import ravi.com.instashop.viewholder.SubCategoryViewHolder;

/**
 * Created by nikpatel on 07/03/18.
 */

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryViewHolder> {
    private static final String TAG = "SubCategoryAdapter";
    Context mContext;
    List<SubcatItemModel> list;
    List<Integer> item_number_select = new ArrayList<>();
    List<String> product_id = new ArrayList<>();
    List<Integer> product_qnty = new ArrayList<>();
    ExampleDBHelper dbHelper;


    int pos;

    public SubCategoryAdapter(Context mContext, List<SubcatItemModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public SubCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_sub_cat_item, parent, false);
        return new SubCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SubCategoryViewHolder holder, final int position) {
        final SubcatItemModel model = (SubcatItemModel) list.get(position);
        holder.p_name.setText(model.getProduct_name());
        holder.p_price.setText(model.getMrpPrice());
        holder.p_weight.setText(model.getWeightSize());
        Picasso.with(mContext).load(model.getProduct_image()).placeholder(R.mipmap.ic_launcher).into(holder.p_image);
        Log.e(TAG, "onBindViewHolder: " + model.getProduct_image());
        Log.e(TAG, "onBindViewHolder: " + model.getProduct_name());
        item_number_select.add(0);

        Log.e(TAG, "onBindViewHolder: " + item_number_select.toString());
        holder.p_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: " + position);
            }
        });
        holder.btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = dbHelper.deleteFromCart(model.getProduct_id());
                if (p == 200) {
                    holder.p_qnty.setText(String.valueOf(0));
                    ((SubcatActivity) mContext).updateItemCount(true);
                    Log.d("-->", String.valueOf(0));
                } else {
                    ((SubcatActivity) mContext).updateItemCount(true);
                    holder.p_qnty.setText(String.valueOf(p));
                    Log.d("-->", String.valueOf(p));
                }
            }
        });
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: btn_add");
                Log.e(TAG, "onClick: " + position);
                //delete for 1,update for >=2,insert 0,error 200
                Log.d("-->", model.getProduct_id());
                Log.d("-->", model.getMrpPrice());
                dbHelper = new ExampleDBHelper(mContext);
                int i = dbHelper.insertCart(model.getProduct_id(),model.getProduct_name(), model.getMrpPrice(), 1,model.getProduct_image());
                Log.d("-->", String.valueOf(i));
                if (i == 0) {
                    ((SubcatActivity) mContext).updateItemCount(true);
                    holder.p_qnty.setText("1");
                } else if (i > 1) {
                    ((SubcatActivity) mContext).updateItemCount(true);
                    holder.p_qnty.setText(String.valueOf(i));
                } else if (i == 1) {
                    ((SubcatActivity) mContext).updateItemCount(false);
                    holder.p_qnty.setText("0");
                } else {
                    Log.d("###", "Something wrong..");
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}