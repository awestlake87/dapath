package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gw.C0343a;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import java.lang.ref.WeakReference;

public abstract class C0168a {
    final C0167a Fm;
    protected int Fn = 0;
    protected int Fo = 0;
    private boolean Fp = true;
    private boolean Fq = false;
    protected int Fr;

    static final class C0167a {
        public final Uri uri;

        public C0167a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0167a) {
                return this == obj ? true : hk.equal(((C0167a) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return hk.hashCode(this.uri);
        }
    }

    public static final class C0612b extends C0168a {
        private WeakReference<ImageView> Fs;

        public C0612b(ImageView imageView, int i) {
            super(null, i);
            gx.m1160c(imageView);
            this.Fs = new WeakReference(imageView);
        }

        public C0612b(ImageView imageView, Uri uri) {
            super(uri, 0);
            gx.m1160c(imageView);
            this.Fs = new WeakReference(imageView);
        }

        private void m2024a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof gv)) {
                int fi = ((gv) imageView).fi();
                if (this.Fo != 0 && fi == this.Fo) {
                    return;
                }
            }
            boolean b = m191b(z, z2);
            Drawable a = b ? m186a(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(a);
            if (imageView instanceof gv) {
                gv gvVar = (gv) imageView;
                gvVar.m1157g(z3 ? this.Fm.uri : null);
                gvVar.al(obj != null ? this.Fo : 0);
            }
            if (b) {
                ((gt) a).startTransition(250);
            }
        }

        protected void mo946a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.Fs.get();
            if (imageView != null) {
                m2024a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0612b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.Fs.get();
            ImageView imageView2 = (ImageView) ((C0612b) obj).Fs.get();
            boolean z = (imageView2 == null || imageView == null || !hk.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class C0613c extends C0168a {
        private WeakReference<OnImageLoadedListener> Ft;

        public C0613c(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            gx.m1160c(onImageLoadedListener);
            this.Ft = new WeakReference(onImageLoadedListener);
        }

        protected void mo946a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ft.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.Fm.uri, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0613c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0613c c0613c = (C0613c) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ft.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) c0613c.Ft.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && hk.equal(onImageLoadedListener2, onImageLoadedListener) && hk.equal(c0613c.Fm, this.Fm);
            return z;
        }

        public int hashCode() {
            return hk.hashCode(this.Fm);
        }
    }

    public C0168a(Uri uri, int i) {
        this.Fm = new C0167a(uri);
        this.Fo = i;
    }

    private Drawable m184a(Context context, gw gwVar, int i) {
        Resources resources = context.getResources();
        if (this.Fr <= 0) {
            return resources.getDrawable(i);
        }
        C0343a c0343a = new C0343a(i, this.Fr);
        Drawable drawable = (Drawable) gwVar.get(c0343a);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.Fr & 1) != 0) {
            drawable = m185a(resources, drawable);
        }
        gwVar.put(c0343a, drawable);
        return drawable;
    }

    protected Drawable m185a(Resources resources, Drawable drawable) {
        return gu.m1155a(resources, drawable);
    }

    protected gt m186a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof gt) {
            drawable = ((gt) drawable).fg();
        }
        return new gt(drawable, drawable2);
    }

    void m187a(Context context, Bitmap bitmap, boolean z) {
        gx.m1160c(bitmap);
        if ((this.Fr & 1) != 0) {
            bitmap = gu.m1153a(bitmap);
        }
        mo946a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void m188a(Context context, gw gwVar) {
        Drawable drawable = null;
        if (this.Fn != 0) {
            drawable = m184a(context, gwVar, this.Fn);
        }
        mo946a(drawable, false, true, false);
    }

    void m189a(Context context, gw gwVar, boolean z) {
        Drawable drawable = null;
        if (this.Fo != 0) {
            drawable = m184a(context, gwVar, this.Fo);
        }
        mo946a(drawable, z, false, false);
    }

    protected abstract void mo946a(Drawable drawable, boolean z, boolean z2, boolean z3);

    public void aj(int i) {
        this.Fo = i;
    }

    protected boolean m191b(boolean z, boolean z2) {
        return this.Fp && !z2 && (!z || this.Fq);
    }
}
