package com.castlestudio.bolsard.Views;

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
import com.castlestudio.bolsard.Data.LocalStorage;
import com.castlestudio.bolsard.R;

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
                    StatisticsFragmentTab fixedRentUsdTab = new StatisticsFragmentTab();
                    args.putString("info", LocalStorage.STATISTICS_FIXED_RENT_DOP);
                    fixedRentUsdTab.setArguments(args);
                    return fixedRentUsdTab;
                case 1:
                    StatisticsFragmentTab fixedRentDopTab = new StatisticsFragmentTab();
                    args.putString("info", LocalStorage.STATISTICS_FIXED_RENT_USD);
                    fixedRentDopTab.setArguments(args);
                    return fixedRentDopTab;
                case 2:
                    StatisticsFragmentTab variableRentDopTab = new StatisticsFragmentTab();
                    args.putString("info", LocalStorage.STATISTICS_INVESTMENT_FOUNDS_DOP);
                    variableRentDopTab.setArguments(args);
                    return variableRentDopTab;

                case 3:
                    StatisticsFragmentTab variableRentUsdTab = new StatisticsFragmentTab();
                    args.putString("info", LocalStorage.STATISTICS_INVESTMENT_FOUNDS_USD);
                    variableRentUsdTab.setArguments(args);
                    return variableRentUsdTab;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //Sets the title for each tab
            switch (position) {
                case 0:
                    return "Renta Fija RD$";
                case 1:
                    return "Renta Fija US$";
                case 2:
                    return "Fondos de Inversion RD$";
                case 3:
                    return "Fondos de Inversion US$";
            }
            return null;
        }
    }

}
