/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsard.castlestudio.bolsard;

import android.os.AsyncTask;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *
 * @author malmonte
 */
public class Scrapper extends AsyncTask<Void,Void,Void>{

    public void scrap() {
        // TODO code application logic here
          String url = "http://bolsard.com/";
          try{
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
                for(Element e: table.select("tr.dop100")){
                    tds = e.select("td");
                    cnt = 0;
                        fixedRentDopList.add(new Result());
                        pos = fixedRentDopList.size() - 1;
                        for(Element td: tds){
                            switch(cnt){
                                case 0:
                                    fixedRentDopList.get(pos).setCodigo(td.text());
                                    break;
                                case 1:
                                    fixedRentDopList.get(pos).setEmisor(td.text());
                                    break;
                                case 2:
                                    if(td.text().contains(".")){
                                        continue;
                                    }
                                    fixedRentDopList.get(pos).setUltNegociado(Integer.valueOf(td.text().replace(",", "")));
                                    break;
                                case 3:
                                    fixedRentDopList.get(pos).setPrecioPorentaje(Float.valueOf(td.text().replace(",", "")));
                                    break;
                                case 4:
                                    fixedRentDopList.get(pos).setTirPorcentaje(Float.valueOf(td.text().replace(",", "")));
                                    break;
                            }
                            cnt++;
                        }
                }
              for(Element e: table.select("tr.usd100")){
                  tds = e.select("td");
                  cnt = 0;
                  fixedRentUsdList.add(new Result());
                  pos = fixedRentUsdList.size() - 1;
                  for(Element td: tds){
                      switch(cnt){
                          case 0:
                              fixedRentUsdList.get(pos).setCodigo(td.text());
                              break;
                          case 1:
                              fixedRentUsdList.get(pos).setEmisor(td.text());
                              break;
                          case 2:
                              if(td.text().contains(".")){
                                  continue;
                              }
                              fixedRentUsdList.get(pos).setUltNegociado(Integer.valueOf(td.text().replace(",", "")));
                              break;
                          case 3:
                              fixedRentUsdList.get(pos).setPrecioPorentaje(Float.valueOf(td.text().replace(",", "")));
                              break;
                          case 4:
                              fixedRentUsdList.get(pos).setTirPorcentaje(Float.valueOf(td.text().replace(",", "")));
                              break;
                      }
                      cnt++;
                  }
              }
              for(Element e: table.select("tr.dop101")){
                  tds = e.select("td");
                  cnt = 0;
                  variableRentList.add(new Result());
                  pos = variableRentList.size() - 1;
                  for(Element td: tds){
                      switch(cnt){
                          case 0:
                              variableRentList.get(pos).setCodigo(td.text());
                              break;
                          case 1:
                              variableRentList.get(pos).setEmisor(td.text());
                              break;
                          case 2:
                              if(td.text().contains(".")){
                                  continue;
                              }
                              variableRentList.get(pos).setUltNegociado(Integer.valueOf(td.text().replace(",", "")));
                              break;
                          case 3:
                              variableRentList.get(pos).setPrecioPorentaje(Float.valueOf(td.text().replace(",", "")));
                              break;
                          case 4:
                              variableRentList.get(pos).setTirPorcentaje(Float.valueOf(td.text().replace(",", "")));
                              break;
                      }
                      cnt++;
                  }
              }
              System.out.println("Fixed Rent DOP Size: " + fixedRentDopList.size());
              System.out.println("Fixed Rent USD Size: " + fixedRentUsdList.size());
              System.out.println("Variable Rent Size: " + variableRentList.size());
          }catch(IOException e){
              System.out.println("Error: " + e);
          }
    }

    @Override
    protected Void doInBackground(Void... params) {
        scrap();
        return null;
    }
}