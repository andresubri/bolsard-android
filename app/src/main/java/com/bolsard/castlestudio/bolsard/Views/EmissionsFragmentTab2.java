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
public class EmissionsFragmentTab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_details, container, false);
        RecyclerView mRecyclerViewTab2 = (RecyclerView) rootView.findViewById(R.id.result_recycler);
        mRecyclerViewTab2.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewTab2.setItemAnimator(new DefaultItemAnimator());
        LocalStorage ls = new LocalStorage(getActivity());
        mRecyclerViewTab2.setAdapter(new RecyclerAdapter(ls.get(LocalStorage.FIXED_RENT_DOP),ls.context));
        return rootView;
    }
}