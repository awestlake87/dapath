package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.dapath.pathgen.PathGenerator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hy.C0758a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ks extends hy implements SafeParcelable, Person {
    public static final kt CREATOR = new kt();
    private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
    private String Ar;
    private String Ln;
    private final Set<Integer> acs;
    private String adA;
    private int adB;
    private List<C1111f> adC;
    private List<C1112g> adD;
    private int adE;
    private int adF;
    private String adG;
    private List<C1113h> adH;
    private boolean adI;
    private String adq;
    private C1105a adr;
    private String ads;
    private String adt;
    private int adu;
    private C1108b adv;
    private String adw;
    private C1109c adx;
    private boolean ady;
    private C1110d adz;
    private int ml;
    private String qY;
    private String xG;
    private final int xM;

    public static class C0360e {
        public static int bA(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    public static final class C1105a extends hy implements SafeParcelable, AgeRange {
        public static final ku CREATOR = new ku();
        private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
        private final Set<Integer> acs;
        private int adJ;
        private int adK;
        private final int xM;

        static {
            acr.put("max", C0758a.m2722g("max", 2));
            acr.put("min", C0758a.m2722g("min", 3));
        }

        public C1105a() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1105a(Set<Integer> set, int i, int i2, int i3) {
            this.acs = set;
            this.xM = i;
            this.adJ = i2;
            this.adK = i3;
        }

        protected boolean mo2859a(C0758a c0758a) {
            return this.acs.contains(Integer.valueOf(c0758a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object mo2860b(C0758a c0758a) {
            switch (c0758a.fN()) {
                case 2:
                    return Integer.valueOf(this.adJ);
                case 3:
                    return Integer.valueOf(this.adK);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
            }
        }

        public int describeContents() {
            ku kuVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1105a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1105a c1105a = (C1105a) obj;
            for (C0758a c0758a : acr.values()) {
                if (mo2859a(c0758a)) {
                    if (!c1105a.mo2859a(c0758a)) {
                        return false;
                    }
                    if (!mo2860b(c0758a).equals(c1105a.mo2860b(c0758a))) {
                        return false;
                    }
                } else if (c1105a.mo2859a(c0758a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0758a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kN();
        }

        public int getMax() {
            return this.adJ;
        }

        public int getMin() {
            return this.adK;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasMax() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0758a c0758a : acr.values()) {
                int hashCode;
                if (mo2859a(c0758a)) {
                    hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1105a kN() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            ku kuVar = CREATOR;
            ku.m1331a(this, out, flags);
        }
    }

    public static final class C1108b extends hy implements SafeParcelable, Cover {
        public static final kv CREATOR = new kv();
        private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
        private final Set<Integer> acs;
        private C1106a adL;
        private C1107b adM;
        private int adN;
        private final int xM;

        public static final class C1106a extends hy implements SafeParcelable, CoverInfo {
            public static final kw CREATOR = new kw();
            private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
            private final Set<Integer> acs;
            private int adO;
            private int adP;
            private final int xM;

            static {
                acr.put("leftImageOffset", C0758a.m2722g("leftImageOffset", 2));
                acr.put("topImageOffset", C0758a.m2722g("topImageOffset", 3));
            }

            public C1106a() {
                this.xM = 1;
                this.acs = new HashSet();
            }

            C1106a(Set<Integer> set, int i, int i2, int i3) {
                this.acs = set;
                this.xM = i;
                this.adO = i2;
                this.adP = i3;
            }

            protected boolean mo2859a(C0758a c0758a) {
                return this.acs.contains(Integer.valueOf(c0758a.fN()));
            }

            protected Object aF(String str) {
                return null;
            }

            protected boolean aG(String str) {
                return false;
            }

            protected Object mo2860b(C0758a c0758a) {
                switch (c0758a.fN()) {
                    case 2:
                        return Integer.valueOf(this.adO);
                    case 3:
                        return Integer.valueOf(this.adP);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
                }
            }

            public int describeContents() {
                kw kwVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1106a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1106a c1106a = (C1106a) obj;
                for (C0758a c0758a : acr.values()) {
                    if (mo2859a(c0758a)) {
                        if (!c1106a.mo2859a(c0758a)) {
                            return false;
                        }
                        if (!mo2860b(c0758a).equals(c1106a.mo2860b(c0758a))) {
                            return false;
                        }
                    } else if (c1106a.mo2859a(c0758a)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, C0758a<?, ?>> fG() {
                return acr;
            }

            public /* synthetic */ Object freeze() {
                return kR();
            }

            public int getLeftImageOffset() {
                return this.adO;
            }

            public int getTopImageOffset() {
                return this.adP;
            }

            int getVersionCode() {
                return this.xM;
            }

            public boolean hasLeftImageOffset() {
                return this.acs.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.acs.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (C0758a c0758a : acr.values()) {
                    int hashCode;
                    if (mo2859a(c0758a)) {
                        hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public C1106a kR() {
                return this;
            }

            Set<Integer> kk() {
                return this.acs;
            }

            public void writeToParcel(Parcel out, int flags) {
                kw kwVar = CREATOR;
                kw.m1333a(this, out, flags);
            }
        }

        public static final class C1107b extends hy implements SafeParcelable, CoverPhoto {
            public static final kx CREATOR = new kx();
            private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
            private final Set<Integer> acs;
            private int ku;
            private int kv;
            private String qY;
            private final int xM;

            static {
                acr.put("height", C0758a.m2722g("height", 2));
                acr.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0758a.m2725j(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                acr.put("width", C0758a.m2722g("width", 4));
            }

            public C1107b() {
                this.xM = 1;
                this.acs = new HashSet();
            }

            C1107b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.acs = set;
                this.xM = i;
                this.kv = i2;
                this.qY = str;
                this.ku = i3;
            }

            protected boolean mo2859a(C0758a c0758a) {
                return this.acs.contains(Integer.valueOf(c0758a.fN()));
            }

            protected Object aF(String str) {
                return null;
            }

            protected boolean aG(String str) {
                return false;
            }

            protected Object mo2860b(C0758a c0758a) {
                switch (c0758a.fN()) {
                    case 2:
                        return Integer.valueOf(this.kv);
                    case 3:
                        return this.qY;
                    case 4:
                        return Integer.valueOf(this.ku);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
                }
            }

            public int describeContents() {
                kx kxVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1107b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1107b c1107b = (C1107b) obj;
                for (C0758a c0758a : acr.values()) {
                    if (mo2859a(c0758a)) {
                        if (!c1107b.mo2859a(c0758a)) {
                            return false;
                        }
                        if (!mo2860b(c0758a).equals(c1107b.mo2860b(c0758a))) {
                            return false;
                        }
                    } else if (c1107b.mo2859a(c0758a)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, C0758a<?, ?>> fG() {
                return acr;
            }

            public /* synthetic */ Object freeze() {
                return kS();
            }

            public int getHeight() {
                return this.kv;
            }

            public String getUrl() {
                return this.qY;
            }

            int getVersionCode() {
                return this.xM;
            }

            public int getWidth() {
                return this.ku;
            }

            public boolean hasHeight() {
                return this.acs.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.acs.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.acs.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (C0758a c0758a : acr.values()) {
                    int hashCode;
                    if (mo2859a(c0758a)) {
                        hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public C1107b kS() {
                return this;
            }

            Set<Integer> kk() {
                return this.acs;
            }

            public void writeToParcel(Parcel out, int flags) {
                kx kxVar = CREATOR;
                kx.m1334a(this, out, flags);
            }
        }

        static {
            acr.put("coverInfo", C0758a.m2719a("coverInfo", 2, C1106a.class));
            acr.put("coverPhoto", C0758a.m2719a("coverPhoto", 3, C1107b.class));
            acr.put("layout", C0758a.m2718a("layout", 4, new hv().m2716f("banner", 0), false));
        }

        public C1108b() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1108b(Set<Integer> set, int i, C1106a c1106a, C1107b c1107b, int i2) {
            this.acs = set;
            this.xM = i;
            this.adL = c1106a;
            this.adM = c1107b;
            this.adN = i2;
        }

        protected boolean mo2859a(C0758a c0758a) {
            return this.acs.contains(Integer.valueOf(c0758a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object mo2860b(C0758a c0758a) {
            switch (c0758a.fN()) {
                case 2:
                    return this.adL;
                case 3:
                    return this.adM;
                case 4:
                    return Integer.valueOf(this.adN);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
            }
        }

        public int describeContents() {
            kv kvVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1108b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1108b c1108b = (C1108b) obj;
            for (C0758a c0758a : acr.values()) {
                if (mo2859a(c0758a)) {
                    if (!c1108b.mo2859a(c0758a)) {
                        return false;
                    }
                    if (!mo2860b(c0758a).equals(c1108b.mo2860b(c0758a))) {
                        return false;
                    }
                } else if (c1108b.mo2859a(c0758a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0758a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kQ();
        }

        public CoverInfo getCoverInfo() {
            return this.adL;
        }

        public CoverPhoto getCoverPhoto() {
            return this.adM;
        }

        public int getLayout() {
            return this.adN;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasCoverInfo() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0758a c0758a : acr.values()) {
                int hashCode;
                if (mo2859a(c0758a)) {
                    hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        C1106a kO() {
            return this.adL;
        }

        C1107b kP() {
            return this.adM;
        }

        public C1108b kQ() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            kv kvVar = CREATOR;
            kv.m1332a(this, out, flags);
        }
    }

    public static final class C1109c extends hy implements SafeParcelable, Image {
        public static final ky CREATOR = new ky();
        private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
        private final Set<Integer> acs;
        private String qY;
        private final int xM;

        static {
            acr.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0758a.m2725j(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C1109c() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        public C1109c(String str) {
            this.acs = new HashSet();
            this.xM = 1;
            this.qY = str;
            this.acs.add(Integer.valueOf(2));
        }

        C1109c(Set<Integer> set, int i, String str) {
            this.acs = set;
            this.xM = i;
            this.qY = str;
        }

        protected boolean mo2859a(C0758a c0758a) {
            return this.acs.contains(Integer.valueOf(c0758a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object mo2860b(C0758a c0758a) {
            switch (c0758a.fN()) {
                case 2:
                    return this.qY;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
            }
        }

        public int describeContents() {
            ky kyVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1109c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1109c c1109c = (C1109c) obj;
            for (C0758a c0758a : acr.values()) {
                if (mo2859a(c0758a)) {
                    if (!c1109c.mo2859a(c0758a)) {
                        return false;
                    }
                    if (!mo2860b(c0758a).equals(c1109c.mo2860b(c0758a))) {
                        return false;
                    }
                } else if (c1109c.mo2859a(c0758a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0758a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kT();
        }

        public String getUrl() {
            return this.qY;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasUrl() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (C0758a c0758a : acr.values()) {
                int hashCode;
                if (mo2859a(c0758a)) {
                    hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1109c kT() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            ky kyVar = CREATOR;
            ky.m1335a(this, out, flags);
        }
    }

    public static final class C1110d extends hy implements SafeParcelable, Name {
        public static final kz CREATOR = new kz();
        private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
        private String acQ;
        private String acT;
        private final Set<Integer> acs;
        private String adQ;
        private String adR;
        private String adS;
        private String adT;
        private final int xM;

        static {
            acr.put("familyName", C0758a.m2725j("familyName", 2));
            acr.put("formatted", C0758a.m2725j("formatted", 3));
            acr.put("givenName", C0758a.m2725j("givenName", 4));
            acr.put("honorificPrefix", C0758a.m2725j("honorificPrefix", 5));
            acr.put("honorificSuffix", C0758a.m2725j("honorificSuffix", 6));
            acr.put("middleName", C0758a.m2725j("middleName", 7));
        }

        public C1110d() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1110d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.acs = set;
            this.xM = i;
            this.acQ = str;
            this.adQ = str2;
            this.acT = str3;
            this.adR = str4;
            this.adS = str5;
            this.adT = str6;
        }

        protected boolean mo2859a(C0758a c0758a) {
            return this.acs.contains(Integer.valueOf(c0758a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object mo2860b(C0758a c0758a) {
            switch (c0758a.fN()) {
                case 2:
                    return this.acQ;
                case 3:
                    return this.adQ;
                case 4:
                    return this.acT;
                case 5:
                    return this.adR;
                case 6:
                    return this.adS;
                case 7:
                    return this.adT;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
            }
        }

        public int describeContents() {
            kz kzVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1110d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1110d c1110d = (C1110d) obj;
            for (C0758a c0758a : acr.values()) {
                if (mo2859a(c0758a)) {
                    if (!c1110d.mo2859a(c0758a)) {
                        return false;
                    }
                    if (!mo2860b(c0758a).equals(c1110d.mo2860b(c0758a))) {
                        return false;
                    }
                } else if (c1110d.mo2859a(c0758a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0758a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kU();
        }

        public String getFamilyName() {
            return this.acQ;
        }

        public String getFormatted() {
            return this.adQ;
        }

        public String getGivenName() {
            return this.acT;
        }

        public String getHonorificPrefix() {
            return this.adR;
        }

        public String getHonorificSuffix() {
            return this.adS;
        }

        public String getMiddleName() {
            return this.adT;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasFamilyName() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.acs.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (C0758a c0758a : acr.values()) {
                int hashCode;
                if (mo2859a(c0758a)) {
                    hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1110d kU() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            kz kzVar = CREATOR;
            kz.m1336a(this, out, flags);
        }
    }

    public static final class C1111f extends hy implements SafeParcelable, Organizations {
        public static final la CREATOR = new la();
        private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
        private int AT;
        private String HY;
        private String Mp;
        private String acP;
        private final Set<Integer> acs;
        private String adU;
        private String adV;
        private boolean adW;
        private String adf;
        private String mName;
        private final int xM;

        static {
            acr.put("department", C0758a.m2725j("department", 2));
            acr.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0758a.m2725j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            acr.put("endDate", C0758a.m2725j("endDate", 4));
            acr.put("location", C0758a.m2725j("location", 5));
            acr.put("name", C0758a.m2725j("name", 6));
            acr.put("primary", C0758a.m2724i("primary", 7));
            acr.put("startDate", C0758a.m2725j("startDate", 8));
            acr.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0758a.m2725j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            acr.put("type", C0758a.m2718a("type", 10, new hv().m2716f("work", 0).m2716f("school", 1), false));
        }

        public C1111f() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1111f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.acs = set;
            this.xM = i;
            this.adU = str;
            this.Mp = str2;
            this.acP = str3;
            this.adV = str4;
            this.mName = str5;
            this.adW = z;
            this.adf = str6;
            this.HY = str7;
            this.AT = i2;
        }

        protected boolean mo2859a(C0758a c0758a) {
            return this.acs.contains(Integer.valueOf(c0758a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object mo2860b(C0758a c0758a) {
            switch (c0758a.fN()) {
                case 2:
                    return this.adU;
                case 3:
                    return this.Mp;
                case 4:
                    return this.acP;
                case 5:
                    return this.adV;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.adW);
                case 8:
                    return this.adf;
                case 9:
                    return this.HY;
                case 10:
                    return Integer.valueOf(this.AT);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
            }
        }

        public int describeContents() {
            la laVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1111f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1111f c1111f = (C1111f) obj;
            for (C0758a c0758a : acr.values()) {
                if (mo2859a(c0758a)) {
                    if (!c1111f.mo2859a(c0758a)) {
                        return false;
                    }
                    if (!mo2860b(c0758a).equals(c1111f.mo2860b(c0758a))) {
                        return false;
                    }
                } else if (c1111f.mo2859a(c0758a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0758a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kV();
        }

        public String getDepartment() {
            return this.adU;
        }

        public String getDescription() {
            return this.Mp;
        }

        public String getEndDate() {
            return this.acP;
        }

        public String getLocation() {
            return this.adV;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.adf;
        }

        public String getTitle() {
            return this.HY;
        }

        public int getType() {
            return this.AT;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasDepartment() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.acs.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.acs.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.acs.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.acs.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (C0758a c0758a : acr.values()) {
                int hashCode;
                if (mo2859a(c0758a)) {
                    hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.adW;
        }

        public C1111f kV() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            la laVar = CREATOR;
            la.m1337a(this, out, flags);
        }
    }

    public static final class C1112g extends hy implements SafeParcelable, PlacesLived {
        public static final lb CREATOR = new lb();
        private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
        private final Set<Integer> acs;
        private boolean adW;
        private String mValue;
        private final int xM;

        static {
            acr.put("primary", C0758a.m2724i("primary", 2));
            acr.put("value", C0758a.m2725j("value", 3));
        }

        public C1112g() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1112g(Set<Integer> set, int i, boolean z, String str) {
            this.acs = set;
            this.xM = i;
            this.adW = z;
            this.mValue = str;
        }

        protected boolean mo2859a(C0758a c0758a) {
            return this.acs.contains(Integer.valueOf(c0758a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object mo2860b(C0758a c0758a) {
            switch (c0758a.fN()) {
                case 2:
                    return Boolean.valueOf(this.adW);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
            }
        }

        public int describeContents() {
            lb lbVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1112g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1112g c1112g = (C1112g) obj;
            for (C0758a c0758a : acr.values()) {
                if (mo2859a(c0758a)) {
                    if (!c1112g.mo2859a(c0758a)) {
                        return false;
                    }
                    if (!mo2860b(c0758a).equals(c1112g.mo2860b(c0758a))) {
                        return false;
                    }
                } else if (c1112g.mo2859a(c0758a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0758a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kW();
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasPrimary() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0758a c0758a : acr.values()) {
                int hashCode;
                if (mo2859a(c0758a)) {
                    hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.adW;
        }

        public C1112g kW() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            lb lbVar = CREATOR;
            lb.m1338a(this, out, flags);
        }
    }

    public static final class C1113h extends hy implements SafeParcelable, Urls {
        public static final lc CREATOR = new lc();
        private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
        private int AT;
        private final Set<Integer> acs;
        private String adX;
        private final int adY;
        private String mValue;
        private final int xM;

        static {
            acr.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0758a.m2725j(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            acr.put("type", C0758a.m2718a("type", 6, new hv().m2716f("home", 0).m2716f("work", 1).m2716f("blog", 2).m2716f(Scopes.PROFILE, 3).m2716f("other", 4).m2716f("otherProfile", 5).m2716f("contributor", 6).m2716f("website", 7), false));
            acr.put("value", C0758a.m2725j("value", 4));
        }

        public C1113h() {
            this.adY = 4;
            this.xM = 2;
            this.acs = new HashSet();
        }

        C1113h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.adY = 4;
            this.acs = set;
            this.xM = i;
            this.adX = str;
            this.AT = i2;
            this.mValue = str2;
        }

        protected boolean mo2859a(C0758a c0758a) {
            return this.acs.contains(Integer.valueOf(c0758a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object mo2860b(C0758a c0758a) {
            switch (c0758a.fN()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.adX;
                case 6:
                    return Integer.valueOf(this.AT);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
            }
        }

        public int describeContents() {
            lc lcVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1113h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1113h c1113h = (C1113h) obj;
            for (C0758a c0758a : acr.values()) {
                if (mo2859a(c0758a)) {
                    if (!c1113h.mo2859a(c0758a)) {
                        return false;
                    }
                    if (!mo2860b(c0758a).equals(c1113h.mo2860b(c0758a))) {
                        return false;
                    }
                } else if (c1113h.mo2859a(c0758a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0758a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kY();
        }

        public String getLabel() {
            return this.adX;
        }

        public int getType() {
            return this.AT;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasLabel() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0758a c0758a : acr.values()) {
                int hashCode;
                if (mo2859a(c0758a)) {
                    hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        @Deprecated
        public int kX() {
            return 4;
        }

        public C1113h kY() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            lc lcVar = CREATOR;
            lc.m1339a(this, out, flags);
        }
    }

    static {
        acr.put("aboutMe", C0758a.m2725j("aboutMe", 2));
        acr.put("ageRange", C0758a.m2719a("ageRange", 3, C1105a.class));
        acr.put("birthday", C0758a.m2725j("birthday", 4));
        acr.put("braggingRights", C0758a.m2725j("braggingRights", 5));
        acr.put("circledByCount", C0758a.m2722g("circledByCount", 6));
        acr.put("cover", C0758a.m2719a("cover", 7, C1108b.class));
        acr.put("currentLocation", C0758a.m2725j("currentLocation", 8));
        acr.put("displayName", C0758a.m2725j("displayName", 9));
        acr.put("gender", C0758a.m2718a("gender", 12, new hv().m2716f("male", 0).m2716f("female", 1).m2716f("other", 2), false));
        acr.put("id", C0758a.m2725j("id", 14));
        acr.put("image", C0758a.m2719a("image", 15, C1109c.class));
        acr.put("isPlusUser", C0758a.m2724i("isPlusUser", 16));
        acr.put("language", C0758a.m2725j("language", 18));
        acr.put("name", C0758a.m2719a("name", 19, C1110d.class));
        acr.put("nickname", C0758a.m2725j("nickname", 20));
        acr.put("objectType", C0758a.m2718a("objectType", 21, new hv().m2716f("person", 0).m2716f("page", 1), false));
        acr.put("organizations", C0758a.m2720b("organizations", 22, C1111f.class));
        acr.put("placesLived", C0758a.m2720b("placesLived", 23, C1112g.class));
        acr.put("plusOneCount", C0758a.m2722g("plusOneCount", 24));
        acr.put("relationshipStatus", C0758a.m2718a("relationshipStatus", 25, new hv().m2716f("single", 0).m2716f("in_a_relationship", 1).m2716f("engaged", 2).m2716f("married", 3).m2716f("its_complicated", 4).m2716f("open_relationship", 5).m2716f("widowed", 6).m2716f("in_domestic_partnership", 7).m2716f("in_civil_union", 8), false));
        acr.put("tagline", C0758a.m2725j("tagline", 26));
        acr.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0758a.m2725j(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        acr.put("urls", C0758a.m2720b("urls", 28, C1113h.class));
        acr.put("verified", C0758a.m2724i("verified", 29));
    }

    public ks() {
        this.xM = 2;
        this.acs = new HashSet();
    }

    public ks(String str, String str2, C1109c c1109c, int i, String str3) {
        this.xM = 2;
        this.acs = new HashSet();
        this.Ln = str;
        this.acs.add(Integer.valueOf(9));
        this.xG = str2;
        this.acs.add(Integer.valueOf(14));
        this.adx = c1109c;
        this.acs.add(Integer.valueOf(15));
        this.adB = i;
        this.acs.add(Integer.valueOf(21));
        this.qY = str3;
        this.acs.add(Integer.valueOf(27));
    }

    ks(Set<Integer> set, int i, String str, C1105a c1105a, String str2, String str3, int i2, C1108b c1108b, String str4, String str5, int i3, String str6, C1109c c1109c, boolean z, String str7, C1110d c1110d, String str8, int i4, List<C1111f> list, List<C1112g> list2, int i5, int i6, String str9, String str10, List<C1113h> list3, boolean z2) {
        this.acs = set;
        this.xM = i;
        this.adq = str;
        this.adr = c1105a;
        this.ads = str2;
        this.adt = str3;
        this.adu = i2;
        this.adv = c1108b;
        this.adw = str4;
        this.Ln = str5;
        this.ml = i3;
        this.xG = str6;
        this.adx = c1109c;
        this.ady = z;
        this.Ar = str7;
        this.adz = c1110d;
        this.adA = str8;
        this.adB = i4;
        this.adC = list;
        this.adD = list2;
        this.adE = i5;
        this.adF = i6;
        this.adG = str9;
        this.qY = str10;
        this.adH = list3;
        this.adI = z2;
    }

    public static ks m3717i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ks bG = CREATOR.bG(obtain);
        obtain.recycle();
        return bG;
    }

    protected boolean mo2859a(C0758a c0758a) {
        return this.acs.contains(Integer.valueOf(c0758a.fN()));
    }

    protected Object aF(String str) {
        return null;
    }

    protected boolean aG(String str) {
        return false;
    }

    protected Object mo2860b(C0758a c0758a) {
        switch (c0758a.fN()) {
            case 2:
                return this.adq;
            case 3:
                return this.adr;
            case 4:
                return this.ads;
            case 5:
                return this.adt;
            case 6:
                return Integer.valueOf(this.adu);
            case 7:
                return this.adv;
            case 8:
                return this.adw;
            case 9:
                return this.Ln;
            case 12:
                return Integer.valueOf(this.ml);
            case 14:
                return this.xG;
            case 15:
                return this.adx;
            case 16:
                return Boolean.valueOf(this.ady);
            case 18:
                return this.Ar;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.adz;
            case PathGenerator.SUBDIVISIONS /*20*/:
                return this.adA;
            case 21:
                return Integer.valueOf(this.adB);
            case 22:
                return this.adC;
            case 23:
                return this.adD;
            case 24:
                return Integer.valueOf(this.adE);
            case 25:
                return Integer.valueOf(this.adF);
            case 26:
                return this.adG;
            case 27:
                return this.qY;
            case 28:
                return this.adH;
            case 29:
                return Boolean.valueOf(this.adI);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
        }
    }

    public int describeContents() {
        kt ktVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ks)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ks ksVar = (ks) obj;
        for (C0758a c0758a : acr.values()) {
            if (mo2859a(c0758a)) {
                if (!ksVar.mo2859a(c0758a)) {
                    return false;
                }
                if (!mo2860b(c0758a).equals(ksVar.mo2860b(c0758a))) {
                    return false;
                }
            } else if (ksVar.mo2859a(c0758a)) {
                return false;
            }
        }
        return true;
    }

    public HashMap<String, C0758a<?, ?>> fG() {
        return acr;
    }

    public /* synthetic */ Object freeze() {
        return kM();
    }

    public String getAboutMe() {
        return this.adq;
    }

    public AgeRange getAgeRange() {
        return this.adr;
    }

    public String getBirthday() {
        return this.ads;
    }

    public String getBraggingRights() {
        return this.adt;
    }

    public int getCircledByCount() {
        return this.adu;
    }

    public Cover getCover() {
        return this.adv;
    }

    public String getCurrentLocation() {
        return this.adw;
    }

    public String getDisplayName() {
        return this.Ln;
    }

    public int getGender() {
        return this.ml;
    }

    public String getId() {
        return this.xG;
    }

    public Image getImage() {
        return this.adx;
    }

    public String getLanguage() {
        return this.Ar;
    }

    public Name getName() {
        return this.adz;
    }

    public String getNickname() {
        return this.adA;
    }

    public int getObjectType() {
        return this.adB;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.adC;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.adD;
    }

    public int getPlusOneCount() {
        return this.adE;
    }

    public int getRelationshipStatus() {
        return this.adF;
    }

    public String getTagline() {
        return this.adG;
    }

    public String getUrl() {
        return this.qY;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.adH;
    }

    int getVersionCode() {
        return this.xM;
    }

    public boolean hasAboutMe() {
        return this.acs.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.acs.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.acs.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.acs.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.acs.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.acs.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.acs.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.acs.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.acs.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.acs.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.acs.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.acs.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.acs.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.acs.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.acs.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.acs.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.acs.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.acs.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.acs.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.acs.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.acs.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.acs.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.acs.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.acs.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (C0758a c0758a : acr.values()) {
            int hashCode;
            if (mo2859a(c0758a)) {
                hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.ady;
    }

    public boolean isVerified() {
        return this.adI;
    }

    C1105a kF() {
        return this.adr;
    }

    C1108b kG() {
        return this.adv;
    }

    C1109c kH() {
        return this.adx;
    }

    C1110d kI() {
        return this.adz;
    }

    List<C1111f> kJ() {
        return this.adC;
    }

    List<C1112g> kK() {
        return this.adD;
    }

    List<C1113h> kL() {
        return this.adH;
    }

    public ks kM() {
        return this;
    }

    Set<Integer> kk() {
        return this.acs;
    }

    public void writeToParcel(Parcel out, int flags) {
        kt ktVar = CREATOR;
        kt.m1330a(this, out, flags);
    }
}
