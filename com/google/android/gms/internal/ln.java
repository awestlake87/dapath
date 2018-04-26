package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0251c;
import com.google.android.gms.dynamic.C0251c.C0659a;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C0252d.C0661a;
import com.google.android.gms.internal.lk.C0782a;
import com.google.android.gms.internal.ll.C0784a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface ln extends IInterface {

    public static abstract class C0788a extends Binder implements ln {

        private static class C0787a implements ln {
            private IBinder kq;

            C0787a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public lk mo1897a(C0252d c0252d, C0251c c0251c, WalletFragmentOptions walletFragmentOptions, ll llVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    obtain.writeStrongBinder(c0251c != null ? c0251c.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (llVar != null) {
                        iBinder = llVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    lk bo = C0782a.bo(obtain2.readStrongBinder());
                    return bo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public static ln br(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ln)) ? new C0787a(iBinder) : (ln) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    lk a = mo1897a(C0661a.ag(data.readStrongBinder()), C0659a.af(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, C0784a.bp(data.readStrongBinder()));
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    lk mo1897a(C0252d c0252d, C0251c c0251c, WalletFragmentOptions walletFragmentOptions, ll llVar) throws RemoteException;
}
