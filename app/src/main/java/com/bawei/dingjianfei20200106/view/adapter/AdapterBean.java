package com.bawei.dingjianfei20200106.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dingjianfei20200106.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:32
 * 类名：com.bawei.dingjianfei20200106.view.adapter
 */
public class AdapterBean extends RecyclerView.Adapter<AdapterBean.MyviewHodel> {
    private List<String> category;

    public AdapterBean(List<String> category) {
        this.category = category;
    }

    @NonNull
    @Override
    public MyviewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.view1, null);
        return new MyviewHodel(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHodel holder, int position) {
        String s = category.get(position);
        holder.nn1.setText(s);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    class MyviewHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.nn1)
        TextView nn1;
        public MyviewHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


    Onclick onclick;

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

    public  interface  Onclick{
        void  onclick(int p);
}
}
