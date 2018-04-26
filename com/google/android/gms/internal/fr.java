package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fp.C0330a;
import com.google.android.gms.internal.iv.C1096a;
import com.google.android.gms.internal.iv.C1096a.C1095a;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class fr implements SafeParcelable {
    public static final fs CREATOR = new fs();
    public final String mP;
    final int xM;
    final fi yq;
    final long yr;
    final int ys;
    final fg yt;

    fr(int i, fi fiVar, long j, int i2, String str, fg fgVar) {
        this.xM = i;
        this.yq = fiVar;
        this.yr = j;
        this.ys = i2;
        this.mP = str;
        this.yt = fgVar;
    }

    public fr(fi fiVar, long j, int i) {
        this(1, fiVar, j, i, null, null);
    }

    public fr(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list) {
        this(1, m2581a(str, intent), System.currentTimeMillis(), 0, null, m2580a(intent, str2, uri, str3, list));
    }

    static fg m2580a(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        List arrayList = new ArrayList();
        arrayList.add(ab(str));
        if (uri != null) {
            arrayList.add(m2583f(uri));
        }
        if (list != null) {
            arrayList.add(m2582a(list));
        }
        String action = intent.getAction();
        if (action != null) {
            arrayList.add(m2584f("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            arrayList.add(m2584f("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            arrayList.add(m2584f("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                arrayList.add(m2584f("intent_extra_data", action));
            }
        }
        return new fg(str2, true, (fk[]) arrayList.toArray(new fk[arrayList.size()]));
    }

    public static fi m2581a(String str, Intent intent) {
        return new fi(str, "", m2585f(intent));
    }

    private static fk m2582a(List<AppIndexingLink> list) {
        me c1096a = new C1096a();
        C1095a[] c1095aArr = new C1095a[list.size()];
        for (int i = 0; i < c1095aArr.length; i++) {
            c1095aArr[i] = new C1095a();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            c1095aArr[i].UA = appIndexingLink.appIndexingUrl.toString();
            c1095aArr[i].UB = appIndexingLink.webUrl.toString();
            c1095aArr[i].viewId = appIndexingLink.viewId;
        }
        c1096a.Uy = c1095aArr;
        return new fk(me.m1428d(c1096a), new C0330a("outlinks").m1073w(true).aa(".private:outLinks").m1072Z("blob").dQ());
    }

    private static fk ab(String str) {
        return new fk(str, new C0330a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).m1071I(1).m1074x(true).aa("name").dQ(), "text1");
    }

    private static fk m2583f(Uri uri) {
        return new fk(uri.toString(), new C0330a("web_url").m1071I(4).m1073w(true).aa(PlusShare.KEY_CALL_TO_ACTION_URL).dQ());
    }

    private static fk m2584f(String str, String str2) {
        return new fk(str2, new C0330a(str).m1073w(true).dQ(), str);
    }

    private static String m2585f(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public int describeContents() {
        fs fsVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.yq, Long.valueOf(this.yr), Integer.valueOf(this.ys)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        fs fsVar = CREATOR;
        fs.m1078a(this, dest, flags);
    }
}
