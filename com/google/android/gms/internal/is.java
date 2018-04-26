package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C1172d;
import java.util.Date;

public class is {
    public static final C1245e KA = new C1245e("sharedWithMe", 4100000);
    public static final C1241a Kw = new C1241a("created", 4100000);
    public static final C1242b Kx = new C1242b("lastOpenedTime", 4300000);
    public static final C1244d Ky = new C1244d("modified", 4100000);
    public static final C1243c Kz = new C1243c("modifiedByMe", 4100000);

    public static class C1241a extends C1172d implements SortableMetadataField<Date> {
        public C1241a(String str, int i) {
            super(str, i);
        }
    }

    public static class C1242b extends C1172d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1242b(String str, int i) {
            super(str, i);
        }
    }

    public static class C1243c extends C1172d implements SortableMetadataField<Date> {
        public C1243c(String str, int i) {
            super(str, i);
        }
    }

    public static class C1244d extends C1172d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1244d(String str, int i) {
            super(str, i);
        }
    }

    public static class C1245e extends C1172d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1245e(String str, int i) {
            super(str, i);
        }
    }
}
