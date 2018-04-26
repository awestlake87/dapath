package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.C0973c;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.ab.C0975a;

public interface ad extends IInterface {

    public static abstract class C0979a extends Binder implements ad {

        private static class C0978a implements ad {
            private IBinder kq;

            C0978a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo2383a(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2384a(ab abVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void mo2385a(ab abVar, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2386a(ab abVar, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
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

            public void mo2387a(ab abVar, C0973c c0973c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (c0973c != null) {
                        obtain.writeInt(1);
                        c0973c.writeToParcel(obtain, 0);
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

            public void mo2388a(ab abVar, ao aoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (aoVar != null) {
                        obtain.writeInt(1);
                        aoVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2389a(ab abVar, C0980b c0980b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (c0980b != null) {
                        obtain.writeInt(1);
                        c0980b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2390a(ab abVar, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.kq.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void mo2391b(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2392b(ab abVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void mo2393c(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2394c(ab abVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void mo2395d(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2396e(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2397f(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2398g(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2399h(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ad by(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ad)) ? new C0978a(iBinder) : (ad) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ao aoVar = null;
            ab bw;
            Uri uri;
            switch (code) {
                case 2:
                    C0973c c0973c;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C0975a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        c0973c = (C0973c) C0973c.CREATOR.createFromParcel(data);
                    }
                    mo2387a(bw, c0973c);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2383a(C0975a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2391b(C0975a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2393c(C0975a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    PutDataRequest putDataRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C0975a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(data);
                    }
                    mo2386a(bw, putDataRequest);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C0975a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    mo2384a(bw, uri);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2395d(C0975a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C0975a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    mo2392b(bw, uri);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C0975a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    mo2394c(bw, uri);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2390a(C0975a.bw(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 13:
                    Asset asset;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C0975a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(data);
                    }
                    mo2385a(bw, asset);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2396e(C0975a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2397f(C0975a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    C0980b c0980b;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C0975a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        c0980b = (C0980b) C0980b.CREATOR.createFromParcel(data);
                    }
                    mo2389a(bw, c0980b);
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C0975a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        aoVar = (ao) ao.CREATOR.createFromParcel(data);
                    }
                    mo2388a(bw, aoVar);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2398g(C0975a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    mo2399h(C0975a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo2383a(ab abVar) throws RemoteException;

    void mo2384a(ab abVar, Uri uri) throws RemoteException;

    void mo2385a(ab abVar, Asset asset) throws RemoteException;

    void mo2386a(ab abVar, PutDataRequest putDataRequest) throws RemoteException;

    void mo2387a(ab abVar, C0973c c0973c) throws RemoteException;

    void mo2388a(ab abVar, ao aoVar) throws RemoteException;

    void mo2389a(ab abVar, C0980b c0980b) throws RemoteException;

    void mo2390a(ab abVar, String str, String str2, byte[] bArr) throws RemoteException;

    void mo2391b(ab abVar) throws RemoteException;

    void mo2392b(ab abVar, Uri uri) throws RemoteException;

    void mo2393c(ab abVar) throws RemoteException;

    void mo2394c(ab abVar, Uri uri) throws RemoteException;

    void mo2395d(ab abVar) throws RemoteException;

    void mo2396e(ab abVar) throws RemoteException;

    void mo2397f(ab abVar) throws RemoteException;

    void mo2398g(ab abVar) throws RemoteException;

    void mo2399h(ab abVar) throws RemoteException;
}
