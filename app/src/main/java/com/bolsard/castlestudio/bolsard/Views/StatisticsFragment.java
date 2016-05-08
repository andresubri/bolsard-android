package com.bolsard.castlestudio.bolsard.Views;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bolsard.castlestudio.bolsard.Data.LocalStorage;
import com.bolsard.castlestudio.bolsard.Data.EmissionsScrapper;
import com.bolsard.castlestudio.bolsard.R;

/**
 * Created by andriusic on 07/05/16.
 */
public class StatisticsFragment extends Fragment {
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);
        //Primary sections of the fragment.
        //Setup the ViewPager with the sections adapter.
        mViewPager = (ViewPager) rootView.findViewById(R.id.container);
        mViewPager.setAdapter(new SectionsPagerAdapter(getChildFragmentManager()));
        //Get the data from the server
        new EmissionsScrapper(getActivity()).execute();
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        return rootView;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Returns a new fragment for each tab with its own data
            Bundle args = new Bundle();
            switch (position) {
                case 0:
                    StatisticsFragmentTab fixedRentTab = new StatisticsFragmentTab();
                    args.putString("info", LocalStorage.EMISSIONS_FIXED_RENT_DOP);
                    fixedRentTab.setArguments(args);
                    return fixedRentTab;
                case 1:
                    StatisticsFragmentTab invesmentFoundsTab = new StatisticsFragmentTab();
                    args.putString("info", LocalStorage.EMISSIONS_VARIABLE_RENT_DOP);
                    invesmentFoundsTab.setArguments(args);
                    return invesmentFoundsTab;
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //Sets the title for each tab
            switch (position) {
                case 0:
                    return "Renta Fija";
                case 1:
                    return "Fondos de Inversion";
            }
            return null;
        }
    }

}
