package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0100R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0250a;
import com.google.android.gms.dynamic.C0253f;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.dynamic.C1031h;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.lk;
import com.google.android.gms.internal.ll.C0784a;
import com.google.android.gms.internal.ls;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private final Fragment FV = this;
    private C0960b akg;
    private final C1031h akh = C1031h.m3261a(this);
    private final C0961c aki = new C0961c();
    private C1143a akj = new C1143a(this);
    private WalletFragmentOptions akk;
    private WalletFragmentInitParams akl;
    private MaskedWalletRequest akm;
    private MaskedWallet akn;
    private Boolean ako;
    private boolean mCreated = false;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    private static class C0960b implements LifecycleDelegate {
        private final lk akr;

        private C0960b(lk lkVar) {
            this.akr = lkVar;
        }

        private int getState() {
            try {
                return this.akr.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.akr.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.akr.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.akr.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.akr.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.akr.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.akr.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C1030e.m3259e(this.akr.onCreateView(C1030e.m3260h(inflater), C1030e.m3260h(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.akr.mo1873a(C1030e.m3260h(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.akr.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.akr.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.akr.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.akr.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.akr.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class C0961c extends C0250a<C0960b> implements OnClickListener {
        final /* synthetic */ SupportWalletFragment aks;

        private C0961c(SupportWalletFragment supportWalletFragment) {
            this.aks = supportWalletFragment;
        }

        protected void mo2362a(FrameLayout frameLayout) {
            View button = new Button(this.aks.FV.getActivity());
            button.setText(C0100R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.aks.akk != null) {
                WalletFragmentStyle fragmentStyle = this.aks.akk.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.aks.FV.getResources().getDisplayMetrics();
                    i = fragmentStyle.m3120a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.m3120a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void mo1945a(C0253f<C0960b> c0253f) {
            Activity activity = this.aks.FV.getActivity();
            if (this.aks.akg == null && this.aks.mCreated && activity != null) {
                try {
                    this.aks.akg = new C0960b(ls.m2809a(activity, this.aks.akh, this.aks.akk, this.aks.akj));
                    this.aks.akk = null;
                    c0253f.mo1073a(this.aks.akg);
                    if (this.aks.akl != null) {
                        this.aks.akg.initialize(this.aks.akl);
                        this.aks.akl = null;
                    }
                    if (this.aks.akm != null) {
                        this.aks.akg.updateMaskedWalletRequest(this.aks.akm);
                        this.aks.akm = null;
                    }
                    if (this.aks.akn != null) {
                        this.aks.akg.updateMaskedWallet(this.aks.akn);
                        this.aks.akn = null;
                    }
                    if (this.aks.ako != null) {
                        this.aks.akg.setEnabled(this.aks.ako.booleanValue());
                        this.aks.ako = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = this.aks.FV.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    static class C1143a extends C0784a {
        private OnStateChangedListener akp;
        private final SupportWalletFragment akq;

        C1143a(SupportWalletFragment supportWalletFragment) {
            this.akq = supportWalletFragment;
        }

        public void mo1887a(int i, int i2, Bundle bundle) {
            if (this.akp != null) {
                this.akp.onStateChanged(this.akq, i, i2, bundle);
            }
        }

        public void m3853a(OnStateChangedListener onStateChangedListener) {
            this.akp = onStateChangedListener;
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.FV.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.akg != null ? this.akg.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.akg != null) {
            this.akg.initialize(initParams);
            this.akl = null;
        } else if (this.akl == null) {
            this.akl = initParams;
            if (this.akm != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.akn != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.akg != null) {
            this.akg.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.akl != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.akl = walletFragmentInitParams;
            }
            if (this.akm == null) {
                this.akm = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.akn == null) {
                this.akn = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.akk = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.ako = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.FV.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.FV.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.m3115Q(this.FV.getActivity());
                this.akk = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.aki.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.aki.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.akk == null) {
            this.akk = WalletFragmentOptions.m3111a((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.akk);
        this.aki.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.aki.onPause();
    }

    public void onResume() {
        super.onResume();
        this.aki.onResume();
        FragmentManager supportFragmentManager = this.FV.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.FV.getActivity()), this.FV.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.aki.onSaveInstanceState(outState);
        if (this.akl != null) {
            outState.putParcelable("walletFragmentInitParams", this.akl);
            this.akl = null;
        }
        if (this.akm != null) {
            outState.putParcelable("maskedWalletRequest", this.akm);
            this.akm = null;
        }
        if (this.akn != null) {
            outState.putParcelable("maskedWallet", this.akn);
            this.akn = null;
        }
        if (this.akk != null) {
            outState.putParcelable("walletFragmentOptions", this.akk);
            this.akk = null;
        }
        if (this.ako != null) {
            outState.putBoolean("enabled", this.ako.booleanValue());
            this.ako = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.aki.onStart();
    }

    public void onStop() {
        super.onStop();
        this.aki.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.akg != null) {
            this.akg.setEnabled(enabled);
            this.ako = null;
            return;
        }
        this.ako = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.akj.m3853a(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.akg != null) {
            this.akg.updateMaskedWallet(maskedWallet);
            this.akn = null;
            return;
        }
        this.akn = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.akg != null) {
            this.akg.updateMaskedWalletRequest(request);
            this.akm = null;
            return;
        }
        this.akm = request;
    }
}
