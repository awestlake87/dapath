package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class C0745h implements C0331g {
    protected MotionEvent jO;
    protected DisplayMetrics jP;
    protected C0365m jQ;
    private C0366n jR;

    protected C0745h(Context context, C0365m c0365m, C0366n c0366n) {
        this.jQ = c0365m;
        this.jR = c0366n;
        try {
            this.jP = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.jP = new DisplayMetrics();
            this.jP.density = TextTrackStyle.DEFAULT_FONT_SCALE;
        }
    }

    private String m2634a(Context context, String str, boolean z, boolean z2) {
        try {
            byte[] u;
            synchronized (this) {
                m2635t();
                if (z) {
                    mo2852e(context);
                } else if (z2) {
                    mo3146d(context);
                } else {
                    mo2851c(context);
                }
                u = m2636u();
            }
            return u.length == 0 ? Integer.toString(5) : m2639a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void m2635t() {
        this.jR.reset();
    }

    private byte[] m2636u() throws IOException {
        return this.jR.mo1911A();
    }

    public String mo1740a(Context context) {
        return m2634a(context, null, false, false);
    }

    public String mo1741a(Context context, String str) {
        return m2634a(context, str, true, false);
    }

    String m2639a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            m2635t();
            m2641a(20, 1);
            bArr = m2636u();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(256).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[256];
        new C0328f().m1051a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m2644a(str, bArr3);
        }
        return this.jQ.mo1692a(bArr3, true);
    }

    public void mo1742a(int i, int i2, int i3) {
        if (this.jO != null) {
            this.jO.recycle();
        }
        this.jO = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.jP.density, ((float) i2) * this.jP.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void m2641a(int i, long j) throws IOException {
        this.jR.mo1912b(i, j);
    }

    protected void m2642a(int i, String str) throws IOException {
        this.jR.mo1913b(i, str);
    }

    public void mo1743a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.jO != null) {
                this.jO.recycle();
            }
            this.jO = MotionEvent.obtain(motionEvent);
        }
    }

    void m2644a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new lx(str.getBytes("UTF-8")).m1368o(bArr);
    }

    public String mo1744b(Context context) {
        return m2634a(context, null, false, true);
    }

    protected abstract void mo2851c(Context context);

    protected abstract void mo3146d(Context context);

    protected abstract void mo2852e(Context context);
}
