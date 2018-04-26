package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.bu.C0690a;

public interface bt extends IInterface {

    public static abstract class C0688a extends Binder implements bt {

        private static class C0687a implements bt {
            private IBinder kq;

            C0687a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public bu mo1611m(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    bu j = C0690a.m2504j(obtain2.readStrongBinder());
                    return j;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0688a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static bt m2499i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bt)) ? new C0687a(iBinder) : (bt) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    bu m = mo1611m(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(m != null ? m.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    bu mo1611m(String str) throws RemoteException;
}
