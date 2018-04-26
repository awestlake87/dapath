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
import com.google.android.gms.tagmanager.da.C0475a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ca implements at {
    private static final String wP = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    private ij aef;
    private final C0455b agq;
    private volatile ab agr;
    private final au ags;
    private final Context mContext;
    private final String wS;
    private long wU;
    private final int wV;

    class C0455b extends SQLiteOpenHelper {
        final /* synthetic */ ca agt;
        private boolean wX;
        private long wY = 0;

        C0455b(ca caVar, Context context, String str) {
            this.agt = caVar;
            super(context, str, null, 1);
        }

        private void m1658a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m1659a(String str, SQLiteDatabase sQLiteDatabase) {
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
            if (!this.wX || this.wY + 3600000 <= this.agt.aef.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.wX = true;
                this.wY = this.agt.aef.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.agt.mContext.getDatabasePath(this.agt.wS).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.wX = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
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
            if (m1659a("gtm_hits", db)) {
                m1658a(db);
            } else {
                db.execSQL(ca.wP);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    class C0927a implements C0475a {
        final /* synthetic */ ca agt;

        C0927a(ca caVar) {
            this.agt = caVar;
        }

        public void mo2331a(ap apVar) {
            this.agt.m2985y(apVar.dl());
        }

        public void mo2332b(ap apVar) {
            this.agt.m2985y(apVar.dl());
            bh.m1644C("Permanent failure dispatching hitId: " + apVar.dl());
        }

        public void mo2333c(ap apVar) {
            long lN = apVar.lN();
            if (lN == 0) {
                this.agt.m2983c(apVar.dl(), this.agt.aef.currentTimeMillis());
            } else if (lN + 14400000 < this.agt.aef.currentTimeMillis()) {
                this.agt.m2985y(apVar.dl());
                bh.m1644C("Giving up on failed hitId: " + apVar.dl());
            }
        }
    }

    ca(au auVar, Context context) {
        this(auVar, context, "gtm_urls.db", 2000);
    }

    ca(au auVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.wS = str;
        this.ags = auVar;
        this.aef = il.gb();
        this.agq = new C0455b(this, this.mContext, this.wS);
        this.agr = new da(new DefaultHttpClient(), this.mContext, new C0927a(this));
        this.wU = 0;
        this.wV = i;
    }

    private SQLiteDatabase m2977S(String str) {
        try {
            return this.agq.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m1645D(str);
            return null;
        }
    }

    private void m2983c(long j, long j2) {
        SQLiteDatabase S = m2977S("Error opening database for getNumStoredHits.");
        if (S != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                S.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                bh.m1645D("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                m2985y(j);
            }
        }
    }

    private void dr() {
        int dt = (dt() - this.wV) + 1;
        if (dt > 0) {
            List A = m2986A(dt);
            bh.m1644C("Store full, deleting " + A.size() + " hits to make room.");
            m2988a((String[]) A.toArray(new String[0]));
        }
    }

    private void m2984g(long j, String str) {
        SQLiteDatabase S = m2977S("Error opening database for putHit");
        if (S != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                S.insert("gtm_hits", null, contentValues);
                this.ags.mo2340s(false);
            } catch (SQLiteException e) {
                bh.m1645D("Error storing hit");
            }
        }
    }

    private void m2985y(long j) {
        m2988a(new String[]{String.valueOf(j)});
    }

    List<String> m2986A(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m1645D("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase S = m2977S("Error opening database for peekHitIds.");
        if (S == null) {
            return arrayList;
        }
        try {
            query = S.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
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
                    bh.m1645D("Error in peekHits fetching hitIds: " + e.getMessage());
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
            bh.m1645D("Error in peekHits fetching hitIds: " + e.getMessage());
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.tagmanager.ap> m2987B(int r16) {
        /*
        r15 = this;
        r10 = new java.util.ArrayList;
        r10.<init>();
        r1 = "Error opening database for peekHits";
        r1 = r15.m2977S(r1);
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        r1 = r10;
    L_0x000e:
        return r1;
    L_0x000f:
        r11 = 0;
        r2 = "gtm_hits";
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r4 = 1;
        r5 = "hit_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r4 = 2;
        r5 = "hit_first_send_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r12 = 0;
        r13 = "hit_id";
        r9[r12] = r13;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        if (r2 == 0) goto L_0x0066;
    L_0x0049:
        r2 = new com.google.android.gms.tagmanager.ap;	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r3 = 0;
        r3 = r12.getLong(r3);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r5 = 1;
        r5 = r12.getLong(r5);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r7 = 2;
        r7 = r12.getLong(r7);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r2.<init>(r3, r5, r7);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r11.add(r2);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r2 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        if (r2 != 0) goto L_0x0049;
    L_0x0066:
        if (r12 == 0) goto L_0x006b;
    L_0x0068:
        r12.close();
    L_0x006b:
        r10 = 0;
        r2 = "gtm_hits";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0167 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0167 }
        r4 = 1;
        r5 = "hit_url";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0167 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x0167 }
        r13 = 0;
        r14 = "hit_id";
        r9[r13] = r14;	 Catch:{ SQLiteException -> 0x0167 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x0167 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x0167 }
        r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x0167 }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        if (r1 == 0) goto L_0x00c0;
    L_0x009b:
        r3 = r10;
    L_0x009c:
        r0 = r2;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = r0;
        r1 = r1.getWindow();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = r1.getNumRows();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        if (r1 <= 0) goto L_0x00f4;
    L_0x00aa:
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r4 = 1;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1.m1629R(r4);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
    L_0x00b8:
        r1 = r3 + 1;
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        if (r3 != 0) goto L_0x017b;
    L_0x00c0:
        if (r2 == 0) goto L_0x00c5;
    L_0x00c2:
        r2.close();
    L_0x00c5:
        r1 = r11;
        goto L_0x000e;
    L_0x00c8:
        r1 = move-exception;
        r2 = r1;
        r3 = r11;
        r1 = r10;
    L_0x00cc:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016c }
        r4.<init>();	 Catch:{ all -> 0x016c }
        r5 = "Error in peekHits fetching hitIds: ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x016c }
        r2 = r2.getMessage();	 Catch:{ all -> 0x016c }
        r2 = r4.append(r2);	 Catch:{ all -> 0x016c }
        r2 = r2.toString();	 Catch:{ all -> 0x016c }
        com.google.android.gms.tagmanager.bh.m1645D(r2);	 Catch:{ all -> 0x016c }
        if (r3 == 0) goto L_0x000e;
    L_0x00e8:
        r3.close();
        goto L_0x000e;
    L_0x00ed:
        r1 = move-exception;
    L_0x00ee:
        if (r11 == 0) goto L_0x00f3;
    L_0x00f0:
        r11.close();
    L_0x00f3:
        throw r1;
    L_0x00f4:
        r4 = "HitString for hitId %d too large.  Hit will be deleted.";
        r1 = 1;
        r5 = new java.lang.Object[r1];	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r6 = 0;
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r7 = r1.dl();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r5[r6] = r1;	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = java.lang.String.format(r4, r5);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        com.google.android.gms.tagmanager.bh.m1645D(r1);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        goto L_0x00b8;
    L_0x0112:
        r1 = move-exception;
        r12 = r2;
    L_0x0114:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015d }
        r2.<init>();	 Catch:{ all -> 0x015d }
        r3 = "Error in peekHits fetching hit url: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x015d }
        r1 = r1.getMessage();	 Catch:{ all -> 0x015d }
        r1 = r2.append(r1);	 Catch:{ all -> 0x015d }
        r1 = r1.toString();	 Catch:{ all -> 0x015d }
        com.google.android.gms.tagmanager.bh.m1645D(r1);	 Catch:{ all -> 0x015d }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x015d }
        r2.<init>();	 Catch:{ all -> 0x015d }
        r3 = 0;
        r4 = r11.iterator();	 Catch:{ all -> 0x015d }
    L_0x0138:
        r1 = r4.hasNext();	 Catch:{ all -> 0x015d }
        if (r1 == 0) goto L_0x0150;
    L_0x013e:
        r1 = r4.next();	 Catch:{ all -> 0x015d }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ all -> 0x015d }
        r5 = r1.lO();	 Catch:{ all -> 0x015d }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x015d }
        if (r5 == 0) goto L_0x0159;
    L_0x014e:
        if (r3 == 0) goto L_0x0158;
    L_0x0150:
        if (r12 == 0) goto L_0x0155;
    L_0x0152:
        r12.close();
    L_0x0155:
        r1 = r2;
        goto L_0x000e;
    L_0x0158:
        r3 = 1;
    L_0x0159:
        r2.add(r1);	 Catch:{ all -> 0x015d }
        goto L_0x0138;
    L_0x015d:
        r1 = move-exception;
    L_0x015e:
        if (r12 == 0) goto L_0x0163;
    L_0x0160:
        r12.close();
    L_0x0163:
        throw r1;
    L_0x0164:
        r1 = move-exception;
        r12 = r2;
        goto L_0x015e;
    L_0x0167:
        r1 = move-exception;
        goto L_0x0114;
    L_0x0169:
        r1 = move-exception;
        r11 = r12;
        goto L_0x00ee;
    L_0x016c:
        r1 = move-exception;
        r11 = r3;
        goto L_0x00ee;
    L_0x016f:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r10;
        goto L_0x00cc;
    L_0x0175:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r11;
        goto L_0x00cc;
    L_0x017b:
        r3 = r1;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ca.B(int):java.util.List<com.google.android.gms.tagmanager.ap>");
    }

    void m2988a(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase S = m2977S("Error opening database for deleteHits.");
            if (S != null) {
                try {
                    S.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    au auVar = this.ags;
                    if (dt() != 0) {
                        z = false;
                    }
                    auVar.mo2340s(z);
                } catch (SQLiteException e) {
                    bh.m1645D("Error deleting hits");
                }
            }
        }
    }

    public void cq() {
        bh.m1644C("GTM Dispatch running...");
        if (this.agr.cC()) {
            List B = m2987B(40);
            if (B.isEmpty()) {
                bh.m1644C("...nothing to dispatch");
                this.ags.mo2340s(true);
                return;
            }
            this.agr.mo2344g(B);
            if (mb() > 0) {
                cx.mQ().cq();
            }
        }
    }

    int ds() {
        boolean z = true;
        long currentTimeMillis = this.aef.currentTimeMillis();
        if (currentTimeMillis <= this.wU + 86400000) {
            return 0;
        }
        this.wU = currentTimeMillis;
        SQLiteDatabase S = m2977S("Error opening database for deleteStaleHits.");
        if (S == null) {
            return 0;
        }
        int delete = S.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.aef.currentTimeMillis() - 2592000000L)});
        au auVar = this.ags;
        if (dt() != 0) {
            z = false;
        }
        auVar.mo2340s(z);
        return delete;
    }

    int dt() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase S = m2977S("Error opening database for getNumStoredHits.");
        if (S != null) {
            try {
                cursor = S.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m1645D("Error getting numStoredHits");
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

    public void mo2335f(long j, String str) {
        ds();
        dr();
        m2984g(j, str);
    }

    int mb() {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        SQLiteDatabase S = m2977S("Error opening database for getNumStoredHits.");
        if (S == null) {
            return 0;
        }
        int count;
        try {
            Cursor query = S.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = query.getCount();
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e) {
                cursor = query;
                try {
                    bh.m1645D("Error getting num untried hits");
                    if (cursor == null) {
                        count = 0;
                    } else {
                        cursor.close();
                        count = 0;
                    }
                    return count;
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
            bh.m1645D("Error getting num untried hits");
            if (cursor == null) {
                cursor.close();
                count = 0;
            } else {
                count = 0;
            }
            return count;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return count;
    }
}
