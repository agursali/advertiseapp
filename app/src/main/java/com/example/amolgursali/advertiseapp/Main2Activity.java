package com.example.amolgursali.advertiseapp;

import android.*;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Main2Activity extends AppCompatActivity {

    public static final String TAG=Main2Activity.class.getSimpleName();
    InterstitialAd interstitialAd;
    public static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE=0;

    //    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermission();
        setContentView(R.layout.activity_main2);
        interstitialAd=new InterstitialAd(this);
       /* adView.setAdUnitId(getString(R.string.interstitialadsunitID));
        adView.setAdSize(AdSize.BANNER);*/
        interstitialAd.setAdUnitId(getString(R.string.interstitialadsunitID));
//        adView=(AdView)findViewById(R.id.adView);

        AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("730C414F3AA2CF46340A7DDF43285CD9").build();

//        adView.loadAd(adRequest);
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded() {
                if(interstitialAd.isLoaded())
                {
                    interstitialAd.show();
                }
            }
        });

    }
    private void checkPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(Main2Activity.this,
                android.Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Main2Activity.this,
                    android.Manifest.permission.READ_PHONE_STATE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(Main2Activity.this,
                        new String[]{android.Manifest.permission.READ_PHONE_STATE},
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

}
