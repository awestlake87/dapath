package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.C1011l;
import com.google.android.gms.drive.metadata.C1022b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0205e;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.iq;
import java.util.ArrayList;
import java.util.List;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    private static final String[] HR;
    private final String HS;
    private C1009a HT;

    private static class C1009a extends Metadata {
        private final DataHolder DG;
        private final int ED;
        private final int HU;

        public C1009a(DataHolder dataHolder, int i) {
            this.DG = dataHolder;
            this.HU = i;
            this.ED = dataHolder.ae(i);
        }

        protected <T> T mo2544a(MetadataField<T> metadataField) {
            return metadataField.mo1006a(this.DG, this.HU, this.ED);
        }

        public /* synthetic */ Object freeze() {
            return gl();
        }

        public Metadata gl() {
            MetadataBundle gF = MetadataBundle.gF();
            for (MetadataField metadataField : C0205e.gE()) {
                if (!((metadataField instanceof C1022b) || metadataField == iq.Kq)) {
                    metadataField.mo1007a(this.DG, gF, this.HU, this.ED);
                }
            }
            return new C1011l(gF);
        }

        public boolean isDataValid() {
            return !this.DG.isClosed();
        }
    }

    static {
        List arrayList = new ArrayList();
        for (MetadataField gC : C0205e.gE()) {
            arrayList.addAll(gC.gC());
        }
        HR = (String[]) arrayList.toArray(new String[0]);
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.HS = nextPageToken;
        dataHolder.eU().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        C1009a c1009a = this.HT;
        if (c1009a != null && c1009a.HU == row) {
            return c1009a;
        }
        Metadata c1009a2 = new C1009a(this.DG, row);
        this.HT = c1009a2;
        return c1009a2;
    }

    public String getNextPageToken() {
        return this.HS;
    }
}
