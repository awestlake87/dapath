package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0609a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.C1022b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C1024b;
import com.google.android.gms.drive.metadata.internal.C1026g;
import com.google.android.gms.drive.metadata.internal.C1027j;
import com.google.android.gms.drive.metadata.internal.C1028l;
import com.google.android.gms.drive.metadata.internal.C1173i;
import com.google.android.gms.drive.metadata.internal.C1174k;
import com.google.android.gms.plus.PlusShare;
import java.util.Collections;

public class iq {
    public static final MetadataField<DriveId> JT = it.KB;
    public static final MetadataField<String> JU = new C1028l("alternateLink", 4300000);
    public static final C1239a JV = new C1239a(5000000);
    public static final MetadataField<String> JW = new C1028l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
    public static final MetadataField<String> JX = new C1028l("embedLink", 4300000);
    public static final MetadataField<String> JY = new C1028l("fileExtension", 4300000);
    public static final MetadataField<Long> JZ = new C1026g("fileSize", 4300000);
    public static final MetadataField<Boolean> Ka = new C1024b("hasThumbnail", 4300000);
    public static final MetadataField<String> Kb = new C1028l("indexableText", 4300000);
    public static final MetadataField<Boolean> Kc = new C1024b("isAppData", 4300000);
    public static final MetadataField<Boolean> Kd = new C1024b("isCopyable", 4300000);
    public static final MetadataField<Boolean> Ke = new C1024b("isEditable", 4100000);
    public static final C1184b Kf = new C1184b("isPinned", 4100000);
    public static final MetadataField<Boolean> Kg = new C1024b("isRestricted", 4300000);
    public static final MetadataField<Boolean> Kh = new C1024b("isShared", 4300000);
    public static final MetadataField<Boolean> Ki = new C1024b("isTrashable", 4400000);
    public static final MetadataField<Boolean> Kj = new C1024b("isViewed", 4300000);
    public static final C1185c Kk = new C1185c("mimeType", 4100000);
    public static final MetadataField<String> Kl = new C1028l("originalFilename", 4300000);
    public static final C1022b<String> Km = new C1174k("ownerNames", 4300000);
    public static final C1240d Kn = new C1240d("parents", 4100000);
    public static final C1186e Ko = new C1186e("quotaBytesUsed", 4300000);
    public static final C1187f Kp = new C1187f("starred", 4100000);
    public static final MetadataField<C0609a> Kq = new C1027j<C0609a>("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
        protected /* synthetic */ Object mo2567b(DataHolder dataHolder, int i, int i2) {
            return m4065i(dataHolder, i, i2);
        }

        protected C0609a m4065i(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    };
    public static final C1188g Kr = new C1188g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
    public static final C1189h Ks = new C1189h("trashed", 4100000);
    public static final MetadataField<String> Kt = new C1028l("webContentLink", 4300000);
    public static final MetadataField<String> Ku = new C1028l("webViewLink", 4300000);
    public static final MetadataField<String> Kv = new C1028l("uniqueIdentifier", 5000000);

    public static class C1184b extends C1024b implements SearchableMetadataField<Boolean> {
        public C1184b(String str, int i) {
            super(str, i);
        }
    }

    public static class C1185c extends C1028l implements SearchableMetadataField<String> {
        public C1185c(String str, int i) {
            super(str, i);
        }
    }

    public static class C1186e extends C1026g implements SortableMetadataField<Long> {
        public C1186e(String str, int i) {
            super(str, i);
        }
    }

    public static class C1187f extends C1024b implements SearchableMetadataField<Boolean> {
        public C1187f(String str, int i) {
            super(str, i);
        }
    }

    public static class C1188g extends C1028l implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public C1188g(String str, int i) {
            super(str, i);
        }
    }

    public static class C1189h extends C1024b implements SearchableMetadataField<Boolean> {
        public C1189h(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object mo2567b(DataHolder dataHolder, int i, int i2) {
            return mo3145d(dataHolder, i, i2);
        }

        protected Boolean mo3145d(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.m2010b(getName(), i, i2) != 0);
        }
    }

    public static class C1239a extends ir implements SearchableMetadataField<AppVisibleCustomProperties> {
        public C1239a(int i) {
            super(i);
        }
    }

    public static class C1240d extends C1173i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public C1240d(String str, int i) {
            super(str, i);
        }
    }
}
