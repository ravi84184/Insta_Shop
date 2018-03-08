package ravi.com.instashop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import ravi.com.instashop.R;
import ravi.com.instashop.activity.SubcatActivity;
import ravi.com.instashop.interfaces.ItemClickListener;
import ravi.com.instashop.model.PopularModel;
import ravi.com.instashop.viewholder.CategoryViewHolder;
import ravi.com.instashop.viewholder.PopularViewHolder;

/**
 * Created by nikpatel on 07/03/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    Context mContext;
    List<PopularModel> list;
    public CategoryAdapter(Context mContext, List<PopularModel> list) {
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
        final PopularModel model = (PopularModel) list.get(position);

        holder.p_name.setText(model.getLan());
        Picasso.with(mContext).load(model.getImg()).into(holder.p_image);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick){
                    mContext.startActivity(new Intent(mContext, SubcatActivity.class));
                } else {
                    mContext.startActivity(new Intent(mContext, SubcatActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
