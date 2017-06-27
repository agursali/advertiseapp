# advertiseapp
In this example you can see different types of ads likewise Banner,Interestitial Ads,Native Ads and Video Ads.


In Banner Ads, you can add this ad to the top or bottom of the layout.
The Interestitial Ads will  occupies the entire page of the layout.
The Native Ads will be added within the recyclerview items and
video ads that will show you video ads.



Note : You will have to create your own Admob account from developer admob console , Select Different types of ads like Banner, Interestitial, Native and Video Ads.Select particular ads from admob console and you will get different KEY for different ADS.

In Your case you won't need any google-services.json file.In My case i have synced Admob account and firebase account so i have created for that purpose.

use of google-services.json

google-services.json contains developer credentials and configuration settings, which is needed to verify while connecting with GoogleApiClient. Though your service is working fine with your test device as it is detecting your developer account but after releasing your app in public, it will not work without the json file. So don't delete it.
