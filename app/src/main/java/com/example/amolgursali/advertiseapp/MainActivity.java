package com.example.amolgursali.advertiseapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    AdView adView;
    Button button,nativeads,videoAds;
    public static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermission();
        setContentView(R.layout.activity_main);
        adView=(AdView)findViewById(R.id.adView);
        button=(Button)findViewById(R.id.button);
        nativeads=(Button)findViewById(R.id.nativeads);
        videoAds=(Button)findViewById(R.id.videoads);
      /*  String android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);*/
      /*  final TelephonyManager tm =(TelephonyManager)getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);

        String deviceid = tm.getDeviceId();*/
//        AdRequest adRequest=new AdRequest.Builder().addTestDevice(deviceid).addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        // add your own device ID below
        AdRequest adRequest=new AdRequest.Builder().addTestDevice("730C414F3AA2CF46340A7DDF43285CD9").addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

        // when we already launced application then we will have to set below format otherwise we will have to setabove format
//        AdRequest adRequest=new AdRequest.Builder().build();




//        adView.setAdUnitId(getString(R.string.adunitadd));
//        adView.setAdSize(AdSize.BANNER);
        adView.loadAd(adRequest);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
        nativeads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NativeAd.class));
            }
        });
        videoAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VideoAdsss.class));

            }
        });

    }
    private void checkPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_PHONE_STATE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);

                // MY_PERMISSIONS_REQUEST_READ_PHONE_STATE is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_PHONE_STATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
