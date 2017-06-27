package com.example.amolgursali.advertiseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class VideoAdsss extends AppCompatActivity implements RewardedVideoAdListener {

    RewardedVideoAd rewardedVideoAd;
    public static final String TAG=VideoAdsss.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_adsss);
        MobileAds.initialize(getApplicationContext(),getString(R.string.videoads));

        rewardedVideoAd=MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

        rewardedVideoAd.loadAd(getString(R.string.videoads),adRequest);
    }

    @Override
    protected void onPause() {
        rewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        rewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        rewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    @Override
    public void onRewardedVideoAdLoaded()
    {
        try
        {
            if(rewardedVideoAd.isLoaded())
            {
                rewardedVideoAd.show();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Log.i(TAG, "Rewarded: onRewardedVideoAdOpened");    }

    @Override
    public void onRewardedVideoStarted() {
        Log.i(TAG, "Rewarded: onRewardedVideoStarted");
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Log.i(TAG, "Rewarded: onRewardedVideoAdClosed");

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Log.i(TAG, "Rewarded:  onRewarded! currency: " + rewardItem.getType() + "  amount: " +
                rewardItem.getAmount());

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Log.i(TAG, "Rewarded: onRewardedVideoAdLeftApplication ");

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Log.i(TAG, "Rewarded: onRewardedVideoAdFailedToLoad: " + i);

    }
}
