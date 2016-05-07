/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsard.castlestudio.bolsard;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *
 * @author malmonte
 */
public class Scrapper extends AsyncTask<Void,Void,List<List>> {
    Context context;
    public Scrapper(Context context) {
        this.context = context;
    }

    @Override
    protected List<List> doInBackground(Void... params) {
        // TODO code application logic here
        String url = "http://bolsard.com/";
        try {
            System.out.println("Connecting to the server...");
            Connection.Response res = Jsoup.connect(url).timeout(0).execute();
            System.out.println("Connected.");
            Document document = res.parse();
            Elements table = document.select(".rc-table-chart-wrapper tbody tr");
            Elements tds;
            int cnt;
            int pos;
            ArrayList<Result> fixedRentDopList = new ArrayList();
            ArrayList<Result> fixedRentUsdList = new ArrayList();
            ArrayList<Result> variableRentList = new ArrayList();
            System.out.println("Scrapping data...");
            for (Element e : table.select("tr.dop100")) {
                tds = e.select("td");
                cnt = 0;
                fixedRentDopList.add(new Result());
                pos = fixedRentDopList.size() - 1;
                for (Element td : tds) {
                    switch (cnt) {
                        case 0:
                            fixedRentDopList.get(pos).setCode(td.text());
                            break;
                        case 1:
                            fixedRentDopList.get(pos).setPublisher(td.text());
                            break;
                        case 2:
                            if (td.text().contains(".")) {
                                continue;
                            }
                            fixedRentDopList.get(pos).setLastNegociated(Integer.valueOf(td.text().replace(",", "")));
                            break;
                        case 3:
                            fixedRentDopList.get(pos).setPricePercentage(Float.valueOf(td.text().replace(",", "")));
                            break;
                        case 4:
                            fixedRentDopList.get(pos).setTirPercentage(Float.valueOf(td.text().replace(",", "")));
                            break;
                    }
                    cnt++;
                }
            }
            for (Element e : table.select("tr.usd100")) {
                tds = e.select("td");
                cnt = 0;
                fixedRentUsdList.add(new Result());
                pos = fixedRentUsdList.size() - 1;
                for (Element td : tds) {
                    switch (cnt) {
                        case 0:
                            fixedRentUsdList.get(pos).setCode(td.text());
                            break;
                        case 1:
                            fixedRentUsdList.get(pos).setPublisher(td.text());
                            break;
                        case 2:
                            if (td.text().contains(".")) {
                                continue;
                            }
                            fixedRentUsdList.get(pos).setLastNegociated(Integer.valueOf(td.text().replace(",", "")));
                            break;
                        case 3:
                            fixedRentUsdList.get(pos).setPricePercentage(Float.valueOf(td.text().replace(",", "")));
                            break;
                        case 4:
                            fixedRentUsdList.get(pos).setTirPercentage(Float.valueOf(td.text().replace(",", "")));
                            break;
                    }
                    cnt++;
                }
            }
            for (Element e : table.select("tr.dop101")) {
                tds = e.select("td");
                cnt = 0;
                variableRentList.add(new Result());
                pos = variableRentList.size() - 1;
                for (Element td : tds) {
                    switch (cnt) {
                        case 0:
                            variableRentList.get(pos).setCode(td.text());
                            break;
                        case 1:
                            variableRentList.get(pos).setPublisher(td.text());
                            break;
                        case 2:
                            if (td.text().contains(".")) {
                                continue;
                            }
                            variableRentList.get(pos).setLastNegociated(Integer.valueOf(td.text().replace(",", "")));
                            break;
                        case 3:
                            variableRentList.get(pos).setPricePercentage(Float.valueOf(td.text().replace(",", "")));
                            break;
                        case 4:
                            variableRentList.get(pos).setTirPercentage(Float.valueOf(td.text().replace(",", "")));
                            break;
                    }
                    cnt++;
                }
            }
            System.out.println("Fixed Rent DOP Size: " + fixedRentDopList.size());
            System.out.println("Fixed Rent USD Size: " + fixedRentUsdList.size());
            System.out.println("Variable Rent Size: " + variableRentList.size());
            List<List> finalList = new ArrayList<>();
            finalList.add(fixedRentDopList);
            finalList.add(fixedRentUsdList);
            finalList.add(variableRentList);
            return finalList;
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<List> lists) {
      LocalStorage ls = new LocalStorage(context);
        ls.save(lists.get(0),LocalStorage.FIXED_RENT_DOP);
        ls.save(lists.get(1),LocalStorage.FIXED_RENT_USD);
        ls.save(lists.get(2),LocalStorage.VARIABLE_RENT_DOP);

    }
}