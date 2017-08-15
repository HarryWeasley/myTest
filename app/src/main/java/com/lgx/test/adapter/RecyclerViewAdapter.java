package com.lgx.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lgx.test.R;

import java.util.List;

/**
 * Created by Harry on 2017/8/15.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<HouseType> houseTypeList;

    public RecyclerViewAdapter(List<HouseType> houseTypeList) {
        this.houseTypeList = houseTypeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.content.setText(String.format("产权面积约%s平米，赠送面积约%s平米", houseTypeList.get(position).getRealArea(),
                houseTypeList.get(position).getGivenArea()));
        holder.title.setText(houseTypeList.get(position).getTypeName());

    }

    @Override
    public int getItemCount() {
        return houseTypeList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, content;
        View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
            this.itemView=itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }


}
