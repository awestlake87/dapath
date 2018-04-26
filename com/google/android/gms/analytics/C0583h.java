package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class C0583h implements C0120m {
    private static C0583h tH;
    private static final Object tq = new Object();
    private final Context mContext;
    private String tI;
    private boolean tJ = false;
    private final Object tK = new Object();

    protected C0583h(Context context) {
        this.mContext = context;
        cz();
    }

    private boolean m1911K(String str) {
        try {
            aa.m39C("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            aa.m37A("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            aa.m37A("Error writing to clientId file.");
            return false;
        }
    }

    public static C0583h cv() {
        C0583h c0583h;
        synchronized (tq) {
            c0583h = tH;
        }
        return c0583h;
    }

    private String cx() {
        if (!this.tJ) {
            synchronized (this.tK) {
                if (!this.tJ) {
                    aa.m39C("Waiting for clientId to load");
                    do {
                        try {
                            this.tK.wait();
                        } catch (InterruptedException e) {
                            aa.m37A("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.tJ);
                }
            }
        }
        aa.m39C("Loaded clientId");
        return this.tI;
    }

    private void cz() {
        new Thread(this, "client_id_fetcher") {
            final /* synthetic */ C0583h tL;

            public void run() {
                synchronized (this.tL.tK) {
                    this.tL.tI = this.tL.cA();
                    this.tL.tJ = true;
                    this.tL.tK.notifyAll();
                }
            }
        }.start();
    }

    public static void m1915u(Context context) {
        synchronized (tq) {
            if (tH == null) {
                tH = new C0583h(context);
            }
        }
    }

    public boolean m1916J(String str) {
        return "&cid".equals(str);
    }

    String cA() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                aa.m37A("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                aa.m37A("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    aa.m39C("Loaded client id from disk.");
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    aa.m37A("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            aa.m37A("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? cy() : str;
    }

    String cw() {
        String str;
        synchronized (this.tK) {
            this.tI = cy();
            str = this.tI;
        }
        return str;
    }

    protected String cy() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !m1911K(toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    public String getValue(String field) {
        return "&cid".equals(field) ? cx() : null;
    }
}
