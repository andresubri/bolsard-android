package com.bolsard.castlestudio.bolsard.Data;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bolsard.castlestudio.bolsard.Models.EmissionsResult;
import com.bolsard.castlestudio.bolsard.R;

import java.util.List;

/**
 * Created by andriusic on 30/04/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public List<EmissionsResult> emissionsResultList;
    private int rowLayout;
    public Context mContext;

    public RecyclerAdapter(List<EmissionsResult> emissionsResultList, Context mContext) {
        this.emissionsResultList = emissionsResultList;
        this.mContext = mContext;
        this.rowLayout = R.layout.list_element;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        final RecyclerAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        //Bind the data to the view
    EmissionsResult emissionsResult = emissionsResultList.get(position);
    holder.code.setText(emissionsResult.getCode());
    holder.publisher.setText(emissionsResult.getPublisher());
    holder.lastNegotiated.setText(String.valueOf(emissionsResult.getLastNegociated()));
    holder.price.setText(String.valueOf(emissionsResult.getPricePercentage()));
    holder.tir.setText(String.valueOf(emissionsResult.getTirPercentage()));
    }

    @Override
    public int getItemCount() {
        return emissionsResultList == null ? 0 : emissionsResultList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //Setup the placeholder for the RecyclerView
        public TextView code,publisher,lastNegotiated,price,tir;
        public CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            code = (TextView)itemView.findViewById(R.id.code_result);
            publisher = (TextView)itemView.findViewById(R.id.publisher_result);
            lastNegotiated = (TextView)itemView.findViewById(R.id.last_negotiated);
            price = (TextView)itemView.findViewById(R.id.price_percentage);
            tir = (TextView)itemView.findViewById(R.id.tir_percentage);
            cardView = (CardView)itemView.findViewById(R.id.result_card);
        }
    }
}
