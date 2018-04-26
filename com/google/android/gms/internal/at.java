package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class at {
    public static final String DEVICE_ID_EMULATOR = et.m1010y("emulator");
    private final Date f46d;
    private final Set<String> f47f;
    private final Location f48h;
    private final String mk;
    private final int ml;
    private final boolean mm;
    private final Bundle mn;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> mo;
    private final String mp;
    private final SearchAdRequest mq;
    private final int mr;
    private final Set<String> ms;

    public static final class C0271a {
        private Date f44d;
        private Location f45h;
        private String mk;
        private int ml = -1;
        private boolean mm = false;
        private final Bundle mn = new Bundle();
        private String mp;
        private int mr = -1;
        private final HashSet<String> mt = new HashSet();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> mu = new HashMap();
        private final HashSet<String> mv = new HashSet();

        public void m809a(Location location) {
            this.f45h = location;
        }

        @Deprecated
        public void m810a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                m811a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.mu.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void m811a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.mn.putBundle(cls.getName(), bundle);
        }

        public void m812a(Date date) {
            this.f44d = date;
        }

        public void m813b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.mn.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void m814e(int i) {
            this.ml = i;
        }

        public void m815g(String str) {
            this.mt.add(str);
        }

        public void m816g(boolean z) {
            this.mm = z;
        }

        public void m817h(String str) {
            this.mv.add(str);
        }

        public void m818h(boolean z) {
            this.mr = z ? 1 : 0;
        }

        public void m819i(String str) {
            this.mk = str;
        }

        public void m820j(String str) {
            this.mp = str;
        }
    }

    public at(C0271a c0271a) {
        this(c0271a, null);
    }

    public at(C0271a c0271a, SearchAdRequest searchAdRequest) {
        this.f46d = c0271a.f44d;
        this.mk = c0271a.mk;
        this.ml = c0271a.ml;
        this.f47f = Collections.unmodifiableSet(c0271a.mt);
        this.f48h = c0271a.f45h;
        this.mm = c0271a.mm;
        this.mn = c0271a.mn;
        this.mo = Collections.unmodifiableMap(c0271a.mu);
        this.mp = c0271a.mp;
        this.mq = searchAdRequest;
        this.mr = c0271a.mr;
        this.ms = Collections.unmodifiableSet(c0271a.mv);
    }

    public SearchAdRequest aH() {
        return this.mq;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> aI() {
        return this.mo;
    }

    public Bundle aJ() {
        return this.mn;
    }

    public int aK() {
        return this.mr;
    }

    public Date getBirthday() {
        return this.f46d;
    }

    public String getContentUrl() {
        return this.mk;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass) {
        Bundle bundle = this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(adapterClass.getClass().getName()) : null;
    }

    public int getGender() {
        return this.ml;
    }

    public Set<String> getKeywords() {
        return this.f47f;
    }

    public Location getLocation() {
        return this.f48h;
    }

    public boolean getManualImpressionsEnabled() {
        return this.mm;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.mo.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass) {
        return this.mn.getBundle(adapterClass.getName());
    }

    public String getPublisherProvidedId() {
        return this.mp;
    }

    public boolean isTestDevice(Context context) {
        return this.ms.contains(et.m1009r(context));
    }
}
