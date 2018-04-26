package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

class C0578a implements C0120m {
    private static Object tq = new Object();
    private static C0578a tr;
    private Context mContext;
    private Info ts;
    private long tt;
    private String tu;
    private boolean tv = false;
    private Object tw = new Object();

    C0578a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    static String m1869H(String str) {
        if (ak.m49W("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, ak.m49W("MD5").digest(str.getBytes()))});
    }

    private boolean m1870I(String str) {
        try {
            String H = C0578a.m1869H(str);
            aa.m39C("Storing hashed adid.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientIdData", 0);
            openFileOutput.write(H.getBytes());
            openFileOutput.close();
            this.tu = H;
            return true;
        } catch (FileNotFoundException e) {
            aa.m37A("Error creating hash file.");
            return false;
        } catch (IOException e2) {
            aa.m37A("Error writing to hash file.");
            return false;
        }
    }

    private boolean m1871a(Info info, Info info2) {
        String str = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        C0583h.m1915u(this.mContext);
        C0583h cv = C0583h.cv();
        String value = cv.getValue("&cid");
        synchronized (this.tw) {
            if (!this.tv) {
                this.tu = C0578a.m1873t(this.mContext);
                this.tv = true;
            } else if (TextUtils.isEmpty(this.tu)) {
                if (info != null) {
                    str = info.getId();
                }
                if (str == null) {
                    boolean I = m1870I(id + value);
                    return I;
                }
                this.tu = C0578a.m1869H(str + value);
            }
            Object H = C0578a.m1869H(id + value);
            if (TextUtils.isEmpty(H)) {
                return false;
            } else if (H.equals(this.tu)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.tu)) {
                    str = value;
                } else {
                    aa.m39C("Resetting the client id because Advertising Id changed.");
                    str = cv.cw();
                    aa.m39C("New client Id: " + str);
                }
                I = m1870I(id + str);
                return I;
            }
        }
    }

    public static C0120m m1872s(Context context) {
        if (tr == null) {
            synchronized (tq) {
                if (tr == null) {
                    tr = new C0578a(context);
                }
            }
        }
        return tr;
    }

    static String m1873t(Context context) {
        String str = null;
        try {
            FileInputStream openFileInput = context.openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                aa.m40D("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                context.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                aa.m38B("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    str = str2;
                    aa.m40D("Error reading Hash file, deleting it.");
                    context.deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            aa.m40D("Error reading Hash file, deleting it.");
            context.deleteFile("gaClientIdData");
            return str;
        }
    }

    Info ck() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (IllegalStateException e) {
            aa.m40D("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (GooglePlayServicesRepairableException e2) {
            aa.m40D("GooglePlayServicesRepairableException getting Ad Id Info");
        } catch (IOException e3) {
            aa.m40D("IOException getting Ad Id Info");
        } catch (GooglePlayServicesNotAvailableException e4) {
            aa.m40D("GooglePlayServicesNotAvailableException getting Ad Id Info");
        } catch (Exception e5) {
            aa.m40D("Unknown exception. Could not get the ad Id.");
        }
        return info;
    }

    public String getValue(String field) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.tt > 1000) {
            Info ck = ck();
            if (m1871a(this.ts, ck)) {
                this.ts = ck;
            } else {
                this.ts = new Info("", false);
            }
            this.tt = currentTimeMillis;
        }
        if (this.ts != null) {
            if ("&adid".equals(field)) {
                return this.ts.getId();
            }
            if ("&ate".equals(field)) {
                return this.ts.isLimitAdTrackingEnabled() ? "0" : "1";
            }
        }
        return null;
    }
}
