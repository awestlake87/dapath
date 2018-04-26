package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class C1094i extends C0745h {
    private static Method jS;
    private static Method jT;
    private static Method jU;
    private static Method jV;
    private static Method jW;
    private static Method jX;
    private static Method jY;
    private static Method jZ;
    private static String ka;
    private static C0368o kb;
    static boolean kc = false;
    private static long startTime = 0;

    static class C0354a extends Exception {
        public C0354a(Throwable th) {
            super(th);
        }
    }

    protected C1094i(Context context, C0365m c0365m, C0366n c0366n) {
        super(context, c0365m, c0366n);
    }

    static String m3660a(Context context, C0365m c0365m) throws C0354a {
        if (jV == null) {
            throw new C0354a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) jV.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c0365m.mo1692a(byteBuffer.array(), true);
            }
            throw new C0354a();
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    static ArrayList<Long> m3661a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C0354a {
        if (jW == null || motionEvent == null) {
            throw new C0354a();
        }
        try {
            return (ArrayList) jW.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    protected static synchronized void m3662a(String str, Context context, C0365m c0365m) {
        synchronized (C1094i.class) {
            if (!kc) {
                try {
                    kb = new C0368o(c0365m, null);
                    ka = str;
                    C1094i.m3667h(context);
                    startTime = C1094i.m3669w().longValue();
                    kc = true;
                } catch (C0354a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static String m3663b(Context context, C0365m c0365m) throws C0354a {
        if (jY == null) {
            throw new C0354a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) jY.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c0365m.mo1692a(byteBuffer.array(), true);
            }
            throw new C0354a();
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    private static String m3664b(byte[] bArr, String str) throws C0354a {
        try {
            return new String(kb.m1442c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    static String m3665f(Context context) throws C0354a {
        if (jX == null) {
            throw new C0354a();
        }
        try {
            String str = (String) jX.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C0354a();
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    static ArrayList<Long> m3666g(Context context) throws C0354a {
        if (jZ == null) {
            throw new C0354a();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) jZ.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new C0354a();
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    private static void m3667h(Context context) throws C0354a {
        File file;
        File createTempFile;
        try {
            byte[] b = kb.m1441b(C0369q.getKey());
            byte[] c = kb.m1442c(b, C0369q.m1443B());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C0354a();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(C1094i.m3664b(b, C0369q.m1444C()));
            Class loadClass2 = dexClassLoader.loadClass(C1094i.m3664b(b, C0369q.m1456O()));
            Class loadClass3 = dexClassLoader.loadClass(C1094i.m3664b(b, C0369q.m1450I()));
            Class loadClass4 = dexClassLoader.loadClass(C1094i.m3664b(b, C0369q.m1448G()));
            Class loadClass5 = dexClassLoader.loadClass(C1094i.m3664b(b, C0369q.m1458Q()));
            Class loadClass6 = dexClassLoader.loadClass(C1094i.m3664b(b, C0369q.m1446E()));
            Class loadClass7 = dexClassLoader.loadClass(C1094i.m3664b(b, C0369q.m1454M()));
            Class loadClass8 = dexClassLoader.loadClass(C1094i.m3664b(b, C0369q.m1452K()));
            jS = loadClass.getMethod(C1094i.m3664b(b, C0369q.m1445D()), new Class[0]);
            jT = loadClass2.getMethod(C1094i.m3664b(b, C0369q.m1457P()), new Class[0]);
            jU = loadClass3.getMethod(C1094i.m3664b(b, C0369q.m1451J()), new Class[0]);
            jV = loadClass4.getMethod(C1094i.m3664b(b, C0369q.m1449H()), new Class[]{Context.class});
            jW = loadClass5.getMethod(C1094i.m3664b(b, C0369q.m1459R()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            jX = loadClass6.getMethod(C1094i.m3664b(b, C0369q.m1447F()), new Class[]{Context.class});
            jY = loadClass7.getMethod(C1094i.m3664b(b, C0369q.m1455N()), new Class[]{Context.class});
            jZ = loadClass8.getMethod(C1094i.m3664b(b, C0369q.m1453L()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        } catch (Throwable e22) {
            throw new C0354a(e22);
        } catch (Throwable e222) {
            throw new C0354a(e222);
        } catch (Throwable e2222) {
            throw new C0354a(e2222);
        } catch (Throwable e22222) {
            throw new C0354a(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    static String m3668v() throws C0354a {
        if (ka != null) {
            return ka;
        }
        throw new C0354a();
    }

    static Long m3669w() throws C0354a {
        if (jS == null) {
            throw new C0354a();
        }
        try {
            return (Long) jS.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    static String m3670x() throws C0354a {
        if (jU == null) {
            throw new C0354a();
        }
        try {
            return (String) jU.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    static Long m3671y() throws C0354a {
        if (jT == null) {
            throw new C0354a();
        }
        try {
            return (Long) jT.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0354a(e);
        } catch (Throwable e2) {
            throw new C0354a(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void mo2851c(android.content.Context r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = com.google.android.gms.internal.C1094i.m3670x();	 Catch:{ a -> 0x0059, IOException -> 0x004f }
        r5.m2642a(r0, r1);	 Catch:{ a -> 0x0059, IOException -> 0x004f }
    L_0x0008:
        r0 = 2;
        r1 = com.google.android.gms.internal.C1094i.m3668v();	 Catch:{ a -> 0x0057, IOException -> 0x004f }
        r5.m2642a(r0, r1);	 Catch:{ a -> 0x0057, IOException -> 0x004f }
    L_0x0010:
        r0 = 25;
        r1 = com.google.android.gms.internal.C1094i.m3669w();	 Catch:{ a -> 0x0055, IOException -> 0x004f }
        r1 = r1.longValue();	 Catch:{ a -> 0x0055, IOException -> 0x004f }
        r5.m2641a(r0, r1);	 Catch:{ a -> 0x0055, IOException -> 0x004f }
    L_0x001d:
        r1 = com.google.android.gms.internal.C1094i.m3666g(r6);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r2 = 31;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r3 = r0.longValue();	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r5.m2641a(r2, r3);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r2 = 32;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = r0.longValue();	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r5.m2641a(r2, r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
    L_0x0041:
        r0 = 33;
        r1 = com.google.android.gms.internal.C1094i.m3671y();	 Catch:{ a -> 0x0051, IOException -> 0x004f }
        r1 = r1.longValue();	 Catch:{ a -> 0x0051, IOException -> 0x004f }
        r5.m2641a(r0, r1);	 Catch:{ a -> 0x0051, IOException -> 0x004f }
    L_0x004e:
        return;
    L_0x004f:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0051:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0053:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0055:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0057:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0059:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.c(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void mo2852e(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = com.google.android.gms.internal.C1094i.m3668v();	 Catch:{ a -> 0x0097, IOException -> 0x008a }
        r6.m2642a(r0, r1);	 Catch:{ a -> 0x0097, IOException -> 0x008a }
    L_0x0008:
        r0 = 1;
        r1 = com.google.android.gms.internal.C1094i.m3670x();	 Catch:{ a -> 0x0094, IOException -> 0x008a }
        r6.m2642a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x008a }
    L_0x0010:
        r0 = com.google.android.gms.internal.C1094i.m3669w();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = 25;
        r6.m2641a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r3 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0 - r3;
        r6.m2641a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = 23;
        r1 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r6.m2641a(r0, r1);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
    L_0x0034:
        r0 = r6.jO;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = r6.jP;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C1094i.m3661a(r0, r1);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r3 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2641a(r2, r3);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r3 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2641a(r2, r3);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r1.size();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 3;
        if (r0 < r2) goto L_0x0073;
    L_0x0063:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2641a(r2, r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
    L_0x0073:
        r0 = 27;
        r1 = r6.jQ;	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C1094i.m3660a(r7, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r6.m2642a(r0, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
    L_0x007e:
        r0 = 29;
        r1 = r6.jQ;	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C1094i.m3663b(r7, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r6.m2642a(r0, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
    L_0x0089:
        return;
    L_0x008a:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008e:
        r0 = move-exception;
        goto L_0x007e;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0034;
    L_0x0094:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0097:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.e(android.content.Context):void");
    }
}
