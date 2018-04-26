package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C0252d.C0661a;

public interface hj extends IInterface {

    public static abstract class C0756a extends Binder implements hj {

        private static class C0755a implements hj {
            private IBinder kq;

            C0755a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public C0252d mo1788a(C0252d c0252d, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public static hj m2708M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hj)) ? new C0755a(iBinder) : (hj) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0252d a = mo1788a(C0661a.ag(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0252d mo1788a(C0252d c0252d, int i, int i2) throws RemoteException;
}
