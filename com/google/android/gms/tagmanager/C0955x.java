package com.google.android.gms.tagmanager;

import android.util.Log;

class C0955x implements bi {
    private int tN = 5;

    C0955x() {
    }

    public void mo2353A(String str) {
        if (this.tN <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void mo2354B(String str) {
        if (this.tN <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void mo2355C(String str) {
        if (this.tN <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void mo2356D(String str) {
        if (this.tN <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void mo2357b(String str, Throwable th) {
        if (this.tN <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void mo2358c(String str, Throwable th) {
        if (this.tN <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(int logLevel) {
        this.tN = logLevel;
    }

    public void mo2360z(String str) {
        if (this.tN <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }
}
