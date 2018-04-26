package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1022b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class C1174k extends C1022b<String> {
    public C1174k(String str, int i) {
        super(str, i);
    }

    public static final Collection<String> aO(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    protected void m3935a(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object mo2567b(DataHolder dataHolder, int i, int i2) {
        return mo3139c(dataHolder, i, i2);
    }

    protected Collection<String> mo3139c(DataHolder dataHolder, int i, int i2) {
        try {
            return C1174k.aO(dataHolder.m2012c(getName(), i, i2));
        } catch (Throwable e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    protected /* synthetic */ Object mo2569f(Bundle bundle) {
        return m3939k(bundle);
    }

    protected Collection<String> m3939k(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
