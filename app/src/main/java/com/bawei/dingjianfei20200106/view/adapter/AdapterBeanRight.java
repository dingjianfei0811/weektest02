package com.bawei.dingjianfei20200106.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dingjianfei20200106.R;
import com.bawei.dingjianfei20200106.model.bean.BeanRight;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:54
 * 类名：com.bawei.dingjianfei20200106.view.adapter
 */
public class AdapterBeanRight extends RecyclerView.Adapter<AdapterBeanRight.MyviewHodela> {
    private List<BeanRight.DataBean> data;

    public AdapterBeanRight(List<BeanRight.DataBean> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public MyviewHodela onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.view2, null);
        return new MyviewHodela(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHodela holder, int position) {
        String goods_name = data.get(position).getGoods_name();
        String goods_english_name = data.get(position).getGoods_english_name();
        String currency_price = data.get(position).getCurrency_price();
        String goods_thumb = data.get(position).getGoods_thumb();

        holder.jiage.setText(currency_price+"");
        holder.name.setText(goods_name);
        holder.name2.setText(goods_english_name);

        Glide.with(holder.img).load(goods_thumb)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyviewHodela extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.name2)
        TextView name2;
        @BindView(R.id.jiage)
        TextView jiage;
        public MyviewHodela(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
