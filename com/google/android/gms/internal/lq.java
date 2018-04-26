package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.C1256b;

public class lq implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, final String googleTransactionId, final String merchantTransactionId, final int requestCode) {
        googleApiClient.mo926a(new C1256b(this) {
            final /* synthetic */ lq akG;

            protected void m4685a(lr lrVar) {
                lrVar.m3736d(googleTransactionId, merchantTransactionId, requestCode);
                m1984b(Status.En);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.mo926a(new C1256b(this) {
            final /* synthetic */ lq akG;

            protected void m4679a(lr lrVar) {
                lrVar.dQ(requestCode);
                m1984b(Status.En);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.mo926a(new C1256b(this) {
            final /* synthetic */ lq akG;

            protected void m4683a(lr lrVar) {
                lrVar.m3733a(request, requestCode);
                m1984b(Status.En);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.mo926a(new C1256b(this) {
            final /* synthetic */ lq akG;

            protected void m4681a(lr lrVar) {
                lrVar.m3734a(request, requestCode);
                m1984b(Status.En);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.mo926a(new C1256b(this) {
            final /* synthetic */ lq akG;

            protected void m4687a(lr lrVar) {
                lrVar.m3735a(request);
                m1984b(Status.En);
            }
        });
    }
}
