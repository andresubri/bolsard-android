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
                ArrayList<RentaFijaRD> rfs = new ArrayList();
                System.out.println("Scrapping data...");
                for(Element e: table){
                    tds = e.select("td");
                    cnt = 0;
                    rfs.add(new RentaFijaRD());
                    pos = rfs.size() - 1;
                    for(Element td: tds){
                        switch(cnt){
                            case 0:
                                rfs.get(pos).setCodigo(td.text());
                                break;
                            case 1:
                                rfs.get(pos).setEmisor(td.text());
                                break;
                            case 2:
                                if(td.text().contains(".")){
                                    continue;
                                }
                                rfs.get(pos).setUltNegociado(Integer.valueOf(td.text().replace(",", "")));
                                break;
                            case 3:
                                rfs.get(pos).setPrecioPorentaje(Float.valueOf(td.text().replace(",", "")));
                                break;
                            case 4:
                                rfs.get(pos).setTirPorcentaje(Float.valueOf(td.text().replace(",", "")));
                                break;
                                
                        }
                        cnt++;
                    }
                }
              System.out.println("Rows scrapped: " + rfs.size());
              Gson gson = new Gson();
              String json = gson.toJson(rfs);
              System.out.println("Converted to json: " + json);
              try (PrintWriter writer = new PrintWriter("data.json", "UTF-8")) {
                  writer.println(json);
              }
              
              System.out.println("Finished. File is data.json in the current directory.");
                
                
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