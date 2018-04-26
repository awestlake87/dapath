package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iu;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class C0205e {
    private static Map<String, MetadataField<?>> JR = new HashMap();

    static {
        C0205e.m369b(iq.JT);
        C0205e.m369b(iq.Kr);
        C0205e.m369b(iq.Kk);
        C0205e.m369b(iq.Kp);
        C0205e.m369b(iq.Ks);
        C0205e.m369b(iq.Ke);
        C0205e.m369b(iq.Kf);
        C0205e.m369b(iq.Kc);
        C0205e.m369b(iq.Kh);
        C0205e.m369b(iq.Kn);
        C0205e.m369b(iq.JU);
        C0205e.m369b(iq.Km);
        C0205e.m369b(iq.JW);
        C0205e.m369b(iq.Kd);
        C0205e.m369b(iq.JX);
        C0205e.m369b(iq.JY);
        C0205e.m369b(iq.JZ);
        C0205e.m369b(iq.Kj);
        C0205e.m369b(iq.Kg);
        C0205e.m369b(iq.Kl);
        C0205e.m369b(iq.Ko);
        C0205e.m369b(iq.Kt);
        C0205e.m369b(iq.Ku);
        C0205e.m369b(iq.Kb);
        C0205e.m369b(iq.Ka);
        C0205e.m369b(iq.Kq);
        C0205e.m369b(iq.Ki);
        C0205e.m369b(iq.JV);
        C0205e.m369b(iq.Kv);
        C0205e.m369b(is.Kw);
        C0205e.m369b(is.Ky);
        C0205e.m369b(is.Kz);
        C0205e.m369b(is.KA);
        C0205e.m369b(is.Kx);
        C0205e.m369b(iu.KC);
        C0205e.m369b(iu.KD);
    }

    public static MetadataField<?> aN(String str) {
        return (MetadataField) JR.get(str);
    }

    private static void m369b(MetadataField<?> metadataField) {
        if (JR.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        JR.put(metadataField.getName(), metadataField);
    }

    public static Collection<MetadataField<?>> gE() {
        return Collections.unmodifiableCollection(JR.values());
    }
}
