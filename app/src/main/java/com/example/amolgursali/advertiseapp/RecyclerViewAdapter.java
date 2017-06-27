package com.example.amolgursali.advertiseapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.ArrayList;

/**
 * Created by AmolGursali on 6/21/2017.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    ArrayList<String> arrayList=new ArrayList<>();
    Context context;
    public static final int VIEW_TYPE=0;
    public static final int VIEW_TYPE_ad=1;

    public RecyclerViewAdapter(Context context, ArrayList<String> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if(viewType==VIEW_TYPE)
        {
            View v;
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cards,parent,false);
            return new RecyclerViewHolder(v);
        }
        else
        {
            View v;
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.nativeads,parent,false);
            return new RecyclerViewAds(v);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType()==VIEW_TYPE)
        {
            RecyclerViewHolder recyclerViewHolder=(RecyclerViewHolder)holder;
            recyclerViewHolder.textView.setText(arrayList.get(holder.getAdapterPosition()));
        }
        else
        {
            RecyclerViewAds recyclerViewAds=(RecyclerViewAds)holder;
            AdRequest adRequest=new AdRequest.Builder().addTestDevice("1B4F6AA196828585844E75727763F07F").addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
            recyclerViewAds.nativeExpressAdView.loadAd(adRequest);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(arrayList.get(position)==null)
        {
            return VIEW_TYPE_ad;
        }
        return VIEW_TYPE;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.number);
        }
    }

    private class RecyclerViewAds extends RecyclerView.ViewHolder {
        NativeExpressAdView nativeExpressAdView;
        public RecyclerViewAds(View v) {
            super(v);
            nativeExpressAdView=(NativeExpressAdView)v.findViewById(R.id.nativeads);
        }
    }
}
