package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public class C0181b {
    public static boolean m272a(int i, DriveId driveId) {
        return driveId != null || C0181b.aK(i);
    }

    public static boolean aK(int i) {
        return (6 & ((long) (1 << i))) != 0;
    }
}
