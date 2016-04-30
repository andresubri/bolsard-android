package com.bolsard.castlestudio.bolsard;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by andriusic on 30/04/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name_element;
        public CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            name_element = (TextView)itemView.findViewById(R.id.name_element);
            cardView = (CardView)itemView.findViewById(R.id.result_card);
        }
    }
}
