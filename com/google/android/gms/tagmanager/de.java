package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class de {
    private GoogleAnalytics aij;
    private Context mContext;
    private Tracker tP;

    static class C0936a implements Logger {
        C0936a() {
        }

        private static int dv(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            bh.m1646b("", exception);
        }

        public void error(String message) {
            bh.m1642A(message);
        }

        public int getLogLevel() {
            return C0936a.dv(bh.getLogLevel());
        }

        public void info(String message) {
            bh.m1643B(message);
        }

        public void setLogLevel(int logLevel) {
            bh.m1645D("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            bh.m1644C(message);
        }

        public void warn(String message) {
            bh.m1645D(message);
        }
    }

    de(Context context) {
        this.mContext = context;
    }

    private synchronized void cn(String str) {
        if (this.aij == null) {
            this.aij = GoogleAnalytics.getInstance(this.mContext);
            this.aij.setLogger(new C0936a());
            this.tP = this.aij.newTracker(str);
        }
    }

    public Tracker cm(String str) {
        cn(str);
        return this.tP;
    }
}
