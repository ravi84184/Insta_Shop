package ravi.com.instashop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.util.List;

import ravi.com.instashop.DatabseHelper.ExampleDBHelper;
import ravi.com.instashop.R;
import ravi.com.instashop.activity.MyorderActivity;
import ravi.com.instashop.model.CartProductModel;
import ravi.com.instashop.model.Money;
import ravi.com.instashop.viewholder.CartProductViewHolder;

/**
 * Created by nikpatel on 07/03/18.
 */

public class CartProductAdapter extends RecyclerView.Adapter<CartProductViewHolder>{
    private static final String TAG = "CartProductAdapter";
    ExampleDBHelper dbHelper;

    Context mContext;
    List<CartProductModel> list;
    public CartProductAdapter(Context mContext, List<CartProductModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public CartProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_cart_view,parent,false);
        return new CartProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CartProductViewHolder holder, final int position) {

        final CartProductModel model = (CartProductModel) list.get(position);
        String Pname=model.getP_name();
        holder.p_name.setText(Pname);
        dbHelper = new ExampleDBHelper(mContext);
        BigDecimal pri = BigDecimal.valueOf(model.getP_price());
        final String  price = String.valueOf(Money.rupees(pri));
        BigDecimal totalb = BigDecimal.valueOf((model.getP_total()));
        String  total = String.valueOf(Money.rupees(totalb));


        holder.p_qnty.setText(model.getP_q() + " Units * " +price);
        holder.p_total.setText(total);
        Picasso.with(mContext).load(model.getP_image()).placeholder(R.mipmap.ic_launcher).into(holder.p_image);

        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: btn_add");
                Log.e(TAG, "onClick: " + position);
                //delete for 1,update for >=2,insert 0,error 200
                Log.d("-->", model.getP_id());
                Log.d("-->", String.valueOf(model.getP_price()));
                dbHelper = new ExampleDBHelper(mContext);
                int i = dbHelper.insertCart(model.getP_id(),model.getP_name(), String.valueOf(model.getP_price()), 1,model.getP_image());
                Log.d("-->", String.valueOf(i));
                if (i == 0) {
                    holder.p_qnty.setText("1 Units * " + price);
                    BigDecimal p = BigDecimal.valueOf((1 * model.getP_price()));
                    holder.p_total.setText(String.valueOf(Money.rupees(p)));
                    ((MyorderActivity) mContext).updateItemCount(true);

                } else if (i > 1) {
                    holder.p_qnty.setText(String.valueOf(i)+" Units * " +price);
                    BigDecimal p = BigDecimal.valueOf((i * model.getP_price()));
                    holder.p_total.setText(String.valueOf(Money.rupees(p)));
                    ((MyorderActivity) mContext).updateItemCount(true);
                } else if (i == 1) {
                    holder.p_qnty.setText(String.valueOf(0)+" Units * " +price);
                    BigDecimal p = BigDecimal.valueOf((0 * model.getP_price()));
                    holder.p_total.setText(String.valueOf(Money.rupees(p)));
                    list.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position,list.size());
                    ((MyorderActivity) mContext).updateItemCount(true);
                } else {
                    Log.d("###", "Something wrong..");
                }
            }
        });
        holder.btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: " +model.getCart_id() );
                int p = dbHelper.deleteFromCart(model.getP_id());

                if (p == 200 || p == 0) {
                    holder.p_qnty.setText(String.valueOf(0)+" Units * " +price);
                    BigDecimal ps = BigDecimal.valueOf((0 * model.getP_price()));
                    holder.p_total.setText(String.valueOf(Money.rupees(ps)));
                    list.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position,list.size());
                    ((MyorderActivity) mContext).updateItemCount(true);

                } else {
                    holder.p_qnty.setText(String.valueOf(p)+" Units * " +price);
                    Log.d("-->", String.valueOf(p));
                    BigDecimal ps = BigDecimal.valueOf((p * model.getP_price()));
                    holder.p_total.setText(String.valueOf(Money.rupees(ps)));
                    ((MyorderActivity) mContext).updateItemCount(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
