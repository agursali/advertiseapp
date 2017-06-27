package com.example.amolgursali.advertiseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.ArrayList;

public class NativeAd extends AppCompatActivity {

//    NativeExpressAdView nativeExpressAdView;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    ArrayList<String> arrayList;
    RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ad);
//        nativeExpressAdView=(NativeExpressAdView)findViewById(R.id.nativeads);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview) ;
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            if(i%5==0)
            {
                arrayList.add(null);
            }
            arrayList.add("Card Number"+i);
        }
        recyclerViewAdapter=new RecyclerViewAdapter(getApplicationContext(),arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
     /*   AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        nativeExpressAdView.loadAd(adRequest);*/
    }
}
