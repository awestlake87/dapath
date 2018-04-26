package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import java.util.List;

public class C0172b {
    public static int m232C(Parcel parcel) {
        return C0172b.m233E(parcel, 20293);
    }

    private static int m233E(Parcel parcel, int i) {
        parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m234F(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void m235G(Parcel parcel, int i) {
        C0172b.m234F(parcel, i);
    }

    public static void m236a(Parcel parcel, int i, byte b) {
        C0172b.m257b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m237a(Parcel parcel, int i, double d) {
        C0172b.m257b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m238a(Parcel parcel, int i, float f) {
        C0172b.m257b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m239a(Parcel parcel, int i, long j) {
        C0172b.m257b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m240a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeBundle(bundle);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m241a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m242a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m243a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int E = C0172b.m233E(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m244a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            C0172b.m257b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m245a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C0172b.m257b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m246a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            C0172b.m257b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m247a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeString(str);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m248a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeStringList(list);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m249a(Parcel parcel, int i, short s) {
        C0172b.m257b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void m250a(Parcel parcel, int i, boolean z) {
        C0172b.m257b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m251a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeByteArray(bArr);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m252a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeIntArray(iArr);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m253a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0172b.m256a(parcel, parcelable, i2);
                }
            }
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m254a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeStringArray(strArr);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m255a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int E = C0172b.m233E(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m256a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void m257b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static <T extends Parcelable> void m258b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int E = C0172b.m233E(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0172b.m256a(parcel, parcelable, 0);
                }
            }
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }

    public static void m259c(Parcel parcel, int i, int i2) {
        C0172b.m257b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m260c(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int E = C0172b.m233E(parcel, i);
            parcel.writeList(list);
            C0172b.m234F(parcel, E);
        } else if (z) {
            C0172b.m257b(parcel, i, 0);
        }
    }
}
