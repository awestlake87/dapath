package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;
import java.util.Collections;

public abstract class C1022b<T> extends C0625a<Collection<T>> {
    protected C1022b(String str, int i) {
        super(str, Collections.emptySet(), Collections.emptySet(), i);
    }

    protected /* synthetic */ Object mo2567b(DataHolder dataHolder, int i, int i2) {
        return mo3139c(dataHolder, i, i2);
    }

    protected Collection<T> mo3139c(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
