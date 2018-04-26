package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.df.C0707a;

public final class cw extends C0707a implements ServiceConnection {
    private Context mContext;
    private cr oY;
    private String pf;
    private cv pj;
    private boolean po = false;
    private int pp;
    private Intent pq;

    public cw(Context context, String str, boolean z, int i, Intent intent, cv cvVar) {
        this.pf = str;
        this.pp = i;
        this.pq = intent;
        this.po = z;
        this.mContext = context;
        this.pj = cvVar;
    }

    public void finishPurchase() {
        int c = cy.m880c(this.pq);
        if (this.pp == -1 && c == 0) {
            this.oY = new cr(this.mContext);
            Context context = this.mContext;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context context2 = this.mContext;
            context.bindService(intent, this, 1);
        }
    }

    public String getProductId() {
        return this.pf;
    }

    public Intent getPurchaseData() {
        return this.pq;
    }

    public int getResultCode() {
        return this.pp;
    }

    public boolean isVerified() {
        return this.po;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        eu.m1012B("In-app billing service connected.");
        this.oY.m873o(service);
        String q = cy.m884q(cy.m881d(this.pq));
        if (q != null) {
            if (this.oY.m870a(this.mContext.getPackageName(), q) == 0) {
                cx.m874k(this.mContext).m876a(this.pj);
            }
            this.mContext.unbindService(this);
            this.oY.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        eu.m1012B("In-app billing service disconnected.");
        this.oY.destroy();
    }
}
