package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class C0359k {
    private String kg = "googleads.g.doubleclick.net";
    private String kh = "/pagead/ads";
    private String ki = "ad.doubleclick.net";
    private String[] kj = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private C0331g kk;

    public C0359k(C0331g c0331g) {
        this.kk = c0331g;
    }

    private Uri m1317a(Uri uri, Context context, String str, boolean z) throws C0361l {
        try {
            boolean a = m1322a(uri);
            if (a) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new C0361l("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new C0361l("Query parameter already exists: ms");
            }
            String a2 = z ? this.kk.mo1741a(context, str) : this.kk.mo1740a(context);
            return a ? m1319b(uri, "dc_ms", a2) : m1318a(uri, "ms", a2);
        } catch (UnsupportedOperationException e) {
            throw new C0361l("Provided Uri is not in a valid state");
        }
    }

    private Uri m1318a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri m1319b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri m1320a(Uri uri, Context context) throws C0361l {
        try {
            return m1317a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C0361l("Provided Uri is not in a valid state");
        }
    }

    public void m1321a(MotionEvent motionEvent) {
        this.kk.mo1743a(motionEvent);
    }

    public boolean m1322a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.ki);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m1323b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.kj) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public C0331g m1324z() {
        return this.kk;
    }
}
