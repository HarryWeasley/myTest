package com.lgx.test.adapter;

import android.support.v7.widget.CardView;
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
    private OnItemViewClick itemClick;

    public RecyclerViewAdapter(List<HouseType> houseTypeList) {
        this.houseTypeList = houseTypeList;
    }

    public void setOnItemClick(OnItemViewClick itemClick){
        this.itemClick=itemClick;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.content.setText(String.format("产权面积约%s平米，赠送面积约%s平米", houseTypeList.get(position).getRealArea(),
                houseTypeList.get(position).getGivenArea()));
        holder.title.setText(houseTypeList.get(position).getTypeName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(position,holder.mCardView);
            }
        });

    }

    @Override
    public int getItemCount() {
        return houseTypeList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, content;
        View itemView;
        CardView  mCardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mCardView= (CardView) itemView.findViewById(R.id.card_view);
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


   public interface OnItemViewClick{
        void onClick(int position,View view);
    }


}
