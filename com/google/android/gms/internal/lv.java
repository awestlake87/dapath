package com.google.android.gms.internal;

import com.google.android.gms.internal.lw.C1118a;
import com.google.android.gms.internal.lw.C1118a.C1117a;
import com.google.android.gms.internal.lw.C1118a.C1117a.C1116a;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class lv {

    public static class C0363a {
        public final lw amp;
        public final List<Asset> amq;

        public C0363a(lw lwVar, List<Asset> list) {
            this.amp = lwVar;
            this.amq = list;
        }
    }

    private static int m1360a(String str, C1117a[] c1117aArr) {
        int i = 14;
        for (C1117a c1117a : c1117aArr) {
            if (i == 14) {
                if (c1117a.type == 9 || c1117a.type == 2 || c1117a.type == 6) {
                    i = c1117a.type;
                } else if (c1117a.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + c1117a.type + " for key " + str);
                }
            } else if (c1117a.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c1117a.type);
            }
        }
        return i;
    }

    static int m1361a(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static C0363a m1362a(DataMap dataMap) {
        lw lwVar = new lw();
        List arrayList = new ArrayList();
        lwVar.amr = m1367a(dataMap, arrayList);
        return new C0363a(lwVar, arrayList);
    }

    private static C1117a m1363a(List<Asset> list, Object obj) {
        C1117a c1117a = new C1117a();
        if (obj == null) {
            c1117a.type = 14;
            return c1117a;
        }
        c1117a.amv = new C1116a();
        if (obj instanceof String) {
            c1117a.type = 2;
            c1117a.amv.amx = (String) obj;
        } else if (obj instanceof Integer) {
            c1117a.type = 6;
            c1117a.amv.amB = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c1117a.type = 5;
            c1117a.amv.amA = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c1117a.type = 3;
            c1117a.amv.amy = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c1117a.type = 4;
            c1117a.amv.amz = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c1117a.type = 8;
            c1117a.amv.amD = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c1117a.type = 7;
            c1117a.amv.amC = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c1117a.type = 1;
            c1117a.amv.amw = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c1117a.type = 11;
            c1117a.amv.amG = (String[]) obj;
        } else if (obj instanceof long[]) {
            c1117a.type = 12;
            c1117a.amv.amH = (long[]) obj;
        } else if (obj instanceof float[]) {
            c1117a.type = 15;
            c1117a.amv.amI = (float[]) obj;
        } else if (obj instanceof Asset) {
            c1117a.type = 13;
            c1117a.amv.amJ = (long) m1361a((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            c1117a.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            C1118a[] c1118aArr = new C1118a[keySet.size()];
            r1 = 0;
            for (String str : keySet) {
                c1118aArr[r1] = new C1118a();
                c1118aArr[r1].name = str;
                c1118aArr[r1].amt = m1363a((List) list, dataMap.get(str));
                r1++;
            }
            c1117a.amv.amE = c1118aArr;
        } else if (obj instanceof ArrayList) {
            c1117a.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            C1117a[] c1117aArr = new C1117a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                C1117a a = m1363a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i2 == 14 && a.type != 14) {
                        r1 = a.type;
                    } else if (a.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    c1117aArr[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            c1117a.amv.amF = c1117aArr;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return c1117a;
    }

    public static DataMap m1364a(C0363a c0363a) {
        DataMap dataMap = new DataMap();
        for (C1118a c1118a : c0363a.amp.amr) {
            m1366a(c0363a.amq, dataMap, c1118a.name, c1118a.amt);
        }
        return dataMap;
    }

    private static ArrayList m1365a(List<Asset> list, C1116a c1116a, int i) {
        ArrayList arrayList = new ArrayList(c1116a.amF.length);
        for (C1117a c1117a : c1116a.amF) {
            if (c1117a.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (C1118a c1118a : c1117a.amv.amE) {
                    m1366a(list, dataMap, c1118a.name, c1118a.amt);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(c1117a.amv.amx);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(c1117a.amv.amB));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void m1366a(List<Asset> list, DataMap dataMap, String str, C1117a c1117a) {
        int i = c1117a.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        C1116a c1116a = c1117a.amv;
        if (i == 1) {
            dataMap.putByteArray(str, c1116a.amw);
        } else if (i == 11) {
            dataMap.putStringArray(str, c1116a.amG);
        } else if (i == 12) {
            dataMap.putLongArray(str, c1116a.amH);
        } else if (i == 15) {
            dataMap.putFloatArray(str, c1116a.amI);
        } else if (i == 2) {
            dataMap.putString(str, c1116a.amx);
        } else if (i == 3) {
            dataMap.putDouble(str, c1116a.amy);
        } else if (i == 4) {
            dataMap.putFloat(str, c1116a.amz);
        } else if (i == 5) {
            dataMap.putLong(str, c1116a.amA);
        } else if (i == 6) {
            dataMap.putInt(str, c1116a.amB);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) c1116a.amC);
        } else if (i == 8) {
            dataMap.putBoolean(str, c1116a.amD);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) c1116a.amJ));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (C1118a c1118a : c1116a.amE) {
                m1366a(list, dataMap2, c1118a.name, c1118a.amt);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = m1360a(str, c1116a.amF);
            ArrayList a = m1365a(list, c1116a, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, a);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static C1118a[] m1367a(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        C1118a[] c1118aArr = new C1118a[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            c1118aArr[i] = new C1118a();
            c1118aArr[i].name = str;
            c1118aArr[i].amt = m1363a((List) list, obj);
            i++;
        }
        return c1118aArr;
    }
}
