package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

//        AdView mAdView = new AdView(getContext());
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
//        AdSize adSize = new AdSize(280 , 50);
//        mAdView.setAdSize(adSize);
//        mAdView.setAdUnitId(getString(R.string.banner_ad_unit_id));
//        AdSize adSize = new AdSize(280 , 50);
//        mAdView.setAdSize(AdSize.SMART_BANNER);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("ABCDEF012345")
                .build();

        mAdView.loadAd(adRequest);
        return root;
    }
}
