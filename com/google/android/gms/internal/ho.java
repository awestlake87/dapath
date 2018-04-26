package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0100R;

public final class ho extends Button {
    public ho(Context context) {
        this(context, null);
    }

    public ho(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private int m1233b(int i, int i2, int i3) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void m1234b(Resources resources, int i, int i2) {
        int b;
        switch (i) {
            case 0:
            case 1:
                b = m1233b(i2, C0100R.drawable.common_signin_btn_text_dark, C0100R.drawable.common_signin_btn_text_light);
                break;
            case 2:
                b = m1233b(i2, C0100R.drawable.common_signin_btn_icon_dark, C0100R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (b == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(b));
    }

    private void m1235c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void m1236c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m1233b(i2, C0100R.color.common_signin_btn_text_dark, C0100R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(C0100R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(C0100R.string.common_signin_button_text_long));
                return;
            case 2:
                setText(null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    public void m1237a(Resources resources, int i, int i2) {
        boolean z = i >= 0 && i < 3;
        hm.m1227a(z, "Unknown button size %d", Integer.valueOf(i));
        z = i2 >= 0 && i2 < 2;
        hm.m1227a(z, "Unknown color scheme %s", Integer.valueOf(i2));
        m1235c(resources);
        m1234b(resources, i, i2);
        m1236c(resources, i, i2);
    }
}
