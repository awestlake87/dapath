package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {
    CampaignTrackingService afQ;
    Context afR;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String name) {
        super(name);
    }

    private void m1610a(Context context, Intent intent) {
        if (this.afQ == null) {
            this.afQ = new CampaignTrackingService();
        }
        this.afQ.processIntent(context, intent);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.afR != null ? this.afR : getApplicationContext();
        ay.m1634d(applicationContext, stringExtra);
        m1610a(applicationContext, intent);
    }
}
