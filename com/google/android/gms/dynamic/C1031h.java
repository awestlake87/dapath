package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.C0251c.C0659a;

public final class C1031h extends C0659a {
    private Fragment FV;

    private C1031h(Fragment fragment) {
        this.FV = fragment;
    }

    public static C1031h m3261a(Fragment fragment) {
        return fragment != null ? new C1031h(fragment) : null;
    }

    public void mo1076c(C0252d c0252d) {
        this.FV.registerForContextMenu((View) C1030e.m3259e(c0252d));
    }

    public void mo1077d(C0252d c0252d) {
        this.FV.unregisterForContextMenu((View) C1030e.m3259e(c0252d));
    }

    public C0252d gI() {
        return C1030e.m3260h(this.FV.getActivity());
    }

    public C0251c gJ() {
        return C1031h.m3261a(this.FV.getParentFragment());
    }

    public C0252d gK() {
        return C1030e.m3260h(this.FV.getResources());
    }

    public C0251c gL() {
        return C1031h.m3261a(this.FV.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.FV.getArguments();
    }

    public int getId() {
        return this.FV.getId();
    }

    public boolean getRetainInstance() {
        return this.FV.getRetainInstance();
    }

    public String getTag() {
        return this.FV.getTag();
    }

    public int getTargetRequestCode() {
        return this.FV.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.FV.getUserVisibleHint();
    }

    public C0252d getView() {
        return C1030e.m3260h(this.FV.getView());
    }

    public boolean isAdded() {
        return this.FV.isAdded();
    }

    public boolean isDetached() {
        return this.FV.isDetached();
    }

    public boolean isHidden() {
        return this.FV.isHidden();
    }

    public boolean isInLayout() {
        return this.FV.isInLayout();
    }

    public boolean isRemoving() {
        return this.FV.isRemoving();
    }

    public boolean isResumed() {
        return this.FV.isResumed();
    }

    public boolean isVisible() {
        return this.FV.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.FV.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.FV.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.FV.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.FV.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.FV.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.FV.startActivityForResult(intent, requestCode);
    }
}
