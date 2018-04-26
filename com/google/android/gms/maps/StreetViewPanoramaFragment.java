package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
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

public class StreetViewPanoramaFragment extends Fragment {
    private final C0812b ZS = new C0812b(this);
    private StreetViewPanorama ZT;

    static class C0811a implements LifecycleDelegate {
        private final Fragment Mj;
        private final IStreetViewPanoramaFragmentDelegate ZU;

        public C0811a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.ZU = (IStreetViewPanoramaFragmentDelegate) hm.m1232f(iStreetViewPanoramaFragmentDelegate);
            this.Mj = (Fragment) hm.m1232f(fragment);
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
            Bundle arguments = this.Mj.getArguments();
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

    static class C0812b extends C0250a<C0811a> {
        private final Fragment Mj;
        protected C0253f<C0811a> ZF;
        private Activity og;

        C0812b(Fragment fragment) {
            this.Mj = fragment;
        }

        private void setActivity(Activity activity) {
            this.og = activity;
            jz();
        }

        protected void mo1945a(C0253f<C0811a> c0253f) {
            this.ZF = c0253f;
            jz();
        }

        public void jz() {
            if (this.og != null && this.ZF != null && gH() == null) {
                try {
                    MapsInitializer.initialize(this.og);
                    this.ZF.mo1073a(new C0811a(this.Mj, C0404u.m1505H(this.og).mo2094j(C1030e.m3260h(this.og))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
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
        this.ZS.jz();
        return this.ZS.gH() == null ? null : ((C0811a) this.ZS.gH()).jC();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ZS.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.ZS.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.ZS.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.ZS.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.ZS.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.ZS.setActivity(activity);
        this.ZS.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.ZS.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.ZS.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.ZS.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.ZS.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
