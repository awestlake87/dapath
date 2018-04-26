package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class DetectedActivityCreator implements Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1476a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, detectedActivity.UY);
        C0172b.m259c(parcel, 1000, detectedActivity.getVersionCode());
        C0172b.m259c(parcel, 2, detectedActivity.UZ);
        C0172b.m235G(parcel, C);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 1000:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
