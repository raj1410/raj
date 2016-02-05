package com.example.surpreet.surpreet_kaur300814616asst7;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Surpreet on 12/4/2015.
 */
public class MySimpleService extends Service{
    public static final String INFO_INTENT = "com.example.surpreet.surpreet_kaur300814616asst7";
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(INFO_INTENT);
        broadcastIntent.putExtra(INFO_INTENT, "Hello There");
        this.sendBroadcast(broadcastIntent);

        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

}

