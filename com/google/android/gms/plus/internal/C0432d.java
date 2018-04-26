package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hg.C0750a;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.ie;
import com.google.android.gms.plus.internal.C0430b.C0909a;
import java.util.List;

public interface C0432d extends IInterface {

    public static abstract class C0913a extends Binder implements C0432d {

        private static class C0912a implements C0432d {
            private IBinder kq;

            C0912a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public hg mo2265a(C0430b c0430b, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.kq.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    hg J = C0750a.m2668J(obtain2.readStrongBinder());
                    return J;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2266a(ie ieVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (ieVar != null) {
                        obtain.writeInt(1);
                        ieVar.writeToParcel(obtain, 0);
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

            public void mo2267a(C0430b c0430b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2268a(C0430b c0430b, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kq.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2269a(C0430b c0430b, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void mo2270a(C0430b c0430b, ie ieVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    if (ieVar != null) {
                        obtain.writeInt(1);
                        ieVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2271a(C0430b c0430b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2272a(C0430b c0430b, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2273a(C0430b c0430b, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeStringList(list);
                    this.kq.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2274a(String str, hr hrVar, hr hrVar2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    if (hrVar != null) {
                        obtain.writeInt(1);
                        hrVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hrVar2 != null) {
                        obtain.writeInt(1);
                        hrVar2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void mo2275b(C0430b c0430b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    this.kq.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2276b(C0430b c0430b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2277c(C0430b c0430b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2279d(C0430b c0430b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2280e(C0430b c0430b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0430b != null ? c0430b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String jU() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean jV() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String jW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.kq.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0432d bm(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0432d)) ? new C0912a(iBinder) : (C0432d) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            hr hrVar = null;
            String accountName;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2271a(C0909a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2272a(C0909a.bk(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2276b(C0909a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2266a(data.readInt() != 0 ? ie.CREATOR.m1263L(data) : null);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    clearDefaultAccount();
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2267a(C0909a.bk(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2269a(C0909a.bk(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2268a(C0909a.bk(data.readStrongBinder()), data.readInt(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 16:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    hg a = mo2265a(C0909a.bk(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        asBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    removeMoment(data.readString());
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2277c(C0909a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2275b(C0909a.bk(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2273a(C0909a.bk(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2279d(C0909a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = jU();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean jV = jV();
                    reply.writeNoException();
                    reply.writeInt(jV ? 1 : 0);
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = jW();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 44:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2280e(C0909a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 45:
                    ie L;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    C0430b bk = C0909a.bk(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        L = ie.CREATOR.m1263L(data);
                    }
                    mo2270a(bk, L);
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    String readString = data.readString();
                    hr D = data.readInt() != 0 ? hr.CREATOR.m1241D(data) : null;
                    if (data.readInt() != 0) {
                        hrVar = hr.CREATOR.m1241D(data);
                    }
                    mo2274a(readString, D, hrVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    hg mo2265a(C0430b c0430b, int i, int i2, int i3, String str) throws RemoteException;

    void mo2266a(ie ieVar) throws RemoteException;

    void mo2267a(C0430b c0430b) throws RemoteException;

    void mo2268a(C0430b c0430b, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    void mo2269a(C0430b c0430b, Uri uri, Bundle bundle) throws RemoteException;

    void mo2270a(C0430b c0430b, ie ieVar) throws RemoteException;

    void mo2271a(C0430b c0430b, String str) throws RemoteException;

    void mo2272a(C0430b c0430b, String str, String str2) throws RemoteException;

    void mo2273a(C0430b c0430b, List<String> list) throws RemoteException;

    void mo2274a(String str, hr hrVar, hr hrVar2) throws RemoteException;

    void mo2275b(C0430b c0430b) throws RemoteException;

    void mo2276b(C0430b c0430b, String str) throws RemoteException;

    void mo2277c(C0430b c0430b, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    void mo2279d(C0430b c0430b, String str) throws RemoteException;

    void mo2280e(C0430b c0430b, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    String jU() throws RemoteException;

    boolean jV() throws RemoteException;

    String jW() throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
