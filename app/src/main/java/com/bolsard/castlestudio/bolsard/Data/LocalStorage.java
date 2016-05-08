package com.bolsard.castlestudio.bolsard.Data;

import android.content.Context;
import android.content.SharedPreferences;

import com.bolsard.castlestudio.bolsard.Models.EmissionsResult;
import com.bolsard.castlestudio.bolsard.Models.StatisticResult;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andriusic on 01/05/16.
 */
public class LocalStorage {
    public static final String PREFS_NAME = "LOCAL_STORAGE";
    public static final String EMISSIONS_FIXED_RENT_DOP = "EMISSIONS_FIXED_RENT_DOP";
    public static final String EMISSIONS_FIXED_RENT_USD = "EMISSIONS_FIXED_RENT_USD";
    public static final String EMISSIONS_VARIABLE_RENT_DOP = "EMISSIONS_VARIABLE_RENT_DOP";
    public static final String STATISTICS_FIXED_RENT_DOP = "STATISTICS_FIXED_RENT_DOP";
    public static final String STATISTICS_FIXED_RENT_USD = "STATISTICS_FIXED_RENT_USD";
    public static final String STATISTICS_INVESTMENT_FOUNDS_DOP = "STATISTICS_INVESTMENT_FOUNDS_DOP";
    public static final String STATISTICS_INVESTMENT_FOUNDS_USD = "STATISTICS_INVESTMENT_FOUNDS_USD";
    public List<EmissionsResult> emissionsResultList;
    public List<StatisticResult> statisticResultList;
    public SharedPreferences settings;
    public Context context;

    public LocalStorage(Context context) {
        this.context = context;
        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);    }

    public void save(List<?> saveList, String keyName){

        SharedPreferences.Editor editor;
        Gson gson = new Gson();
        String jsonResult = gson.toJson(saveList);
        switch (keyName){
            case EMISSIONS_FIXED_RENT_DOP:
                editor = settings.edit();
                editor.putString(EMISSIONS_FIXED_RENT_DOP,jsonResult);
                editor.commit();
                break;

            case EMISSIONS_FIXED_RENT_USD:
                editor = settings.edit();
                editor.putString(EMISSIONS_FIXED_RENT_USD,jsonResult);
                editor.commit();
                break;

            case EMISSIONS_VARIABLE_RENT_DOP:
                editor = settings.edit();
                editor.putString(EMISSIONS_VARIABLE_RENT_DOP,jsonResult);
                editor.commit();
                break;
            case STATISTICS_FIXED_RENT_DOP:
                editor = settings.edit();
                editor.putString(STATISTICS_FIXED_RENT_DOP,jsonResult);
                editor.commit();
                break;
            case STATISTICS_FIXED_RENT_USD:
                editor = settings.edit();
                editor.putString(STATISTICS_FIXED_RENT_USD,jsonResult);
                editor.commit();
                break;
            case STATISTICS_INVESTMENT_FOUNDS_DOP:
                editor = settings.edit();
                editor.putString(STATISTICS_INVESTMENT_FOUNDS_DOP,jsonResult);
                editor.commit();
                break;
            case STATISTICS_INVESTMENT_FOUNDS_USD:
                editor = settings.edit();
                editor.putString(STATISTICS_INVESTMENT_FOUNDS_USD,jsonResult);
                editor.commit();
                break;
        }
    }

    public List<StatisticResult> getStatisticResult(String keyName){
        Gson gson = new Gson();
        switch (keyName){
        case STATISTICS_FIXED_RENT_DOP:
        if(settings.contains(STATISTICS_FIXED_RENT_DOP)) {
            String jsonResult = settings.getString(STATISTICS_FIXED_RENT_DOP, null);
            StatisticResult[] items = gson.fromJson(jsonResult, StatisticResult[].class);
            statisticResultList = Arrays.asList(items);
            statisticResultList = new ArrayList<>(statisticResultList);
            return statisticResultList;
        }else
            return null;

        case STATISTICS_FIXED_RENT_USD:
        if(settings.contains(STATISTICS_FIXED_RENT_USD)) {
            String jsonResult = settings.getString(STATISTICS_FIXED_RENT_USD, null);
            StatisticResult[] items = gson.fromJson(jsonResult, StatisticResult[].class);
            statisticResultList = Arrays.asList(items);
            statisticResultList = new ArrayList<>(statisticResultList);
            return statisticResultList;
        }else
            return null;

        case STATISTICS_INVESTMENT_FOUNDS_DOP:
        if(settings.contains(STATISTICS_INVESTMENT_FOUNDS_DOP)) {
            String jsonResult = settings.getString(STATISTICS_INVESTMENT_FOUNDS_DOP, null);
            StatisticResult[] items = gson.fromJson(jsonResult, StatisticResult[].class);
            statisticResultList = Arrays.asList(items);
            statisticResultList = new ArrayList<>(statisticResultList);
            return statisticResultList;
        }else
            return null;

        case STATISTICS_INVESTMENT_FOUNDS_USD:
        if(settings.contains(STATISTICS_INVESTMENT_FOUNDS_USD)) {
            String jsonResult = settings.getString(STATISTICS_INVESTMENT_FOUNDS_USD, null);
            StatisticResult[] items = gson.fromJson(jsonResult, StatisticResult[].class);
            statisticResultList = Arrays.asList(items);
            statisticResultList = new ArrayList<>(statisticResultList);
            return statisticResultList;
        }else
            return null;

        }
        return statisticResultList;
    }

    public List<EmissionsResult> getEmissionsResult(String keyName){
        Gson gson = new Gson();
        switch (keyName){
            case EMISSIONS_FIXED_RENT_DOP:
                if(settings.contains(EMISSIONS_FIXED_RENT_DOP)) {
                    String jsonResult = settings.getString(EMISSIONS_FIXED_RENT_DOP, null);
                    EmissionsResult[] items = gson.fromJson(jsonResult, EmissionsResult[].class);
                    emissionsResultList = Arrays.asList(items);
                    emissionsResultList = new ArrayList<>(emissionsResultList);
                    return emissionsResultList;
                }else{
                    return null;
                }

            case EMISSIONS_FIXED_RENT_USD:
                if(settings.contains(EMISSIONS_FIXED_RENT_USD)) {
                    String jsonResult = settings.getString(EMISSIONS_FIXED_RENT_USD, null);
                    EmissionsResult[] items = gson.fromJson(jsonResult, EmissionsResult[].class);
                    emissionsResultList = Arrays.asList(items);
                    emissionsResultList = new ArrayList<>(emissionsResultList);
                    return emissionsResultList;
                }else
                    return null;

            case EMISSIONS_VARIABLE_RENT_DOP:
                if(settings.contains(EMISSIONS_VARIABLE_RENT_DOP)) {
                    String jsonResult = settings.getString(EMISSIONS_VARIABLE_RENT_DOP, null);
                    EmissionsResult[] items = gson.fromJson(jsonResult, EmissionsResult[].class);
                    emissionsResultList = Arrays.asList(items);
                    emissionsResultList = new ArrayList<>(emissionsResultList);
                    return emissionsResultList;
                }else
                    return null;
        }
        return emissionsResultList;
    }

}
