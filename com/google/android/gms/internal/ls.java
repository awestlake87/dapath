package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0251c;
import com.google.android.gms.dynamic.C0255g;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.ln.C0788a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class ls extends C0255g<ln> {
    private static ls akN;

    protected ls() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static lk m2809a(Activity activity, C0251c c0251c, WalletFragmentOptions walletFragmentOptions, ll llVar) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((ln) nj().m469G(activity)).mo1897a(C1030e.m3260h(activity), c0251c, walletFragmentOptions, llVar);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static ls nj() {
        if (akN == null) {
            akN = new ls();
        }
        return akN;
    }

    protected ln bv(IBinder iBinder) {
        return C0788a.br(iBinder);
    }

    protected /* synthetic */ Object mo1585d(IBinder iBinder) {
        return bv(iBinder);
    }
}
