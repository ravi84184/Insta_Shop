package ravi.com.instashop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import ravi.com.instashop.R;
import ravi.com.instashop.model.PopularModel;
import ravi.com.instashop.viewholder.PopularViewHolder;

/**
 * Created by nikpatel on 07/03/18.
 */

public class PopularAdapter extends RecyclerView.Adapter<PopularViewHolder>{
    Context mContext;
    List<PopularModel> list;
    public PopularAdapter(Context mContext, List<PopularModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_popular_view,parent,false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PopularViewHolder holder, int position) {
        final PopularModel model = (PopularModel) list.get(position);
        holder.p_name.setText(model.getLan());
        Picasso.with(mContext).load(model.getImg()).into(holder.p_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
