package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.C0138u.C0137a;
import com.google.android.gms.analytics.GoogleAnalytics.C0105a;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
    private Context mContext;
    private final TrackerHandler xe;
    private final Map<String, String> xf;
    private ad xg;
    private final C0583h xh;
    private final ae xi;
    private final C0582g xj;
    private boolean xk;
    private C0577a xl;
    private aj xm;
    private ExceptionReporter xn;

    private class C0577a implements C0105a {
        private C0116i uu;
        private boolean xo = false;
        private int xp = 0;
        private long xq = -1;
        private boolean xr = false;
        private long xs;
        final /* synthetic */ Tracker xt;

        public C0577a(final Tracker tracker) {
            this.xt = tracker;
            this.uu = new C0116i(this) {
                final /* synthetic */ C0577a xv;

                public long currentTimeMillis() {
                    return System.currentTimeMillis();
                }
            };
        }

        private void dB() {
            GoogleAnalytics di = GoogleAnalytics.di();
            if (di == null) {
                aa.m37A("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.xq >= 0 || this.xo) {
                di.m1863a(this.xt.xl);
            } else {
                di.m1865b(this.xt.xl);
            }
        }

        public boolean dA() {
            boolean z = this.xr;
            this.xr = false;
            return z;
        }

        boolean dC() {
            return this.uu.currentTimeMillis() >= this.xs + Math.max(1000, this.xq);
        }

        public long dy() {
            return this.xq;
        }

        public boolean dz() {
            return this.xo;
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.xo = enabled;
            dB();
        }

        public void mo834h(Activity activity) {
            C0138u.cU().m83a(C0137a.EASY_TRACKER_ACTIVITY_START);
            if (this.xp == 0 && dC()) {
                this.xr = true;
            }
            this.xp++;
            if (this.xo) {
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                C0138u.cU().m84u(true);
                this.xt.set("&cd", this.xt.xm != null ? this.xt.xm.m1901j(activity) : activity.getClass().getCanonicalName());
                this.xt.send(hashMap);
                C0138u.cU().m84u(false);
            }
        }

        public void mo835i(Activity activity) {
            C0138u.cU().m83a(C0137a.EASY_TRACKER_ACTIVITY_STOP);
            this.xp--;
            this.xp = Math.max(0, this.xp);
            if (this.xp == 0) {
                this.xs = this.uu.currentTimeMillis();
            }
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.xq = sessionTimeout;
            dB();
        }
    }

    Tracker(String trackingId, TrackerHandler handler, Context context) {
        this(trackingId, handler, C0583h.cv(), ae.dv(), C0582g.cu(), new C0593z("tracking"), context);
    }

    Tracker(String trackingId, TrackerHandler handler, C0583h clientIdDefaultProvider, ae screenResolutionDefaultProvider, C0582g appFieldsDefaultProvider, ad rateLimiter, Context context) {
        this.xf = new HashMap();
        this.xe = handler;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        if (trackingId != null) {
            this.xf.put("&tid", trackingId);
        }
        this.xf.put("useSecure", "1");
        this.xh = clientIdDefaultProvider;
        this.xi = screenResolutionDefaultProvider;
        this.xj = appFieldsDefaultProvider;
        this.xf.put("&a", Integer.toString(new Random().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        this.xg = rateLimiter;
        this.xl = new C0577a(this);
        enableAdvertisingIdCollection(false);
    }

    void m35a(aj ajVar) {
        aa.m39C("Loading Tracker config values.");
        this.xm = ajVar;
        if (this.xm.dE()) {
            String dF = this.xm.dF();
            set("&tid", dF);
            aa.m39C("[Tracker] trackingId loaded: " + dF);
        }
        if (this.xm.dG()) {
            dF = Double.toString(this.xm.dH());
            set("&sf", dF);
            aa.m39C("[Tracker] sample frequency loaded: " + dF);
        }
        if (this.xm.dI()) {
            setSessionTimeout((long) this.xm.getSessionTimeout());
            aa.m39C("[Tracker] session timeout loaded: " + dy());
        }
        if (this.xm.dJ()) {
            enableAutoActivityTracking(this.xm.dK());
            aa.m39C("[Tracker] auto activity tracking loaded: " + dz());
        }
        if (this.xm.dL()) {
            if (this.xm.dM()) {
                set("&aip", "1");
                aa.m39C("[Tracker] anonymize ip loaded: true");
            }
            aa.m39C("[Tracker] anonymize ip loaded: false");
        }
        enableExceptionReporting(this.xm.dN());
    }

    long dy() {
        return this.xl.dy();
    }

    boolean dz() {
        return this.xl.dz();
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (enabled) {
            if (this.xf.containsKey("&ate")) {
                this.xf.remove("&ate");
            }
            if (this.xf.containsKey("&adid")) {
                this.xf.remove("&adid");
                return;
            }
            return;
        }
        this.xf.put("&ate", null);
        this.xf.put("&adid", null);
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.xl.enableAutoActivityTracking(enabled);
    }

    public void enableExceptionReporting(boolean enabled) {
        if (this.xk != enabled) {
            this.xk = enabled;
            if (enabled) {
                this.xn = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
                Thread.setDefaultUncaughtExceptionHandler(this.xn);
                aa.m39C("Uncaught exceptions will be reported to Google Analytics.");
                return;
            }
            if (this.xn != null) {
                Thread.setDefaultUncaughtExceptionHandler(this.xn.cD());
            } else {
                Thread.setDefaultUncaughtExceptionHandler(null);
            }
            aa.m39C("Uncaught exceptions will not be reported to Google Analytics.");
        }
    }

    public String get(String key) {
        C0138u.cU().m83a(C0137a.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.xf.containsKey(key)) {
            return (String) this.xf.get(key);
        }
        if (key.equals("&ul")) {
            return ak.m51a(Locale.getDefault());
        }
        if (this.xh != null && this.xh.m1916J(key)) {
            return this.xh.getValue(key);
        }
        if (this.xi == null || !this.xi.m1888J(key)) {
            return (this.xj == null || !this.xj.m1910J(key)) ? null : this.xj.getValue(key);
        } else {
            return this.xi.getValue(key);
        }
    }

    public void send(Map<String, String> params) {
        C0138u.cU().m83a(C0137a.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.xf);
        if (params != null) {
            hashMap.putAll(params);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            aa.m40D(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str)) {
            aa.m40D(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str = "";
        }
        if (this.xl.dA()) {
            hashMap.put("&sc", "start");
        }
        String toLowerCase = str.toLowerCase();
        if ("screenview".equals(toLowerCase) || "pageview".equals(toLowerCase) || "appview".equals(toLowerCase) || TextUtils.isEmpty(toLowerCase)) {
            int parseInt = Integer.parseInt((String) this.xf.get("&a")) + 1;
            if (parseInt >= ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                parseInt = 1;
            }
            this.xf.put("&a", Integer.toString(parseInt));
        }
        if (toLowerCase.equals("transaction") || toLowerCase.equals("item") || this.xg.mo879do()) {
            this.xe.mo830p(hashMap);
        } else {
            aa.m40D("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        hm.m1228b((Object) key, (Object) "Key should be non-null");
        C0138u.cU().m83a(C0137a.SET);
        this.xf.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", ak.m54v(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toHexString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            aa.m40D("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.xl.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", ak.m54v(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }
}
