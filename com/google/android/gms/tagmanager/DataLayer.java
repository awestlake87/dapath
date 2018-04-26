package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] aeY = "gtm.lifetime".toString().split("\\.");
    private static final Pattern aeZ = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<C0441b, Integer> afa;
    private final Map<String, Object> afb;
    private final ReentrantLock afc;
    private final LinkedList<Map<String, Object>> afd;
    private final C0443c afe;
    private final CountDownLatch aff;

    static final class C0440a {
        public final String JL;
        public final Object afh;

        C0440a(String str, Object obj) {
            this.JL = str;
            this.afh = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof C0440a)) {
                return false;
            }
            C0440a c0440a = (C0440a) o;
            return this.JL.equals(c0440a.JL) && this.afh.equals(c0440a.afh);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.JL.hashCode()), Integer.valueOf(this.afh.hashCode())});
        }

        public String toString() {
            return "Key: " + this.JL + " value: " + this.afh.toString();
        }
    }

    interface C0441b {
        void mo2291x(Map<String, Object> map);
    }

    interface C0443c {

        public interface C0442a {
            void mo2290d(List<C0440a> list);
        }

        void mo2287a(C0442a c0442a);

        void mo2288a(List<C0440a> list, long j);

        void bP(String str);
    }

    class C09191 implements C0443c {
        C09191() {
        }

        public void mo2287a(C0442a c0442a) {
            c0442a.mo2290d(new ArrayList());
        }

        public void mo2288a(List<C0440a> list, long j) {
        }

        public void bP(String str) {
        }
    }

    class C09202 implements C0442a {
        final /* synthetic */ DataLayer afg;

        C09202(DataLayer dataLayer) {
            this.afg = dataLayer;
        }

        public void mo2290d(List<C0440a> list) {
            for (C0440a c0440a : list) {
                this.afg.m1605z(this.afg.m1609c(c0440a.JL, c0440a.afh));
            }
            this.afg.aff.countDown();
        }
    }

    DataLayer() {
        this(new C09191());
    }

    DataLayer(C0443c persistentStore) {
        this.afe = persistentStore;
        this.afa = new ConcurrentHashMap();
        this.afb = new HashMap();
        this.afc = new ReentrantLock();
        this.afd = new LinkedList();
        this.aff = new CountDownLatch(1);
        ly();
    }

    private void m1596A(Map<String, Object> map) {
        Long B = m1597B(map);
        if (B != null) {
            List D = m1599D(map);
            D.remove("gtm.lifetime");
            this.afe.mo2288a(D, B.longValue());
        }
    }

    private Long m1597B(Map<String, Object> map) {
        Object C = m1598C(map);
        return C == null ? null : bO(C.toString());
    }

    private Object m1598C(Map<String, Object> map) {
        String[] strArr = aeY;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<C0440a> m1599D(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        m1604a(map, "", arrayList);
        return arrayList;
    }

    private void m1600E(Map<String, Object> map) {
        synchronized (this.afb) {
            for (String str : map.keySet()) {
                m1608a(m1609c(str, map.get(str)), this.afb);
            }
        }
        m1601F(map);
    }

    private void m1601F(Map<String, Object> map) {
        for (C0441b x : this.afa.keySet()) {
            x.mo2291x(map);
        }
    }

    private void m1604a(Map<String, Object> map, String str, Collection<C0440a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                m1604a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C0440a(str2, entry.getValue()));
            }
        }
    }

    static Long bO(String str) {
        Matcher matcher = aeZ.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                bh.m1645D("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                bh.m1643B("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    bh.m1645D("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        bh.m1643B("unknown _lifetime: " + str);
        return null;
    }

    public static List<Object> listOf(Object... objects) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void ly() {
        this.afe.mo2287a(new C09202(this));
    }

    private void lz() {
        int i = 0;
        while (true) {
            Map map = (Map) this.afd.poll();
            if (map != null) {
                m1600E(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    this.afd.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objects.length) {
            if (objects[i] instanceof String) {
                hashMap.put((String) objects[i], objects[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objects[i]);
            }
        }
        return hashMap;
    }

    private void m1605z(Map<String, Object> map) {
        this.afc.lock();
        try {
            this.afd.offer(map);
            if (this.afc.getHoldCount() == 1) {
                lz();
            }
            m1596A(map);
        } finally {
            this.afc.unlock();
        }
    }

    void m1606a(C0441b c0441b) {
        this.afa.put(c0441b, Integer.valueOf(0));
    }

    void m1607a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m1607a((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m1608a((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    void m1608a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m1607a((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m1608a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void bN(String str) {
        push(str, null);
        this.afe.bP(str);
    }

    Map<String, Object> m1609c(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    public Object get(String key) {
        synchronized (this.afb) {
            Map map = this.afb;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(m1609c(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.aff.await();
        } catch (InterruptedException e) {
            bh.m1645D("DataLayer.push: unexpected InterruptedException");
        }
        m1605z(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        Map hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }
}
