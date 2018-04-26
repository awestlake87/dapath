package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;

public interface MetadataField<T> {
    T mo1006a(DataHolder dataHolder, int i, int i2);

    void mo1007a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2);

    void mo1008a(T t, Bundle bundle);

    T mo1009e(Bundle bundle);

    Collection<String> gC();

    String getName();
}
