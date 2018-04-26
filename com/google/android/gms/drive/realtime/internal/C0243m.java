package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.dapath.pathgen.PathGenerator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.C0223c.C0627a;
import com.google.android.gms.drive.realtime.internal.C0224d.C0629a;
import com.google.android.gms.drive.realtime.internal.C0225e.C0631a;
import com.google.android.gms.drive.realtime.internal.C0236f.C0633a;
import com.google.android.gms.drive.realtime.internal.C0237g.C0635a;
import com.google.android.gms.drive.realtime.internal.C0238h.C0637a;
import com.google.android.gms.drive.realtime.internal.C0239i.C0639a;
import com.google.android.gms.drive.realtime.internal.C0240j.C0641a;
import com.google.android.gms.drive.realtime.internal.C0241k.C0643a;
import com.google.android.gms.drive.realtime.internal.C0242l.C0645a;
import com.google.android.gms.drive.realtime.internal.C0244n.C0649a;
import com.google.android.gms.drive.realtime.internal.C0245o.C0651a;
import com.google.android.gms.games.Notifications;

public interface C0243m extends IInterface {

    public static abstract class C0647a extends Binder implements C0243m {

        private static class C0646a implements C0243m {
            private IBinder kq;

            C0646a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo1030a(int i, C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1031a(BeginCompoundOperationRequest beginCompoundOperationRequest, C0245o c0245o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0245o != null ? c0245o.asBinder() : null);
                    this.kq.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1032a(EndCompoundOperationRequest endCompoundOperationRequest, C0245o c0245o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0245o != null ? c0245o.asBinder() : null);
                    this.kq.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1033a(ParcelableIndexReference parcelableIndexReference, C0244n c0244n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0244n != null ? c0244n.asBinder() : null);
                    this.kq.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1034a(C0223c c0223c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0223c != null ? c0223c.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1035a(C0224d c0224d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0224d != null ? c0224d.asBinder() : null);
                    this.kq.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1036a(C0225e c0225e) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0225e != null ? c0225e.asBinder() : null);
                    this.kq.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1037a(C0238h c0238h) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0238h != null ? c0238h.asBinder() : null);
                    this.kq.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1038a(C0239i c0239i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0239i != null ? c0239i.asBinder() : null);
                    this.kq.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1039a(C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1040a(C0242l c0242l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0242l != null ? c0242l.asBinder() : null);
                    this.kq.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1041a(C0245o c0245o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0245o != null ? c0245o.asBinder() : null);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1042a(String str, int i, int i2, C0237g c0237g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0237g != null ? c0237g.asBinder() : null);
                    this.kq.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1043a(String str, int i, int i2, C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1044a(String str, int i, DataHolder dataHolder, C0237g c0237g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0237g != null ? c0237g.asBinder() : null);
                    this.kq.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1045a(String str, int i, DataHolder dataHolder, C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1046a(String str, int i, C0245o c0245o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c0245o != null ? c0245o.asBinder() : null);
                    this.kq.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1047a(String str, int i, String str2, int i2, C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1048a(String str, int i, String str2, C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1049a(String str, DataHolder dataHolder, C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1050a(String str, C0236f c0236f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0236f != null ? c0236f.asBinder() : null);
                    this.kq.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1051a(String str, C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1052a(String str, C0241k c0241k) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0241k != null ? c0241k.asBinder() : null);
                    this.kq.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1053a(String str, C0242l c0242l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0242l != null ? c0242l.asBinder() : null);
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1054a(String str, C0244n c0244n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0244n != null ? c0244n.asBinder() : null);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1055a(String str, C0245o c0245o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0245o != null ? c0245o.asBinder() : null);
                    this.kq.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1056a(String str, String str2, C0236f c0236f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0236f != null ? c0236f.asBinder() : null);
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1057a(String str, String str2, C0237g c0237g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0237g != null ? c0237g.asBinder() : null);
                    this.kq.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1058a(String str, String str2, C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
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

            public void mo1059b(C0223c c0223c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0223c != null ? c0223c.asBinder() : null);
                    this.kq.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1060b(C0240j c0240j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0240j != null ? c0240j.asBinder() : null);
                    this.kq.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1061b(C0245o c0245o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0245o != null ? c0245o.asBinder() : null);
                    this.kq.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1062b(String str, C0236f c0236f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0236f != null ? c0236f.asBinder() : null);
                    this.kq.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1063b(String str, C0242l c0242l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0242l != null ? c0242l.asBinder() : null);
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1064b(String str, C0244n c0244n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0244n != null ? c0244n.asBinder() : null);
                    this.kq.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1065b(String str, C0245o c0245o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0245o != null ? c0245o.asBinder() : null);
                    this.kq.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1066c(C0223c c0223c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0223c != null ? c0223c.asBinder() : null);
                    this.kq.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1067c(String str, C0242l c0242l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0242l != null ? c0242l.asBinder() : null);
                    this.kq.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1068d(C0223c c0223c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0223c != null ? c0223c.asBinder() : null);
                    this.kq.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0243m ac(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0243m)) ? new C0646a(iBinder) : (C0243m) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelableIndexReference parcelableIndexReference = null;
            String readString;
            DataHolder x;
            int readInt;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1054a(data.readString(), C0649a.ad(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1034a(C0627a.m2089S(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1041a(C0651a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1056a(data.readString(), data.readString(), C0633a.m2098V(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1053a(data.readString(), C0645a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    mo1049a(readString, x, C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1051a(data.readString(), C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1063b(data.readString(), C0645a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1064b(data.readString(), C0649a.ad(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1048a(data.readString(), data.readInt(), data.readString(), C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1043a(data.readString(), data.readInt(), data.readInt(), C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1058a(data.readString(), data.readString(), C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1062b(data.readString(), C0633a.m2098V(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1067c(data.readString(), C0645a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    mo1045a(readString, readInt, x, C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    mo1044a(readString, readInt, x, C0635a.m2101W(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1042a(data.readString(), data.readInt(), data.readInt(), C0635a.m2101W(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 18:
                    BeginCompoundOperationRequest beginCompoundOperationRequest;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        beginCompoundOperationRequest = (BeginCompoundOperationRequest) BeginCompoundOperationRequest.CREATOR.createFromParcel(data);
                    }
                    mo1031a(beginCompoundOperationRequest, C0651a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    EndCompoundOperationRequest endCompoundOperationRequest;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        endCompoundOperationRequest = (EndCompoundOperationRequest) EndCompoundOperationRequest.CREATOR.createFromParcel(data);
                    }
                    mo1032a(endCompoundOperationRequest, C0651a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case PathGenerator.SUBDIVISIONS /*20*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1050a(data.readString(), C0633a.m2098V(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1057a(data.readString(), data.readString(), C0635a.m2101W(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1039a(C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1060b(C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1066c(C0627a.m2089S(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1068d(C0627a.m2089S(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        parcelableIndexReference = (ParcelableIndexReference) ParcelableIndexReference.CREATOR.createFromParcel(data);
                    }
                    mo1033a(parcelableIndexReference, C0649a.ad(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1052a(data.readString(), C0643a.aa(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1046a(data.readString(), data.readInt(), C0651a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1040a(C0645a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1030a(data.readInt(), C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1036a(C0631a.m2095U(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1035a(C0629a.m2092T(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1059b(C0627a.m2089S(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1038a(C0639a.m2105Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1061b(C0651a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 36:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1037a(C0637a.m2103X(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1047a(data.readString(), data.readInt(), data.readString(), data.readInt(), C0641a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 38:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1055a(data.readString(), C0651a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 39:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1065b(data.readString(), C0651a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo1030a(int i, C0240j c0240j) throws RemoteException;

    void mo1031a(BeginCompoundOperationRequest beginCompoundOperationRequest, C0245o c0245o) throws RemoteException;

    void mo1032a(EndCompoundOperationRequest endCompoundOperationRequest, C0245o c0245o) throws RemoteException;

    void mo1033a(ParcelableIndexReference parcelableIndexReference, C0244n c0244n) throws RemoteException;

    void mo1034a(C0223c c0223c) throws RemoteException;

    void mo1035a(C0224d c0224d) throws RemoteException;

    void mo1036a(C0225e c0225e) throws RemoteException;

    void mo1037a(C0238h c0238h) throws RemoteException;

    void mo1038a(C0239i c0239i) throws RemoteException;

    void mo1039a(C0240j c0240j) throws RemoteException;

    void mo1040a(C0242l c0242l) throws RemoteException;

    void mo1041a(C0245o c0245o) throws RemoteException;

    void mo1042a(String str, int i, int i2, C0237g c0237g) throws RemoteException;

    void mo1043a(String str, int i, int i2, C0240j c0240j) throws RemoteException;

    void mo1044a(String str, int i, DataHolder dataHolder, C0237g c0237g) throws RemoteException;

    void mo1045a(String str, int i, DataHolder dataHolder, C0240j c0240j) throws RemoteException;

    void mo1046a(String str, int i, C0245o c0245o) throws RemoteException;

    void mo1047a(String str, int i, String str2, int i2, C0240j c0240j) throws RemoteException;

    void mo1048a(String str, int i, String str2, C0240j c0240j) throws RemoteException;

    void mo1049a(String str, DataHolder dataHolder, C0240j c0240j) throws RemoteException;

    void mo1050a(String str, C0236f c0236f) throws RemoteException;

    void mo1051a(String str, C0240j c0240j) throws RemoteException;

    void mo1052a(String str, C0241k c0241k) throws RemoteException;

    void mo1053a(String str, C0242l c0242l) throws RemoteException;

    void mo1054a(String str, C0244n c0244n) throws RemoteException;

    void mo1055a(String str, C0245o c0245o) throws RemoteException;

    void mo1056a(String str, String str2, C0236f c0236f) throws RemoteException;

    void mo1057a(String str, String str2, C0237g c0237g) throws RemoteException;

    void mo1058a(String str, String str2, C0240j c0240j) throws RemoteException;

    void mo1059b(C0223c c0223c) throws RemoteException;

    void mo1060b(C0240j c0240j) throws RemoteException;

    void mo1061b(C0245o c0245o) throws RemoteException;

    void mo1062b(String str, C0236f c0236f) throws RemoteException;

    void mo1063b(String str, C0242l c0242l) throws RemoteException;

    void mo1064b(String str, C0244n c0244n) throws RemoteException;

    void mo1065b(String str, C0245o c0245o) throws RemoteException;

    void mo1066c(C0223c c0223c) throws RemoteException;

    void mo1067c(String str, C0242l c0242l) throws RemoteException;

    void mo1068d(C0223c c0223c) throws RemoteException;
}
