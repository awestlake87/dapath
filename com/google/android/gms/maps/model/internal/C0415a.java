package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C0252d.C0661a;

public interface C0415a extends IInterface {

    public static abstract class C0879a extends Binder implements C0415a {

        private static class C0878a implements C0415a {
            private IBinder kq;

            C0878a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public C0252d mo2135b(Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0252d bs(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0252d bt(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0252d bu(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0252d mo2139c(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeFloat(f);
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0252d cX(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeInt(i);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0252d jR() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0415a aX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0415a)) ? new C0878a(iBinder) : (C0415a) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0252d cX;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    cX = cX(data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(cX != null ? cX.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    cX = bs(data.readString());
                    reply.writeNoException();
                    if (cX != null) {
                        iBinder = cX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    cX = bt(data.readString());
                    reply.writeNoException();
                    if (cX != null) {
                        iBinder = cX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    cX = jR();
                    reply.writeNoException();
                    if (cX != null) {
                        iBinder = cX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    cX = mo2139c(data.readFloat());
                    reply.writeNoException();
                    if (cX != null) {
                        iBinder = cX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    cX = mo2135b(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (cX != null) {
                        iBinder = cX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    cX = bu(data.readString());
                    reply.writeNoException();
                    if (cX != null) {
                        iBinder = cX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0252d mo2135b(Bitmap bitmap) throws RemoteException;

    C0252d bs(String str) throws RemoteException;

    C0252d bt(String str) throws RemoteException;

    C0252d bu(String str) throws RemoteException;

    C0252d mo2139c(float f) throws RemoteException;

    C0252d cX(int i) throws RemoteException;

    C0252d jR() throws RemoteException;
}
