package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0119k.C0118a;

class C0591v extends C0119k<C0592w> {

    private static class C0590a implements C0118a<C0592w> {
        private final C0592w wi = new C0592w();

        public void mo844a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.wi.wk = i;
            } else {
                aa.m40D("int configuration name not recognized:  " + str);
            }
        }

        public void mo845c(String str, String str2) {
        }

        public void mo846c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.wi.wl = z ? 1 : 0;
                return;
            }
            aa.m40D("bool configuration name not recognized:  " + str);
        }

        public /* synthetic */ C0117j cB() {
            return cX();
        }

        public C0592w cX() {
            return this.wi;
        }

        public void mo848d(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.wi.tC = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.wi.tD = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.wi.wj = str2;
            } else {
                aa.m40D("string configuration name not recognized:  " + str);
            }
        }
    }

    public C0591v(Context context) {
        super(context, new C0590a());
    }
}
