package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0252d.C0661a;
import java.lang.reflect.Field;

public final class C1030e<T> extends C0661a {
    private final T Mk;

    private C1030e(T t) {
        this.Mk = t;
    }

    public static <T> T m3259e(C0252d c0252d) {
        if (c0252d instanceof C1030e) {
            return ((C1030e) c0252d).Mk;
        }
        IBinder asBinder = c0252d.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    public static <T> C0252d m3260h(T t) {
        return new C1030e(t);
    }
}
