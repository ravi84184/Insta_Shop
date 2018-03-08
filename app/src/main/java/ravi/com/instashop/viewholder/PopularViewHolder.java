package ravi.com.instashop.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ravi.com.instashop.R;
import ravi.com.instashop.interfaces.ItemClickListener;

/**
 * Created by nikpatel on 07/03/18.
 */

public class PopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

    public TextView p_name;
    public ImageView p_image;
    private ItemClickListener itemClickListener;
    public PopularViewHolder(View itemView) {
        super(itemView);

        p_name = itemView.findViewById(R.id.p_name);
        p_image = itemView.findViewById(R.id.p_image);

        //itemView.setOnClickListener(this);
        //itemView.setOnLongClickListener(this);
    }

    void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}