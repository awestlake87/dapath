package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface C0393j extends IInterface {

    public static abstract class C0856a extends Binder implements C0393j {

        private static class C0855a implements C0393j {
            private IBinder kq;

            C0855a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void onMapLoaded() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0856a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLoadedCallback");
        }

        public static C0393j aI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0393j)) ? new C0855a(iBinder) : (C0393j) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                    onMapLoaded();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onMapLoaded() throws RemoteException;
}
