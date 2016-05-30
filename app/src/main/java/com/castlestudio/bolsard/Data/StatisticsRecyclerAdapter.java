package com.castlestudio.bolsard.Data;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.castlestudio.bolsard.Models.StatisticResult;
import com.castlestudio.bolsard.R;

import java.util.List;

/**
 * Created by andriusic on 30/04/16.
 */
public class StatisticsRecyclerAdapter extends RecyclerView.Adapter<StatisticsRecyclerAdapter.ViewHolder> {
    public List<StatisticResult> statisticResultList;
    private int rowLayout;
    public Context mContext;

    public StatisticsRecyclerAdapter(List<StatisticResult> statisticResultList, Context mContext) {
        this.statisticResultList = statisticResultList;
        this.mContext = mContext;
        this.rowLayout = R.layout.statistics_list_element;
    }

    @Override
    public StatisticsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        final StatisticsRecyclerAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(StatisticsRecyclerAdapter.ViewHolder holder, int position) {
        //Bind the data to the view
        StatisticResult emissionsResult = statisticResultList.get(position);
        holder.code.setText(emissionsResult.getCode());
        holder.tax.setText(emissionsResult.getTax());
        holder.price.setText(String.valueOf(emissionsResult.getPrice()));
        holder.expDate.setText(String.valueOf(emissionsResult.getExpDate()));
    }

    @Override
    public int getItemCount() {
        return statisticResultList == null ? 0 : statisticResultList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //Setup the placeholder for the RecyclerView
        public TextView code,tax,price,expDate;
        public CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            code = (TextView)itemView.findViewById(R.id.statistic_code);
            tax  = (TextView)itemView.findViewById(R.id.statistic_tax);
            price = (TextView)itemView.findViewById(R.id.statistic_price);
            expDate = (TextView)itemView.findViewById(R.id.statistic_exp_date);
            cardView = (CardView)itemView.findViewById(R.id.statistics_result_card);
        }
    }
}
