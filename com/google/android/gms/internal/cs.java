package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cs extends em implements ServiceConnection {
    private final Object ls = new Object();
    private Context mContext;
    private boolean oW = false;
    private dg oX;
    private cr oY;
    private cx oZ;
    private List<cv> pa = null;
    private cz pb;

    public cs(Context context, dg dgVar, cz czVar) {
        this.mContext = context;
        this.oX = dgVar;
        this.pb = czVar;
        this.oY = new cr(context);
        this.oZ = cx.m874k(this.mContext);
        this.pa = this.oZ.m878d(10);
    }

    private void m2522a(final cv cvVar, String str, String str2) {
        final Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        et.sv.post(new Runnable(this) {
            final /* synthetic */ cs pe;

            public void run() {
                try {
                    if (this.pe.pb.m885a(cvVar.pm, -1, intent)) {
                        this.pe.oX.mo1680a(new cw(this.pe.mContext, cvVar.pn, true, -1, intent, cvVar));
                    } else {
                        this.pe.oX.mo1680a(new cw(this.pe.mContext, cvVar.pn, false, -1, intent, cvVar));
                    }
                } catch (RemoteException e) {
                    eu.m1014D("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    private void m2524b(long j) {
        do {
            if (!m2526c(j)) {
                eu.m1014D("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.oW);
    }

    private void bi() {
        if (!this.pa.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (cv cvVar : this.pa) {
                hashMap.put(cvVar.pn, cvVar);
            }
            String str = null;
            while (true) {
                Bundle b = this.oY.m872b(this.mContext.getPackageName(), str);
                if (b == null || cy.m879a(b) != 0) {
                    break;
                }
                ArrayList stringArrayList = b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = b.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = b.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        cv cvVar2 = (cv) hashMap.get(str);
                        if (cvVar2.pm.equals(cy.m883p(str2))) {
                            m2522a(cvVar2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.oZ.m876a((cv) hashMap.get(str4));
            }
        }
    }

    private boolean m2526c(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.ls.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            eu.m1014D("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void bh() {
        synchronized (this.ls) {
            Context context = this.mContext;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context context2 = this.mContext;
            context.bindService(intent, this, 1);
            m2524b(SystemClock.elapsedRealtime());
            this.mContext.unbindService(this);
            this.oY.destroy();
        }
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.ls) {
            this.oY.m873o(service);
            bi();
            this.oW = true;
            this.ls.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        eu.m1012B("In-app billing service disconnected.");
        this.oY.destroy();
    }

    public void onStop() {
        synchronized (this.ls) {
            this.mContext.unbindService(this);
            this.oY.destroy();
        }
    }
}
