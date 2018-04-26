package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.C0251c.C0659a;

public final class C1029b extends C0659a {
    private Fragment Mj;

    private C1029b(Fragment fragment) {
        this.Mj = fragment;
    }

    public static C1029b m3256a(Fragment fragment) {
        return fragment != null ? new C1029b(fragment) : null;
    }

    public void mo1076c(C0252d c0252d) {
        this.Mj.registerForContextMenu((View) C1030e.m3259e(c0252d));
    }

    public void mo1077d(C0252d c0252d) {
        this.Mj.unregisterForContextMenu((View) C1030e.m3259e(c0252d));
    }

    public C0252d gI() {
        return C1030e.m3260h(this.Mj.getActivity());
    }

    public C0251c gJ() {
        return C1029b.m3256a(this.Mj.getParentFragment());
    }

    public C0252d gK() {
        return C1030e.m3260h(this.Mj.getResources());
    }

    public C0251c gL() {
        return C1029b.m3256a(this.Mj.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.Mj.getArguments();
    }

    public int getId() {
        return this.Mj.getId();
    }

    public boolean getRetainInstance() {
        return this.Mj.getRetainInstance();
    }

    public String getTag() {
        return this.Mj.getTag();
    }

    public int getTargetRequestCode() {
        return this.Mj.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Mj.getUserVisibleHint();
    }

    public C0252d getView() {
        return C1030e.m3260h(this.Mj.getView());
    }

    public boolean isAdded() {
        return this.Mj.isAdded();
    }

    public boolean isDetached() {
        return this.Mj.isDetached();
    }

    public boolean isHidden() {
        return this.Mj.isHidden();
    }

    public boolean isInLayout() {
        return this.Mj.isInLayout();
    }

    public boolean isRemoving() {
        return this.Mj.isRemoving();
    }

    public boolean isResumed() {
        return this.Mj.isResumed();
    }

    public boolean isVisible() {
        return this.Mj.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.Mj.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.Mj.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.Mj.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.Mj.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.Mj.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.Mj.startActivityForResult(intent, requestCode);
    }
}
