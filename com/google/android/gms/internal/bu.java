package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C0252d.C0661a;
import com.google.android.gms.internal.bv.C0692a;

public interface bu extends IInterface {

    public static abstract class C0690a extends Binder implements bu {

        private static class C0689a implements bu {
            private IBinder kq;

            C0689a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo1612a(C0252d c0252d, ai aiVar, String str, bv bvVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    if (aiVar != null) {
                        obtain.writeInt(1);
                        aiVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bvVar != null) {
                        iBinder = bvVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1613a(C0252d c0252d, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    if (aiVar != null) {
                        obtain.writeInt(1);
                        aiVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bvVar != null) {
                        iBinder = bvVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1614a(C0252d c0252d, al alVar, ai aiVar, String str, bv bvVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    if (alVar != null) {
                        obtain.writeInt(1);
                        alVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aiVar != null) {
                        obtain.writeInt(1);
                        aiVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bvVar != null) {
                        iBinder = bvVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1615a(C0252d c0252d, al alVar, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    if (alVar != null) {
                        obtain.writeInt(1);
                        alVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aiVar != null) {
                        obtain.writeInt(1);
                        aiVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bvVar != null) {
                        iBinder = bvVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
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

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0252d getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kq.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0690a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static bu m2504j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bu)) ? new C0689a(iBinder) : (bu) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ai aiVar = null;
            C0252d view;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1614a(C0661a.ag(data.readStrongBinder()), data.readInt() != 0 ? al.CREATOR.m785c(data) : null, data.readInt() != 0 ? ai.CREATOR.m781b(data) : null, data.readString(), C0692a.m2505k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = getView();
                    reply.writeNoException();
                    if (view != null) {
                        asBinder = view.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = C0661a.ag(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        aiVar = ai.CREATOR.m781b(data);
                    }
                    mo1612a(view, aiVar, data.readString(), C0692a.m2505k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1615a(C0661a.ag(data.readStrongBinder()), data.readInt() != 0 ? al.CREATOR.m785c(data) : null, data.readInt() != 0 ? ai.CREATOR.m781b(data) : null, data.readString(), data.readString(), C0692a.m2505k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1613a(C0661a.ag(data.readStrongBinder()), data.readInt() != 0 ? ai.CREATOR.m781b(data) : null, data.readString(), data.readString(), C0692a.m2505k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    pause();
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    resume();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo1612a(C0252d c0252d, ai aiVar, String str, bv bvVar) throws RemoteException;

    void mo1613a(C0252d c0252d, ai aiVar, String str, String str2, bv bvVar) throws RemoteException;

    void mo1614a(C0252d c0252d, al alVar, ai aiVar, String str, bv bvVar) throws RemoteException;

    void mo1615a(C0252d c0252d, al alVar, ai aiVar, String str, String str2, bv bvVar) throws RemoteException;

    void destroy() throws RemoteException;

    C0252d getView() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;
}
