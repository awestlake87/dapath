package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.dw.C0711a;
import com.google.android.gms.internal.ey.C0318a;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class dx extends C0711a {
    private static final Object qp = new Object();
    private static dx qq;
    private final Context mContext;
    private final ed qr;
    private final bi qs;
    private final ay qt;

    dx(Context context, ay ayVar, bi biVar, ed edVar) {
        this.mContext = context;
        this.qr = edVar;
        this.qs = biVar;
        this.qt = ayVar;
    }

    private static du m3585a(Context context, ay ayVar, bi biVar, ed edVar, ds dsVar) {
        eu.m1019z("Starting ad request from service.");
        biVar.init();
        ec ecVar = new ec(context);
        if (ecVar.rm == -1) {
            eu.m1019z("Device is offline.");
            return new du(2);
        }
        final dz dzVar = new dz(dsVar.applicationInfo.packageName);
        if (dsVar.pX.extras != null) {
            String string = dsVar.pX.extras.getString("_ad");
            if (string != null) {
                return dy.m916a(context, dsVar, string);
            }
        }
        Location a = biVar.mo1608a(250);
        final String aN = ayVar.aN();
        String a2 = dy.m917a(dsVar, ecVar, a, ayVar.aO());
        if (a2 == null) {
            return new du(0);
        }
        final C0318a s = m3589s(a2);
        final Context context2 = context;
        final ds dsVar2 = dsVar;
        et.sv.post(new Runnable() {
            public void run() {
                ex a = ex.m1023a(context2, new al(), false, false, null, dsVar2.kQ);
                a.setWillNotDraw(true);
                dzVar.m928b(a);
                ey cb = a.cb();
                cb.m1041a("/invalidRequest", dzVar.qD);
                cb.m1041a("/loadAdURL", dzVar.qE);
                cb.m1041a("/log", bb.mZ);
                cb.m1038a(s);
                eu.m1019z("Loading the JS library.");
                a.loadUrl(aN);
            }
        });
        eb bx = dzVar.bx();
        if (bx == null || TextUtils.isEmpty(bx.getUrl())) {
            return new du(dzVar.getErrorCode());
        }
        a2 = null;
        if (bx.bA()) {
            a2 = edVar.mo1694u(dsVar.pY.packageName);
        }
        return m3586a(context, dsVar.kQ.sw, bx.getUrl(), a2, bx);
    }

    public static du m3586a(Context context, String str, String str2, String str3, eb ebVar) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            du duVar;
            ea eaVar = new ea();
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                eo.m974a(context, str, false, httpURLConnection);
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                }
                if (!(ebVar == null || TextUtils.isEmpty(ebVar.bz()))) {
                    httpURLConnection.setDoOutput(true);
                    byte[] bytes = ebVar.bz().getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < 200 || responseCode >= 300) {
                    m3588a(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        eu.m1014D("No location header to follow redirect.");
                        duVar = new du(0);
                        httpURLConnection.disconnect();
                        return duVar;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        eu.m1014D("Too many redirects.");
                        duVar = new du(0);
                        httpURLConnection.disconnect();
                        return duVar;
                    }
                    eaVar.m943d(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String a = eo.m969a(new InputStreamReader(httpURLConnection.getInputStream()));
                    m3588a(url3, headerFields, a, responseCode);
                    eaVar.m942a(url3, headerFields, a);
                    duVar = eaVar.m944i(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return duVar;
                }
            }
            eu.m1014D("Received error HTTP response code: " + responseCode);
            duVar = new du(0);
            httpURLConnection.disconnect();
            return duVar;
        } catch (IOException e) {
            eu.m1014D("Error while connecting to ad server: " + e.getMessage());
            return new du(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public static dx m3587a(Context context, ay ayVar, bi biVar, ed edVar) {
        dx dxVar;
        synchronized (qp) {
            if (qq == null) {
                qq = new dx(context.getApplicationContext(), ayVar, biVar, edVar);
            }
            dxVar = qq;
        }
        return dxVar;
    }

    private static void m3588a(String str, Map<String, List<String>> map, String str2, int i) {
        if (eu.m1018p(2)) {
            eu.m1013C("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    eu.m1013C("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        eu.m1013C("      " + str32);
                    }
                }
            }
            eu.m1013C("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    eu.m1013C(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                eu.m1013C("    null");
            }
            eu.m1013C("  Response Code:\n    " + i + "\n}");
        }
    }

    private static C0318a m3589s(final String str) {
        return new C0318a() {
            public void mo1577a(ex exVar) {
                String format = String.format("javascript:%s(%s);", new Object[]{"AFMA_buildAdURL", str});
                eu.m1013C("About to execute: " + format);
                exVar.loadUrl(format);
            }
        };
    }

    public du mo1691b(ds dsVar) {
        return m3585a(this.mContext, this.qt, this.qs, this.qr, dsVar);
    }
}
