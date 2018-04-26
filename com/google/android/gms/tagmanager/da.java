package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class da implements ab {
    private final Context ahK;
    private final String aib = m3018a("GoogleTagManager", "4.00", VERSION.RELEASE, m3017c(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient aic;
    private C0475a aid;

    public interface C0475a {
        void mo2331a(ap apVar);

        void mo2332b(ap apVar);

        void mo2333c(ap apVar);
    }

    da(HttpClient httpClient, Context context, C0475a c0475a) {
        this.ahK = context.getApplicationContext();
        this.aic = httpClient;
        this.aid = c0475a;
    }

    private HttpEntityEnclosingRequest m3015a(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.aib);
            } catch (URISyntaxException e2) {
                e = e2;
                bh.m1645D("Exception sending hit: " + e.getClass().getSimpleName());
                bh.m1645D(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            bh.m1645D("Exception sending hit: " + e.getClass().getSimpleName());
            bh.m1645D(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    private void m3016a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                bh.m1644C("Error Writing hit to log...");
            }
        }
        bh.m1644C(stringBuffer.toString());
    }

    static String m3017c(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    String m3018a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    public boolean cC() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.ahK.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m1644C("...no network connectivity");
        return false;
    }

    URL m3019d(ap apVar) {
        try {
            return new URL(apVar.lO());
        } catch (MalformedURLException e) {
            bh.m1642A("Error trying to parse the GTM url.");
            return null;
        }
    }

    public void mo2344g(List<ap> list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            Object obj2;
            ap apVar = (ap) list.get(i);
            URL d = m3019d(apVar);
            if (d == null) {
                bh.m1645D("No destination: discarding hit.");
                this.aid.mo2332b(apVar);
                obj2 = obj;
            } else {
                HttpEntityEnclosingRequest a = m3015a(d);
                if (a == null) {
                    this.aid.mo2332b(apVar);
                    obj2 = obj;
                } else {
                    HttpHost httpHost = new HttpHost(d.getHost(), d.getPort(), d.getProtocol());
                    a.addHeader("Host", httpHost.toHostString());
                    m3016a(a);
                    if (obj != null) {
                        try {
                            bn.m1656w(this.ahK);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            bh.m1645D("ClientProtocolException sending hit; discarding hit...");
                            this.aid.mo2332b(apVar);
                            obj2 = obj;
                        } catch (IOException e2) {
                            bh.m1645D("Exception sending hit: " + e2.getClass().getSimpleName());
                            bh.m1645D(e2.getMessage());
                            this.aid.mo2333c(apVar);
                            obj2 = obj;
                        }
                    }
                    HttpResponse execute = this.aic.execute(httpHost, a);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        bh.m1645D("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.aid.mo2333c(apVar);
                    } else {
                        this.aid.mo2331a(apVar);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
    }
}
