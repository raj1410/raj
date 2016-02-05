package com.example.surpreet.surpreet_kaur300814616asst7;

import android.support.v7.app.AppCompatActivity;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ComponentName;
import android.os.IBinder;
import android.content.ServiceConnection;


public class ServicesActivity extends AppCompatActivity {
    public  TextView textView;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        textView = (TextView) findViewById(R.id.tv);
       // textView.setText("Sur");

    }
    //This will handle the broadcast
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        //@Override
        public void onReceive(Context context, Intent intent) {
            //textView.setText("Here");
            String action = intent.getAction();
            if (action.equals(MySimpleService.INFO_INTENT)) {
                String info = intent.getStringExtra("com.example.surpreet.surpreet_kaur300814616asst7");
               textView.setText(info);

            }
        }
    };

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MySimpleService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(),
                MySimpleService.class));
    }

    public void onResume()
    {
        super.onResume();
        //This needs to be in the activity that will end up receiving the broadcast
        registerReceiver(receiver, new IntentFilter("com.example.surpreet.surpreet_kaur300814616asst7"));

    }

}

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_services, menu);
        return true;
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
}*/
