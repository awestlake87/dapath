package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer.C0441b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager aig;
    private final DataLayer aeu;
    private final C0484r agO;
    private final C0446a aie;
    private final ConcurrentMap<C1140n, Boolean> aif;
    private final Context mContext;

    interface C0446a {
        C1141o mo2292a(Context context, TagManager tagManager, Looper looper, String str, int i, C0484r c0484r);
    }

    class C09211 implements C0441b {
        final /* synthetic */ TagManager aih;

        C09211(TagManager tagManager) {
            this.aih = tagManager;
        }

        public void mo2291x(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.aih.cl(obj.toString());
            }
        }
    }

    static class C09222 implements C0446a {
        C09222() {
        }

        public C1141o mo2292a(Context context, TagManager tagManager, Looper looper, String str, int i, C0484r c0484r) {
            return new C1141o(context, tagManager, looper, str, i, c0484r);
        }
    }

    TagManager(Context context, C0446a containerHolderLoaderProvider, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.aie = containerHolderLoaderProvider;
        this.aif = new ConcurrentHashMap();
        this.aeu = dataLayer;
        this.aeu.m1606a(new C09211(this));
        this.aeu.m1606a(new C0935d(this.mContext));
        this.agO = new C0484r();
    }

    private void cl(String str) {
        for (C1140n bH : this.aif.keySet()) {
            bH.bH(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (aig == null) {
                if (context == null) {
                    bh.m1642A("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                aig = new TagManager(context, new C09222(), new DataLayer(new C0954v(context)));
            }
            tagManager = aig;
        }
        return tagManager;
    }

    void m1614a(C1140n c1140n) {
        this.aif.put(c1140n, Boolean.valueOf(true));
    }

    boolean m1615b(C1140n c1140n) {
        return this.aif.remove(c1140n) != null;
    }

    public DataLayer getDataLayer() {
        return this.aeu;
    }

    synchronized boolean m1616i(Uri uri) {
        boolean z;
        cd md = cd.md();
        if (md.m1661i(uri)) {
            String containerId = md.getContainerId();
            switch (md.me()) {
                case NONE:
                    for (C1140n c1140n : this.aif.keySet()) {
                        if (c1140n.getContainerId().equals(containerId)) {
                            c1140n.bJ(null);
                            c1140n.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (C1140n c1140n2 : this.aif.keySet()) {
                        if (c1140n2.getContainerId().equals(containerId)) {
                            c1140n2.bJ(md.mf());
                            c1140n2.refresh();
                        } else if (c1140n2.lo() != null) {
                            c1140n2.bJ(null);
                            c1140n2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.mo2292a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.lr();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.mo2292a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.lr();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.mo2292a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.lt();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.mo2292a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.lt();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.mo2292a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.ls();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.mo2292a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.ls();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
