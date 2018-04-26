package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class C0250a<T extends LifecycleDelegate> {
    private T LX;
    private Bundle LY;
    private LinkedList<C0249a> LZ;
    private final C0253f<T> Ma = new C06521(this);

    private interface C0249a {
        void mo1074b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    class C06521 implements C0253f<T> {
        final /* synthetic */ C0250a Mb;

        C06521(C0250a c0250a) {
            this.Mb = c0250a;
        }

        public void mo1073a(T t) {
            this.Mb.LX = t;
            Iterator it = this.Mb.LZ.iterator();
            while (it.hasNext()) {
                ((C0249a) it.next()).mo1074b(this.Mb.LX);
            }
            this.Mb.LZ.clear();
            this.Mb.LY = null;
        }
    }

    class C06566 implements C0249a {
        final /* synthetic */ C0250a Mb;

        C06566(C0250a c0250a) {
            this.Mb = c0250a;
        }

        public void mo1074b(LifecycleDelegate lifecycleDelegate) {
            this.Mb.LX.onStart();
        }

        public int getState() {
            return 4;
        }
    }

    class C06577 implements C0249a {
        final /* synthetic */ C0250a Mb;

        C06577(C0250a c0250a) {
            this.Mb = c0250a;
        }

        public void mo1074b(LifecycleDelegate lifecycleDelegate) {
            this.Mb.LX.onResume();
        }

        public int getState() {
            return 5;
        }
    }

    private void m461a(Bundle bundle, C0249a c0249a) {
        if (this.LX != null) {
            c0249a.mo1074b(this.LX);
            return;
        }
        if (this.LZ == null) {
            this.LZ = new LinkedList();
        }
        this.LZ.add(c0249a);
        if (bundle != null) {
            if (this.LY == null) {
                this.LY = (Bundle) bundle.clone();
            } else {
                this.LY.putAll(bundle);
            }
        }
        mo1945a(this.Ma);
    }

    public static void m463b(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence d = GooglePlayServicesUtil.m138d(context, isGooglePlayServicesAvailable);
        CharSequence e = GooglePlayServicesUtil.m139e(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(d);
        linearLayout.addView(textView);
        if (e != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(e);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.m136c(context, isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void ca(int i) {
        while (!this.LZ.isEmpty() && ((C0249a) this.LZ.getLast()).getState() >= i) {
            this.LZ.removeLast();
        }
    }

    protected void mo2362a(FrameLayout frameLayout) {
        C0250a.m463b(frameLayout);
    }

    protected abstract void mo1945a(C0253f<T> c0253f);

    public T gH() {
        return this.LX;
    }

    public void onCreate(final Bundle savedInstanceState) {
        m461a(savedInstanceState, new C0249a(this) {
            final /* synthetic */ C0250a Mb;

            public void mo1074b(LifecycleDelegate lifecycleDelegate) {
                this.Mb.LX.onCreate(savedInstanceState);
            }

            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        m461a(savedInstanceState, new C0249a(this) {
            final /* synthetic */ C0250a Mb;

            public void mo1074b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.Mb.LX.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.LX == null) {
            mo2362a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.LX != null) {
            this.LX.onDestroy();
        } else {
            ca(1);
        }
    }

    public void onDestroyView() {
        if (this.LX != null) {
            this.LX.onDestroyView();
        } else {
            ca(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        m461a(savedInstanceState, new C0249a(this) {
            final /* synthetic */ C0250a Mb;

            public void mo1074b(LifecycleDelegate lifecycleDelegate) {
                this.Mb.LX.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.LX != null) {
            this.LX.onLowMemory();
        }
    }

    public void onPause() {
        if (this.LX != null) {
            this.LX.onPause();
        } else {
            ca(5);
        }
    }

    public void onResume() {
        m461a(null, new C06577(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.LX != null) {
            this.LX.onSaveInstanceState(outState);
        } else if (this.LY != null) {
            outState.putAll(this.LY);
        }
    }

    public void onStart() {
        m461a(null, new C06566(this));
    }

    public void onStop() {
        if (this.LX != null) {
            this.LX.onStop();
        } else {
            ca(4);
        }
    }
}
