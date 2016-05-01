package com.bolsard.castlestudio.bolsard;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andriusic on 30/04/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public List<Result> resultList;
    private int rowLayout;
    public Context mContext;

    public RecyclerAdapter(List<Result> resultList, Context mContext) {
        this.resultList = resultList;
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
    Result result = resultList.get(position);
    holder.code.setText(result.getCodigo());
    holder.publisher.setText(result.getEmisor());
    holder.lastNegotiated.setText(String.valueOf(result.getUltNegociado()));
    holder.price.setText(String.valueOf(result.getPrecioPorentaje()));
    holder.tir.setText(String.valueOf(result.getTirPorcentaje()));
    }

    @Override
    public int getItemCount() {
        return resultList == null ? 0 : resultList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

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
