package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class C0204c implements Creator<CustomProperty> {
    static void m368a(CustomProperty customProperty, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, customProperty.xM);
        C0172b.m243a(parcel, 2, customProperty.JQ, i, false);
        C0172b.m247a(parcel, 3, customProperty.mValue, false);
        C0172b.m235G(parcel, C);
    }

    public CustomProperty aB(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < B) {
            CustomPropertyKey customPropertyKey2;
            int g;
            String str2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = C0171a.m212g(parcel, A);
                    str2 = str3;
                    break;
                case 2:
                    g = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) C0171a.m201a(parcel, A, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 3:
                    str2 = C0171a.m220o(parcel, A);
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
            }
            i = g;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == B) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CustomProperty[] bx(int i) {
        return new CustomProperty[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bx(x0);
    }
}
