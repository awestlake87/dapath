package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.C0100R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle implements SafeParcelable {
    public static final Creator<WalletFragmentStyle> CREATOR = new C0509c();
    Bundle akE;
    int akF;
    final int xM;

    public WalletFragmentStyle() {
        this.xM = 1;
        this.akE = new Bundle();
    }

    WalletFragmentStyle(int versionCode, Bundle attributes, int styleResourceId) {
        this.xM = versionCode;
        this.akE = attributes;
        this.akF = styleResourceId;
    }

    private void m3116a(TypedArray typedArray, int i, String str) {
        if (!this.akE.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.akE.putLong(str, Dimension.m1757a(peekValue));
            }
        }
    }

    private void m3117a(TypedArray typedArray, int i, String str, String str2) {
        if (!this.akE.containsKey(str) && !this.akE.containsKey(str2)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue == null) {
                return;
            }
            if (peekValue.type < 28 || peekValue.type > 31) {
                this.akE.putInt(str2, peekValue.resourceId);
            } else {
                this.akE.putInt(str, peekValue.data);
            }
        }
    }

    private void m3118b(TypedArray typedArray, int i, String str) {
        if (!this.akE.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.akE.putInt(str, peekValue.data);
            }
        }
    }

    public void m3119Q(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.akF <= 0 ? C0100R.style.WalletFragmentDefaultStyle : this.akF, C0100R.styleable.WalletFragmentStyle);
        m3116a(obtainStyledAttributes, 1, "buyButtonWidth");
        m3116a(obtainStyledAttributes, 0, "buyButtonHeight");
        m3118b(obtainStyledAttributes, 2, "buyButtonText");
        m3118b(obtainStyledAttributes, 3, "buyButtonAppearance");
        m3118b(obtainStyledAttributes, 4, "maskedWalletDetailsTextAppearance");
        m3118b(obtainStyledAttributes, 5, "maskedWalletDetailsHeaderTextAppearance");
        m3117a(obtainStyledAttributes, 6, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        m3118b(obtainStyledAttributes, 7, "maskedWalletDetailsButtonTextAppearance");
        m3117a(obtainStyledAttributes, 8, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        m3118b(obtainStyledAttributes, 9, "maskedWalletDetailsLogoTextColor");
        m3118b(obtainStyledAttributes, 10, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }

    public int m3120a(String str, DisplayMetrics displayMetrics, int i) {
        return this.akE.containsKey(str) ? Dimension.m1755a(this.akE.getLong(str), displayMetrics) : i;
    }

    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int buyButtonAppearance) {
        this.akE.putInt("buyButtonAppearance", buyButtonAppearance);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int height) {
        this.akE.putLong("buyButtonHeight", Dimension.dM(height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int unit, float height) {
        this.akE.putLong("buyButtonHeight", Dimension.m1756a(unit, height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int buyButtonText) {
        this.akE.putInt("buyButtonText", buyButtonText);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int width) {
        this.akE.putLong("buyButtonWidth", Dimension.dM(width));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int unit, float width) {
        this.akE.putLong("buyButtonWidth", Dimension.m1756a(unit, width));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int color) {
        this.akE.remove("maskedWalletDetailsBackgroundResource");
        this.akE.putInt("maskedWalletDetailsBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int resourceId) {
        this.akE.remove("maskedWalletDetailsBackgroundColor");
        this.akE.putInt("maskedWalletDetailsBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int color) {
        this.akE.remove("maskedWalletDetailsButtonBackgroundResource");
        this.akE.putInt("maskedWalletDetailsButtonBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int resourceId) {
        this.akE.remove("maskedWalletDetailsButtonBackgroundColor");
        this.akE.putInt("maskedWalletDetailsButtonBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int resourceId) {
        this.akE.putInt("maskedWalletDetailsButtonTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int resourceId) {
        this.akE.putInt("maskedWalletDetailsHeaderTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int imageType) {
        this.akE.putInt("maskedWalletDetailsLogoImageType", imageType);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int color) {
        this.akE.putInt("maskedWalletDetailsLogoTextColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int resourceId) {
        this.akE.putInt("maskedWalletDetailsTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int id) {
        this.akF = id;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0509c.m1777a(this, dest, flags);
    }
}
