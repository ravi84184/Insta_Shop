package ravi.com.instashop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import ravi.com.instashop.R;
import ravi.com.instashop.activity.SubcatActivity;
import ravi.com.instashop.interfaces.ItemClickListener;
import ravi.com.instashop.model.PopularModel;
import ravi.com.instashop.model.catModel;
import ravi.com.instashop.viewholder.CategoryViewHolder;
import ravi.com.instashop.viewholder.PopularViewHolder;

/**
 * Created by nikpatel on 07/03/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    Context mContext;
    List<catModel> list;
    public CategoryAdapter(Context mContext, List<catModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_category_view,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        final catModel model = (catModel) list.get(position);
        String Pname=model.getCategory_name();
        Pname=Pname.replace("&amp;","&");
        Log.d("###-->",Pname);
        holder.p_name.setText(Pname);
        Picasso.with(mContext).load(model.getCategory_photo()).placeholder(R.mipmap.ic_launcher).into(holder.p_image);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick){
                    mContext.startActivity(new Intent(mContext, SubcatActivity.class).putExtra("CAT_ID",model.getCategory_id()));
                } else {
                    mContext.startActivity(new Intent(mContext, SubcatActivity.class).putExtra("CAT_ID",model.getCategory_id()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
