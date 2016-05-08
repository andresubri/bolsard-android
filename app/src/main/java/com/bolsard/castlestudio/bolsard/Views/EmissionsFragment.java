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
import com.bolsard.castlestudio.bolsard.R;
import com.bolsard.castlestudio.bolsard.Data.EmissionsScrapper;

/**
 * Created by andriusic on 05/05/16.
 */
public class EmissionsFragment extends Fragment {
    private ViewPager mViewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);
        //Primary sections of the fragment.
        //Setup the ViewPager with the sections adapter.
        mViewPager = (ViewPager) rootView.findViewById(R.id.container);
        mViewPager.setAdapter(new SectionsPagerAdapter(getChildFragmentManager()));
        //Position the ViewPager on the second tab
        mViewPager.setCurrentItem(1);
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
                    EmissionsFragmentTab fixedRentUsdTab = new EmissionsFragmentTab();
                    args.putString("info", LocalStorage.EMISSIONS_FIXED_RENT_USD);
                    fixedRentUsdTab.setArguments(args);
                    return fixedRentUsdTab;
                case 1:
                    EmissionsFragmentTab fixedRentDopTab = new EmissionsFragmentTab();
                    args.putString("info", LocalStorage.EMISSIONS_FIXED_RENT_DOP);
                    fixedRentDopTab.setArguments(args);
                    return fixedRentDopTab;
                case 2:
                    EmissionsFragmentTab variableRentDopTab = new EmissionsFragmentTab();
                    args.putString("info", LocalStorage.EMISSIONS_VARIABLE_RENT_DOP);
                    variableRentDopTab.setArguments(args);
                    return variableRentDopTab;
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //Sets the title for each tab
            switch (position) {
                case 0:
                    return "Renta Fija US$";
                case 1:
                    return "Renta Fija RD$";
                case 2:
                    return "Renta Variable";
            }
            return null;
        }
    }
}
