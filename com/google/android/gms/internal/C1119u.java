package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.aq.C0674a;
import com.google.android.gms.internal.dm.C0297a;
import com.google.android.gms.internal.ds.C0306a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class C1119u extends C0674a implements ba, bd, bf, bn, ci, cl, C0297a, ej, C0372t {
    private final bt kB;
    private final C0375c kC;
    private final C0379y kD;
    private final ab kE;
    private boolean kF;
    private final ComponentCallbacks kG = new C03731(this);

    class C03731 implements ComponentCallbacks {
        final /* synthetic */ C1119u kH;

        C03731(C1119u c1119u) {
            this.kH = c1119u;
        }

        public void onConfigurationChanged(Configuration newConfig) {
            if (this.kH.kC != null && this.kH.kC.kU != null && this.kH.kC.kU.oy != null) {
                this.kH.kC.kU.oy.bX();
            }
        }

        public void onLowMemory() {
        }
    }

    private static final class C0374a extends ViewSwitcher {
        private final ep kI;

        public C0374a(Context context) {
            super(context);
            this.kI = new ep(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.kI.m995c(event);
            return false;
        }
    }

    private static final class C0375c {
        public final C0374a kM;
        public final String kN;
        public final Context kO;
        public final C0359k kP;
        public final ev kQ;
        public ap kR;
        public em kS;
        public al kT;
        public ef kU;
        public eg kV;
        public as kW;
        public dg kX;
        public dc kY;
        public cz kZ;
        public ek la = null;
        public boolean lb = false;
        private HashSet<eg> lc = null;

        public C0375c(Context context, al alVar, String str, ev evVar) {
            if (alVar.mf) {
                this.kM = null;
            } else {
                this.kM = new C0374a(context);
                this.kM.setMinimumWidth(alVar.widthPixels);
                this.kM.setMinimumHeight(alVar.heightPixels);
                this.kM.setVisibility(4);
            }
            this.kT = alVar;
            this.kN = str;
            this.kO = context;
            this.kQ = evVar;
            this.kP = new C0359k(new C0798b(this));
        }

        public void m1466a(HashSet<eg> hashSet) {
            this.lc = hashSet;
        }

        public HashSet<eg> aq() {
            return this.lc;
        }
    }

    private static final class C0798b implements C0331g, Runnable {
        private C0375c kC;
        private final List<Object[]> kJ = new Vector();
        private final CountDownLatch kK = new CountDownLatch(1);
        private final AtomicReference<C0331g> kL = new AtomicReference();

        public C0798b(C0375c c0375c) {
            this.kC = c0375c;
            if (et.bW()) {
                en.execute(this);
            } else {
                run();
            }
        }

        private void ao() {
            try {
                this.kK.await();
            } catch (Throwable e) {
                eu.m1017c("Interrupted during GADSignals creation.", e);
            }
        }

        private void ap() {
            if (!this.kJ.isEmpty()) {
                for (Object[] objArr : this.kJ) {
                    if (objArr.length == 1) {
                        ((C0331g) this.kL.get()).mo1743a((MotionEvent) objArr[0]);
                    } else if (objArr.length == 3) {
                        ((C0331g) this.kL.get()).mo1742a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                    }
                }
            }
        }

        public String mo1740a(Context context) {
            ao();
            if (this.kL.get() == null) {
                return "";
            }
            ap();
            return ((C0331g) this.kL.get()).mo1740a(context);
        }

        public String mo1741a(Context context, String str) {
            ao();
            if (this.kL.get() == null) {
                return "";
            }
            ap();
            return ((C0331g) this.kL.get()).mo1741a(context, str);
        }

        public void mo1742a(int i, int i2, int i3) {
            C0331g c0331g = (C0331g) this.kL.get();
            if (c0331g != null) {
                ap();
                c0331g.mo1742a(i, i2, i3);
                return;
            }
            this.kJ.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }

        public void mo1743a(MotionEvent motionEvent) {
            C0331g c0331g = (C0331g) this.kL.get();
            if (c0331g != null) {
                ap();
                c0331g.mo1743a(motionEvent);
                return;
            }
            this.kJ.add(new Object[]{motionEvent});
        }

        public String mo1744b(Context context) {
            ao();
            if (this.kL.get() == null) {
                return "";
            }
            ap();
            return ((C0331g) this.kL.get()).mo1744b(context);
        }

        public void run() {
            try {
                this.kL.set(C1190j.m4072a(this.kC.kQ.sw, this.kC.kO));
            } finally {
                this.kK.countDown();
                this.kC = null;
            }
        }
    }

    public C1119u(Context context, al alVar, String str, bt btVar, ev evVar) {
        this.kC = new C0375c(context, alVar, str, evVar);
        this.kB = btVar;
        this.kD = new C0379y(this);
        this.kE = new ab();
        eo.m985n(context);
        m3755W();
    }

    private void m3755W() {
        if (VERSION.SDK_INT >= 14 && this.kC != null && this.kC.kO != null) {
            this.kC.kO.registerComponentCallbacks(this.kG);
        }
    }

    private void m3756X() {
        if (VERSION.SDK_INT >= 14 && this.kC != null && this.kC.kO != null) {
            this.kC.kO.unregisterComponentCallbacks(this.kG);
        }
    }

    private void m3758a(int i) {
        eu.m1014D("Failed to load ad: " + i);
        if (this.kC.kR != null) {
            try {
                this.kC.kR.onAdFailedToLoad(i);
            } catch (Throwable e) {
                eu.m1017c("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void ah() {
        eu.m1012B("Ad closing.");
        if (this.kC.kR != null) {
            try {
                this.kC.kR.onAdClosed();
            } catch (Throwable e) {
                eu.m1017c("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void ai() {
        eu.m1012B("Ad leaving application.");
        if (this.kC.kR != null) {
            try {
                this.kC.kR.onAdLeftApplication();
            } catch (Throwable e) {
                eu.m1017c("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void aj() {
        eu.m1012B("Ad opening.");
        if (this.kC.kR != null) {
            try {
                this.kC.kR.onAdOpened();
            } catch (Throwable e) {
                eu.m1017c("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void ak() {
        eu.m1012B("Ad finished loading.");
        if (this.kC.kR != null) {
            try {
                this.kC.kR.onAdLoaded();
            } catch (Throwable e) {
                eu.m1017c("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private boolean al() {
        boolean z = true;
        if (!eo.m978a(this.kC.kO.getPackageManager(), this.kC.kO.getPackageName(), "android.permission.INTERNET")) {
            if (!this.kC.kT.mf) {
                et.m1008a(this.kC.kM, this.kC.kT, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!eo.m984m(this.kC.kO)) {
            if (!this.kC.kT.mf) {
                et.m1008a(this.kC.kM, this.kC.kT, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.kC.kT.mf)) {
            this.kC.kM.setVisibility(0);
        }
        return z;
    }

    private void am() {
        if (this.kC.kU == null) {
            eu.m1014D("Ad state was null when trying to ping click URLs.");
            return;
        }
        eu.m1019z("Pinging click URLs.");
        this.kC.kV.bC();
        if (this.kC.kU.nt != null) {
            eo.m973a(this.kC.kO, this.kC.kQ.sw, this.kC.kU.nt);
        }
        if (this.kC.kU.rz != null && this.kC.kU.rz.nt != null) {
            br.m837a(this.kC.kO, this.kC.kQ.sw, this.kC.kU, this.kC.kN, false, this.kC.kU.rz.nt);
        }
    }

    private void an() {
        if (this.kC.kU != null) {
            this.kC.kU.oy.destroy();
            this.kC.kU = null;
        }
    }

    private void m3759b(View view) {
        this.kC.kM.addView(view, new LayoutParams(-2, -2));
    }

    private boolean m3760b(ef efVar) {
        View view;
        if (efVar.qg) {
            try {
                view = (View) C1030e.m3259e(efVar.nN.getView());
                View nextView = this.kC.kM.getNextView();
                if (nextView != null) {
                    this.kC.kM.removeView(nextView);
                }
                try {
                    m3759b(view);
                } catch (Throwable th) {
                    eu.m1017c("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                eu.m1017c("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (efVar.rA != null) {
            efVar.oy.m1027a(efVar.rA);
            this.kC.kM.removeAllViews();
            this.kC.kM.setMinimumWidth(efVar.rA.widthPixels);
            this.kC.kM.setMinimumHeight(efVar.rA.heightPixels);
            m3759b(efVar.oy);
        }
        if (this.kC.kM.getChildCount() > 1) {
            this.kC.kM.showNext();
        }
        if (this.kC.kU != null) {
            view = this.kC.kM.getNextView();
            if (view instanceof ex) {
                ((ex) view).m1026a(this.kC.kO, this.kC.kT);
            } else if (view != null) {
                this.kC.kM.removeView(view);
            }
            if (this.kC.kU.nN != null) {
                try {
                    this.kC.kU.nN.destroy();
                } catch (RemoteException e) {
                    eu.m1014D("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.kC.kM.setVisibility(0);
        return true;
    }

    private C0306a m3761c(ai aiVar) {
        PackageInfo packageInfo;
        Bundle bundle;
        ApplicationInfo applicationInfo = this.kC.kO.getApplicationInfo();
        try {
            packageInfo = this.kC.kO.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (this.kC.kT.mf || this.kC.kM.getParent() == null) {
            bundle = null;
        } else {
            int[] iArr = new int[2];
            this.kC.kM.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.kC.kO.getResources().getDisplayMetrics();
            int width = this.kC.kM.getWidth();
            int height = this.kC.kM.getHeight();
            int i3 = (!this.kC.kM.isShown() || i + width <= 0 || i2 + height <= 0 || i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) ? 0 : 1;
            bundle = new Bundle(5);
            bundle.putInt("x", i);
            bundle.putInt("y", i2);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            bundle.putInt("visible", i3);
        }
        String bI = eh.bI();
        this.kC.kV = new eg(bI, this.kC.kN);
        this.kC.kV.m950f(aiVar);
        return new C0306a(bundle, aiVar, this.kC.kT, this.kC.kN, applicationInfo, packageInfo, bI, eh.rQ, this.kC.kQ, eh.m955a(this.kC.kO, this, bI));
    }

    private void m3762c(boolean z) {
        if (this.kC.kU == null) {
            eu.m1014D("Ad state was null when trying to ping impression URLs.");
            return;
        }
        eu.m1019z("Pinging Impression URLs.");
        this.kC.kV.bB();
        if (this.kC.kU.nu != null) {
            eo.m973a(this.kC.kO, this.kC.kQ.sw, this.kC.kU.nu);
        }
        if (!(this.kC.kU.rz == null || this.kC.kU.rz.nu == null)) {
            br.m837a(this.kC.kO, this.kC.kQ.sw, this.kC.kU, this.kC.kN, z, this.kC.kU.rz.nu);
        }
        if (this.kC.kU.nM != null && this.kC.kU.nM.np != null) {
            br.m837a(this.kC.kO, this.kC.kQ.sw, this.kC.kU, this.kC.kN, z, this.kC.kU.nM.np);
        }
    }

    public C0252d mo1591U() {
        hm.ay("getAdFrame must be called on the main UI thread.");
        return C1030e.m3260h(this.kC.kM);
    }

    public al mo1592V() {
        hm.ay("getAdSize must be called on the main UI thread.");
        return this.kC.kT;
    }

    public void mo3089Y() {
        ai();
    }

    public void mo3090Z() {
        this.kE.m2440d(this.kC.kU);
        if (this.kC.kT.mf) {
            an();
        }
        this.kF = false;
        ah();
        this.kC.kV.bD();
    }

    public void mo1593a(al alVar) {
        hm.ay("setAdSize must be called on the main UI thread.");
        this.kC.kT = alVar;
        if (this.kC.kU != null) {
            this.kC.kU.oy.m1027a(alVar);
        }
        if (this.kC.kM.getChildCount() > 1) {
            this.kC.kM.removeView(this.kC.kM.getNextView());
        }
        this.kC.kM.setMinimumWidth(alVar.widthPixels);
        this.kC.kM.setMinimumHeight(alVar.heightPixels);
        this.kC.kM.requestLayout();
    }

    public void mo1594a(ap apVar) {
        hm.ay("setAdListener must be called on the main UI thread.");
        this.kC.kR = apVar;
    }

    public void mo1595a(as asVar) {
        hm.ay("setAppEventListener must be called on the main UI thread.");
        this.kC.kW = asVar;
    }

    public void mo1596a(dc dcVar) {
        hm.ay("setInAppPurchaseListener must be called on the main UI thread.");
        this.kC.kY = dcVar;
    }

    public void mo1597a(dg dgVar, String str) {
        hm.ay("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.kC.kZ = new cz(str);
        this.kC.kX = dgVar;
        if (!eh.bM() && dgVar != null) {
            new cs(this.kC.kO, this.kC.kX, this.kC.kZ).start();
        }
    }

    public void mo3091a(ef efVar) {
        int i = 0;
        this.kC.kS = null;
        if (!(efVar.errorCode == -2 || efVar.errorCode == 3)) {
            eh.m956b(this.kC.aq());
        }
        if (efVar.errorCode != -1) {
            boolean z = efVar.pX.extras != null ? efVar.pX.extras.getBoolean("_noRefresh", false) : false;
            if (this.kC.kT.mf) {
                eo.m975a(efVar.oy);
            } else if (!z) {
                if (efVar.nx > 0) {
                    this.kD.m1472a(efVar.pX, efVar.nx);
                } else if (efVar.rz != null && efVar.rz.nx > 0) {
                    this.kD.m1472a(efVar.pX, efVar.rz.nx);
                } else if (!efVar.qg && efVar.errorCode == 2) {
                    this.kD.m1473d(efVar.pX);
                }
            }
            if (!(efVar.errorCode != 3 || efVar.rz == null || efVar.rz.nv == null)) {
                eu.m1019z("Pinging no fill URLs.");
                br.m837a(this.kC.kO, this.kC.kQ.sw, efVar, this.kC.kN, false, efVar.rz.nv);
            }
            if (efVar.errorCode != -2) {
                m3758a(efVar.errorCode);
                return;
            }
            int i2;
            if (!this.kC.kT.mf) {
                if (!m3760b(efVar)) {
                    m3758a(0);
                    return;
                } else if (this.kC.kM != null) {
                    this.kC.kM.kI.m996x(efVar.ql);
                }
            }
            if (!(this.kC.kU == null || this.kC.kU.nP == null)) {
                this.kC.kU.nP.m3489a(null);
            }
            if (efVar.nP != null) {
                efVar.nP.m3489a((bn) this);
            }
            this.kE.m2440d(this.kC.kU);
            this.kC.kU = efVar;
            if (efVar.rA != null) {
                this.kC.kT = efVar.rA;
            }
            this.kC.kV.m951j(efVar.rB);
            this.kC.kV.m952k(efVar.rC);
            this.kC.kV.m953n(this.kC.kT.mf);
            this.kC.kV.m954o(efVar.qg);
            if (!this.kC.kT.mf) {
                m3762c(false);
            }
            if (this.kC.la == null) {
                this.kC.la = new ek(this.kC.kN);
            }
            if (efVar.rz != null) {
                i2 = efVar.rz.ny;
                i = efVar.rz.nz;
            } else {
                i2 = 0;
            }
            this.kC.la.m965a(i2, i);
            if (!(this.kC.kT.mf || efVar.oy == null || (!efVar.oy.cb().cj() && efVar.ry == null))) {
                ac a = this.kE.m2437a(this.kC.kT, this.kC.kU);
                if (efVar.oy.cb().cj() && a != null) {
                    a.m766a(new C0800x(efVar.oy));
                }
            }
            this.kC.kU.oy.bX();
            ak();
        }
    }

    public void mo3092a(String str, ArrayList<String> arrayList) {
        db ctVar = new ct(str, arrayList, this.kC.kO, this.kC.kQ.sw);
        if (this.kC.kY == null) {
            eu.m1014D("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.kC.kO) != 0) {
                eu.m1014D("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.kC.kX == null) {
                eu.m1014D("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.kC.kZ == null) {
                eu.m1014D("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else {
                try {
                    if (!this.kC.kX.isValidPurchase(str)) {
                        return;
                    }
                } catch (RemoteException e) {
                    eu.m1014D("Could not start In-App purchase.");
                }
                cu.m3572a(this.kC.kO, this.kC.kQ.sz, new cq(ctVar, this.kC.kX, this.kC.kZ, this.kC.kO));
                return;
            }
        }
        try {
            this.kC.kY.mo1670a(ctVar);
        } catch (RemoteException e2) {
            eu.m1014D("Could not start In-App purchase.");
        }
    }

    public void mo3093a(HashSet<eg> hashSet) {
        this.kC.m1466a(hashSet);
    }

    public boolean mo1598a(ai aiVar) {
        hm.ay("loadAd must be called on the main UI thread.");
        if (this.kC.kS != null) {
            eu.m1014D("An ad request is already in progress. Aborting.");
            return false;
        } else if (this.kC.kT.mf && this.kC.kU != null) {
            eu.m1014D("An interstitial is already loading. Aborting.");
            return false;
        } else if (!al()) {
            return false;
        } else {
            ex exVar;
            eu.m1012B("Starting ad request.");
            if (!aiVar.lV) {
                eu.m1012B("Use AdRequest.Builder.addTestDevice(\"" + et.m1009r(this.kC.kO) + "\") to get test ads on this device.");
            }
            this.kD.cancel();
            this.kC.lb = false;
            C0306a c = m3761c(aiVar);
            if (this.kC.kT.mf) {
                ex a = ex.m1023a(this.kC.kO, this.kC.kT, false, false, this.kC.kP, this.kC.kQ);
                a.cb().m1040a(this, null, this, this, true, this, this);
                exVar = a;
            } else {
                ex exVar2;
                View nextView = this.kC.kM.getNextView();
                if (nextView instanceof ex) {
                    exVar2 = (ex) nextView;
                    exVar2.m1026a(this.kC.kO, this.kC.kT);
                } else {
                    if (nextView != null) {
                        this.kC.kM.removeView(nextView);
                    }
                    nextView = ex.m1023a(this.kC.kO, this.kC.kT, false, false, this.kC.kP, this.kC.kQ);
                    if (this.kC.kT.mg == null) {
                        m3759b(nextView);
                    }
                }
                exVar2.cb().m1039a(this, this, this, this, false, this);
                exVar = exVar2;
            }
            this.kC.kS = dm.m893a(this.kC.kO, c, this.kC.kP, exVar, this.kB, this);
            return true;
        }
    }

    public void aa() {
        if (this.kC.kT.mf) {
            m3762c(false);
        }
        this.kF = true;
        aj();
    }

    public void ab() {
        onAdClicked();
    }

    public void ac() {
        mo3090Z();
    }

    public void ad() {
        mo3089Y();
    }

    public void ae() {
        aa();
    }

    public void af() {
        if (this.kC.kU != null) {
            eu.m1014D("Mediation adapter " + this.kC.kU.nO + " refreshed, but mediation adapters should never refresh.");
        }
        m3762c(true);
        ak();
    }

    public void ag() {
        hm.ay("recordManualImpression must be called on the main UI thread.");
        if (this.kC.kU == null) {
            eu.m1014D("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        eu.m1019z("Pinging manual tracking URLs.");
        if (this.kC.kU.qi != null) {
            eo.m973a(this.kC.kO, this.kC.kQ.sw, this.kC.kU.qi);
        }
    }

    public void m3776b(ai aiVar) {
        ViewParent parent = this.kC.kM.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && eo.bQ() && !this.kF) {
            mo1598a(aiVar);
            return;
        }
        eu.m1012B("Ad is not visible. Not refreshing ad.");
        this.kD.m1473d(aiVar);
    }

    public void mo3100b(boolean z) {
        this.kC.lb = z;
    }

    public void destroy() {
        hm.ay("destroy must be called on the main UI thread.");
        m3756X();
        this.kC.kR = null;
        this.kC.kW = null;
        this.kD.cancel();
        this.kE.stop();
        stopLoading();
        if (this.kC.kM != null) {
            this.kC.kM.removeAllViews();
        }
        if (!(this.kC.kU == null || this.kC.kU.oy == null)) {
            this.kC.kU.oy.destroy();
        }
        if (this.kC.kU != null && this.kC.kU.nN != null) {
            try {
                this.kC.kU.nN.destroy();
            } catch (RemoteException e) {
                eu.m1014D("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean isReady() {
        hm.ay("isLoaded must be called on the main UI thread.");
        return this.kC.kS == null && this.kC.kU != null;
    }

    public void onAdClicked() {
        am();
    }

    public void onAppEvent(String name, String info) {
        if (this.kC.kW != null) {
            try {
                this.kC.kW.onAppEvent(name, info);
            } catch (Throwable e) {
                eu.m1017c("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        hm.ay("pause must be called on the main UI thread.");
        if (this.kC.kU != null) {
            eo.m975a(this.kC.kU.oy);
        }
        if (!(this.kC.kU == null || this.kC.kU.nN == null)) {
            try {
                this.kC.kU.nN.pause();
            } catch (RemoteException e) {
                eu.m1014D("Could not pause mediation adapter.");
            }
        }
        this.kE.pause();
        this.kD.pause();
    }

    public void resume() {
        hm.ay("resume must be called on the main UI thread.");
        if (this.kC.kU != null) {
            eo.m981b(this.kC.kU.oy);
        }
        if (!(this.kC.kU == null || this.kC.kU.nN == null)) {
            try {
                this.kC.kU.nN.resume();
            } catch (RemoteException e) {
                eu.m1014D("Could not resume mediation adapter.");
            }
        }
        this.kD.resume();
        this.kE.resume();
    }

    public void showInterstitial() {
        hm.ay("showInterstitial must be called on the main UI thread.");
        if (!this.kC.kT.mf) {
            eu.m1014D("Cannot call showInterstitial on a banner ad.");
        } else if (this.kC.kU == null) {
            eu.m1014D("The interstitial has not loaded.");
        } else if (this.kC.kU.oy.ce()) {
            eu.m1014D("The interstitial is already showing.");
        } else {
            this.kC.kU.oy.m1032q(true);
            if (this.kC.kU.oy.cb().cj() || this.kC.kU.ry != null) {
                ac a = this.kE.m2437a(this.kC.kT, this.kC.kU);
                if (this.kC.kU.oy.cb().cj() && a != null) {
                    a.m766a(new C0800x(this.kC.kU.oy));
                }
            }
            if (this.kC.kU.qg) {
                try {
                    this.kC.kU.nN.showInterstitial();
                    return;
                } catch (Throwable e) {
                    eu.m1017c("Could not show interstitial.", e);
                    an();
                    return;
                }
            }
            C0799v c0799v = new C0799v(this.kC.lb, false);
            if (this.kC.kO instanceof Activity) {
                Window window = ((Activity) this.kC.kO).getWindow();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                window.getDecorView().getGlobalVisibleRect(rect);
                window.getDecorView().getWindowVisibleDisplayFrame(rect2);
                if (!(rect.bottom == 0 || rect2.bottom == 0)) {
                    c0799v = new C0799v(this.kC.lb, rect.top == rect2.top);
                }
            }
            cf.m3562a(this.kC.kO, new ch(this, this, this, this.kC.kU.oy, this.kC.kU.orientation, this.kC.kQ, this.kC.kU.ql, c0799v));
        }
    }

    public void stopLoading() {
        hm.ay("stopLoading must be called on the main UI thread.");
        if (this.kC.kU != null) {
            this.kC.kU.oy.stopLoading();
            this.kC.kU = null;
        }
        if (this.kC.kS != null) {
            this.kC.kS.cancel();
        }
    }
}
