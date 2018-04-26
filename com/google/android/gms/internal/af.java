package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ae.C0270a;
import com.google.android.gms.internal.ey.C0318a;
import org.json.JSONObject;

public class af implements ae {
    private final ex lN;

    public af(Context context, ev evVar) {
        this.lN = ex.m1023a(context, new al(), false, false, null, evVar);
    }

    public void mo1578a(final C0270a c0270a) {
        this.lN.cb().m1038a(new C0318a(this) {
            final /* synthetic */ af lP;

            public void mo1577a(ex exVar) {
                c0270a.aE();
            }
        });
    }

    public void mo1579a(String str, bc bcVar) {
        this.lN.cb().m1041a(str, bcVar);
    }

    public void mo1580a(String str, JSONObject jSONObject) {
        this.lN.m1030a(str, jSONObject);
    }

    public void mo1581d(String str) {
        this.lN.loadUrl(str);
    }

    public void mo1582e(String str) {
        this.lN.cb().m1041a(str, null);
    }

    public void pause() {
        eo.m975a(this.lN);
    }

    public void resume() {
        eo.m981b(this.lN);
    }
}
