package com.castlestudio.bolsard.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castlestudio.bolsard.Data.LocalStorage;
import com.castlestudio.bolsard.R;
import com.castlestudio.bolsard.Data.EmissionsRecyclerAdapter;

/**
 * Created by andriusic on 01/05/16.
 */
public class EmissionsFragmentTab extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Displays the given data for each tab in the EmissionsFragment fragment
        View rootView = inflater.inflate(R.layout.fragment_tab_details, container, false);
        RecyclerView mRecyclerViewTab = (RecyclerView) rootView.findViewById(R.id.result_recycler);
        mRecyclerViewTab.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewTab.setItemAnimator(new DefaultItemAnimator());
        //Setup an instance of LocalStorage to fetch the data locally
        LocalStorage ls = new LocalStorage(getActivity());
        //Set the RecyclerView adapter
        String extra = getArguments().getString("info");
        mRecyclerViewTab.setAdapter(new EmissionsRecyclerAdapter(ls.getEmissionsResult(extra),ls.context));
        return rootView;
    }
}
