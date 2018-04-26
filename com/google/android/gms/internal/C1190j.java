package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.C1094i.C0354a;
import java.io.IOException;

public class C1190j extends C1094i {

    class C0356a {
        private String kd;
        private boolean ke;
        final /* synthetic */ C1190j kf;

        public C0356a(C1190j c1190j, String str, boolean z) {
            this.kf = c1190j;
            this.kd = str;
            this.ke = z;
        }

        public String getId() {
            return this.kd;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.ke;
        }
    }

    protected C1190j(Context context, C0365m c0365m, C0366n c0366n) {
        super(context, c0365m, c0366n);
    }

    public static C1190j m4072a(String str, Context context) {
        C0365m c0715e = new C0715e();
        C1094i.m3662a(str, context, c0715e);
        return new C1190j(context, c0715e, new C0793p(239));
    }

    protected void mo2851c(Context context) {
        super.mo2851c(context);
        try {
            C0356a i = m4075i(context);
            m2641a(28, i.isLimitAdTrackingEnabled() ? 1 : 0);
            String id = i.getId();
            if (id != null) {
                m2641a(26, 5);
                m2642a(24, id);
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            try {
                m2642a(24, C1094i.m3665f(context));
            } catch (IOException e2) {
            } catch (C0354a e3) {
            }
        }
    }

    protected void mo3146d(Context context) {
        long j = 1;
        super.mo2851c(context);
        try {
            m2642a(24, C1094i.m3665f(context));
        } catch (C0354a e) {
        }
        try {
            C0356a i = m4075i(context);
            try {
                if (!i.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                m2641a(28, j);
                String id = i.getId();
                if (id != null) {
                    m2642a(30, id);
                }
            } catch (IOException e2) {
            }
        } catch (GooglePlayServicesNotAvailableException e3) {
        } catch (IOException e4) {
            m2641a(28, 1);
        }
    }

    C0356a m4075i(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.jQ.mo1692a(bArr, true);
            }
            return new C0356a(this, str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
