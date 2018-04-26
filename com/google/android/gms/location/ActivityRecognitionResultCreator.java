package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1475a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m258b(parcel, 1, activityRecognitionResult.UV, false);
        C0172b.m259c(parcel, 1000, activityRecognitionResult.getVersionCode());
        C0172b.m239a(parcel, 2, activityRecognitionResult.UW);
        C0172b.m239a(parcel, 3, activityRecognitionResult.UX);
        C0172b.m235G(parcel, C);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int B = C0171a.m196B(parcel);
        int i = 0;
        List list = null;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    list = C0171a.m207c(parcel, A, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 1000:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ActivityRecognitionResult(i, list, j2, j);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
