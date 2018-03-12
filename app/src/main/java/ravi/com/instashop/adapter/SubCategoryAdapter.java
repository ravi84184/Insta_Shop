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
        Log.e(TAG, "onBindViewHolder: " +model.getProduct_image() );
        Log.e(TAG, "onBindViewHolder: " +model.getProduct_name() );
        item_number_select.add(0);

        Log.e(TAG, "onBindViewHolder: " + item_number_select.toString());
        holder.p_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: " +position );
                if (!product_id.contains(model.getProduct_id())){
                    product_id.add(model.getProduct_id());
                    product_qnty.add(1);
                    holder.rel_add_remove.setVisibility(View.VISIBLE);
                    holder.add_item.setText("+" + 1);
                    Log.e(TAG, "onClick: " +product_id.toString());
                    Log.e(TAG, "onClick: " +product_qnty.toString());
                } else {
                    for (int i=0; i<product_id.size(); i++){
                        if (product_id.get(i)==model.getProduct_id())
                        {
                            pos=i;
                        }
                    }
                    Log.d("Position",String.valueOf(pos));
                    product_qnty.set(pos,product_qnty.get(pos)+1);
                    holder.add_item.setText("+" + product_qnty.get(pos));
                    Log.e(TAG, "onClick: " +product_id.toString());
                    Log.e(TAG, "onClick: " +product_qnty.toString());
                }
            }
        });
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: btn_add");
                Log.e(TAG, "onClick: " +position );

                if (!product_id.contains(model.getProduct_id())){
                    product_id.add(model.getProduct_id());
                    product_qnty.add(1);
                    ((SubcatActivity) mContext).updateItemCount(true);
                    holder.add_item.setText("+" + 1);
                    Log.e(TAG, "onClick: " +product_id.toString());
                    Log.e(TAG, "onClick: " +product_qnty.toString());
                } else {
                    for (int i=0; i<product_id.size(); i++){
                        if (product_id.get(i)==model.getProduct_id())
                        {
                            pos=i;
                        }
                    }
                    Log.d("Position",String.valueOf(pos));
                    product_qnty.set(pos,product_qnty.get(pos)+1);
                    holder.add_item.setText("+" + product_qnty.get(pos));
                    Log.e(TAG, "onClick: " +product_id.toString());
                    Log.e(TAG, "onClick: " +product_qnty.toString());
                }
            }
        });
        holder.add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: " +position );
                if (!product_id.contains(model.getProduct_id())){
                    product_id.add(model.getProduct_id());
                    product_qnty.add(1);
                    holder.rel_add_remove.setVisibility(View.VISIBLE);
                    holder.add_item.setText("+" + 1);
                    Log.e(TAG, "onClick: " +product_id.toString());
                    Log.e(TAG, "onClick: " +product_qnty.toString());
                } else {
                    for (int i=0; i<product_id.size(); i++){
                        if (product_id.get(i)==model.getProduct_id())
                        {
                            pos=i;
                        }
                    }
                    Log.d("Position",String.valueOf(pos));
                    product_qnty.set(pos,product_qnty.get(pos)+1);
                    holder.add_item.setText("+" + product_qnty.get(pos));
                    Log.e(TAG, "onClick: " +product_id.toString());
                    Log.e(TAG, "onClick: " +product_qnty.toString());
                }
            }
        });
        holder.remove_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "onClick: " +position );
                if (!product_id.contains(model.getProduct_id())){
//                    product_id.add(model.getProduct_id());
//                    product_qnty.add(1);
//                    holder.rel_add_remove.setVisibility(View.VISIBLE);
//                    holder.add_item.setText("+" + 1);
//                    Log.e(TAG, "onClick: " +product_id.toString());
//                    Log.e(TAG, "onClick: " +product_qnty.toString());
                } else {
                    for (int i=0; i<product_id.size(); i++){
                        if (product_id.get(i)==model.getProduct_id())
                        {
                            pos=i;
                        }
                    }

                    int q = product_qnty.get(pos);
                    Log.e(TAG, "onClick: q !!!!! " + q);
                    if (q > 1){
                        product_qnty.set(pos,product_qnty.get(pos)-1);
                        holder.add_item.setText("+" + product_qnty.get(pos));
                        Log.e(TAG, "onClick: " +product_id.toString());
                        Log.e(TAG, "onClick: " +product_qnty.toString());
                    } else {
                        product_id.remove(pos);
                        product_qnty.remove(pos);
                        holder.rel_add_remove.setVisibility(View.INVISIBLE);
                        Log.e(TAG, "onClick: " +product_id.toString());
                        Log.e(TAG, "onClick: " +product_qnty.toString());
                    }
                }
