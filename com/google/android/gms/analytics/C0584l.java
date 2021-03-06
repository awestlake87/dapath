package com.google.android.gms.analytics;

import android.util.Log;

class C0584l implements Logger {
    private int tN = 1;

    C0584l() {
    }

    private String m1917L(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public void error(Exception exception) {
        if (this.tN <= 3) {
            Log.e("GAV4", null, exception);
        }
    }

    public void error(String msg) {
        if (this.tN <= 3) {
            Log.e("GAV4", m1917L(msg));
        }
    }

    public int getLogLevel() {
        return this.tN;
    }

    public void info(String msg) {
        if (this.tN <= 1) {
            Log.i("GAV4", m1917L(msg));
        }
    }

    public void setLogLevel(int level) {
        this.tN = level;
    }

    public void verbose(String msg) {
        if (this.tN <= 0) {
            Log.v("GAV4", m1917L(msg));
        }
    }

    public void warn(String msg) {
        if (this.tN <= 2) {
            Log.w("GAV4", m1917L(msg));
        }
    }
}
