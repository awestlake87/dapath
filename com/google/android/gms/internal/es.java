package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class es extends em {
    private final String lr;
    private final Context mContext;
    private final String qY;

    public es(Context context, String str, String str2) {
        this.mContext = context;
        this.lr = str;
        this.qY = str2;
    }

    public void bh() {
        HttpURLConnection httpURLConnection;
        try {
            eu.m1013C("Pinging URL: " + this.qY);
            httpURLConnection = (HttpURLConnection) new URL(this.qY).openConnection();
            eo.m974a(this.mContext, this.lr, true, httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                eu.m1014D("Received non-success response code " + responseCode + " from pinging URL: " + this.qY);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            eu.m1014D("Error while parsing ping URL: " + this.qY + ". " + e.getMessage());
        } catch (IOException e2) {
            eu.m1014D("Error while pinging URL: " + this.qY + ". " + e2.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public void onStop() {
    }
}
