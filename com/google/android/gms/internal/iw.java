package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.hb.C1092e;
import com.google.android.gms.internal.ix.C0762a;
import com.google.android.gms.internal.iy.C0764a;

public class iw extends hb<iy> {
    private C1097a UG;
    private final int mTheme;
    private Activity og;
    private final String yQ;

    public static final class C1097a extends C0762a {
        private final int FW;
        private Activity og;

        public C1097a(int i, Activity activity) {
            this.FW = i;
            this.og = activity;
        }

        private void setActivity(Activity activity) {
            this.og = activity;
        }

        public void mo1797g(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.og.createPendingResult(this.FW, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.og, this.FW);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.og.createPendingResult(this.FW, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public iw(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.yQ = str;
        this.og = activity;
        this.mTheme = i;
    }

    public void m3684a(UserAddressRequest userAddressRequest, int i) {
        iU();
        this.UG = new C1097a(i, this.og);
        Bundle bundle;
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.yQ)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.yQ, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            iT().mo1798a(this.UG, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.UG.mo1797g(1, bundle);
        }
    }

    protected void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException {
        hiVar.mo1769d(c1092e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    protected iy an(IBinder iBinder) {
        return C0764a.ap(iBinder);
    }

    protected String bu() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String bv() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public void disconnect() {
        super.disconnect();
        if (this.UG != null) {
            this.UG.setActivity(null);
            this.UG = null;
        }
    }

    protected iy iT() {
        return (iy) super.ft();
    }

    protected void iU() {
        super.cn();
    }

    protected /* synthetic */ IInterface mo2555x(IBinder iBinder) {
        return an(iBinder);
    }
}
