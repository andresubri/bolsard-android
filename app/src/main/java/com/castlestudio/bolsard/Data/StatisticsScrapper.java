package com.castlestudio.bolsard.Data;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.castlestudio.bolsard.Models.StatisticResult;
import com.castlestudio.bolsard.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *
 * @author Carlos Andres
 */
public class StatisticsScrapper extends AsyncTask<Void,Void,List<List>> {
    Context context;
    Toolbar toolbar;
    public StatisticsScrapper(Context context, Toolbar toolbar) {
        this.context = context;
        this.toolbar = toolbar;
    }

    @Override
    protected List<List> doInBackground(Void... params) {
        //Setup the scrapping process
        String url = "http://bolsard.com/";
        try {
            System.out.println("Connecting to the server...");
            Connection.Response res = Jsoup.connect(url).timeout(0).execute();
            System.out.println("Connected.");
            Document document = res.parse();
            Elements table = document.select("div.indicators-list div");
            ArrayList<StatisticResult> fixedRentDopList = new ArrayList();
            ArrayList<StatisticResult> fixedRentUsdList = new ArrayList();
            ArrayList<StatisticResult> investmentFoundsDopList = new ArrayList();
            ArrayList<StatisticResult> investmentFoundsUsdList = new ArrayList();
            System.out.println("Scrapping data...");
            for (Element e : table.select("div.dop100")) {
                StatisticResult statisticResult = new StatisticResult();
                statisticResult.setCode(e.select("span.nemo-ins").text());
                statisticResult.setTax(e.select("span.tax").text());
                statisticResult.setExpDate(e.select("span.exp-date").text());
                statisticResult.setPrice(e.select("span.precio-limp").text());
                fixedRentDopList.add(statisticResult);
            }

            for (Element e : table.select("div.usd100")) {
                StatisticResult statisticResult = new StatisticResult();
                statisticResult.setCode(e.select("span.nemo-ins").text());
                statisticResult.setTax(e.select("span.tax").text());
                statisticResult.setExpDate(e.select("span.exp-date").text());
                statisticResult.setPrice(e.select("span.precio-limp").text());
                fixedRentUsdList.add(statisticResult);
            }

            for (Element e : table.select("div.dop101")) {
                StatisticResult statisticResult = new StatisticResult();
                statisticResult.setCode(e.select("span.nemo-ins").text());
                statisticResult.setTax(e.select("span.tax").text());
                statisticResult.setExpDate(e.select("span.exp-date").text());
                statisticResult.setPrice(e.select("span.precio-limp").text());
                investmentFoundsDopList.add(statisticResult);
            }
            for (Element e : table.select("div.usd101")) {
                StatisticResult statisticResult = new StatisticResult();
                statisticResult.setCode(e.select("span.nemo-ins").text());
                statisticResult.setTax(e.select("span.tax").text());
                statisticResult.setExpDate(e.select("span.exp-date").text());
                statisticResult.setPrice(e.select("span.precio-limp").text());
                investmentFoundsUsdList.add(statisticResult);
            }
            System.out.println("Fixed Rent DOP Size: " + fixedRentDopList.size());
            System.out.println("Fixed Rent USD Size: " + fixedRentUsdList.size());
            System.out.println("Investment Founds Dop Size: " + investmentFoundsDopList.size());
            System.out.println("Investment Founds USD Size: " + investmentFoundsUsdList.size());

            List<List> finalList = new ArrayList<>();
            finalList.add(fixedRentDopList);
            finalList.add(fixedRentUsdList);
            finalList.add(investmentFoundsDopList);
            finalList.add(investmentFoundsUsdList);
            return finalList;
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<List> lists) {
        if(!lists.isEmpty()){
            LocalStorage ls = new LocalStorage(context);
            ls.save(lists.get(0),LocalStorage.STATISTICS_FIXED_RENT_DOP);
            ls.save(lists.get(1),LocalStorage.STATISTICS_FIXED_RENT_USD);
            ls.save(lists.get(2),LocalStorage.STATISTICS_INVESTMENT_FOUNDS_DOP);
            ls.save(lists.get(3),LocalStorage.STATISTICS_INVESTMENT_FOUNDS_USD);

        }else {
            Snackbar.make(toolbar, R.string.connection_error_fetch, Snackbar.LENGTH_LONG)
                    .setAction(R.string.connection_settings, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        }
                    })
                    .setActionTextColor(context.getResources().getColor(android.R.color.holo_red_light ))
                    .show();
        }
    }
}
