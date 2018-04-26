package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class C1011l extends Metadata {
    private final MetadataBundle II;

    public C1011l(MetadataBundle metadataBundle) {
        this.II = metadataBundle;
    }

    protected <T> T mo2544a(MetadataField<T> metadataField) {
        return this.II.m2085a((MetadataField) metadataField);
    }

    public /* synthetic */ Object freeze() {
        return gl();
    }

    public Metadata gl() {
        return new C1011l(MetadataBundle.m2084a(this.II));
    }

    public boolean isDataValid() {
        return this.II != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.II + "]";
    }
}
