package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class bh implements bc {
    private static int m2483a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = et.m1005a(displayMetrics, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                eu.m1014D("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void mo1576b(ex exVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            eu.m1014D("Action missing from video GMSG.");
            return;
        }
        cf ca = exVar.ca();
        if (ca == null) {
            eu.m1014D("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        int a;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = exVar.getContext().getResources().getDisplayMetrics();
            a = m2483a(displayMetrics, map, "x", 0);
            int a2 = m2483a(displayMetrics, map, "y", 0);
            int a3 = m2483a(displayMetrics, map, "w", -1);
            int a4 = m2483a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && ca.aQ() == null) {
                ca.m3567c(a, a2, a3, a4);
                return;
            } else {
                ca.m3566b(a, a2, a3, a4);
                return;
            }
        }
        cj aQ = ca.aQ();
        if (aQ == null) {
            cj.m857a(exVar, "no_video_view", null);
        } else if ("click".equalsIgnoreCase(str)) {
            displayMetrics = exVar.getContext().getResources().getDisplayMetrics();
            int a5 = m2483a(displayMetrics, map, "x", 0);
            a = m2483a(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a, 0);
            aQ.m860b(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                eu.m1014D("Enabled parameter missing from controls video GMSG.");
            } else {
                aQ.m861l(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get("time");
            if (str == null) {
                eu.m1014D("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                aQ.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                eu.m1014D("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            aQ.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            aQ.ba();
        } else if ("pause".equalsIgnoreCase(str)) {
            aQ.pause();
        } else if ("play".equalsIgnoreCase(str)) {
            aQ.play();
        } else if ("show".equalsIgnoreCase(str)) {
            aQ.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            aQ.m862o((String) map.get("src"));
        } else {
            eu.m1014D("Unknown video action: " + str);
        }
    }
}
