package com.castlestudio.bolsard.Data;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.castlestudio.bolsard.R;
import java.net.InetAddress;
import java.util.TooManyListenersException;

/**
 * Created by andriusic on 01/06/16.
 */
public class NetworkHelper  extends AsyncTask<Void,Boolean, Boolean>{
    Context context;
    Toolbar toolbar;
    public NetworkHelper(Context context, Toolbar toolbar){
        this.context = context;
        this.toolbar = toolbar;
    }
    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com"); //You can replace it with your name

            if (ipAddr.equals("")) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if(activeNetwork != null && activeNetwork.isConnected() && aBoolean){
            new StatisticsScrapper(context,toolbar).execute();
            new EmissionsScrapper(context).execute();
        }else{
            Snackbar.make(toolbar, R.string.connection_error_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.connection_settings, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        }
                    })
                    .setActionTextColor(context.getResources().getColor(android.R.color.holo_red_light ))
                    .show();
        }
        super.onPostExecute(aBoolean);
    }
}
