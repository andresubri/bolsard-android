package com.bolsard.castlestudio.bolsard.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolsard.castlestudio.bolsard.Data.LocalStorage;
import com.bolsard.castlestudio.bolsard.R;
import com.bolsard.castlestudio.bolsard.Data.RecyclerAdapter;

/**
 * Created by andriusic on 01/05/16.
 */
public class FragmentTab1 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        RecyclerView mRecyclerViewTab1 = (RecyclerView) rootView.findViewById(R.id.result_recycler);
        mRecyclerViewTab1.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewTab1.setItemAnimator(new DefaultItemAnimator());
        LocalStorage ls = new LocalStorage(getActivity());
        mRecyclerViewTab1.setAdapter(new RecyclerAdapter(ls.get(LocalStorage.FIXED_RENT_USD),ls.context));
        return rootView;
    }
}