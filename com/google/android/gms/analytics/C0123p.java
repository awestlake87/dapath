package com.google.android.gms.analytics;

import android.os.Build.VERSION;
import java.io.File;

class C0123p {
    static boolean m80N(String str) {
        if (C0123p.version() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }

    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            aa.m37A("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }
}
