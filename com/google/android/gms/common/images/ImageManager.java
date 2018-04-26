package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0168a.C0167a;
import com.google.android.gms.common.images.C0168a.C0612b;
import com.google.android.gms.common.images.C0168a.C0613c;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hq;
import com.google.android.gms.internal.ip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object EX = new Object();
    private static HashSet<Uri> EY = new HashSet();
    private static ImageManager EZ;
    private static ImageManager Fa;
    private final ExecutorService Fb = Executors.newFixedThreadPool(4);
    private final C0611b Fc;
    private final gw Fd;
    private final Map<C0168a, ImageReceiver> Fe;
    private final Map<Uri, ImageReceiver> Ff;
    private final Map<Uri, Long> Fg;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList<C0168a> Fh = new ArrayList();
        final /* synthetic */ ImageManager Fi;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.Fi = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void m168b(C0168a c0168a) {
            gx.ay("ImageReceiver.addImageRequest() must be called in the main thread");
            this.Fh.add(c0168a);
        }

        public void m169c(C0168a c0168a) {
            gx.ay("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.Fh.remove(c0168a);
        }

        public void ff() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.Fi.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.Fi.Fb.execute(new C0163c(this.Fi, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class C0162a {
        static int m170a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private final class C0163c implements Runnable {
        final /* synthetic */ ImageManager Fi;
        private final ParcelFileDescriptor Fj;
        private final Uri mUri;

        public C0163c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.Fi = imageManager;
            this.mUri = uri;
            this.Fj = parcelFileDescriptor;
        }

        public void run() {
            gx.az("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.Fj != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.Fj.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.Fj.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.Fi.mHandler.post(new C0166f(this.Fi, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class C0164d implements Runnable {
        final /* synthetic */ ImageManager Fi;
        private final C0168a Fk;

        public C0164d(ImageManager imageManager, C0168a c0168a) {
            this.Fi = imageManager;
            this.Fk = c0168a;
        }

        public void run() {
            gx.ay("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.Fi.Fe.get(this.Fk);
            if (imageReceiver != null) {
                this.Fi.Fe.remove(this.Fk);
                imageReceiver.m169c(this.Fk);
            }
            C0167a c0167a = this.Fk.Fm;
            if (c0167a.uri == null) {
                this.Fk.m189a(this.Fi.mContext, this.Fi.Fd, true);
                return;
            }
            Bitmap a = this.Fi.m173a(c0167a);
            if (a != null) {
                this.Fk.m187a(this.Fi.mContext, a, true);
                return;
            }
            Long l = (Long) this.Fi.Fg.get(c0167a.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.Fk.m189a(this.Fi.mContext, this.Fi.Fd, true);
                    return;
                }
                this.Fi.Fg.remove(c0167a.uri);
            }
            this.Fk.m188a(this.Fi.mContext, this.Fi.Fd);
            imageReceiver = (ImageReceiver) this.Fi.Ff.get(c0167a.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.Fi, c0167a.uri);
                this.Fi.Ff.put(c0167a.uri, imageReceiver);
            }
            imageReceiver.m168b(this.Fk);
            if (!(this.Fk instanceof C0613c)) {
                this.Fi.Fe.put(this.Fk, imageReceiver);
            }
            synchronized (ImageManager.EX) {
                if (!ImageManager.EY.contains(c0167a.uri)) {
                    ImageManager.EY.add(c0167a.uri);
                    imageReceiver.ff();
                }
            }
        }
    }

    private static final class C0165e implements ComponentCallbacks2 {
        private final C0611b Fc;

        public C0165e(C0611b c0611b) {
            this.Fc = c0611b;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Fc.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Fc.evictAll();
            } else if (level >= 20) {
                this.Fc.trimToSize(this.Fc.size() / 2);
            }
        }
    }

    private final class C0166f implements Runnable {
        final /* synthetic */ ImageManager Fi;
        private boolean Fl;
        private final CountDownLatch kK;
        private final Bitmap mBitmap;
        private final Uri mUri;

        public C0166f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.Fi = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.Fl = z;
            this.kK = countDownLatch;
        }

        private void m171a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.Fh;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0168a c0168a = (C0168a) a.get(i);
                if (z) {
                    c0168a.m187a(this.Fi.mContext, this.mBitmap, false);
                } else {
                    this.Fi.Fg.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    c0168a.m189a(this.Fi.mContext, this.Fi.Fd, false);
                }
                if (!(c0168a instanceof C0613c)) {
                    this.Fi.Fe.remove(c0168a);
                }
            }
        }

        public void run() {
            gx.ay("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.Fi.Fc != null) {
                if (this.Fl) {
                    this.Fi.Fc.evictAll();
                    System.gc();
                    this.Fl = false;
                    this.Fi.mHandler.post(this);
                    return;
                } else if (z) {
                    this.Fi.Fc.put(new C0167a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.Fi.Ff.remove(this.mUri);
            if (imageReceiver != null) {
                m171a(imageReceiver, z);
            }
            this.kK.countDown();
            synchronized (ImageManager.EX) {
                ImageManager.EY.remove(this.mUri);
            }
        }
    }

    private static final class C0611b extends hq<C0167a, Bitmap> {
        public C0611b(Context context) {
            super(C0611b.m2020D(context));
        }

        private static int m2020D(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !ip.gc()) ? activityManager.getMemoryClass() : C0162a.m170a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected int m2021a(C0167a c0167a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void m2022a(boolean z, C0167a c0167a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0167a, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            m2022a(x0, (C0167a) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2021a((C0167a) x0, (Bitmap) x1);
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.Fc = new C0611b(this.mContext);
            if (ip.gf()) {
                fc();
            }
        } else {
            this.Fc = null;
        }
        this.Fd = new gw();
        this.Fe = new HashMap();
        this.Ff = new HashMap();
        this.Fg = new HashMap();
    }

    private Bitmap m173a(C0167a c0167a) {
        return this.Fc == null ? null : (Bitmap) this.Fc.get(c0167a);
    }

    public static ImageManager m174a(Context context, boolean z) {
        if (z) {
            if (Fa == null) {
                Fa = new ImageManager(context, true);
            }
            return Fa;
        }
        if (EZ == null) {
            EZ = new ImageManager(context, false);
        }
        return EZ;
    }

    public static ImageManager create(Context context) {
        return m174a(context, false);
    }

    private void fc() {
        this.mContext.registerComponentCallbacks(new C0165e(this.Fc));
    }

    public void m183a(C0168a c0168a) {
        gx.ay("ImageManager.loadImage() must be called in the main thread");
        new C0164d(this, c0168a).run();
    }

    public void loadImage(ImageView imageView, int resId) {
        m183a(new C0612b(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        m183a(new C0612b(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0168a c0612b = new C0612b(imageView, uri);
        c0612b.aj(defaultResId);
        m183a(c0612b);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        m183a(new C0613c(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0168a c0613c = new C0613c(listener, uri);
        c0613c.aj(defaultResId);
        m183a(c0613c);
    }
}
