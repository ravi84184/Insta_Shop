package ravi.com.instashop.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ravi.com.instashop.R;
import ravi.com.instashop.interfaces.ItemClickListener;

/**
 * Created by nikpatel on 07/03/18.
 */
public class CartProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

    public LinearLayout rel_add_remove;
    public TextView p_name,p_total,p_qnty;
    public ImageView p_image,btn_add,btn_remove;

    private ItemClickListener itemClickListener;
    public CartProductViewHolder(View itemView) {
        super(itemView);

        p_name = itemView.findViewById(R.id.p_name);
//        p_weight = itemView.findViewById(R.id.sub_cat_weight_size);
//        p_price = itemView.findViewById(R.id.sub_cat_price);
        p_qnty = itemView.findViewById(R.id.p_qnt);
        p_total = itemView.findViewById(R.id.p_total);
        p_image = itemView.findViewById(R.id.p_image);
        btn_add = itemView.findViewById(R.id.btn_add);
        btn_remove = itemView.findViewById(R.id.btn_remove);

        btn_add.setOnClickListener(this);
        btn_add.setOnLongClickListener(this);

        btn_remove.setOnClickListener(this);
        btn_remove.setOnLongClickListener(this);

//        itemView.setOnClickListener(this);
//        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
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