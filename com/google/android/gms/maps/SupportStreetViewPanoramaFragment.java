package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0250a;
import com.google.android.gms.dynamic.C0253f;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.C0403t;
import com.google.android.gms.maps.internal.C0404u;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportStreetViewPanoramaFragment extends Fragment {
    private StreetViewPanorama ZT;
    private final C0818b aah = new C0818b(this);

    static class C0817a implements LifecycleDelegate {
        private final Fragment FV;
        private final IStreetViewPanoramaFragmentDelegate ZU;

        public C0817a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.ZU = (IStreetViewPanoramaFragmentDelegate) hm.m1232f(iStreetViewPanoramaFragmentDelegate);
            this.FV = (Fragment) hm.m1232f(fragment);
        }

        public IStreetViewPanoramaFragmentDelegate jC() {
            return this.ZU;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.FV.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                C0403t.m1504a(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.ZU.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C1030e.m3259e(this.ZU.onCreateView(C1030e.m3260h(inflater), C1030e.m3260h(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.ZU.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.ZU.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.ZU.onInflate(C1030e.m3260h(activity), null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.ZU.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.ZU.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.ZU.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.ZU.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    static class C0818b extends C0250a<C0817a> {
        private final Fragment FV;
        protected C0253f<C0817a> ZF;
        private Activity og;

        C0818b(Fragment fragment) {
            this.FV = fragment;
        }

        private void setActivity(Activity activity) {
            this.og = activity;
            jz();
        }

        protected void mo1945a(C0253f<C0817a> c0253f) {
            this.ZF = c0253f;
            jz();
        }

        public void jz() {
            if (this.og != null && this.ZF != null && gH() == null) {
                try {
                    MapsInitializer.initialize(this.og);
                    this.ZF.mo1073a(new C0817a(this.FV, C0404u.m1505H(this.og).mo2094j(C1030e.m3260h(this.og))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate jC = jC();
        if (jC == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = jC.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.ZT == null || this.ZT.jB().asBinder() != streetViewPanorama.asBinder()) {
                this.ZT = new StreetViewPanorama(streetViewPanorama);
            }
            return this.ZT;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    protected IStreetViewPanoramaFragmentDelegate jC() {
        this.aah.jz();
        return this.aah.gH() == null ? null : ((C0817a) this.aah.gH()).jC();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aah.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.aah.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.aah.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.aah.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.aah.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.aah.setActivity(activity);
        this.aah.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.aah.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.aah.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.aah.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.aah.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