//                Log.e(TAG, "onClick: remove_item");
//                int i = item_number_select.get(position);
//                i--;
//                if (i <= 0) {
//                    item_number_select.set(position, 0);
//                    holder.rel_add_remove.setVisibility(View.INVISIBLE);
//                } else {
//                    holder.add_item.setText("+" + i);
//                    item_number_select.set(position, i);
//                }
            }
        });

//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onClick(View view, int position, boolean isLongClick) {
//                if (isLongClick){
//                    Toast.makeText(mContext, "Click", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(mContext, "Click", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }


//    @Override
//    public void onBindViewHolder(final SubCategoryViewHolder holder, final int position) {
//        final SubcatItemModel model = (SubcatItemModel) list.get(position);
//
//        holder.p_name.setText(model.getProduct_name());
//        holder.p_price.setText(model.getMrpPrice());
//        holder.p_weight.setText(model.getWeightSize());
//        Picasso.with(mContext).load(model.getProduct_image()).placeholder(R.mipmap.ic_launcher).into(holder.p_image);
//        Log.e(TAG, "onBindViewHolder: " +model.getProduct_image() );
//        Log.e(TAG, "onBindViewHolder: " +model.getProduct_name() );
//        item_number_select.add(0);
//
//        Log.e(TAG, "onBindViewHolder: " + item_number_select.toString());
//        holder.p_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int i = item_number_select.get(position);
//                if (i <= 0) {
//                    Log.e(TAG, "onClick: btn_add  if ");
//                    holder.rel_add_remove.setVisibility(View.VISIBLE);
//                    i++;
//                    holder.add_item.setText("+" + 1);
//                    item_number_select.set(position, i);
//                } else {
//                    i++;
//                    item_number_select.set(position, i);
//                    holder.add_item.setText("+" + i);
//                }
//            }
//        });
//        holder.btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e(TAG, "onClick: btn_add");
//                int i = item_number_select.get(position);
//                if (i <= 0) {
//                    Log.e(TAG, "onClick: btn_add  if ");
//                    holder.rel_add_remove.setVisibility(View.VISIBLE);
//                    i++;
//                    holder.add_item.setText("+" + 1);
//                    item_number_select.set(position, i);
//                } else {
//                    i++;
//                    item_number_select.set(position, i);
//                    holder.add_item.setText("+" + i);
//                }
//            }
//        });
//        holder.add_item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int i = item_number_select.get(position);
//                Log.e(TAG, "onClick: add_item");
//                i++;
//                item_number_select.set(position, i);
//                holder.add_item.setText("+" + i);
//            }
//        });
//        holder.remove_item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e(TAG, "onClick: remove_item");
//                int i = item_number_select.get(position);
//                i--;
//                if (i <= 0) {
//                    item_number_select.set(position, 0);
//                    holder.rel_add_remove.setVisibility(View.INVISIBLE);
//                } else {
//                    holder.add_item.setText("+" + i);
//                    item_number_select.set(position, i);
//                }
//            }
//        });
//
////        holder.setItemClickListener(new ItemClickListener() {
////            @Override
////            public void onClick(View view, int position, boolean isLongClick) {
////                if (isLongClick){
////                    Toast.makeText(mContext, "Click", Toast.LENGTH_SHORT).show();
////                } else {
////                    Toast.makeText(mContext, "Click", Toast.LENGTH_SHORT).show();
////                }
////            }
////        });
//    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
