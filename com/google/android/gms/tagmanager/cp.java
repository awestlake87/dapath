package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.C0276c.C1077f;
import com.google.android.gms.internal.le.C1114a;
import com.google.android.gms.internal.md;
import com.google.android.gms.tagmanager.C1141o.C0950f;
import com.google.android.gms.tagmanager.cq.C0464c;
import com.google.android.gms.tagmanager.cq.C0468g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cp implements C0950f {
    private final String aet;
    private bg<C1114a> agN;
    private final ExecutorService agU = Executors.newSingleThreadExecutor();
    private final Context mContext;

    class C04591 implements Runnable {
        final /* synthetic */ cp agV;

        C04591(cp cpVar) {
            this.agV = cpVar;
        }

        public void run() {
            this.agV.ml();
        }
    }

    cp(Context context, String str) {
        this.mContext = context;
        this.aet = str;
    }

    private C0464c m3817a(ByteArrayOutputStream byteArrayOutputStream) {
        C0464c c0464c = null;
        try {
            c0464c = ba.bY(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            bh.m1648z("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
        } catch (JSONException e2) {
            bh.m1645D("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return c0464c;
    }

    private C0464c m3818k(byte[] bArr) {
        C0464c c0464c = null;
        try {
            c0464c = cq.m1684b(C1077f.m3532a(bArr));
        } catch (md e) {
            bh.m1645D("Resource doesn't contain a binary container");
        } catch (C0468g e2) {
            bh.m1645D("Resource doesn't contain a binary container");
        }
        return c0464c;
    }

    public void mo3107a(bg<C1114a> bgVar) {
        this.agN = bgVar;
    }

    public void mo3108b(final C1114a c1114a) {
        this.agU.execute(new Runnable(this) {
            final /* synthetic */ cp agV;

            public void run() {
                this.agV.m3821c(c1114a);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m3821c(com.google.android.gms.internal.le.C1114a r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.mm();
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0016 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0016 }
        r3 = com.google.android.gms.internal.me.m1428d(r5);	 Catch:{ IOException -> 0x0024 }
        r2.write(r3);	 Catch:{ IOException -> 0x0024 }
        r0 = 1;
        r2.close();	 Catch:{ IOException -> 0x001d }
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = move-exception;
        r1 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.bh.m1642A(r1);
        goto L_0x0015;
    L_0x001d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1645D(r1);
        goto L_0x0015;
    L_0x0024:
        r3 = move-exception;
        r3 = "Error writing resource to disk. Removing resource from disk.";
        com.google.android.gms.tagmanager.bh.m1645D(r3);	 Catch:{ all -> 0x0038 }
        r1.delete();	 Catch:{ all -> 0x0038 }
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0015;
    L_0x0031:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1645D(r1);
        goto L_0x0015;
    L_0x0038:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1645D(r1);
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cp.c(com.google.android.gms.internal.le$a):boolean");
    }

    public C0464c dn(int i) {
        bh.m1644C("Atttempting to load container from resource ID " + i);
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            cq.m1685b(openRawResource, byteArrayOutputStream);
            C0464c a = m3817a(byteArrayOutputStream);
            return a != null ? a : m3818k(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            bh.m1645D("Error reading default container resource with ID " + i);
            return null;
        } catch (NotFoundException e2) {
            bh.m1645D("No default container resource found.");
            return null;
        }
    }

    public void lw() {
        this.agU.execute(new C04591(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void ml() {
        /*
        r3 = this;
        r0 = r3.agN;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r3.agN;
        r0.lv();
        r0 = "Start loading resource from disk ...";
        com.google.android.gms.tagmanager.bh.m1644C(r0);
        r0 = com.google.android.gms.tagmanager.cd.md();
        r0 = r0.me();
        r1 = com.google.android.gms.tagmanager.cd.C0456a.CONTAINER;
        if (r0 == r1) goto L_0x002e;
    L_0x0022:
        r0 = com.google.android.gms.tagmanager.cd.md();
        r0 = r0.me();
        r1 = com.google.android.gms.tagmanager.cd.C0456a.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0046;
    L_0x002e:
        r0 = r3.aet;
        r1 = com.google.android.gms.tagmanager.cd.md();
        r1 = r1.getContainerId();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = r3.agN;
        r1 = com.google.android.gms.tagmanager.bg.C0454a.NOT_AVAILABLE;
        r0.mo2350a(r1);
    L_0x0045:
        return;
    L_0x0046:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x006d }
        r0 = r3.mm();	 Catch:{ FileNotFoundException -> 0x006d }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x006d }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0082 }
        r0.<init>();	 Catch:{ IOException -> 0x0082 }
        com.google.android.gms.tagmanager.cq.m1685b(r1, r0);	 Catch:{ IOException -> 0x0082 }
        r2 = r3.agN;	 Catch:{ IOException -> 0x0082 }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x0082 }
        r0 = com.google.android.gms.internal.le.C1114a.m3720l(r0);	 Catch:{ IOException -> 0x0082 }
        r2.mo2351i(r0);	 Catch:{ IOException -> 0x0082 }
        r1.close();	 Catch:{ IOException -> 0x007b }
    L_0x0067:
        r0 = "Load resource from disk finished.";
        com.google.android.gms.tagmanager.bh.m1644C(r0);
        goto L_0x0045;
    L_0x006d:
        r0 = move-exception;
        r0 = "resource not on disk";
        com.google.android.gms.tagmanager.bh.m1648z(r0);
        r0 = r3.agN;
        r1 = com.google.android.gms.tagmanager.bg.C0454a.NOT_AVAILABLE;
        r0.mo2350a(r1);
        goto L_0x0045;
    L_0x007b:
        r0 = move-exception;
        r0 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1645D(r0);
        goto L_0x0067;
    L_0x0082:
        r0 = move-exception;
        r0 = "error reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1645D(r0);	 Catch:{ all -> 0x009a }
        r0 = r3.agN;	 Catch:{ all -> 0x009a }
        r2 = com.google.android.gms.tagmanager.bg.C0454a.IO_ERROR;	 Catch:{ all -> 0x009a }
        r0.mo2350a(r2);	 Catch:{ all -> 0x009a }
        r1.close();	 Catch:{ IOException -> 0x0093 }
        goto L_0x0067;
    L_0x0093:
        r0 = move-exception;
        r0 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1645D(r0);
        goto L_0x0067;
    L_0x009a:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x009f }
    L_0x009e:
        throw r0;
    L_0x009f:
        r1 = move-exception;
        r1 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1645D(r1);
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cp.ml():void");
    }

    File mm() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.aet);
    }

    public synchronized void release() {
        this.agU.shutdown();
    }
}
