package com.bolsard.castlestudio.bolsard;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andriusic on 01/05/16.
 */
public class LocalStorage {
    public static final String PREFS_NAME = "LOCAL_STORAGE";
    public static final String FIXED_RENT_DOP = "FIXED_RENT_DOP";
    public static final String FIXED_RENT_USD = "FIXED_RENT_USD";
    public static final String VARIABLE_RENT_DOP = "VARIABLE_RENT_DOP";
    public List<Result> list;
    SharedPreferences settings;
    Context context;

    public LocalStorage(Context context) {
        this.context = context;
        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);    }

    public void save(List<Result> saveList, String keyName){
        SharedPreferences.Editor editor;

        Gson gson = new Gson();
        String jsonResult = gson.toJson(saveList);
        switch (keyName){
            case FIXED_RENT_DOP:
                editor = settings.edit();
                editor.putString(FIXED_RENT_DOP,jsonResult);
                editor.commit();
                break;

            case FIXED_RENT_USD:
                editor = settings.edit();
                editor.putString(FIXED_RENT_USD,jsonResult);
                editor.commit();
                break;

            case VARIABLE_RENT_DOP:
                editor = settings.edit();
                editor.putString(VARIABLE_RENT_DOP,jsonResult);
                editor.commit();
                break;
        }
    }
    public List<Result> get(String keyName){
        Gson gson = new Gson();

        switch (keyName){
            case FIXED_RENT_DOP:
                if(settings.contains(FIXED_RENT_DOP)) {
                    String jsonResult = settings.getString(FIXED_RENT_DOP, null);
                    Result[] items = gson.fromJson(jsonResult, Result[].class);
                    list = Arrays.asList(items);
                    list = new ArrayList<>(list);
                    return list;
                }else{
                    return null;
                }

            case FIXED_RENT_USD:
                if(settings.contains(FIXED_RENT_USD)) {
                    String jsonResult = settings.getString(FIXED_RENT_USD, null);
                    Result[] items = gson.fromJson(jsonResult, Result[].class);
                    list = Arrays.asList(items);
                    list = new ArrayList<>(list);
                    return list;
                }else
                    return null;

            case VARIABLE_RENT_DOP:
                if(settings.contains(VARIABLE_RENT_DOP)) {
                    String jsonResult = settings.getString(VARIABLE_RENT_DOP, null);
                    Result[] items = gson.fromJson(jsonResult, Result[].class);
                    list = Arrays.asList(items);
                    list = new ArrayList<>(list);
                    return list;
                }else
                    return null;
        }
        return list;
    }

}
