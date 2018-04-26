package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import com.google.android.gms.tagmanager.DataLayer.C0440a;
import com.google.android.gms.tagmanager.DataLayer.C0443c;
import com.google.android.gms.tagmanager.DataLayer.C0443c.C0442a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class C0954v implements C0443c {
    private static final String afj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private ij aef;
    private final Executor afk;
    private C0490a afl;
    private int afm;
    private final Context mContext;

    class C0490a extends SQLiteOpenHelper {
        final /* synthetic */ C0954v afp;

        C0490a(C0954v c0954v, Context context, String str) {
            this.afp = c0954v;
            super(context, str, null, 1);
        }

        private void m1746a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m1747a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        bh.m1645D("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                bh.m1645D("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.afp.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase db) {
            ak.m1628N(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m1747a("datalayer", db)) {
                m1746a(db);
            } else {
                db.execSQL(C0954v.afj);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    private static class C0491b {
        final String JL;
        final byte[] afs;

        C0491b(String str, byte[] bArr) {
            this.JL = str;
            this.afs = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.JL + " serialized hash = " + Arrays.hashCode(this.afs);
        }
    }

    public C0954v(Context context) {
        this(context, il.gb(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    C0954v(Context context, ij ijVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.aef = ijVar;
        this.afm = i;
        this.afk = executor;
        this.afl = new C0490a(this, this.mContext, str);
    }

    private SQLiteDatabase m3043S(String str) {
        try {
            return this.afl.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m1645D(str);
            return null;
        }
    }

    private synchronized void m3048b(List<C0491b> list, long j) {
        try {
            long currentTimeMillis = this.aef.currentTimeMillis();
            m3056x(currentTimeMillis);
            m3050do(list.size());
            m3049c(list, currentTimeMillis + j);
            lF();
        } catch (Throwable th) {
            lF();
        }
    }

    private void bQ(String str) {
        SQLiteDatabase S = m3043S("Error opening database for clearKeysWithPrefix.");
        if (S != null) {
            try {
                bh.m1644C("Cleared " + S.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.m1645D("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                lF();
            }
        }
    }

    private void m3049c(List<C0491b> list, long j) {
        SQLiteDatabase S = m3043S("Error opening database for writeEntryToDatabase.");
        if (S != null) {
            for (C0491b c0491b : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", c0491b.JL);
                contentValues.put("value", c0491b.afs);
                S.insert("datalayer", null, contentValues);
            }
        }
    }

    private void m3050do(int i) {
        int lE = (lE() - this.afm) + i;
        if (lE > 0) {
            List dp = dp(lE);
            bh.m1643B("DataLayer store full, deleting " + dp.size() + " entries to make room.");
            m3053g((String[]) dp.toArray(new String[0]));
        }
    }

    private List<String> dp(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m1645D("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase S = m3043S("Error opening database for peekEntryIds.");
        if (S == null) {
            return arrayList;
        }
        try {
            query = S.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    bh.m1645D("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            bh.m1645D("Error in peekEntries fetching entryIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private List<C0440a> m3051e(List<C0491b> list) {
        List<C0440a> arrayList = new ArrayList();
        for (C0491b c0491b : list) {
            arrayList.add(new C0440a(c0491b.JL, m3054j(c0491b.afs)));
        }
        return arrayList;
    }

    private List<C0491b> m3052f(List<C0440a> list) {
        List<C0491b> arrayList = new ArrayList();
        for (C0440a c0440a : list) {
            arrayList.add(new C0491b(c0440a.JL, m3055j(c0440a.afh)));
        }
        return arrayList;
    }

    private void m3053g(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase S = m3043S("Error opening database for deleteEntries.");
            if (S != null) {
                try {
                    S.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.m1645D("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private Object m3054j(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private byte[] m3055j(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List<C0440a> lC() {
        try {
            m3056x(this.aef.currentTimeMillis());
            List<C0440a> e = m3051e(lD());
            return e;
        } finally {
            lF();
        }
    }

    private List<C0491b> lD() {
        SQLiteDatabase S = m3043S("Error opening database for loadSerialized.");
        List<C0491b> arrayList = new ArrayList();
        if (S == null) {
            return arrayList;
        }
        Cursor query = S.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C0491b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int lE() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase S = m3043S("Error opening database for getNumStoredEntries.");
        if (S != null) {
            try {
                cursor = S.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m1645D("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void lF() {
        try {
            this.afl.close();
        } catch (SQLiteException e) {
        }
    }

    private void m3056x(long j) {
        SQLiteDatabase S = m3043S("Error opening database for deleteOlderThan.");
        if (S != null) {
            try {
                bh.m1644C("Deleted " + S.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.m1645D("Error deleting old entries.");
            }
        }
    }

    public void mo2287a(final C0442a c0442a) {
        this.afk.execute(new Runnable(this) {
            final /* synthetic */ C0954v afp;

            public void run() {
                c0442a.mo2290d(this.afp.lC());
            }
        });
    }

    public void mo2288a(List<C0440a> list, final long j) {
        final List f = m3052f(list);
        this.afk.execute(new Runnable(this) {
            final /* synthetic */ C0954v afp;

            public void run() {
                this.afp.m3048b(f, j);
            }
        });
    }

    public void bP(final String str) {
        this.afk.execute(new Runnable(this) {
            final /* synthetic */ C0954v afp;

            public void run() {
                this.afp.bQ(str);
            }
        });
    }
}
