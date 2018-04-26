package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C0252d.C0661a;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C0820a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C0826a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C0828a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.C0834a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.C0836a;
import com.google.android.gms.maps.model.internal.C0415a;
import com.google.android.gms.maps.model.internal.C0415a.C0879a;

public interface C0386c extends IInterface {

    public static abstract class C0842a extends Binder implements C0386c {

        private static class C0841a implements C0386c {
            private IBinder kq;

            C0841a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IMapViewDelegate mo2089a(C0252d c0252d, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate aC = C0828a.aC(obtain2.readStrongBinder());
                    return aC;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaViewDelegate mo2090a(C0252d c0252d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaViewDelegate aV = C0836a.aV(obtain2.readStrongBinder());
                    return aV;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2091a(C0252d c0252d, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    obtain.writeInt(i);
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void mo2092h(C0252d c0252d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate mo2093i(C0252d c0252d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate aB = C0826a.aB(obtain2.readStrongBinder());
                    return aB;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaFragmentDelegate mo2094j(C0252d c0252d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaFragmentDelegate aU = C0834a.aU(obtain2.readStrongBinder());
                    return aU;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate jH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate av = C0820a.av(obtain2.readStrongBinder());
                    return av;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0415a jI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0415a aX = C0879a.aX(obtain2.readStrongBinder());
                    return aX;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0386c ax(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0386c)) ? new C0841a(iBinder) : (C0386c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    mo2092h(C0661a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate i = mo2093i(C0661a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    if (i != null) {
                        iBinder = i.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = mo2089a(C0661a.ag(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate jH = jH();
                    reply.writeNoException();
                    if (jH != null) {
                        iBinder = jH.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C0415a jI = jI();
                    reply.writeNoException();
                    if (jI != null) {
                        iBinder = jI.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    mo2091a(C0661a.ag(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate a2 = mo2090a(C0661a.ag(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate j = mo2094j(C0661a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    if (j != null) {
                        iBinder = j.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate mo2089a(C0252d c0252d, GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaViewDelegate mo2090a(C0252d c0252d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void mo2091a(C0252d c0252d, int i) throws RemoteException;

    void mo2092h(C0252d c0252d) throws RemoteException;

    IMapFragmentDelegate mo2093i(C0252d c0252d) throws RemoteException;

    IStreetViewPanoramaFragmentDelegate mo2094j(C0252d c0252d) throws RemoteException;

    ICameraUpdateFactoryDelegate jH() throws RemoteException;

    C0415a jI() throws RemoteException;
}
