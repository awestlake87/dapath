package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class fc extends WebViewClient {
    private final ex lN;
    private final String sT;
    private boolean sU = false;
    private final C0304do sV;

    public fc(C0304do c0304do, ex exVar, String str) {
        this.sT = m1052G(str);
        this.lN = exVar;
        this.sV = c0304do;
    }

    private String m1052G(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                eu.m1011A(e.getMessage());
            }
        }
        return str;
    }

    protected boolean m1053F(String str) {
        Object G = m1052G(str);
        if (TextUtils.isEmpty(G)) {
            return false;
        }
        try {
            URI uri = new URI(G);
            if ("passback".equals(uri.getScheme())) {
                eu.m1019z("Passback received");
                this.sV.bp();
                return true;
            } else if (TextUtils.isEmpty(this.sT)) {
                return false;
            } else {
                URI uri2 = new URI(this.sT);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!hk.equal(host, host2) || !hk.equal(path, path2)) {
                    return false;
                }
                eu.m1019z("Passback received");
                this.sV.bp();
                return true;
            }
        } catch (URISyntaxException e) {
            eu.m1011A(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView view, String url) {
        eu.m1019z("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!m1053F(url)) {
            this.lN.cb().onLoadResource(this.lN, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        eu.m1019z("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.sU) {
            this.sV.bo();
            this.sU = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        eu.m1019z("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!m1053F(url)) {
            return this.lN.cb().shouldOverrideUrlLoading(this.lN, url);
        }
        eu.m1019z("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
