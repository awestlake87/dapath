package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C0252d.C0661a;
import com.google.android.gms.internal.bt.C0688a;

public interface ar extends IInterface {

    public static abstract class C0676a extends Binder implements ar {

        private static class C0675a implements ar {
            private IBinder kq;

            C0675a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder mo1606a(C0252d c0252d, al alVar, String str, bt btVar, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    if (alVar != null) {
                        obtain.writeInt(1);
                        alVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (btVar != null) {
                        iBinder = btVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public static ar m2468g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ar)) ? new C0675a(iBinder) : (ar) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = mo1606a(C0661a.ag(data.readStrongBinder()), data.readInt() != 0 ? al.CREATOR.m785c(data) : null, data.readString(), C0688a.m2499i(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IBinder mo1606a(C0252d c0252d, al alVar, String str, bt btVar, int i) throws RemoteException;
}
