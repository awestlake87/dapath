package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class cd {
    private static cd agx;
    private volatile String aet;
    private volatile String agA;
    private volatile C0456a agy;
    private volatile String agz;

    enum C0456a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    cd() {
        clear();
    }

    private String ca(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String m1660j(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    static cd md() {
        cd cdVar;
        synchronized (cd.class) {
            if (agx == null) {
                agx = new cd();
            }
            cdVar = agx;
        }
        return cdVar;
    }

    void clear() {
        this.agy = C0456a.NONE;
        this.agz = null;
        this.aet = null;
        this.agA = null;
    }

    String getContainerId() {
        return this.aet;
    }

    synchronized boolean m1661i(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    bh.m1644C("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.agy = C0456a.CONTAINER_DEBUG;
                    } else {
                        this.agy = C0456a.CONTAINER;
                    }
                    this.agA = m1660j(uri);
                    if (this.agy == C0456a.CONTAINER || this.agy == C0456a.CONTAINER_DEBUG) {
                        this.agz = "/r?" + this.agA;
                    }
                    this.aet = ca(this.agA);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        bh.m1645D("Invalid preview uri: " + decode);
                        z = false;
                    } else if (ca(uri.getQuery()).equals(this.aet)) {
                        bh.m1644C("Exit preview mode for container: " + this.aet);
                        this.agy = C0456a.NONE;
                        this.agz = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    C0456a me() {
        return this.agy;
    }

    String mf() {
        return this.agz;
    }
}
