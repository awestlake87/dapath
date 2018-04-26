package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.lf;
import com.google.android.gms.internal.lq;
import com.google.android.gms.internal.lr;
import com.google.android.gms.internal.lt;
import com.google.android.gms.internal.lu;
import com.google.android.gms.wallet.wobs.C0530r;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api(yI, yH, new Scope[0]);
    public static final Payments Payments = new lq();
    public static final C0530r ajZ = new lu();
    public static final lf aka = new lt();
    private static final C0149c<lr> yH = new C0149c();
    private static final C0148b<lr, WalletOptions> yI = new C09581();

    static class C09581 implements C0148b<lr, WalletOptions> {
        C09581() {
        }

        public lr m3070a(Context context, Looper looper, gy gyVar, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            hm.m1230b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new lr(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, gyVar.getAccountName(), walletOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int akb = 0;
            private int mTheme = 0;

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.akb = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.akb;
            this.theme = builder.mTheme;
        }
    }

    public static abstract class C1201a<R extends Result> extends C1002b<R, lr> {
        public C1201a() {
            super(Wallet.yH);
        }
    }

    public static abstract class C1256b extends C1201a<Status> {
        protected /* synthetic */ Result mo2535c(Status status) {
            return m4268d(status);
        }

        protected Status m4268d(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
