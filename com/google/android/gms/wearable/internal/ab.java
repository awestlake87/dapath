package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface ab extends IInterface {

    public static abstract class C0975a extends Binder implements ab {

        private static class C0974a implements ab {
            private IBinder kq;

            C0974a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo2368Z(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2369a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2370a(am amVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (amVar != null) {
                        obtain.writeInt(1);
                        amVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2371a(aq aqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (aqVar != null) {
                        obtain.writeInt(1);
                        aqVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2372a(as asVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (asVar != null) {
                        obtain.writeInt(1);
                        asVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2373a(C0983p c0983p) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c0983p != null) {
                        obtain.writeInt(1);
                        c0983p.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2374a(C0984r c0984r) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c0984r != null) {
                        obtain.writeInt(1);
                        c0984r.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2375a(C0985t c0985t) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c0985t != null) {
                        obtain.writeInt(1);
                        c0985t.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2376a(C0986v c0986v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c0986v != null) {
                        obtain.writeInt(1);
                        c0986v.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2377a(C0987x c0987x) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c0987x != null) {
                        obtain.writeInt(1);
                        c0987x.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2378a(C0988z c0988z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c0988z != null) {
                        obtain.writeInt(1);
                        c0988z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public C0975a() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        public static ab bw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ab)) ? new C0974a(iBinder) : (ab) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            as asVar = null;
            switch (code) {
                case 2:
                    C0984r c0984r;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c0984r = (C0984r) C0984r.CREATOR.createFromParcel(data);
                    }
                    mo2374a(c0984r);
                    reply.writeNoException();
                    return true;
                case 3:
                    am amVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        amVar = (am) am.CREATOR.createFromParcel(data);
                    }
                    mo2370a(amVar);
                    reply.writeNoException();
                    return true;
                case 4:
                    C0986v c0986v;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c0986v = (C0986v) C0986v.CREATOR.createFromParcel(data);
                    }
                    mo2376a(c0986v);
                    reply.writeNoException();
                    return true;
                case 5:
                    DataHolder x;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    mo2368Z(x);
                    reply.writeNoException();
                    return true;
                case 6:
                    C0983p c0983p;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c0983p = (C0983p) C0983p.CREATOR.createFromParcel(data);
                    }
                    mo2373a(c0983p);
                    reply.writeNoException();
                    return true;
                case 7:
                    aq aqVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        aqVar = (aq) aq.CREATOR.createFromParcel(data);
                    }
                    mo2371a(aqVar);
                    reply.writeNoException();
                    return true;
                case 8:
                    C0987x c0987x;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c0987x = (C0987x) C0987x.CREATOR.createFromParcel(data);
                    }
                    mo2377a(c0987x);
                    reply.writeNoException();
                    return true;
                case 9:
                    C0988z c0988z;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c0988z = (C0988z) C0988z.CREATOR.createFromParcel(data);
                    }
                    mo2378a(c0988z);
                    reply.writeNoException();
                    return true;
                case 10:
                    C0985t c0985t;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c0985t = (C0985t) C0985t.CREATOR.createFromParcel(data);
                    }
                    mo2375a(c0985t);
                    reply.writeNoException();
                    return true;
                case 11:
                    Status createFromParcel;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(data);
                    }
                    mo2369a(createFromParcel);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        asVar = (as) as.CREATOR.createFromParcel(data);
                    }
                    mo2372a(asVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo2368Z(DataHolder dataHolder) throws RemoteException;

    void mo2369a(Status status) throws RemoteException;

    void mo2370a(am amVar) throws RemoteException;

    void mo2371a(aq aqVar) throws RemoteException;

    void mo2372a(as asVar) throws RemoteException;

    void mo2373a(C0983p c0983p) throws RemoteException;

    void mo2374a(C0984r c0984r) throws RemoteException;

    void mo2375a(C0985t c0985t) throws RemoteException;

    void mo2376a(C0986v c0986v) throws RemoteException;

    void mo2377a(C0987x c0987x) throws RemoteException;

    void mo2378a(C0988z c0988z) throws RemoteException;
}
